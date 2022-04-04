package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BillService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.billRequests.CreateBillRequest;
import com.etiya.rentACar.business.requests.billRequests.DeleteBillRequest;
import com.etiya.rentACar.business.requests.billRequests.UpdateBillRequest;
import com.etiya.rentACar.business.responses.billResponses.ListBillDto;
import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.OrderedAdditionalServiceDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BillDao;
import com.etiya.rentACar.entities.Bill;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BillManager implements BillService {
    private BillDao billDao;
    private ModelMapperService modelMapperService;
    private RentalService rentalService;

    public BillManager(BillDao billDao, ModelMapperService modelMapperService, RentalService rentalService) {
        this.billDao = billDao;
        this.modelMapperService = modelMapperService;
        this.rentalService = rentalService;

    }

    @Override
    public Result add(CreateBillRequest createBillRequest) {

        int rentalId = createBillRequest.getRentalId();
        RentalDto rentalDto = this.rentalService.getById(rentalId);

        Period day = Period.between(rentalDto.getRentDate(), rentalDto.getReturnDate());
        int daysCount = day.getDays();

        Bill bill = this.modelMapperService.forRequest().map(createBillRequest, Bill.class);
        bill.setRentDate(rentalDto.getRentDate());
        bill.setReturnDate(rentalDto.getReturnDate());
        bill.setTotalPrice(calculateTotalPrice(rentalDto));
        bill.setTotalRentDay(daysCount);
        this.billDao.save(bill);


        return new SuccessResult(BusinessMessages.BillMessages.BILL_ADDED);
    }


    @Override
    public Result update(UpdateBillRequest updateBillRequest) {
        Bill result = this.modelMapperService.forRequest().map(updateBillRequest, Bill.class);
        this.billDao.save(result);

        return new SuccessResult(BusinessMessages.BillMessages.BILL_UPDATED);
    }

    @Override
    public Result delete(DeleteBillRequest deleteBillRequest) {
        int billId = deleteBillRequest.getId();
        this.billDao.deleteById(billId);

        return new SuccessResult(BusinessMessages.BillMessages.BILL_DELETED);
    }

    @Override
    public DataResult<List<ListBillDto>> getAll() {
        List<Bill> bills = this.billDao.findAll();
        List<ListBillDto> response = bills.stream().map(bill -> this.modelMapperService.forDto()
                        .map(bill, ListBillDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListBillDto>>(response);
    }

    @Override
    public DataResult<List<ListBillDto>> getByCustomerId(int customerId) {
        List<Bill> bills = this.billDao.getByCustomerId(customerId);
        List<ListBillDto> response = bills.stream().map(bill -> this.modelMapperService.forDto()
                        .map(bill, ListBillDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListBillDto>>(response);

    }

    @Override
    public DataResult<List<ListBillDto>> findByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
        List<Bill> bills = this.billDao.findByCreateDateBetween(startDate, endDate);
        List<ListBillDto> response = bills.stream().map(bill -> modelMapperService.forDto().map(bill, ListBillDto.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<ListBillDto>>(response);
    }

    private double calculateTotalPrice(RentalDto rentalDto) {
        double totalPrice = 0;
        Period day = Period.between(rentalDto.getRentDate(), rentalDto.getReturnDate());
        int daysCount = day.getDays();
        if (!Objects.equals(rentalDto.getRentCityName(), rentalDto.getReturnCityName())) {
            totalPrice += 750;
        }

        totalPrice += rentalDto.getDailyPrice() * daysCount;

        for (OrderedAdditionalServiceDto additionalservice : rentalDto.getOrderedAdditionalServices()) {
            totalPrice += additionalservice.getAdditionalServiceDailyPrice() * daysCount;
        }

        return totalPrice;

    }


}

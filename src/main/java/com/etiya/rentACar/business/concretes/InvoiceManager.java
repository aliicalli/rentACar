package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.InvoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.InvoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.InvoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.InvoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.OrderedAdditionalServiceDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.InvoiceDao;
import com.etiya.rentACar.entities.Invoice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InvoiceManager implements InvoiceService {
    private InvoiceDao invoiceDao;
    private ModelMapperService modelMapperService;
    private RentalService rentalService;

    public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService, RentalService rentalService) {
        this.invoiceDao = invoiceDao;
        this.modelMapperService = modelMapperService;
        this.rentalService = rentalService;

    }

    @Override
    public DataResult<Invoice> add(CreateInvoiceRequest createInvoiceRequest) {

        int rentalId = createInvoiceRequest.getRentalId();
        RentalDto rentalDto = this.rentalService.getById(rentalId);

        Period day = Period.between(rentalDto.getRentDate(), rentalDto.getReturnDate());
        int daysCount = day.getDays();

        Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setRentDate(rentalDto.getRentDate());
        invoice.setReturnDate(rentalDto.getReturnDate());
       // invoice.setTotalPrice(calculateTotalPrice(rentalDto));
        invoice.setTotalRentDay(daysCount);
        this.invoiceDao.save(invoice);

        return new SuccessDataResult<Invoice>(invoice,BusinessMessages.BillMessages.BILL_ADDED);
    }


    @Override
    public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice result = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
        this.invoiceDao.save(result);

        return new SuccessResult(BusinessMessages.BillMessages.BILL_UPDATED);
    }

    @Override
    public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
        int billId = deleteInvoiceRequest.getId();
        this.invoiceDao.deleteById(billId);

        return new SuccessResult(BusinessMessages.BillMessages.BILL_DELETED);
    }

    @Override
    public DataResult<Invoice> getById(int id) {
        Invoice invoice= this.invoiceDao.getById(id);
        return new SuccessDataResult<Invoice>(invoice);
    }

    @Override
    public DataResult<List<ListInvoiceDto>> getAll() {
        List<Invoice> invoices = this.invoiceDao.findAll();
        List<ListInvoiceDto> response = invoices.stream().map(invoice -> this.modelMapperService.forDto()
                        .map(invoice, ListInvoiceDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListInvoiceDto>>(response);
    }

    @Override
    public DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId) {
        List<Invoice> invoices = this.invoiceDao.getByCustomerId(customerId);
        List<ListInvoiceDto> response = invoices.stream().map(invoice -> this.modelMapperService.forDto()
                        .map(invoice, ListInvoiceDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListInvoiceDto>>(response);

    }

    @Override
    public DataResult<List<ListInvoiceDto>> findByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
        List<Invoice> invoices = this.invoiceDao.findByCreateDateBetween(startDate, endDate);
        List<ListInvoiceDto> response = invoices.stream().map(invoice -> modelMapperService.forDto().map(invoice, ListInvoiceDto.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<ListInvoiceDto>>(response);
    }



}

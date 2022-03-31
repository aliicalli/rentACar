package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.Rental;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class RentalManager implements RentalService {
    private RentalDao rentalDao;
    private ModelMapperService modelMapperService;
    private CarService carService;

    public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarService carService) {
        this.rentalDao = rentalDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public Result add(CreateRentalRequest createRentalRequest) {

        checkIfRentalExists(createRentalRequest);
        Rental result = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        this.rentalDao.save(result);
        updateCarState(createRentalRequest.getCarId(), createRentalRequest.getReturnDate(), createRentalRequest.getRentCity());
        return new SuccessResult("RENTAL_ADD");


    }


    @Override
    public Result update(UpdateRentalRequest updateRentalRequest) {
        Rental result = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
        this.rentalDao.save(result);
        return new SuccessResult("RENTAL_UPDATE");
    }

    @Override
    public Result delete(DeleteRentalRequest deleteRentalRequest) {
        int rentalId = deleteRentalRequest.getId();
        this.rentalDao.deleteById(rentalId);
        return new SuccessResult("RENTAL_DELETED");
    }

    public Result returnRental(ReturnRentalRequest returnRentalRequest) {
        Rental result = this.rentalDao.getById(returnRentalRequest.getId());
        result.setReturnDate(returnRentalRequest.getReturnDate());
        result.setReturnCity(returnRentalRequest.getReturnCity());
        updateCarState(returnRentalRequest.getCarId(), returnRentalRequest.getReturnDate(), returnRentalRequest.getReturnCity());

        this.rentalDao.save(result);
        totalPrice(returnRentalRequest.getCarId(), returnRentalRequest.getId(), returnRentalRequest.getRentCity(), returnRentalRequest.getRentCity());
        return new SuccessResult("RENTAL_RETURNED");
    }


    private void checkIfRentalExists(CreateRentalRequest createRentalRequest) {
        int carId = createRentalRequest.getCarId();
        CarDto result = this.carService.getById(carId);

        if (result.getCarStateName() == CarStates.UnderMaintenance) {
            throw new BusinessException(BusinessMessages.MaintenanceMessages.CAR_UNDERMAINTENANCE);
        } else if (result.getCarStateName() == CarStates.Rented) {
            throw new BusinessException(BusinessMessages.RentalMessages.CAR_RENTED);
        }

    }

    private void updateCarState(int carId, LocalDate returnedDate, int returnCity) {
        CarDto car = carService.getById(carId);
        UpdateCarStateRequest updateCarStateRequest = new UpdateCarStateRequest();
        updateCarStateRequest.setCitiesId(returnCity);
        updateCarStateRequest.setCarId(carId);
        if (returnedDate == null) {
            updateCarStateRequest.setCarStateName(CarStates.Rented);
        } else {
            updateCarStateRequest.setCarStateName(CarStates.Rentable);
        }

        this.carService.updateCarState(updateCarStateRequest);

    }

    private void totalPrice(int carId, int rentalId, int rentCity, int returnCity) {
        Rental result = this.rentalDao.getById(rentalId);
        RentalDto rentalDto = this.modelMapperService.forDto().map(result, RentalDto.class);
        CarDto car = carService.getById(carId);
        double dailyPrice = car.getDailyPrice();
        Period gun = Period.between(result.getRentDate(), result.getReturnDate());
        int gunSayisi = gun.getDays() + 1;
        dailyPrice = dailyPrice * gunSayisi;
        if (rentalDto.getRentCity() != rentalDto.getReturnCity()) {
            dailyPrice = dailyPrice + 750;
        }
        result.setTotalPrice(dailyPrice);
        this.rentalDao.save(result);

    }
}

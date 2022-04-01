package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.OrderedAdditionalService;
import com.etiya.rentACar.entities.Rental;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalManager implements RentalService {
    private RentalDao rentalDao;
    private ModelMapperService modelMapperService;
    private CarService carService;
    private OrderedAdditionalServiceService orderedAdditionalServiceService;

    public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarService carService, OrderedAdditionalServiceService orderedAdditionalServiceService) {
        this.rentalDao = rentalDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
        this.orderedAdditionalServiceService = orderedAdditionalServiceService;
    }

    @Override
    public Result add(CreateRentalRequest createRentalRequest) {
        int carId = createRentalRequest.getCarId();
        checkIfRentalExists(carId);
        Rental result = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        this.rentalDao.save(result);
        // rented
        UpdateCarStateRequest updateCarStateRequest = new UpdateCarStateRequest();
        updateCarStateRequest.setCarId(carId);
        updateCarStateRequest.setCarStateName(CarStates.Rented);
        this.carService.updateCarState(updateCarStateRequest);
        //state güncelleme

        // rental   createRentalRequest.getId()
        // createRentalRequest.getAdditionalServiceId()
       // List<CreateOrderedAdditionalServiceRequest> result1 = this.modelMapperService.forRequest().map(createRentalRequest,CreateOrderedAdditionalServiceRequest.class);
        //CreateOrderedAdditionalServiceRequest deneme = new CreateOrderedAdditionalServiceRequest();
        //[1,2,3]
        int rentalId = result.getId();
        CreateOrderedAdditionalServiceRequest deneme = new CreateOrderedAdditionalServiceRequest();
        deneme.setRentalId(rentalId);

        for (int item : createRentalRequest.getAdditionalServiceId()) {

            deneme.setAdditionalServiceId(item);
            this.orderedAdditionalServiceService.add(deneme);
        }

        //
        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_ADD);
    }

    @Override
    public Result update(UpdateRentalRequest updateRentalRequest) {
        Rental result = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
        this.rentalDao.save(result);
        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_UPDATE);
    }

    @Override
    public Result delete(DeleteRentalRequest deleteRentalRequest) {
        int rentalId = deleteRentalRequest.getId();
        this.rentalDao.deleteById(rentalId);
        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_DELETED);
    }

    public Result returnRental(ReturnRentalRequest returnRentalRequest) {

        //checkIfRentalIdExists(returnRentalRequest.getId());
        Rental result = this.rentalDao.getById(returnRentalRequest.getId());
        UpdateCarStateRequest updateCarStateRequest = new UpdateCarStateRequest();
        updateCarStateRequest.setCarId(returnRentalRequest.getCarId());
        updateCarStateRequest.setCarStateName(CarStates.Available);
        this.carService.updateCarState(updateCarStateRequest);
        this.rentalDao.save(result);
        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_NOT_ID);
    }

    @Override
    public DataResult<List<ListRentalDto>> getAll() {
        List<Rental> results = this.rentalDao.findAll();
        List<ListRentalDto> response = results.stream().map(rental -> modelMapperService.forDto().map(rental,ListRentalDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListRentalDto>>(response);
    }


    private void checkIfRentalExists(int carId) {
        CarDto result = this.carService.getById(carId);
        if (result.getCarStateName() != CarStates.Available) {
            throw new BusinessException(BusinessMessages.RentalMessages.CAR_NOT_AVAILABLE);
        }

    }

    private void checkIfRentalIdExists(int rentalId) {
        if (!this.rentalDao.existsById(rentalId)) {
            throw new BusinessException("Böyle bir id ye ait kayıt yoktur");
        }
    }

}


package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.Maintenance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceManager implements MaintenanceService {

    private MaintenanceDao maintenanceDao;
    private ModelMapperService modelMapperService;
    private CarService carService;

    public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService, CarService carService) {
        this.maintenanceDao = maintenanceDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public Result add(CreateMaintenanceRequest createMaintenanceRequest) {
        checkIfMaintenanceExists(createMaintenanceRequest);
        Maintenance result = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(result);

        updateCarState(createMaintenanceRequest);
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_ADD);
    }

    @Override
    public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        Maintenance result = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(result);
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_UPDATED);
    }

    @Override
    public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {
        int maintenanceId = deleteMaintenanceRequest.getId();
        this.maintenanceDao.deleteById(maintenanceId);
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_DELETED);
    }


    @Override
    public DataResult<List<ListMaintenanceDto>> getAll() {
        List<Maintenance> maintenances = this.maintenanceDao.findAll();
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance -> this.modelMapperService.forDto()
                        .map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListMaintenanceDto>>(response);
    }


    @Override
    public DataResult<List<ListMaintenanceDto>> getAllMaintenanceByCarId(int CarId) {
        List<Maintenance> maintenances = this.maintenanceDao.getByCarId(CarId);
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance -> this.modelMapperService.forDto()
                        .map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListMaintenanceDto>>(response);
    }


    private void checkIfMaintenanceExists(CreateMaintenanceRequest createMaintenanceRequest) {
        CarDto result = this.carService.getById(createMaintenanceRequest.getCarId());
        if (result.getCarStateName() == CarStates.UnderMaintenance) {
            throw new BusinessException(BusinessMessages.MaintenanceMessages.CAR_UNDERMAINTENANCE);
        }

    }

    private void updateCarState(CreateMaintenanceRequest createMaintenanceRequest) {
        CarDto carDto = this.carService.getById(createMaintenanceRequest.getCarId());
        UpdateCarStateRequest updateCarStateRequest = new UpdateCarStateRequest();
        updateCarStateRequest.setCarId(createMaintenanceRequest.getCarId());
        updateCarStateRequest.setCarStateName(CarStates.UnderMaintenance);
        this.carService.updateCarState(updateCarStateRequest);

    }

}

package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.Maintenance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceManager implements MaintenanceService {

    private MaintenanceDao maintenanceDao;
    private ModelMapperService modelMapperService;

    public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService) {
        this.maintenanceDao = maintenanceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateMaintenanceRequest createMaintenanceRequest) {
        checkIfMaintenanceExists(createMaintenanceRequest.getCarId());
        Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(maintenance);

    }

    @Override
    public void updateState(int id,boolean state) {
        Maintenance maintenance = this.maintenanceDao.getById(id);
        maintenance.setState(state);
        this.maintenanceDao.save(maintenance);
    }

    @Override
    public List<ListMaintenanceDto> getAll() {
        List<Maintenance> maintenances = this.maintenanceDao.findAll();
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance -> this.modelMapperService.forDto()
                        .map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return response;
    }


    @Override
    public List<ListMaintenanceDto> getAllMaintenanceByCarId(int CarId) {
        List<Maintenance> maintenances = this.maintenanceDao.getByCarId(CarId);
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance -> this.modelMapperService.forDto()
                        .map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return response;
    }


    private void checkIfMaintenanceExists(int maintenanceCarId) {
        if (this.maintenanceDao.existsMaintenanceByCarId(maintenanceCarId)) {
            checkIfStateByCarId(maintenanceCarId);
        }
    }

    private void checkIfStateByCarId(int CarId) {
        List<Maintenance> maintenances = this.maintenanceDao.getByCarId(CarId);
        for (Maintenance maintenance : maintenances) {
            if (maintenance.getState()) {
                throw new BusinessException("Araç zaten bakımda. Bakımda olan bir aracı tekrar bakıma ekleyemezsiniz");
            }
        }

    }


}

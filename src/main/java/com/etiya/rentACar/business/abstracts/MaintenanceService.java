package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.entities.Maintenance;

import java.util.List;

public interface MaintenanceService {
    void add(CreateMaintenanceRequest createMaintenanceRequest);
    void update(UpdateMaintenanceRequest updateMaintenanceRequest);
    void delete(DeleteMaintenanceRequest deleteMaintenanceRequest);



    List<ListMaintenanceDto> getAll();
    List<ListMaintenanceDto> getAllMaintenanceByCarId(int CarId);


}

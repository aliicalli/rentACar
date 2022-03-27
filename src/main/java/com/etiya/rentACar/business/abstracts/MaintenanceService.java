package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.entities.Maintenance;

import java.util.List;

public interface MaintenanceService {
    void add(CreateMaintenanceRequest createMaintenanceRequest);
    void updateState(int id,boolean state);
    List<ListMaintenanceDto> getAll();
    List<ListMaintenanceDto> getAllMaintenanceByCarId(int CarId);


}

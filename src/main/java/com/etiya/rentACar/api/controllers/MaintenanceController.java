package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintanances")
public class MaintenanceController {


    private MaintenanceService maintenanceService;

    //@Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }


    @PostMapping("/add")
    public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {
        this.maintenanceService.add(createMaintenanceRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest) {
        this.maintenanceService.update(updateMaintenanceRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest) {
        this.maintenanceService.delete(deleteMaintenanceRequest);
    }

    @GetMapping("/getall")
    public List<ListMaintenanceDto> getAll() {
        return this.maintenanceService.getAll();
    }

    @GetMapping("/getByCarId")
    public List<ListMaintenanceDto> getByCarId(@RequestParam("car") int id) {
        return this.maintenanceService.getAllMaintenanceByCarId(id);
    }


}

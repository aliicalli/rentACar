package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
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
    public Result add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {
       return this.maintenanceService.add(createMaintenanceRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest) {
      return   this.maintenanceService.update(updateMaintenanceRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest) {
      return   this.maintenanceService.delete(deleteMaintenanceRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListMaintenanceDto>> getAll() {
        return this.maintenanceService.getAll();
    }

    @GetMapping("/getByCarId")
    public DataResult<List<ListMaintenanceDto>> getByCarId(@RequestParam("car") int id) {
        return this.maintenanceService.getAllMaintenanceByCarId(id);
    }


}

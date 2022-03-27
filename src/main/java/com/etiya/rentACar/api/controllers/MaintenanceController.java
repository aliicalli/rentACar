package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
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
    public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        this.maintenanceService.add(createMaintenanceRequest);
    }

    @GetMapping("/getall")
    public List<ListMaintenanceDto> getAll(){
        return this.maintenanceService.getAll();
    }
    @GetMapping("/getByCarId")
    public List<ListMaintenanceDto> getByCarId(@RequestParam("car") int id ){
        return this.maintenanceService.getAllMaintenanceByCarId(id);
    }

    @PostMapping("/updateState")
    public void updateState(int id,@RequestParam("hazır:false-bakımda:true") boolean state){
        this.maintenanceService.updateState(id,state);
    }

}

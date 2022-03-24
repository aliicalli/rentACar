package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/damages")
public class DamagesController {
    private DamageService damageService;

    public DamagesController(DamageService damageService) {
        this.damageService = damageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateDamageRequest createDamageRequest){
        this.damageService.add(createDamageRequest);
    }


    @GetMapping("/getall")
    public List<ListDamageDto> getAll(){
        return this.damageService.getAll();
    }

    @GetMapping("/getByCarId")
    public List<ListDamageDto> getByCarId(@RequestParam("carId") int id ){
        return this.damageService.getByCarId(id);
    }

    @GetMapping("/getallpaged")
    List<ListDamageDto> getAllPaged(int pageNo, int pageSize){
        return this.damageService.getAllPaged(pageNo,pageSize);
    }
    @GetMapping("/getallsorted")
    List<ListDamageDto> getAllSorted(String option,String properties){
        return this.damageService.getAllSorted(option,properties);

    }

}

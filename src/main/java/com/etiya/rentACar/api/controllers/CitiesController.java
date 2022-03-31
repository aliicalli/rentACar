package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return this.cityService.add(createCityRequest);
    }


    @PutMapping("/update")
    public Result update(@Valid @RequestBody UpdateCityRequest updateCityRequest) {
        return this.cityService.update(updateCityRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCityRequest deleteCityRequest) {
        return this.cityService.delete(deleteCityRequest);
    }
}

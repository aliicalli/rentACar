package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarControllers {
    private CarService carService;

    public CarControllers(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCarRequest createCarRequest) {
        carService.add(createCarRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCarRequest deleteCarRequest) {
        this.carService.delete(deleteCarRequest);
    }

    @GetMapping("/getall")
    public List<ListCarDto> getAll() {
        return this.carService.getAll();
    }

    @GetMapping("/getallModelYear")
    public List<ListCarDto> getlAllByModelYear(@RequestParam("modelYear") double modelYear) {
        return this.carService.getAllByModelYear(modelYear);
    }

    @GetMapping("/getallpaged")
    List<ListCarDto> getAllPaged(int pageNo, int pageSize) {
        return this.carService.getAllPaged(pageNo, pageSize);
    }

    @GetMapping("/getallsorted")
    List<ListCarDto> getAllSorted() {
        return this.carService.getAllSorted();

    }

}
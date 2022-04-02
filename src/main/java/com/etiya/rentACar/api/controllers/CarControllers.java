package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarControllers {
    private CarService carService;

    public CarControllers(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCarRequest updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) {
        return this.carService.delete(deleteCarRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListCarDto>> getAll() {
        return this.carService.getAll();
    }

    @GetMapping("/getallModelYear")
    public DataResult<List<ListCarDto>> getlAllByModelYear(@RequestParam("modelYear") double modelYear) {
        return this.carService.getAllByModelYear(modelYear);
    }

    @GetMapping("/getallpaged")
    public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize) {
        return this.carService.getAllPaged(pageNo, pageSize);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<ListCarDto>> getAllSorted() {
        return this.carService.getAllSorted();

    }

}
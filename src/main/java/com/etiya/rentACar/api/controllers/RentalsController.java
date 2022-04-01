package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
    private RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
        return this.rentalService.add(createRentalRequest);
    }


    @PutMapping("/update")
    public Result update(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
        return this.rentalService.update(updateRentalRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteRentalRequest deleteRentalRequest) {
        return this.rentalService.delete(deleteRentalRequest);
    }

    @PostMapping("/returnRental")
    public Result returnRental(@RequestBody ReturnRentalRequest returnRentalRequest) {
        return this.rentalService.returnRental(returnRentalRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListRentalDto>> getAll() {
        return this.rentalService.getAll();
    }

}

package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.BillService;
import com.etiya.rentACar.business.requests.billRequests.CreateBillRequest;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bills")
public class BillsController {
    private BillService billService;

    public BillsController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateBillRequest createBillRequest){
        return this.billService.add(createBillRequest);
    }

}

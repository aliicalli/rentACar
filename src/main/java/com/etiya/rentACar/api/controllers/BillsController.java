package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.BillService;
import com.etiya.rentACar.business.requests.billRequests.CreateBillRequest;
import com.etiya.rentACar.business.requests.billRequests.DeleteBillRequest;
import com.etiya.rentACar.business.requests.billRequests.UpdateBillRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarCityRequest;
import com.etiya.rentACar.business.responses.billResponses.ListBillDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    @PutMapping("/update")
    public Result update(@RequestBody UpdateBillRequest updateBillRequest){
        return this.billService.update(updateBillRequest);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteBillRequest deleteBillRequest){
        return this.billService.delete(deleteBillRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<ListBillDto>> getAll(){
        return this.billService.getAll();
    }

    @GetMapping("/findCreateDate")
    public DataResult<List<ListBillDto>> findCreateDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate ){
        return this.billService.findByCreateDateBetween(startDate,endDate);
    }
    @GetMapping("/getAllCustomerId")
    public DataResult<List<ListBillDto>> getByCustomerId(@RequestParam int customerId){
        return this.billService.getByCustomerId(customerId);
    }
}

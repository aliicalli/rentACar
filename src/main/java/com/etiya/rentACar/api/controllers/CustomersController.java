package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody CreateCustomerRequest createCustomerRequest) {
       return this.customerService.add(createCustomerRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
        return this.customerService.delete(deleteCustomerRequest);
    }

}

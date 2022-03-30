package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CustomerService {
    Result add(CreateCustomerRequest createCustomerRequest);

    Result update(UpdateCustomerRequest updateCustomerRequest);

    Result delete(DeleteCustomerRequest deleteCustomerRequest);
}

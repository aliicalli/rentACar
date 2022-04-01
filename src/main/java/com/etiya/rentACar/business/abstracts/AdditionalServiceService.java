package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.core.utilities.results.Result;

public interface AdditionalServiceService {
    Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
}

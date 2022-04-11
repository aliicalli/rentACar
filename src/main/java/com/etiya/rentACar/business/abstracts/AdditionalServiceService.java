package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface AdditionalServiceService {
    Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);

    Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);

    Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);

     DataResult<AdditionalServiceDto> getById(int id);

    DataResult<List<ListAdditionalServiceDto>> getAll();
}

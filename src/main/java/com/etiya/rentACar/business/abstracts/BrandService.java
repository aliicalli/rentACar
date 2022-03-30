package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface BrandService {
    Result add(CreateBrandRequest createBrandRequest);
    Result update(UpdateBrandRequest updateBrandRequest);
    Result delete(DeleteBrandRequest deleteBrandRequest);

    DataResult<List<ListBrandDto>> getAll();
}

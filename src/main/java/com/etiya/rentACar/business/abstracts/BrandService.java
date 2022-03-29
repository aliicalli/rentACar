package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;

import java.util.List;

public interface BrandService {
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(DeleteBrandRequest deleteBrandRequest);

    List<ListBrandDto> getAll();
}

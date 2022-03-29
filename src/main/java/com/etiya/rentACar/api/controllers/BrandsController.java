package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    //@Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }


    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
        this.brandService.delete(deleteBrandRequest);
    }

    @GetMapping("/getall")
    public List<ListBrandDto> getAll() {
        return this.brandService.getAll();
    }

}

//response-request pattern
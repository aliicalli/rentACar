package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Color;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@Service
public class BrandManager implements BrandService {
    private BrandDao brandDao;
    private ModelMapperService modelMapperService;

    public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
        this.brandDao = brandDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        ExampleMatcher nameMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id").withMatcher("name", ignoreCase());
        Example<Brand> example = Example.of(brand, nameMatcher);
        if (!this.brandDao.exists(example)) {
            this.brandDao.save(brand);
        } else {
            throw new RuntimeException("Aynı isimden mevcut");
        }


//        ExampleMatcher nameMatcher = ExampleMatcher.matching()
//                .withIgnorePaths("id").withMatcher("name", startsWith()).withIgnoreCase();
//        Example<Brand> example = Example.of(brand,nameMatcher);
//       if (!this.brandDao.exists(example)){
//           this.brandDao.save(brand);
//       }else
//       {
//           throw new RuntimeException("Aynı isimden mevcut") ;
//       }
//
//        if (!this.brandDao.existsBrandByName(createBrandRequest.getName())){
//            Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
//            this.brandDao.save(brand);
//            }
//


    }

    @Override
    public List<ListBrandDto> getAll() {
        List<Brand> brands = this.brandDao.findAll();
        List<ListBrandDto> response = brands.stream().map(brand -> this.modelMapperService.forDto()
                .map(brand, ListBrandDto.class)).collect(Collectors.toList());

        return response;
    }


}

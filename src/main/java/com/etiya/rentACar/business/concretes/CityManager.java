package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CityDao;
import com.etiya.rentACar.entities.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;
    private ModelMapperService modelMapperService;

    public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
        this.cityDao = cityDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCityRequest createCityRequest) {
        City city = modelMapperService.forRequest().map(createCityRequest, City.class);
        cityDao.save(city);
        return new SuccessResult(BusinessMessages.CityMessages.CITY_ADD);
    }

    @Override
    public Result delete(DeleteCityRequest deleteCityRequest) {
        int cityId = deleteCityRequest.getId();
        this.cityDao.deleteById(cityId);
        return new SuccessResult(BusinessMessages.CityMessages.CITY_DELETED);
    }

    @Override
    public Result update(UpdateCityRequest updateCityRequest) {
        City result = this.modelMapperService.forRequest().map(updateCityRequest, City.class);
        this.cityDao.save(result);
        return new SuccessResult(BusinessMessages.CityMessages.CITY_UPDATED);
    }

    @Override
    public DataResult<List<ListCityDto>> getAll() {
        List<City> results = this.cityDao.findAll();
        List<ListCityDto> response = results.stream()
                .map(city -> modelMapperService.forDto().map(city, ListCityDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListCityDto>>(response);
    }

}

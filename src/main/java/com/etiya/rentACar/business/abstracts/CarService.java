package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.carRequests.*;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface CarService {
    Result add(CreateCarRequest createCarRequest);
    Result update(UpdateCarRequest updateCarRequest);
    Result delete(DeleteCarRequest deleteCarRequest);

     void updateCarState(UpdateCarStateRequest updateCarStateRequest);
     void updateCarKilometer(UpdateKilometerRequest updateKilometerRequest);
     void updateCarCity(UpdateCarCityRequest updateCarCityRequest);

    CarDto getById(int carId);

    DataResult<List<ListCarDto>> getAll();
    DataResult<List<ListCarDto>> getAllByModelYear(double ModelYear);
    DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize);
    DataResult<List<ListCarDto>>getAllSorted();

}

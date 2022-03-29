package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

import java.util.List;

public interface CarService {
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(DeleteCarRequest deleteCarRequest);

    CarDto getById(int id);

    List<ListCarDto> getAll();
    List<ListCarDto> getAllByModelYear(double ModelYear);
    List<ListCarDto> getAllPaged(int pageNo, int pageSize);
    List<ListCarDto> getAllSorted();

}

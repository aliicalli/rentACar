package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;

import java.util.List;

public interface DamageService {
    void add(CreateDamageRequest createDamageRequest);
    void update(UpdateDamageRequest updateDamageRequest);
    void delete(DeleteDamageRequest deleteDamageRequest);

    DamageDto getById(int id);

    List<ListDamageDto> getAll();
    List<ListDamageDto> getAllByCarId(int carId);
    List<ListDamageDto> getAllPaged(int pageNo, int pageSize);
    List<ListDamageDto> getAllSorted(String option ,String properties);
}

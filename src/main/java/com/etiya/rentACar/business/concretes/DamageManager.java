package com.etiya.rentACar.business.concretes;


import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.DamageDao;
import com.etiya.rentACar.entities.Damage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DamageManager implements DamageService {

    private DamageDao damageDao;
    private ModelMapperService modelMapperService;


    public DamageManager(DamageDao damageDao, ModelMapperService modelMapperService) {
        this.damageDao = damageDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateDamageRequest createDamageRequest) {

        Damage damage = this.modelMapperService.forRequest().map(createDamageRequest, Damage.class);
        this.damageDao.save(damage);

    }

    @Override
    public List<ListDamageDto> getAll() {
        List<Damage> damages = this.damageDao.findAll();
        List<ListDamageDto> response = damages.stream().map(damage -> this.modelMapperService.forDto().map(damage,ListDamageDto.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public List<ListDamageDto> getByCarId(int id) {
        List<Damage> damages = this.damageDao.getByCarId(id);
        List<ListDamageDto> response = damages.stream().map(damage -> this.modelMapperService.forDto()
                .map(damage,ListDamageDto.class))
                .collect(Collectors.toList());
       return response;


//        List<Damage> damages = this.damageDao.findAll();
//        List<ListDamageDto> response = damages.stream()
//                .map(damage -> this.modelMapperService.forDto()
//                .map(damage,ListDamageDto.class))
//                .filter( x -> x.getCarId()== Id )
//                .collect(Collectors.toList());


    }

    @Override
    public List<ListDamageDto> getAllPaged(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        List<Damage> cars = this.damageDao.findAll(pageable).getContent();//content datayı anlatır burada sayfa ile biligilerde olduğu için bunu kullanıyoruz.
        List<ListDamageDto> response = cars.stream().map(car -> this.modelMapperService.forDto()
                .map(car,ListDamageDto.class))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public List<ListDamageDto> getAllSorted(String option,String properties ) {

            Sort sort = Sort.by(Sort.Direction.valueOf(option),properties);
            List<Damage> damages = this.damageDao.findAll(sort);
            List<ListDamageDto> response = damages.stream().map(damage-> this.modelMapperService.forDto()
                    .map(damage,ListDamageDto.class))
                    .collect(Collectors.toList());

        return response;

    }


}

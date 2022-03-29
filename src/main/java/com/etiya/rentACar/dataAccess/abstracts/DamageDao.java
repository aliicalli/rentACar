package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.entities.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageDao  extends JpaRepository<Damage,Integer> {
    List<Damage> getAllByCarId(int carId);
}

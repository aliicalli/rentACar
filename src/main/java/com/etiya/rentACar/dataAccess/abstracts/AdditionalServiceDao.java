package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServiceDao extends JpaRepository<AdditionalService,Integer> {

}

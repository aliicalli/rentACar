package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {
    Boolean existsBrandByNameIgnoreCase(String name);
}

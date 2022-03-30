package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer> {
    List<Rental> getByCarId(int CarId);
}

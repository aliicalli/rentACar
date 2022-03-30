package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    // List<Customer> getById(int CarId);
}

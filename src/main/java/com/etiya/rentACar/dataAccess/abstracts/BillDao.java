package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer> {

}

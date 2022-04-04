package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer> {
    List<Bill> getByCustomerId(int customerId);


    List<Bill> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);
   // List<Bill> findByCreatedAtBetween(Date startDate, Date endDate);
}

package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment,Integer> {
}

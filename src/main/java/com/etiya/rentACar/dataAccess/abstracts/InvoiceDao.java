package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Integer> {
    List<Invoice> getByCustomerId(int customerId);

    List<Invoice> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);

}

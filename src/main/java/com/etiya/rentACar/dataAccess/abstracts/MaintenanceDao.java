package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceDao extends JpaRepository<Maintenance,Integer> {
    Boolean existsMaintenanceByCarId(int MaintenanceCarId);
    List<Maintenance> getByCarId(int CarId);
    Maintenance getById(int id);

}

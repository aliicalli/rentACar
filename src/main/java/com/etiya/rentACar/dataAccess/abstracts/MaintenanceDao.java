package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceDao extends JpaRepository<Maintenance,Integer> {
    Boolean existsMaintenanceByCarId(int MaintenanceCarId);
    List<Maintenance> getByCarId(int CarId);
    Maintenance getById(int id);

}

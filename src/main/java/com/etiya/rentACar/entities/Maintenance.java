package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "dateAdded")
    private LocalDate dateAdded;

    @Column(name = "dateReturned")
    private LocalDate dateReturned;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


}

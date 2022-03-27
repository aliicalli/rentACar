package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dateAdded")
    private String dateAdded;

    @Column(name = "dateReturned")
    private String dateReturned;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


}

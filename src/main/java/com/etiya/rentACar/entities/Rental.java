package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "after_rent_kilometer")
    private double afterRentKilometer;

    @Column(name = "before_rent_kilometer")
    private double beforeRentKilometer;

    @ManyToOne
    @JoinColumn(name = "rent_city_id", referencedColumnName = "id")
    private City rentCityId;

    @ManyToOne
    @JoinColumn(name = "return_city_id", referencedColumnName = "id")
    private City returnCityId;

    @Column(name = "daily_price")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "rental")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "rental")
    private  List<OrderedAdditionalService> orderedAdditionalServices;

    @OneToOne(mappedBy = "rental")
    private Payment payment;


}

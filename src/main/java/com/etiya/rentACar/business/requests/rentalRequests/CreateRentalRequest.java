package com.etiya.rentACar.business.requests.rentalRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    @JsonIgnore
    private int id;

    private LocalDate rentDate;

    @JsonIgnore
    private LocalDate returnDate = null;

    private int customerId;

    private int carId;

    private int rentCity;

    private int returnCity;

    private double totalPrice;

}

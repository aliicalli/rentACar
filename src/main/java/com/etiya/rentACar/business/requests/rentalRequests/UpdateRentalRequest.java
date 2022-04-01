package com.etiya.rentACar.business.requests.rentalRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int customerId;

    private int returnCityId;

    private int rentCityId;

    private int carId;

    private double dailyPrice;


}

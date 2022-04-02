package com.etiya.rentACar.business.requests.rentalRequests;

import com.etiya.rentACar.entities.AdditionalService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    @JsonIgnore
    private int id;
    @NotNull
    private LocalDate rentDate;
    @NotNull
    private LocalDate returnDate;

    private double dailyPrice;

    @NotNull
    private int customerId;
    @NotNull
    private int carId;
    @NotNull
    private int rentCityId;
    @NotNull
    private int returnCityId;

    private List<Integer> additionalServiceId;



}

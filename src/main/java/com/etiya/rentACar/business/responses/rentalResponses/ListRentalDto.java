package com.etiya.rentACar.business.responses.rentalResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalDto {
    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int customerId;

    private int carId;
}

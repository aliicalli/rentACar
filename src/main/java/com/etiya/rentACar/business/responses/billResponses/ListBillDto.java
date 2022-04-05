package com.etiya.rentACar.business.responses.billResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBillDto {

    private int id;
    private String billNumber;

    private LocalDate createDate;

    private double totalPrice;
    private int totalRentDay;
    private String customerFirstName;
    private String customerLastName;

    private LocalDate rentalRentDate;
    private LocalDate rentalReturnDate;


}

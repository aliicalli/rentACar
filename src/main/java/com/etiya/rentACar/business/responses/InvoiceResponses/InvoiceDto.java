package com.etiya.rentACar.business.responses.InvoiceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private int id;
    private String invoiceNumber;
    private LocalDate rentalRentDate;
    private LocalDate createDate;
    private LocalDate rentalReturnDate;
    private double totalPrice;
    private int totalRentDay;
    private String customerFirstName;
    private String customerLastName;
}

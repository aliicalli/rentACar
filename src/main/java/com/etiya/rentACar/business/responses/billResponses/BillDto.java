package com.etiya.rentACar.business.responses.billResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private int id;
    private String billNumber;
    private LocalDate rentDate;
    private LocalDate createDate;
    private LocalDate returnDate;
    private double totalPrice;
    private int totalRentDay;
    private String customerName;
}

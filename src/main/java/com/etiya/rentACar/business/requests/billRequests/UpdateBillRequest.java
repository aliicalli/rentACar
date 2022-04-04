package com.etiya.rentACar.business.requests.billRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillRequest {

    private int id;
    private String billNumber;
    private LocalDate createDate;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int totalRentDay;
    private double totalPrice;
    private int customerId;

}

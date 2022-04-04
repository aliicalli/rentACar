package com.etiya.rentACar.business.requests.billRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillRequest {
    @JsonIgnore
    private int id;
    private String billNumber;
    private LocalDate createDate;
    private double totalPrice;
    private int customerId;
    private int rentalId;


}

package com.etiya.rentACar.business.requests.InvoiceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {
    @JsonIgnore
    private int id;
    private String invoiceNumber;

    private LocalDate createDate;
    @JsonIgnore
    private double totalPrice;

    private int customerId;
    @JsonIgnore
    private int rentalId;


}

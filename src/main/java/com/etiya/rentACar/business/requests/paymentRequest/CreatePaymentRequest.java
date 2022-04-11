package com.etiya.rentACar.business.requests.paymentRequest;

import com.etiya.rentACar.business.requests.InvoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.creditCardRequests.CreateCreditCardRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    @JsonIgnore
    private int id;
    private String paymentNumber;
    private int customerId;
    private CreateCreditCardRequest creditCard;
    private CreateRentalRequest createRentalRequest;
    private CreateInvoiceRequest createInvoiceRequest;
    private List<CreateOrderedAdditionalServiceRequest> createOrderedAdditionalServiceRequest;

}

package com.etiya.rentACar.business.responses.paymentResponses;

import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.OrderedAdditionalServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentDto {

    private String paymentNumber;
    private String rentalCustomerCustomerFirstName;
    private String rentalCustomerCustomerLastName;
    private List<OrderedAdditionalServiceDto> rentalAdditionalServices;
    private String invoiceInvoicesNumber;
    private double totalPrice;

}

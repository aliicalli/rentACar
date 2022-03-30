package com.etiya.rentACar.business.requests.customerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;

}

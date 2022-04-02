package com.etiya.rentACar.business.requests.customerRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @JsonIgnore
    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;


}

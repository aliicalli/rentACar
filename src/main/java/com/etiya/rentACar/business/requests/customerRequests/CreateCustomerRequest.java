package com.etiya.rentACar.business.requests.customerRequests;

import com.etiya.rentACar.entities.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

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

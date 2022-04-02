package com.etiya.rentACar.business.requests.additionalServiceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {
    @JsonIgnore
    private int id;

    private String name;

    private int dailyPrice;
}

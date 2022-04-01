package com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderedAdditionalServiceRequest {
    @JsonIgnore
    private int id;
    private int rentalId;
    private int additionalServiceId;

}

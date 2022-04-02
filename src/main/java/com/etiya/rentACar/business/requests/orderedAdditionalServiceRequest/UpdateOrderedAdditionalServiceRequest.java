package com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderedAdditionalServiceRequest {
    private int id;
    private int rentalId;
    private int additionalServiceId;
}

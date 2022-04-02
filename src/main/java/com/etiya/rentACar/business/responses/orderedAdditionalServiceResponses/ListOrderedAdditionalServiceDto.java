package com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderedAdditionalServiceDto {
    private int id;
    private int rentalId;
    private String  additionalServiceName;
}

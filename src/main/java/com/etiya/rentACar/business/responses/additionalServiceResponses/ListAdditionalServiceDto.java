package com.etiya.rentACar.business.responses.additionalServiceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAdditionalServiceDto {
    private int id;

    private String name;

    private int dailyPrice;
}

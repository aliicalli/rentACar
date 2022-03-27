package com.etiya.rentACar.business.responses.maintenanceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListMaintenanceDto {
    private int id;
    private String dateAdded;
    private String dateReturned;
    private boolean state;
    private int carId;

}

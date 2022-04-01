package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.CarStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int id;

    private double dailyPrice;

    private String description;

    private double modelYear;

    private int cityId;

    private int colorId;

    private int brandId;

    private CarStates carStateName;


}

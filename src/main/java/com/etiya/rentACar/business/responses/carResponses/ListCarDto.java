package com.etiya.rentACar.business.responses.carResponses;

import com.etiya.rentACar.entities.CarStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {
    private int id;
    private double dailyPrice;
    private String description;
    private double modelYear;
    private String cityName;
    private String brandName;
    private String colorName;
    private CarStates carStateName;


}

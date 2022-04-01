package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.CarStates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    @JsonIgnore
    private int id;

    @NotNull
    @Min(1)
    @Max(2000)
    private double dailyPrice;

    @NotNull
    @Length(min = 2,max = 50)
    private String description;

    @NotNull
    @Min(2015)
    private double modelYear;

    private int cityId;

    @NotNull
    private int colorId;

    @NotNull
    private  int brandId;

    @NotNull
    private CarStates carStateName;




}

package com.etiya.rentACar.business.responses.rentalResponses;

import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.entities.AdditionalService;
import com.etiya.rentACar.entities.OrderedAdditionalService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto {
    @JsonIgnore
    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private String carDescription;
    private String customerFirstName;
    private String customerLastName;
    private String rentCityName;
    private String returnCityName;
    private double dailyPrice;
    private List<AdditionalServiceDto> additionalServiceName;


//    private int id;
//    private LocalDate rentDate;
//    private LocalDate returnDate;
//    private int customerId;
//    private int carId;
//    private int rentCityId;
//    private int returnCityId;
//    private double dailyPrice;
//    OrderedAdditionalService orderedAdditionalServicesId;


}

package com.etiya.rentACar.business.responses.rentalResponses;

import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.OrderedAdditionalServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalDto {
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
    private List<OrderedAdditionalServiceDto> orderedAdditionalService;

//    private int id;
//    private LocalDate rentDate;
//    private LocalDate returnDate;
//    private int customerId;
//    private String customerFirstName;
//    private String customerLastName;
//    private int carId;
//    private String carDescription;
//    private int rentCityId;
//    private String rentCityName;
//    private int returnCityId;
//    private String returnCityName;
//    private double dailyPrice;
//    List<OrderedAdditionalService> orderedAdditionalServicesName;

}

package com.etiya.rentACar.business.requests.rentalRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRentalRequest {
    private int id;
    private int carId;
    private int returnCityId;
    private LocalDate returnDate;
    private double afterRentKilometer;

//    private LocalDate rentDate;
//    private LocalDate returnDate;
//    private int customerId;
//    private int rentCityId;


//    private double dailyPrice;
//    private List<Integer> additionalServiceId;

//Todo: zaten kiralanırken rentDate,rentCityId,customerId,CarId,dailyPrice bellidir bu yüzden bunları zaten almama gerek yok sorabilirsin ? aslında şu an için sadece id yeterli olacaktır.

}

package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.CarStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarRequest {
    private int id;

}

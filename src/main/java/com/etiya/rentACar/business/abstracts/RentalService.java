package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.core.utilities.results.Result;

public interface RentalService {
    Result add(CreateRentalRequest createRentalRequest);

    Result update(UpdateRentalRequest updateRentalRequest);

    Result delete(DeleteRentalRequest deleteRentalRequest);

    Result returnRental(ReturnRentalRequest returnRentalRequest);
}
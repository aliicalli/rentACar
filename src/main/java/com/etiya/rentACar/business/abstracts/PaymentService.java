package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.paymentRequest.CreatePaymentRequest;
import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface PaymentService {

    Result add(CreatePaymentRequest createPaymentRequest);

    DataResult<List<ListPaymentDto>> getAll();

}

package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.DeleteOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.UpdateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.ListOrderedAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface OrderedAdditionalServiceService {

    Result add(CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest);
    Result update(UpdateOrderedAdditionalServiceRequest updateOrderedAdditionalServiceRequest);
    Result delete(DeleteOrderedAdditionalServiceRequest deleteOrderedAdditionalServiceRequest);

    DataResult<List<ListOrderedAdditionalServiceDto>> getAll();
}

package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.billRequests.CreateBillRequest;
import com.etiya.rentACar.business.requests.billRequests.DeleteBillRequest;
import com.etiya.rentACar.business.requests.billRequests.UpdateBillRequest;
import com.etiya.rentACar.business.responses.billResponses.ListBillDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.time.LocalDate;
import java.util.List;


public interface BillService {
    Result add(CreateBillRequest createBillRequest);

    Result update(UpdateBillRequest updateBillRequest);

    Result delete(DeleteBillRequest deleteBillRequest);

    DataResult<List<ListBillDto>> getAll();

    DataResult<List<ListBillDto>> getByCustomerId(int customerId);

    DataResult<List<ListBillDto>> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);


}

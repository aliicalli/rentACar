package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.InvoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.InvoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.InvoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.InvoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.Invoice;

import java.time.LocalDate;
import java.util.List;


public interface InvoiceService {
    DataResult<Invoice> add(CreateInvoiceRequest createInvoiceRequest);

    Result update(UpdateInvoiceRequest updateInvoiceRequest);

    Result delete(DeleteInvoiceRequest deleteInvoiceRequest);

    DataResult<Invoice> getById(int id);

    DataResult<List<ListInvoiceDto>> getAll();

    DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId);

    DataResult<List<ListInvoiceDto>> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);


}

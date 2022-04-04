package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BillService;
import com.etiya.rentACar.business.requests.billRequests.CreateBillRequest;
import com.etiya.rentACar.business.requests.billRequests.DeleteBillRequest;
import com.etiya.rentACar.business.requests.billRequests.UpdateBillRequest;
import com.etiya.rentACar.business.responses.billResponses.ListBillDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BillDao;
import com.etiya.rentACar.entities.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillManager implements BillService {
    private BillDao billDao;
    private ModelMapperService modelMapperService;

    public BillManager(BillDao billDao, ModelMapperService modelMapperService) {
        this.billDao = billDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateBillRequest createBillRequest) {
        Bill bill = this.modelMapperService.forRequest().map(createBillRequest, Bill.class);
        this.billDao.save(bill);
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateBillRequest updateBillRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteBillRequest deleteBillRequest) {
        return null;
    }

    @Override
    public DataResult<List<ListBillDto>> getAll() {
        return null;
    }
}

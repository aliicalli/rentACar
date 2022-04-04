package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CustomerDao;
import com.etiya.rentACar.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private ModelMapperService modelMapperService;
    private CarService carService;

    public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService, CarService carService) {
        this.customerDao = customerDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {
        Customer result = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerDao.save(result);
        return new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_ADD);
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {
        Customer result = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerDao.save(result);
        return new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_UPDATED);
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        int customerId = deleteCustomerRequest.getId();
        this.customerDao.deleteById(customerId);
        return new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_DELETED);
    }

    @Override
    public Boolean checkIfExistCustomerId(int customerId) {
        return this.customerDao.ExistByCustomerId(customerId);
    }


    @Override
    public DataResult<List<ListCustomerDto>> getAll() {
        List<Customer> results = this.customerDao.findAll();
        List<ListCustomerDto> response = results.stream().map(customer -> modelMapperService.forDto().map(customer, ListCustomerDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListCustomerDto>>(response);
    }
}

package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CreditCardService;
import com.etiya.rentACar.dataAccess.abstracts.CreditCardDao;
import org.springframework.stereotype.Service;

@Service
public class CreditCardManager implements CreditCardService {
    private CreditCardDao creditCardDao;

    public CreditCardManager(CreditCardDao creditCardDao) {
        this.creditCardDao = creditCardDao;
    }

}

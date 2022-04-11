package com.etiya.rentACar.core.Adapters;

import com.etiya.rentACar.entities.CreditCard;

public interface PosService {

    Boolean makePayment(CreditCard creditCard);

}

package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.requests.paymentRequest.CreatePaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreatePaymentRequest createPaymentRequest){
        this.paymentService.add(createPaymentRequest);
    }
}

package com.demo.ecommerce.controller;

import com.demo.ecommerce.dto.CustomerPaymentRequest;
import com.demo.ecommerce.dto.PaymentInvoiceAcknowledgement;
import com.demo.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InsufficientResourcesException;

@RestController
@EnableTransactionManagement
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment")
    public PaymentInvoiceAcknowledgement paymentInvoiceAcknowledgement(@RequestBody CustomerPaymentRequest request) throws InsufficientResourcesException {
        return paymentService.paymentInvoice(request);
    }
}

package com.demo.ecommerce.service;

import com.demo.ecommerce.dto.CustomerPaymentRequest;
import com.demo.ecommerce.dto.PaymentInvoiceAcknowledgement;
import com.demo.ecommerce.model.Customer;
import com.demo.ecommerce.model.PaymentDetails;
import com.demo.ecommerce.repository.CustomerInfoRepository;
import com.demo.ecommerce.repository.PaymentRepository;
import com.demo.ecommerce.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InsufficientResourcesException;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public PaymentInvoiceAcknowledgement paymentInvoice(CustomerPaymentRequest request) throws InsufficientResourcesException {
        Customer customer = request.getCustomer();
        customerInfoRepository.save(customer);

        //get payment details as total Amount
        PaymentDetails paymentDetails = request.getPaymentDetails();
        PaymentUtils.validateCreditLimit(paymentDetails.getAccountNo(),customer.getAmount());

        paymentDetails.setCustomerId(customer.getCId());
        paymentDetails.setAmount(customer.getAmount());
        paymentRepository.save(paymentDetails);

        return new PaymentInvoiceAcknowledgement("SUCCESS PAYMENT !!", customer.getAmount(), UUID.randomUUID().toString().split("_")[0],customer);

    }

}

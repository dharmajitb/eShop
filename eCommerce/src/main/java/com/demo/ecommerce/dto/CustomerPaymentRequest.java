package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Customer;
import com.demo.ecommerce.model.PaymentDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPaymentRequest {

    private Customer customer;

    private PaymentDetails paymentDetails;


}

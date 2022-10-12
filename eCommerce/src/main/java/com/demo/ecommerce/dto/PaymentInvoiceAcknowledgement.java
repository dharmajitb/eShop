package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInvoiceAcknowledgement {

    private String status;
    private double totalPayment;
    private String InvoiceNo;
    private Customer customer;

}

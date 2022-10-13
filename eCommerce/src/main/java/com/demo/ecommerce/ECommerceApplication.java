package com.demo.ecommerce;

import com.demo.ecommerce.dto.CustomerPaymentRequest;
import com.demo.ecommerce.dto.PaymentInvoiceAcknowledgement;
import com.demo.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InsufficientResourcesException;

@SpringBootApplication
public class ECommerceApplication {


    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
        System.out.println("Hello Run Project");
    }

}

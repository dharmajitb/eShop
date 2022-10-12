package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetails,String> {

}

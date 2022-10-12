package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<Customer,Long> {

}

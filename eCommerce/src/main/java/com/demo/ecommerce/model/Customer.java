package com.demo.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
public class Customer {
    @Id
    @GeneratedValue
    private Long cId;
    private String name;
    private String email;
    private String Address;
    private String mobileNo;
    private double amount;
//
//    {
//        "name":"customer1",
//        "email":"customer1@gmail.com",
//        "Address":"Kathmandu",
//        "mobileNo":"9861247521",
//        "amount":5000.0
//    }

}

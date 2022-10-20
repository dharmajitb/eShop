package com.demo.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "add_to_cart")
public class CheckoutCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String order_id,payment_type,delivery_address;
    long user_id;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;
    //long ;
    int qty;
    double price;
    @Column(updatable=false, insertable=false)
    String order_date;



}

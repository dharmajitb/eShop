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
public class AddToCart {
    @Id
    long id;
    @JsonIgnore

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;
    //Long product_id;
    int qty;
    double price;
    Long user_id;
    @Column(updatable=false, insertable=false)
    String added_date;

    @Transient
    String productName;



}

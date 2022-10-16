package com.demo.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    Category category;



}

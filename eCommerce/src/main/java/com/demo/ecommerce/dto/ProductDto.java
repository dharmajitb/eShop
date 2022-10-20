package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    // for create it can be optional
    // for update we need the id
    private long id;
    private @NotNull String name;
    private @NotNull double price;
    private @NotNull int AvailableQuantity;
    private @NotNull Integer categoryId;
}

package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;
    private @NotNull String name;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;
}

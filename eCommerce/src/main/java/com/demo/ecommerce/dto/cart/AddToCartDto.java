package com.demo.ecommerce.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;

}

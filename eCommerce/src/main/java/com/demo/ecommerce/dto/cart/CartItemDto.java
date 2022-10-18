package com.demo.ecommerce.dto.cart;

import com.demo.ecommerce.model.Cart;
import com.demo.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDto(Cart cart) {
    }
}

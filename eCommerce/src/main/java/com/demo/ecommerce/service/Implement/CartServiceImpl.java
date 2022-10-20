package com.demo.ecommerce.service.Implement;

import com.demo.ecommerce.model.AddToCart;
import com.demo.ecommerce.model.CheckoutCart;

import java.util.List;

public interface CartServiceImpl {
    List<AddToCart> addCartbyUserIdAndProductId(long productId, long userId, int qty, double price);
    void updateQtyByCartId(long cartId,int qty,double price);
    List<AddToCart> getCartByUserId(long userId);

    Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);


    List<CheckoutCart> getAllCheckoutByUserId(long userId);
    List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;


}

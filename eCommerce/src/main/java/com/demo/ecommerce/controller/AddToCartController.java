package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.AddToCart;
import com.demo.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/addtocart")
public class AddToCartController {
    @Autowired
    CartService cartService;

    @RequestMapping("addProduct")
    public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String, String> addCartRequest) throws Exception {
        try {
            String keys[] = {"productId", "userId", "qty", "price"};
            long productId = Long.parseLong(addCartRequest.get("productId"));
            long userId = Long.parseLong(addCartRequest.get("userId"));
            int qty = Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            List<AddToCart> obj = cartService.addCartbyUserIdAndProductId(productId, userId, qty, price);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Does not add a Cart " + e.getMessage());
        }

    }

    @RequestMapping("updateQtyForCart")
    public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String, String> addCartRequest) throws Exception {
        try {
            String keys[] = {"cartId", "userId", "qty", "price"};
            long cartId = Long.parseLong(addCartRequest.get("cartId"));
            long userId = Long.parseLong(addCartRequest.get("userId"));
            int qty = Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            cartService.updateQtyByCartId(cartId, qty, price);
            List<AddToCart> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials " + e.getMessage());
        }

    }


    @GetMapping("getCartsByUserId")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String, String> getCartRequest) throws Exception {
        try {
            String keys[] = {"userId"};

            List<AddToCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            throw new Exception("Bad Credentials " + e.getMessage());
        }
    }

}

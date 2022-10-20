package com.demo.ecommerce.service;

import com.demo.ecommerce.model.AddToCart;
import com.demo.ecommerce.model.CheckoutCart;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.AddCartRepository;
import com.demo.ecommerce.repository.CheckOutRepo;
import com.demo.ecommerce.service.Implement.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartServiceImpl {

    @Autowired
    AddCartRepository addCartRepository;
    @Autowired
    ProductService productService;

    @Autowired
    CheckOutRepo checkOutRepo;

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Override
    public List<AddToCart> addCartbyUserIdAndProductId(long productId, long userId, int qty, double price) {
        AddToCart obj = new AddToCart();
        obj.setQty(qty);
        obj.setUser_id(userId);
        Product product = productService.findById(productId);
        obj.setProduct(product);
        //TODO price has to check with qty
        obj.setPrice(price);
        addCartRepository.save(obj);
        return this.getCartByUserId(userId);
    }

    @Override
    public void updateQtyByCartId(long cartId, int qty, double price) {
        addCartRepository.updateQtyByCartId(cartId, price, qty);
    }

    @Override
    public List<AddToCart> getCartByUserId(long userId) {
        return addCartRepository.getCartByuserId(userId);
    }


    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, long userId) {
        double total_amount = addCartRepository.getTotalAmountByUserId(userId);
        if (total_amount == totalAmount) {
            return true;
        }
        System.out.print("Error from request " + total_amount + " --db-- " + totalAmount);
        return false;
    }

    @Override
    public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
        return checkOutRepo.getByuserId(userId);
    }

    @Override
    public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
        try {
            long user_id = tmp.get(0).getUser_id();
            if (tmp.size() > 0) {
                checkOutRepo.saveAll(tmp);
                return this.getAllCheckoutByUserId(user_id);
            } else {
                throw new Exception("Should not be empty");
            }
        } catch (Exception e) {
            throw new Exception("Error while checkout " + e.getMessage());
        }
    }


}

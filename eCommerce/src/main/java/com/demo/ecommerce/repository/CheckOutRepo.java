package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.CheckoutCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOutRepo extends JpaRepository<CheckoutCart, Long> {
    @Query("Select checkCart  FROM CheckoutCart checkCart WHERE checkCart.user_id=:user_id")
    List<CheckoutCart> getByuserId(@Param("user_id")Long user_id);
}

package com.demo.ecommerce.utils;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private  static Map<String, Double> paymentMap = new HashMap<>();

    {
        paymentMap.put("Account1",15000.0);
        paymentMap.put("Account2",10000.0);
        paymentMap.put("Account3",1000.0);
        paymentMap.put("Account4",13000.0);
        paymentMap.put("Account5",5000.0);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) throws InsufficientResourcesException {
        //check account amount
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientResourcesException("Insufficient Amount in your Account...!");
        }else {
            return true;
        }
    }
}

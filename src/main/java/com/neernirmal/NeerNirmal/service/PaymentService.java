package com.neernirmal.NeerNirmal.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private RazorpayClient razorpayClient;

    public String createOrder(Double amount, String currency) throws Exception {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Razorpay expects the amount in the smallest currency unit (e.g., paise for INR)
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", "txn_123456");
        orderRequest.put("payment_capture", 1);

        Order order = razorpayClient.Orders.create(orderRequest);
        return order.toString();
    }
}


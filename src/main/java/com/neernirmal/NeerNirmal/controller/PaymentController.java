package com.neernirmal.NeerNirmal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neernirmal.NeerNirmal.service.PaymentService;

@RestController
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create_order")
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            return paymentService.createOrder(orderRequest.getAmount(), orderRequest.getCurrency());
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
}

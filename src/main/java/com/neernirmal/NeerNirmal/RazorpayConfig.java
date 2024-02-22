package com.neernirmal.NeerNirmal;

import com.razorpay.RazorpayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {

    private static final String API_KEY = "rzp_test_RPhITB6jQsJDz7";
    private static final String API_SECRET = "ZF0KfA2YfvCTk0zjtym4kVKd";

    @Bean
    public RazorpayClient razorpayClient() throws Exception {
        return new RazorpayClient(API_KEY, API_SECRET);
    }
}

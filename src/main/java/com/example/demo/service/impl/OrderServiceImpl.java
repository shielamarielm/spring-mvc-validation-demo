package com.example.demo.service.impl;

import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<String> getCakeFlavors() {
        return Arrays.asList("Chocolate", "Ube", "Strawberry", "Mango");
    }
}
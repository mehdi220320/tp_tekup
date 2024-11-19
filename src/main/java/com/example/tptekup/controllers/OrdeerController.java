package com.example.tptekup.controllers;

import com.example.tptekup.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class OrdeerController {
    @Autowired
    OrderService orderService;
}

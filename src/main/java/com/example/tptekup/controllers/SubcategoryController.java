package com.example.tptekup.controllers;

import com.example.tptekup.Services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;
}

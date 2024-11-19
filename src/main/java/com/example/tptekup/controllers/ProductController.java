package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Product;
import com.example.tptekup.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/addProduct")
    public String addProduct(Model model){
        Product product=new Product();
        model.addAttribute(("ProductForm"), product);
        return "create/new_product";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("ProductForm") Product product){
        productService.CreateProd(product);
        return "redirect:/all";
    }

    @RequestMapping("/all")
    public String listeProducts(Model model){

        model.addAttribute("listProducts",productService.getAll());
        return "liste/liste_products";
    }


}

package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Product;
import com.example.tptekup.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/deleteprod/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        productService.DeleteProd(id);
        return "redirect:/all";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productService.GetbyId(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, Product product) {
        productService.updateProd(product);
        return "redirect:/all";
    }

}

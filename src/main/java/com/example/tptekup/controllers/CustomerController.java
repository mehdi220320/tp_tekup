package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Category;
import com.example.tptekup.Entities.Customer;
import com.example.tptekup.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping("addCustomer")
    public String addCustomer(Model model){
        Customer customer=new Customer();
        model.addAttribute(("CustomerForm"),customer);
        return "create/new_customer";
    }
    @RequestMapping(value = "/saveCust",method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("CustomerForm") Customer customer){
        customerService.CreateCust(customer);
        return "redirect:/allcustomer";
    }
    @RequestMapping("/allcustomer")
    public String listeCustomers(Model model){
        model.addAttribute("listCustomers",customerService.getAll());
        return "liste/liste_customers";
    }
    @RequestMapping("/deletecus/{id}")
    public String deleteCustomer(@PathVariable("id") long id){
        customerService.DeleteCust(id);
        return "redirect:/allcustomer";
    }
}

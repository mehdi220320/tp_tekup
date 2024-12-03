package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Ordeer;
import com.example.tptekup.Entities.Provider;
import com.example.tptekup.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class OrdeerController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/addOrder")
    public String addOrder(Model model){
        Ordeer ordeer=new Ordeer();
        model.addAttribute(("OrderForm"), ordeer);
        return "create/new_order";
    }
    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("OrderForm") Ordeer ordeer){
        orderService.CreateORD(ordeer);
        return "redirect:/allorders";
    }
    @RequestMapping("/allorders")
    public String listeOrders(Model model){

        model.addAttribute("listOrders",orderService.getAll());
        return "liste/liste_orders";
    }
    @RequestMapping("/deleteord/{id}")
    public String deleteOrder(@PathVariable("id") long id){
        orderService.DeleteOrd(id);
        return "redirect:/allorders";
    }
}

package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Product;
import com.example.tptekup.Entities.Provider;
import com.example.tptekup.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ProviderController {
    @Autowired
    ProviderService providerService;
    @RequestMapping("/addProvider")
    public String addProvider(Model model){
        Provider provider=new Provider();
        model.addAttribute(("ProviderForm"), provider);
        return "create/new_provider";
    }
    @RequestMapping(value = "/saveProvider",method = RequestMethod.POST)
    public String saveProvider(@ModelAttribute("ProductForm") Provider provider){
        providerService.CreateProv(provider);
        return "redirect:/all";
    }

}

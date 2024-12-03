package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Provider;
import com.example.tptekup.Entities.User;
import com.example.tptekup.Services.ProviderService;
import com.example.tptekup.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user=new User();
        model.addAttribute(("UserForm"), user);
        return "create/new_user";
    }
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("UserForm") User user){
        userService.addUser(user);
        return "redirect:/allUsers";
    }
    @RequestMapping("/allUsers")
    public String listeUser(Model model){

        model.addAttribute("listUsers",userService.getAll());
        return "liste/liste_users";
    }
    @RequestMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.DeleteUser(id);
        return "redirect:/allUsers";
    }
}

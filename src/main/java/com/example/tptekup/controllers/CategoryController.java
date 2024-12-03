package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Category;
import com.example.tptekup.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/addCategory")
    public String addCategory(Model model){
        Category category=new Category();
        model.addAttribute(("CategoryForm"),category );
        return "create/new_category";
    }
    @RequestMapping(value = "/saveCatg",method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("CategoryForm") Category category){
        categoryService.CreateCatg(category);
        return "redirect:/allcat";
    }

    @RequestMapping("/allcat")
    public String listeCategorys(Model model){

        model.addAttribute("listCategories",categoryService.getAll());
        return "liste/liste_categories";
    }
    @RequestMapping("/deletecat/{id}")
    public String deleteCategory(@PathVariable("id") long id){
        categoryService.DeleteCatg(id);
        return "redirect:/allcat";
    }
}

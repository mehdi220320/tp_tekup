package com.example.tptekup.controllers;

import com.example.tptekup.Entities.Category;
import com.example.tptekup.Entities.Subcategory;
import com.example.tptekup.Services.CategoryService;
import com.example.tptekup.Services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;
    @RequestMapping("/addSubCategory")
    public String addSubcategory(Model model){
        Category category=new Category();
        model.addAttribute(("SubCategoryForm"),category );
        return "create/new_subcategory";
    }
    @RequestMapping(value = "/saveSubCatg",method = RequestMethod.POST)
    public String saveSubCategory(@ModelAttribute("SubCategoryForm") Subcategory subcategory){
        subcategoryService.CreateSubCatg(subcategory);
        return "redirect:/allsubcat";
    }
    @RequestMapping("/allsubcat")
    public String listeSubCategorys(Model model){

        model.addAttribute("listSubCategories",subcategoryService.getAll());
        return "liste/liste_subcategories";
    }
    @RequestMapping("/deletesubcat/{id}")
    public String deleteCustomer(@PathVariable("id") long id){
        subcategoryService.DeleteSubCatg(id);
        return "redirect:/allsubcat";
    }
}

package com.example.tptekup.Services;

import com.example.tptekup.Entities.Category;
import com.example.tptekup.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category CreateCatg(Category category){return categoryRepository.save(category);}
    public Category GetbyId(long id){return categoryRepository.findById(id).get();}
    public List<Category> getAll(){return categoryRepository.findAll();}
    public void DeleteCatg(long id){ categoryRepository.deleteById(id);}
    public Category updateCatg(Category category){ return  categoryRepository.saveAndFlush(category);}
}

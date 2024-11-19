package com.example.tptekup.Services;

import com.example.tptekup.Entities.Subcategory;
import com.example.tptekup.Repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;
    public Subcategory CreateSubCatg(Subcategory subcategory){return subcategoryRepository.save(subcategory);}
    public Subcategory GetbyId(long id){return subcategoryRepository.findById(id).get();}
    public List<Subcategory> getAll(){return subcategoryRepository.findAll();}
    public void DeleteSubCatg(long id){ subcategoryRepository.deleteById(id);}
    public Subcategory updateSubCatg(Subcategory subcategory){ return  subcategoryRepository.saveAndFlush(subcategory);}

}

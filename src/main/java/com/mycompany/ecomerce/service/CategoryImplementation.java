package com.mycompany.ecomerce.service;

import com.mycompany.ecomerce.model.Category;
import com.mycompany.ecomerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryImplementation implements CategoryInterface{


    private final List<Category> categories = new ArrayList<>();
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {

        //return categories;
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        //return categories.stream().filter(g -> g.getId() == id).findFirst();
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category addCategory(Category category){
        category.setId(categories.size() + 1);
        //categories.add(category);
        categoryRepository.save(category);
        return  category;
    }

    @Override
    public boolean deleteCategoryById(long id) {
        //return categories.removeIf(category -> category.getId() == id);
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Category updateCategoryById(Category category, long id) {
//        Optional<Category> findCategory = categories.stream()
//                .filter(g -> g.getId() == id)
//                .findFirst();
//        return findCategory.orElse(null);
        Category updateCatagory = categoryRepository.findById(id).orElse(null);
        if(updateCatagory == null) return null;
        updateCatagory.setName(category.getName());
        return categoryRepository.save(updateCatagory);
    }


}

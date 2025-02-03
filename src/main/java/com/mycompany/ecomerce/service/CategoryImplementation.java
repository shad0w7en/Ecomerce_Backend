package com.mycompany.ecomerce.service;

import com.mycompany.ecomerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryImplementation implements CategoryInterface{


    private final List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategory() {
        return categories;
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return categories.stream().filter(g -> g.getId() == id).findFirst();
    }

    @Override
    public Category addCategory(Category category){
        category.setId(categories.size() + 1);
        categories.add(category);
        return  category;
    }

    @Override
    public boolean deleteCategoryById(long id) {
        return categories.removeIf(category -> category.getId() == id);
    }


}

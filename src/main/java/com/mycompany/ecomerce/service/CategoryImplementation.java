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
    public boolean addCategory(Category category){
        categories.add(category);
        return true;
    }


}

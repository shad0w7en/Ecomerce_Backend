package com.mycompany.ecomerce.service;

import com.mycompany.ecomerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryInterface {
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(long id);
    public boolean addCategory(Category category);
}

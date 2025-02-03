package com.mycompany.ecomerce.service;

import com.mycompany.ecomerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryInterface {
    public List<Category> getAllCategory();
    public Category getCategoryById(long id);
    public Category addCategory(Category category);
    public boolean deleteCategoryById(long id);
    public Category updateCategoryById(Category category , long id);
}

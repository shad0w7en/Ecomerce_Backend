package com.mycompany.ecomerce.controller;

import com.mycompany.ecomerce.model.Category;
import com.mycompany.ecomerce.service.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryInterface categoryInterface;

    @GetMapping("api/public/Category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoriesList = categoryInterface.getAllCategory();

        return new ResponseEntity<>(categoriesList,HttpStatus.FOUND);
    }

    @PostMapping("api/public/Category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory =  categoryInterface.addCategory(category);
        if(newCategory == null) return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(newCategory , HttpStatus.CREATED);
    }

    @DeleteMapping("api/public/Category/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable long id){
        if(categoryInterface.deleteCategoryById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/admin/Category/{id}")
    public ResponseEntity<Optional<Category>> findCategoryById(@PathVariable long id){
        Optional<Category> findCategory = categoryInterface.getCategoryById(id);
        if(findCategory.isEmpty()){
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(findCategory ,HttpStatus.FOUND);
    }
}

package com.mycompany.ecomerce.controller;

import com.mycompany.ecomerce.model.Category;
import com.mycompany.ecomerce.service.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryInterface categoryInterface;

    @GetMapping("/Category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoriesList = categoryInterface.getAllCategory();

        return new ResponseEntity<>(categoriesList,HttpStatus.FOUND);
    }

    @PostMapping("Category/{Category}")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryInterface.addCategory(category);

        return new ResponseEntity<>(categoryInterface.)
    }
}

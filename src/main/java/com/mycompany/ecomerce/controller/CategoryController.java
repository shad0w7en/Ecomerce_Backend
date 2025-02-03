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
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryInterface categoryInterface;

    @GetMapping("/public/Category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoriesList = categoryInterface.getAllCategory();

        return new ResponseEntity<>(categoriesList,HttpStatus.FOUND);
    }

    @PostMapping("/public/Category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory =  categoryInterface.addCategory(category);
        if(newCategory == null) return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(newCategory , HttpStatus.CREATED);
    }

    @DeleteMapping("/public/Category/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable long id){
        if(categoryInterface.deleteCategoryById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admin/Category/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable long id){
        Category findCategory = categoryInterface.getCategoryById(id);
        if(findCategory == null ){
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(findCategory ,HttpStatus.FOUND);
    }

    @PutMapping("/admin/Category/{id}")
    public ResponseEntity<Category> updateCategoryById(@RequestBody Category category ,
                                                       @PathVariable Long id){
        Category updateCategory = categoryInterface.updateCategoryById(category,id);
        if(updateCategory == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updateCategory,HttpStatus.OK);
    }
}

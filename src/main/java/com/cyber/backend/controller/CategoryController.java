package com.cyber.backend.controller;

import com.cyber.backend.model.exam.Category;
import com.cyber.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add category

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //get Category

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){

        return this.categoryService.getCategoryById(categoryId);

    }

    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getcategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.upateCategory(category);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

}

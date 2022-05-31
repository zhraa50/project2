package com.example.commercewebsite.controller;

import com.example.commercewebsite.model.Api;
import com.example.commercewebsite.model.Category;
import com.example.commercewebsite.service.Categorycservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Category")
@RequiredArgsConstructor


public class CategoryController {
    private final Categorycservice categorycservice ;


    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory() {
        return ResponseEntity.status(200).body(categorycservice.getCategory());
    }

    //-------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Api> addCategoryc(@RequestBody @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAdded = categorycservice.AddCategory(category);
        if (!isAdded) {
            return ResponseEntity.status(500).body(new Api("Error adding a product", 500));

        }
        return ResponseEntity.status(200).body(new Api("New Product added", 200));
    }



    //---------------------------------------------------------
    @PutMapping("/{index}")
    public ResponseEntity<String> UpdateCategory(@PathVariable Integer index, @RequestBody @Valid Category category , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(categorycservice.UpdateCategory(index,category));
    }


    //-----------------------------------------------------
    @DeleteMapping("/{index}")
    public ResponseEntity<String> DeleteCategory(@PathVariable Integer index)
    {

        return ResponseEntity.status(200).body(categorycservice.DeleteCategory(index));
    }

}

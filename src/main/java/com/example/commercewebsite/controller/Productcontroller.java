package com.example.commercewebsite.controller;

import com.example.commercewebsite.model.Api;
import com.example.commercewebsite.model.Product;
import com.example.commercewebsite.service.Productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor

public class Productcontroller {
    public final  Productservice productservice;


    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProduct() {

        return ResponseEntity.status(200).body(productservice.getProduct());
    }

    //-------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Api> addProduct(@RequestBody @Valid Product product, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAdded = productservice.AddProduct(product);
        if (!isAdded) {
            return ResponseEntity.status(500).body(new Api("Error adding a product", 500));

        }
        return ResponseEntity.status(200).body(new Api("New Product added", 200));
    }

    //---------------------------------------------------------
    @PutMapping("/{index}")
    public ResponseEntity<String> UpdateProduct(@PathVariable int index, @RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(productservice.UpdateProduct(index,product));
    }
    //-----------------------------------------------------
    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteProduct(@PathVariable int index){
        return ResponseEntity.status(200).body(productservice.deleteProduct(index));
    }




   @GetMapping("/comment/{productID}")
   public ResponseEntity<ArrayList<Comment>> getAllComment(@PathVariable String productID){
       return ResponseEntity.status(200).body(productservice.getAllComment(productID));
    }

        }

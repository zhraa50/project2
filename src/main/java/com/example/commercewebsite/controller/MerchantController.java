package com.example.commercewebsite.controller;

import com.example.commercewebsite.model.Api;
import com.example.commercewebsite.model.Merchant;
import com.example.commercewebsite.service.Categorycservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor

public class MerchantController {

    public final Categorycservice.MerchantSerivce merchantSerivce;


    @GetMapping
    public  ResponseEntity<ArrayList<Merchant>> getMerchant() {

        return ResponseEntity.status(200).body(merchantSerivce.getMerchant());
    }

    //-------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Api> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAdded = merchantSerivce.AddMerchant(merchant);
        if (!isAdded) {
            return ResponseEntity.status(500).body(new Api("Error Merchant a product", 500));

        }
        return ResponseEntity.status(200).body(new Api("New Merchant added", 200));
    }

    //---------------------------------------------------------
    @PutMapping("/{index}")
    public ResponseEntity<String> UpdateMerchant(@PathVariable int index, @RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(merchantSerivce.UpdateMerchant(index,merchant));
    }
    //-----------------------------------------------------
    @DeleteMapping("/{index}")
    public ResponseEntity<Merchant> deleteProduct(@PathVariable int index)
    {
        return ResponseEntity.status(200).body(merchantSerivce.deleteMerchant(index));
    }

}

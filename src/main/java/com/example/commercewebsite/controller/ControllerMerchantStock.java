package com.example.commercewebsite.controller;

import com.example.commercewebsite.model.Api;
import com.example.commercewebsite.service.MerchantStock;

import com.example.commercewebsite.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/MerchantStock")
@RequiredArgsConstructor
public class ControllerMerchantStock {

    public final MerchantStockService merchantStockSerivce;

    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock() {

        return ResponseEntity.status(200).body(merchantStockSerivce.getMerchantStock());
    }


    //-------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Api> addMerchantStocK(@RequestBody @Valid MerchantStock  merchantStock, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAdded = merchantStockSerivce.AddMerchantStocK(merchantStock);
        if (!isAdded) {
            return ResponseEntity.status(500).body(new Api("Error adding merchantStock ", 500));

        }
        return ResponseEntity.status(200).body(new Api("New merchantStock added", 200));
    }



    //---------------------------------------------------------
    @PutMapping("/{index}")
    public ResponseEntity<String> UpdatMerchantStock(@PathVariable Integer index, @RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(merchantStockSerivce.UpdateCategory(index,merchantStock));
    }


    //-----------------------------------------------------
    @DeleteMapping("/{index}")
    public ResponseEntity<Boolean> DeletMerchantStock(@PathVariable Integer index)
    {

        return ResponseEntity.status(200).body(merchantStockSerivce.DeleteCategory(index));
    }
}

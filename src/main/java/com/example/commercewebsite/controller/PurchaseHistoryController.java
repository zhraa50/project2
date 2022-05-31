package com.example.commercewebsite.controller;

import com.example.commercewebsite.service.PurchaseHistory;
import com.example.commercewebsite.service.PurchaseHistorySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/PurchaseHistor")
@RequiredArgsConstructor



public class PurchaseHistoryController
{

    public final PurchaseHistorySevice purchaseHistorySevice;


    @GetMapping
    public ResponseEntity<ArrayList<PurchaseHistory>> getPurchaseHistory() {
        return ResponseEntity.status(200).body(purchaseHistorySevice.getPurchaseHistory());
    }
}

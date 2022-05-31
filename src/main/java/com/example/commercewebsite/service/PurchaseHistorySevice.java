package com.example.commercewebsite.service;

import java.util.ArrayList;

public class PurchaseHistorySevice {

    ArrayList<PurchaseHistory> purchaseHistory = new ArrayList<>();

    public ArrayList<PurchaseHistory> getPurchaseHistory(){
       return purchaseHistory;
    }
}
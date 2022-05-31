package com.example.commercewebsite.service;

import com.example.commercewebsite.model.Cart;

import java.util.ArrayList;

public class CartService {
    ArrayList<Cart> cart = new ArrayList<>();
    public ArrayList<Cart> getCarts(){
        return cart;
    }

}


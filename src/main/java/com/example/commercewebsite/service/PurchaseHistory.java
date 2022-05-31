package com.example.commercewebsite.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PurchaseHistory {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String userid;
    //-------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String productid ;
   //---------------------------------------------
    @NotNull(message = "not be null")
    @Positive(message = "onlry positive number")
    private Integer Price;
    //-----------------------------------

}

package com.example.commercewebsite.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Cart {

    @NotEmpty(message = "not be empty")
    @Size(min = 3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min = 3)
    public String userid;
    //-------------------------------------------
    //ArrayList < Product > ( initialize in the constructor ).

}
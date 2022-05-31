package com.example.commercewebsite.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Merchant {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String name;

}

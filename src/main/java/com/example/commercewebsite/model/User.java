package com.example.commercewebsite.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String username;
    //-------------------------------------------
    @NotNull(message = "not be null")
    @Size(min =6 ,message = "length 6")
    @Digits(message = "only number", integer = 1, fraction = 10)
    private Integer password;
    //-----------------------------------
    @NotEmpty(message = "not be empty")
    private String email ;
    //-----------------------------------
    @NotEmpty(message = "not be empty")
    @Pattern(regexp = ("Admin | Customer"))
    private String role  ;
    //----------------------------------------
    @NotNull(message = "not be null")
    @Positive(message = "only positive ")
    private String balance   ;




}

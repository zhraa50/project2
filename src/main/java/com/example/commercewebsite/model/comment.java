package com.example.commercewebsite.model;

import javax.validation.constraints.*;

public class comment {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String id ;
    //-------------------------------------------
    @NotNull(message = "not be null")
    @Size(min =5 ,message = "length 5")
    private String userid;
    //-----------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min =6 ,message = "length 6")
    private String  message   ;
    //-----------------------------------
    @NotNull(message = "not be NULL")
   @Size(min =1 ,max = 5 ,message = " between 1 - 5")
    private Integer rate   ;
    //----------------------------------------


}

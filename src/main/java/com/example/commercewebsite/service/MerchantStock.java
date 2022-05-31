package com.example.commercewebsite.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MerchantStock {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String productid ;
    //----------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String merchantid  ;
    //---------------------------------------
    @NotEmpty(message = "not be empty")
     //@Size(min  =3-- have to be more than 10 at start
    public String stock  ;
    //-------------------------------------




}

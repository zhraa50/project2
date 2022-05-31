package com.example.commercewebsite.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;

public class Product {
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String id;
    //-----------------------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    public String name;
    //-------------------------------------------
    @NotNull(message = "not be null")
    @Positive(message = "onlry positive number")
    private Integer Price;
    //-----------------------------------
    @NotEmpty(message = "not be empty")
    @Size(min  =3)
    private String categoryID;

    //------------------------------------------
    private ArrayList<Comment> comment;

    public Product(String id, String name, Integer price,
                   String categoryID, ArrayList<Comment> comment) {
        this.id = id;
        this.name = name;
        Price = price;
        this.categoryID = categoryID;
        this.comment = comment;
    }


    public ArrayList<Comment> getComment() {return comment;


    }
}
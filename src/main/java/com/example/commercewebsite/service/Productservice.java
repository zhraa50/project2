package com.example.commercewebsite.service;

import com.example.commercewebsite.model.Category;
import com.example.commercewebsite.model.Product;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
@Service
public class Productservice {

    private ArrayList<Product> products =new ArrayList();

    public static Product getProductid(String productid) {
    }


    public ArrayList <Product> getProduct() {
        return products;
    }
    public  boolean AddProduct(Product product)
    {

            return products.add( product);

    }
    public  String UpdateProduct(int index, Product product)
    {
        products.set(index,product);
        return "Product is UPDATE ";
    }

    public String deleteProduct(int index) {
        products.remove(index);
        return "Product is deleted";
    }
//For product is ==nul ?
    public static Product getProductid(String productid) {
        for (Product product:products)
        {
            if (Product.getid().equals(poductid))
            {
                return product;
            }
        }
        return null;
    }

//get all the comments for a product
        public ArrayList<Comment> getAllComment(String productid) {
            for (Product product : products){
                if (product.getid().equals(productid)){
                    return product.getComment();
                }

            }
            return null;
        }

//Create endpoint where user can get all the rate 5 products





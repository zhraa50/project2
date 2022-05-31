package com.example.commercewebsite.service;

import com.example.commercewebsite.model.Product;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class UserService {
    ArrayList<User> user = new ArrayList<>();
    private final MerchantStockService merchantStockService;
    private final Productservice productService;

    public UserService() {
    }


    public ArrayList<User> getUser() {
        return user;
    }

    public boolean AddUser(User users) {
        return user.add(users);

    }

    public User UpdateUser(int index, User users) {
        return user.set(index, users);

    }

    public String deleteUser(int index) {
        return user.set(index);


    }

    public String addProductToCart(String userid, String productid) {
        boolean isUser = checkUserid(userid);
        if (!isUser) {
            return -1;
        }


        Product currentProduct = Productservice.getProductid(productid);
        if (currentProduct == null) {
            return 0;
        }


    }

//remove product from a cart

    public String deleteProductToCart(String userid, String productid) {
        boolean isUser = checkUserid(userid);
        if (!isUser) {
            return -1;
        }
        Product currentProduct = Productservice.getProductid(productid);
        if (currentProduct == null) {
            return 0;
        }

    }

    //  for loop userid
//  تححق من جميع
    private boolean checkUserid(String userid) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getid().equals(userid)) {
                return true;
            }
        }
        return false;
    }

//add product to a merchantStock
    public static int buy(String userid, String productid, String merchantStockid) {

        public String buyProduct(String userid, String productid, String merchantStockid)
        {
            MerchantStock currentmerchantid = merchantStockService.getMerchantStock(merchantStockid);
            if (currentMerchantid == null) {
                return -2;
            }
            Product currentProduct = productService.getProductsID(productid);
            if (currentMerchantid.getStock() < 0) {
                return -1;
            }
        }

    }

}

//   public int addComment(String userID, String productid, Comment comment) {
//        boolean isUser = checkUserID(userid);
//        if(!isUser){
//            return -1;
//        }
//        ArrayList<Comment> oldComment;
//        for (Product product : productService.products){
//            if (product.getid().equals(productID)){
//                oldComment = product.getComment();
//                if (oldComment == null){
//                    oldComment = new ArrayList<>();
//                    oldComment.add(comment);
//                    product.setComment(oldComment);
//                    return 0;
//                }
//                oldComment.add(comment);
//                product.setComment(oldComment);
//                return 0;
//            }
//        }
//        return 1;
//    }
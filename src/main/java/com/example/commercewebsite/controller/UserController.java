package com.example.commercewebsite.controller;

import com.example.commercewebsite.model.Api;
import com.example.commercewebsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor

public class UserController {

    public final UserService userservice;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser() {

        return ResponseEntity.status(200).body(userservice.getUser());
    }

    //-------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAdded = userservice.AddUser(user);
        if (!isAdded) {
            return ResponseEntity.status(500).body(new Api("Error user a product", 500));

        }
        return ResponseEntity.status(200).body(new Api("New user added", 200));
    }

    //---------------------------------------------------------
    @PutMapping("/{index}")
    public ResponseEntity<String> UpdateUser(@PathVariable int index, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return (ResponseEntity<String>) ResponseEntity.status(200).body(userservice.UpdateUser(index,user));
    }
    //-----------------------------------------------------
    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer index) {

        return ResponseEntity.status(200).body(userservice.deleteUser(index));}
        //--------------------------
        //user can add product to a cart.

        @PostMapping("/{userID}/{productID}")
        public ResponseEntity<String> addProductToCart(@RequestBody String userid, @PathVariable String productid){
            String isAddProductToCart = userservice.addProductToCart(userid, productid);
            return switch (isAddProductToCart) {
                case -1 -> ResponseEntity.status(400).body("error");
                case 0 -> ResponseEntity.status(400).body("error");
                default -> ResponseEntity.status(500).body(" error  add product to cart");


            };

        }
////Remove product from a cart
    @DeleteMapping("/{userID}/{productID}")

    public ResponseEntity<String> deleteProductToCart(@PathVariable String userid, @PathVariable String productid){
        int isDeleteProductToCart = UserService.deleteProductToCart(userid,productid);
        return switch (isDeleteProductToCart) {
            case -1 -> ResponseEntity.status(400).body("error");
            case 0 -> ResponseEntity.status(400).body("error");
            default -> ResponseEntity.status(500).body("error remove product to cart");

        };
    }
// can add product to a merchantStock

    @PutMapping("/{userID}/{productID}/{merchantStockID}")
 public ResponseEntity<String> buyProduct(@PathVariable String userID, @PathVariable String productID, @PathVariable String merchantStockID){
     int isBuy = UserService.buy(userID,productID,merchantStockID);
   return switch (isBuy) {
          case -2 -> ResponseEntity.status(400).body("error");
            case -1 -> ResponseEntity.status(400).body("error");

  default -> ResponseEntity.status(500).body("server error");
       };

}
//user can post comment on product
   public int addComment(String userID, String productid, Comment comment) {
      boolean isUser = checkUserid(userid);
    if(!isUser){
        return -1;
     }
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

//    @PostMapping("/commint/{userID}/{productID}")
//    public ResponseEntity<Object> addComment(@PathVariable String userID, @PathVariable String productID,
//                                             @RequestBody @Valid Comment comment,Errors errors){
//        if(errors.hasErrors()){
//            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
//        }
//        int isAddComment = userService.addComment(userID,productID,comment);
//
//        return switch (isAddComment) {
//            case -1 -> ResponseEntity.status(400).body("User id is wrong");
//            case 0 -> ResponseEntity.status(200).body("Add comment completed");
//            case 1 -> ResponseEntity.status(400).body("Product id is wrong");
//            default -> ResponseEntity.status(500).body("server error");
//        };
//    }
//}
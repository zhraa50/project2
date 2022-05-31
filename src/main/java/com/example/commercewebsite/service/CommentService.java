package com.example.commercewebsite.service;


import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
@Service
public class CommentService {


 ArrayList<Comment> comments = new ArrayList<>();

 public ArrayList<Comment> getComment()
 {
  return comments;
 }


     public Object getRate() {
      ArrayList<Comment> rate = new ArrayList<>();
      for (Comment comment:comments){
       if (comment.getRate() == 5){
        rate.add(comment);
        return rate;
       }
      }
      return null;
     }


    }

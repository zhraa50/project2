package com.example.commercewebsite.controller;

import com.example.commercewebsite.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Comment")
@RequiredArgsConstructor
public class CommentController
{
    public final CommentService commentService;

;

   @GetMapping
   public ResponseEntity<ArrayList<Comment>> getComment(){
      return  ResponseEntity.status(200).body(commentService.getComment());
 }
 //can get all the rate 5 products

    @GetMapping("/getRate")
    public ResponseEntity<Object> getRate(){
        return ResponseEntity.status(200).body(commentService.getRate());
    }
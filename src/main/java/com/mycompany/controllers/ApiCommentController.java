/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.Hoa;
import com.mycompany.pojos.User;
import com.mycompany.service.CommentService;
import com.mycompany.service.HoaService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Admin
 */
@RestController
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private HoaService hoaService;
    @PostMapping(path ="/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params){
        try{
            String content = params.get("content");
            int hoaId = Integer.parseInt(params.get("hoaId"));
            
            Comment c = this.commentService.addComment(content, hoaId);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
 
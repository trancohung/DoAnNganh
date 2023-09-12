/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.Hoa;
import com.mycompany.pojos.User;
import com.mycompany.repository.CommentRepository;
import com.mycompany.repository.HoaRepository;
import com.mycompany.repository.UserRepository;
import com.mycompany.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private HoaRepository hoaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int hoaId) {
        Hoa h= this.hoaRepository.getHoaByID(hoaId);
        User u = this.userRepository.getUserById(3);
        Comment c = new Comment();
        c.setContent(content);
        c.setHoaid(h);
        c.setUserId(u);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.Hoa;
import com.mycompany.pojos.User;

/**
 *
 * @author Admin
 */
public interface CommentService {
    Comment addComment(String content, int hoaId);
    
}

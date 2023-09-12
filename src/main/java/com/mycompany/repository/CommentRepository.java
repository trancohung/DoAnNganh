/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojos.Comment;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CommentRepository {
//    List<Comment> getCommentsByHoaId(int hoaid);
    Comment addComment(Comment c);
}

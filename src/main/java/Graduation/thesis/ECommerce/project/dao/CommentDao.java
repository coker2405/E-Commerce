package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.Comment;

import java.util.*;

public interface CommentDao {

    void insert(Comment comment);

    void update(Comment comment);

    void delete(Long id);

    Comment get(Long id);

    List<Comment> searchByProduct(Long id);

}

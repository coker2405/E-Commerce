package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.CommentDTO;

import java.util.*;

public interface CommentService {

    void insert(CommentDTO commentDTO);

    void delete(long id);

    void update(CommentDTO commentDTO);

   // CommentDTO get(long id);

    List<CommentDTO> searchByProduct(Long id);
}

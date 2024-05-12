package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Comment;
import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.Enity.User;
import Graduation.thesis.ECommerce.project.Model.CommentDTO;
import Graduation.thesis.ECommerce.project.Model.ProductDTO;
import Graduation.thesis.ECommerce.project.Model.UserDTO;
import Graduation.thesis.ECommerce.project.Service.CommentService;
import Graduation.thesis.ECommerce.project.Utils.DateTimeUtils;
import Graduation.thesis.ECommerce.project.dao.CommentDao;
import Graduation.thesis.ECommerce.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;


    @Override
    public void insert(CommentDTO commentDTO) {
        
                Comment comment = new Comment();
                comment.setComment(commentDTO.getComment());
                comment.setCommentDate(new Date());

                User user = new User();
                user.setId(commentDTO.getUserDTO().getId());
                comment.setUser(user);

                Product product = new Product();
                product.setId(commentDTO.getProductDTO().getId());
                comment.setProduct(product);

                commentDao.insert(comment);

    }

    @Override
    public void delete(long id) {

                Comment comment = commentDao.get(id);
                if(comment != null){
                    commentDao.delete(comment);
                }
    }

    @Override
    public void update(CommentDTO commentDTO) {
        
                Comment comment = commentDao.get(commentDTO.getId());
                comment.setComment(comment.getComment());
                
                commentDao.update(comment);
    }


    @Override
    public List<CommentDTO> searchByProduct(Long id) {
        List<Comment> listComments= commentDao.searchByProduct(id);
        List<CommentDTO> commentDTOs= new ArrayList<>();
        for(Comment comment:listComments) {
            CommentDTO commentDTO= new CommentDTO();
            commentDTO.setComment(comment.getComment());
            commentDTO.setCommentDate(String.valueOf(comment.getCommentDate()));

            ProductDTO productDTO= new ProductDTO();
            productDTO.setId(comment.getProduct().getId());
            commentDTO.setProductDTO(productDTO);

            UserDTO userDTO = new UserDTO();
            userDTO.setName(comment.getUser().getName());
            commentDTO.setUserDTO(userDTO);

            commentDTOs.add(commentDTO);
        }
        return commentDTOs;
    }
}

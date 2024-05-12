package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Comment;
import Graduation.thesis.ECommerce.project.dao.CommentDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void insert(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void update(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public void delete(Comment comment) {
        entityManager.remove(comment);
    }

    @Override
    public Comment get(Long id) {
        return entityManager.find(Comment.class,id);
    }

    @Override
    public List<Comment> searchByProduct(Long id) {
        String jql = "select c from Comment c join c.product p join c.user u where p.id = :pId";
        return entityManager.createQuery(jql, Comment.class).setParameter("pId", id).getResultList();
    }
}

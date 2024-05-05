package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.Enity.Review;
import Graduation.thesis.ECommerce.project.Model.SearchReviewDTO;
import Graduation.thesis.ECommerce.project.dao.ReviewDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository
public class ReviewDaoImpl implements ReviewDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(Review review) {
        entityManager.persist(review);
    }

    @Override
    public void delete(Review review) {
        entityManager.remove(review);
    }

    @Override
    public void edit(Review review) {
        entityManager.merge(review);
    }

    @Override
    public Review getById(Long id) {
        return entityManager.find(Review.class, id);
    }

    @Override
    public List<Review> find(Long productId) {
        String jql = "select r from Review r join r.user u join r.product p where p.id =:pid";
        return entityManager.createQuery(jql, Review.class).setParameter("pid", productId).getResultList();
    }

    @Override
    public Long count(SearchReviewDTO searchReviewDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Review> root = criteriaQuery.from(Review.class);

        List<Predicate> predicates = new ArrayList<Predicate>();


        if (searchReviewDTO.getProductId() != null) {
            Join<Review, Product> product = root.join("product");
            predicates.add(criteriaBuilder.equal(product.get("id"), searchReviewDTO.getProductId()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
        return typedQuery.getSingleResult();
    }

    @Override
    public Long countTotal(SearchReviewDTO searchReviewDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Review> root = criteriaQuery.from(Review.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
        return typedQuery.getSingleResult();

    }
}

package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Category;
import Graduation.thesis.ECommerce.project.dao.CategoryDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class CategoryImpl implements CategoryDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void insert(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
        entityManager.remove(category);
    }

    @Override
    public Category get(Long id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public List<Category> search(String findName) {
        String jql = "Select c from category c where c.name like :cname";
        return entityManager.createQuery(jql,Category.class)
                .setParameter("cname","%"+findName+"%")
                .getResultList();
    }

    @Override
    public List<Category> search(String findName, int offset, int maxPerPage) {
        String jql = "Select c from category c where c.name like :cname";
        return entityManager.createQuery(jql,Category.class)
                .setParameter("cname","%"+findName+"%")
                .setFirstResult(offset)
                .setMaxResults(maxPerPage)
                .getResultList();
    }

    @Override
    public int count(String findName) {
        String jql = "Select c from category c where c.name like :cname";
        return entityManager.createQuery(jql,Integer.class)
                .setParameter("cname","%"+findName+"%")
                .getSingleResult();
    }
}

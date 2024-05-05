package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Size;
import Graduation.thesis.ECommerce.project.dao.SizeDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class SizeDaoImpl implements SizeDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void insert(Size Size) {
        entityManager.persist(Size);
    }

    @Override
    public void update(Size Size) {
        entityManager.merge(Size);
    }

    @Override
    public void delete(Size Size) {
        entityManager.remove(Size);
    }

    @Override
    public Size get(Long id) {
        return entityManager.find(Size.class,id);
    }

    @Override
    public List<Size> search(String findName) {
        String jql = "select c from size c where c.name like :name";
        return entityManager.createQuery(jql, Size.class).setParameter("name", "%" + findName + "%")
                .getResultList();

    }

    @Override
    public List<Size> search(String findName, int offset, int maxPerPage) {
        String jql = "select c from size c where c.name like :name";
        return entityManager.createQuery(jql, Size.class).setParameter("name", "%" + findName + "%")
                .setFirstResult(offset).setMaxResults(maxPerPage).getResultList();
    }

    @Override
    public int count(String findName) {
        String jql = "select count(c) from size c where c.name like :name";
        return entityManager.createQuery(jql, Integer.class).setParameter("name", "%" + findName + "%")
                .getSingleResult();
    }
}

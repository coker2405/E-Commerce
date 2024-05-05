package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Brand;
import Graduation.thesis.ECommerce.project.dao.BrandDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class BrandDaoImpl implements BrandDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insert(Brand brand) {
        entityManager.persist(brand);
    }

    @Override
    public void update(Brand brand) {
        entityManager.merge(brand);
    }

    @Override
    public void delete(Brand brand) {
        entityManager.remove(brand);
    }

    @Override
    public Brand get(long id) {
        return entityManager.find(Brand.class,id);
    }

    @Override
    public List<Brand> search(String findName) {

        String jql = "Select b from brand b where b.name like: bname";
        return entityManager.createQuery(jql, Brand.class)
                .setParameter("bname","%" +findName+ "%")
                .getResultList();
    }

    @Override
    public List<Brand> search(String findName, int offset, int maxPerPage) {
        String jql = "Select b from brand where b.name = bname";
        return entityManager.createQuery(jql)
                .setParameter("bname","%"+findName+"%")
                .setFirstResult(offset)
                .setMaxResults(maxPerPage)
                .getResultList();
    }

    @Override
    public int count(String findName) {
        String jql = "select count(c) from ThuongHieu c where c.name like :name";
        return entityManager.createQuery(jql, Integer.class).setParameter("name", "%" + findName + "%")
                .getSingleResult();
    }
}

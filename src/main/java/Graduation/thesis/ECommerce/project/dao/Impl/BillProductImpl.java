package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.BillProduct;
import Graduation.thesis.ECommerce.project.dao.BillProductDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class BillProductImpl implements BillProductDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void insert(BillProduct billProduct) {
        entityManager.persist(billProduct);
    }

    @Override
    public void update(BillProduct billProduct) {
        entityManager.merge(billProduct);
    }

    @Override
    public void delete(BillProduct billProduct) {
        entityManager.remove(billProduct);
    }

    @Override
    public BillProduct get(Long id) {

        return entityManager.find(BillProduct.class,id);
    }

    @Override
    public List<BillProduct> search(String findName, int start, int length) {
        String jql = "Select bp from BillProduct bp join bp.product p where p.name like :pname ";
        return entityManager.createQuery(jql,BillProduct.class)
                .setParameter("pname",findName)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();
    }

    @Override
    public List<BillProduct> searchByBill(Long idBill, int start, int length) {
        String jql = "Select bp from BillProduct bp join bp.bill b where b.id = :bid";
        return entityManager.createQuery(jql,BillProduct.class)
                .setParameter("bid",idBill)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();

    }
}

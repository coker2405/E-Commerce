package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Bill;
import Graduation.thesis.ECommerce.project.dao.BillDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class BillDaoImpl implements BillDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void insert(Bill bill) {
        entityManager.persist(bill);
    }

    @Override
    public void update(Bill bill) {
        entityManager.merge(bill);
    }

    @Override
    public void delete(Bill bill) {
        entityManager.remove(bill);
    }

    @Override
    public Bill get(Long id) {
        return entityManager.find(Bill.class,id);
    }

    @Override
    public List<Bill> search(String findName, int start, int length) {
        String jql = "Select b from Bill b where b.buyer u where u.name like :uname";
        return entityManager.createQuery(jql,Bill.class).
                            setParameter("uname","%"+findName+"%").
                            setFirstResult(start).setMaxResults(length).
                            getResultList();
    }

    @Override
    public List<Bill> searchByBuyerId(Long buyerId, int start, int length) {
        String jql = "Select b from Bill b join b.buyer u.id = :uid";
        return entityManager.createQuery(jql,Bill.class)
                .setParameter("uid",buyerId)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();
    }
}

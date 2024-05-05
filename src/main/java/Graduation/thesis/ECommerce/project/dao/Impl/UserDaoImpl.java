package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.User;
import Graduation.thesis.ECommerce.project.dao.UserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User getByUserName(String userName) {
        String jql = " select u from user u where u.username = :name ";
        return entityManager.createQuery(jql, User.class).setParameter("name", userName).getSingleResult();
    }

    @Override
    public List<User> search(String findName, int start, int length) {

        String jql = "select u from User u where name like :name";
        return entityManager.createQuery(jql, User.class)
                .setParameter("name",findName)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();

    }

}

package Graduation.thesis.ECommerce.project.dao.Impl;

import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.dao.ProductDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

    @Override
    public Product get(Long id) {
        String hql="SELECT p FROM Product p join p.category c"
                + " join p.brand th"
                + " join p.size kt"
                + "where p.id =:pId";
        return entityManager.createQuery(hql,Product.class).setParameter("pId", id).getSingleResult();
    }

    @Override
    public List<Product> search(String findName, String categoryName, String brandName, String sizeName, Long priceStart, Long priceEnd, int start, int length) {

        try {
            String hql = "SELECT p FROM Product p join p.category c"
                    + " join p.brand th"
                    + " join p.size kt"
                    + "where (p.name like:pname and c.name like:cname and th.name like:thname and kt.name like:ktname"
                    + " and (p.price between :priceStart AND :priceEnd ))";

            return entityManager.createQuery(hql, Product.class).setParameter("pname", "%" + findName + "%")
                    .setParameter("cname", "%" + categoryName + "%").setParameter("thname", "%" + brandName + "%")
                    .setParameter("ktname", "%" + sizeName + "%")
                    .setParameter("priceStart", priceStart).setParameter("priceEnd", priceEnd).setFirstResult(start)
                    .setMaxResults(length).getResultList();

        } catch (Exception e) {
            System.out.println("loi" + e);
        }
        return null;

    }

    @Override
    public List<Product> searchByCategory(String findName, String thuongHieuName, String KichThuocName
                                          , Long priceStart, Long priceEnd, Long categoryId, int start, int length) {
        String hql = "SELECT p FROM Product p  inner join Category c on c.id=p.category.id"
                + " inner join brand th  on p.brand.id=th.id"
                + " inner join size kt on p.size.id=kt.id "
                + "where (p.name like:pname and p.category.id=:cId and p.brand.name like:thname and p.size.name like:ktname"
                + " and (p.price between :priceStart AND :priceEnd ))";

        return entityManager.createQuery(hql, Product.class).setParameter("pname", "%" + findName + "%")
                .setParameter("thname", "%" + thuongHieuName + "%")
                .setParameter("priceStart", priceStart).setParameter("priceEnd", priceEnd)
                .setParameter("ktname", "%" + KichThuocName + "%").setParameter("cId", categoryId).setFirstResult(start)
                .setMaxResults(length).getResultList();
    }
}

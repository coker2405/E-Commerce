package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.Product;

import java.util.*;

public interface ProductDao {
    void insert(Product product);

    void update(Product product);

    void delete(Product product);

    Product get(Long id);

    List<Product> search(String findName, String categoryName, String brandName, String sizeName,
                         Long priceStart, Long priceEnd, int start, int length);

    List<Product> searchByCategory(String findName, String brandName, String sizeName,
                                   Long priceStart, Long priceEnd, Long categoryId, int start, int length);

}

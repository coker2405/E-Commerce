package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.ProductDTO;

import java.util.*;

public interface ProductService {
    void insert(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void delete(Long id);

    ProductDTO get(Long id);

    List<ProductDTO> search(String findName, String categoryName, String brandName, String sizeName,
                             Long priceStart, Long priceEnd, int start, int length);

    List<ProductDTO> searchByCategory(String findName, String brandName, String sizeName,
                                      Long priceStart, Long priceEnd, Long categoryId, int start, int length);

}


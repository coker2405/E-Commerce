package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Enity.Category;
import Graduation.thesis.ECommerce.project.Model.CategoryDTO;

import java.util.*;

public interface CategoryService {
    void insert(CategoryDTO categoryDTD);

    void update(CategoryDTO categoryDTO);

    void delete(Long id);
    CategoryDTO get(Long id);

    List<CategoryDTO> search(String findName, int offset, int maxPerPage);

}
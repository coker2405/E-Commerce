package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Category;
import Graduation.thesis.ECommerce.project.Model.CategoryDTO;
import Graduation.thesis.ECommerce.project.Service.CategoryService;
import Graduation.thesis.ECommerce.project.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public void insert(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryDao.insert(category);
        categoryDTO.setId(category.getId());

    }

    @Override
    public void update(CategoryDTO categoryDTO) {

        Category category = categoryDao.get(categoryDTO.getId());
        if(category != null){
            category.setName(categoryDTO.getName());
            categoryDao.update(category);
        }
    }

    @Override
    public void delete(Long id) {
        Category category = categoryDao.get(id);
        categoryDao.delete(category);
    }

    @Override
    public CategoryDTO get(Long id) {

            Category category = categoryDao.get(id);
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(category.getName());
            categoryDTO.setId(category.getId());
            return categoryDTO;

    }
    @Override
    public List<CategoryDTO> search(String findName, int offset, int maxPerPage) {
            List<Category> categories = categoryDao.search(findName, offset, maxPerPage);
            List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
            for (Category category : categories) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());
                categoryDTOs.add(categoryDTO);
            }
            return categoryDTOs;
        }


}

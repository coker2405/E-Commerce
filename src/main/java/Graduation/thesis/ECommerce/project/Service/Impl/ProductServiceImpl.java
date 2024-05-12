package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Brand;
import Graduation.thesis.ECommerce.project.Enity.Category;
import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.Enity.Size;
import Graduation.thesis.ECommerce.project.Model.BrandDTO;
import Graduation.thesis.ECommerce.project.Model.CategoryDTO;
import Graduation.thesis.ECommerce.project.Model.ProductDTO;
import Graduation.thesis.ECommerce.project.Model.SizesDTO;
import Graduation.thesis.ECommerce.project.Service.ProductService;
import Graduation.thesis.ECommerce.project.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public void insert(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImageURL());
        product.setQuantity(productDTO.getQuantity());

        Category category = new Category();
        category.setId(productDTO.getCategory().getId());
        category.setName(productDTO.getCategory().getName());
        product.setCategory(category);

        Brand Brand = new Brand();
        Brand.setId(productDTO.getBrandDTO().getId());
        Brand.setName(productDTO.getBrandDTO().getName());
        product.setBrand(Brand);

        Size Sizes = new Size();
        Sizes.setId(productDTO.getSizesDTO().getId());
        Sizes.setName(productDTO.getSizesDTO().getName());
        product.setSize(Sizes);
        
        productDao.insert(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productDao.get(productDTO.getId());
        if (product != null) {
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setImage(productDTO.getImageURL());
            product.setQuantity(productDTO.getQuantity());

            Category category = new Category();
            category.setId(productDTO.getCategory().getId());
            category.setName(productDTO.getCategory().getName());
            product.setCategory(category);

            Brand Brand = new Brand();
            Brand.setId(productDTO.getBrandDTO().getId());
            Brand.setName(productDTO.getBrandDTO().getName());
            product.setBrand(Brand);

            Size Sizes = new Size();
            Sizes.setId(productDTO.getSizesDTO().getId());
            Sizes.setName(productDTO.getSizesDTO().getName());
            product.setSize(Sizes);
            

            productDao.update(product);
        }
    }

    @Override
    public void delete(Long id) {
        Product product = productDao.get(id);
        if (product != null) {
            productDao.delete(product);
        }
    }

    @Override
    public List<ProductDTO> search(String findName, String categoryName, String BrandName, String SizesName,
                                  Long priceStart, Long priceEnd, int start, int length) {

        List<Product> listProducts = productDao.search(findName, categoryName, BrandName, SizesName,
                priceStart, priceEnd, start, length);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (Product product : listProducts) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setImageURL(product.getImage());
            productDTO.setDescription(product.getDescription());
            productDTO.setQuantity(product.getQuantity());

            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(product.getCategory().getId());
            categoryDTO.setName(product.getCategory().getName());
            productDTO.setCategory(categoryDTO);

            BrandDTO Brand = new BrandDTO();
            Brand.setId(product.getBrand().getId());
            Brand.setName(product.getBrand().getName());
            productDTO.setBrandDTO(Brand);

            SizesDTO SizesDTO = new SizesDTO();
            SizesDTO.setId(product.getSize().getId());
            SizesDTO.setName(product.getSize().getName());
            productDTO.setSizesDTO(SizesDTO);

            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public ProductDTO get(Long id) {
        Product product = productDao.get(id);
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setImageURL(product.getImage());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(product.getCategory().getId());
        categoryDTO.setName(product.getCategory().getName());
        dto.setCategory(categoryDTO);

        BrandDTO BrandDTO = new BrandDTO();
        BrandDTO.setId(product.getBrand().getId());
        BrandDTO.setName(product.getBrand().getName());
        dto.setBrandDTO(BrandDTO);

        SizesDTO SizesDTO = new SizesDTO();
        SizesDTO.setId(product.getSize().getId());
        SizesDTO.setName(product.getSize().getName());
        dto.setSizesDTO(SizesDTO);
        

        return dto;
    }

    @Override
    public List<ProductDTO> searchByCategory(String findName, String BrandName, String SizesName,
                                              Long priceStart, Long priceEnd, Long categoryId, int start, int length) {

        List<Product> listProducts = productDao.searchByCategory(findName, BrandName, SizesName,
                priceStart, priceEnd, categoryId, start, length);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (Product product : listProducts) {
            ProductDTO ProductDTO = new ProductDTO();
            ProductDTO.setId(product.getId());
            ProductDTO.setName(product.getName());
            ProductDTO.setPrice(product.getPrice());
            ProductDTO.setImageURL(product.getImage());
            ProductDTO.setDescription(product.getDescription());

            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(product.getCategory().getId());
            categoryDTO.setName(product.getCategory().getName());
            ProductDTO.setCategory(categoryDTO);

            BrandDTO Brand = new BrandDTO();
            Brand.setId(product.getBrand().getId());
            Brand.setName(product.getBrand().getName());
            ProductDTO.setBrandDTO(Brand);

            SizesDTO SizesDTO = new SizesDTO();
            SizesDTO.setId(product.getSize().getId());
            SizesDTO.setName(product.getSize().getName());
            ProductDTO.setSizesDTO(SizesDTO);


            productDTOs.add(ProductDTO);
        }
        return productDTOs;
    }
}

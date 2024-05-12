package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Bill;
import Graduation.thesis.ECommerce.project.Enity.BillProduct;
import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.Model.BillProductDTO;
import Graduation.thesis.ECommerce.project.Model.ProductDTO;
import Graduation.thesis.ECommerce.project.Service.BillProductService;
import Graduation.thesis.ECommerce.project.dao.BillProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BillProductServiceImpl implements BillProductService {

    @Autowired
    BillProductDao billProductDao;
    @Override
    public void insert(BillProductDTO billProductDTO) {

        BillProduct billProduct = new BillProduct();
        billProduct.setQuantity(billProductDTO.getQuantity());
        billProduct.setUnitPrice(billProductDTO.getUnitPrice());

        Bill bill = new Bill();
        bill.setId(billProductDTO.getBill().getId());
        billProduct.setBill(bill);

        Product product = new Product();
        product.setId(billProductDTO.getProduct().getId());

        billProduct.setProduct(product);

        billProductDao.insert(billProduct);
    }
    @Override
    public void update(BillProductDTO billProductDTO) {

        BillProduct billProduct = billProductDao.get(billProductDTO.getId());

        if (billProduct != null) {

            billProduct.setId(billProductDTO.getId());
            billProduct.setQuantity(billProductDTO.getQuantity());
            billProduct.setUnitPrice(billProductDTO.getUnitPrice());

            Bill bill = new Bill();
            bill.setId(billProductDTO.getBill().getId());

            Product product = new Product();
            product.setId(billProductDTO.getProduct().getId());
            billProduct.setBill(bill);
            billProduct.setProduct(product);
            billProductDao.update(billProduct);
        }
    }

    @Override
    public void delete(Long id) {

        BillProduct billProduct = billProductDao.get(id);
        if (billProduct != null) {
            billProductDao.delete(billProduct);
        }

    }

    @Override
    public List<BillProductDTO> search(String findName, int start, int length) {

        List<BillProduct> billProducts = billProductDao.search(findName,start, length );
        List<BillProductDTO> billProductDTOs = new ArrayList<BillProductDTO>();

        for (BillProduct billProduct : billProducts) {
            billProductDTOs.add(convertDTO(billProduct));
        }
        return billProductDTOs;
    }

    private BillProductDTO convertDTO(BillProduct billProduct) {

        BillProductDTO billProductDTO = new BillProductDTO();
        billProductDTO.setId(billProduct.getId());
        billProductDTO.setQuantity(billProduct.getQuantity());
        billProductDTO.setUnitPrice(billProduct.getUnitPrice());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(billProduct.getProduct().getId());
        productDTO.setName(billProduct.getProduct().getName());
        productDTO.setImageURL(billProduct.getProduct().getImage());
        productDTO.setPrice(billProduct.getProduct().getPrice());
        billProductDTO.setProduct(productDTO);

        return billProductDTO;
    }

    @Override
    public List<BillProductDTO> searchByBill(Long idBill, int start, int length) {

        List<BillProduct> billProducts = billProductDao.searchByBill(idBill, start, length);
        List<BillProductDTO> billProductDTOs = new ArrayList<BillProductDTO>();

        for (BillProduct billProduct : billProducts) {
            billProductDTOs.add(convertDTO(billProduct));
        }
        return billProductDTOs;

    }
}

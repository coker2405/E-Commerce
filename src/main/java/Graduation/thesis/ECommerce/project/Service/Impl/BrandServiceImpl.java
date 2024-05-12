package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Brand;
import Graduation.thesis.ECommerce.project.Model.BrandDTO;
import Graduation.thesis.ECommerce.project.Service.BrandService;
import Graduation.thesis.ECommerce.project.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandDao BrandDao;
    @Override
    public void add(BrandDTO BrandDTO) {
        Brand Brand = new Brand();
        Brand.setName(BrandDTO.getName());
        BrandDao.insert(Brand);
        BrandDTO.setId(Brand.getId());
    }

    @Override
    public void update(BrandDTO BrandDTO) {
        Brand Brand = BrandDao.get(BrandDTO.getId());
        if (Brand != null) {
            Brand.setName(BrandDTO.getName());

            BrandDao.update(Brand);
        }
    }


    @Override
    public void delete(long id) {
        Brand Brand = BrandDao.get(id);
        if (Brand != null) {
            BrandDao.delete(Brand);
        }
    }

    @Override
    public BrandDTO get(long id) {
        Brand Brand = BrandDao.get(id);
        if (Brand !=null) {
            BrandDTO BrandDTO = new BrandDTO();
            BrandDTO.setId(Brand.getId());
            BrandDTO.setName(Brand.getName());
            return BrandDTO;
        }
        return null;
    }

    @Override
    public List<BrandDTO> search(String name, int start, int length) {
        List<Brand> Brands = BrandDao.search(name, start, length);
        List<BrandDTO> BrandDTOs = new ArrayList<BrandDTO>();
        for (Brand Brand : Brands) {
            BrandDTO thHieuDTO = new BrandDTO();
            thHieuDTO.setId(Brand.getId());
            thHieuDTO.setName(Brand.getName());
            BrandDTOs.add(thHieuDTO);
        }
        return BrandDTOs;
    }

}
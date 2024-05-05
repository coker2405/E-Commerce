package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Model.BillProductDTO;
import Graduation.thesis.ECommerce.project.Service.BillProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BillProductServiceImpl implements BillProductService {
    @Override
    public void insert(BillProductDTO billProductDTO) {

    }

    @Override
    public void update(BillProductDTO billProductDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<BillProductDTO> search(String findName, int start, int length) {
        return null;
    }

    @Override
    public List<BillProductDTO> searchByBill(Long idBill, int start, int length) {
        return null;
    }
}

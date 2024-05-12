package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Bill;
import Graduation.thesis.ECommerce.project.Enity.User;
import Graduation.thesis.ECommerce.project.Model.BillDTO;
import Graduation.thesis.ECommerce.project.Model.UserDTO;
import Graduation.thesis.ECommerce.project.Service.BillService;
import Graduation.thesis.ECommerce.project.Utils.DateTimeUtils;
import Graduation.thesis.ECommerce.project.dao.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;
    @Override
    public void insert(BillDTO billDTO) {

        Bill bill = new Bill();

        bill.setBuyer(new User(billDTO.getBuyer().getId()));
        bill.setPay(billDTO.getPay());
        bill.setBuyDate(new Date());
        bill.setStatus(billDTO.getStatus());
        bill.setId(billDTO.getId());

        billDao.insert(bill);
    }

    @Override
    public void update(BillDTO billDTO) {

            Bill bill = billDao.get(billDTO.getId());

            if (bill != null) {
                bill.setPriceTotal(billDTO.getPriceTotal());
                bill.setDiscountPercent(billDTO.getDiscountPercent());
                bill.setStatus(billDTO.getStatus());
                bill.setPay(billDTO.getPay());

                billDao.update(bill);
            }

        };

    @Override
    public void delete(Long id) {

        Bill bill = billDao.get(id);
        if(bill != null){
            billDao.delete(bill);
        }

    }

    @Override
    public BillDTO get(Long id) {

        return convertDTO(billDao.get(id));
    }

    private BillDTO convertDTO(Bill bill) {

        BillDTO billDTO = new BillDTO();
        billDTO.setId(bill.getId());
        billDTO.setBuyDate(DateTimeUtils.formatDate(bill.getBuyDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
        billDTO.setPriceTotal(bill.getPriceTotal());
        billDTO.setDiscountPercent(bill.getDiscountPercent());
        billDTO.setPay(bill.getPay());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(bill.getBuyer().getId());
        userDTO.setAddress(bill.getBuyer().getAddress());
        userDTO.setName(bill.getBuyer().getName());
        userDTO.setPhone(bill.getBuyer().getPhone());
        billDTO.setBuyer(userDTO);

        return billDTO;
    }

    @Override
    public List<BillDTO> search(String findName, int start, int length) {
        List<Bill> bills = billDao.search(findName, start, length);
        List<BillDTO> billDTOs = new ArrayList<BillDTO>();
        for (Bill bill : bills) {
            billDTOs.add(convertDTO(bill));
        }
        return billDTOs;

    }

    @Override
    public List<BillDTO> searchByBuyerId(Long buyerId, int start, int length) {
        List<Bill> bills = billDao.searchByBuyerId(buyerId, start, length);
        List<BillDTO> billDTOs = new ArrayList<BillDTO>();
        if (bills.isEmpty()) {
            return null;
        } else {
            for (Bill bill : bills) {
                billDTOs.add(convertDTO(bill));
            }
            return billDTOs;
        }
    }
}

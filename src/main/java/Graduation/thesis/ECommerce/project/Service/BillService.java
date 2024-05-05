package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.BillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


public interface BillService {
    void insert(BillDTO billDTO);

    void update(BillDTO billDTO);

    void delete(Long id);

    BillDTO get(Long id);

    List<BillDTO> search(String findName, int start, int length);

    List<BillDTO> searchByBuyerId(Long buyerId, int start, int length);
}
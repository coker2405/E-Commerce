package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.BillProductDTO;
import java.util.*;

public interface BillProductService {
    void insert(BillProductDTO billProductDTO);

    void update(BillProductDTO billProductDTO);

    void delete(Long id);

    List<BillProductDTO> search(String findName, int start, int length);

    List<BillProductDTO> searchByBill(Long idBill, int start, int length);
}

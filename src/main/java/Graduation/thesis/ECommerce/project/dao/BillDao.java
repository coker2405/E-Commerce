package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.Bill;

import java.util.*;

public interface BillDao {
    void insert(Bill bill);

    void update(Bill bill);

    void delete(Bill bill);

    Bill get(Long id);

    List<Bill> search(String findName, int start, int length);

    List<Bill> searchByBuyerId(Long buyerId, int start, int length);
}


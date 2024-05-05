package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.Brand;
import java.util.*;
public interface BrandDao {

    void insert(Brand brand);

    void update(Brand brand);

    void delete(Brand brand);

    Brand get(long id);

    List<Brand> search(String findName);

    List<Brand> search(String findName, int offset, int maxPerPage);

    int count(String findName);
}

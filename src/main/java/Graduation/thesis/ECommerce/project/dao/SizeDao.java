package Graduation.thesis.ECommerce.project.dao;


import Graduation.thesis.ECommerce.project.Enity.Size;

import java.util.*;

public interface SizeDao {

    void insert(Size Size);

    void update(Size Size);

    void delete(Size Size);

    Size get(Long id);

    List<Size> search(String findName);

    List<Size> search(String findName, int offset, int maxPerPage);

    int count(String findName);
}

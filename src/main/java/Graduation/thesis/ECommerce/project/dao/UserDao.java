package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.User;
import java.util.*;
public interface UserDao {
    void insert(User user);

    void update(User user);

    void delete(User user);

    User get(Long id);

    User getByUserName(String userName);

    User getByEmail(String email);

    List<User> search(String findName, int start, int length);

}

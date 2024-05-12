package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.UserDTO;

import java.util.*;

public interface UserService {
    void insert(UserDTO user);

    void update(UserDTO user);

    void delete(Long id);

    UserDTO get(Long id);

    UserDTO getByUserName(String userName);

    List<UserDTO> search(String name, int start, int length);
    void changePassword(UserDTO accountDTO);

    void resetPassword(UserDTO accountDTO);

    void setupUserPassword(UserDTO accountDTO);

    void updateProfile(UserDTO userDTO);

}

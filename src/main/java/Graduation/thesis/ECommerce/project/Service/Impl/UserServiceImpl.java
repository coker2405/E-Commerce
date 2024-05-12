package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.User;
import Graduation.thesis.ECommerce.project.Model.UserDTO;
import Graduation.thesis.ECommerce.project.Service.UserService;
import Graduation.thesis.ECommerce.project.Utils.DateTimeUtils;
import Graduation.thesis.ECommerce.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static Graduation.thesis.ECommerce.project.Utils.DateTimeUtils.DD_MM_YYYY;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public void insert(UserDTO user) {


        User user1 = new User();
        user1.setName(user.getName());
        user1.setDOB(DateTimeUtils.parseDate(DD_MM_YYYY,user.getDOB()));
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        user1.setAddress(user.getAddress());
        user1.setEnabled(user.getEnabled());
        user1.setUsername(user.getUsername());

        userDao.insert(user1);
    }

    @Override
    public void update(UserDTO userDTO) {

        User user = userDao.get(userDTO.getId());

        user.setName(userDTO.getName());
        user.setDOB(DateTimeUtils.parseDate(userDTO.getDOB(),DD_MM_YYYY));
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());
        user.setAddress(userDTO.getAddress());
        user.setEnabled(userDTO.getEnabled());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(userDao.get(id));
    }

    @Override
    public UserDTO get(Long id) {

        UserDTO userDTO = new UserDTO();
        User user = userDao.get(id);

        userDTO.setEmail(userDTO.getEmail());
        userDTO.setPhone(userDTO.getPhone());
        userDTO.setGender(userDTO.getGender());
        userDTO.setRole(userDTO.getRole());
        userDTO.setName(userDTO.getName());
        userDTO.setDOB(DateTimeUtils.formatDate(user.getDOB(),DD_MM_YYYY));
        return null;
    }

    @Override
    public UserDTO getByUserName(String userName) {
        User user = userDao.getByUserName(userName);
        return convert(user);
    }

    private UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDOB(DateTimeUtils.formatDate(user.getDOB(),DD_MM_YYYY));
        userDTO.setRole(user.getRole());
        userDTO.setUsername(user.getUsername());
        userDTO.setGender(user.getGender());
        userDTO.setAddress(user.getAddress());
        userDTO.setEnabled(user.getEnabled());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public List<UserDTO> search(String name, int start, int length) {
    List<User> users = userDao.search(name, start, length);
    List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
        userDTOs.add(convert(user));
    }
		return userDTOs;
}
    @Override
    public void changePassword(UserDTO accountDTO) {
            User userChange = userDao.get(accountDTO.getId());
            if(accountDTO != null){
                accountDTO.setPassword(accountDTO.getPassword());
            }
    }

    @Override
    public void resetPassword(UserDTO accountDTO) {
            User account = userDao.getByEmail(accountDTO.getEmail());

            if(account != null){

            }
    }

    @Override
    public void setupUserPassword(UserDTO accountDTO) {
        User user = userDao.get(accountDTO.getId());
        if (user != null) {
//            user.setPassword(PasswordGenerator.getHashString(accountDTO.getPassword()));
            userDao.update(user);
        }
    }

    @Override
    public void updateProfile(UserDTO userDTO) {
        User userUpdate = userDao.get(userDTO.getId());
        if(userUpdate != null){
            userUpdate.setDOB(DateTimeUtils.parseDate(userDTO.getDOB(),DD_MM_YYYY));
            userUpdate.setName(userDTO.getName());
            userUpdate.setAddress(userDTO.getAddress());
            userUpdate.setPhone(userUpdate.getPhone());

            userDao.update(userUpdate);
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.getByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("not found");
//        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//
//        UserPrincipal userPrincipal = new UserPrincipal(user.getUsername(), user.getPassword(), user.getEnabled(), true,
//                true, true, authorities);
//
//        userPrincipal.setId(user.getId());
//        userPrincipal.setName(user.getName());
//        userPrincipal.setRole(user.getRole());
//        userPrincipal.setPhone(user.getPhone());
//        userPrincipal.setEmail(user.getEmail());
//
//        return userPrincipal;
//    }
}

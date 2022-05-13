package com.scm.ojt.veterinarypharmacy.bl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scm.ojt.veterinarypharmacy.bl.service.UserService;
import com.scm.ojt.veterinarypharmacy.dto.CustomUserDetail;
import com.scm.ojt.veterinarypharmacy.entity.User;
import com.scm.ojt.veterinarypharmacy.persistance.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
     private UserDao userDAO;

    /**
     * <h2>saveUser</h2>
     * <p>
     * Method to save user
     * </p>
     *
     * @param theUser
     */
    @Override
    public void saveUser(User theUser) {
        userDAO.saveUser(theUser);
    }

    /**
     * <h2>getUserByName</h2>
     * <p>
     * method to get user by username
     * </p>
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        return this.userDAO.getUserByName(username);
    }

    /**
     * <h2>getAllUsers</h2>
     * <p>
     * Method to get user list
     * </p>
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDAO.getUserByName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = (UserDetails) new CustomUserDetail(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getAuthorities());
        return user;
    }

}

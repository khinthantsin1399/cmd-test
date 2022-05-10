package com.scm.ojt.veterinarypharmacy.persistance.dao;

import java.util.List;

import com.scm.ojt.veterinarypharmacy.entity.User;

public interface UserDao {
    /**
     * <h2>saveUser</h2>
     * <p>
     * Abstract method to save user
     * </p>
     * 
     * @param theUser
     * @return void
     */
    public void saveUser(User theUser);

    /**
     * <h2>getUserByName</h2>
     * <p>
     * Abstract method to get user by username
     * </p>
     * 
     * @param username
     * @return
     * @return User
     */
    public User getUserByName(String username);

    /**
     * <h2>getAllUsers</h2>
     * <p>
     * Abstract method to get user list
     * </p>
     * 
     * @return
     * @return List<User>
     */
    public List<User> getAllUsers();
}

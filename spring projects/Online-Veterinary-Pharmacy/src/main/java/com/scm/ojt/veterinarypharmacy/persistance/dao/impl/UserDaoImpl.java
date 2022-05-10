package com.scm.ojt.veterinarypharmacy.persistance.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scm.ojt.veterinarypharmacy.entity.User;
import com.scm.ojt.veterinarypharmacy.persistance.dao.UserDao;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>saveUser</h2>
     * <p>
     * Override method to save user
     * </p>
     *
     * @param theUser
     */
    @Override
    public void saveUser(User theUser) {
        this.sessionFactory.getCurrentSession().save(theUser);
    }

    /**
     * <h2>getUserByName</h2>
     * <p>
     * Override method to get user by username
     * </p>
     *
     * @param username
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public User getUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    /**
     * <h2>getAllUsers</h2>
     * <p>
     * Override method to get user list
     * </p>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}

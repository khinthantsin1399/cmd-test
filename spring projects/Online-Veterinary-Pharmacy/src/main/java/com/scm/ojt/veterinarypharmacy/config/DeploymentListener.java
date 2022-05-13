package com.scm.ojt.veterinarypharmacy.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.scm.ojt.veterinarypharmacy.entity.Authority;
import com.scm.ojt.veterinarypharmacy.entity.User;
import com.scm.ojt.veterinarypharmacy.persistance.dao.AuthorityDao;
import com.scm.ojt.veterinarypharmacy.persistance.dao.UserDao;



@Component
public class DeploymentListener {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityDao authorityDAO;

    @Autowired
    private UserDao userDAO;

    @PostConstruct
    public void addInitialData() {
   
        /*    List<Authority> adminAuthorities = new ArrayList<Authority>();
            adminAuthorities.add(authorityDao.getAuthorityByName("ADMIN"));
           @SuppressWarnings("null")
        User admin = new User((Integer) null, "admin", passwordEncoder.encode("123"),"admin@gmail.com", adminAuthorities);
            this.userDao.saveUser(admin);*/

           
            
            List<Authority> adminAuthorities = new ArrayList<Authority>();
            Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
            this.authorityDAO.saveAuthority(adminAuthority);
            adminAuthorities.add(adminAuthority);
            @SuppressWarnings("null")
            User admin = new User((Integer) null, "admin", passwordEncoder.encode("123"),"admin@gmail.com", adminAuthorities);
            this.userDAO.saveUser(admin);
        }
    }


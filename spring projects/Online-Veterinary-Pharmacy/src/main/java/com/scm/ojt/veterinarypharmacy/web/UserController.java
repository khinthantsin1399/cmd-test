package com.scm.ojt.veterinarypharmacy.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.ojt.veterinarypharmacy.bl.service.UserService;

import com.scm.ojt.veterinarypharmacy.entity.User;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value =  "/login" , method = RequestMethod.GET)
    public String ShowLoginForm(Model model) {
        User theUser = new User();
        model.addAttribute("user", theUser);
        return "login";
    }
    /**
     * <h2>listUsers</h2>
     * <p>
     * Method to get user list
     * </p>
     * 
     * @param model
     * @return
     * @return String
     */
    @GetMapping("/userList")
    public String listUsers(Model model) {
        List<User> theUsers = userService.getAllUsers();
        model.addAttribute("users", theUsers);
        return "UserList";
    }

    /**
     * <h2>showRegisterForm</h2>
     * <p>
     * Method to display register form
     * </p>
     * 
     * @param model
     * @return
     * @return String
     */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User theUser = new User();
        model.addAttribute("user", theUser);
        return "RegisterForm";
    }

    /**
     * <h2>saveUser</h2>
     * <p>
     * Method to save user
     * </p>
     * 
     * @param theUser
     * @param bindingResult
     * @return
     * @return String
     */
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "RegisterForm";
        } else {
            userService.saveUser(theUser);
            return "redirect:/userList";
        }
    }
}
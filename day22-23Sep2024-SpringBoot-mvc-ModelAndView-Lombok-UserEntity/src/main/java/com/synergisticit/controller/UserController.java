package com.synergisticit.controller;

import com.synergisticit.domain.Role;
import com.synergisticit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="userForm")
    public ModelAndView userForm() {
        ModelAndView mav = new ModelAndView("userForm");
        return mav;
    }
}

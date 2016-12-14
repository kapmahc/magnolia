package com.github.kapmahc.auth.controllers;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("auth.usersController")
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/sign-in")
    public String getSignIn() {
        return "auth/users/sign-in";
    }

    @GetMapping("/sign-up")
    public String getSignUp() {
        return "auth/users/sign-up";
    }

    @GetMapping("/unlock")
    public String getUnlock() {
        return "auth/users/unlock";
    }

    @Resource
    MessageSource messageSource;
}

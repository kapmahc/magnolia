package com.github.kapmahc.auth.controllers;

import com.github.kapmahc.auth.forms.SignInForm;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("auth.usersController")
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/sign-in")
    public String getSignIn(SignInForm signInForm) {
        return "auth/users/sign-in";
    }

    @PostMapping("/sign-in")
    public String postSignIn(@Valid SignInForm signInForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/users/sign-in";
        }

        return "redirect:/";
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

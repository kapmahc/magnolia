package com.github.kapmahc.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("site.homeController")
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}

package com.github.kapmahc.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("auth.logsController")
@RequestMapping("/logs")
public class LogsController {
    @GetMapping("/")
    public String index() {
        return "auth/logs/index";
    }
}

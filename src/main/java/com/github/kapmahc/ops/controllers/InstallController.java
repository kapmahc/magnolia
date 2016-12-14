package com.github.kapmahc.ops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("ops.installController")
@RequestMapping("/ops")
public class InstallController {
    @PostMapping("/install")
    public void postInstall() {

    }

    @GetMapping("/install")
    public String getInstall() {
        return "ops/install";
    }
}

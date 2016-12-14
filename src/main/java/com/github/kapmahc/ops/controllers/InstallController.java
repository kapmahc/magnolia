package com.github.kapmahc.ops.controllers;

import com.github.kapmahc.auth.repositories.UserRepository;
import com.github.kapmahc.ops.forms.InstallForm;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Locale;

import static com.github.kapmahc.auth.Constants.FLASH_ALERT;
import static com.github.kapmahc.auth.Constants.FLASH_NOTICE;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("ops.installController")
@RequestMapping("/ops")
public class InstallController {
    @PostMapping("/install")
    public String postInstall(@Valid InstallForm installForm, BindingResult bindingResult, RedirectAttributes redirectAttrs, Locale locale) {
        if (userRepository.count() > 0) {
            redirectAttrs.addFlashAttribute(FLASH_ALERT, messageSource.getMessage("ops.messages.database-not-empty", null, locale));
            return "redirect:/";
        }

        if (!bindingResult.hasErrors()) {
            if (!installForm.getPassword().equals(installForm.getPasswordConfirmation())) {
                bindingResult.rejectValue("password", "messages.passwords-not-match");
            }
        }
        if (bindingResult.hasErrors()) {
            return "ops/install";
        }
        redirectAttrs.addFlashAttribute(FLASH_NOTICE, "");
        return "redirect:/users/sign-in";
    }

    @GetMapping("/install")
    public String getInstall(InstallForm installForm, RedirectAttributes redirectAttrs, Locale locale) {
        if (userRepository.count() > 0) {
            redirectAttrs.addFlashAttribute(FLASH_ALERT, messageSource.getMessage("ops.messages.database-not-empty", null, locale));
            return "redirect:/";
        }
        installForm.setDomain("www.change-me.com");
        installForm.setEmail("admin@change-me.com");
        return "ops/install";
    }

    @Resource
    UserRepository userRepository;
    @Resource
    MessageSource messageSource;
}

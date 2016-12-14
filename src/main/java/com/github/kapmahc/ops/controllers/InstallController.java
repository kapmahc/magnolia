package com.github.kapmahc.ops.controllers;

import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.auth.repositories.UserRepository;
import com.github.kapmahc.auth.services.LocaleService;
import com.github.kapmahc.auth.services.PolicyService;
import com.github.kapmahc.auth.services.SettingService;
import com.github.kapmahc.auth.services.UserService;
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
import java.io.IOException;
import java.security.GeneralSecurityException;
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
    public String postInstall(@Valid InstallForm installForm, BindingResult bindingResult, RedirectAttributes redirectAttrs, Locale locale) throws IOException, GeneralSecurityException {
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

        settingService.set("site.domain", installForm.getDomain());

        User user = userService.addUser("Administrator", installForm.getEmail(), installForm.getPassword());
        userService.log(user, localeService.t("auth.logs.sign-in", null, locale));
        userService.setConfirmedAt(user.getId());
        userService.log(user, localeService.t("auth.logs.confirm", null, locale));
        for (String r : new String[]{"root", "admin"}) {
            policyService.apply(user, r);
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
    UserService userService;
    @Resource
    LocaleService localeService;
    @Resource
    PolicyService policyService;
    @Resource
    MessageSource messageSource;
    @Resource
    SettingService settingService;
}

package com.github.kapmahc.ops.controllers;

import com.github.kapmahc.auth.errors.ForbiddenException;
import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.auth.repositories.UserRepository;
import com.github.kapmahc.auth.services.LocaleService;
import com.github.kapmahc.auth.services.PolicyService;
import com.github.kapmahc.auth.services.SettingService;
import com.github.kapmahc.auth.services.UserService;
import com.github.kapmahc.ops.forms.InstallForm;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by flamen on 16-12-13.
 */
@Controller("site.installController")
@RequestMapping("/ops")
public class InstallController {
    @PostMapping("/install")
    @PreAuthorize("permitAll()")
    public String postInstall(@Valid InstallForm installForm, BindingResult bindingResult, Locale locale) throws IOException, GeneralSecurityException {
        if (userRepository.count() > 0) {
            throw new ForbiddenException();
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
        userService.log(user, messageSource.getMessage("auth.logs.sign-in", null, locale));


        user.setConfirmedAt(new Date());
        userRepository.save(user);
        userService.log(user, messageSource.getMessage("auth.logs.confirm", null, locale));

        for (String r : new String[]{"root", "admin"}) {
            policyService.apply(user, r);
        }
        return "redirect:/users/sign-in";
    }

    @GetMapping("/install")
    @PreAuthorize("permitAll()")
    public Object getInstall(InstallForm installForm) {
        if (userRepository.count() > 0) {
            throw new ForbiddenException();
        }
        installForm.setDomain("www.change-me.com");
        installForm.setEmail("admin@change-me.com");
        return "ops/install";
    }


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
    @Resource(name = "auth.userRepository")
    UserRepository userRepository;
}

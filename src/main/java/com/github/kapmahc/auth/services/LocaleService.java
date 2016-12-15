package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.models.Locale;
import com.github.kapmahc.auth.repositories.LocaleRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.localeService")
public class LocaleService {
    public void set(java.util.Locale locale, String code, String message) {
        Locale l = localeRepository.findByLangAndCode(locale.getDisplayName(), code);
        if (l == null) {
            l = new Locale();
            l.setLang(locale.getDisplayName());
            l.setCode(code);
        }
        l.setMessage(message);;
        localeRepository.save(l);
    }

    public String t(String code, Object[] args, java.util.Locale locale) {
        Locale l = localeRepository.findByLangAndCode(locale.getDisplayName(), code);
        if (l == null) {
            return messageSource.getMessage(code, args, locale);
        }
        return String.format(l.getMessage(), args);
    }

    @Resource
    MessageSource messageSource;
    @Resource
    LocaleRepository localeRepository;
}

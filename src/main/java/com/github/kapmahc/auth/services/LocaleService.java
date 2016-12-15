package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.models.Locale;
import com.github.kapmahc.auth.repositories.LocaleRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.localeService")
public class LocaleService {
    @CacheEvict(cacheNames = "locales", allEntries = true)
    public void set(java.util.Locale locale, String code, String message) {
        Locale l = localeRepository.findByLangAndCode(locale.toLanguageTag(), code);
        if (l == null) {
            l = new Locale();
            l.setLang(locale.getDisplayName());
            l.setCode(code);
        }
        l.setMessage(message);
        ;
        localeRepository.save(l);
    }

    @Cacheable(cacheNames="locales", key="(#code)/(#locale.toLanguageTag())")
    public String t(String code, Object[] args, java.util.Locale locale) {
        Locale l = localeRepository.findByLangAndCode(locale.toLanguageTag(), code);
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

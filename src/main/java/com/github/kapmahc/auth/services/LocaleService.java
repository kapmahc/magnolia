package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.ExposedResourceBundleMessageSource;
import com.github.kapmahc.auth.models.Locale;
import com.github.kapmahc.auth.repositories.LocaleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.localeService")
public class LocaleService {
    @CacheEvict(cacheNames = "locales", allEntries = true)
    @Transactional
    public void set(java.util.Locale locale, String code, String message) {
        String lang = locale.toLanguageTag();
        Locale l = localeRepository.findByLangAndCode(lang, code);
        if (l == null) {
            l = new Locale();
            l.setLang(lang);
            l.setCode(code);
        }
        l.setMessage(message);
        localeRepository.save(l);
    }

    @Cacheable(cacheNames = "locales", key = "#code+'/'+#locale.toLanguageTag()")
    @Transactional(readOnly = true)
    public String get(String code, java.util.Locale locale) {
        Locale l = localeRepository.findByLangAndCode(locale.toLanguageTag(), code);
        return l == null ? null : l.getMessage();
    }

    public void load() {
        for (String n : messageSource.getBasenameSet()) {
            for (String l : languages) {
                java.util.Locale lang = java.util.Locale.forLanguageTag(l);
                for (String c : messageSource.getKeys(n, lang)) {
                    set(lang, c, messageSource.getMessage(c, null, lang));
                }
            }
        }
    }

    @Resource
    LocaleRepository localeRepository;
    @Resource(name = "ops.messageSource")
    ExposedResourceBundleMessageSource messageSource;
    @Value("#{'${app.languages}'.split(',')}")
    List<String> languages;

}

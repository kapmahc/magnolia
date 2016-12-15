package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.models.Locale;
import com.github.kapmahc.auth.repositories.LocaleRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.localeService")
public class LocaleService {
    @CacheEvict(cacheNames = "locales", allEntries = true)
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

    @Resource
    LocaleRepository localeRepository;
}

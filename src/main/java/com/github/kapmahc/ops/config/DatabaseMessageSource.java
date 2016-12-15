package com.github.kapmahc.ops.config;

import com.github.kapmahc.auth.services.LocaleService;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * Created by flamen on 16-12-15.
 */
@Component("messageSource")
public class DatabaseMessageSource extends AbstractMessageSource {
    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String fmt = localeService.get(code, locale);
        return fmt == null ? null : createMessageFormat(fmt, locale);
    }

    @PostConstruct
    void init() {
        setParentMessageSource(messageSource);
    }

    @Resource
    LocaleService localeService;
    @Resource(name = "ops.messageSource")
    MessageSource messageSource;
}

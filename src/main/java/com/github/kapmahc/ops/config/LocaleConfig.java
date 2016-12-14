package com.github.kapmahc.ops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Created by flamen on 16-12-13.
 */
@Configuration
@EnableWebMvc
public class LocaleConfig extends WebMvcConfigurerAdapter {

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean(name = "messageSource")
    public AbstractResourceBasedMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return resource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setDefaultLocale(Locale.US);
        clr.setCookieName(LOCALE);
        clr.setCookieMaxAge(Integer.MAX_VALUE);
        clr.setLanguageTagCompliant(true);
        return clr;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName(LOCALE);
        interceptor.setLanguageTagCompliant(true);
        registry.addInterceptor(interceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        VersionResourceResolver vrr = new VersionResourceResolver().addVersionStrategy(new ContentVersionStrategy(), "/**");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/themes/bootstrap4/static/")
                .setCachePeriod(60 * 60 * 24 * 365) /* one year */
                .resourceChain(true)
                .addResolver(vrr);
    }

    // fix "o.s.web.servlet.PageNotFound"
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    private final static String LOCALE = "locale";
}

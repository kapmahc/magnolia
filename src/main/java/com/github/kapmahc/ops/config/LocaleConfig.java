package com.github.kapmahc.ops.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.Locale;

/**
 * Created by flamen on 16-12-13.
 */
@Configuration
@EnableWebMvc
public class LocaleConfig extends WebMvcConfigurerAdapter {
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename(msBasename);
        resource.setDefaultEncoding("UTF-8");
        resource.setCacheSeconds(msCacheSeconds);
        resource.setFallbackToSystemLocale(true);
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
                .addResourceLocations("classpath:/themes/" + theme + "/static/")
                .setCachePeriod(60 * 60 * 24 * 365) /* one year */
                .resourceChain(true)
                .addResolver(vrr);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    private final static String LOCALE = "locale";
    @Value("${app.theme}")
    protected String theme;
    @Value("${spring.messages.basename}")
    protected String msBasename;
    @Value("${spring.messages.cache-seconds}")
    protected int msCacheSeconds;

}

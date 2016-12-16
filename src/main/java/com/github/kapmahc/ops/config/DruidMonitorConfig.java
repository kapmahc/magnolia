package com.github.kapmahc.ops.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by flamen on 16-12-13.
 * <p>
 * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_%E9%85%8D%E7%BD%AEWebStatFilter
 */
@Configuration
public class DruidMonitorConfig {

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        return reg;
    }

    @Bean
    public FilterRegistrationBean druidFilterRegistrationBean() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setName("druid");

        frb.setFilter(new WebStatFilter());
        frb.addUrlPatterns("/*");
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        frb.addInitParameter("profileEnable", "true");
        frb.addInitParameter("sessionStatMaxCount", "1000");

        return frb;
    }
}

package org.example.ativooperante.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AccessFilter> registrationBean(){
        FilterRegistrationBean<AccessFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new AccessFilter());
        filterRegistrationBean.addUrlPatterns("/api/usuario/*", "/api/tipo/*");
        return filterRegistrationBean;
    }
}


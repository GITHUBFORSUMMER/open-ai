package com.summer.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsSettings {


    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsConfiguration cors = new CorsConfiguration();

        cors.addAllowedOriginPattern("*");
        cors.addAllowedMethod("*");
        cors.setAllowCredentials(true);
        cors.addAllowedHeader("*");
        cors.addExposedHeader("*");

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", cors);

        FilterRegistrationBean<CorsFilter> filterFilterRegistrationBean  = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource));
        filterFilterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterFilterRegistrationBean;

    }


}

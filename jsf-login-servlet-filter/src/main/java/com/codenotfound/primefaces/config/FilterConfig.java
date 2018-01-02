package com.codenotfound.primefaces.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codenotfound.primefaces.filter.LoginFilter;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean loginFilter() {
    FilterRegistrationBean registration =
        new FilterRegistrationBean();
    registration.setFilter(new LoginFilter());
    registration.addUrlPatterns("/secured/*");
    return registration;
  }
}

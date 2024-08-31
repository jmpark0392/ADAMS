package com.rds.adams.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import egovframework.com.cmm.filter.SimpleCORSFilter;
import egovframework.com.config.EgovConfigAppMapper;
import egovframework.com.config.EgovWebApplicationInitializer;

@SpringBootApplication(scanBasePackages={"com.rds.adams.web", "egovframework.com.config"}, exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages={"com.rds.adams.web", "egovframework.com.config"})
@Import({EgovWebApplicationInitializer.class, EgovConfigAppMapper.class})
public class RsfWebApplication extends SpringBootServletInitializer  {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RsfWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RsfWebApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean<SimpleCORSFilter> simpleCORSFilter() {
        FilterRegistrationBean<SimpleCORSFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SimpleCORSFilter());
        registrationBean.addUrlPatterns("/*"); // URL 패턴을 /* 로 설정
        return registrationBean;
    }
}

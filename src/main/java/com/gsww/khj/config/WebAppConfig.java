package com.gsww.khj.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //�ļ����KB,MB
        factory.setMaxFileSize("5MB");
        //�������ϴ������ܴ�С
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
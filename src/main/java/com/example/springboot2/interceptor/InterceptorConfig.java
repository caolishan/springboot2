package com.example.springboot2.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Autowired
    private InterceptorOne interceptorOne;
    @Autowired
    private InterceptorTwo interceptorTwo;
    @Autowired
    private EncodingInterceptor encodingInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorOne).addPathPatterns("/*").order(1);
        registry.addInterceptor(interceptorTwo).addPathPatterns("/*").order(2);
        registry.addInterceptor(encodingInterceptor).addPathPatterns("/*").order(0);
    }
}

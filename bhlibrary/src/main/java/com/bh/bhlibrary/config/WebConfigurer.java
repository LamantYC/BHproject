package com.bh.bhlibrary.config;

import com.bh.bhlibrary.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 17331
 */
@Component
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    @Bean
//    public LoginInterceptor getLoginInterceptor(){
//        return new LoginInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
//    }

}

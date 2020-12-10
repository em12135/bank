package com.i2finance.bank.config;

import com.i2finance.bank.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //配置类
public class InterceptorConfig implements WebMvcConfigurer {  //配置mvc需要实现WebMvcConfigurer接口
    //注入登录拦截器
    @Autowired
    private LoginInterceptor interceptor;

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(interceptor)
                //配置拦截器  要拦截的请求
                .addPathPatterns("/**")
                //不拦截的请求
                .excludePathPatterns("/user/login/**","/user/register/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

    }
}

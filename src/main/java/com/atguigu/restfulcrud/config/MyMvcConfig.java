package com.atguigu.restfulcrud.config;

import com.atguigu.restfulcrud.component.LoginHandlerInterceptor;
import com.atguigu.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName: MyMvcConfig
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/23 11:27
 * @Version 1.0
 */
// 使用WebMvcConfigureAdapter可以扩展SpringMVC的功能
//    @EnableWebMvc 接管springMVC（不要这样操作
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }

    @Bean
    public MyMvcConfig webMvcConfigurationSupport() {
        MyMvcConfig webMvcConfigurationSupport = new MyMvcConfig() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // /** 拦截任意界面的任意请求
                // 静态资源： *.css , *.js
                //springBoot 已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                    .excludePathPatterns("/index.html", "/user/login", "/static/css/**", "/webjars/**");

            }
        };
        return webMvcConfigurationSupport;
    }

    // 将我们编写的区域信息解析器放到容器中
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}

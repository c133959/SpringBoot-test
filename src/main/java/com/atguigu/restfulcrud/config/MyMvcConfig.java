package com.atguigu.restfulcrud.config;

import com.atguigu.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

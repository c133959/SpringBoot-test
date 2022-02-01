package com.atguigu.restfulcrud.config;

import com.atguigu.restfulcrud.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyServerConfig
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/2/1 12:02
 * @Version 1.0
 */
@Configuration
public class MyServerConfig {

    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
//        return new ServletRegistrationBean<>(new MyServlet(), "myServlet"); 报错

    }

    /**
     * 编写一个EmbeddedServletContainerCustomizer(2.x的接口为WebServerFactoryCustomizer
     * 定义嵌入式的servlet容器相关的规则
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(8083);
    }
}

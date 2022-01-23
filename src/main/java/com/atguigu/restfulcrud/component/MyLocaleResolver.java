package com.atguigu.restfulcrud.component;

/**
 * @ClassName: MyLocaleResolver
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/23 17:06
 * @Version 1.0
 */

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 在请求头中携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//获取请求头中l的取值
        Locale locale = Locale.getDefault();//先赋值为默认值
        if (!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

package com.atguigu.restfulcrud.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName: MyErrorAttributes
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/2/1 10:42
 * @Version 1.0
 */

//给容器中加入我们自己定义的ErrorAttribute
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        // interface WebRequest extends RequestAttributes

        // 返回值的map就是页面和JSON能获取的所有字段
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company", "atguigu");

        // 我们自定义异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);

        return map;
    }
}

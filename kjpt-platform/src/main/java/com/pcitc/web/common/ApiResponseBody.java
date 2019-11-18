package com.pcitc.web.common;

import com.pcitc.base.common.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 拦截springMVC 的@ResponseBody  填充返回对象信息
 * @author ty
 */
@ControllerAdvice
@RestControllerAdvice
public class ApiResponseBody implements ResponseBodyAdvice<Object>  {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        boolean isSupports = false;
        Class<?> cls = methodParameter.getDeclaringClass();
        if (cls.getSuperclass().equals(RestBaseController.class)) {
            isSupports = true;
        }

        //System.out.println("is support = " + isSupports);
        return isSupports;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Result result = new Result();
        result.setCode(Result.RESPONSE_SUCC_CODE);
        result.setMessage(Result.RESPONSE_SUCC_MSG);
        result.setSuccess(true);
        result.setData(o);
        return result;
    }
}


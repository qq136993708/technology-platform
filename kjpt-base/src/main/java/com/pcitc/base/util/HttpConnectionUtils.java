package com.pcitc.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;


/**
 * restTemplate发送http请求的工具类
 *
 * @author ty
 */
public class HttpConnectionUtils {
    private HttpConnectionUtils() {
    }

    /**
     * post 请求封装
     *
     * @param param  传参
     * @param URL
     * @param mediaType  参数类型，附件、表单文字
     * @return
     */

    public static Object post(final Object param, final String URL,MediaType mediaType,Class<?> className) {

        if (!StringUtils.isNotBlank(URL)) {
            return null;

        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<Object> entity = new HttpEntity<>(param,headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<?> response = restTemplate.exchange(URL, HttpMethod.POST, entity, className);
        Integer code = response.getStatusCode().value();
        if (200 != code) {

        //错误返回值处理

        }
        //JSONObject body = JSON.parseObject(response.getBody());
        //log.info("body:{}", body);
        return response.getBody();
    }



    /**
     * get请求封装
     *
     * @return
     */

    public static Object get(String url,Class<?> className) {

        if (null == url) {
            return null;
        }

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        URI uri = URI.create(url);
        //log.info(uri.toString());
        ResponseEntity<?> response = restTemplate.getForEntity(uri, className);
        Integer code = response.getStatusCode().value();
        if (200 != code) {

        //错误返回值处理

        }

       // JSONObject body = JSON.parseObject(response.getBody());
        //log.info("body:{}", body);
        return response.getBody();

    }

    /**
     * delete请求封装
     *
     * @param URL
     * @param map
     * @return
     */

    public static JSONObject delete(final String URL, final Map<String, Object> map) {

        if (!StringUtils.isNotBlank(URL)) {

            return null;

        }

        //log.info("URL:{}", URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(180000);// 设置超时
        requestFactory.setReadTimeout(180000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.DELETE, entity, String.class, map);
        Integer code = response.getStatusCode().value();

        if (200 != code) {

        //错误返回值处理

        }
        JSONObject body = JSON.parseObject(response.getBody());
        //log.info("body:{}", body);
        return body;

    }

}
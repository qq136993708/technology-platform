package com.pcitc.base.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class Tools {


    public static String getServicePath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/") + "/";
    }

    public static String getChar(int num) {
        String md = "123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ789abcd";
        Random random = new Random();
        String temp = "";
        for (int i = 0; i < num; i++) {
            temp = temp + md.charAt(random.nextInt(50));
        }
        return temp;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        return response;
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static ServletContext getServletContext() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        return webApplicationContext.getServletContext();
    }

    public static String readStream(InputStream inStream, String encoding)
            throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return new String(outSteam.toByteArray(), encoding);
    }

    public static String removeHtml(String inputStr) {
        inputStr = inputStr.replaceAll("<[a-zA-Z|//]+[1-9]?[^><]*>", "");
        inputStr = inputStr.replaceAll("&nbsp;", "");
        StringBuffer temp = new StringBuffer();
        String str = "[a-z]*[A-Z]*[0-9]*[\u4E00-\u9FA5]*[Ⅰ|,|。|，|.|：|(|)|（|）|:|/]*";
        Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        while (matcher.find()) {
            temp.append(matcher.group());
        }
        return temp.toString();
    }

}

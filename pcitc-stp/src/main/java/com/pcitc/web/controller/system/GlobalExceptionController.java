package com.pcitc.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ControllerAdvice
public class GlobalExceptionController {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
    // 文件上传路径
    @Value("${listPath}")
    private String listPath;
    /**
     * 所有异常报错
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Object handleBaseException(HttpServletRequest request, Exception exception) {
        String result = "请联系管理员！";
        String errorCode = "500";
        logger.info("GlobalException detail =={} ",exception.getStackTrace());
        logger.info("GlobalException =={} ",exception.getMessage());
        boolean isServiceException = HttpMessageNotReadableException.class.isInstance(exception);

        if(isServiceException){
            result ="服务异常！请联系管理员";
        }
        Map<String,String> resultMap = new HashMap<String,String>();
        LayuiTableData emptyTable = new LayuiTableData();
        //获取url判断是否返回json对象
        String url = request.getRequestURI();
        //判断是否首页，首页跳转错误页面;非首页传json
        if(url.indexOf("index")<0 &&
                !(exception instanceof org.springframework.web.servlet.NoHandlerFoundException)) {
            logger.info("GlobalException ==json");
            List<String> urlArray = Arrays.asList(listPath.split(";"));
            boolean check=false;
            for(String para:urlArray){
                if(url.indexOf(para)>0){
                    check=true;
                    break;
                }
            }

            if(check) {
                result = JSON.toJSONString(emptyTable);
                return result;
            }
            resultMap.put("errorCode",errorCode);
            resultMap.put("errorMessage",result);
            result =  JSON.toJSONString(resultMap);
            return result;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("errorcode",checkErrorType(exception));
            modelAndView.setViewName("/error");
            logger.info("GlobalException  ==page");
            modelAndView.addObject("exception", exception);
            return modelAndView;
        }
    }

    private String checkErrorType(Exception exception){
        Map<String,String> resultMap = new HashMap<String,String>();
        String result ="";

        if ((exception instanceof HttpMessageNotReadableException) || (exception instanceof HttpServerErrorException)) {
            resultMap.put("errorCode", "500");
            resultMap.put("errorMessage", "服务出错了");
            result = JSON.toJSONString(resultMap);
        }
        if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            resultMap.put("errorCode", "404");
            resultMap.put("errorMessage","页面出错了");
            result = JSON.toJSONString(resultMap);
        }
        return result;
    }
}

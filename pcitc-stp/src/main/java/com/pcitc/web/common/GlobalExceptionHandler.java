package com.pcitc.web.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pcitc.base.common.Result;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler 
{
	
		//private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	    /**
	     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
	     */
	    @Override
	    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	logger.error("错误.....................");
	        return new ResponseEntity<Object>(new Result(false,"ERROR","请求过程发生异常，请联系管理员!","500"),status);
	    }
	 
	    @ExceptionHandler(value = Exception.class)
	    @ResponseBody
	    public String jsonHandler(HttpServletRequest request, Exception e) {
	        logger.error("请求路径："+request.getRequestURL().toString()+"; 发生错误！");
	        log(e,request);
	        return new Result(false,"ERROR","请求过程发生异常，请联系管理员!","500").toString();
	    }
	 
	    private void log(Exception ex, HttpServletRequest request) {
	        logger.error("************************异常开始*******************************");
	        logger.error("异常信息：", ex);
	        logger.error("请求地址：" + request.getRequestURL());
	        Enumeration<?> enumeration = request.getParameterNames();
	        logger.error("请求参数");
	        while (enumeration.hasMoreElements()) {
	            String name = enumeration.nextElement().toString();
	            logger.error(name + "---" + request.getParameter(name));
	        }
	        StackTraceElement[] error = ex.getStackTrace();
	        for (StackTraceElement stackTraceElement : error) {
	            logger.error(stackTraceElement.toString());
	        }
	        logger.error("************************异常结束*******************************");
	    }
}

package com.pcitc.web.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.pcitc.base.common.Result;
import com.pcitc.base.exception.SysException;
import com.pcitc.web.utils.TokenInterUtils;


/**
 * 统一错误响应Controller
 * @author ty
 */

@RestController
@ControllerAdvice
@CrossOrigin(allowCredentials = "true")
public class ErrorController extends BaseController{


/**
	 * 一般业务性错误响应
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(value = { SysException.class })
    public Result handleException(SysException ex) {
		Result result = new Result();
		result.setSuccess(false);
		result.setCode(ex.getCode());
		result.setMessage("服务器异常,错误码"+ex.getCode());
		result.setData(ex.getMessage());
        return result;
    }
	
/**
	 * 系统错误响应
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(value = { Exception.class })
    public Result handleException(Exception ex) {
		Result result = new Result();
		result.setSuccess(false);
		result.setCode("-1");
		result.setMessage("服务器错误=" + ex.getMessage());
		TokenInterUtils.saveErrorSysLog(restTemplate, httpHeaders, this.getCurrentRequest(), this.getUserProfile(),ex.getMessage());
        return result;
    }
	
	
	
	
	

  
    
}

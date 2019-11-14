package com.pcitc.web.common;

import com.pcitc.base.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 统一错误响应Controller
 * @author ty
 */

@RestControllerAdvice
@CrossOrigin(allowCredentials = "true")
public class ErrorController extends BaseController{

/**
	 * 未登录错误响应
	 * @param ex
	 * @return
	 */

	/*@ExceptionHandler(value = { NoLogonException.class })
    public Result handleNoLogonException(NoLogonException ex) {
		Result result = new Result();
		result.setCode(NoLogonException.getCode());
		result.setMessage(StringUtils.isNotBlank(ex.getMessage())?ex.getMessage():"用户未登录或已过期");
		return result;
    }*/
	

/**
	 * 一般业务性错误响应
	 * @param ex
	 * @return
	 */

	/*@ExceptionHandler(value = { SysException.class })
    public Result handleException(SysException ex) {
		Result result = new Result();
		result.setCode(SysException.getCode());
		result.setMessage(ex.getMessage());
        return result;
    }*/
	
/**
	 * 系统错误响应
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(value = { Exception.class })
    public Result handleException(Exception ex) {
		ex.printStackTrace();
		Result result = new Result();
		result.setCode("-1");
		result.setMessage("服务器错误=" + ex.getMessage());
        return result;
    }
}

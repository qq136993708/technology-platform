package com.pcitc.web.common;

import com.pcitc.base.common.Result;
import com.pcitc.base.exception.SysException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 统一错误响应Controller
 * @author ty
 */

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
		result.setMessage(ex.getMessage());
        return result;
    }
	
/**
	 * 系统错误响应
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(value = { Exception.class })
    public Result handleException(Exception ex) {
		ex.printStackTrace();
		Result result = new Result();
		result.setSuccess(false);
		result.setCode("-1");
		result.setMessage("服务器错误=" + ex.getMessage());
        return result;
    }
}

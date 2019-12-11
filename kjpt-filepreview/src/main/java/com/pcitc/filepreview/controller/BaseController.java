package com.pcitc.filepreview.controller;

import com.pcitc.filepreview.model.BaseModel;
import com.pcitc.filepreview.model.Page;
import com.pcitc.filepreview.model.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Controller基类
 *
 * @author ty
 */
public abstract class BaseController {
	 

	/**
	 * 构建出错的返回结果
	 * @param errCode
	 * @param msg
	 * @return 
	 */
	protected Response<?> returnError(String errCode, String msg) {
        Response<?> result = new Response<>();
        result.setResCode(errCode);
        result.setResMessage(msg);
        return result;
    }
	
	/**
	 * 构建成功的返回结果
	 * @return
	 */
	protected Response<?> returnOk() {
		return returnData(null);
	}
	
	/**
	 * 构建包含一般数据的成功的返回结果
	 * @param data
	 * @return
	 */
    protected <T> Response<T> returnData(T data) {
		Response<T> result = new Response<T>();
		
		result.setResCode(Response.RESPONSE_SUCC_CODE);
		result.setResMessage(Response.RESPONSE_SUCC_MSG);
		result.setResult(data);

		return result;
	}

    /**
     * 构建分页查询结果的成功返回结果
     * @param pageData
     * @return
     */
    protected <T> Response<?> returnPage(Page<T> pageData) {
		Response<List<T>> result = new Response<List<T>>();

		result.setResCode(Response.RESPONSE_SUCC_CODE);
		result.setResMessage(Response.RESPONSE_SUCC_MSG);
		result.setResCode("0");
		result.setResult(pageData.getData());
		result.setPageNum(pageData.getPageNum());
		result.setTotal(pageData.getCount());
		result.setPageCount(pageData.getPageCount());

		return result;
	}
    
	/**
	 * 构建分页查询的成功返回结果
	 * @param data
	 * @param pageNum
	 * @param count
	 * @return
	 */
	protected <T> Response<T> returnPage(T data, int pageNum, long count) {
		Response<T> result = new Response<T>();

		result.setResCode(Response.RESPONSE_SUCC_CODE);
		result.setResMessage(Response.RESPONSE_SUCC_MSG);
		result.setResCode("0");
		result.setResult(data);
		result.setPageNum(pageNum);
		result.setTotal(count);

		return result;
	}

	/**
	 * 为基础实体对象生成唯一ID
	 * @param model
	 */
	protected void setId(BaseModel model) {
		if (StringUtils.isEmpty(model.getId())) {
			model.setId(UUID.randomUUID().toString().replace("-", ""));
		}
	}
	
	/**
	 * 为可追踪操作记录的实体对象自动追加操作记录
	 * @param model
	 */
	/*protected void setRecordData(RecordModel model) {
		AuthorityUser user = this.getCurrentUser();

		if (StringUtils.isEmpty(model.getCreateor())) {
			model.setCreateor(user.getAdAccount());
			model.setCreateDate(new Date());
		}

		if (StringUtils.isEmpty(model.getUpdator())) {
			model.setUpdator(user.getAdAccount());
			model.setUpdateDate(new Date());
		}

		this.setId(model);
	}*/

	/**
	 * 返回当前Request对象
	 * @return
	 */
	protected HttpServletRequest getCurrentRequest()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}	

	/**
	 * 返回当前Response对象
	 * @return
	 */
	protected HttpServletResponse getCurrentResponse()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	/**
	 * 返回当前登录用户
	 * @return
	 */
	/*protected AuthorityUser getCurrentUser(){
		return (AuthorityUser) this.getSessionData(OcrConstant.Session_User);
	}*/
	
	/**
	 * 返回当前Session
	 * @return
	 */
	private HttpSession getSession() {
		HttpServletRequest request = this.getCurrentRequest();
		return request.getSession();	
	}
	
	/**
	 * 查询当前Session数据
	 * @param key 键
	 * @return
	 */
	public Object getSessionData(String key) {
		return this.getSession().getAttribute(key);
	}
	
	/**
	 * 为当前Session设置数据
	 * @param key 键
	 * @param data 值
	 */
	protected void setSessionData(String key, Object data) {
		this.getSession().setAttribute(key, data);
	}
	
	/**
	 * 设置登录用户
	 * @param user
	 */
	/*protected void setCurrentUser(AuthorityUser user) {
		this.setSessionData(OcrConstant.Session_User, user);
	}*/
	
	/**
	 * 清除Session
	 */
	protected void clearSession() {
		this.getSession().invalidate();
	}
	
	/**
	 * 检查当前人的权限
	 * @param right 权限对象
	 * @throws NoPremissionException
	 * @throws NoLogonException
	 */
	/*protected void checkRight(UserRightEnum right) throws NoPremissionException, NoLogonException {

		if(hasRight(right)) {
			return;
		}

		throw new NoPremissionException(currentUserId(), right);
	}*/

	/**
	 * 判定当前人是否包含权限
	 * @param right
	 * @return
	 */
	/*protected boolean hasRight(UserRightEnum right) {

		//如果未登录则为否
		AuthorityUser su = this.getCurrentUser();
		if(su == null) {
			return false;
		}

		return su.hasRight(right);

	}*/

	/**
	 * 返回当前登录人ID
	 * @return
	 */
	/*protected String currentUserId() {
		
		AuthorityUser su = this.getCurrentUser();
		if(su == null) {
			return null;
		}
		
		return su.getId();
	}*/

	protected void setParam(Map<String, String> params, String key, String value) {
		this.setParam(params, key, value, false);
	}

	protected void setParam(Map<String, String> params, String key, String value, boolean like) {
		if (value != null) {
			params.put(key, like ? "?" + value : value);
		}
	}
}

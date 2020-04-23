package com.pcitc.base.util;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysDictionary;

public class CommonUtil {

	public static Page getPage(Page p) throws Exception {
		Page result = p;
		int listbegin = p.getPageNo() - (p.getShowPage() % 2 == 0 ? p.getShowPage() / 2 - 1 : p.getShowPage() / 2);
		int listend = p.getPageNo() + p.getShowPage() / 2;
		if (listbegin < 1) {
			listbegin = 1;
			if (p.getTotalPages() >= p.getShowPage())
				listend = p.getShowPage();
			else
				listend = p.getTotalPages();
		}
		if (listend > p.getTotalPages()) {
			listend = p.getTotalPages() + 1;
		}
		if (listend > p.getTotalPages()) {
			listend = p.getTotalPages();
			if ((listend - p.getShowPage()) > 0)
				listbegin = listend - p.getShowPage() + 1;
			else
				listbegin = 1;
		}
		System.out.println("======================起始 listbegin:" + listbegin + " listend:" + listend);
		
		result.setListbegin(listbegin);
		result.setListend(listend);
		return result;
	}
	
	public static String getParameter(HttpServletRequest request,String para,String defaultStr)
	{
		
		String resault=request.getParameter(para);
		if(resault==null || "".equals(resault))
		{
			return defaultStr;
		}else
		{
			return resault;
		}
	}
	public  static int getParameterPageNo(HttpServletRequest request) 
	{
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt((String)request.getParameter("pageNo"));
		return pageNo;
	}
	
	public static BigDecimal  getParameterBigDecimal(HttpServletRequest request,String para,BigDecimal no)
	{
		
		String resault=request.getParameter(para);
		if(resault==null || "".equals(resault))
		{
			return no;
		}else
		{
			return BigDecimal.valueOf(Long.valueOf(resault));
		}
	}
	public static Integer getParameterInt(HttpServletRequest request,String para,int no)
	{
		
		String resault=request.getParameter(para);
		if(resault==null || "".equals(resault))
		{
			return no;
		}else
		{
			return Integer.valueOf(resault);
		}
	}
	public static Long getParameterLong(HttpServletRequest request,String para,Long no)
	{
		
		String resault=request.getParameter(para);
		if(resault==null || "".equals(resault))
		{
			return no;
		}else
		{
			return Long.valueOf(resault);
		}
	}
	
	public static String getParameterTrim(HttpServletRequest request,String para,String defaultStr)
	{
		
		String resault=request.getParameter(para);
		if(resault==null || "".equals(resault))
		{
			return defaultStr.trim();
		}else
		{
			return resault;
		}
	}
	
	public  static String getRequestUrl(HttpServletRequest request) 
	{
		String querystring=request.getQueryString();
		String backUrl = "http://" + request.getServerName() //服务器地
                + ":"+ request.getServerPort()           //端口
                + request.getContextPath()      //项目名称  
                + request.getServletPath();     //请求页面或其他地
               
		if(querystring!=null && !querystring.equals(""))
		{
			backUrl=backUrl+ "?" + querystring; //参数  
		}
		return backUrl;
	}
	
	public  static JSONArray StrToJSONArray(String chkboxstr) 
	{
		JSONArray jsonObject =null;
		String chkbox[]=chkboxstr.split(",");
		if(chkbox!=null && chkbox.length>0)
		{
			 List<String> list = Arrays.asList(chkbox);
			 List<String> longList =new ArrayList();
			 if(list!=null)
			 {
				for(int i=0;i<list.size();i++)
				{
					String str=list.get(i);	
					if(str!=null && !"".equals(str))
					{
						longList.add(str);
					}
					
				}
			 }
		
	     jsonObject = JSONArray.parseArray(JSON.toJSONString(longList));
		}
		return jsonObject;
	}
	
	
	
	public  static List<String> strToList(String chkboxstr) 
	{
		List<String> longList =null;
		String chkbox[]=chkboxstr.split(",");
		if(chkbox!=null && chkbox.length>0)
		{
			 List<String> list = Arrays.asList(chkbox);
			 longList =new ArrayList();
			 if(list!=null)
			 {
				for(int i=0;i<list.size();i++)
				{
					String str=list.get(i);	
					if(str!=null && !"".equals(str))
					{
						longList.add(str);
					}
				}
			 }
		}
		return longList;
	}
	
	
	public static String getTableCode(String tableEncode,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		return "请更换CodeUtil(xx,xx,xx)获取编码";

	}
	
	public static List<SysDictionary> getDictionaryByParentCode(String parentCode,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		    String DIC_ENCODE_CREATE = "http://kjpt-zuul/system-proxy/dictionary-provider/dictionary/";
		    List<SysDictionary>  list=restTemplate.exchange(DIC_ENCODE_CREATE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), List.class).getBody();
		    return list;

	}
	/**
	 *  一次获取多个字典
	 * @param codes
	 * @param restTemplate
	 * @param httpHeaders
	 * @return
	 * @throws Exception
	 */
	public static Map<String,List<SysDictionary>> getDictionaryByParentCodes(List<String> codes,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		    String DIC_ENCODE_CREATE = "http://kjpt-zuul/system-proxy/dictionary-provider/dictionary/get-map-dicionarys";
		    ResponseEntity<?> rs = restTemplate.exchange(DIC_ENCODE_CREATE, HttpMethod.POST, new HttpEntity<Object>(codes), Map.class);
		    return (Map<String,List<SysDictionary>>)rs.getBody();
	}
	
	

	/**
	 * 文件上传回调更新文件标志
	 * @param restTemplate
	 * @param httpHeaders
	 * @param uuid
	 * @throws Exception
	 */
	public static boolean updateFileFlag(RestTemplate restTemplate,HttpHeaders httpHeaders,String uuid)
	{
		boolean b = true;
		try {
			DataOperationStatusEnum rs = restTemplate.exchange(Constant.UPDATE_FILE_FLAG + uuid,HttpMethod.POST, new HttpEntity<Object>(httpHeaders), DataOperationStatusEnum.class).getBody();
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}finally {
			return b;
		}
	}

	/**
	 * 删除表单关联文件
	 * @param restTemplate
	 * @param httpHeaders
	 * @param uuid
	 * @return
	 */
	public static boolean deleteSysFileByFormId(RestTemplate restTemplate,HttpHeaders httpHeaders,String uuid)
	{
		boolean b = true;
		try {
			DataOperationStatusEnum rs = restTemplate.exchange(Constant.DELETE_FILE_FORM + uuid,HttpMethod.POST, new HttpEntity<Object>(httpHeaders), DataOperationStatusEnum.class).getBody();
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}finally {
			return b;
		}
	}

	public static String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
	}

	public static Integer getTableParamInt(LayuiTableParam param,String paramName,Integer no)
	{
		Integer resault=null;
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(Integer)object;
		}
				
		if(resault==null )
		{
			return no;
		}else
		{
			return Integer.valueOf(resault);
		}
		
	}
	
	
	//生成8位随机数
		public static String genRandomNum() {
			int maxNum = 36;
			int i;
			int count = 0;
			char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
					'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
			StringBuffer pwd = new StringBuffer("");
			Random r = new Random();
			while (count < 8) {
				i = Math.abs(r.nextInt(maxNum));
				if (i >= 0 && i < str.length) {
					pwd.append(str[i]);
					count++;
				}
			}
			return pwd.toString();
		}
		
		
		
		
		 
		 
	/*
	 * public static String getSwSSOTokenEnumeration(HttpServletRequest
	 * request,HttpServletResponse response)throws Exception {
	 * 
	 * Enumeration headers = request.getHeaderNames(); while
	 * (headers.hasMoreElements()) { String name = (String)headers.nextElement();
	 * String value = request.getHeader(header);
	 * if("KOAL_CERT_CN".equalsIgnoreCase(header)) { name = "用户标识："; value = new
	 * String(URLDecoder.decode(value).getBytes("ISO-8859-1"), "GBK"); }else
	 * if("KOAL_CERT_O".equalsIgnoreCase(header)) { name = "组织："; value = new
	 * String(URLDecoder.decode(value).getBytes("ISO-8859-1"), "GBK"); } else {
	 * continue; } }
	 * 
	 * }
	 */
		 

}

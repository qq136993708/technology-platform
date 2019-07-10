package com.pcitc.web.controller.equipment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.FindView;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.WordUtil;

@Controller
public class SreScrapApplyController extends BaseController {
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/page";
	private static final String INSERT_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/addApplyAndItem";
	private static final String GETVIEW_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/getapplybyid/";
	private static final String GETLIST_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/selectByAppltidList/";
	
	private static final String List_view="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/Listview/";
	private static final String INVALID_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/submitInvalid/";
	private static final String DEL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/delete/";
	private static final String PURCHASE_INNER_WORKFLOW_URL = "http://pcitc-zuul/stp-proxy/stp-provider/sreScrapApply/start_inner_activity/";
	private static final String UPDATE_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/update";
	//临时导出文件目录
	private static final String TEMP_FILE_PATH = "src/main/resources/tem/";
	
	//新增报废添加路径
	private static final String ANOUNCE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/announceAdd";
	
	private static final String MODEL_URL="http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/model/";
	  
	   @RequestMapping(value = "/sre-sreScrapApply/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}

	@RequestMapping(value = "/sre-sreScrapApply/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response) {


        String id = CommonUtil.getParameter(request, "id", "");
        String modenl = CommonUtil.getParameter(request, "modenl", "");
        request.setAttribute("id", id);
        request.setAttribute("modenl", modenl);
        if(!id.equals(""))
        {
            ResponseEntity<SreScrapApply> responseEntity = restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class);
            SreScrapApply sreProjectAudit = responseEntity.getBody();
            request.setAttribute("srePurchase", sreProjectAudit);
            String documentDoc = sreProjectAudit.getDocumentdoc();
   
            String stage = sreProjectAudit.getStatus();
           
                if(documentDoc==null || documentDoc.equals(""))
                {
                    documentDoc= IdUtil.createFileIdByTime();
                }
                request.setAttribute("documentDoc", documentDoc);
          
                request.setAttribute("stage", stage);
            }
          

		return "/stp/equipment/scrapapply/upload";
	}
	@RequestMapping(value = "/sre-sreScrapApply/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		if(!unitPathIds.equals(""))
		{
			if(unitPathIds.length()>4)
			{
				parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);
				
			}
		}
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/scrapapply/scrapapply_list";
	}
    	//启动采购管理-采购申请 确认流程
	    @RequestMapping(value = "/sre-sreScrapApply/start_purchase_workflow")
	    @ResponseBody
	    public Object start_purchase_workflow(HttpServletRequest request, HttpServletResponse response) throws Exception
	    {
	        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	        String id = CommonUtil.getParameter(request, "id", "");
	        String functionId = CommonUtil.getParameter(request, "functionId", "");
	        String userIds = CommonUtil.getParameter(request, "userIds", "");
	        System.out.println("============start_purchase_workflow userIds="+userIds+" functionId="+functionId+" id="+id);

	    	SreScrapApply sreScrapApply=restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class).getBody();

	        Map<String ,Object> paramMap = new HashMap<String ,Object>();
	        paramMap.put("id", id);
	        paramMap.put("functionId", functionId);
	        paramMap.put("processInstanceName", "报废申请确认->"+sreScrapApply.getName());
	        paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
	        paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
	        paramMap.put("auditor", userIds);
	        //申请者机构信息
	        paramMap.put("applyUnitCode", sysUserInfo.getUnitCode());
	        String parentApplyUnitCode=EquipmentUtils.getUnitParentCodesByUnitCodes(sysUserInfo.getUnitCode(), restTemplate, httpHeaders);
	        paramMap.put("parentApplyUnitCode", parentApplyUnitCode);


	     HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	        //return null;
	     Result rs = this.restTemplate.exchange(PURCHASE_INNER_WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
	        return rs;
	    }
	
	/**
	 * 增加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sre-sreScrapApply/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		request.setAttribute("applyDepartName", applyDepartName);
		String id = CommonUtil.getParameter(request, "id", "");
		request.setAttribute("id",id);
		if(id=="")
		{
			return "/stp/equipment/scrapapply/scrapapply_add";
		}
		else
		{
			System.out.println(id);
			String name="";
			ResponseEntity<SreScrapApply> sreScrapApply=restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class);
			
			if(sreScrapApply!=null && sreScrapApply.getBody()!=null)
			{
				name=sreScrapApply.getBody().getName();				
			}
			request.setAttribute("name",name);
			ResponseEntity<List> selectByAppltidList=restTemplate.exchange(GETLIST_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders),List.class);
			List<FindAppltid> list = selectByAppltidList.getBody();
			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
			request.setAttribute("getList",jsonObject.toString());
			return "/stp/equipment/scrapapply/scrapapply_edit";
		}
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/sre-sreScrapApply/view/{id}")
//	public String view(@PathVariable("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		//request.setAttribute("id",id);
//			System.out.println(id);
//			String name="";
//			String documentDoc="";
//			ResponseEntity<SreScrapApply> sreScrapApply=restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class);
//			if(sreScrapApply!=null && sreScrapApply.getBody()!=null)
//			{
//				name=sreScrapApply.getBody().getName();	
//				documentDoc=sreScrapApply.getBody().getDocumentdoc();
//			}
//			request.setAttribute("name",name);        
//		    request.setAttribute("documentDoc", documentDoc);     
//			ResponseEntity<List> selectByAppltidList=restTemplate.exchange(List_view + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders),List.class);
//			List<FindAppltid> list = selectByAppltidList.getBody();
//			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
//			request.setAttribute("getList",jsonObject.toString());
//			return "/stp/equipment/scrapapply/scrapapply_view";
//	}
	
	
	
	@RequestMapping(value = "/sre-sreScrapApply/addApplyAndItem")
	@ResponseBody
	public String addApplyAndItem(HttpServletRequest request)throws Exception{
		ResponseEntity<String> responseEntity = null;
		String name = CommonUtil.getParameter(request, "name", "");
		String ids = CommonUtil.getParameter(request, "ids", "");
		String id=CommonUtil.getParameter(request, "id", "");
		FindView f=new FindView();
		f.setName(name);
		f.setIds(ids);
		f.setUserId(sysUserInfo.getUserId());
		f.setUserName(sysUserInfo.getUserName());
		f.setAddorupdate(id);
		responseEntity =restTemplate.exchange(INSERT_URL, HttpMethod.POST,new HttpEntity<FindView>(f, this.httpHeaders),String.class);
		String success ="{\"success\":\"success\"}";
		return success;
	}
	@RequestMapping(method = RequestMethod.GET,value = "/sre-sreScrapApply/submitInvalid")
	@ResponseBody
	public String submitInvalid(HttpServletRequest request)throws Exception{
		ResponseEntity<String> responseEntity = null;
		String id=CommonUtil.getParameter(request, "id", "");
		responseEntity =restTemplate.exchange(INVALID_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders),String.class);
		String success ="{\"success\":\"success\"}";
		return success;
	}
	
	  @RequestMapping(value = "/sre-sreScrapApply/updateFileDoc")
	    public String updateFileDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {

	        Result resultsDate = new Result();
	        String id = CommonUtil.getParameter(request, "id", "");
	        String stage = CommonUtil.getParameter(request, "stage", "");
	        String documentDoc = CommonUtil.getParameter(request, "documentDoc", "");

	        String resutl="";

	        int statusCodeValue = 0;
	        ResponseEntity<SreScrapApply> responseEntity = restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class);
            SreScrapApply sreProjectAudit = responseEntity.getBody();
	        if(!id.equals(""))
	        {
	        	sreProjectAudit.setStatus("20");
	                sreProjectAudit.setDocumentdoc(documentDoc);
	                ResponseEntity<String>  exchange = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreScrapApply>(sreProjectAudit, this.httpHeaders), String.class);
	                statusCodeValue = responseEntity.getStatusCodeValue();
	           
	        }
	        if (statusCodeValue==200)
	        {
	            resultsDate.setSuccess(true);
	        } else
	        {
	            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
	        }

	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	        out.println(ob.toString());
	        out.flush();
	        out.close();
	        return null;
	    }
	  
	  /**
		 * 删除
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/sre-sreScrapApply/delete/{id}")
		public String delete(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			Result resultsDate = new Result();
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			int status = responseEntity.getBody();
			logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
			if (responseEntity.getBody() == 0) {
				resultsDate = new Result(true);
			} else {
				resultsDate = new Result(false, "删除失败，请联系系统管理员！");
			}
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
			out.println(ob.toString());
			out.flush();
			out.close();
			return null;
		}
	  /* =================================生成word文档  START================================*/
	    //生成采购单word模板
	    @RequestMapping(value = "/sre-sreScrapApply/createWord/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public String createWord(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception
	    {
	        Result resultsDate = new Result();
	        String fileName=createPurchaseWord( id,"srescrapapply.ftl",  response);
	        if (!fileName.equals(""))
	        {
	            resultsDate = new Result(true);
	            download(TEMP_FILE_PATH+fileName, response);
	            deleteFile(TEMP_FILE_PATH+fileName);
	        } else {
	            resultsDate = new Result(false, "生成文件失败！");
	        }
	        return null;
	    }
	    //导出采购单word数据
	    private String  createPurchaseWord(String id,String ftlName, HttpServletResponse response)
	    {

	        String  resutl="";
	        // 文件路径
	        String filePath = TEMP_FILE_PATH;
	        // 文件名称
	        String fileName =DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02)+".doc";
	        try {
	            List<Map<String, Object>> purchaseEquipmentList = new ArrayList<Map<String, Object>>();
	            Map<String, Object> dataMap = new HashMap<String, Object>();
	          
	 
	            	ResponseEntity<List> selectByAppltidList=restTemplate.exchange(MODEL_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders),List.class);
	            	List<Map<String, Object>> list = selectByAppltidList.getBody();
	            	for (int i = 0; i < list.size(); i++) {
	            		Map<String, Object> stringObjectMap=list.get(i);
	                
	            	    String  name=stringObjectMap.get("name").toString();//申报名称
	            	    String  createUser=stringObjectMap.get("createUser").toString();//装备名称
	            	    String  applicationNumber=stringObjectMap.get("applicationNumber").toString();//资产编号
	            	    String  updateUser=stringObjectMap.get("updateUser").toString();//公司代码
	            	    String  remarks=stringObjectMap.get("remarks").toString();//申报单位
                	    String  G0NDURJ=stringObjectMap.get("g0NDURJ").toString();//使用年限
                	    String  G0SCHRW=stringObjectMap.get("g0SCHRW").toString();//资产残值
                	    String  G0LJGZYZJE=stringObjectMap.get("g0LJGZYZJE").toString();//账面净额
                	    String  G0LJDJZJJE=stringObjectMap.get("g0LJDJZJJE").toString();//预付定金
                	    String  G0NCGZYZJE=stringObjectMap.get("g0NCGZYZJE").toString();//年初购置价值
                	    String  G0LJZJJE=stringObjectMap.get("g0LJZJJE").toString();//累计折旧
                        Map<String, Object> map = new HashMap<String, Object>();

	                        map.put("name",name);         //申报名称
	                        map.put("createUser",createUser);         //装备名称
	                        map.put("applicationNumber",applicationNumber);         //资产编号
	                        map.put("updateUser",updateUser);         //公司代码
	                        map.put("remarks",remarks);      //申报单位 
	                        map.put("G0NDURJ",G0NDURJ);       //使用年限
	                        map.put("G0SCHRW",G0SCHRW);       //资产残值
	                        map.put("G0LJGZYZJE",G0LJGZYZJE);     //账面净额  
	                        map.put("G0LJDJZJJE",G0LJDJZJJE);       //预付定金
	                        map.put("G0NCGZYZJE",G0NCGZYZJE);       //年初购置价值
	                        map.put("G0LJZJJE",G0LJZJJE);       //累计折旧

	                        purchaseEquipmentList.add(map);

	                dataMap.put("purchaseEquipmentList",purchaseEquipmentList);
	            }
	            /** 生成word */
	            boolean flage= WordUtil.createWord(dataMap, ftlName, filePath, fileName);
	            if(flage==true)
	            {
	                resutl=fileName;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resutl;
	    }

	    
	    public HttpServletResponse download(String path, HttpServletResponse response)
	    {
	        try {
	            // path是指欲下载的文件的路径。
	            File file = new File(path);
	            // 取得文件名。
	            String filename = file.getName();
	            // 取得文件的后缀名。
	            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

	            // 以流的形式下载文件。
	            InputStream fis = new BufferedInputStream(new FileInputStream(path));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            // 设置response的Header
	            response.setCharacterEncoding("UTF-8");
	            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return response;
	    }




	    public  boolean deleteFile(String fileName)
	    {
	        File file = new File(fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile())
	        {
	            if (file.delete())
	            {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else
	            {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else
	        {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }
	    }
	    /* =================================生成word文档  END================================*/
		
		
	    /*******************************************修改报废新增功能*************************/
	    /**
		 * 保存-更新操作
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@ResponseBody
		@RequestMapping(method = RequestMethod.POST, value = "/sre-announceAdd/announceAdd")
		public String savePrivilege(String ids,String froname,HttpServletResponse response) throws Exception{ 
			String result = "";
			SreForApplication pplication = new SreForApplication();
			ResponseEntity<Integer> responseEntity = null;
			ResponseEntity<Integer> respo = null;
			Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
			String parentUnitPathNames = map.get("unitName");// 申报单位
			String parentUnitPathIds = map.get("unitCode");// 申报单位
			String applyDepartName = map.get("applyDepartName");// 申报部门
			String applyDepartCode = map.get("applyDepartCode");// 申报部门
			String unitPathIds= map.get("applyDepartCode");
			String unitPathNames= map.get("applyDepartName");
			SreScrapApply srescrapply = new SreScrapApply();//创建报废对象
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			srescrapply.setId(id);//报废ID
			srescrapply.setName(froname);//报废名称 
			srescrapply.setRemarks(applyDepartName);//申请单位
			srescrapply.setAuditStatus(Constant.EQUME_ZERO);//添加状态
			srescrapply.setCreateUserId(ids);//装备ID
			respo = this.restTemplate.exchange(ANOUNCE_URL, HttpMethod.POST, new HttpEntity<SreScrapApply>(srescrapply, this.httpHeaders), Integer.class);
			int statusCode = respo.getStatusCodeValue();
			if(statusCode == 200) {
				 result = "1";
			}else {
				 result = "2";
			}
			JSONObject jObject=new JSONObject();
			jObject.put("result", result);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jObject.toString());
			out.flush();
			out.close();
			return null;
			}
	    

		/**
		 * 详情
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(method = RequestMethod.GET, value = "/sre-sreScrapApply/view/{id}")
		public String view(@PathVariable("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
			//request.setAttribute("id",id);
				System.out.println(id);
				String name="";
				String documentDoc="";
				ResponseEntity<SreScrapApply> sreScrapApply=restTemplate.exchange(GETVIEW_URL + id, HttpMethod.GET,new HttpEntity<Object>(this.httpHeaders), SreScrapApply.class);
				if(sreScrapApply!=null && sreScrapApply.getBody()!=null)
				{
					name=sreScrapApply.getBody().getName();	
					documentDoc=sreScrapApply.getBody().getDocumentdoc();
				}
				SreScrapApply srescrap = sreScrapApply.getBody();
				request.setAttribute("srescrap",srescrap);
				return "/stp/equipment/scrapapply/scrapapply_view";
		}
		
		/**
		 * 详情列表
		 * 
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value = "/sre-sreScrapApply/listView")
		@ResponseBody
		public String listView(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
			
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GETLIST_URL, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			logger.info("============result" + result);
			return result.toString();
		}
}

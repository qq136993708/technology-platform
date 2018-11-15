package com.pcitc.web.controller.system;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.util.JasperHelper;
import com.pcitc.web.common.BaseController;


@RestController
public class IreportController extends BaseController {
	
	 @RequestMapping(value="/common/ireport",method=RequestMethod.POST)
     public String ireport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	//设置编码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			// 清除页面
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);

			String exportType = request.getParameter("type");// 要生成文件的格式xls、word、pdf
			String jaspername = URLDecoder.decode(request.getParameter("jaspername").toString(),"UTF-8");// jaspername
			String params_filename = URLDecoder.decode(request.getParameter("params_filename").toString(),"UTF-8");// 导出的文件id@:@名称
			String dataType = request.getParameter("datatype");//ireport的datasource类型(javabean、sql)
			String identity = request.getParameter("identity");//会签、审批
			Map map = new HashMap();
			map.put("params", params_filename);
			
			String zipname = JasperHelper.exportmain(exportType, jaspername, map, dataType,
						request, response, restTemplate, httpHeaders);

			// 打印不压缩zip包
			if (!JasperHelper.PRINT_TYPE.equals(exportType)) {
				// 判断是否多条导出
				String arrpid = map.get("params").toString();
				String arrpids[] = arrpid.split(",");
				if (arrpids.length > 1 && !"".equals(zipname)) {
					// zip包下载到本地
					String Foldername = zipname.substring(zipname.indexOf("&@&")+3);
					zipname = zipname.substring(0,zipname.indexOf("&@&"));
					JasperHelper.export(response, Foldername, zipname);
				}
			}
			return "";
	 }
}

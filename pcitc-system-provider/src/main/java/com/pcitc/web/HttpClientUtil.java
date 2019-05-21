package com.pcitc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetItemTypeEnum;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.stp.budget.BudgetTechSplit;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.system.SysMessage;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.ExcelReadUtil;
import com.pcitc.base.util.FileUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.Point;
import com.pcitc.utils.OSSUtil;
import com.pcitc.utils.StringUtils;

/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil 
{
	public String doPostFormData(String url,Map<String,String> map,String charset){
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			//httpClient = new SSLClient();
			httpClient = HttpClientBuilder.create().build();
			httpPost = new HttpPost(url);
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	public String doPostBody(String url, Object obj, String charset)
	{
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try
		{
			httpClient = HttpClientBuilder.create().build();
			httpPost = new HttpPost(url);

			StringEntity entity = new StringEntity(JSON.toJSONString(obj), Charset.forName(charset));
			entity.setContentEncoding(charset);
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			// 检验返回码
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK)
			{
				System.out.println("请求出错"+statusCode);
			}
			else
			{
				if (response != null)
				{
					HttpEntity resEntity = response.getEntity();
					if (resEntity != null)
					{
						result = EntityUtils.toString(resEntity, charset);
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
	public void createByNd(String nd) 
	{
		//创建集团单位预算表信息（空白表）
		String url = "http://localhost:8765/stp-provider/budget/budget-create-blank-grouptotal";
		BudgetInfo total = (BudgetInfo)MyBeanUtils.createDefaultModel(BudgetInfo.class);
		total.setNd(nd);
		total.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		for(int i = 0;i<10;i++) {
			doPostBody(url,total,"UTF-8");
		}
		//检索集团预算表
		url = "http://localhost:8765/stp-provider/budget/budget-info-list";
		BudgetInfo infoparam = new BudgetInfo();
		infoparam.setNd(nd);
		infoparam.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		String rs = doPostBody(url,infoparam,"UTF-8");
		System.out.println(rs);
		
		//检索集团预算表
		url = "http://localhost:8765/stp-provider/budget/budget-info-table";
		LayuiTableParam params = new LayuiTableParam();
		params.setLimit(100);
		params.setPage(1);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("nd", nd);
		param.put("budget_type", BudgetInfoEnum.GROUP_TOTAL.getCode());
		params.setParam(param);
		
		
		//测试创建集团数据
		rs = doPostBody(url,params,"UTF-8");
		JSONArray array = JSON.parseObject(rs).getJSONArray("data");
		for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) 
		{
			BudgetInfo info = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), BudgetInfo.class);
			System.out.println(info.getDataId());
			
			String [][] compnays = new String[][]{
				{"1","石油工程技术服务公司","石油","物探、测井、钻井、开发工程技术"},
				{"2","石油机械公司","机械","石油勘探开发装备研发、制造"},
				{"3","新星石油公司","其他","地热资源评价与利用技术"},
				{"4","南化集团研究院","其他","钻井液等油田化学品开发、精细化工品开发"},
				{"5","石油管理局（胜利、河南、中原等）","其他","污水处理等环保节能技术开发"},
				{"6","炼化工程（集团）公司","其他","新能源、环保等石油化工工程技术开发"}
			};
			List<Integer> ls = new ArrayList<Integer>();
			Integer totalnumber = 0;
			for(int i = 0;i<compnays.length;i++) {
				Integer t = new Random().nextInt(10)+1;
				totalnumber += t;
				ls.add(t);
			}
			
			
			
			for(int i = 0;i<compnays.length;i++) {
				String [] compnay = compnays[i];
				

				Double tNmuber = Math.floor(ls.get(i)*1d/totalnumber*info.getBudgetMoney());
				Double d = new Random().nextDouble();
				
				BudgetGroupTotal groupTotal = (BudgetGroupTotal)MyBeanUtils.createDefaultModel(BudgetGroupTotal.class);
				
				groupTotal.setBudgetInfoId(info.getDataId());
				groupTotal.setDataVersion(info.getDataVersion());
				groupTotal.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				groupTotal.setNd(info.getNd());
				groupTotal.setNo(new Integer(compnay[0]));
				groupTotal.setParentDataId(null);
				groupTotal.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				groupTotal.setXmjf(Math.floor(tNmuber*d));
				groupTotal.setZxjf(tNmuber-groupTotal.getXmjf());
				groupTotal.setDisplayName(compnay[1]);
				groupTotal.setSimpleName(compnay[2]);
				groupTotal.setRemark(compnay[3]);
				groupTotal.setDisplayCode(HanyuPinyinHelper.toPinyin(groupTotal.getDisplayName()));
				groupTotal.setLevel(0);
				
				url = "http://localhost:8765/stp-provider/budget/budget-persistence-grouptotal-item";
				doPostBody(url,groupTotal,"UTF-8");
			}
		}
	}
	/**
	 * 使用测试数据生成股份公司数据
	 * 
	 */
	public void crateStockTotalTestData() 
	{
		//创建预算表
		String url = "http://localhost:8765/stp-provider/budget/budget-create-blank-stocktotal";
		BudgetInfo info = (BudgetInfo)MyBeanUtils.createDefaultModel(BudgetInfo.class);
		info.setBudgetType(BudgetInfoEnum.STOCK_TOTAL.getCode());
		info.setCreaterId("163a05ad6df_3df71106");
		info.setCreaterName("冯波");
		info.setNd("2015");
		String rs = doPostBody(url,info,"UTF-8");
		BudgetInfo newInfo = JSON.toJavaObject(JSON.parseObject(rs), BudgetInfo.class);
		
		
		//导入预算表数据
		url = "http://localhost:8765/stp-provider/budget/save-stocktotal-item";
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try 
		{
			InputStream is = new FileInputStream(new File("D:\\test_data.xlsx"));
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			BudgetStockTotal pstock = new BudgetStockTotal();
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				Row row = iter.next();
				BudgetStockTotal stock = (BudgetStockTotal)MyBeanUtils.createDefaultModel(BudgetStockTotal.class);
				Integer no = StringUtils.isBlank(readCell(row.getCell(0)))?0:new Double(readCell(row.getCell(0))).intValue();
				stock.setNo(no);
				stock.setDisplayName(readCell(row.getCell(1)));
				stock.setYjwcTotal(new Double(readCell(row.getCell(2))));
				stock.setYjwcZbx(new Double(readCell(row.getCell(3))));
				stock.setYjwcFyx(new Double(readCell(row.getCell(4))));
				stock.setXmjfTotal(new Double(readCell(row.getCell(5))));
				stock.setXmjfZbx(new Double(readCell(row.getCell(6))));
				stock.setXmjfFyx(new Double(readCell(row.getCell(7))));
				stock.setBudgetInfoId(newInfo.getDataId());
				stock.setParentDataId(pstock.getDataId());
				stock.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
				stock.setLevel(1);
				if(no > 0) {
					stock.setLevel(0);
					stock.setParentDataId("0");
				}
				
				rs = doPostBody(url,stock,"UTF-8");
				BudgetStockTotal rsstock = JSON.toJavaObject(JSON.parseObject(rs), BudgetStockTotal.class);
				if(rsstock.getNo() >0) {
					pstock = rsstock;
				}
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * 专项预算表
	 */
	public void crateTechSplitTestData(String nd,Integer auditStatus) 
	{
		//创建预算表
		String url = "http://localhost:8765/stp-provider/budget/budget-create-blank-techsplit";
		BudgetInfo info = (BudgetInfo)MyBeanUtils.createDefaultModel(BudgetInfo.class);
		info.setCreaterId("163a05ad6df_3df71106");
		info.setCreaterName("冯波");
		info.setNd(nd);
		info.setAuditStatus(auditStatus);
		String rs = doPostBody(url,info,"UTF-8");
		BudgetInfo newInfo = JSON.toJavaObject(JSON.parseObject(rs), BudgetInfo.class);
		
		
		url = "http://localhost:8765/stp-provider/budget/save-techsplit-item";
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try 
		{
			InputStream is = new FileInputStream(new File("D:\\tech_split_data.xlsx"));
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			Integer no = 1;
			for(java.util.Iterator<Row> iter = sheet.iterator();iter.hasNext();) {
				Row row = iter.next();
				BudgetTechSplit stock = (BudgetTechSplit)MyBeanUtils.createDefaultModel(BudgetTechSplit.class);
				stock.setNo(no++);
				stock.setDisplayName(readCell(row.getCell(0)));
				stock.setJtgs(new Double(readCell(row.getCell(1))));
				//勘探院	工程院	物探院	石科院	北化院	抚研院	上海院	青岛院

				stock.setGfZsyKty(new Double(readCell(row.getCell(2))));
				stock.setGfZsyGcy(new Double(readCell(row.getCell(3))));
				stock.setGfZsyWty(new Double(readCell(row.getCell(4))));
				stock.setGfZsySky(new Double(readCell(row.getCell(5))));
				stock.setGfZsyBhy(new Double(readCell(row.getCell(6))));
				stock.setGfZsyFyy(new Double(readCell(row.getCell(7))));
				stock.setGfZsyShy(new Double(readCell(row.getCell(8))));
				stock.setGfZsyQdy(new Double(readCell(row.getCell(9))));
				stock.setGfFzgs(new Double(readCell(row.getCell(10))));
				stock.setXtw(new Double(readCell(row.getCell(11))));
				
				stock.setBudgetInfoId(newInfo.getDataId());
				stock.setParentDataId("0");
				stock.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
				stock.setLevel(0);
				
				rs = doPostBody(url,stock,"UTF-8");
				BudgetTechSplit rsstock = JSON.toJavaObject(JSON.parseObject(rs), BudgetTechSplit.class);
				
				System.out.println(JSON.toJSONString(rsstock));
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	private String readCell(Cell cell) 
	{
		String  cellVal = null;
		
		switch (cell.getCellType()) 
		{
	        case Cell.CELL_TYPE_NUMERIC:
	        	cellVal = cell.getNumericCellValue()+"";
	            break;
	        case Cell.CELL_TYPE_STRING:
	        	cellVal = cell.getStringCellValue();
	            break;
	        case Cell.CELL_TYPE_FORMULA:
	        	cellVal = cell.getRichStringCellValue().getString();
	            break;
	        case Cell.CELL_TYPE_BLANK:
	            break;
	        case Cell.CELL_TYPE_BOOLEAN:
	            break;
	        case Cell.CELL_TYPE_ERROR:
	            break;
	        default:
	            break;
        }
		return cellVal;
	}
	//测试输出数据
	public void testOutBaseData() 
	{
		String url = "http://localhost:8762/out-basedata-provider/basedata/search-org-type";
		Map<String,Object> params = new HashMap<String,Object>();
		String rs = doPostBody(url,params,"UTF-8");
		System.out.println(rs);
		
		
		url = "http://localhost:8762/out-basedata-provider/basedata/search-ics-type-code";
		rs = doPostBody(url,params,"UTF-8");
		System.out.println(rs);
		
		url = "http://localhost:8762/out-basedata-provider/basedata/search-target-type";
		rs = doPostBody(url,params,"UTF-8");
		System.out.println(rs);
		
	}
	/**
	 * 处理十条龙书记
	 * @return
	 */
	public void processProjectInfoList(){
		try 
		{
			//读取数据
			ExcelReadUtil readUtil = new ExcelReadUtil();
			List<Map<Point,Object>> listdata = readUtil.readExcelAllCellVal(new File("D:\\project\\石化盈科\\科技项目\\十条龙数据对应\\十条龙20190109-1的副本.xlsx"));
			List<List<Object>> sheetdata = readUtil.getValByRow(listdata.get(0));
			List<List<Object>> rows = sheetdata.subList(1, sheetdata.size());
			
			//System.out.println(JSON.toJSONString(sheetdata));
			//System.out.println(sheetdata.size());
			//读取文件
			String path = "D:\\dragon_files\\";
			List<File> files = FileUtil.findAllFiles(null,path,false);
			System.out.println("file size:"+files.size());
			List<Map<String,Object>> filelist = new ArrayList<Map<String,Object>>();
			for(File f:files) {
				if(!StringUtils.isNumber(f.getName().split("-")[0])) {
					continue;
				}
				Integer no = new Integer(f.getName().split("-")[0]);
				String nd = f.getAbsolutePath().substring(path.length(),path.length()+4);
				String type = f.getAbsolutePath().substring(path.length()+4, path.length()+8);
				//System.out.println(no+"  "+nd+"  "+type);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("no", no);
				map.put("nd", nd);//年度
				map.put("type", type);//类别
				map.put("file", f.getAbsolutePath());
				
				System.out.println("start... "+f.getName());
				OSSUtil.uploadFile(f, "stpfile/tendragon",f.getName());
				System.out.println("end  ... "+f.getName());
				map.put("file", "stpfile/tendragon/"+f.getName());
				
				
				filelist.add(map);
			}
			
			String url = "http://localhost:8762/out-provider/select-all-project-info";
			Map<String,Object> params = new HashMap<String,Object>();
			String rs = doPostBody(url,params,"UTF-8");
			List<OutProjectInfo> projects =  new ArrayList<OutProjectInfo>();
			
			for(java.util.Iterator<?> iter = JSON.parseArray(rs).iterator();iter.hasNext();) {
				OutProjectInfo project = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), OutProjectInfo.class);
				
				//匹配Excel中的数据 （根据年度，合同号匹配）
				List<List<Object>> infos = rows.stream().filter(a -> project.getNd().equals(a.get(0).toString().substring(0,4)))
						.filter(a -> project.getHth().equals(a.get(3).toString().trim()))
						.filter(a -> project.getXmid().equals(a.get(5).toString().trim()))
						.collect(Collectors.toList());
				Set<Integer> nos = new HashSet<Integer>();
				for(List<Object> row:infos) {
					//String nd = row.get(0).toString().substring(0,4);
					//String xmmc = row.get(5).toString().trim();
					//String hth = row.get(3).toString().trim();
					//System.out.println(nd+"  "+no+"  "+xmmc+"  "+hth);
					
					Integer no = new Double(row.get(1).toString().trim()).intValue();
					nos.add(no);
				}
				//如果有文档
				if(nos.size() >0) {
					
					//List<Map<String,Object>> filelist = new ArrayList<Map<String,Object>>();
					List<Map<String,Object>> rsdata = filelist.stream().filter(a -> nos.contains(a.get("no"))).collect(Collectors.toList());
					System.out.println(project.getDataId() +" "+project.getXmid()+" "+project.getNd()+" "+project.getHth()+" "+JSON.toJSONString(nos)+" "+JSON.toJSONString(rsdata));
					project.setDefine13(JSON.toJSONString(rsdata));
					url = "http://localhost:8762/out-provider/update-project-info";
					rs = doPostBody(url,project,"UTF-8");
					
					
					projects.add(project);
				}
				
			}
			System.out.println("project size:"+projects.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public void testSendMsg() 
	{
		String url = "http://localhost:8080/test/msg-sent";
		SysMessage msg = new SysMessage();
		msg.setUserId("163a05ad6df_3df71106");
		msg.setUserName("冯波");
		
		String rs = doPostBody(url,msg,"UTF-8");
		System.out.println(rs);
	}
	public static void main(String [] args) 
	{
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		//httpClientUtil.processProjectInfoList();
		
		httpClientUtil.testSendMsg();
		
		/*HttpClientUtil httpClientUtil = new HttpClientUtil();
		String [] nds = {"2015","2016","2017","2018","2019"} ;
		String url = "";
		for(String nd:nds) {
			httpClientUtil.createByNd(nd);
		}*/
		
		//根据往年预算创建新预算表
		/*for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) 
		{
			BudgetInfo info = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), BudgetInfo.class);
			System.out.println(info.getDataId());
			
			//根据往年预算创建新预算表
			url = "http://localhost:8765/stp-provider/budget/budget-create-template-grouptotal";
			String newrs = httpClientUtil.doPostBody(url,info,"UTF-8");
			System.out.println(newrs);
		}*/
		
		//创建集团单位预算表信息（空白表）
		/*url = "http://localhost:8765/stp-provider/budget/budget-create-blank-grouptotal";
		BudgetInfo params = (BudgetInfo) MyBeanUtils.createDefaultModel(BudgetInfo.class);
		params.setAuditStatus(WorkFlowStatusEnum.STATUS_WAITING.getCode());
		params.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		params.setNd("2018");
		params.setBudgetMoney(28000d);
		params.setDataVersion("vs-2018-02");*/
		
		
	}
}




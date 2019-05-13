package com.pcitc.web.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutIcsTypeCode;
import com.pcitc.base.stp.out.OutOrgType;
import com.pcitc.base.stp.out.OutTargetType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 第三方导入数据
 * @author fb
 *
 */
@Api(value = "OutBaseDataClient-API", description = "第三方导入基础数据")
@RestController
public class OutBaseDataClient 
{
	
	@ApiOperation(value = "组织类别数据", notes = "检索组织类别数据")
    @RequestMapping(value = "/out-basedata-provider/basedata/search-org-type", method = RequestMethod.POST)
    public Object selectOrgTypeList(@RequestBody LayuiTableParam param) {
        
		List<OutOrgType> types = new ArrayList<OutOrgType>();
		LayuiTableData rsdata = null;
		try {
        	 String [] first = {"所有","企业标准","国内标准","国外标准","国际标准"};
             String [][] secend = {
             		{},
             		{},
             		{"国家标准","行业标准","地方标准","其他标准"},
             		{"DIN德国标准","NF法国标准","JIS日本标准","ASTM美国标准","BS英国标准","GOST俄罗斯标准","其他标准"},
             		{"ISO国际标准","IEC国际电工委员会标准","其他国际标准"}
             };
             Integer no = 1;
             for(int i = 0;i<first.length;i++) {
            	 types.add(new OutOrgType((i+1)+"",first[i],"0",no++));
            	 for(int j=0;j<secend[i].length;j++) {
            		 Integer id = (i+1)*100+j;
            		 types.add(new OutOrgType((id)+"",secend[i][j],(i+1)+"",no++));
            	 }
             }
             System.out.println(JSON.toJSONString(types));
             rsdata = new LayuiTableData();
         	 rsdata.setCode(0);
         	 rsdata.setCount(types.size());
         	 rsdata.setData(types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsdata;
    }
	@ApiOperation(value = "ICS分类码", notes = "检索ICS分类码数据")
    @RequestMapping(value = "/out-basedata-provider/basedata/search-ics-type-code", method = RequestMethod.POST)
    public Object selectIcsTypeCodeList(@RequestBody LayuiTableParam param) {
        List<OutIcsTypeCode> codes = new ArrayList<OutIcsTypeCode>();
        LayuiTableData rsdata = null;
        try {
            String [] arrays = {"信息技术、办公设备","采矿和矿产品","电信","机械系统和通用部件","造纸技术","电器工程","综合、术语学、标准化、文献"
            ,"数学、自然科学","环境和保健、安全","石油及相关技术","材料储运设备","电子学","橡胶和塑料工业"		
            ,"试验","军事工程","食品技术","纺织和皮革技术","货物包装和调运"
            ,"化工技术","铁路工程","机械制造","农业","土木工程","冶金","能源和热传导工程"};
           for(int i = 0;i<arrays.length;i++) {
        	   OutIcsTypeCode code = new OutIcsTypeCode((i+1)+"",arrays[i]);
        	   codes.add(code);
           }
           System.out.println(JSON.toJSONString(codes));
           rsdata = new LayuiTableData();
       	   rsdata.setCode(0);
       	   rsdata.setCount(codes.size());
       	   rsdata.setData(codes);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsdata;
    }
	@ApiOperation(value = "中标分类", notes = "检索中标分类数据")
    @RequestMapping(value = "/out-basedata-provider/basedata/search-target-type", method = RequestMethod.POST)
    public Object selectTargetTypeList(@RequestBody LayuiTableParam param) {
        List<OutTargetType> types = new ArrayList<OutTargetType>();
        LayuiTableData rsdata = null;
        try {
        	String [] prefix = {"A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};
        	String [] names = {"综合","农业、林业","医药、卫生、劳动保护","矿业","石油","能源核技术","化工","冶金","机械","电工","电子元器件","通信、广播","仪器、仪表","工程建设","建材","公路、水路运输","铁路","车辆","船舶","航空、航天","纺织","食品","轻工、文化与生活用品","环境保护"};
        	for(int i = 0;i<prefix.length;i++) {
        		OutTargetType type = new OutTargetType((i+1)+"", prefix[i]+" "+names[i], i+1, 0, prefix[i]);
        		types.add(type);
        	}
        	System.out.println(JSON.toJSONString(types));
        	rsdata = new LayuiTableData();
        	rsdata.setCode(0);
        	rsdata.setCount(types.size());
        	rsdata.setData(types);
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsdata;
    }
}

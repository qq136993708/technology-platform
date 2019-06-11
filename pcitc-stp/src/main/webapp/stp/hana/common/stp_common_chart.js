/**
 * 标志柱状图
 * @type {{title: {text: string, x: string}, tooltip: {trigger: string}, legend: {bottom: number, data: Array}, xAxis: {type: string, data: Array}, yAxis: {type: string}, series: *[]}}
 */
var optionbar = {
    title: {
        text: '',
        x: 'center'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        bottom: 10,
        data: []
    },
    xAxis: {
        type: 'category',
        data: []
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        name: '',
        data: [],
        type: 'bar'
    }]
};


/**
 * ======================================柱 single 开始==============================================
 */
var single_bar_option = {
		
		title: {
		        text: '',
		        x: 'center'
		    },
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : [],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'直接访问',
	            type:'bar',
	            barWidth: '60%',
	            data:[]
	        }
	    ]
	};


/**
 * ======================================柱 single 结束==============================================
 */
/**
 * ======================================线柱 mutil begin==============================================
 */


/**
 * ======================================线柱 mutil end==============================================
 */


/**
 * ======================================线条begin==============================================
 */

/**
 * ======================================线条 end==============================================
 */







function barAjaxSimple_ajaxPost(url,params,echartsobj,options,formName,type,backurl,successMsg,failMsg)
{
	 $.ajax({
  	     type:type,
  	     url: url,
  	     dataType:"json",
  	     data:$("#"+formName).serialize(),
  	     async: false, 
  	     cache: false,
  	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        	  echartsobj.hideLoading();
	              //var legendDataList=JSON.stringify(result.returnData.chart1.legendDataList);
	              options.legend.data = result.returnData.legendDataList;
	              options.xAxis.data =  result.returnData.xAxisDataList;
	              options.series = result.returnData.seriesList;
	              echartsobj.setOption(options)
	          } else
	          {
	        	 layer.alert(failMsg);
	          }
		   },
		   error:function()
		   {
		    	layer.alert("网络访问错误");
		   }
    });
}








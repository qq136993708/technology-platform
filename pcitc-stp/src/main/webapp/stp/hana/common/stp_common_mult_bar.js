function load_mult_bar(url,id,title,subtext,callback)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	if(title!='')
	{
		mult_option.title.text=title;
	}
	if(subtext!='')
	{
		mult_option.title.subtext=subtext;
	}
	echartsobj.setOption(mult_option);
	echartsobj.showLoading();
	ajax_load_data(url,echartsobj,callback);
	return echartsobj;
}

var mult_option = 
{
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    legend: {
	        //data:['2016','2017','2018','2019']
	    },
	    grid: {
	        left: '3%',
	        right: '0%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	           //data : ['专利总数','国际专利','国内专利']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        /*{
	            name:'2016',
	            type:'bar',
	            data:[320, 332, 301,111,11]
	        },
	        
	        {
	            name:'2017',
	            type:'bar',
	            data:[150, 232, 201,111,12]
	        },
	        {
	            name:'2018',
	            type:'bar',
	            data:[862, 1018, 964,222,23]
	        }*/
	    ]
};

/**
 * 支持回调函数的数据请求
 * @param url
 * @param echartsobj
 * @param options
 * @param callback
 * @returns
 */
function ajax_load_data(url,echartsobj,callback)
{
	 var xAxisData=[];
	 var legendData=[];
     var series=[];  
     $.ajax({
	     type:"get",
	     url: url,
	     timeout : 9000,
	     dataType:"json",
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
	     success:function(data,status)
	      {    
		          if(data.success==true ||data.success=='true')
		          {
	        		    echartsobj.hideLoading();
	        	        var chartList=data.data.xAxisDataList;
	                    for(var i=0;i<chartList.length;i++)
	                    {
	                        xAxisData.push(chartList[i]);
	                    }
	                    var legendDataList = data.data.legendDataList;
	                    for(var i=0;i<legendDataList.length;i++)
	                    {
	                    	legendData.push(legendDataList[i]);
	                    }
	                    console.log(legendData);
	                    
	                    var seriesDataList=data.data.seriesList;
	                    for(var i=0;i<seriesDataList.length;i++)
	                    {
	                    	series.push(seriesDataList[i]);
	                    	console.log(seriesDataList[i]);
	                    }
	                    //加载数据图表
	                    echartsobj.setOption({
	                    	xAxis: {
	                            data: xAxisData
	                        },
	                        legend: {
	                	        data:legendData
	                	    }
	                        ,series: series
	                    });
	                    if(callback)
	                    {
	                    	callback(data);
	                    }
		        	        
		          } 
			   },
			   error:function()
			   {
				   layer.msg('图表加载失败');
			   },
			   complete: function (XMLHttpRequest, status) {
		            if(status == 'timeout'){
		            	 layer.msg('超时');
		            }
		        }
	    });
   
} 
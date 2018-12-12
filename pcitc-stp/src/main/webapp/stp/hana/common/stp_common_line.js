
/**
 * ======================================单线==============================================
 */

//Line-简单线条 smooth: true线是弧形
var line_single_option = {
		
		title: {
	        text: '',
	        x: 'center',
	        y: '10px',
	        textStyle: {
	            fontSize: 15,
	            fontWeight: 'normal',
	            color: '#000000'       
	        },
	        subtextStyle: {
	            color: '#7B7B7B'        
	        },
	        subtext:''
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    /*toolbox: {
            feature: {
                magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },*/
        grid: {
        	 x: 60,
  	        y: 20,
  	        x2: 10,
  	        y2: 20
	    },
	    xAxis: {
	        type: 'category',
	        data: [],
	    axisLabel:{
            interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
            //rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
           }
	    },
	    color:['#b78c01'],
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [],
	        
	        type: 'line',
            itemStyle : { normal: {label : {show: true,color:"#000",position: 'top'}}},
	        //smooth: true//线是弧形
	    }]
};
function lineSingleAjax(url, echartsobj, options) 
{
	 var xAxisData=[];  
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
		                    
		                    var seriesDataList=data.data.seriesDataList;
		                    for(var i=0;i<seriesDataList.length;i++)
		                    {
	
		                    	series.push(seriesDataList[i]);
		                    }
		                    //加载数据图表
		                    echartsobj.setOption({
		                    	xAxis: {
		                            data: xAxisData
		                        },
		                        series: [{
		                            data: series
		                        }]
		                    });
		        	        
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





//单线图
function load_single_line(url,id,title,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	line_single_option.title.text=title;
	line_single_option.title.subtext=subtext;
	echartsobj.setOption(line_single_option);
	echartsobj.showLoading();
	lineSingleAjax(url, echartsobj, line_single_option);
	return echartsobj;
}


function load_single_line_tt(id,title,xAxisData,seriesData,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	line_single_option.title.text=title;
	line_single_option.title.subtext=subtext;
	echartsobj.setOption(line_single_option);
	echartsobj.setOption({
    	xAxis: {
            data: xAxisData
        },
        series: [{
            data: seriesData
        }]
    });
	
}
/**
 * ======================================单线 end==============================================
 */

/**===============================================多线==================================*/
var mony_line_option = {
	    title: {
	        text: '',
	        x: 'center',
	        y: '10px',
	        textStyle: {
	            fontSize: 15,
	            fontWeight: 'normal',
	            color: '#000000'       
	        },
	        subtextStyle: {
	            color: '#7B7B7B'        
	        },
	        subtext:''
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    /*toolbox: {
            feature: {
                magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },*/
        grid: {
            x: 40,
            y: 30,
            x2: 30,
            y2: 20
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
	    legend: {
	        data:[],
	        top: 0,
	    },

	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: []
	    },
	    yAxis: [
	        {
	            type: 'value',
	            name: '金额（万元）',
	            min: 'dataMin',
                max:'dataMax',
                position: 'left',
                axisLabel: {
                    formatter: '{value}'
                }
	        },
	        {
	        	    type: 'value',
	                name: '百分比',
	                min: 0,
	                max:100,
	                position: 'right',
	                axisLabel: {
	                    formatter: '{value} %'
	                }
	        }
	    ],
	    series: [
	        
	    ]
	};




var mony_line_option_02 = {
	    title: {
	        text: '',
	        x: 'center',
	        y: '10px',
	        textStyle: {
	            fontSize: 15,
	            fontWeight: 'normal',
	            color: '#000000'       
	        },
	        subtextStyle: {
	            color: '#7B7B7B'        
	        },
	        subtext:''
	    },
	    tooltip: {
	        trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                crossStyle: {
                    color: '#999'
                }
            }
	    },
	    /*toolbox: {
            feature: {
                magicType: {show: true, type: ['line', 'bar']},
                saveAsImage: {show: true}
            }
        },*/
        grid: {
            top:"10.5%",
            left: '0%',
            right: '5%',
            bottom: '10%',
            containLabel: true
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
	    
	    legend: {
            type: 'scroll',
            bottom: 1,
            data:[]
        },
        

	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: []
	    },
	    yAxis: [
	        {
	            type: 'value',
	            name: '金额（万元）',
	            min: 'dataMin',
                max:'dataMax',
                position: 'left',
                axisLabel: {
                    formatter: '{value}'
                }
	        },
	        {
	        	    type: 'value',
	                name: '百分比',
	                min: 0,
	                max:100,
	                position: 'right',
	                axisLabel: {
	                    formatter: '{value} %'
	                }
	        }
	    ],
	    series: [

	    ]
	};



function get_mony_line_option_ajax(url,echartsobj, options) 
{
	
   var legends=[];     //指标
   var xAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 20000,
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        		       echartsobj.hideLoading();
	        	           var legendDataList=data.data.legendDataList;
	        	           //挨个取出类别并填入类别数组
	        	           for(var i=0;i<legendDataList.length;i++)
	        	           {
	        	               legends.push(legendDataList[i]);
	        	           }
	        	           var xAxisDataList=data.data.xAxisDataList;
	        	           for(var i=0;i<xAxisDataList.length;i++)
	        	           {

	        	           	xAxisData.push(xAxisDataList[i]);
	        	           }
	        	           var seriesList=data.data.seriesList;
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	        	           	seriesData.push({
	        	           		   type: seriesList[i].type,
	        	                   name: seriesList[i].name,
	        	                   data: seriesList[i].data,
                                       // 显示数值
								   itemStyle : { normal: {label : {show: true,color:"#000"}}}

	        	                   /*//系列中的数据标注内容    
	                               ,markPoint: {    
	                                   data: [    
	                                       {type: 'max', name: '最大值'},    
	                                       {type: 'min', name: '最小值'}    
	                                   ]    
	                               },    
	                               //系列中的数据标线内容    
	                               markLine: {    
	                                   data: [    
	                                       {type: 'average', name: '平均值'}    
	                                   ]    
	                               }    */
	                               
	                               
	        	               });
	        	           }
	        	           //加载数据图表
	        	           echartsobj.setOption({
	        	               legend: {
	        	                   data: legends
	        	               },
	        	               xAxis: [
	        	                   {
	        	                       type: 'category',
	        	                       data: xAxisData
	        	                   }
	        	               ],
	        	               series: seriesData
	        	           });
	        	           console.log(options);
	        	       
	          } else
	          {
	        	 layer.alert(failMsg);
	          }
		   },
		   error:function()
		   {
		    	layer.alert("网络访问错误");
		   },
		   complete: function (XMLHttpRequest, status) {
	            if(status == 'timeout'){
	            	 layer.msg('超时');
	            }
	        }
		  
  });
   
} 


function load_mony_line(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	mony_line_option.title.text=title;
	mony_line_option.title.subtext=subtext;
	mony_line_option.yAxis=yAxis;
	echartsobj.setOption(mony_line_option);
	echartsobj.showLoading();
	get_mony_line_option_ajax(url,echartsobj, mony_line_option);
	return echartsobj;
}




function load_mony_line_down(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	mony_line_option_02.title.text=title;
	mony_line_option_02.title.subtext=subtext;
	mony_line_option_02.yAxis=yAxis;
	echartsobj.setOption(mony_line_option_02);
	echartsobj.showLoading();
	get_mony_line_option_ajax(url,echartsobj, mony_line_option_02);
	return echartsobj;
}
function load_mony_line_one(url,id,title,subtext,yAxis)
{
    var echartsobj = echarts.init(document.getElementById(id));
    mony_line_option_02.title.text=title;
    mony_line_option_02.title.subtext=subtext;
    mony_line_option_02.yAxis=yAxis;
    mony_line_option_02.color=["#9799ec","#b68d01"];
    echartsobj.setOption(mony_line_option_02);
    echartsobj.showLoading();
    get_mony_line_option_ajax(url,echartsobj, mony_line_option_02);
    return echartsobj;
}



function load_mony_line_tt(id,title,legends,xAxisData,yAxis,seriesData,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	mony_line_option.title.text=title;
	mony_line_option.yAxis=yAxis;
	mony_line_option.title.subtext=subtext;
	echartsobj.setOption(mony_line_option);
	echartsobj.setOption({
         legend: {
             data: legends
         },
         xAxis: [
             {
                 type: 'category',
                 data: xAxisData
             }
         ],
         series: seriesData
     });
}

/**===============================================多线 end==================================*/




/**==============================================堆叠区域图===============================*/


var option_dt = {
		title: {
	        text: '',
	        x: 'center',
	        y: '10px',
	        textStyle: {
	            fontSize: 15,
	            fontWeight: 'normal',
	            color: '#000000'       
	        },
	        subtextStyle: {
	            color: '#7B7B7B'        
	        },
	        subtext:''
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'shadow',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {
	        data:[],
	        bottom: 5,
	    },
	    /*toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },*/
	    grid: {

            top:"10%",
            left: '0%',
            right: '3%',
            bottom: '10%',
            containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : [],
	            axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }
	        }
	    ],
	    yAxis : [
	        {
	            //type : 'value'
	        }
	    ],
	    series : [
	    ]
	};


function get_mony_line_option_ajax_dt(url,echartsobj, options) 
{
	
   var legends=[];     //指标
   var xAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 20000,
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        		       echartsobj.hideLoading();
	        	           var legendDataList=data.data.legendDataList;
	        	           //挨个取出类别并填入类别数组
	        	           for(var i=0;i<legendDataList.length;i++)
	        	           {
	        	               legends.push(legendDataList[i]);
	        	           }
	        	           var xAxisDataList=data.data.xAxisDataList;
	        	           for(var i=0;i<xAxisDataList.length;i++)
	        	           {

	        	           	xAxisData.push(xAxisDataList[i]);
	        	           }
	        	           var seriesList=data.data.seriesList;
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	        	           	seriesData.push({
	        	           		   type: seriesList[i].type,
	        	                   name: seriesList[i].name,
	        	                   data: seriesList[i].data,
	        	                   areaStyle: seriesList[i].areaStyle,
	        	                   stack: seriesList[i].stack,
	        	                   smooth: seriesList[i].smooth,
	        	                   color: seriesList[i].color,
                                   itemStyle : { normal: {label : {show: true,color:"#000"}}},
	        	                   /*//系列中的数据标注内容    
	                               ,markPoint: {    
	                                   data: [    
	                                       {type: 'max', name: '最大值'},    
	                                       {type: 'min', name: '最小值'}    
	                                   ]    
	                               },    
	                               //系列中的数据标线内容    
	                               markLine: {    
	                                   data: [    
	                                       {type: 'average', name: '平均值'}    
	                                   ]    
	                               }    */
	                               
	                               
	        	               });
	        	           }
	        	           //加载数据图表
	        	           echartsobj.setOption({
	        	               legend: {
	        	                   data: legends
	        	               },
	        	               xAxis: [
	        	                   {
	        	                       type: 'category',
	        	                       data: xAxisData
	        	                   }
	        	               ],
	        	               series: seriesData
	        	           });
	        	           console.log(options);
	        	       
	          } else
	          {
	        	 layer.alert(failMsg);
	          }
		   },
		   error:function()
		   {
		    	layer.alert("网络访问错误!");
		   },
		   complete: function (XMLHttpRequest, status) {
	            if(status == 'timeout'){
	            	 layer.msg('超时');
	            }
	        }
		  
  });
   
} 


function load_mony_line_dt(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	option_dt.title.text=title;
	option_dt.title.subtext=subtext;
	if(yAxis!='')
	{
		option_dt.yAxis=yAxis;
	}
	echartsobj.setOption(option_dt);
	echartsobj.showLoading();
	get_mony_line_option_ajax_dt(url,echartsobj, option_dt);
	return echartsobj;
}

/**==============================================堆叠区域图 end===============================*/

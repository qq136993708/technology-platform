/**===============================================单柱图 =================================*/

var option_bar_single = {
		
		title : {
	        text: '',
	        x:'center',
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
	    grid: {
	    	  x: 40,
	            y: 30,
	            x2: 30,
	            y2: 60
	    },
	    tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
	    xAxis: {
	        type: 'category',
	        data: [],
	        axisLabel:{
                interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                rotate:-30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
               }
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: []
	};






function barAjax_single(url,  echartsobj, options) 
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
		                            data: series,
		                            type: 'bar',
		                            barWidth:20
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


//单图
function load_single_bar(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	option_bar_single.title.text=title;
	option_bar_single.title.subtext=subtext;
	
	if(yAxis!=null && yAxis!='')
	{
		option_bar_single.yAxis=yAxis;
	}
	
	
	echartsobj.setOption(option_bar_single);
	echartsobj.showLoading();
	barAjax_single(url, echartsobj, option_bar_single);
	return echartsobj;
}


//假的
function load_single_bar_tt(id,title,xAxisData,seriesdata,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	option_bar_single.title.text=title;
	option_bar_single.title.subtext=subtext;
	echartsobj.setOption(option_bar_single);
	//echartsobj.showLoading();
	 echartsobj.setOption({
         xAxis: [
             {
                 type: 'category',
                 data: xAxisData
             }
         ],
         series: [{
	        data: seriesdata,
	        type: 'bar'
	    }]
     });
}

/**===============================================单 柱图 =================================*/

/**===============================================多柱图 =================================*/




var mutl_bar = {
        title: {
            text: '',
            x:'center',
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
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        grid: {
        	  x: 40,
              y: 60,
              x2: 30,
              y2: 40
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
        legend: {
            type: 'scroll',
            top: 0,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }

            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额（万元）',
                min: 'dataMin',
                max:'dataMax',
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [

        ]
    };




var mutl_bar_bottom = {
        title: {
            text: '',
            x:'center',
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
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        grid: {
        	  x: 40,
              y: 60,
              x2: 30,
              y2: 60
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
        legend: {
            type: 'scroll',
            bottom: 1,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }

            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额（万元）',
                min: 'dataMin',
                max:'dataMax',
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [

        ]
    };






var mutl_bar_stack = {
        title: {
            text: '',
            x:'center',
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
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        grid: {
        	  x: 40,
              y: 60,
              x2: 30,
              y2: 40
	    },
	    color:['#6592b2', '#FF8849','#3FBB49','#e8a791','#b5c26a','#d59981'],
        legend: {
            type: 'scroll',
            top: 0,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }

            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额（万元）',
                min: 'dataMin',
                max:'dataMax',
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [

        ]
    };





//柱图 
function load_mutl_bar(url,id,title,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	mutl_bar.title.text=title;
	mutl_bar.title.subtext=subtext;
	echartsobj.setOption(mutl_bar);
	echartsobj.showLoading();
	barLineAjax(url,echartsobj, mutl_bar);
}

function load_mutl_bar_02(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	
	if(title!=null && title!='')
	{
		
		mutl_bar.title.text=title;
	}
	if(subtext!=null && subtext!='')
	{
		
		mutl_bar.title.subtext=subtext;
	}

    mutl_bar.grid={
        left: '0%',
        right: '3%',
        bottom: '0',
        containLabel: true
	}
	
	if(yAxis!=null && yAxis!='')
	{
		mutl_bar.yAxis=yAxis;
	}
    echartsobj.clear();
	echartsobj.setOption(mutl_bar);
	echartsobj.showLoading();
	barLineAjax(url,echartsobj, mutl_bar);
	return echartsobj;
}


// barLineAjax返回DATA,指标在下方
function load_mutl_bar_03(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	if(title!=null && title!='')
	{
		mutl_bar_bottom.title.text=title;
	}
	if(subtext!=null && subtext!='')
	{
		mutl_bar_bottom.title.subtext=subtext;
	}

	if(yAxis!=null && yAxis!='')
	{
		mutl_bar_bottom.yAxis=yAxis;
	}
    echartsobj.clear();
	echartsobj.setOption(mutl_bar_bottom);
	echartsobj.showLoading();
	var data=barLineAjax_03(url,echartsobj, mutl_bar_bottom);
	return data;
}




function load_mutl_bar_2(url,id,title,subtext,yAxis)
{
    var echartsobj = echarts.init(document.getElementById(id));

    if(title!=null && title!='')
    {

        mutl_bar.title.text=title;
    }
    if(subtext!=null && subtext!='')
    {

        mutl_bar.title.subtext=subtext;
    }

    mutl_bar.grid={
        left: '0%',
        right: '0.5%',
        bottom: '0',
        containLabel: true
    }

    if(yAxis!=null && yAxis!='')
    {
        mutl_bar.yAxis=yAxis;
    }
    echartsobj.setOption(mutl_bar);
    echartsobj.showLoading();
    barLineAjax(url,echartsobj, mutl_bar);
    
    return echartsobj;
    
}




function load_mutl_bar_stack(url,id,title,subtext,yAxis)
{
    var echartsobj = echarts.init(document.getElementById(id));

    if(title!=null && title!='')
    {

    	mutl_bar_stack.title.text=title;
    }
    if(subtext!=null && subtext!='')
    {

    	mutl_bar_stack.title.subtext=subtext;
    }

    mutl_bar_stack.grid={
        left: '0%',
        right: '0.5%',
        bottom: '0',
        containLabel: true
    }

    if(yAxis!=null && yAxis!='')
    {
    	mutl_bar_stack.yAxis=yAxis;
    }
    echartsobj.setOption(mutl_bar_stack);
    echartsobj.showLoading();
    barLineAjax_Stack(url,echartsobj, mutl_bar_stack);
    
    return echartsobj;
    
}

function load_mutl_bar_tt(id,title,legends,xAxisData,yAxis,seriesData,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	mutl_bar.title.text=title;
	mutl_bar.title.subtext=subtext;
	if(yAxis!=null && yAxis!='')
	{
		mutl_bar.yAxis=yAxis;
	}
	echartsobj.setOption(mutl_bar);
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
function load_mutl_bar_yy(id,title,legends,xAxisData,yAxis,seriesData,subtext)
{
    var echartsobj = echarts.init(document.getElementById(id));
    mutl_bar.title.text=title;
    mutl_bar.title.subtext=subtext;
    mutl_bar.grid={
        x: 40,
        y: 60,
        x2: 50,
        y2: 42
    }
    if(yAxis!=null && yAxis!='')
    {
        mutl_bar.yAxis=yAxis;
    }
    echartsobj.setOption(mutl_bar);
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
/**===============================================多柱图 end==================================*/


/**===============================================多柱堆叠图 返回DATA ==================================*/






var mutl_bar_stack_02 = {
        title: {
            text: '',
            x:'center',
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
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        grid: {
        	  x: 60,
              y: 60,
              x2: 60,
              y2: 60
	    },
	    color:['#6592b2', '#FF8849','#3FBB49','#e8a791','#b5c26a','#d59981'],
        legend: {
            type: 'scroll',
            bottom: 1,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }

            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额（万元）',
                min: 'dataMin',
                max:'dataMax',
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [

        ]
    };


//barLineAjax返回DATA,指标在下方
function load_mutl_bar_stack_02(url,id,title,subtext,yAxis)
{
 var echartsobj = echarts.init(document.getElementById(id));

 if(title!=null && title!='')
 {

	 mutl_bar_stack_02.title.text=title;
 }
 if(subtext!=null && subtext!='')
 {

	 mutl_bar_stack_02.title.subtext=subtext;
 }

 if(yAxis!=null && yAxis!='')
 {
	 mutl_bar_stack_02.yAxis=yAxis;
 }
 echartsobj.setOption(mutl_bar_stack_02);
 echartsobj.showLoading();
 var data=barLineAjax_Stack_02(url,echartsobj, mutl_bar_stack_02);
 return data;
 
}

function barLineAjax_Stack_02(url,  echartsobj, options) 
{
	
   var legends=[];     //指标
   var xAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   var dataresutl;
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 11000,
	     async:false, 
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        		       echartsobj.hideLoading();
	        		       dataresutl=data.data;
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
	        	                   stack:seriesList[i].stack,
	        	                   itemStyle:seriesList[i].itemStyle,
	        	                   barWidth:20
	        	                   ,yAxisIndex: seriesList[i].yAxisIndex
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
   return dataresutl;
   
} 

/**===============================================多柱堆叠图 end==================================*/





/**===============================================柱线组合==================================*/



var optionbarline = {
        title: {
            text: '',
            x:'center',
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
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        /*toolbox: {
            feature: {
                magicType: {show: true, type: ['line', 'bar']}
                saveAsImage: {show: true}
            }
        },*/
        grid: {
        	  x: 40,
              y: 30,
              x2: 30,
              y2: 60
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
        legend: {
            type: 'scroll',
            bottom: 10,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: []
                
            }
        ],
        yAxis: [
        	
        	
            {
                type: 'value',
                name: '金额（万元）',
                min: 0,
                max:'dataMax',
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '百分比',
                min: 0,
                max:100,
                axisLabel: {
                    formatter: '{value} %'
                }
            }
        ],
        series: [

        ]
    };

function barLineAjax(url,  echartsobj, options) 
{
	
   var legends=[];     //指标
   var xAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 11000,
	     async:false, 
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
	        	                   barWidth:20
	        	                   ,yAxisIndex: seriesList[i].yAxisIndex
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

function barLineAjax_03(url,  echartsobj, options) 
{
	
   var legends=[];     
   var xAxisData=[];  
   var seriesData=[]; 
   var dataresutl;
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 11000,
	     async:false, 
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        		       echartsobj.hideLoading();
	        		       dataresutl=data.data;
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
	        	                   barWidth:20
	        	                   ,yAxisIndex: seriesList[i].yAxisIndex
	                               
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
   return dataresutl;
   
} 


function barLineAjax_Stack(url,  echartsobj, options) 
{
	
   var legends=[];     //指标
   var xAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 11000,
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
	        	                   stack:seriesList[i].stack,
	        	                   itemStyle:seriesList[i].itemStyle,
	        	                   barWidth:20
	        	                   ,yAxisIndex: seriesList[i].yAxisIndex
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





//柱线组合
function load_bar_line(url,id,title,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	optionbarline.title.text=title;
	optionbarline.title.subtext=subtext;
	echartsobj.setOption(optionbarline);
	echartsobj.showLoading();
	barLineAjax(url,echartsobj, optionbarline);
}

function load_bar_line_tt(id,title,legends,xAxisData,seriesData,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	optionbarline.title.text=title;
	optionbarline.title.subtext=subtext;
	echartsobj.setOption(optionbarline);
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

/**===============================================柱线组合 end==================================*/




/**===============================================正负柱状图==================================*/
var option_zhengfu = {
		 title: {
	            text: '',
	            x:'center',
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
	        axisPointer : {            
	            type : 'shadow'
	        }
	    },
	    /*toolbox: {
            feature: {
                magicType: {show: true, type: ['line', 'bar']}
                saveAsImage: {show: true}
            }
        },*/
        color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
	    legend: {
	    	  bottom: 4,
	        data:[]
	    },
	    xAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    yAxis : [
	        {
	            type : 'category',
	            axisTick : {show: false},
	            data : []
	        }
	    ],
	    series : [
	    ]
	};



function barLine_zhengfu_Ajax(url,  echartsobj, options) 
{
	
   var legends=[];     //指标
   var yAxisData=[];   //X轴名称
   var seriesData=[];  //X轴数据
   $.ajax({
	     type:"GET",
	     url: url,
	     dataType:"json",
	     timeout : 10000,
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
	        	           var yAxisDataList=data.data.yAxisDataList;
	        	           for(var i=0;i<yAxisDataList.length;i++)
	        	           {

	        	           	yAxisData.push(yAxisDataList[i]);
	        	           }
	        	           var seriesList=data.data.seriesList;
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	        	           	seriesData.push({
	        	           		   type: seriesList[i].type,
	        	                   name: seriesList[i].name,
	        	                   data: seriesList[i].data
	        	               });
	        	           }
	        	           //加载数据图表
	        	           echartsobj.setOption({
	        	               legend: {
	        	                   data: legends
	        	               },
	        	               yAxis: [
	        	                   {
	        	                       type: 'category',
	        	                       data: yAxisData
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



function load_bar_zhengfu(url,id,title,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	option_zhengfu.title.text=title;
	option_zhengfu.title.subtext=subtext;
	echartsobj.setOption(option_zhengfu);
	echartsobj.showLoading();
	barLine_zhengfu_Ajax(url,echartsobj, option_zhengfu);
	return echartsobj;
}	
function load_bar_zhengfu_tt(id,title,subtext,legends,yAxisData,seriesData)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	option_zhengfu.title.text=title;
	option_zhengfu.title.subtext=subtext;
	echartsobj.setOption(option_zhengfu);
	  echartsobj.setOption({
          legend: {
              data: legends
          },
          yAxis: [
              {
                  type: 'category',
                  data: yAxisData
              }
          ],
          series: seriesData
      });
}

/**===============================================正负柱状图 end==================================*/







/**==============================================排名 =================================*/
var  option_level = {
		title: {
            text: '',
            x:'center',
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
	            type: 'shadow'
	        }
	    },
	    grid: {
	    	  x: 40,
	            y: 30,
	            x2: 30,
	            y2: 60
	    },
	    xAxis: {
	        type: 'value',
	        axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
	            interval: 0,
	            rotate: -30,
	            textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                color: '#333'
	            }
	        }

	    },
	    yAxis: {
	        type: 'category',
	        data: []
	    },
	    series: [
	        {
	            type: 'bar',
	            data: []
	        }
	    ]
	};
   


//假的
function load_single_bar_option_level_tt(id,title,yAxisData,seriesdata,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	option_level.title.text=title;
	option_level.title.subtext=subtext;
	echartsobj.setOption(option_level);
	//echartsobj.showLoading();
	 echartsobj.setOption({
		 yAxis: [
             {
                 type: 'category',
                 data: yAxisData
             }
         ],
         series: [{
	        data: seriesdata,
	        type: 'bar'
	    }]
     });
}

/**===============================================排名 end =================================*/






function getNowFormatDate(str)
{
	var yearv=str.substring(0,4);
	var monthv=str.substring(4,6);
	var resutt=yearv+"年"+monthv+"月"; 
	return resutt;
	
}

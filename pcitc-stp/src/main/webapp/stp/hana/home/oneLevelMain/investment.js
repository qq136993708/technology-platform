

var mutl_bar_investment = {
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
                type: 'shadow',
                crossStyle: {
                    color: '#999'
                }
            },
            formatter: function(params, ticket, callback) {
            	 var relVal = params[0].name+"<br/>";
            	 relVal += params[0].seriesName+ ' : ' + params[0].value+"亿元<br/>";
            	 relVal += params[1].seriesName+ ' : ' +params[1].value+"亿元<br/>";
            	 relVal += params[2].seriesName+ ' : ' + params[2].value+"%";
            	 return relVal;;
            }
        },
        /*grid: {
        	  x: 80,
              y: 80,
              x2: 80,
              y2: 80
	    },*/
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
                    interval:0,
                    //rotate:30,
                   }

            }
        ],
        
        yAxis: [
            {
            	 type: 'value',
                 name: '亿元',
                 //min: 0,
                 //interval: 10,
                 //max:'dataMax',
                 position: 'left',
                 axisLabel: {
                     formatter: '{value}'
                 }
            },
            {
                type: 'value',
                show: true ,
                name: '百分比',
                //min: 0,
                //max: 100,
                //interval: 20,
                position: 'right',
                axisLabel: {
                    formatter: '{value}%'
                }
            }
        ],
        
        
        series: [

        ]
    };

function barLineAjax_investment(url,  echartsobj, options,width)
{
	
   var legends=[];     
   var xAxisData=[];   
   var seriesData=[];  
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
	        	           if(width!=undefined && width!="" && width!=null){
	        	           		var barWidth=width
						   }else{
                               var barWidth=20
						   }
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	        	        		      seriesData.push({
		        	           		   type: seriesList[i].type,
		        	                   name: seriesList[i].name,
		        	                   data: seriesList[i].data,
		        	                  stack:seriesList[i].stack,
		        	                   barWidth:barWidth,
                                       label: {
                                           show: true, //开启显示
                                           position: 'top', //在上方显示
                                           textStyle: { //数值样式
                                               color: 'black',
                                               fontSize: 14
                                           }
                                       }
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
	        	 
	          }
		   },
		   error:function()
		   {
		    	layer.alert("网络访问错误");
		   },
		   complete: function (XMLHttpRequest, status) 
		   {
	            if(status == 'timeout')
	            {
	            	 layer.msg('超时');
	            }
	       }
		  
  });
} 


function load_mutl_bar_investment(url,id,title,subtext,yAxis,color,width)
{
    var echartsobj = echarts.init(document.getElementById(id));

    if(title!=null && title!='')
    {

    	mutl_bar_investment.title.text=title;
    }
    if(subtext!=null && subtext!='')
    {

    	mutl_bar_investment.title.subtext=subtext;
    }
	if(color!=undefined && color!=""){
        mutl_bar_investment.color=color;
	}
    mutl_bar_investment.grid={
    	top:'10%',
        left: '0%',
        right: '0.5%',
        bottom: '10%',
        containLabel: true
    }

    if(yAxis!=null && yAxis!='')
    {
    	mutl_bar_investment.yAxis=yAxis;
    }
    echartsobj.setOption(mutl_bar_investment);
    echartsobj.showLoading();
    barLineAjax_investment(url,echartsobj, mutl_bar_investment,width);
    
    return echartsobj;
    
}


/**================================================ 堆叠 =========================================*/

var option_dt_investment = {
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
	    	
	    	x: 80,
  	        y: 80,
  	        x2: 80,
  	        y2: 80
	    },
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : [],
	            axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    //rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
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

function get_mony_line_option_ajax_dt_investment(url,echartsobj, options) 
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
	        	                   color: seriesList[i].color
	        	                   //系列中的数据标注内容    
	                               /*,markPoint: {    
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
	                               }  */ 
	                               
	                               
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
function 	load_mony_line_dt_investment(url,id,title,subtext,yAxis,rotate)
{
	var echartsobj = echarts.init(document.getElementById(id));
	option_dt_investment.title.text=title;
	option_dt_investment.title.subtext=subtext;
	if(yAxis!='')
	{
		option_dt_investment.yAxis=yAxis;
	}
	option_dt_investment.grid={
	        top:"12%",
	        left: '0%',
	        right: '6%',
	        bottom: '12%',
	        containLabel: true
	    }
    if(rotate==undefined){
        option_dt_investment.xAxis=[{
            type: 'category',
            boundaryGap : false,
            axisLabel:{
                interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                rotate:0,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
            }
        }]
    }else {
        option_dt_investment.xAxis=[{
            type: 'category',
            boundaryGap : false,
            axisLabel:{
                interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                rotate:-30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
            }
        }]
    }
	echartsobj.setOption(option_dt_investment);
	echartsobj.showLoading();
	get_mony_line_option_ajax_dt_investment(url,echartsobj, option_dt_investment);
	return echartsobj;
}


/**================================================ 堆叠 end=========================================*/


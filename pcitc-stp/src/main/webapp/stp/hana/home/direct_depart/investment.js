

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
            }
        },
        grid: {
        	  x: 80,
              y: 80,
              x2: 80,
              y2: 80
	    },
	    color:['#6592b2', '#54b6e9','#70b1aa','#e8a791','#b5c26a','#d59981'],
	    
	   
	    
	    
        legend: {
            type: 'scroll',
            bottom: 0,
            data:[]
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisLabel:{
                    interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
                    //rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
                   }

            }
        ],
        
        yAxis: [
            {
            	 type: 'value',
                 name: '金额（万元）',
                 min: 0,
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
                max: 100,
                interval: 5,
                position: 'right',
                axisLabel: {
                    formatter: '{value}%'
                }
            }
        ],
        
        
        series: [

        ]
    };

function barLineAjax_investment(url,  echartsobj, options) 
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
	        	           var legendDataList=data.data.barLine.legendDataList;
	        	           //挨个取出类别并填入类别数组
	        	           for(var i=0;i<legendDataList.length;i++)
	        	           {
	        	               legends.push(legendDataList[i]);
	        	           }
	        	           var xAxisDataList=data.data.barLine.xAxisDataList;
	        	           for(var i=0;i<xAxisDataList.length;i++)
	        	           {
	        	        		   xAxisData.push(xAxisDataList[i]);
	        	           }
	        	           var seriesList=data.data.barLine.seriesList;
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	        	        		      seriesData.push({
		        	           		   type: seriesList[i].type,
		        	                   name: seriesList[i].name,
		        	                   data: seriesList[i].data,
		        	                   stack:seriesList[i].stack,
                                       itemStyle : { normal: {label : {show: true,color:"#000"}}},
		        	                   barWidth:20
		        	                   ,yAxisIndex: seriesList[i].yAxisIndex
		        	                 });
	        	        	   /*if(name=='总计')
	        	        	   {
	        	        		   $("#bar1_all_count").html(allCount);
	        	        		   $("#bar1_all_count").html(allCount);
	        	        		   $("#bar1_all_count").html(allCount);
	        	        		   $("#bar1_all_count").html(allCount);
	        	        	   }*/
	        	           	
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
		   complete: function (XMLHttpRequest, status) {
	            if(status == 'timeout'){
	            	 layer.msg('超时');
	            }
	        }
		  
  });
   
} 
function load_mutl_bar_investment(url,id,title,subtext,yAxis)
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

    mutl_bar_investment.grid={
        top:"10%",
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
    barLineAjax_investment(url,echartsobj, mutl_bar_investment);
    
    return echartsobj;
    
}

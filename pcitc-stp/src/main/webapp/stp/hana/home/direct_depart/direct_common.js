




var mutl_bar_down = {
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
        	  x: 40,
              y: 60,
              x2: 30,
              y2: 60
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


// barLineAjax返回DATA,指标在下方
function load_mutl_bar_down(url,id,title,subtext,yAxis)
{
	var echartsobj = echarts.init(document.getElementById(id));
	if(title!=null && title!='')
	{
		mutl_bar_down.title.text=title;
	}
	if(subtext!=null && subtext!='')
	{
		mutl_bar_down.title.subtext=subtext;
	}
    mutl_bar_down.grid={
	    top:"10.5%",
        left: '0%',
        right: '3%',
        bottom: '10%',
        containLabel: true
    }
	if(yAxis!=null && yAxis!='')
	{
		mutl_bar_down.yAxis=yAxis;
	}
    echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();
	
	 echartsobj=barLineAjax_down(url,echartsobj, mutl_bar_down,id);
	return echartsobj;
}


function barLineAjax_down(url,  echartsobj, options,id) 
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
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
         success:function(data,status)
         {    
	          if(data.success==true ||data.success=='true')
	          {
	        		       echartsobj.hideLoading();
	        		       dataresutl=data.data;
	        		       chart_ajax_back(dataresutl,id);
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
	        	                   stack: seriesList[i].stack,
	        	                   barWidth:20
	        	                   ,yAxisIndex: seriesList[i].yAxisIndex,
                                itemStyle : { normal: {label : {show: true,color:"#000",position: 'top'}}},
	                               
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
   return echartsobj;
   
} 
function getDataCountForName(data,strName)
{
	var seriesList=data.seriesList;
    var xkCount=0;
    
        for(var i=0;i<seriesList.length;i++)
        {
        	var arr=seriesList[i].data;
        	var name=seriesList[i].name;
        	if(name==strName)
        	{
        		var name_count=0;
        		for(var j=0;j<arr.length;j++)
	            {
        			name_count=name_count+parseInt(arr[j]);
	            }
        		xkCount=name_count;
        	}
        } 
        return parseInt(xkCount);
}

function chart_ajax_back(data,id)
{
	
	if(id=='knowldege_chart1')
	{
		var xkCount_1=getDataCountForName(data,'专利申请');
    	var jzCount_2=getDataCountForName(data,'专利授权');
        var allCount_3=xkCount_1+jzCount_2;
        
        $("#knowldege_chart1_01").html(allCount_3);
        $("#knowldege_chart1_02").html(xkCount_1);
        $("#knowldege_chart1_03").html(jzCount_2);
	}
	if(id=='knowldege_chart4')
	{
		
		var count_1=getDataCountForName(data,'发明授权');
    	var count_2=getDataCountForName(data,'外观设计');
        var count_3=getDataCountForName(data,'实用新型');
        var count_all=count_1+count_2+count_3;
        
        $("#knowldege_chart4_01").html(count_all);
        $("#knowldege_chart4_02").html(count_1);
        $("#knowldege_chart4_03").html(count_2);
        $("#knowldege_chart4_04").html(count_3);
        
		
	}
	
}


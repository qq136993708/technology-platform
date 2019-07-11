function init_companyCode(functionId)
{
	 var v_date=(new Date()).getTime();
	 $.ajax({
			url : "/getDirDeparetMentList?functionId="+ functionId+"&v_date="+v_date,
			type : "get",
			async: false,
			dataType : "json",
			success : function(data) 
			{
				//$("#companyCode").append("<option value=''>请选择</option>");
				$.each(data.data, function(i, el) 
				{
					$("#companyCode").append('<option value="'+ el.numValue +'">' + el.name+ '</option>');
					/* if(cityId==el.id)
					{
						$("#companyCode ").val(cityId);  
					} */
				});
			},
			error : function() 
			{
				alert("发生未知错误 ,请重新操作.");
			}
		});
}




var mutlbar = {
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
            data:[],
            selected:{}
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
                /*min: 'dataMin',
                max:'dataMax',*/
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [

        ]
    };


function load_mutl_bar(url,id,title,subtext,yAxis,width,color,callback,isItemStyle)
{
	var echartsobj = echarts.init(document.getElementById(id));
	if(title!=null && title!='')
	{
		mutlbar.title.text=title;
	}
	if(subtext!=null && subtext!='')
	{
		mutlbar.title.subtext=subtext;
	}
	mutlbar.grid={
	    top:"10.5%",
	    left: '2.5%',
	    right: '3%',
	    bottom: '10%',
	    containLabel: true
	}
	if(yAxis!=null && yAxis!='')
	{
		mutlbar.yAxis=yAxis;
	}
	if(color!=undefined && color!=""){
		mutlbar.color=color;
	}
	mutlbar.xAxis=[{
		type: 'category',
		axisLabel:{
			interval:0,//0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
			rotate:0,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}
	}]
	echartsobj.clear();
	echartsobj.setOption(mutlbar);
	echartsobj.showLoading();
	
	echartsobj=bar_line_ajax(url,echartsobj, mutlbar,id,width,callback,isItemStyle);
	return echartsobj;
}






function bar_line_ajax(url,echartsobj, options,id,width,callback,isItemStyle)
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
	        		       set_multi_statistics(dataresutl,id);
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
	        	           
	        	           
	        	       	   var barWidth=20;
	        	           if(width!=undefined && width!="")
	        	           {
	        	           	barWidth=width
						   }
	        	           
	        	           for(var i=0;i<seriesList.length;i++)
	        	           {
	                            
	        	           	seriesData.push({
	        	           		   type: seriesList[i].type,
	        	                   name: seriesList[i].name,
	        	                   data: seriesList[i].data,
	        	                   stack: seriesList[i].stack,
	        	                   barWidth:barWidth,
	        	                   barGap:"4%",
	        	                   yAxisIndex: seriesList[i].yAxisIndex,
                                   itemStyle : { normal: {label : {show: isItemStyle,color:"#000",position: 'inside'}}},
	                               
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
	        	           
	        	       
	          } else
	          {
	        	 
	          }
	          if(callback)
	          {
	        	  callback(data);
	          }
		   },
		   error:function()
		   {
		   },
		   complete: function (XMLHttpRequest, status) {
	            if(status == 'timeout'){
	            }
	        }
		  
  });
   return echartsobj;
   
}

//多柱图 -统计
function set_multi_statistics(data,id)
{
	
}

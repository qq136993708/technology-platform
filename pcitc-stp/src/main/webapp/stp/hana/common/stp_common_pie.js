

/**
 * ======================================饼形图 begin==============================================
 */
var optionpie = {
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
    color:['#87d359', '#70b1aa','#f3cc42','#e79579','#349bd1','#7e7fa5','#9799ec','#c3c784','#f4964a'],
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c}  ({d}%)"
    },
    legend: {
    	 type: 'scroll',
         bottom: 0,
         data: [],
         selected:{}
    },
    series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: ['30%', '60%'],
            center: ['50%','45%'],
            avoidLabelOverlap: false,
            data: [],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        formatter: '{b} \n {c} \n({d}%)'
                    },
                    labelLine: {show: true}
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
var optionpieNew = {
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
    color:['#87d359', '#70b1aa','#f3cc42','#e79579','#349bd1','#7e7fa5','#9799ec','#c3c784','#f4964a'],
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c}  ({d}%)"
    },
    legend: {
        type: 'scroll',
        top: 10,
        data: []
    },
    series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: ['30%', '60%'],
            center: ['40%','55%'],
            avoidLabelOverlap: false,
            data: [],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        formatter: '{b} \n {c} \n({d}%)'
                    },
                    labelLine: {show: true}
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

function pieAjax(url, echartsobj, options)
{

    var names=[];
    var values=[];
    var selecteds={};
    $.ajax({
        type:"get",
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
                var chartList=data.data.dataList;
                for(var i=0;i<chartList.length;i++)
                {
                    names.push(chartList[i].name);
                    if(chartList[i].value==0||chartList[i].value=="0"){
                        selecteds[chartList[i].name]=false;
                    }
                }
                for(var i=0;i<chartList.length;i++)
                {

                    values.push({
                        value: chartList[i].value,
                        name: chartList[i].name
                    });
                }
                //加载数据图表
                echartsobj.setOption({
                    legend: {
                        data: names,
                        selected:selecteds
                    },
                    series: [{
                        data: values
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



//饼图
function loadPie(url,id,title,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	if(title!='')
	{
		optionpie.title.text=title;
	}
	if(subtext!='')
	{
		optionpie.title.subtext=subtext;
	}
	
	
	echartsobj.setOption(optionpie);
	echartsobj.showLoading();
	pieAjax(url,echartsobj,optionpie);
	return echartsobj;
}
function loadPieNew(url,id,title,subtext)
{

    var echartsobj = echarts.init(document.getElementById(id));
    if(title!='')
    {
        optionpieNew.title.text=title;
    }
    if(subtext!='')
    {
        optionpieNew.title.subtext=subtext;
    }
    echartsobj.setOption(optionpieNew);
    echartsobj.showLoading();
    pieAjax(url,echartsobj,optionpieNew);
    return echartsobj;
}

function loadPie_tt(id,title,legend_names,series_values,subtext)
{
	var echartsobj = echarts.init(document.getElementById(id));
	optionpie.title.text=title;
	optionpie.title.subtext=subtext;
	echartsobj.setOption(optionpie);
	echartsobj.setOption({
        legend: {
            data: legend_names
        },
        series: [{
            data: series_values
        }]
    });
}


/**=============================================返回DATA============================*/


var optionpie_02 = {
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
	    color:['#87d359', '#70b1aa','#f3cc42','#e79579','#349bd1','#7e7fa5','#9799ec','#c3c784','#f4964a'],
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c}  ({d}%)"
	    },
	    legend: {
	        type: 'scroll',
	        bottom: 1,
	        data: []
	    },
	    grid: {
    	    x: 80,
            y: 80,
            x2: 80,
            y2: 80
    },
	    series: [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['30%', '50%'],
	            center: ['50%','40%'],
	            avoidLabelOverlap: false,
	            data: [],
	            itemStyle: {
	                normal: {
	                    label: {
	                        show: true,
	                        formatter: '{b} \n {c} \n({d}%)'
	                    },
	                    labelLine: {show: true}
	                },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

	function pieAjax_02(url, echartsobj, options)
	{
		return pieAjax_02(url, echartsobj, options,null);
	}
	/**
	 * 支持回调的数据加载
	 * @param url
	 * @param echartsobj
	 * @param options
	 * @param callback
	 * @returns
	 */
	function pieAjax_02(url, echartsobj, options,callback) 
	{
		 
		 var names=[];  
	     var values=[];  
	     $.ajax({
		     type:"get",
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
			        	        var chartList=data.data.dataList;
			                    for(var i=0;i<chartList.length;i++)
			                    {
			                        names.push(chartList[i].name);
			                    }
			                    for(var i=0;i<chartList.length;i++)
			                    {
			                    	
			                    	values.push({
			                            value: chartList[i].value,
			                            name: chartList[i].name
			                        });
			                    }
			                    //加载数据图表
			                    echartsobj.setOption({
			                        legend: {
			                            data: names
			                        },
			                        series: [{
			                            data: values
			                        }]
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
	     
	     return echartsobj;
	        
	        
	}




	//饼图
	function loadPie_02(url,id,title,subtext)
	{
		return loadPie_02(url,id,title,subtext,null);
	}
	function loadPie_02(url,id,title,subtext,callback)
	{
		var echartsobj = echarts.init(document.getElementById(id));
		optionpie_02.title.text=title;
		optionpie_02.title.subtext=subtext;
		echartsobj.setOption(optionpie_02);
		echartsobj.showLoading();
		echartsobj=pieAjax_02(url,echartsobj,optionpie_02,callback);
		return echartsobj;
	}
	
/**
 * ======================================饼形图 end==============================================
 */


var option_taiyang = {
        series: {
            type: 'sunburst',
            radius: [0, '100%'],
            levels: [{}, {}, {}, {}, {

                label: {
                    position: 'outside',
                    padding: 3,
                    silent: false
                },
                itemStyle: {
                    borderWidth: 3
                }
            }],
            data: []
        }
    };

function pieAjax_taiyang(url, echartsobj, options) 
{
	 var names=[];  
     var values=[];  
     $.ajax({
	     type:"get",
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
		        	        var chartList=data.data;
		        	        //alert(chartList.length);
		                    //加载数据图表
		                    echartsobj.setOption({
		                        series: {
		                            data: chartList
		                        }
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

//饼图
function load_taiyang(url,id,title,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	echartsobj.setOption(option_taiyang);
	echartsobj.showLoading();
	pieAjax_taiyang(url,echartsobj,option_taiyang);
	return echartsobj;
}






















/**
 * ======================================二层太阳 end==============================================
 */



var option_taiyang_02 = {
   	 title: {
   		        text: '',
   		        x:'center',
   		        y: '10px',
   		        subtext: '',
   		        textStyle: {
   		            fontSize: 15,
   		            fontWeight: 'normal',
   		            color: '#000000'       
   		        },
   		        subtextStyle: {
   		            color: '#7B7B7B'        
   		        },
   		    },
   		    tooltip: {
   		        trigger: 'item',
   		        formatter: "{b}: {c}"
   		    },
   		    grid: {
   		        x: 80,
   		        y: 80,
   		        x2: 80,
   		        y2: 80
   		    },
        series: {
            type: 'sunburst',
            highlightPolicy: 'ancestor',
            data: [],
            radius: [0, '95%'],
            sort: null,
            levels: [{}, {
                r0: '15%',
                r: '35%',
                itemStyle: {
                    borderWidth: 2
                },
                label: {
                    rotate: 'tangential'
                }
            }, {
                r0: '35%',
                r: '70%',
                label: {
                    align: 'right'
                }
            }]
            
            
          }
        };


function pieAjax_taiyang_02(url, echartsobj, options) 
{
	
	echartsobj.hideLoading();
	$.ajax({
	     type:"get",
	     url: url,
	     dataType:"json",
	     timeout : 11000,
	     cache: false,
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
	      success:function(data,status)
	      {    
		          if(data.success==true ||data.success=='true')
		          {
		        	        var chartList=data.data;
		        	        option_taiyang_02.series.data=chartList;
		        	        echartsobj.setOption(option_taiyang_02);
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

//饼图
function load_taiyang_02(url,id,title,subtext)
{
	
	var echartsobj = echarts.init(document.getElementById(id));
	
	option_taiyang_02.title.text=title;
	option_taiyang_02.title.subtext=subtext;
	
	
	echartsobj.setOption(option_taiyang_02);
	echartsobj.showLoading();
	pieAjax_taiyang_02(url,echartsobj,option_taiyang_02);
}

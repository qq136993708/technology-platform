/**成果信息***/
var cgxx_charts1 = echarts.init(document.getElementById('cgxx_charts1'));
var cgxx_charts2 = echarts.init(document.getElementById('cgxx_charts2'));
var cgxx_charts3 = echarts.init(document.getElementById('cgxx_charts3'));
/**项目投资***/
var xmtz_charts1 = echarts.init(document.getElementById('xmtz_charts1'));
var xmtz_charts2 = echarts.init(document.getElementById('xmtz_charts2'));
var xmtz_charts3 = echarts.init(document.getElementById('xmtz_charts3'));
var xmtz_charts4 = echarts.init(document.getElementById('xmtz_charts4'));

//成果信息option
var cgxx_option = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        type: 'scroll',
        itemWidth: 10,  // 设置宽度
　　    itemHeight: 10, // 设置高度
　　    itemGap: 20, // 设置间距
        orient: 'vertical',
        right: 150,
        top: 20,
        bottom: 20,
        icon:"circle",
        data:['直接访问','邮件营销','联盟广告'],
        textStyle: {
            fontSize: '14',
            color:'#ffffff'
      }
    },
    color:['#DF5DFF','#81FF5B','#42FDFF'],
    series: [
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '65%'],
            center: ['25%', '45%'],
            avoidLabelOverlap: false,
            label: {
               normal: {
                   show: false,
                   textStyle: {
                       color: 'rgba(255, 255, 255, 1)'
                   },
                   fontSize: htmlFont(),
                    formatter:function (params){	            
                       return params.name+'\n'+params.percent+'%'+'\n'+parseInt(params.value)+'吨'
                    }
               }
           },
            
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'}
            ]
        }
    ]
};
var option1 = {
   color:['#FED25F','#43a7fa','#ff586f'],
     title:{
        show:true,
        left:'center',
        top:'center',
        
    },
     legend: {
//	        orient: 'vertical',
        x: 'left',
        data:['直接访问','邮件营销','联盟广告'],
        textStyle:{
           color:'#fff',
           fontSize:0.12*getFontSize()
        },
        itemWidth:0.12*getFontSize(),
        itemHeight:0.12*getFontSize()
    },
    tooltip: {
        trigger: 'item',
        formatter: function(params){
           return params.name+'<br />'+name+':'+params.value+'万吨'	        	
        }
    },
    series: [
        {
            name:'零售构成',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    textStyle: {
                        color: 'rgba(255, 255, 255, 1)'
                    },
                    fontSize: htmlFont(),
                     formatter:function (params){	            
                        return params.name+'\n'+params.percent+'%'+'\n'+parseInt(params.value)+'吨'
                     }
                }
            },
            labelLine: {
                normal: {
                    show: false,
                    length: 2,
                    length2: 5,
                    lineStyle: {
                        color: 'rgba(255, 255, 255, 1)'
                    },
                }
            },
            data:[
               {value:335, name:'直接访问'},
               {value:310, name:'邮件营销'},
               {value:234, name:'联盟广告'}
           ]
        }
    ]
};
// 成果信息
cgxx_charts1.setOption(cgxx_option);
cgxx_charts2.setOption(cgxx_option);
cgxx_charts3.setOption(cgxx_option);


// 项目投资Option
var xmtz_option = {
	tooltip : {
		formatter: "{a} <br/>{b} : {c}%"
	},
	series: [
		{
			name: '业务指标',
			type: 'gauge',
			min:0,
			max:120,
			splitNumber:6,
			startAngle:225,
			endAngle:-45,
			center : ['45%', '50%'],    // 默认全局居中
			radius : '75%',
			detail: {
				formatter:'{value}%',
				offsetCenter: [0, 0],
				textStyle: {
				   color: '#ffffff',
               fontSize : 30,
               fontFamily:'Impact'
				}
         },
         grid: {
            left: '3%',
            right: '4%',
            top: '5%',
            bottom: '5%',
            containLabel: true
          },
         axisTick:{
            show: false
         },
			axisLine: {            // 坐标轴线
            lineStyle: {       // 属性lineStyle控制线条样式
					color: [
						[1,new echarts.graphic.LinearGradient(0, 0, 1, 0, [
							{
								offset: 0.1,
								color: "rgba(246, 224, 103, 1)"
							},
							{
								offset: 1,
								color: "rgba(246, 180, 103, 1)"
							}
						])]
					
               ],
               width: 10
				}
			},
			axisLabel: {            // 坐标轴小标记
				show:false
			},
			splitLine: {           // 分隔线
				show:false
			},
			pointer: {
				show:false
         },
			data: [{value: 50, name: '核能开发'}]
		}
	]
};


// 项目投资
xmtz_charts1.setOption(xmtz_option);
xmtz_charts2.setOption(xmtz_option);
xmtz_charts3.setOption(xmtz_option);
xmtz_charts4.setOption(xmtz_option);


//-------获取html font-size值--------//
function htmlFont(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	return Number(fontSize)*0.134;
}
function getFontSize(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	console.log(fontSize);
	return parseFloat(fontSize);
}
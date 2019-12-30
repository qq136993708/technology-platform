var main_area_map = echarts.init(document.getElementById('main_area_map'));
/**风险***/
var fx_chart1 = echarts.init(document.getElementById('fx_chart1'));
var fx_chart2 = echarts.init(document.getElementById('fx_chart2'));
var fx_chart3 = echarts.init(document.getElementById('fx_chart3'));
var fx_chart4 = echarts.init(document.getElementById('fx_chart4'));
var fx_chart5 = echarts.init(document.getElementById('fx_chart5'));
var fx_chart6 = echarts.init(document.getElementById('fx_chart6'));

/**项目投资***/
var xmtz_charts1 = echarts.init(document.getElementById('xmtz_charts1'));
var xmtz_charts2 = echarts.init(document.getElementById('xmtz_charts2'));
var xmtz_charts3 = echarts.init(document.getElementById('xmtz_charts3'));
var xmtz_charts4 = echarts.init(document.getElementById('xmtz_charts4'));
main_area_map.showLoading({
    text: '数据加载中',
    color: 'rgba(35,245,253)',
    textColor: 'rgba(35,245,253)',
    maskColor: 'rgba(255, 255, 255, 0)',
    zlevel:3
});
var option = {
    tooltip : {
        trigger: 'item'
    },
    legend: {
        show:false,
        orient: 'vertical',
        left: 'center',
        top:60,
        data:['总计产能']
    },
    grid: {
        x:90,
        x2:80,
        y:30,
        y2:30
    },
    visualMap: {
        //type:'continuous',
        // min: 0,
        // max: json.maxValue,
        bottom:0,
        left:20,
        text: ['高','低'],           // 文本，默认为数值文本
        calculable: true,
        inRange:{
            // color: ['#ecfcfe','#1d8fff']
            color: [ '#fff','#006edd']
        },
        // formatter:function(value){ 
        //     value=formatNum(value,2);
        //     return value; 
        // },
        textStyle:{
            color:'#333333',
            fontSize:'14'
        }
    },
    toolbox: {
        show: false,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
            dataView: {readOnly: false},
            restore: {},
            saveAsImage: {}
        }
    },
    geo:{
        show:true
    },
    series: [{
            name: '总计产能',
            type: 'map',
            mapType: 'china',
            roam: false,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color:'#ffffff'
                    }
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {  
                normal: { 
                    label: { 
                        show:true 
                    }, 
                    areaStyle:{
                        color:'blue'
                    },
                    borderColor: '#1890ff',
                    borderWidth: 2,
                },// for legend  
                emphasis: { label: { show:true}, areaStyle:{color:'blue'} }  
            }, 
            data:[
                {name: '北京',value: Math.round(Math.random()*1000)},
                {name: '天津',value: Math.round(Math.random()*1000)},
                {name: '上海',value: Math.round(Math.random()*1000)},
                {name: '重庆',value: Math.round(Math.random()*1000)},
                {name: '河北',value: Math.round(Math.random()*1000)},
                {name: '河南',value: Math.round(Math.random()*1000)},
                {name: '云南',value: Math.round(Math.random()*1000)},
                {name: '辽宁',value: Math.round(Math.random()*1000)},
                {name: '黑龙江',value: Math.round(Math.random()*1000)},
                {name: '湖南',value: Math.round(Math.random()*1000)},
                {name: '安徽',value: Math.round(Math.random()*1000)},
                {name: '山东',value: Math.round(Math.random()*1000)},
                {name: '新疆',value: Math.round(Math.random()*1000)},
                {name: '江苏',value: Math.round(Math.random()*1000)},
                {name: '浙江',value: Math.round(Math.random()*1000)},
                {name: '江西',value: Math.round(Math.random()*1000)},
                {name: '湖北',value: Math.round(Math.random()*1000)},
                {name: '广西',value: Math.round(Math.random()*1000)},
                {name: '甘肃',value: Math.round(Math.random()*1000)},
                {name: '山西',value: Math.round(Math.random()*1000)},
                {name: '内蒙古',value: Math.round(Math.random()*1000)},
                {name: '陕西',value: Math.round(Math.random()*1000)},
                {name: '吉林',value: Math.round(Math.random()*1000)},
                {name: '福建',value: Math.round(Math.random()*1000)},
                {name: '贵州',value: Math.round(Math.random()*1000)},
                {name: '广东',value: Math.round(Math.random()*1000)},
                {name: '青海',value: Math.round(Math.random()*1000)},
                {name: '西藏',value: Math.round(Math.random()*1000)},
                {name: '四川',value: Math.round(Math.random()*1000)},
                {name: '宁夏',value: Math.round(Math.random()*1000)},
                {name: '海南',value: Math.round(Math.random()*1000)},
                {name: '台湾',value: Math.round(Math.random()*1000)},
                {name: '香港',value: Math.round(Math.random()*1000)},
                {name: '澳门',value: Math.round(Math.random()*1000)}
            ]
            
        }
    ]
};
main_area_map.setOption(option,true);
main_area_map.hideLoading();


var fx_option = {
    title: {
        text: '/ 中核宝原投资 /',
        x:'center',
        textStyle: {
            color: '#ffffff',
            fontSize : 13
            // fontFamily:'myFont6'
        }
    },
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    
    series: [
        {
            name: '业务指标',
			type: 'gauge',
			min:0,
			max:300,
			splitNumber:6,
			startAngle:180,
			endAngle:0,
			center : ['45%', '60%'],    // 默认全局居中
			radius : '90%',
			detail: {
				formatter:'风险：{value}',
				offsetCenter: [0, 0],
				textStyle: {
                    color: '#ffffff',
                    fontSize : 12,
                    fontFamily:'Impact'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                top: '25%',
                bottom: '5%',
                containLabel: true
            },
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [
                        [1,new echarts.graphic.LinearGradient(0, 0, 1, 0, [
                            {
                                offset: 0.1,
                                color: "rgba(0, 255, 24, 1)"
                            },
                            {
                                offset: 0.5,
                                color: "rgba(255, 222, 0, 1)"
                            },
                            {
                                offset: 1,
                                color: "rgba(255, 0, 90, 1)"
                            }
                        ])]
                   ],
                width: 15
                }
            },
            pointer: {
				show:false
            },
            axisTick: {            // 坐标轴小标记
                length: 15,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length: 18,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            axisLabel: {
                color: '#fff',
                fontSize: 7
            },
            data: [{value: 50, name: ''}]
        }
    ]
};

fx_chart1.setOption(fx_option);
fx_chart2.setOption(fx_option);
fx_chart3.setOption(fx_option);
fx_chart4.setOption(fx_option);
fx_chart5.setOption(fx_option);
fx_chart6.setOption(fx_option);


// 投资执行情况Option
$(document).ready(function() {
    gaugeimg('xmtz_charts1', '核能开发', 0, 100, 42, 'μg/m3');
    gaugeimg('xmtz_charts2', '集中研发', 0, 100, 90, 'μg/m3');
    gaugeimg('xmtz_charts3', '国防基础', 0, 100, 50, 'μg/m3');
    gaugeimg('xmtz_charts4', '国防技术基础', 0, 100, 80, 'μg/m3');
    
    /*
		 *id:id;
		 *title:仪表盘名称
		 *min:最小值
		 *max:最大值
		 *val:当前实际值
		 *unit:单位符号
		 */
		function gaugeimg(id, title, min, max, val, unit) {
			var myChart = echarts.init(document.getElementById(id)); //初始化

			option = {
				title: {
					text: title,
					x: 'center',
                    y: '44%',
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 14,
                        color: '#fff',
                        shadowColor : '#fff', //默认透明
                        shadowBlur: 10
                    }
				},
				tooltip: {
					formatter: "{a} <br/>{b} : {c}" + unit
				},
				toolbox: {
					show: false,
					feature: {
						mark: {
							show: true
						},
						restore: {
							show: true
						},
						saveAsImage: {
							show: true
						}
					}
				},
				series: [{
					startAngle:225,
                    endAngle:-45,
                    center : ['50%', '60%'],    // 默认全局居中
					name: title,
					type: 'gauge',
					radius: '90%',
					splitNumber: 10, // 分割段数，默认为5
					axisLine: { // 坐标轴线
						lineStyle: { // 属性lineStyle控制线条样式
							color: [
								[0.25, '#ddd'],
								[1, 'rgba(18, 75, 128, 0.5)']
							],
							width: 8
						}
					},
					axisTick:{
                        show: false
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
					title : {
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                            fontSize: 14,
                            color: '#fff',
                            shadowColor : '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
					detail: {
                        formatter:'{value}%',
                        offsetCenter: [0, '25%'],  
						// formatter: '{value}' + unit,
						textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
							color: '#fff',
                            "fontSize": 25,
                            fontFamily:'Impact'
						}
					},
					data: [{
						//value: val,
						//name: name
					}]
				}]
			};
			option.series[0].min = min;
			option.series[0].max = max;
			option.series[0].data[0].value = val;
			option.series[0].axisLine.lineStyle.color[0][0] = (val - min) / (max - min);
			option.series[0].axisLine.lineStyle.color[0][1] = detectionData(val, id);
			myChart.setOption(option);
        }
        
        /*
		 *颜色设置，
		 */
		function detectionData(str, id) {
            color = new echarts.graphic.LinearGradient(0, 0, 1, 1, [{
                offset: 0.1,
                color: "rgba(246, 224, 103, 1)"
            }, {
                offset: 1,
                color: "rgba(246, 180, 103, 1)"
            }]);
            option.series[0].axisLine.lineStyle.width = '11'; //重置仪表盘轴线宽度
            option.series[0].axisTick.length = '16'; //重置仪表盘刻度线长度
            option.series[0].title.color = color.colorStops[1].color; //字体颜色和轴线颜色一致
            option.series[0].title.fontSize = 30; //第一个字体变大
            return color;
		}

})






























var tzgmtj_data=[
    {"xms":"5千万及以下","hnkf":"8","jzyf":"14","gfjc":"0","gfjs":"5"},
    {"xms":"5千万~1亿","hnkf":"4","jzyf":"2","gfjc":"0","gfjs":"0"},
    {"xms":"1~3亿","hnkf":"0","jzyf":"0","gfjc":"0","gfjs":"1"},
    {"xms":"3~5亿","hnkf":"0","jzyf":"14","gfjc":"0","gfjs":"3"},
    {"xms":"5~10亿","hnkf":"5","jzyf":"2","gfjc":"0","gfjs":"0"},
    {"xms":"10亿以上","hnkf":"9","jzyf":"0","gfjc":"34","gfjs":"1"},
]
load_tzgmtj_data();
function load_tzgmtj_data(){
	//清空数据
    $("#tzgmtj_table .tzgmtj_tbody").html('');
    var html='';
	for(var v in tzgmtj_data){
        html+='<tr><td>'+tzgmtj_data[v].xms+'</td>';
        html+='<td>'+tzgmtj_data[v].hnkf+'</td>';
        html+='<td>'+tzgmtj_data[v].jzyf+'</td>';
        html+='<td>'+tzgmtj_data[v].gfjc+'</td>';
        html+='<td class="name">'+tzgmtj_data[v].gfjs+'</td>';
    }
    $("#tzgmtj_table .tzgmtj_tbody").append(html);
}

//-------获取html font-size值--------//
function htmlFont(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	return Number(fontSize)*0.134;
}
function getFontSize(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	return parseFloat(fontSize);
}
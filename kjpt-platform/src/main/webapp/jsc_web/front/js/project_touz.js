var chartsW = $(".jcCharts").width();
var chartsH = $(".jcCharts").height();
$("#charts1").css("width", chartsW).css("height", chartsH);
$("#charts2").css("width", chartsW).css("height", chartsH);
var charts1= echarts.init(document.getElementById('charts1'));
var charts2= echarts.init(document.getElementById('charts2'));
var option1 = {
	tooltip: {
		trigger: 'axis',
		axisPointer: {
            type: 'shadow'
        },
		backgroundColor:'rgba(38,84,113,0.5)',
		borderColor:'#0897a0',
		borderWidth:1
	},
	legend: {
		show:true,
		data:['计划（万元）','支出（万元）'],
		itemWidth: 10,  // 设置宽度
　　    itemHeight: 10, // 设置高度
　　    itemGap: 40, // 设置间距
		x:'right',
		textStyle:{
			color:'#fff',
			fontSize:14
		}
	},
	color:['#4526FF','#00AEFF','#93E9FF'],
	grid: {
		x:'5%',
		x2:'3%',
		y:'15%',
		y2:'20%',
	},
	xAxis: [
		{
			type: 'category',
			data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			axisLabel:{
				textStyle:{
					color:'#fff',
					fontSize:'16'
				}
			}
		}
	],
	yAxis: [
		{
			type: 'value',
			name: '',
			axisLabel:{
				textStyle:{
					color:'#fff',
					fontSize:'16'
				}
			},
			axisLine:{
				show:true,
				lineStyle:{
					color:['rgba(30,83,137,0.6)']
				}
			},
			splitLine:{
				lineStyle:{
					color:['rgba(30,83,137,0.6)']
				}
			}
		}
	],
	series: [
		{
            name:'计划（万元）',
			type:'bar',
			barWidth:20,
			barGap: 0,
            data: [5270, 2643, 7804, 9172, 8753, 5786, 5796, 10532, 7536, 12643, 8888, 6666]

        },
        {
            name:'支出（万元）',
			type:'bar',
			barWidth:20,
            data: [7543, 9999, 7804, 9172, 8753, 5786, 9631, 7543, 8541, 14763, 9999, 7777]
		}
	]
};

var option2 = {
	legend:{
		show:true,
		itemWidth: 10,  // 设置宽度
　　    itemHeight: 10, // 设置高度
　　    itemGap: 40, // 设置间距
		x:'right',
		textStyle:{
			color:'#fff',
			fontSize:14
		},
		data:['2019年执行率','2018年执行率']
	},
	tooltip : {
		trigger: 'axis',
		backgroundColor:'rgba(38,84,113,0.5)',
		borderColor:'#0897a0',
		borderWidth:1,
		formatter:'{b0}<br/>{a0} : {c0}%<br/>{a1} : {c1}%'
	},
	grid: {
		x:'3%',
		x2:'3%',
		y:'15%',
		y2:'20%',
	},
	xAxis : [
		{
			type : 'category',
			data : ['1月','1-2月','1-3月','1-4月','1-5月','1-6月','1-7月','1-8月','1-9月','1-10月','1-11月','1-12月'],
			axisLabel:{
				textStyle:{
					color:'#fff',
					fontSize:'16'
				}
			}
		}

	],
	yAxis : [
		{
			type : 'value',
			axisLabel:{
				textStyle:{
					color:'#fff',
					fontSize:'16'
				}
			},
			axisLine:{
				show:true,
				lineStyle:{
					color:['rgba(30,83,137,0.6)']
				}
			},
			splitLine:{
				lineStyle:{
					color:['rgba(30,83,137,0.6)']
				}
			}
		}
	],
	series : [
		{
			name:'2019年执行率',
			type:'line',
			data: [10, 14, 24, 40, 44, 45, 50, 57,67, 72, 81, 90],
			symbol:'circle',
			symbolSize:2 | 4,
			itemStyle:{
				normal:{
					borderWidth:10,
					color : '#00FF2A',
					shadowBlur:20
				}
			},
			
			itemStyle:{
				normal:{
					borderWidth:10,
					color:'#00FF2A',
					shadowBlur:20
				}
			}
		},
		{
			name:'2018年执行率',
			type:'line',
			data: [6, 10, 20, 37, 40, 42,24, 40, 44, 45, 50, 57],
			symbol:'circle',
			symbolSize:2 | 4,
			itemStyle:{
				normal:{
					borderWidth:10,
					color : '#03F003',
					shadowBlur:20
				}
			},
			
			itemStyle:{
				normal:{
					borderWidth:10,
					color:'#EAFF74',
					shadowBlur:20
				}
			}
		}
	]
};
charts1.setOption(option1);
charts2.setOption(option2);

$(document).ready(function(){
	$("#query1 .query").on("click", function(){
		$(this).siblings().removeClass("qActive");
		$(this).addClass("qActive");
		if($(this).text()=="核能开发"){
			option1.series[0].data=tz_data1[0].data;
			option1.series[1].data=tz_data1[1].data;
			charts1.setOption(option1);
		}
		if($(this).text()=="集中研发"){
			option1.series[0].data=tz_data2[0].data;
			option1.series[1].data=tz_data2[1].data;
			charts1.setOption(option1);
		}
	});
	$("#query2 .query").on("click", function(){
		$(this).siblings().removeClass("qActive");
		$(this).addClass("qActive");
		if($(this).text()=="核能开发"){
			option2.series[0].data=tz_data5[0].data;
			option2.series[1].data=tz_data5[1].data;
			charts2.setOption(option2);
		}
		if($(this).text()=="集中研发"){
			option2.series[0].data=tz_data6[0].data;
			option2.series[1].data=tz_data6[1].data;
			charts2.setOption(option2);
		}
	});
});
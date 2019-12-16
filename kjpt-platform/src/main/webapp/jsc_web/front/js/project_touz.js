var chartsW = $(".jcCharts").width();
var chartsH = $(".jcCharts").height();
$("#charts1").css("width", chartsW).css("height", chartsH);
$("#charts2").css("width", chartsW).css("height", chartsH);
var charts1= echarts.init(document.getElementById('charts1'));
var charts2= echarts.init(document.getElementById('charts2'));
var option1 = {
	tooltip: {
		trigger: 'axis',
		backgroundColor:'rgba(38,84,113,0.5)',
		borderColor:'#0897a0',
		borderWidth:1
	},
	legend: {
		show:true,
		data:['蒸发量','降水量'],
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
		x:'3%',
		x2:'3%',
		y:'15%',
		y2:'20%',
	},
	xAxis: [
		{
			type: 'category',
			data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
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
            name:'蒸发量',
			type:'bar',
			barWidth:20,
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
        },
        {
            name:'降水量',
			type:'bar',
			barWidth:20,
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
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
			data : ['2011年','2012年','2013年','2014年','2015年'],
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
			data:[3.5,12.4,24.0,32.3,66.2],
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
			data:[95.9,97.0,96.5,96.6,96.5],
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


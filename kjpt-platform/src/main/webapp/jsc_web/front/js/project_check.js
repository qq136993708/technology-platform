var chartsW = $(".jcCharts").width();
var chartsH = $(".jcCharts").height();
$("#charts").css("width", chartsW).css("height", chartsH);
var linebar= echarts.init(document.getElementById('charts'));
var option = {
	tooltip: {
		trigger: 'axis',
		backgroundColor:'rgba(38,84,113,0.5)',
		borderColor:'#0897a0',
		borderWidth:1
	},
	legend: {
		show:true,
		data:['蒸发量','降水量','降水量1'],
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
		},
        {
            name:'降水量1',
			type:'bar',
			barWidth:20,
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        }
	]
};
linebar.setOption(option);

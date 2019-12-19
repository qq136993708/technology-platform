var chartsW = $(".jcCharts").width();
var chartsH = $(".jcCharts").height();
$("#charts").css("width", chartsW).css("height", chartsH);
var linebar= echarts.init(document.getElementById('charts'));
var option = {
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
		data:['关键控制节点数','完成数','未完成数'],
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
			data: ['中国核电','核动力院','工程公司','原子能公司','XXXX','XXXX'],
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
            name:'关键控制节点数',
			type:'bar',
			barWidth:20,
			barGap: 0,
            data:[49, 71, 16, 129, 144, 176]
        },
        {
            name:'完成数',
			type:'bar',
			barWidth:20,
            data:[83, 78, 8, 93, 106, 84]
		},
        {
            name:'未完成数',
			type:'bar',
			barWidth:20,
            data:[48, 38, 39, 4, 47, 8]
        }
	]
};
linebar.setOption(option);


$(document).ready(function() {
	
	var data={
		"year1": {
			"hhkf": {
				"data1": [49, 71, 106, 129, 144, 176],
				"data2": [83, 78, 98, 93, 106, 84],
				"data3": [48, 38, 39, 41, 47, 48],
			},
			"jzyf": {
				"data1": [11, 12, 16, 129, 144, 176],
				"data2": [83, 78, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 47, 4]
			},
			"gfjc": {
				"data1": [11, 12, 16, 19, 144, 176],
				"data2": [83, 78, 8, 93, 16, 8],
				"data3": [4, 38, 9, 41, 47, 4],
			},
			"gfjsjc": {
				"data1": [11, 12, 16, 12, 144, 176],
				"data2": [3, 8, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 4, 4],
			},
			"hhkf-table": 
				[
					{"val1":"项目名称1","val2":"承担单位1","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称2","val2":"承担单位2","val3":"节点名称2","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称3","val2":"承担单位3","val3":"节点名称3","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称4","val2":"承担单位4","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称5","val2":"承担单位5","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称6","val2":"承担单位6","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称7","val2":"承担单位7","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"}
				]
		},
		"year2": {
			"hhkf": {
				"data1": [49, 71, 106, 129, 144, 176],
				"data2": [83, 78, 98, 93, 106, 84],
				"data3": [48, 38, 39, 41, 47, 48],
			},
			"jzyf": {
				"data1": [11, 12, 16, 129, 144, 176],
				"data2": [83, 78, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 47, 4]
			},
			"gfjc": {
				"data1": [11, 12, 16, 19, 144, 176],
				"data2": [83, 78, 8, 93, 16, 8],
				"data3": [4, 38, 9, 41, 47, 4],
			},
			"gfjsjc": {
				"data1": [11, 12, 16, 12, 144, 176],
				"data2": [3, 8, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 4, 4],
			},
			"hhkf-table": 
				[
					{"val1":"项目名称1","val2":"承担单位1","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称2","val2":"承担单位2","val3":"节点名称2","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称3","val2":"承担单位3","val3":"节点名称3","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称4","val2":"承担单位4","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称5","val2":"承担单位5","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称6","val2":"承担单位6","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称7","val2":"承担单位7","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"},
					{"val1":"项目名称8","val2":"承担单位8","val3":"节点名称1","val4":"节点内容","val5":"2020-05-01","val6":"单位1","val7":"5","val8":"5","val9":"5"}
				]
			
		},
		"year3": {
			"hhkf": {
				"data1": [49, 71, 106, 129, 144, 176],
				"data2": [83, 78, 98, 93, 106, 84],
				"data3": [48, 38, 39, 41, 47, 48],
			},
			"jzyf": {
				"data1": [11, 12, 16, 129, 144, 176],
				"data2": [83, 78, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 47, 4]
			},
			"gfjc": {
				"data1": [11, 12, 16, 19, 144, 176],
				"data2": [83, 78, 8, 93, 16, 8],
				"data3": [4, 38, 9, 41, 47, 4],
			},
			"gfjsjc": {
				"data1": [11, 12, 16, 12, 144, 176],
				"data2": [3, 8, 8, 93, 106, 84],
				"data3": [4, 38, 9, 41, 4, 4],
			},
			"hhkf-table": {
				"xlxw1": "石油大学（华东）",
				"xlxw2": "（2003-01-01 至 2007-01-01）",
				"xlxw3": "石油大学（华东）本科(最高学历)｜管理学学士(最高学位)｜会计学",
				"xlxw4": "全日制"
			}
		},
	}
	loadTableDat();
	$(".check_query .query").on("click", function(){
		$(this).siblings().removeClass("qActive");
		$(this).addClass("qActive");
		$("#check_date").val()
		if($(this).text()=="核能开发"){
			option.series[0].data=data.year1.hhkf.data1;
			option.series[1].data=data.year1.hhkf.data2;
			option.series[2].data=data.year1.hhkf.data3;
			linebar.setOption(option);
			loadTableDat();
		}
		if($(this).text()=="集中研发"){
			option.series[0].data=data.year1.jzyf.data1;
			option.series[1].data=data.year1.jzyf.data2;
			option.series[2].data=data.year1.jzyf.data3;
			linebar.setOption(option);
			loadTableDat();
		}
		if($(this).text()=="国防基础"){
			option.series[0].data=data.year1.gfjc.data1;
			option.series[1].data=data.year1.gfjc.data2;
			option.series[2].data=data.year1.gfjc.data3;
			linebar.setOption(option);
			loadTableDat();
		}
		if($(this).text()=="国防技术基础"){
			option.series[0].data=data.year1.gfjsjc.data1;
			option.series[1].data=data.year1.gfjsjc.data2;
			option.series[2].data=data.year1.gfjsjc.data3;
			linebar.setOption(option);
			loadTableDat();
		}
	});

	function loadTableDat(){
		//清空数据
		$("#check_table").html('');
		var html='';
		var tableData=data.year1["hhkf-table"];
		console.log(tableData);
		for(var v in tableData){
			html+='<tr><td>'+tableData[v].val1+'</td>';
			html+='<td>'+tableData[v].val2+'</td>';
			html+='<td>'+tableData[v].val3+'</td>';
			html+='<td>'+tableData[v].val4+'</td>';
			html+='<td>'+tableData[v].val5+'</td>';
			html+='<td>'+tableData[v].val6+'</td>';
			html+='<td>'+tableData[v].val7+'</td>';
			html+='<td>'+tableData[v].val8+'</td>';
			html+='<td>'+Math.round(Math.random()*1000)+'</td></<td></tr>';
		}
		$("#check_table").append(html);
	}
	
})

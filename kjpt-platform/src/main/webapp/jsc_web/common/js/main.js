// 成果鉴定
kyptCharts.render({
    id: 'cgxx_charts1',
    type: 'pie',
    legendPosition: 'right',
    legend: { top: 'center', formatter: 'name|value'},
    label: false,
    labelColor: '#fff',
    radius: ['62%', '84%'],
    borderColor: '#001e38',
    title: '成果鉴定',
    totalTitle: true,
    title: {
        textStyle: {
        color: '#fff',
        fontSize: 24,
        width: '100%'
        }
    },
    series: [
        {name: '理论成果', value: '10'},
        {name: '软科学成果', value: '60'},
        {name: '应用技术成果', value: '30'}
    ],
    color: ['#DF5DFF', '#81FF5B', '#42FDFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
});

// 成果报奖
kyptCharts.render({
    id: 'cgxx_charts2',
    type: 'pie',
    legendPosition: 'right',
    legend: { top: 'center', formatter: 'name|value'},
    label: false,
    labelColor: '#fff',
    radius: ['62%', '84%'],
    borderColor: '#001e38',
    title: '成果报奖',
    totalTitle: true,
    title: {
        textStyle: {
        color: '#fff',
        fontSize: 24,
        width: '100%'
        }
    },
    series: [
        {name: '理论成果', value: '10'},
        {name: '软科学成果', value: '60'},
        {name: '应用技术成果', value: '30'}
    ],
    color: ['#DF5DFF', '#81FF5B', '#42FDFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
});

// 成果转化
kyptCharts.render({
    id: 'cgxx_charts3',
    type: 'pie',
    legendPosition: 'right',
    legend: { top: 'center', formatter: 'name|value'},
    label: false,
    labelColor: '#fff',
    radius: ['62%', '84%'],
    borderColor: '#001e38',
    title: '成果转化',
    totalTitle: true,
    title: {
        textStyle: {
        color: '#fff',
        fontSize: 24,
        width: '100%'
        }
    },
    series: [
        {name: '待转化', value: '10'},
        {name: '拟转化', value: '60'},
        {name: '已转化', value: '30'}
    ],
    color: ['#DF5DFF', '#81FF5B', '#42FDFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
});


/**项目投资***/
var xmtz_charts1 = echarts.init(document.getElementById('xmtz_charts1'));
var xmtz_charts2 = echarts.init(document.getElementById('xmtz_charts2'));
var xmtz_charts3 = echarts.init(document.getElementById('xmtz_charts3'));
var xmtz_charts4 = echarts.init(document.getElementById('xmtz_charts4'));
/**项目数量***/
var main_charts = echarts.init(document.getElementById('main_charts'));

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
            title : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize: 14,
                    color: '#fff',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 10
                }
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

//项目数量
var xmsl_option={
	tooltip: {
		trigger: 'axis',
		backgroundColor:'rgba(38,84,113,0.5)',
		borderColor:'#0897a0',
        borderWidth:1,
        axisPointer : {            
            type : 'shadow'        
        }
	},
	
	legend: {
        show:true,
        itemWidth:13,
        itemHeight:13,
		data:['已完成','在研'],
		textStyle:{
			color:'#fff',
			fontSize: 16
        },
        right: 10
	},
	grid: {
		top: '12%',
		right: '5%',
		left: '5%',
		bottom:'12%'
	},
	xAxis: [
		{
			type: 'category',
			data: ['核能开发 ','集中研发','国防基础','国防技术基础',],
			axisLabel:{
				textStyle:{
					color:'#fff',
					fontSize:'16'
                },
                margin: 16,
                interval: 0
			},
			axisLine:{
				show:false
			},
			splitLine:{
				show:false
            },
            axisTick:{
                show:false
            }
		}
	],
	yAxis: [
		{
			type: 'value',
			name: '',
			// min: 0,
			// max: 250,
			// interval: 50,
			axisLabel:{
				// formatter: '{value} ml',
				textStyle:{
					color:'#fff',
					fontSize:'16'
				}
			},
			axisLine:{
				show:false
			},
			splitLine:{
                show:false
			},
            axisTick:{
                show:false
            },
            axisLabel:{
                show:false
            }
		}
	],
	series: [
        {
            name:'辅助0',
            type:'bar',
            stack:"采购",
            data:[0,0,0,0],
            barMinHeight: 0,
            itemStyle: { opacity: 0 },
            tooltip: { show: false },
            markPoint: {
                type: 'category',
                data: [
                    {coord: [0, 0]},
                    {coord: [1, 0]},
                    {coord: [2, 0]},
                    {coord: [3, 0]}
                ],
                // symbolOffset: [0, -15],
                label: { show: false },
                symbol: 'circle',
                symbolSize: [40, 12],
                itemStyle: { color : '#42fdff'}
            }
        },
		{
			name:'已完成',
			type:'bar',
			stack:"采购",
			data: [10,7,10,10],
			itemStyle:{ color: '#42fdff' },
            label: {
                normal: {
                    show: true,
                    position: 'inside',
                    textStyle:{
                        color:'#000'
                    }
                }
            },
            barWidth:40,
            markPoint: {
                data: [
                    {coord: [0, 10]},
                    {coord: [1, 7]},
                    {coord: [2, 10]},
                    {coord: [3, 10]}
                ],
                label: { show: false },
                symbol: 'circle',
                symbolSize: [40, 12],
                itemStyle: { color : '#0E9AC2'}
            }
        },
        {
            name:'辅助1',
            type:'bar',
            stack:"采购",
            data:[0,0,0,0],
            barMinHeight: 16,
            itemStyle: { opacity: 0 },
            tooltip: { show: false },
            markPoint: {
                type: 'category',
                data: [
                    {coord: [0, 10]},
                    {coord: [1, 7]},
                    {coord: [2, 10]},
                    {coord: [3, 10]}
                ],
                symbolOffset: [0, -15],
                label: { show: false },
                symbol: 'circle',
                symbolSize: [40, 12],
                itemStyle: { color : '#5cfdb7'}
            }
        },
		{
			name:'在研',
			type:'bar',
			stack:"采购",
			data:[4,4,4,2],
			itemStyle:{ color: "#5cfdb7"},
            label: {
                normal: {
                    show: true,
                    position: 'inside',
                    textStyle:{
                        color:'#000'
                    }
                }
            },
            barWidth:40,
            markPoint: {
                type: 'category',
                data: [
                    {coord: [0, 14]},
                    {coord: [1, 11]},
                    {coord: [2, 14]},
                    {coord: [3, 12]}
                ],
                symbolOffset: [0, -15],
                label: { show: false },
                symbol: 'circle',
                symbolSize: [40, 12],
                itemStyle: { color : '#1ACB62'}
            }
		}
	]
};
// 项目数量
main_charts.setOption(xmsl_option);
//-------获取html font-size值--------//
function htmlFont(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	return Number(fontSize)*0.134;
}
function getFontSize(){
	var fontSize = $("html").css('fontSize').replace("px",'');
	return parseFloat(fontSize);
}

$(document).ready(function() {
    //知识产权
    loadZSCQData();
    //成果信息
    loadMAINData('2');
    //项目数量
    loadMAINData('1');
    //质量信息
    loadMAINData('4');
    //项目投资
    loadMAINData('5');
})

//知识产权
function loadZSCQData(){
    httpModule({
        url: "/cockpit/results/queryBIData/indexKnowledgeRightCount",
        success: function(result){
            console.log(result)
            if(result.success==true){
                $("#cgsj_num span").html(result.data[0].count);//成果数量
                $("#zhuanl_num span").html(result.data[1].count);//专利
                $("#rjzzq_num span").html(result.data[2].count);//软件著作权
            }else{
                $("#cgsj_num span").html('0');//成果数量
                $("#zhuanl_num span").html('0');//专利
                $("#rjzzq_num span").html('0');//软件著作权
            }
        },
        errro:function(data){
            console.log(data);
        }
    });
}
//项目数量
function loadMAINData(type){
    $.ajax({
        url: "/cockpit/index/allSummaryCount",
        type: 'POST',
        data:{inType:type},
        dataType: 'JSON',
        success: function(result){
            if(result.success == true){
                // console.log(result);

                if(type=="2"){
                    //成果信息 数据不对
                    var chartData = [];
                    $.each(result.data, function(i, item) {
                        chartData.push({
                            name: item.name.split('-')[1],
                            value: item.num
                        })
                    })
                    // kyptCharts.reload('cgxx_charts1', {series: chartData});
                    // kyptCharts.reload('cgxx_charts2', {series: chartData});
                    // kyptCharts.reload('cgxx_charts3', {series: chartData});
                }
                if(type=="1"){
                    setXMSLData(result);//项目数量
                }
                if(type=="4"){
                    setZLXXData(result);//质量信息
                }
                if(type=="5"){
                    setXMTZData(result);//项目投资
                }
               
            }
        }
    });
}

//项目数量
function setXMSLData(result){
    if(result.success==true){
        $.each(result.data, function(i,v){     
            if(v.name=="科研平台"){
                $("#xmsl_num1").html(v.num);//科研平台
            }   
            if(v.name=="科技人才"){
                $("#xmsl_num2").html(v.num);//科科技人才
            }
            if(v.name=="行业标准"){
                $("#xmsl_num3").html(v.num);//行业标准
            }
            if(v.name=="经验反馈"){
                $("#xmsl_num4").html(v.num);//经验反馈
            }
        }); 
    }else{
        $("#xmsl_num1").html('0');
        $("#xmsl_num2").html('0');
        $("#xmsl_num3").html('0');
        $("#xmsl_num4").html('0');
    }
}

//质量信息
function setZLXXData(result){
    if(result.success==true){
        $.each(result.data, function(i,v){     
            if(v.name=="填报报表数"){
                $("#zlxx_num1 span").html(v.num);//填报报表数
            }   
            if(v.name=="即时事故数"){
                $("#zlxx_num2 span").html(v.num);//即时事故数
            }
            if(v.name=="参与单位数"){
                $("#zlxx_num3 span").html(v.num);//参与单位数
            }
        }); 
    }else{
        $("#zlxx_num1 span").html('0');
        $("#zlxx_num2 span").html('0');
        $("#zlxx_num3 span").html('0');
    }
}
//项目投资
function setXMTZData(result){
    if(result.success==true){
        var data1=[];
        var data2=[];
        var data3=[];
        var data4=[];
        
        var json1={};
        var json2={};
        var json3={};
        var json4={};
        //第一个
        json1.name=result.data[0].name.split('-')[1];
        json1.value=result.data[0].num;
        data1.push(json1);
        xmtz_option.series[0].data = data1;
        xmtz_charts1.setOption(xmtz_option);
        //第二个
        json2.name=result.data[1].name.split('-')[1];
        json2.value=result.data[1].num;
        data2.push(json2);
        xmtz_option.series[0].data=data2;
        xmtz_charts2.setOption(xmtz_option);
        //第三个
        json3.name=result.data[2].name.split('-')[1];
        json3.value=result.data[2].num;
        data3.push(json3);
        xmtz_option.series[0].data=data3;
        xmtz_charts3.setOption(xmtz_option);
        //第四个
        json4.name=result.data[3].name.split('-')[1];
        json4.value=result.data[3].num;
        data4.push(json4);
        xmtz_option.series[0].data=data4;
        xmtz_charts4.setOption(xmtz_option);
    }else{
        
        
    }
}
var option={
    legend: {
        type: 'scroll',
        bottom: 1,
        data:[]
    },
    xAxis: [{
        type: 'category',
        data: [],
        axisLabel:{
            interval:0,
        }
    }],
    yAxis: [],
    series: []
};
function eCharts(data,callback) {
    console.log(data.color);
    var echartsobj = echarts.init(document.getElementById(data.id));
    if(data.color==undefined){}else {
        option.color=data.color;
    }
    if(data.grid==undefined){}else {
        option.grid=data.grid;
    }
    if(data.yAxis==undefined){}else {
        option.yAxis=data.yAxis;
    }
    echartsobj.setOption(option);
    echartsobj.showLoading();
    data.ajaxPost(data.url,echartsobj, option,data.width,callback);
}
function eChartsAjax(url,echartsobj, options,width,callback) {
    var legends=[];
    var xAxisData=[];
    var seriesData=[];
    $.ajax({
        type:"GET",
        url: url,
        dataType:"json",
        timeout : 11000,
        cache: false,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success:function(data,status) {
            if(data.success==true ||data.success=='true') {
                echartsobj.hideLoading();
                var legendDataList=data.data.legendDataList;
                for(var i=0;i<legendDataList.length;i++) {
                    legends.push(legendDataList[i]);
                }
                var xAxisDataList=data.data.xAxisDataList;
                for(var i=0;i<xAxisDataList.length;i++) {
                    xAxisData.push(xAxisDataList[i]);
                }
                var seriesList=data.data.seriesList;
                if(width!=undefined && width!="" && width!=null){
                    var barWidth=width
                }else{
                    var barWidth=20
                }
                for(var i=0;i<seriesList.length;i++) {
                    seriesData.push({
                        type: seriesList[i].type,
                        name: seriesList[i].name,
                        data: seriesList[i].data,
                        stack:seriesList[i].stack,
                        barWidth:barWidth,
                        label: {
                            show: true, //开启显示
                            position: 'inside', //在上方显示
                            textStyle: { //数值样式
                                color: 'black',
                                fontSize: 14
                            }
                        }
                        ,yAxisIndex: seriesList[i].yAxisIndex
                    });
                }
                //加载数据图表
                echartsobj.setOption({
                    legend: {
                        data: legends
                    },
                    xAxis: [{
                            type: 'category',
                            data: xAxisData
                        }],
                    series: seriesData
                });
                if(callback) {
                    console.log("call.....back......");
                    callback(data.data);
                }
            } else {

            }
        }
    });
}
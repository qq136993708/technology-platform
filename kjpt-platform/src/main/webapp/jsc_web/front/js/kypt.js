
layui.use(['laydate'], function() {
    var laydate = layui.laydate;
    var achieveTypes = [];
    var achieveTypesSeries = [];
    var awardsYearChart;
     var kypt_charts1 = echarts.init(document.getElementById('awardTramsformInfoHistory'));
    var awardNameColor = [
        {type: '授权', color: '#5AB2F6'},
        {type: '申请', color: '#D66234'},
        {type: '无效', color: '#545684'}
    ];
    var awardTramsformInfoHistoryColor = [
        {type: 'transMoney', cololr: '#D89936'},
        {type: 'transMoneySum', cololr: '#0CB92D'}
    ];
    var pieColor = ['#4FA0E4', '#3461D3', '#EFEC56', '#DE7A3A', '#DF5DFF'];

    var chartInit = {
        transformInfo: function (param) {
            var y1 = [];
            var y2 = [];
            httpModule({
                url: '/patentBI/getPatentCountByYear',
                data: '2020',
                type: 'GET',
                async: false,
                success: function(res) {
                    var result = [];
                    if (res.code == 0) {
                        var data = res.data;
                        var option1 = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                },
                                formatter: function (serves) {
                                    var showHtms = '<div style="font-size:16px; margin:5px;">'+'申请专利'+'</div>'+
                                     '<span style="display:inline-block;margin-right: 3px;width:16px;height:16px;background: rgba(216,153,54,1);opacity: 0.4; "></span>'+  serves[0].seriesName+ '&nbsp;&nbsp;'+serves[0].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7;opacity: 0.4; "></span>'+ serves[1].seriesName+'&nbsp;&nbsp;'+ serves[1].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7;opacity: 0.4; "></span>'+ serves[2].seriesName+ '&nbsp;&nbsp;'+serves[2].value+'<br>'+
                                        '<div style="font-size:16px; margin:5px;">'+'授权专利'+'</div>'+
                                     '<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: rgba(216,153,54,1); "></span>'+ serves[3].seriesName+'&nbsp;&nbsp;'+ serves[3].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7; "></span>'+  serves[4].seriesName+ '&nbsp;&nbsp;'+serves[4].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7; "></span>'+ serves[5].seriesName+'&nbsp;&nbsp;'+ serves[5].value+'<br>'

                                    return showHtms;
                                }
                            },
                            color: ['#D89936', '#5AB3F8', '#2D66D7', '#EDDE21','#28A1EA'],
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    data: [data[0].textTitle, data[6].textTitle, data[12].textTitle, data[18].textTitle, data[24].textTitle],
                                    axisLabel:{
                                        color:"white"
                                    }
                                }
                            ],
                            yAxis: [
                                {
                                    name: '单位：个',
                                    nameTextStyle: {color: '#fff'},
                                    yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
                                    type: 'value',
                                    splitLine:{
                                        lineStyle:{
                                            color:"#1E5389",
                                            opacity:"0.6"
                                        }
                                    },
                                    axisLabel:{
                                        color:"white"
                                    },
                                },
                            ],
                            series: [
                                {
                                    name:data[0].text,
                                    type: 'bar',
                                    barWidth:"20",
                                    barGap:'0',
                                    stack: data[0].textSub,
                                    data: [data[0].calValue, data[6].calValue, data[12].calValue,data[18].calValue,data[24].calValue],
                                },
                                {
                                    name:data[1].text,
                                    type: 'bar',
                                    stack: data[1].textSub,
                                    data: [data[1].calValue, data[7].calValue,data[13].calValue, data[19].calValue, data[25].calValue]
                                },
                                {
                                    name: data[2].text,
                                    type: 'bar',
                                    stack:data[2].textSub,
                                    data: [data[2].calValue,data[8].calValue, data[14].calValue, data[20].calValue, data[26].calValue],
                                    label: {
                                      // normal:{
                                        fontFamily: 'Impact',
                                        color: 'white',
                                        fontSize: 20,
                                        show: true,
                                        position: 'top',
                                        formatter: function (params) {
                                            var nums = "{a|" + params.value + "}";
                                            return nums
                                        }
                                    }

                                },
                                {
                                    name: data[3].text,
                                    barWidth:"20",
                                    type: 'bar',
                                    stack:data[3].textSub,
                                    data: [data[3].calValue, data[9].calValue, data[15].calValue, data[21].calValue, data[27].calValue],
                                },
                                {
                                    name: data[4].text,
                                    type: 'bar',
                                    stack:data[4].textSub,
                                    data: [data[4].calValue, data[10].calValue, data[16].calValue, data[22].calValue, data[28].calValue]
                                },
                                {
                                    name: data[5].text,
                                    type: 'bar',
                                    stack:data[5].textSub,
                                    data: [data[5].calValue, data[11].calValue, data[17].calValue, data[23].calValue, data[29].calValue],
                                    label: {
                                        fontFamily: 'Impact',
                                        color: 'white',
                                        fontSize: 20,
                                        show: true,
                                        position: 'top',
                                        formatter: function (params){
                                            return params.value
                                        }
                                    }

                                },
                            ]
                        };
                        var series = option1["series"];

                        var fun = function (params) {
                            var datavalue = 0;
                            for (var i = 0; i < series.length; i++) {
                                if(series[i].stack === '申请专利'){
                                    datavalue += series[i].data[params.dataIndex]
                                }
                            }
                            return datavalue;
                        }
                        var fun2 = function (params) {
                            var datavalue2 = 0;
                            for (var i = 0; i < series.length; i++) {
                                if(series[i].stack === '授权专利'){
                                    datavalue2 += series[i].data[params.dataIndex]
                                }
                            }
                            return datavalue2;
                        }
                        series[2]["label"]["formatter"] = fun;
                        series[series.length - 1]["label"]["formatter"] = fun2;
                        kypt_charts1.setOption(option1)
                    }
                }
            });
        },
        awardsYearPie: function (params) {
            var series = [];
            var colors = [];
            httpModule({
                url: '/patentBI/getPatentCountByLegelStatus',
                data: '2020',
                type: 'GET',
                async: false,
                success: function(res) {
                    var awardTramsformType = echarts.init(document.getElementById('awardTramsformType'));
                    var data = res.data;
                    $.each(res.data, function(i, item) {
                        var colorObj = awardNameColor.find(function (currValue, i) {
                            return currValue.type == item.text;
                        });
                        var color = colorObj ? colorObj.color : '#DF5DFF';
                        var obj = {name: item.text, value: Number(item.calValue)};
                        colors.push(color)
                        series.push(obj);
                    });
                    // kyptCharts.render({
                    //     id: 'awardTramsformType',
                    //     type: 'pie',
                    //     legendPosition: 'right',
                    //     legend: { top: 'center', formatter: 'name|value', right: 40},
                    //     label: false,
                    //     labelColor: '#fff',
                    //     radius: '65%',
                    //     center: ['50%', '50%'],
                    //     left: '20',
                    //     borderColor: '#001e38',
                    //     totalTitle: false,
                    //     series: series,
                    //     title: {
                    //         textStyle: { fontSize: 48, color: '#fff' }
                    //     },
                    //     color: colors,
                    // });
                    var option2 = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: '70%',
                            top:'20%',
                            data: [
                                {value: res.data[0].calValue, name: res.data[0].text},
                                {value: res.data[1].calValue, name: res.data[1].text},
                                {value: res.data[2].calValue, name: res.data[2].text},
                            ],
                            formatter:function(name){
                                var target;
                                for(var i=0;i<data.length;i++){
                                    if(data[i].text===name){
                                        target=data[i].calValue
                                    }
                                }
                                var arr= arr=["{a|"+name+"}","{b|"+target+"}"]
                                return arr
                            },
                            color:['#59B2F6','#D66134','#535584'],
                            textStyle:{
                                rich:{
                                    a:{
                                        fontFamily:'PingFang SC',
                                        fontSize:18,
                                        color:"white",
                                        padding: 15
                                    },
                                    b:{
                                        fontFamily:'Impact',
                                        fontSize:26,
                                        color:"white"
                                    }
                                }
                            }
                        },
                        series: [
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius: '80%',
                                center: ['30%', '50%'],
                                label: {
                                    show: false
                                },
                                data: series,
                                color:['#59B2F6','#D66134','#535584'],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    awardTramsformType.setOption(option2)
                }
            });
        },
        achieveTransferOfficeChart: function (params) {
            $('#achieveTransferOffice').empty();
            kyptCharts.render({
                id: 'achieveTransferOffice',
                type: 'bar',
                grid: { top: 40 },
                label: false,
                legend: { show: false, left: 'right', top: 5},
                labelColor: '#fff',
                borderColor: '#001e38',
                data: [],
                itemName: 'name',
                series: [
                    { name: '授权', valueKey: 'value1', stack: 'charts'},
                    { name: '申请', valueKey: 'value2', stack: 'charts'},
                    { name: '无效', valueKey: 'value3', stack: 'charts'}
                ],
                color: ['#59B2F6', '#D66134', '#535584'],
                lineColor: 'rgba(4, 30, 54, 1)',
                valueColor: '#fff',
                labelColor: '#fff',
                labelRotate: 40,
                yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
                barWidth: 20,
                axisLineColor: 'rgba(255, 255, 255, .2)'
            });
            var y1 = [];
            var y2 = [];
            httpModule({
                url: '/patentBI/getPatentCountByOffice',
                data: '2020',
                type: 'GET',
                async: false,
                success: function(res) {
                    var result = [];
                    if (res.code == 0) {
                        var data = res.data;
                        var dataArr = [];
                        for(var i=0; i<data.length;i++){
                            var obj = {};
                            if(i%3 === 0){
                                obj.name = data[i].text;
                                obj.value1 = data[i].calValue;
                                obj.value2 = data[i+1].calValue;
                                obj.value3 = data[i+2].calValue;
                                dataArr.push(obj)
                            }
                        }
                        kyptCharts.reload('achieveTransferOffice',
                            {
                                data: dataArr,
                                yAxis: [
                                    {
                                        type: 'value',
                                        name: '单位：个',
                                        nameTextStyle: {
                                            color: '#ffffff',
                                            lineHeight: 40,
                                            height: 40
                                        },
                                        min: 0
                                    },
                                ]

                            });
                    }
                }
            });
        }
    };

    chartInit.transformInfo();
    chartInit.awardsYearPie();
    chartInit.achieveTransferOfficeChart();
});
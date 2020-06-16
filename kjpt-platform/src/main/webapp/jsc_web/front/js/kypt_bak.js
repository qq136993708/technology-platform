
$(function() {
    // 历年成果转化完成情况
    kyptCharts.render({
        id: 'awardTramsformInfoHistory',
        type: 'bar',
        itemName: 'textTitle',
        legend: { show: true },
        legendPosition: 'top',
        grid: { top: 30, right: 30, bottom: 12 },
        lineColor: 'rgba(30, 83, 137, .6)',
        axisLineColor: 'rgba(30, 83, 137, .6)',
        valueColor: '#fff',
        labelColor: '#2BB7FF',
        label: {
            color: '#fff',
            position: 'inside',
            show: false
        },
        color: ['rgba(216,153,54, 0.4)', 'rgba(90,179,248, 0.4)', 'rgba(45,102,215, 0.5)', '#D89936', '#5AB3F8', '#2D66D7'],
        series: [],
        data: [],
        yAxis: [{ name: '单位：个', nameTextStyle: {color: '#fff'}}],
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
                var flag1 = true;
                var flag2 = true;
                return showHtms;
            }
        }
    });

    // 法律状态
    kyptCharts.render({
        id: 'awardTramsformType',
        type: 'pie',
        legendPosition: 'right',
        legend: { top: 'center', formatter: 'name|value', right: 40},
        label: false,
        labelColor: '#fff',
        center: ['50%', '50%'],
        radius: ['0%',  '65%'],
        totalTitle: false,
        series: [],
        color: ['#5AB2F6', '#D66234', '#545684']
    });


    // 二级单位专利数量统计
    kyptCharts.render({
        id: 'achieveTransferOffice',
        type: 'bar',
        grid: { top: 40, bottom: 0 },
        label: false,
        legend: { show: true },
        legendPosition: 'top',
        labelColor: '#fff',
        data: [],
        itemName: 'name',
        series: [
            { name: '授权', valueKey: 'value1', stack: 'charts'},
            { name: '申请', valueKey: 'value2', stack: 'charts'},
            { name: '无效', valueKey: 'value3', stack: 'charts'}
        ],
        color: ['#59B2F6', '#D66134', '#535584'],
        lineColor: 'rgba(30, 83, 137, .6)',
        valueColor: '#fff',
        labelColor: '#fff',
        labelRotate: 40,
        yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
        barWidth: 20,
        axisLineColor: 'rgba(30, 83, 137, .6)'
    });

    var chartInit = {
        transformInfo: function (param) {
            var params = {};
            if(param){
                switch(param.type){
                    case  'fm':
                        params.patentType = '01';
                        flag1 = !flag1;
                        break;
                    case 'syxl':
                        params.patentType = '02';
                        flag1 = !flag1;
                        break;
                    case 'wgsj':
                        params.patentType = '03';
                        flag1 = !flag1;
                        break;
                }
            }else {
                params = '2020';
            }

            httpModule({
                url: '/patentBI/getPatentCountByYear',
                data: params,
                type: 'GET',
                async: false,
                success: function(res) {
                    if (res.code == 0) {

                        var data = res.data;
                        var option1 = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                    type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
                                },
                                formatter: function (serves) {
                                    var showHtms = '<div style="font-size:16px; margin:5px;">'+'申请专利'+'</div>'+
                                     '<span style="display:inline-block;margin-right: 3px;width:16px;height:16px;background: rgba(216,153,54,1);opacity: 0.4; "></span>'+  serves[0].seriesName+ '&nbsp;&nbsp;'+serves[0].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7;opacity: 0.4; "></span>'+ serves[1].seriesName+'&nbsp;&nbsp;'+ serves[1].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7;opacity: 0.4; "></span>'+ serves[2].seriesName+ '&nbsp;&nbsp;'+serves[2].value+'<br>'+
                                        '<div style="font-size:16px; margin:5px;">'+'授权专利'+'</div>'+
                                     '<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: rgba(216,153,54,1); "></span>'+ serves[3].seriesName+'&nbsp;&nbsp;'+ serves[3].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7; "></span>'+  serves[4].seriesName+ '&nbsp;&nbsp;'+serves[4].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #2D66D7; "></span>'+ serves[5].seriesName+'&nbsp;&nbsp;'+ serves[5].value+'<br>'

                                    return showHtms;



                        var data = res.data, yearIndex = [], _totalArr = [], HJdata = [], sData = [];
                        $.each(data, function(i, item) {
                            var index = yearIndex.indexOf(item.textTitle);
                            if (index === -1) {
                                yearIndex.push(item.textTitle);
                                _totalArr.push([item]);
                            } else {
                                _totalArr[index].push(item);
                            }
                        });
                        $.each(_totalArr, function(i, item) {
                            var tempJson = {textTitle: yearIndex[i]};
                            for (var a = 0; a < item.length; a++) {
                                var valKey = 'val_' + a;
                                tempJson[valKey] = item[a].calValue;
                                if (i === 0) {
                                    sData.push({
                                        name: item[a].text + '_' + item[a].textSub,
                                        valueKey: valKey,
                                        stack: item[a].text
                                    })
                                }

                            },
                            legend: {
                                show: false,
                                data: ['发明','实用新型', '外观设计', '发明','实用新型', '外观设计']
                            },
                            color: ['#D89936', '#5AB3F8', '#2D66D7', 'red','#28A1EA'],
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    triggerEvent: true,
                                    data: [data[0].textTitle, data[6].textTitle, data[12].textTitle, data[18].textTitle, data[24].textTitle],
                                    axisLabel:{
                                        color:"#2BB7FF"
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
                                    name:data[0].textSub,
                                    type: 'bar',
                                    barWidth:"20",
                                    barGap:'0',
                                    stack: data[0].text,
                                    data: [data[0].calValue, data[6].calValue, data[12].calValue,data[18].calValue,data[24].calValue],
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(216,153,54,.4)',
                                        }
                                    }
                                },
                                {
                                    name:data[1].textSub,
                                    type: 'bar',
                                    stack: data[1].text,
                                    data: [data[1].calValue, data[7].calValue,data[13].calValue, data[19].calValue, data[25].calValue],
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(90,179,248,.4)',
                                        }
                                    }
                                },
                                {
                                    name: data[2].textSub,
                                    type: 'bar',
                                    stack:data[2].text,
                                    data: [data[2].calValue,data[8].calValue, data[14].calValue, data[20].calValue, data[26].calValue],
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(45,102,215,.4)',
                                        }
                                    },
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

                            }
                            HJdata.push(tempJson);
                        });


















































































                                },
                                {
                                    name: data[3].textSub,
                                    barWidth:"20",
                                    type: 'bar',
                                    stack:data[3].text,
                                    data: [data[3].calValue, data[9].calValue, data[15].calValue, data[21].calValue, data[27].calValue],
                                },
                                {
                                    name: data[4].textSub,
                                    type: 'bar',
                                    stack:data[4].text,
                                    data: [data[4].calValue, data[10].calValue, data[16].calValue, data[22].calValue, data[28].calValue]
                                },
                                {
                                    name: data[5].textSub,
                                    type: 'bar',
                                    stack:data[5].text,
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

                        kyptCharts.reload('awardTramsformInfoHistory', {data: HJdata, series: sData});
                        console.log('sData => ', sData);
                        kypt_charts1.on('click', function (params) {
                            if(params.componentType == "xAxis"){
                                chartInit.achieveTransferOfficeChart({year: params.value})
                            }else{
                                alert("单击了"+params.name+"柱状图");
                            }
                        });

                            HJdata.push(tempJson);
                        });

                        kyptCharts.reload('awardTramsformInfoHistory', {data: HJdata, series: sData});

                        console.log('sData => ', sData);

                    }
                }
            });
        },
        awardsYearPie: function (params) {
            httpModule({
                url: '/patentBI/getPatentCountByLegelStatus',
                data: '2020',
                type: 'GET',
                async: false,
                success: function(res) {
                    var pieData = [];
                    $.each(res.data, function(i, item) {
                        var obj = {name: item.text, value: Number(item.calValue)};
                        pieData.push(obj);
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
                                        fontSize:14,
                                        color:"white",
                                    },
                                    b:{
                                        fontFamily:'Impact',
                                        fontSize:20,
                                        color:"white",
                                        padding: 15
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

                    kyptCharts.reload('awardTramsformType', {series: pieData});

















































































                }
            });
        },
        achieveTransferOfficeChart: function (param) {

            $('#achieveTransferOffice').empty();
            var params = {};
            if(param.type){
                if(flag2){
                    switch(param.type){
                        case  'shouQ':
                            params.legalStatus = '01';
                            flag2 = !flag2;
                            break;
                        case 'sq':
                            params.legalStatus = '02';
                            flag2 = !flag2;
                            break;
                        case 'wx':
                            params.legalStatus = '03';
                            flag2 = !flag2;
                            break;

                    }
                }else {
                    params = '2020'
                    flag2 = !flag2;
                }
            } else if(param.year){
                params = param.year
            }else {
                params = '2020'
            }
            kyptCharts.render({
                id: 'achieveTransferOffice',
                type: 'bar',
                grid: { top: 40 },
                label: false,
                tooltip: {
                    show: true,
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
                    },
                    formatter:function(serves){
                        var showHtms = '<div style="font-size:20px; margin:10px;">'+'中国核电工程'+'</div>'+
                            '<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background:#59B2F6; "></span>'+ serves[0].seriesName+'&nbsp;&nbsp;'+ serves[0].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+
                            '<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #D66134; "></span>'+  serves[1].seriesName+ '&nbsp;&nbsp;'+serves[1].value+'&nbsp;&nbsp;&nbsp;&nbsp;'+
                            '<span style="display:inline-block;margin-right: 3px; width:16px;height:16px;background: #535584; "></span>'+ serves[2].seriesName+'&nbsp;&nbsp;'+ serves[2].value+'<br>'
                        return showHtms;
                    }
                },
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
                data: params,
                type: 'GET',
                async: false,
                success: function(res) {
                    var result = [];
                    if (res.code == 0) {
                        var data = res.data;
                        var dataArr = [];
                        for(var i=0; i<data.length;i++) {
                            var obj = {};
                            if(i%3 === 0){
                                obj.name = data[i].text;
                                obj.value1 = data[i].calValue;
                                obj.value2 = data[i+1].calValue;
                                obj.value3 = data[i+2].calValue;
                                dataArr.push(obj)
                            }
                        }
                        kyptCharts.reload('achieveTransferOffice', { data: dataArr, yAxis: [ {
                            type: 'value', name: '单位：个', nameTextStyle: { color: '#ffffff', lineHeight: 40, height: 40 }, min: 0 }]
                        });
                    }
                }
            });
        }
    };
    $('.count-year-title ul li').on('click', function () {
        var type = $(this).attr('data-type');
        chartInit.transformInfo({type: type});
        chartInit.achieveTransferOfficeChart({type: type})
    });

    chartInit.transformInfo();
    chartInit.awardsYearPie();
    chartInit.achieveTransferOfficeChart({type:false});
});
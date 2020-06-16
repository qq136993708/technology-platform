
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
                        break;
                    case 'syxl':
                        params.patentType = '02';
                        break;
                    case 'wgsj':
                        params.patentType = '03';
                        break;
                }
            } else {
                params = '2020'
            }

            httpModule({
                url: '/patentBI/getPatentCountByYear',
                data: params,
                type: 'GET',
                async: false,
                success: function(res) {
                    if (res.code == 0) {
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
                            }
                            HJdata.push(tempJson);
                        });

                        kyptCharts.reload('awardTramsformInfoHistory', {data: HJdata, series: sData});
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
                    kyptCharts.reload('awardTramsformType', {series: pieData});
                }
            });
        },
        achieveTransferOfficeChart: function (params) {
            httpModule({
                url: '/patentBI/getPatentCountByOffice',
                data: '2020',
                type: 'GET',
                async: false,
                success: function(res) {
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
    // $('.count-year-title ul li').on('click', function () {
    //     var type = $(this).attr('data-type');
    //     chartInit.transformInfo({type: type});
    // });

    chartInit.transformInfo();
    chartInit.awardsYearPie();
    chartInit.achieveTransferOfficeChart();
});
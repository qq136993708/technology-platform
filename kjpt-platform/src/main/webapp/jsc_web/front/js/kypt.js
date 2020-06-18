
$(function() {
    // 历年申请/授权专利数量统计
    var legendItems = [],
    barColor = ['rgba(216,153,54, 0.4)', 'rgba(90,179,248, 0.4)', 'rgba(45,102,215, 0.5)', '#D89936', '#5AB3F8', '#2D66D7'];
    kyptCharts.render({
        id: 'awardTramsformInfoHistory',
        type: 'bar',
        itemName: 'textTitle',
        legendPosition: 'bottom',
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
        color: barColor,
        series: [],
        data: [],
        yAxis: [{ name: '单位：个', nameTextStyle: {color: '#fff'}}],
        tooltip: { trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } },
            formatter: function (params) {
                var itemGroup = [], parentNames = [];
                $.each(params, function(i, item) {
                    var newItem = {
                        parentName: item.seriesName.split('_')[0],
                        itemName: item.seriesName.split('_')[1],
                        value: item.value,
                        colorIndex: item.seriesIndex,
                        year: item.axisValue
                    };
                    var index = parentNames.indexOf(newItem.parentName);
                    if (index === -1) {
                        parentNames.push(newItem.parentName);
                        itemGroup.push([newItem]);
                    } else {
                        itemGroup[index].push(newItem);
                    }
                });
                
                if (itemGroup.length) {
                    var tipsHtml = '<div class="zscq_charts_tips">';
                    $.each(itemGroup, function(i, item) {
                        tipsHtml += '<dl><dt>'+ item[0].parentName;
                        tipsHtml += '<span style="font-size: 12px;">（'+ item[0].year +'年）</span></dt><dd class="middle-block">';
                        $.each(item, function(a, subItem) {
                            tipsHtml += '<span class="ib-block icon" style="background:'+ barColor[subItem.colorIndex] +'"></span>';
                            tipsHtml += '<span class="ib-block name">'+ subItem.itemName +'：</span>';
                            tipsHtml += '<span class="ib-block value">'+ subItem.value +'</span>';
                        });
                        tipsHtml += '</dd></dl>';
                    });
                    tipsHtml += '</div>';
                    return tipsHtml;
                }
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
        tooltip: { trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } }},
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
                };
            } else {
                params = '2020';
            }

            httpModule({
                url: '/patentBI/getPatentCountByYear',
                data: params,
                type: 'GET',
                async: false,
                success: function(res) {
                    if (res.code == 0) {
                        var data = res.data, yearIndex = [], _totalArr = [], HJdata = [];
                        
                        $.each(data, function(i, item) {
                            var index = yearIndex.indexOf(item.textTitle);
                            if (index === -1) {
                                yearIndex.push(item.textTitle);
                                _totalArr.push([item]);
                            } else {
                                _totalArr[index].push(item);
                            }
                        });

                        legendItems = [];
                        $.each(_totalArr, function(i, item) {
                            var tempJson = {textTitle: yearIndex[i]};
                            for (var a = 0; a < item.length; a++) {
                                var valKey = 'val_' + a;
                                tempJson[valKey] = item[a].calValue;
                                if (i === 0) {
                                    var legendItem = {
                                        name: item[a].text + '_' + item[a].textSub,
                                        valueKey: valKey,
                                        stack: item[a].text,
                                        label: '',
                                        parentLabel: '',
                                        parentSelected: true,
                                        selected:  true
                                    }
                                    if (item[a].text === '申请专利') {
                                        legendItem.parentLabel = 'apply';
                                    } else {
                                        legendItem.parentLabel = 'auth';
                                    }
                                    if (item[a].textSub === '发明') {
                                        legendItem.label = 'fm';
                                    } else if (item[a].textSub === '实用新型') {
                                        legendItem.label = 'syxx';
                                    } else {
                                        legendItem.label = 'wgsj';
                                    }
                                    legendItems.push(legendItem);
                                }
                            }
                            HJdata.push(tempJson);
                        });

                        console.log('legendItems => ', legendItems);

                        kyptCharts.reload('awardTramsformInfoHistory', {data: HJdata, series: legendItems});
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

    // 历年申请/授权专利数量统计 图例被点击后的
    $('#itemGroupList').on('click', '.legend-item', function(e) {
        var itemLabel = $(this).attr('label'), selected = false;
        if ($(this).hasClass('selected')) {
            selected = true;
            $(this).removeClass('selected');
        } else {
            $(this).addClass('selected');
        }

        var itemNames = {};
        $.each(legendItems, function(i, item) {
            if (item.parentLabel === itemLabel) {
                item.parentSelected = selected;
                if (!selected) {
                    itemNames[item.name] = selected;
                } else if (item.selected) {
                    itemNames[item.name] = selected;
                }
            } else if (item.label === itemLabel) {
                item.selected = selected;
                if (item.parentSelected) {
                    itemNames[item.name] = selected;
                }
            }
        });
        kyptCharts.reload('awardTramsformInfoHistory', {legend: {selected: itemNames}});
    })
});
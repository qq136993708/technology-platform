// 专利数量按专利类型占比分析
kyptCharts.render({
    id: 'chartsBox1',
    type: 'pie',
    legendPosition: 'right',
    legend: { top: 'center', right: 20, formatter: 'name|value'},
    label: false,
    labelColor: '#fff',
    radius: ['50%', '72%'],
    borderColor: '#001e38',
    totalTitle: true,
    title: {
      textStyle: {
        color: '#fff',
        fontSize: 30,
        width: '100%'
      }
    },
    series: [],
    color: ['#FFF04E', '#FF7F5D', '#2687FF']
});
// 专利数量年度趋势分析
kyptCharts.render({
    id: 'chartsBox2',
    type: 'bar',
    valueIndex: 'x', // 横向配置
    itemName: 'application_type_text',
    legend: { left: 'right' },
    grid: { left: 40, top: 40, right: 20 },
    lineColor: '#1E5389',
    valueColor: '#fff',
    labelColor: '#fff',
    label: false,
    barWidth: 12,
    series: [
      { name: '2017年', valueKey: 'count1'},
      { name: '2018年', valueKey: 'count2'},
      { name: '2019年', valueKey: 'count3'},
    ],
    data: [],
    color: ['#FFF04E','#2687FF','#FF7F5D']
})

// 专利数量按单位同比分析
kyptCharts.render({
    id: 'chartsBox3',
    type: 'bar',
    itemName: 'unit_name_text',
    legend: { left: 'right' },
    grid: { left: 40, top: 40, right: 15 },
    lineColor: '#1E5389',
    valueColor: '#fff',
    labelColor: '#fff',
    label: false,
    labelRotate: 30,
    series: [
      { name: '本年', valueKey: 'count1'},
      { name: '上年', valueKey: 'count2'},
      { name: '同比', valueKey: 'scale', type: 'line', yIndex: 1},
    ],
    yAxis: [ {max: 200}, { max: 200, formatter: '{value} %'}],
    data: [],
    color: ['#4526FF','#93E9FF','#EAFF74']
})

var api = {
    numOrType: '/cockpit/knowledgeRight/numOrType', //专利类型占比
    numOrUnit: '/cockpit/knowledgeRight/numOrUnit', //单位同比
    numYearTrend: '/cockpit/knowledgeRight/numYearTrend' //年度趋势分析
}

httpModule({
    url: api.numOrType,
    type: 'POST',
    success: setNumOrType,
    error: msgErr
})

httpModule({
    url: api.numYearTrend,
    type: 'POST',
    success: setNumYearTrend,
    error: msgErr
})

httpModule({
    url: api.numOrUnit,
    type: 'POST',
    success: setNumOrUnit,
    error: msgErr
    
})

function msgErr (){
    top.layer.msg('请求失败!', {icon: 2});
}

//设置类型占比配置项
function setNumOrType(result){
    if(result.code == 0){
        var relData = $.map(result.data, function(item, i) {
            return { name: item.patent_type_text, value: item.count };
        });
        kyptCharts.reload('chartsBox1', {series: relData});
    }else{
        top.layer.msg(result.message);
    }
}

//设置年度趋势
function setNumYearTrend(result){
    if(result.code == 0){
        kyptCharts.reload('chartsBox2', {data: result.data});
    }else{
        top.layer.msg(result.message);
    }
}

function setNumOrUnit(result){
    if(result.code == 0){
        var relData = $.map(result.data, function(item, i) {
            var tempItem = switchHttpData(item);
            tempItem.scale = item.scale * 100;
            return tempItem;
        });
        kyptCharts.reload('chartsBox3', {data: relData});  
    }else{
        top.layer.msg(result.message);
    }
}



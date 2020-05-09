// 成果信息
kyptCharts.render({
    id: 'cgxx_charts1',
    type: 'pie',
    legendPosition: 'right',
    legend: {
        top: 'center',
        formatter: 'name|value'
    },
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
    series: [{
            name: '未鉴定',
            value: '25'
        },
        {
            name: '鉴定中   ',
            value: '12'
        },
        {
            name: '鉴定完成',
            value: '18'
        }
    ],
    color: ['#f9dd56', '#ff9156', '#1bc85e'],
    callback:function(param){
        param.on('click',function(){
            //kjpt/achieve/identify/achieve_identify_plan_list.html
            window.open('/index?kjpt/achieve/identify/achieve_identify_plan_list.html');
        })
    },
});

// 专利数量类型占比
kyptCharts.render({
    id: 'cgxx_charts2',
    type: 'pie',
    legendPosition: 'right',
    legend: {
        top: 'center',
        formatter: 'name|value'
    },
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
    series: [{
            name: '发明专利',
            value: '10'
        },
        {
            name: '实用型专利',
            value: '60'
        },
        {
            name: '外观设计专利',
            value: '30'
        }
    ],
    color: ['#f9dd56', '#ff9156', '#1bc85e']
});

// 软件著作权数量
kyptCharts.render({
    id: 'cgxx_charts3',
    type: 'bar',
    labelColor: '#fff',
    borderColor: '#001e38',
    data: [
        { name: '动力院', value: 21 },
        { name: '原子能院', value: 46 },
        { name: '核能院', value: 18 },
        { name: '核化工', value: 50 },
        { name: '地研院', value: 6 }
    ],
    itemName: 'name',
    series: [
        { name: '著作权', valueKey: 'value' }
    ],
    color: [['#25B9FE', '#25B9FE']],
    lineColor: 'rgba(4, 30, 54, 1)',
    valueColor: '#fff',
    labelColor: '#fff',
    yAxis: [{splitNumber: 3}],
    barWidth: 20,
    axisLineColor: 'rgba(255, 255, 255, .2)',
    legend: {show: false },
});

// 专利数量按单位统计
kyptCharts.render({
    id: 'zltj_chart',
    type: 'bar',
    labelColor: '#fff',
    borderColor: '#001e38',
    data: [
        { name: '中国核动力\n设计研究院', value: 41, number: 81 },
        { name: '中核咨询\n服务有限公司', value: 152, number: 81 },
        { name: '中核咨询\n服务有限公司', value: 41, number: 81 },
        { name: '中核能源\n科技有限公司', value: 210, number: 125 },
        { name: '中国原子能\n科学研究院', value: 277, number: 210 },
        { name: '中核机械工程\n有限公司', value: 177, number: 125 }
    ],
    itemName: 'name',
    series: [
        { name: '本年', valueKey: 'value' },
        { name: '上年', valueKey: 'number' }
    ],
    color: ['#4526FF', ['#25B9FE', '#25B9FE']],
    yAxis: [{splitNumber: 3}],
    lineColor: 'rgba(255, 255, 255, .2)',
    valueColor: '#fff',
    labelColor: '#fff',
    barWidth: 20,
    label: false,
    axisLineColor: 'rgba(255, 255, 255, .2)',
    legendPosition: 'top'
    // legend: {show: false }
});

// 成果转化
kyptCharts.render({
    id: 'cgzh_chart1',
    type: 'pie',
    legendPosition: 'right',
    legend: { top: 'center', formatter: 'name|value' },
    label: false,
    labelColor: '#fff',
    radius: ['56%', '78%'],
    borderColor: '#001e38',
    title: '成果报奖',
    totalTitle: true,
    title: { textStyle: { color: '#fff', fontSize: 24, width: '100%' } },
    series: [
        { name: '核心成果', value: '10' },
        { name: '非核心成果', value: '60' }
    ],
    color: ['#45F0FF', '#2687FF', '#1bc85e']
});

// 成果转换趋势
kyptCharts.render({
    id: 'cgzh_chart2',
    type: 'line',
    labelColor: '#fff',
    borderColor: '#001e38',
    data: [
        { name: '2017年', value1: 10, value2: 53, value3: 41 },
        { name: '2018年', value1: 32, value2: 67, value3: 21 },
        { name: '2019年', value1: 19, value2: 39, value3: 74 }
    ],
    itemName: 'name',
    series: [
        { name: '待转化', valueKey: 'value1' },
        { name: '拟转化', valueKey: 'value2' },
        { name: '已经转化', valueKey: 'value3'}
    ],
    color: [ '#fbf002', '#14fd30', '#25B9FE'],
    lineColor: 'rgba(255, 255, 255, .2)',
    valueColor: '#fff',
    labelColor: '#fff',
    yAxis: [{splitNumber: 3}],
    axisLineColor: 'rgba(255, 255, 255, .2)',
    legendPosition: 'top'
})

//知识产权
function loadZSCQData() {
    httpModule({
        url: "/cockpit/results/queryBIData/indexKnowledgeRightCount",
        success: function (result) {
            if (result.success == true) {
                $.each(result.data, function (index, item) {
                    if (item.patent == 'patent') {
                        $("#zhuanl_num span").html(item.count); //专利
                    } else if (item.patent == 'achieve_core') {
                        $("#cgsj_num span").html(item.count); //成果数量
                    } else {
                        $("#rjzzq_num span").html(item.count); //软件著作权
                    }
                })
            } else {
                $("#cgsj_num span").html('0'); //成果数量
                $("#zhuanl_num span").html('0'); //专利
                $("#rjzzq_num span").html('0'); //软件著作权
            }
        },
        errro: function (data) {
            console.log(data);
        }
    });
}
//项目数量
function loadMAINData(type) {
    $.ajax({
        url: "/cockpit/index/allSummaryCount",
        type: 'POST',
        data: {
            inType: type
        },
        dataType: 'JSON',
        success: function (result) {
            if (result.success == true) {
                // console.log(result);

                if (type == "2") {
                    //成果信息 数据不对
                    var chartData = [];
                    $.each(result.data, function (i, item) {
                        chartData.push({
                            name: item.name.split('-')[1],
                            value: item.num
                        })
                    })
                    // kyptCharts.reload('cgxx_charts1', {series: chartData});
                    // kyptCharts.reload('cgxx_charts2', {series: chartData});
                    // kyptCharts.reload('cgxx_charts3', {series: chartData});
                }
                if (type == "1") {
                    // setXMSLData(result); //项目数量
                }
                if (type == "4") {
                    // setZLXXData(result); //质量信息
                }
                if (type == "5") {
                    // setXMTZData(result); //项目投资
                }

            }
        }
    });
}


$(document).ready(function () {
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
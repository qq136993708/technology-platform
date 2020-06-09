// 科研平台
kyptCharts.render({
    id: 'kypt_charts',
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
    series: [
        { name: '国家级', value: '9' },
        { name: '国家部委级', value: '12' },
        { name: '地方省级', value: '10' },
        { name: '集团级', value: '8' },
        { name: '板块级', value: '11' }
    ],
    color: ['#2687FF', '#6BD04A', '#EFEC56', '#D89339', '#D66635'],
    callback:function(param){
        param.on('click',function(){
            var openUrl={
                url:'/kjpt/achieve/identify/achieve_identify_plan_list.html',
                name:'成果鉴定'
            }
            window.open('/index', 'kjpt_webapp');
            localStorage.setItem("url", JSON.stringify(openUrl));
        })
    },
});

// 成果获奖
kyptCharts.render({
    id: 'achieve_charts',
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
    series: [
        { name: '国家级奖', value: '143' },
        { name: '省部级奖', value: '120' },
        { name: '集团奖', value: '325' },
        { name: '社会奖项', value: '184' }
    ],
    color: ['#4526D4', '#3461D3', '#5ABEE7', '#74E8D0'],
    callback:function(param){
        param.on('click',function(){
            var openUrl={
                url:'/html/patent/query.html',
                name:'专利管理'
            }
            window.open('/index', 'kjpt_webapp');
            localStorage.setItem("url", JSON.stringify(openUrl));
        })
    },
});

// 专利数量
kyptCharts.render({
    id: 'patent_charts',
    type: 'pie',
    legend: { show: false },
    label: {
        show: true,
        color: '#fff',
        formatter: [ '{a|{b}：{c}}' ].join('\n'),
        rich: {
            a: {
                height: 20,
                borderWidth: 1,
                lineHeight: 18,
                fontSize: 14,
                align: 'center',
                padding: [3, 6, 3, 6],
                borderRadius: 3
            }
        }
    },
    labelColor: '#fff',
    radius: ['0%', '70%'],
    borderColor: '#001e38',
    title: '成果报奖',
    totalTitle: false,
    series: [
        { name: '外观设计', value: '120' },
        { name: '发明', value: '90' },
        { name: '实用新型', value: '131' }
    ],
    color: ['#45F0FF', '#2687FF', '#1bc85e']
});


// 软件著作权数量
kyptCharts.render({
    id: 'kyxm_charts',
    type: 'bar',
    grid: { top: 40 },
    legend: { show: true, left: 'right', top: 5},
    labelColor: '#fff',
    borderColor: '#001e38',
    data: [
        { name: '核能开发', value1: 21, value2: 76 },
        { name: '集中研发', value1: 46, value2: 18 },
        { name: '国防基础', value1: 18, value2: 55 },
        { name: '国防技术基础', value1: 50, value2: 43 }
    ],
    itemName: 'name',
    series: [
        { name: '在研', valueKey: 'value1', stack: 'kyxm_charts'},
        { name: '已完成', valueKey: 'value2', stack: 'kyxm_charts'}
    ],
    color: ['rgba(107, 100, 96, .3)', ['#25B9FE', '#25B9FE']],
    lineColor: 'rgba(4, 30, 54, 1)',
    valueColor: '#fff',
    labelColor: '#fff',
    yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
    barWidth: 20,
    axisLineColor: 'rgba(255, 255, 255, .2)'
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
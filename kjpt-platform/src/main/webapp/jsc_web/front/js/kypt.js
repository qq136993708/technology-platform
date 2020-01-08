var kypt_charts1 = echarts.init(document.getElementById('kypt_charts1'));
var kypt_charts2 = echarts.init(document.getElementById('kypt_charts2'));
var kypt_charts3 = echarts.init(document.getElementById('kypt_charts3'));
var kypt_charts4 = echarts.init(document.getElementById('kypt_charts4'));
// var kypt_charts5= echarts.init(document.getElementById('kypt_charts5'));

var option1 = {
    tooltip: {
        trigger: 'axis',
        formatter: "{b}： {c}",
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        show: false,
        data: ['2019年'],
        x: 'left',
        textStyle: {
            color: '#fff'
        },
        // formatter:  function(name){
        //     console.log(name);
        //     var total = 0;
        //     var target;
        //     for (var i = 0, l = data.length; i < l; i++) {
        //     total += data[i].value;
        //     if (data[i].name == name) {
        //         target = data[i].value;
        //         }
        //     }
        //     return name + ' ' + ((target/total)*100).toFixed(2) + '%';
        // }
    },
    grid: {
        top: '5%',
        left: '10',
        right: '4%',
        bottom: '1%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01],
        axisLabel: {
            show: false
        },
        splitLine: {
            show: false
        },
        axisTick: {
            show: false,
        },
        axisLine: {
            show: false
        }
    },
    yAxis: {
        type: 'category',
        data: ['板块级', '集团级', '部委级', '省部级', '国家级'],
        axisLabel: {
            textStyle: {
                color: '#fff',
                fontSize: '16'
            }
        },
        splitLine: {
            show: false
        },
        axisTick: {
            show: false,
        },
        axisLine: {
            show: false
        }
    },
    series: [{
        name: '2019年',
        type: 'bar',
        barWidth: '15',
        inverse: true,
        label: {
            normal: {
                show: false
            }
        },
        itemStyle: {
            normal: {
                color: function (params) {
                    if (params.dataIndex == 5) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#FE486D'
                        }, {
                            offset: 1,
                            color: '#FFA164'
                        }]);
                    }
                    if (params.dataIndex == 4) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#6E03E5'
                        }, {
                            offset: 1,
                            color: '#AE3AFF'
                        }]);
                    }
                    if (params.dataIndex == 3) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#00C8DD'
                        }, {
                            offset: 1,
                            color: '#07EDE2'
                        }]);
                    }
                    if (params.dataIndex == 2) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#FFC600'
                        }, {
                            offset: 1,
                            color: '#FFEA00'
                        }]);
                    }
                    if (params.dataIndex == 1) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#FE486D'
                        }, {
                            offset: 1,
                            color: '#FFA164'
                        }]);
                    }
                    if (params.dataIndex == 0) {
                        return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                            offset: 0,
                            color: '#0AFF16'
                        }, {
                            offset: 1,
                            color: '#A1FF01'
                        }]);
                    }
                }
            }
        },
        data: [100, 200, 300, 400, 500]
    }]
};

kypt_charts1.setOption(option1);
kypt_charts2.setOption(option1);
kypt_charts3.setOption(option1);
kypt_charts4.setOption(option1);
kypt_charts1.setOption({
    series: [{
        data: [1, 2, 3, 4, 5],
    }]
});
// kypt_charts1._model.option.series[0].data=[1,2,3,4,5,6];

// 获取远端数据源
httpModule({
    url: '/cockpit/results/queryBIData/scientificResearchNumscientifictype',
    success: function (res) {
        if (res.code === '0' || res.success === true) {
            console.log(res)
            // kyptCharts.reload('kypt_charts5', {data: res.data}); 
        }
    }
});

var chartTime = null;
$(window).resize(function () {
    if (chartTime || chartTime === 0) {
        clearTimeout(chartTime);
    };

    chartTime = setTimeout(function () {
        kypt_charts1.resize();
        kypt_charts2.resize();
        kypt_charts3.resize();
        kypt_charts4.resize();
    }, 120);
})

// 科研平台数量按技术领域
kyptCharts.render({
    id: 'kypt_charts5',
    type: 'bar',
    legend: {
        show: false
    },
    lineColor: '#1E5389',
    valueColor: '#fff',
    labelColor: '#fff',
    label: false,
    itemName: 'typeName',
    borderColor: '#001e38',
    title: '科研平台数量',
    barMinHeight: 2,
    // labelRotate: 30,
    labelLenth: 9,
    labelMaxNumber: 10,
    data: [],
    series: [{
        name: '数量',
        valueKey: 'num'
    }],
    color: [
        ['#4E00FF', '#43F0FF']
    ]
});

// 获取远端数据源
httpModule({
    url: '/cockpit/results/queryBIData/scientificResearchNumscientifictechnology',
    success: function (res) {
        if (res.code === '0' || res.success === true) {
            kyptCharts.reload('kypt_charts5', {
                data: res.data
            });
        }
    }
});
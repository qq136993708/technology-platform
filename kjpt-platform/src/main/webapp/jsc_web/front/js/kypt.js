var kypt_charts1= echarts.init(document.getElementById('kypt_charts1'));
var kypt_charts2= echarts.init(document.getElementById('kypt_charts2'));
var kypt_charts3= echarts.init(document.getElementById('kypt_charts3'));
var kypt_charts4= echarts.init(document.getElementById('kypt_charts4'));
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
        x:'left',
        textStyle:{
            color:'#fff'
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
        top:'5%',
        left: '10',
        right: '4%',
        bottom: '1%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01],
        axisLabel:{
            show: false
        },
        splitLine:{
            show:false
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
        data: ['板块级','集团级','部委级','省部级','国家级'],
        axisLabel:{
            textStyle:{
                color:'#fff',
                fontSize:'16'
            }
        },
        splitLine:{
            show:false
        },
        axisTick: {
            show: false,
        },
        axisLine: {
            show: false
        }
    },
    series: [
        {
            name: '2019年',
            type: 'bar',
            barWidth: '15',
            inverse: true,
            label: {
                normal: {
                    show: false
                }
            },
            itemStyle:{
                normal:{
                    color:function(params){
                        if(params.dataIndex==5){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#FE486D'
                            }, {
                                offset: 1,
                                color: '#FFA164'
                            }]);
                        }
                        if(params.dataIndex==4){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#6E03E5'
                            }, {
                                offset: 1,
                                color: '#AE3AFF'
                            }]);
                        }
                        if(params.dataIndex==3){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#00C8DD'
                            }, {
                                offset: 1,
                                color: '#07EDE2'
                            }]);
                        }
                        if(params.dataIndex==2){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#FFC600'
                            }, {
                                offset: 1,
                                color: '#FFEA00'
                            }]);
                        }
                        if(params.dataIndex==1){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#FE486D'
                            }, {
                                offset: 1,
                                color: '#FFA164'
                            }]);
                        }
                        if(params.dataIndex==0){
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
            data: [100, 200, 300, 400, 500, 600]
        }
    ]
};

kypt_charts1.setOption(option1);
kypt_charts2.setOption(option1);
kypt_charts3.setOption(option1);
kypt_charts4.setOption(option1);



var chartTime = null;
$(window).resize(function() {
  if (chartTime || chartTime === 0) {
    clearTimeout(chartTime);
  };

  chartTime = setTimeout(function() {
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
    legend: { show: false },
    lineColor: '#1E5389',
    valueColor: '#fff',
    labelColor: '#fff',
    label: false,
    itemName: 'name',
    borderColor: '#001e38',
    title: '科研平台数量',
    data: [
        {name: '技术领域1', value: 143},
        {name: '技术领域2', value: 423},
        {name: '技术领域3', value: 63},
        {name: '技术领域4', value: 93},
        {name: '技术领域5', value: 113},
        {name: '技术领域6', value: 203},
        {name: '技术领域7', value: 120},
        {name: '技术领域8', value: 69},
        {name: '技术领域9', value: 91},
        {name: '技术领域10', value: 210},
        {name: '技术领域11', value: 150},
        {name: '技术领域12', value: 50}
    ],
    series: [
        {name: '数量', valueKey: 'value'},
    ],
    color: [['#4E00FF', '#43F0FF']]
});









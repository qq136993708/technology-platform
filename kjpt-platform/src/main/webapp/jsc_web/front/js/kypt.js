var kypt_charts1= echarts.init(document.getElementById('kypt_charts1'));
var kypt_charts2= echarts.init(document.getElementById('kypt_charts2'));
var kypt_charts3= echarts.init(document.getElementById('kypt_charts3'));
var kypt_charts4= echarts.init(document.getElementById('kypt_charts4'));
var kypt_charts5= echarts.init(document.getElementById('kypt_charts5'));

var option1 = {
    tooltip: {
        trigger: 'axis',
        formatter: "{b}： {c}%",
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
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
        data: ['平台一','平台二','平台三','平台四','平台五','平台六'],
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

var option5 = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            backgroundColor:'rgba(38,84,113,0.5)',
            borderColor:'#0897a0',
            borderWidth:1
        },
    
        legend: {
            show:false,
            data:['本年'],
            itemWidth: 10,  // 设置宽度
    　　    itemHeight: 10, // 设置高度
    　　    itemGap: 40, // 设置间距
            x:'right',
            textStyle:{
                color:'#fff',
                fontSize:14
            }
        },
        color:['#4526FF','#00AEFF','#EAFF74'],
        grid: {
            x:'3%',
            x2:'3%',
            y:'15%',
            y2:'20%',
        },
        xAxis: [
            {
                type: 'category',
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                axisLabel:{
                    textStyle:{
                        color:'#fff',
                        fontSize:'16'
                    }
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '',
                axisLabel:{
                    textStyle:{
                        color:'#fff',
                        fontSize:'16'
                    }
                },
                axisLine:{
                    show:true,
                    lineStyle:{
                        color:['rgba(30,83,137,0.6)']
                    }
                },
                splitLine:{
                    lineStyle:{
                        color:['rgba(30,83,137,0.6)']
                    }
                }
            }
        ],
        series: [
            {
                name:'本年',
                type:'bar',
                barWidth:30,
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                itemStyle:{
                    normal:{
                        color:function(params){
                            return new echarts.graphic.LinearGradient(1, 0, 0, 1, [{
                                offset: 0,
                                color: '#43F0FF'
                            }, {
                                offset: 1,
                                color: '#4E00FF'
                            }]);
                        }
                    }
                },
            }
        ]
    };
kypt_charts1.setOption(option1);
kypt_charts2.setOption(option1);
kypt_charts3.setOption(option1);
kypt_charts4.setOption(option1);
kypt_charts5.setOption(option5);









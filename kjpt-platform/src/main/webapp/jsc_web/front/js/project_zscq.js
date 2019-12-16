var color = ['#FFF04E', '#FF7F5D', '#2687FF']
option1 = {
    tooltip: {
        trigger: 'item',
        formatter: "{b} <br/>{c}"
    },
    legend: {
        orient: 'vertical',
        right: '10%',
        top: 'middle',
        textStyle: {
            color: '#ffffff',
        },
        // data: ['发明专利', '你用新型', '联盟外观设计']
    },
    series: [
        {
            type: 'pie',
            center: ['30%', '50%'],
            radius: ['60%', '80%'],
            avoidLabelOverlap: false,
            color: color,
            label: {
                normal: {
                    show: false,
                    position: 'center',
                    formatter: '{c}'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
        }
    ]
};

option2 = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        // data: ['2017', '2018', '2019'],
        textStyle: {
            color: '#ffffff'
        },
        right: '10%',
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'value',
        axisLabel: {
            color: '#ffffff',
            formatter: '{value}'
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: ['rgba(30,83,137,0.6)']
            }
        },
        splitLine: {
            lineStyle: {
                color: ['rgba(30,83,137,0.6)']
            }
        }
    },
    yAxis: {
        type: 'category',
        inverse: true,
        // data: ['专利总数', '国内专利', '国外专利'],
        axisLine: {
            show: true,
            lineStyle: {
                color: ['rgba(30,83,137,0.6)']
            }
        },
        splitLine: {
            lineStyle: {
                color: ['rgba(30,83,137,0.6)']
            }
        },
        axisLabel: {
            color: '#ffffff',
            margin: 20,
            rich: {
                value: {
                    lineHeight: 30,
                    align: 'center'
                },
            }
        }
    },
    toolbox: {
        show: false,
    },
    color: color,
    series: [
        // {
        //     name: '2017',
        //     type: 'bar',
        //     barGap: '0%',
        //     data: [165, 170, 30],
        // },
        // {
        //     name: '2018',
        //     type: 'bar',
        //     barGap: '0%',
        //     data: [150, 105, 110]
        // },
        // {
        //     name: '2019',
        //     type: 'bar',
        //     barGap: '0%',
        //     data: [220, 82, 63]
        // }
    ]
};

var option3 = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        },
        backgroundColor: 'rgba(38,84,113,0.5)',
        borderColor: '#0897a0',
        borderWidth: 1
    },

    legend: {
        show: true,
        data: ['本年', '上年', '同比'],
        itemWidth: 10,  // 设置宽度
        itemHeight: 10, // 设置高度
        itemGap: 40, // 设置间距
        x: 'right',
        textStyle: {
            color: '#fff',
            fontSize: 14
        }
    },
    color: ['#4526FF', '#00AEFF', '#EAFF74'],
    grid: {
        x: '3%',
        x2: '3%',
        y: '15%',
        y2: '20%',
    },
    xAxis: [
        {
            type: 'category',
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            axisLabel: {
                textStyle: {
                    color: '#fff',
                    fontSize: '16'
                }
            }
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '',
            axisLabel: {
                textStyle: {
                    color: '#fff',
                    fontSize: '16'
                }
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: ['rgba(30,83,137,0.6)']
                }
            },
            splitLine: {
                lineStyle: {
                    color: ['rgba(30,83,137,0.6)']
                }
            }
        }
    ],
    series: [
        {
            name: '本年',
            type: 'bar',
            barWidth: 20,
            barGap: 0,
            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
        },
        {
            name: '上年',
            type: 'bar',
            barWidth: 20,
            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        },
        {
            name: '同比',
            type: 'line',
            barWidth: 20,
            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        }
    ]
};

var chartsBox1 = echarts.init(document.getElementById('chartsBox1')); //初始化
var chartsBox2 = echarts.init(document.getElementById('chartsBox2'));
var chartsBox3 = echarts.init(document.getElementById('chartsBox3'));

var api = {
    numOrType: '/cockpit/knowledgeRight/numOrType', //专利类型占比
    numOrUnit: '/cockpit/knowledgeRight/numOrUnit', //单位同比
    numYearTrend: '/cockpit/knowledgeRight/numYearTrend' //年度趋势分析
}

httpModule({
    url: api.numOrType,
    type: 'POST',
    success: setNumOrType
})

httpModule({
    url: api.numYearTrend,
    type: 'POST',
    success: setNumYearTrend
})

httpModule({
    url: api.numOrUnit,
    type: 'POST',
    success: setNumOrUnit
})

function setNumOrType(data){ //设置类型占比配置项
    if(data.code == 0){
        var result = data.data;
        if(result){
            var str = JSON.stringify(result);
            str = str.replace(/count/g,'value');
            str = str.replace(/patent_type_text/g,'name');
            result = JSON.parse(str);
        }
        var legendArr = result.map(function(item,index){
            return item.name;
        })
        option1.legend.data = legendArr; //设置legend
        option1.series[0].data = result; //赋值
        chartsBox1.setOption(option1);
    }else{
        layer.msg(data.message);
    }
}

function setNumYearTrend(data){ //设置年度趋势
    if(data.code == 0){
        var result = data.data;
        if(result){

            var datas = [];
            var count = {
                count1:[],
                count2:[],
                count3:[]
            }
            var years = new Date().getFullYear();
            for(var i = 0; i < 3; i++){
                var obj = {};
                obj['type'] = 'bar';
                obj['barGap'] = '0%';
                obj['name'] = years-i;
                obj['data'] = count['count'+(i+1)];
                datas.push(obj);
            }

            var legendArr = result.map(function(item,index){
                count.count1.push(item['count1']);
                count.count2.push(item['count2']);
                count.count3.push(item['count3']);   
                return item.application_type_text;
            })
            
            console.log('datas',datas);
            option2.legend.data = [String(years-2),String(years-1),String(years-0)];
            option2.yAxis.data = legendArr;
            option2.series = datas;
            chartsBox2.setOption(option2);
        }
    }else{
        layer.msg(data.message);
    }
}

function setNumOrUnit(data){
    if(data.code == 0){
        var result = data.data;
        if(result){
            
        }
    }else{
        layer.msg(data.message);
    }
}


chartsBox3.setOption(option3);

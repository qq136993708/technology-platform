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
        data: ['发明专利', '你用新型', '联盟外观设计']
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
            graphic: [
                {
                    type: 'text',
                    id: 'text1',
                    left: 'center',
                    top: 'middle',
                    style: {
                        text: 'test111',       // 文本块文字。可以使用 \n 来换行。[ default: '' ]
                        fill: '#ffffff',           // 填充色。
                        fontSize: 20,
                        fontWeight: 'bold'
                    }
                }
            ],
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: [
                { value: 335, name: '发明专利' },
                { value: 310, name: '你用新型' },
                { value: 234, name: '联盟外观设计' },
            ]
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
        data: ['2017', '2018', '2019'],
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
        data: ['专利总数', '国内专利', '国外专利'],
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
        {
            name: '2017',
            type: 'bar',
            barGap: '0%',
            data: [165, 170, 30],
        },
        {
            name: '2018',
            type: 'bar',
            barGap: '0%',
            data: [150, 105, 110]
        },
        {
            name: '2019',
            type: 'bar',
            barGap: '0%',
            data: [220, 82, 63]
        }
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

var chartsBox1 = echarts.init(document.getElementById('chartsBox1'));
chartsBox1.setOption(option1);
var chartsBox2 = echarts.init(document.getElementById('chartsBox2'));
chartsBox2.setOption(option2);
var chartsBox3 = echarts.init(document.getElementById('chartsBox3'));
chartsBox3.setOption(option3);

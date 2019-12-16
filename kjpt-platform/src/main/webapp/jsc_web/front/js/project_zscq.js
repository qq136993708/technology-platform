var color = ['#FFF04E','#FF7F5D','#2687FF']
option1 = {
    tooltip: {
        trigger: 'item',
        formatter: "{b} <br/>{c}"
    },
    legend: {
        orient: 'vertical',
        right:'10%',
        top:'middle',
        textStyle:{
            color:'#ffffff',
        },
        data:['发明专利','你用新型','联盟外观设计']
    },
    series: [
        {
            type:'pie',
            center: ['30%', '50%'],
            radius: ['60%', '80%'],
            avoidLabelOverlap: false,
            color:color,
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
            graphic:[
                {
                    type:'text',
                    id: 'text1',
                    left:'center',
                    top:'middle',
                    style:{
                        text: 'test111',       // 文本块文字。可以使用 \n 来换行。[ default: '' ]
                        fill: '#ffffff',           // 填充色。
                        width: 30,
                        height: 30,
                        fontSize: 20,
                        // fontSize: 32,           // 字体大小
                        fontWeight: 'bold'
                    }
                }
            ],
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'发明专利'},
                {value:310, name:'你用新型'},
                {value:234, name:'联盟外观设计'},
            ]
        }
    ]
};

var chartsBox1 = echarts.init(document.getElementById('chartsBox1'));
chartsBox1.setOption(option1);

layui.use(['element'], function () {
    var element = layui.element;
    // element.progress('progressDemo', '50%');

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
        // borderColor: '#001e38',
        title: '成果鉴定',
        totalTitle: true,
        company:'个',
        title: {
            textStyle: {
                color: '#fff',
                fontSize: 24,
                width: '100%'
            },
            subtextStyle:{
                color: '#fff',
                fontSize: 12,
                width: '100%',
                verticalAlign:'bottom',
            }
        },
        series: [
            { name: '国家级', value: '9' ,page:'kynl_page'},
            { name: '国家部委级', value: '12' ,page:'kynl_page'},
            { name: '地方省级', value: '10' ,page:'kynl_page'},
            { name: '集团级', value: '8' ,page:'kynl_page'},
            { name: '板块级', value: '11',page:'kynl_page' }
        ],
        color: ['#2687FF', '#6BD04A', '#EFEC56', '#D89339', '#D66635'],
        callback:function(param){
            param.on('click',function(data){
                // var openUrl={
                //     url:'/jsc_web/front/kynl_page.html',
                //     name:'科研能力'
                // }
                // debugger
                jscPup('kynl_page',encodeURI(data.name));
                // $('#top-header-nav', parent.document).find('.tab_button').removeClass('btnactive');
                // $('#top-header-nav .transR' , parent.document).each(function(item){
                //     console.log($(this).attr('href'))
                //     var itemHref = $(this).attr('href');
                //     if(itemHref == 'kynl_page'){
                //         $(this).addClass('btnactive');
                //     }
                // })
                // window.location.href='/jsc_web/front/kynl_page.html';
                // window.open('/index', 'kjpt_webapp');
                // localStorage.setItem("url", JSON.stringify(openUrl));
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
        // borderColor: '#001e38',
        title: '成果报奖',
        totalTitle: true,
        company:'项',   
        title: {
            textStyle: {    
                color: '#fff',
                fontSize: 24,
                width: '100%'
            },
            subtextStyle:{
                color: '#fff',
                fontSize: 12,
                width: '100%',
                verticalAlign:'bottom',
            }
        },
        series: [
            { name: '国家级奖', value: '143',page:'achieve_award' },
            { name: '省部级奖', value: '120' ,page:'achieve_award'},
            { name: '集团奖', value: '325' ,page:'achieve_award'},
            { name: '社会奖项', value: '184' ,page:'achieve_award'}
        ],
        color: ['#4526D4', '#3461D3', '#5ABEE7', '#74E8D0'],
        callback:function(param){
            param.on('click',function(){
            //     var openUrl={
            //         url:'/html/patent/query.html',
            //         name:'专利管理'
            //     }
            //     window.open('/index', 'kjpt_webapp');
            //     localStorage.setItem("url", JSON.stringify(openUrl));
            jscPup('achieve_award');
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
                    borderRadius: 3,
                }
            }
        },
        labelColor: '#fff',
        radius: ['0%', '70%'],
        // borderColor: '#001e38',
        title: '成果报奖',
        totalTitle: false,
        series: [
            { name: '外观设计', value: '120' },
            { name: '发明', value: '90' },
            { name: '实用新型', value: '131' }
        ],
        color: ['#297cce', '#efb614', '#18cdea'],
        callback:function(param){
            param.on('click',function(){
                jscPup('kypt');
            })
        },
    });


    // 科研项目
    kyptCharts.render({
        id: 'kyxm_charts',
        type: 'bar',
        grid: { top: 40 },
        legend: { show: true, left: 'right', top: 5},
        labelColor: '#fff',
        // borderColor: '#001e38',
        data: [
            { name: '核能开发', value1: 21, value2: 76 },
            { name: '集中研发', value1: 10, value2: 38 },   
            { name: '国防基础', value1: 18, value2: 55 },
            { name: '国防技术基础', value1: 50, value2: 43 }
        ],
        itemName: 'name',
        series: [
            { name: '在研', valueKey: 'value1', stack: 'kyxm_charts'},
            { name: '已完成', valueKey: 'value2', stack: 'kyxm_charts'}
        ],
        color: ['rgba(107, 100, 96, .3)', ['#31E1F6','#386BEE']],
        lineColor: 'rgba(4, 30, 54, 1)',
        valueColor: '#fff',
        labelColor: '#fff',
        yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
        barWidth: 20,
        axisLineColor: 'rgba(255, 255, 255, .2)',
        // callback:function(param){
        //     param.on('click',function(){
        //         jscPup('achieve_award');
        //     })
        // },
    });
    $('.orange').on('click',function(){
        jscPup('kypt');
    })
    // $('.item_number').on('click',function(){
    //     jscPup('achieve_award'); 
    // })
    // HTTP请求公式
    function loadData() {
        httpModule({
            url: "/cockpit/results/queryBIData/indexKnowledgeRightCount",
            success: function (result) {
                
            },
            errro: function (data) {
                
            }
        });
    }
});
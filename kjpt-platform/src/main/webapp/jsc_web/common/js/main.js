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
                fontSize: 30,
                width: '100%',
                fontFamily:'Impact'
            },
            subtextStyle:{
                color: '#fff',
                fontSize: 12,
                width: '100%',
                verticalAlign:'bottom',
            }
        },
        series:[],
        color: ['#2687FF', '#6BD04A', '#EFEC56', '#D89339', '#D66635'],
        callback:function(param){
            param.on('click',function(data){
                // var openUrl={
                //     url:'/jsc_web/front/kynl_page.html',
                //     name:'科研能力'
                // }
                // debugger

                top.childrenClickItem('kynl_page', '?name=' + encodeURI(data.name));

                // jscPup('kynl_page', encodeURI(data.name));
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
                fontSize: 30,
                width: '100%',
                fontFamily:'Impact'
            },
            subtextStyle:{
                color: '#fff',
                fontSize: 12,
                width: '100%',
                verticalAlign:'bottom',
            }
        },
        series: [],
        color: ['#4526D4', '#3461D3', '#5ABEE7', '#74E8D0'],
        callback:function(param){
            param.on('click',function(){
                //     var openUrl={
                //         url:'/html/patent/query.html',
                //         name:'专利管理'
                //     }
                //     window.open('/index', 'kjpt_webapp');
                //     localStorage.setItem("url", JSON.stringify(openUrl));
                // jscPup('achieve_award');
                top.childrenClickItem('achieve_award');
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
                    lineHeight: 24,
                    fontSize: 14,
                    align: 'center',
                    padding: [0, 6, 3, 6],
                    borderRadius: 3,
                    borderColor: 'rgba(30, 83, 137, .6)'
                },
            }
        },
        labelColor: '#fff',
        radius: ['0%', '70%'],
        // borderColor: '#001e38',
        title: '成果报奖',
        totalTitle: false,
        series: [],
        color: ['#297cce', '#efb614', '#18cdea'],
        callback:function(param){
            param.on('click',function(){
                // jscPup('kypt');
                top.childrenClickItem('kypt');
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
        tooltip: { trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } }},
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
        valueColor: '#fff',
        labelColor: '#fff',
        yAxis: [{splitNumber: 3, name: '单位：个', nameGap: 20, nameTextStyle: {color: '#fff'}}],
        barWidth: 20,
        lineColor: 'rgba(30, 83, 137, .6)',
        axisLineColor: 'rgba(30, 83, 137, .6)',
        showMask: { img: '/images/mask_bg.png', text: '该内容请在密网中查看！' }
        // callback:function(param){
        //     param.on('click',function(){
        //         jscPup('achieve_award');
        //     })
        // },
    });
    $('.orange').on('click',function(){
        // jscPup('kypt');
        top.childrenClickItem('kypt');
    })
    // $('.item_number').on('click',function(){
    //     jscPup('achieve_award'); 
    // })
    
    //科技专家 
    function loadExperts() { 
        httpModule({
            url: "/getZjkTongjiList",
            success: function (result) {
                if(result.success){
                    $.each(result.data,function(index,item){
                        if(item.name == '中国科学院院士'){
                            $('#academy').text(item.value)
                        }else if(item.name == '中国工程院院士'){
                            $('#engineering').text(item.value)
                        }else if(item.name == '“高层次人才引进计划”专家'){
                            $('#senior').text(item.value)
                        }else if(item.name == '其他省部级人才计划'){
                            $('#provincial').text(item.value)
                        }else if(item.name == '集团首席专家'){
                            $('#group').text(item.value)
                        }else if(item.name == '项目两总'){
                            $('#manager').text(item.value)
                        }
                    })
                }else{

                }
            }
        });
    };
    //科研平台 -- 饼图
    function loadResearchPlatform(option) {
        httpModule({
            url: option.url,
            success: function (result) {
                if(result.success){
                var curList=[];
                if(option.page){
                    $.each(result.data,function(index,item){
                    if(option.page == 'kynl_page'){
                        item.name=item.name.replace(/科研平台/, "")
                    }
                    item['page'] = option.page;
                })
                curList=result.data;
                }else{
                    curList=result.data;
                }
                console.log(curList);
                kyptCharts.reload(option.id,{
                    series:curList
                })
            }
            }
        });
    };
    //知识产权（累计)
    function loadIntellectual() {
        httpModule({
            url: "/getRightsMap",
            success: function (result) {   
                if(result.success) {
                    $('#patent').text(result.data.patentCount);
                    $('#trademark').text(result.data.trademarkInfoCount);
                    $('#copyright').text(result.data.computerSoftwareCount);
                    $('#paper').text(result.data.treatiseInfoCount);
                }
                // $.each(result[1],function(index,item){
                //     if(item.text == '专利'){
                //         $('#patent').text(item.calValue);
                //     }else if(item.text == '商标'){
                //         $('#trademark').text(item.calValue);
                //     }else if(item.text == '软件著作权'){
                //         $('#copyright').text(item.calValue);
                //     }else if(item.text == '论文'){
                //         $('#paper').text(item.calValue);
                //     } 
                // })
            }
        });
    };
    function loadAchievements() {
        httpModule({
            url: "/indexHomeBI-api/getAchieveTransfer",
            success: function (result) {
                if(result.success){
                $.each(result,function(index,item){
                    if(item.text == '申请数量'){
                        $('#applications').text(item.calValue);
                    }else if(item.text == '完成数量'){
                        $('#completed').text(item.calValue);
                    }else if(item.text == '完成金额'){
                        $('#amount').text(item.calValue);
                    }
                })
            }
            }
        });
    };
    // { name: '核能开发', value1: 21, value2: 76 },
    //         { name: '集中研发', value1: 10, value2: 38 },   
    //         { name: '国防基础', value1: 18, value2: 55 },
    //         { name: '国防技术基础', value1: 50, value2: 43 }
    // 科研项目
    function loadResearch() {
        httpModule({
            url: "/indexHomeBI-api/getTechnologyProject",
            success: function (result) {
                console.log(result)
            },
            errro: function (data) {
                
            }
        });
    }
    loadExperts();
    loadIntellectual();
    loadAchievements();
    // loadResearch();
    // 科研平台
    loadResearchPlatform({
        url:'/getKyptInfoGrupCountList',
        id:'kypt_charts',
        page:'kynl_page'
    });
    //成果获奖（累计)
    loadResearchPlatform({
        url:'/getAchieveMaintainGrupCountList',
        id:'achieve_charts',
        page:'achieve_award'
    });
    //专利数量(累计)
    loadResearchPlatform({
        url:'/getPatentCountByType',
        id:'patent_charts',
    });

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
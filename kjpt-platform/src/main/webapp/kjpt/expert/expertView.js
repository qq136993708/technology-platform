layui.use(['form', 'table', 'layer', 'element'], function(){
    var form = layui.form,$ = layui.$,table = layui.table, element = layui.element;
    // 获取页面参数ID
    var variable = getQueryVariable();
    if(variable!=null){
        httpModule({
            url: '/expert-api/get/'+variable.id,
            type: 'GET',
            success: function(relData) {
                if (relData.success === true) {
                    if(relData.data.headPic!=''){
                        $("#img img").attr("src",'/file/imgFile/'+relData.data.headPic)
                    }
                    setTargetNameValue(relData.data)
                }
            }
        });
    }
    $(".label-value").eq(2).hover(function () {
        $(this).attr("title",$(this).html())
    })
    var projectArr=[
        {type: 'radio' },
        {title: '序号',type:'numbers',width:55 },
        {field: 'projectName', title: '项目名称'},
        {field: 'chargeUnitStr', title: '负责单位'},
        {field: 'researchTarget', title: '研究目标' },
        {field: 'setupYeat', title: '立项年度'},
        {field: 'secretLevelStr', title: '密级'},
    ]
    tableRender('project',projectArr,'/expert-project-api/page',variable.id)
    var achievementsArr=[
        {type: 'radio' },
        {title: '序号',type:'numbers',width:55 },
        {field: 'achieveName', title: '成果名称'},
        {field: 'applyUnitStr', title: '申请单位'},
        {field: 'achieveTypeStr', title: '成果类别' },
        {field: 'applyYear', title: '申请年度'},
        {field: 'secretLevelStr', title: '密级'},
    ]
    tableRender('achievements',achievementsArr,'/expert-achievement-api/page',variable.id)
    var patentArr=[
        {type: 'radio' },
        {title: '序号',type:'numbers' ,width:55},
        {field: 'patentName', title: '专利名称'},
        {field: 'patentTypeStr', title: '专利类型'},
        {field: 'getPatentTimeStr', title: '申请日期' },
        {field: 'describe', title: '专利描述'},
        {field: 'secretLevelStr', title: '密级'},
    ]
    tableRender('patent',patentArr,'/expert-patent-api/page',variable.id)
    var rewardArr=[
        {type: 'radio' },
        {title: '序号',type:'numbers',width:55 },
        {field: 'rewarkLevelStr', title: '奖励级别'},
        {field: 'notes', title: '奖励描述'},
        {field: 'awardingUnit', title: '授奖单位' },
        {field: 'awardingTimeStr', title: '获奖日期'},
        {field: 'secretLevelStr', title: '密级'},
    ]
    tableRender('reward',rewardArr,'/expert-reward-api/page',variable.id)
    function tableRender(id,cols,url,where) {
        table.render({
            elem: '#'+id // 表格元素ID
            ,url:url //数据接口
            ,cols: [cols],
            method: 'post', // 数据请求接口类型 默认 get, 如果是get 可以去掉此项
            where: {
                useID: 'admin' // 表格请求时传递的参数
                ,expertId:where
                //  默认请求参数 页码 => page, 每页条数 => limit
            }
            ,request: {
                page: 'pageIndex', // 重置默认分页请求请求参数 page => pageIndex
                limit: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
            },
            done:function (res, curr, count) {
                console.log(res)
                console.log($("." +id))
                $("." +id).html(res.count)
            }
            , page: true //开启分页
            , limit: 15
            , limits: [15, 30, 45, 60], // 配置分页数据条数
        });
    }
    function openLayer(obj) {
        top.layer.open({
            type: 2,
            title: obj.title,
            content: obj.url, // 全局弹窗页面地址
            btn: null,
            area: ['50%', '60%'],
            end: function(lay, index) {
                // 弹窗销毁时获取弹窗返回数据
                var getData = getDialogData('dialog-data');
                if(getData.success){
                    tableRender(obj.tableName,obj.arr,obj.tableUrl,variable.id)
                }
            }
        });
    }
    function deleData(obj) {
        var activeData = table.checkStatus(obj.id).data;
        console.log(activeData)
        if(activeData.length==0){
            layer.msg('请选择要删除的数据!');
            return false
        }
        top.layer.confirm('您确定要删除吗？', {icon: 3, title:'删除提示'}, function(index){
            layer.close(index);
            // 确认删除
            httpModule({
                url: obj.url+activeData[0].id,
                type: "get",
                success: function(e) {
                    console.log(e)
                    if(e.success){
                        layer.msg('删除成功!');
                        top.layer.closeAll(); // 关闭弹窗
                        tableRender(obj.tableName,obj.arr,obj.tableUrl,variable.id)
                    }
                }
            });
        });
    }
    var activeTab = 0;
    // 监控tab签切换
    element.on('tab(platformDetails)', function(data) {
        activeTab = data.index;
        if (activeTab) {
            table.reload(tableFilterArr[activeTab].tableId);
        }
    })
    var tableFilterArr = [
        {tableName: '', title: '人物简介',arr:[],tableUrl:'' },
        {tableName: '', title: ' 人物成就',arr:[],tableUrl:''},
        {tableName: 'project', title: '相关项目',arr:projectArr,tableUrl:'/expert-project-api/page'},
        {tableName: 'achievements', title: '成果信息',arr:achievementsArr,tableUrl:'/expert-achievement-api/page'},
        {tableName: 'patent', title: '专利信息',arr:patentArr,tableUrl:'/expert-patent-api/page'},
        {tableName: 'reward', title: '奖励信息',arr:rewardArr,tableUrl:'/expert-reward-api/page'},

    ];
    // 导入
    $('.ib-button').each(function(e) {
        var buttonId = $(this).attr('id'),
            exportType = $(this).attr('export-type');
        importFiles({
            id: buttonId,
            url: '/excelImport/'+ exportType +'?pid=' + variable.id,
            callback: function(res, type) {
                if (res.code === '0') {
                    layer.msg('数据导入成功!', {icon: 1});
                    tableRender(tableFilterArr[activeTab].tableName,tableFilterArr[activeTab].arr,tableFilterArr[activeTab].tableUrl,variable.id)
                }
            }
        });
    })
    var $ = layui.$, active = {
        projectAdd:function () {
            var obj={
                title:'添加项目',
                url:'/kjpt/expert/project_add.html?expertId='+variable.id,
                tableName:'project',
                arr:projectArr,
                tableUrl:'/expert-project-api/page'
            }
            openLayer(obj)
        },
        projectEdit:function(){
            var activeData = table.checkStatus('project').data;
            console.log(activeData)
            if(activeData.length==0){
                layer.msg('请选择要编辑的数据!');
                return false
            }
            var obj={
                title:'编辑项目',
                url:'/kjpt/expert/project_add.html?expertId='+variable.id+"&id="+activeData[0].id,
                tableName:'project',
                arr:projectArr,
                tableUrl:'/expert-project-api/page'
            }
            openLayer(obj)
        },
        projectDelete:function(){
            var obj={
                id:'project',
                tableName:'project',
                url:'/expert-project-api/delete/',
                arr:projectArr,
                tableUrl:'/expert-project-api/page'
            }
            deleData(obj)

        },
        achievementsAdd:function () {
            var obj={
                title:'添加成果',
                url:'/kjpt/expert/achievements_add.html?expertId='+variable.id,
                tableName:'achievements',
                arr:achievementsArr,
                tableUrl:'/expert-achievement-api/page'
            }
            openLayer(obj)
        },
        achievementsEdit:function(){
            var activeData = table.checkStatus('achievements').data;
            console.log(activeData)
            if(activeData.length==0){
                layer.msg('请选择要编辑的数据!');
                return false
            }
            var obj={
                title:'编辑成果',
                url:'/kjpt/expert/achievements_add.html?expertId='+variable.id+"&id="+activeData[0].id,
                tableName:'achievements',
                arr:achievementsArr,
                tableUrl:'/expert-achievement-api/page'
            }
            openLayer(obj)
        },
        achievementsDelete:function(){
            var obj={
                id:'achievements',
                tableName:'achievements',
                url:'/expert-achievement-api/delete/',
                arr:achievementsArr,
                tableUrl:'/expert-achievement-api/page'
            }
            deleData(obj)

        },
        patentAdd:function () {
            var obj={
                title:'添加专利',
                url:'/kjpt/expert/patent_add.html?expertId='+variable.id,
                tableName:'patent',
                arr:patentArr,
                tableUrl:'/expert-patent-api/page'
            }
            openLayer(obj)
        },
        patentEdit:function(){
            var activeData = table.checkStatus('patent').data;
            console.log(activeData)
            if(activeData.length==0){
                layer.msg('请选择要编辑的数据!');
                return false
            }
            var obj={
                title:'编辑专利',
                url:'/kjpt/expert/patent_add.html?expertId='+variable.id+"&id="+activeData[0].id,
                tableName:'patent',
                arr:patentArr,
                tableUrl:'/expert-patent-api/page'
            }
            openLayer(obj)
        },
        patentDelete:function(){
            var obj={
                id:'patent',
                tableName:'patent',
                url:'/expert-patent-api/delete/',
                arr:patentArr,
                tableUrl:'/expert-patent-api/page'
            }
            deleData(obj)

        },
        rewardAdd:function () {
            var obj={
                title:'添加奖励',
                url:'/kjpt/expert/reward_add.html?expertId='+variable.id,
                tableName:'reward',
                arr:rewardArr,
                tableUrl:'/expert-reward-api/page'
            }
            openLayer(obj)
        },
        rewardEdit:function () {
            var activeData = table.checkStatus('reward').data;
            console.log(activeData)
            if(activeData.length==0){
                layer.msg('请选择要编辑的数据!');
                return false
            }
            var obj={
                title:'编辑奖励',
                url:'/kjpt/expert/reward_add.html?expertId='+variable.id+"&id="+activeData[0].id,
                tableName:'reward',
                arr:rewardArr,
                tableUrl:'/expert-reward-api/page'
            }
            openLayer(obj)
        },
        rewardDelete:function(){
            var obj={
                id:'reward',
                tableName:'reward',
                url:'/expert-reward-api/delete/',
                arr:rewardArr,
                tableUrl:'/expert-reward-api/page'
            }
            deleData(obj)

        },
    }
    $('.layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    // 导出
    $('.importData').click(function() {
        var importUrl = '';
        switch ($(this).data('item')+'') {
            case '1':
                // 项目
                importUrl =  '/expertProject-api/export?expertId='+ variable.id;
                break;
            case '2':
                // 成果
                importUrl =  '/expertAchievement-api/export?expertId='+ variable.id;
                break;
            case '3':
                // 专利
                importUrl =  '/expertPatent-api/export?expertId='+ variable.id;
                break;
            case '4':
                // 奖励
                importUrl =  '/expertReward-api/export?expertId='+ variable.id;
                break;
        }
        window.open(importUrl, '_blank');
    })
});
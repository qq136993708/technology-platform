var domianUrl = "webKJQTApi";//接口转发匹配路径

layui.use(['form', 'laydate', 'table'], function () {

    var itemRowData = null; // 选中行的数据
    var tableRender = false; // 节流

    var laydate = layui.laydate; //设置时间筛查范围
    var table = layui.table; //操作表格
    var form = layui.form; //操作表单

    function queryTable(searchData) { //表格渲染
        if (!tableRender) {
            table.render({
                elem: '#tableContent',
                cols: [
                    [
                        {
                            field: 'id',
                            type: 'radio',
                        },
                        {
                            field: 'unitNameText',
                            title: '单位名称'

                        },
                        {
                            field: 'trademarkName',
                            title: '注册商标名称'
                        },
                        {
                            field: 'commodityCategoryText',
                            title: '核定使用商品大类'
                        },
                        {
                            field: 'legalStatusText',
                            title: '法律状态'
                        },
                        {
                            field: 'applicant',
                            title: '申请人'
                        },
                        {
                            field: 'registerDate',
                            title: '注册日期',
                            templet:'#registerDate'
                        },
                        {
                            field: 'effectiveDate',
                            title: '有效日期',
                            templet:'#effectiveDate'
                        },
                        {
                            field: 'applicationNumber',
                            title: '商标申请号'
                        },
                        {
                            field: 'registerNoticeDate',
                            title: '注册公告日',
                            templet:'#registerNoticeDate'
                        },
                        ,{field: 'secretLevelText', title: '密级', sort: true} 
                    ]
                ],
                page: true, //开启分页
                url: '/trademarkController/query',
                limit: 10, // 每页数据条数,
                parseData: function (res) { return layuiParseData(res); },
                request: {
                    pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
                    limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
                },
                defaultToolbar: "none",
                limits: [5, 10, 15, 20], // 配置分页数据条数
                done: function () {
                    itemRowData = null;
                },
                where: searchData
            });
        } else {
            table.reload('tableContent', { where: searchData });
        }
    }

    form.on('submit(formDemo)', function (data) { //查询条件提交操作
        queryTable(data.field);
        return false;
    });

    $('[lay-filter="formDemo"]').click(); //首次table渲染操作

    function openDataDilog(type) { //进行添加和修改的弹框操作
        var dialogTitle = '新增';

        if (type) {
            dialogTitle = '编辑';
        }

        top.layer.open({ // 打开弹窗
            type: 2,
            title: dialogTitle,
            area: ['880px', '70%'],
            content: '/html/trademark/trademark_add.html?id=' + type,
            btn: null,
            end: function () {
                var relData = getDialogData('dialog-data');
                if (relData) {
                    if (relData.code === '0') {
                        layer.msg(dialogTitle + '成功!', { icon: 1 });
                        $('[lay-filter="formDemo"]').click();
                    } else {
                        layer.msg(relData.message, { icon: 2 });
                    }
                }
            }
        });
    }

    function checkDilog(id) {
        top.layer.open({ // 打开弹窗
            type: 2,
            title: "查看",
            area: ['880px', '70%'],
            content: '/html/trademark/trademark_check.html?id=' + id,
            btn: null,
            end: function () {
                
            }
        });
    }
    // 新增平台
    $('#addItem').on('click', function (e) {
        openDataDilog();
    })

    $('#editItem').on('click', function (e) { //编辑平台
        if (itemRowData) {
            openDataDilog(itemRowData.id);
        } else {
            layer.msg('请选择需要编辑的商标！');
        }
    })

    table.on('radio(tableContent)', function (obj) { // 表格行被选中
        itemRowData = obj.data;
        console.log(obj)
    });

    $('#check').on('click', function (e) { // 查看平台
        if (itemRowData) {
            checkDilog(itemRowData.id);
        } else {
            layer.msg('请选择需要查看的商标！');
        }
    })

    $('#delItem').on('click', function (e) { // 删除平台
        console.log('sss',itemRowData);
        if (itemRowData) {
            layer.confirm('您确定要删除”' + itemRowData.unitNameText + '“吗？', { icon: 3, title: '删除提示' }, function (index) {
                layer.close(index);
                // 确认删除
                httpModule({
                    url: '/trademarkController/delete/' + itemRowData.id,
                    type: 'DELETE',
                    success: function (relData) {
                        if (relData.code === '0') {
                            layer.msg('删除成功!', { icon: 1 });
                            $('[lay-filter="formDemo"]').click();
                        } else {
                            layer.msg('删除失败', { icon: 2 });
                        }
                    }
                });
            });
        } else {
            layer.msg('请选择需要删除的商标！');
        }
    })

    laydate.render({ //渲染时间表单
        elem: '#startTime',
        trigger: 'click',
    });
    laydate.render({
        elem: '#endTime',
        trigger: 'click',
    });



})
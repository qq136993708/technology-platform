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
                            title: '单位名称',

                        },
                        {
                            field: 'trademarkName',
                            title: '商标名称'
                        },
                        /*{
                            field: 'commodityCategoryText',
                            title: '核定使用商品大类'
                        },*/
                        {
                            field: 'applicationNumber',
                            title: '注册号'
                        },
                        {
                            field: 'applicant',
                            title: '申请人'
                        },
                        {
                            field: 'countryType',
                            title: '国际分类号'
                        },
                        {
                            field: 'registerOrg',
                            title: '注册单位'
                        },
                        {
                            field: 'registerDate',
                            title: '注册日期',
                            sort: true,
                            templet:'#registerDate'
                        },
                        {
                            field: 'effectiveDate',
                            title: '有效日期',
                            templet:'#effectiveDate'
                            , sort: true
                        },
                        {
                            field: 'extensionPeriod',
                            title: '延展有效期',
                            templet:'#extensionPeriod'
                        },
                        {
                            field: 'tradeMarkType',
                            title: '商标类型'
                        },
                        {field: 'secretLevelText', title: '密级', sort: true, hide: _hideSecrecylevel()} 
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

    $('button[data-type="exportEvent"]').on('click', function (e) {
        console.log('导出')
    });

    $('button[data-type="importEvent"]').on('click', function (e) {
        console.log('导入')
    });

    table.on('radio(tableContent)', function (obj) { // 表格行被选中
        itemRowData = obj.data;
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
        elem: '.registerDate',
        trigger: 'click',
    });
    laydate.render({
        elem: '.effectiveDate',
        trigger: 'click',
    });
     //导入
importFiles({
    id:'#importData',
    url:'//excelImport/kgjimp',
    callback: function (data, type) {
      queryTable('');
    }
  })
  // 导出
  $('#exportData').click(function() {
    var formValue = form.val('selectCondition'),
    searchData = {
      unitName: formValue.unitName || '', // 单位名称：
      trademarkName: formValue.trademarkName || '', // 商标名称
      applicationNumber: formValue.applicationNumber || '', // 注册号
      registerOrg: formValue.registerOrg || '', // 注册单位
      registerDate: formValue.registerDate || '', // 注册日期
      effectiveDate: formValue.effectiveDate || '', // 有效期
      tradeMarkType: formValue.tradeMarkType || '', // 商标类型：
      lawStatus: formValue.lawStatus || '', // 商标类型：
    },
    exportUrl = '';
  
    for (var key in searchData) {
      exportUrl += '&' + key + '=' + searchData[key];
    }
    exportUrl = '/patentController/exportExcel?' + exportUrl.substring(1);
    window.open(exportUrl, '_blank');
  })
})
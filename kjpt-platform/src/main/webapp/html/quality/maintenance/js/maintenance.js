//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function () {
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;
  var variable = getQueryVariable();
  var curisPublish=null;
  //表格渲染
  var tableRender = false;

  
  var researchCol=[  //在研
    { type: 'checkbox',align: 'center'},
    {title: '序号',templet: '#xuhao', align: 'center'},
    {field: 'planNum',title: '计划号',align: 'center'},
    {field: 'planChineseName',title: '计划中文名称',align: 'center'},
    {field: 'planEnglishName',title: '计划英文名称',align: 'center'},
    {field: 'applicationDate',title: '下达年度',align: 'center',
      templet:function (d) {
       return  new Date(d.applicationDate).format('yyyy-MM-dd')
        }
    },
   
    {field: 'standardTypeText',title: '标准类型'},
    {field: 'chiefEditorUnit',title: '主编单位',},
    {field: 'partakeEditorUnit',title: '参编单位',},
    {field: 'levelText',title: '密级',},
    {field: 'updateStatusText',title: '修改状态',align: 'center',},
    {field: 'fileStatusText',title: '文件状态',align: 'center',},
    {field: 'isPublishText',title: '是否已发布',align: 'center',},
    {field: 'manageOrg',title: '主管部门',align: 'center',},
    {field: 'technicalCommittee',title: '技术委员会',align: 'center',},
    {field: 'putUnderUnitText',title: '归口单位',align: 'center',},
    {field: 'consultStandard',title: '参照标准',align: 'center',},
    {field: 'uniformityDegree',title: '一致性程度',align: 'center',},
    {field: 'toReplacedStandard',title: '拟代替标准',align: 'center',},
  ]
  var publishedCol =[  //已发布
    { type: 'checkbox',align: 'center'},
    {title: '序号',templet: '#xuhao', align: 'center'},
    {field: 'standardNum',title: '标准号',align: 'center'},
    {field: 'planEnglishName',title: '英文名称',align: 'center'},
    {field: 'publishDate',title: '发布时间',align: 'center',
      templet:function (d) {
        if(d.publishDate !=null){
          return  new Date(d.publishDate).format('yyyy-MM-dd')
        }else{
          return '-';
        }
        }
    },
    {field: 'terminationDate',title: '实施时间',align: 'center',
      templet:function (d) {
        if(d.terminationDate != null){
          return  new Date(d.terminationDate).format('yyyy-MM-dd')
        }else{
          return '-';
        }
        }
    },
   
    {field: 'chiefEditorUnit',title: '主编单位',},
    {field: 'partakeEditorUnit',title: '参编单位',},
    {field: 'updateStatusText',title: '修改状态',align: 'center',},
    {field: 'fileStatusText',title: '文件状态',align: 'center',},
    {field: 'isPublishText',title: '是否已发布英文版',align: 'center',},
    {field: 'manageOrg',title: '主管部门',align: 'center',},
    {field: 'technicalCommittee',title: '技术委员会',align: 'center',},
    {field: 'putUnderUnitText',title: '归口单位',align: 'center',},
    {field: 'consultStandard',title: '参照标准',align: 'center',},
    {field: 'uniformityDegree',title: '一致性程度',align: 'center',},
    {field: 'toReplacedStandard',title: '拟代替标准',align: 'center',},
  ]
  var curCol = null;
  //1 :否 0 是
  variable.type == '1'?curCol=publishedCol:curCol=researchCol;
  
  if(variable.type == '1'){
    $('input[name="isPublish"]').val('0');
  }else{
    $('input[name="isPublish"]').val('1');
  }

  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo',
        url: '/standardMaintain-api/query' //数据接口
          ,
        cols: [curCol],
        parseData: function (res) {
          return layuiParseData(res);
        },
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        done: function (res) {
          itemRowData = null;
        },
        where: searchData
      });
    } else {
      table.reload('tableDemo', {
        where: searchData
      });
    }
  }

  form.on('submit(formDemo)', function (data) {
    var query = data.field;
    queryTable(query);
    return false;
  });
  
  $('[lay-filter="formDemo"]').click();

  function openDataDilog(type, id) {
    var pageName = 'edit', pageTitle = '质量标准';
    var url = '/html/quality/'+ pageName +'.html?type=' + type;
    var dialogTitle = '新增'+pageTitle;
    if (type === 'edit') {
      dialogTitle = '编辑'+ pageTitle;
      url += '&id=' + id;
    } else if (type === 'view') {
      dialogTitle = pageTitle + '信息查看';
      url = '/html/quality/view.html?id=' + id + '&type=' + type;
    }
    // 打开弹窗
    top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
      content: url,
      btn: null,
      end: function () {
        var relData = getDialogData('dialog-data');
        if (relData) {
          if (relData.code === '0') {
            layer.msg(dialogTitle + '成功!', {
              icon: 1
            });
            $('[lay-filter="formDemo"]').click();
          } else {
            layer.msg(relData.message, {
              icon: 2
            });
          }
        }
      }
    });
  }

  // 新增
  $('#addItem').on('click', function (e) {
    openDataDilog('add');
  })

  // 表格行被选中
  // table.on('radio(tableDemo)', function (obj) {
  //   itemRowData = obj.data;
  // });
  // 编辑
  $('#editItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length == 1) {
      openDataDilog('edit', itemRowData[0].id);
    } else {
      layer.msg('请选择需要编辑的数据！');
    }
  });
  // 查看
  $('#viewItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length == 1) {
      openDataDilog('view', itemRowData[0].id);
    } else {
      layer.msg('请选择需要查看的数据！');
    }
  });

  // 删除
  $('#delItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length == 1) {
      top.layer.confirm('您确定要删除吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        top.layer.close(index);
        // 确认删除
        httpModule({
          url: '/standardMaintain-api/delete/' + itemRowData[0].id,
          type: 'DELETE',
          success: function (relData) {
            if (relData.code === '0') {
              layer.msg('删除成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              layer.msg('删除失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要删除的数据！');
    }
  });

  $('#removeItem').on('click', function (e) {
    if (itemRowData) {
      layer.confirm('您确定要移除”' + itemRowData.patentName + '“吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        layer.close(index);
        // 确认删除
        httpModule({
          url: '/patentController/batchRemove/' + itemRowData.id,
          type: 'GET',
          success: function (relData) {
            if (relData.code === '0') {
              layer.msg('移除成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              layer.msg('移除失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要移除的数据！');
    }
  });

  laydate.render({
    elem: '#applicationDateStart' //指定元素
  });

  laydate.render({
    elem: '#applicationDateEnd' //指定元素
  });
 
  //导入
importFiles({
  id:'#importData',
  url:'/excelImport/standardImp',
  callback: function (data, type) {
    queryTable('');
  }
})
// 导出
$('#exportData').click(function() {
//  debugger
  var formValue = form.val('patentFormDemo'),
  searchData = {
    planNum: formValue.planNum || '', // 计划号：
    standardNum: formValue.standardNum || '', // 标准号：
    planChineseName: formValue.planChineseName || '', // 计划名称：
    standardName: formValue.standardName || '', // 标准名称：
  },
  exportUrl = '';

  for (var key in searchData) {
    exportUrl += '&' + key + '=' + searchData[key];
  }
  exportUrl = '/standardMaintain-api/export?' + exportUrl.substring(1);
  window.open(exportUrl, '_blank');
})

});

function shouUser(userId) {
  alert(userId);
}
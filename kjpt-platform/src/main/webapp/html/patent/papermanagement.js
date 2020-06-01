//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function () {
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;
  var variable = getQueryVariable();
  var queryType = (function() {
    if (variable && typeof(variable) === 'object' && variable.type) {
      return variable.type; } else { return '1'; }
  })();
  
  //表格渲染
  var itemRowData = null; // 选中行的数据
  var tableRender = false;

  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo',
        url: '/treatise-api/query' //数据接口
          ,
        cols: [
          [ //表头
            {
              type: 'radio',
              field: 'id',
              align: 'center'
            },
            // {title: '序号',templet: '#xuhao', align: 'center'},
            {
              field: 'theme',
              title: '论文主题',
              align: 'center',
            },
            {
              field: 'keyWord',
              title: '关键字',
              align: 'center'
            }, {
              field: 'title',
              title: '篇名'
            },
            {
              field: 'author',
              title: '作者'
            },
            {
              field: 'unitText',
              title: '单位',
            },
            {
              field: 'summary',
              title: '摘要',
              align: 'center',
            },
            {
              field: 'journalName',
              title: '期刊名',
              align: 'center',
            },
            {
              field: 'journalLevelText',
              title: '期刊等级',
              align: 'center',
            },
            {
              field: 'publishDate',
              title: '发表日期',
              align: 'center',
              sort: true,
              templet: function(d){
                var times = new Date(d.publishDate);
                 return times.getFullYear() + '-' + (times.getMonth()+1) + '-' +times.getDate();
              }},
            {
              field: 'influencingFactors',
              title: '影响因子',
              align: 'center',
            },
          ]
        ],
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
    //TODO date error
    var query = data.field;
    // query.type = queryType;  // 后台去掉了type字段
    queryTable(query);
    return false;
  });
  
  $('[lay-filter="formDemo"]').click();

  function openDataDilog(type, id) {
   
     var pageName = 'addpaper';
     var pageTitle = '论文';

    var url = '/html/patent/'+ pageName +'.html?type=' + type;
    var dialogTitle = '新增'+pageTitle;
    if (type === 'edit') {
      dialogTitle = '编辑'+ pageTitle;
      url += '&id=' + id;
    } else if (type === 'view') {
      dialogTitle = pageTitle + '信息查看';
      url += '&id=' + id;
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
  table.on('radio(tableDemo)', function (obj) {
    itemRowData = obj.data;
  });
  // 编辑
  $('#editItem').on('click', function (e) {
    if (itemRowData) {
      openDataDilog('edit', itemRowData.id);
    } else {
      layer.msg('请选择需要编辑的论文！');
    }
  });

  // 查看
  $('#viewItem').on('click', function (e) {
    if (itemRowData) {
      openDataDilog('view', itemRowData.id);
    } else {
      layer.msg('请选择需要查看的论文！');
    }
  });

  // 删除
  $('#delItem').on('click', function (e) {
    if (itemRowData) {
      layer.confirm('您确定要删除”' + itemRowData.title + '“吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        layer.close(index);
        // 确认删除
        httpModule({
          url: '/treatise-api/delete/' + itemRowData.id,
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
      layer.msg('请选择需要删除的论文！');
    }
  });

  laydate.render({
    elem: '#estimate' //指定元素
  });
  // 导出
$('#exportData').click(function() {
  var formValue = form.val('patentFormDemo'),
  searchData = {
    theme: formValue.theme || '', // 论文主题：
    title: formValue.title || '', // 篇名：
    journalName: formValue.journalName || '', // 期刊名：
    journalLevel: formValue.journalLevel || '', // 期刊等级
    publishDate: formValue.publishDate || '', // 发表日期：
  },
  exportUrl = '';

  for (var key in searchData) {
    exportUrl += '&' + key + '=' + searchData[key];
  }
  exportUrl = '/treatise-api/export?' + exportUrl.substring(1);
  window.open(exportUrl, '_blank');
})
//导入
importFiles({
  id:'#importData',
  url:'/excelImport/treatiseImp',
  //treatiseImp
  callback: function (data,type) {
      queryTable('');
  }
});
// 导出
$('#exportData').click(function() {
  var formValue = form.val('patentFormDemo'),
  searchData = {
    unitName: formValue.unitName || '', // 单位名称：
    patentName: formValue.patentName || '', // 项目背景：
    patentType: formValue.patentType || '', // 专利类型：
    lawStatus: formValue.lawStatus || '', // 法律状态
    applicationNumber: formValue.applicationNumber || '', // 专利号：
  },
  exportUrl = '';

  for (var key in searchData) {
    exportUrl += '&' + key + '=' + searchData[key];
  }
  exportUrl = '/patentController/exportExcel?' + exportUrl.substring(1);
  window.open(exportUrl, '_blank');
})

});




function shouUser(userId) {
  alert(userId);
}
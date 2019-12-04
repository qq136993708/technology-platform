layui.use(['table', 'form'], function() {
  var table = layui.table;
  var form = layui.form;

  var tableRender = false;
  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/data/datalist.json' //数据接口
        ,cols: [[ //表头
          {type: 'checkbox', field: 'id'}
          ,{type: 'numbers', title: '序号', width: 50}
          ,{field: 'platformName', title: '备案状态'}
          ,{field: 'supportingInstitutionsText', title: '成果名称' }
          ,{field: 'personLiable', title: '成果持有单位' }
          ,{field: 'typeText', title: '拟受让单位'} 
          ,{field: 'researchFieldText', title: '是否核心技术成果'}
          ,{field: 'experience', title: '拟转让方式' }
          ,{field: 'experience', title: '拟转化金额（万）' }
          ,{field: 'experience', title: '激励预计总额（万）' }
          ,{field: 'experience', title: '本年激励额度' }
          ,{field: 'experience', title: '完成情况' }
          ,{field: 'experience', title: '未完成项目预计完成时间' }
          ,{field: 'experience', title: '操作' }
        ]],
        parseData: function(res) {return layuiParseData(res, null, 3);},
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        where: searchData
      });
    } else {
      table.reload('tableDemo', {where: searchData});
    }
  }

  // 监控表单提交事件
  form.on('submit(formSubmit)', function(data) {
    queryTable(data.field);
    return false;
  });
  $('[lay-filter="formSubmit"]').click();

  // 删除申请
  $('#delItem').on('click', function() {
    // 获取被选中的行数据
    var activeData = table.checkStatus('tableDemo').data;
    if (activeData.length) {

    } else {
      top.layer.msg('请选择需要删除的数据！');
    }
  })
  
  // 新增、编辑、查看
  $('.openLayerPage').on('click', function() {
    var optionType = $(this).data('type'),
    dialogTitle = '新增',
    url = '/kjpt/achieve/addRecord.html?type=' + optionType;

    if (optionType === 'edit') {
      dialogTitle = '编辑';
    } else if (optionType === 'view') {
      dialogTitle = '查看';
    }

    if (optionType !== 'add') {
      var listData = table.checkStatus('tableDemo').data;
      if (listData.length) {
        if (listData.length === 1) {
          url += '&id='+listData[0].id;
        } else {
          top.layer.msg('要'+dialogTitle+'的数据只能是单条！');
          return false;
        }
      } else {
        top.layer.msg('请选择要'+dialogTitle+'的数据！');
        return false;
      }
    }
    parent.layui.index.openTabsPage(url, dialogTitle + '申请');
  })
})
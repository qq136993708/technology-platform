layui.use(['table', 'form'], function() {
  var table = layui.table;
  var form = layui.form;

  var tableRender = false;
  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        width: '100%'
        ,elem: '#tableDemo'
        ,url: '/data/datalist.json' //数据接口
        ,cols: [[ //表头
          {type: 'checkbox', field: 'id'}
          ,{type: 'numbers', title: '序号', width: 50}
          ,{field: 'platformName', title: '备案状态', width: 80}
          ,{field: 'supportingInstitutionsText', title: '成果名称' }
          ,{field: 'personLiable', title: '成果持有单位' }
          ,{field: 'typeText', title: '拟受让单位'} 
          ,{field: 'researchFieldText', title: '是否核心技术成果'}
          ,{field: 'experience', title: '拟转让方式' }
          ,{field: 'experience', title: '拟转化金额（万）' }
          ,{field: 'experience', title: '激励预计总额（万）' }
          ,{field: 'experience', title: '本年激励额度' }
          ,{field: 'experience', title: '完成情况' }
          ,{field: 'experience', title: '未完成项目预计完成时间', width: 100 }
          ,{field: 'experience', title: '操作', width: '100', templet: function(d) {
            var templet = '<div class="options-list">';
            templet += '<span class="link-text recordDetails" data-type="input" data-id="'+d.id+'">录入备案信息</span>';
            templet += '<span class="link-text recordDetails" data-type="see" data-id="'+d.id+'">查看备案信息</span>';
            templet += '<span class="link-text recordDetails" data-type="transfrom" data-id="'+d.id+'">转化收益维护</span>';
            templet += '</div>';
            return templet;
          }}
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
  
  // 备案详情，查看，录入，转化
  $('#record_list_table').on('click', '.recordDetails', function(e) {
    var optionType = $(this).data('type'),
    dialogTitle =  $(this).text().trim(),
    id = $(this).data('id');
    url = '/kjpt/achieve/record_input.html?type=' + optionType + '&id='+ id;
    parent.layui.index.openTabsPage(url, dialogTitle + '申请');
  })

  // 新增、编辑、查看
  $('.openLayerPage').on('click', function() {
    var optionType = $(this).data('type'),
    dialogTitle = '新增',
    url = '/kjpt/achieve/record_add.html?type=' + optionType;

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
    
    // 打开弹窗
    top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['960px', '520px'],
      content: url,
      btn: null,
      end: function() {
        var returnValue = getDialogData('dialog-data');
        if (returnValue) {
          if (returnValue.code === '0') {
            layer.msg(dialogTitle + '成功。', {icon: 1});
            $('[lay-filter="formSubmit"]').click();
          } else {
            layer.msg(dialogTitle + '失败。', {icon: 2});
          }
        }
      }
    });


  })
})
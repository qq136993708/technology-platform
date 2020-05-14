layui.use(['table', 'form', 'laydate'], function () {
  var table = layui.table;
  var form = layui.form;
  var laydate = layui.laydate;
  var tableRender = false;
  window.queryTable = function (searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo',
        url: '/achieve-api/query' //数据接口
          ,
        cols: [
          [ //表头
            {
              type: 'radio',
              field: 'id'
            }, {
              type: 'numbers',
              title: '序号',
              width: 80
            }, {
              field: 'auditStatusText',
              title: '申请状态',
              templet: function (d) {
                if (d.auditStatus != 0) {
                  return "<a class='view link-text recordDetails' id='" + d.id + "'>" + d.auditStatusText + "</a>"
                } else {
                  return d.auditStatusText
                }
              }
            }, {
              field: 'achieveName',
              title: '成果名称',
              sort: true
            }, {
              field: 'finishUnitNameText',
              title: '完成单位',
              sort: true
            }, {
              field: 'brief',
              title: '科技成果介绍'
            }, {
              field: 'finishDate',
              title: '成果完成时间',
              templet: '<div>{{ layui.laytpl.toDateString(d.finishDate) }}</div>',
              sort: true
            }, {
              field: 'achieveTransTypeText',
              title: '拟转让方式',
              sort: true
            }, {
              field: 'secretLevelText',
              title: '密级',
              sort: true,
              hide: _hideSecrecylevel()
            }
          ]
        ],
        parseData: function (res) {
          return layuiParseData(res);
        },
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        done: function () {
          $(".view").click(function () {
            var temUrl = "/task/process_bussinessId/" + $(this).attr("id");
            top.layer.open({
              title: '详情',
              shadeClose: true,
              type: 2,
              fixed: false,
              maxmin: false,
              area: ['70%', '50%'],
              content: temUrl
            });
          })
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        where: searchData
      });
    } else {
      table.reload('tableDemo', {
        where: searchData
      });
    }
  }
  //开始日期
  var insStart = laydate.render({
    elem: '#inputStart',
    done: function (value, date) {
      //更新结束日期的最小日期
      insEnd.config.min = lay.extend({}, date, {
        month: date.month - 1
      });

      //自动弹出结束日期的选择器
      insEnd.config.elem[0].focus();
    }
  });

  //结束日期
  var insEnd = laydate.render({
    elem: '#inputEnd',
    min: 0,
    done: function (value, date) {
      //更新开始日期的最大日期
      insStart.config.max = lay.extend({}, date, {
        month: date.month - 1
      });
    }
  });

  // 监控表单提交事件
  form.on('submit(formSubmit)', function (data) {
    queryTable(data.field);
    return false;
  });
  $('[lay-filter="formSubmit"]').click();
  $("#reset").click(function () {

    queryTable('')
  })
  // 删除申请
  $('#delItem').on('click', function () {
    top.layer.confirm('您确定要删除选中的信息吗？', {icon: 3, title:'提示'}, function(index) {
      // 获取被选中的行数据
      var activeData = table.checkStatus('tableDemo').data;
      if (activeData.length) {
        if (activeData[0].auditStatus == 0 || activeData[0].auditStatus == 3) {
          httpModule({
            url: "/achieve-api/delete/" + activeData[0].id,
            type: 'DELETE',
            success: function (relData) {
              if (relData.code == 0) {
                layer.msg('删除成功!', {  
                  icon: 1
                });
                top.layer.closeAll(); // 关闭弹窗
                queryTable('')
              }
            }
          });
        } else {
          layer.closeAll(); // 关闭弹窗
          top.layer.msg('当前申请状态不能删除！');
          }
      }
    })
  })
  //流程
  $('#flow').on('click', function () {
    var activeData = table.checkStatus('tableDemo').data;
    if (activeData[0].auditStatus == 0 || activeData[0].auditStatus == 3) {
      dealFlow(activeData[0].id);
    } else {
      top.layer.msg('当前申请状态不能上报！');
      return false;
    }
    $('#flow').attr('disabled', "true")
  })

  // 新增、编辑、查看
  $('.openLayerPage').on('click', function () {
    var index = parent.$("#LAY_app_body div.layui-show").index() - 1;
    var optionType = $(this).data('type'),
      dialogTitle = '新增',
      url = '/kjpt/achieve/apply.html?type=' + optionType + "&index=" + index;
    if (optionType === 'edit') {
      dialogTitle = '编辑';
    } else if (optionType === 'view') {
      dialogTitle = '查看';
      url = '/kjpt/achieve/apply_view.html?type=' + optionType + "&index=" + index;
    }

    if (optionType == 'edit') {
      var listData = table.checkStatus('tableDemo').data;
      if (listData.length) {
        if (listData.length === 1) {
          if (listData[0].auditStatus == 0 || listData[0].auditStatus == 3) {
            url += '&id=' + listData[0].id + "&index=" + index;
            parent.layui.index.openTabsPage(url, dialogTitle + '申请');
          } else {
            top.layer.msg('当前申请状态不能编辑！');
            return false;
          }

        } else {
          top.layer.msg('要' + dialogTitle + '的数据只能是单条！');
          return false;
        }
      } else {
        top.layer.msg('请选择要' + dialogTitle + '的数据！');
        return false;
      }
    } else if (optionType == 'view') {
      var listData = table.checkStatus('tableDemo').data;
      if (listData.length) {
        url += '&id=' + listData[0].id + "&index=" + index;
        parent.layui.index.openTabsPage(url, dialogTitle + '申请');
        return false
      } else {
        top.layer.msg('请选择要' + dialogTitle + '的数据！');
        return false;
      }
    } else {
      parent.layui.index.openTabsPage(url, dialogTitle + '申请');
    }
  })
})
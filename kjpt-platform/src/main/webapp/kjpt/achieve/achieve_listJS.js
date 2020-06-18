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
          ,cols: [
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
            },
             {
              field: 'isSupplementaryRecordText',
              title: '是否补录',
            }, {
              field: 'achieveTypeText',
              title: '是否核心',
            },
            {
              field: 'achieveName',
              title: '成果名称',
            }, {
              field: 'finishUnitNameText',
              title: '成果持有单位',
              sort: true
            }, {
              field: 'affiliatedUnitText',
              title: '成果所属单位（专业化公司/直属单位)',
              sort: true
            }, {
              field: 'brief',
              title: '科技成果简介'
            }, {
              field: 'finishDate',
              title: '成果完成时间',
              sort: true
            },
             {
              field: 'achieveTransTypeText',
              title: '拟转化方式',
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
  laydate.render({
    elem: '#inputStart',
    trigger: 'click',
    type:'year',
    change: function(value, date){ //监听日期被切换
      $('#inputStart').val(value);
      $('#inputEnd').val(value);
    }
  });

  //结束日期
 laydate.render({
    elem: '#inputEnd',
    trigger: 'click',
    type:'year'
  });

  // 监控表单提交事件
  form.on('submit(formSubmit)', function (data) {
    queryTable(data.field);
    return false;
  });
  $('[lay-filter="formSubmit"]').click();
  
  // 删除申请
  $('#delItem').on('click', function () {
    top.layer.confirm('您确定要删除选中的信息吗？', {
      icon: 3,
      title: '提示'
    }, function (index) {
      // 获取被选中的行数据
      var activeData = table.checkStatus('tableDemo').data;
      if (activeData.length) {
        if (activeData[0].auditStatus == 0 ) {
          httpModule({
            url: "/achieve-api/delete/" + activeData[0].id,
            type: 'DELETE',
            success: function (relData) {
              if (relData.code == 0) {
                top.layer.msg('删除成功!', {
                  icon: 1
                });
                top.layer.closeAll(); // 关闭弹窗
                queryTable('')
              }
            }
          });
        } else {
          top.layer.closeAll(); // 关闭弹窗
          top.layer.msg('当前申请状态不能删除！');
        }
      }
    })
  })
  
  $('#kxbdelete').on('click', function () {
    top.layer.confirm('您确定要删除选中的信息吗？', {
      icon: 3,
      title: '提示'
    }, function (index) {
      // 获取被选中的行数据
      var activeData = table.checkStatus('tableDemo').data;
      if (activeData.length) {
          httpModule({
            url: "/achieve-api/delete/" + activeData[0].id,
            type: 'DELETE',
            success: function (relData) {
              if (relData.code == 0) {
                top.layer.msg('删除成功!', {
                  icon: 1
                });
                top.layer.closeAll(); // 关闭弹窗
                queryTable('')
              }
            }
          });
      }
    })
  })
  // // 驳回
  $('#reject').on('click', function () {
    top.layer.confirm('您确定要驳回选中的信息吗？', {
      icon: 3,
      title: '提示'
    }, function (index) {
      // 获取被选中的行数据
      var activeData = table.checkStatus('tableDemo').data;
      if (activeData.length) {
        //审批中 已通过  驳回
        if (activeData[0].auditStatus == 2 || activeData[0].auditStatus == 3  ) {
          var curData = switchHttpData( activeData[0], '', function(item) {
            var temp_Json = {};
            for (var key in item) {
              temp_Json[key] = item[key];
              if (temp_Json[key] === '-') {
                temp_Json[key] = '';
              }
            }
            return temp_Json;
          });
          httpModule({
            url: "/achieve-api/reject" ,
            type: 'POST',
            data:curData,
            success: function (relData) {
              if (relData.code == 0) {  
                layer.msg('驳回成功!', {
                  icon: 1
                });
                top.layer.closeAll(); // 关闭弹窗
                queryTable('')
              }
            }
          });
        } else {
          layer.closeAll(); // 关闭弹窗
          top.layer.msg('此状态下不能驳回！');
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
    }else if(optionType == 'collection'){
      dialogTitle = '补录',
      url = '/kjpt/achieve/apply.html?type=' + optionType + "&index=" + index;
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
    // else if(optionType == 'collection'){ // 补录
    //   var listData = table.checkStatus('tableDemo').data;
    //   if (listData.length === 1) {
    //       url += '&id=' + listData[0].id + "&index=" + index;
    //       parent.layui.index.openTabsPage(url, dialogTitle + '申请');
    //     }
    // }
  })
   // 导出 /achieveRecord-api/exportExcel
   $('#exportData').on('click', function(e) {
    var formValue = form.val('achTransfrom'),
    searchData = {
      startDate: formValue.startDate, 
      endDate: formValue.endDate, 
      achieveName: formValue.achieveName, // 备案状态
      auditStatus: formValue.auditStatus, // 录入开始时间
      achieveTransType: formValue.achieveTransType, // 录入结束时间
      affiliatedUnit: formValue.affiliatedUnit, // 成果类型、是否为核心成果
      finishUnitName: formValue.finishUnitName, // 完成情况
    },
    exportUrl = '';

    for (var key in searchData) {
      exportUrl += '&' + key + '=' + searchData[key];
    }
    exportUrl = '/achieve-api/export?' + exportUrl.substring(1);
    console.log(formValue);
    // 附件下载
    window.open(exportUrl, '_blank');
  });
})
layui.use(['table', 'form','laydate'], function() {
  var table = layui.table;
  var form = layui.form;
    var laydate = layui.laydate;

  var tableRender = false;
   window.queryTable=function(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        width: '100%'
        ,elem: '#tableDemo'
        // ,url: '/achieveRecord-api/query' //数据接口
        ,url: '/achieveRecord-api/queryAchieveSubsidiarity'
        ,cols: [[ //表头
          {type: 'radio', field: 'id', width: 50, fixed: 'left'}
          ,{type: 'numbers', title: '序号', width: 50}
          ,{field: 'auditStatusText', title: '备案状态', width: 80,templet:function(d) {
            if(d.auditStatus!=0){
              return "<a class='view link-text recordDetails' id='"+d.id+"'>"+d.auditStatusText+"</a>"
            }else {
              return d.auditStatusText
            }
          }}
          ,{field: 'achieveName', title: '成果名称', width: 120 }
          ,{field: 'finishUnitNameText', title: '成果持有单位', width: 120 }
          ,{field: 'achieveInfo', title: '成果基本情况', width: 120 }
          ,{field: 'grantUnitName', title: '拟受让单位', width: 120} 
          ,{field: 'achieveTypeText', title: '是否核心技术成果', width: 120}
          ,{field: 'achieveTransTypeText', title: '拟转化方式', width: 120 }
          ,{field: 'transMoney', title: '拟转化金额（万）', width: 100 }
          ,{field: 'rewardMoney', title: '激励预计总额（万）', width: 100 }
          ,{field: 'currentRewardMoney', title: '本年激励额度', width: 100 }
          ,{field: 'aboutCompleteInfoText', title: '完成情况', width: 120, }
          ,{field: 'aboutCompleteTime', title: '未完成项目预计完成时间', width: 100, templet: function(d) {
            return new Date(d.aboutCompleteTime).format('yyyy-MM-dd');
          }}
          ,{field: 'secretLevelText', title: '密级', sort: true, hide: _hideSecrecylevel()} 
          ,{field: '', title: '操作', width: '100', templet: function(d) {
            var templet = '<div class="options-list middle-block"><div class="ib-block">';
            if (d.auditStatus == 0 || d.auditStatus == 3){
              templet += '<span class="link-text recordDetails" data-auditstatus="'+d.auditStatus+'" data-type="input" data-id="'+d.id+'">录入备案信息</span>';
            }
            if (d.auditStatus == 1 || d.auditStatus == 2){
              templet += '<span class="link-text recordDetails" data-auditstatus="'+d.auditStatus+'" data-type="view" data-id="'+d.id+'">查看备案信息</span>';
            }
            if (d.auditStatus == 2){
              if (!d.rewardYear || d.status == 0 || d.status == 3 ) {
                templet += '<span class="link-text recordDetails" data-auditstatus="'+d.auditStatus+'" data-type="transfrom" data-id="'+d.id+'">转化收益维护</span>';
              }
            }
            templet += '</div></div>';
            return templet;
          }, fixed: 'right'}
        ]],
        parseData: function(res) {return layuiParseData(res);},
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
          done:function(){
              $(".view").click(function () {
                  var temUrl = "/task/process_bussinessId/" + $(this).attr("id");
                  top.layer.open({
                      title : '详情',
                      shadeClose : true,
                      type : 2,
                      fixed : false,
                      maxmin : false,
                      area : [ '70%', '50%' ],
                      content : temUrl
                  });
                  return false
              })
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
//开始日期
    var insStart = laydate.render({
        elem: '#inputStart'
        ,done: function(value, date){
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
        elem: '#inputEnd'
        ,min: 0
        ,done: function(value, date){
            //更新开始日期的最大日期
            insStart.config.max = lay.extend({}, date, {
                month: date.month - 1
            });
        }
    });
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
      var itemID = '', deleteStatus = true;
      $.each(activeData, function(i, item) {
        itemID += ',' + item.id;
        if (item.auditStatus == 1 || item.auditStatus == 2) {
          deleteStatus = false;
        }
      })

      if (!deleteStatus) {
        top.layer.msg('审批中或审批通过的备案信息不能删除!');
        return false;
      }

      itemID = itemID.substring(1);
      top.layer.confirm('您确定要删除选中的备案信息吗？', {icon: 3, title:'提示'}, function(index) {
        top.layer.close(index);
        httpModule({
          url: '/achieveRecord-api/delete/' + itemID,
          type: 'DELETE',
          success: function(res) {
            if (res.code === '0') {
              layer.msg('删除成功。', {icon: 1});
              $('[lay-filter="formSubmit"]').click();
            } else {
              layer.msg('删除失败。', {icon: 2});
            }
          }
        });
      });
    } else {
      top.layer.msg('请选择需要删除的数据！');
    }
  })

  var functionId = parent.$("#LAY_app_body>div.layui-show iframe").attr("data-code");
  // 备案详情，查看，录入，转化
  $('#record_list_table').on('click', '.recordDetails', function(e) {
    var index=parent.$("#LAY_app_body div.layui-show").index()-1;
    var optionType = $(this).data('type'),
    dialogTitle =  $(this).text().trim(),
    id = $(this).data('id'),
    auditStatus = $(this).data('auditstatus');
    url = '/kjpt/achieve/record_input.html?type=' + optionType + '&id='+ id+"&index="+index;
    url += '&functionId=' + functionId;
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
      url = '/kjpt/achieve/record_view.html?type=' + optionType;
    }

    if (optionType !== 'add') {
      var listData = table.checkStatus('tableDemo').data;
      if (listData.length) {
        if (listData.length === 1) {
          if (optionType === 'edit') {
            if (listData[0].auditStatus == 0 || listData[0].auditStatus == 3) {
              url += '&id='+listData[0].id;
            } else {
              top.layer.msg('审批中或审批通过的数据不能' + dialogTitle);
              return false;
            }
          } else {
            url += '&id='+listData[0].id;
          }
        } else {
          top.layer.msg('不能同时'+dialogTitle+'多条数据！');
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
      area: ['960px', '80%'],
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
  
  // 导出 /achieveRecord-api/exportExcel
  $('#exportData').on('click', function(e) {
    var formValue = form.val('achTransfrom'),
    searchData = {
      achieveName: formValue.achieveName, // 成果名称
      finishUnitName: formValue.finishUnitName, // 完成单位、持有单位
      auditStatus: formValue.auditStatus, // 备案状态
      startDate: formValue.startDate, // 录入开始时间
      endDate: formValue.endDate, // 录入结束时间
      achieveType: formValue.achieveType, // 成果类型、是否为核心成果
      aboutCompleteInfo: formValue.aboutCompleteInfo, // 完成情况
      grantUnitName: '', // 成果受让单位
      achieveTransType: '', // 转化方式
      secretLevel: '' // 密级
    },
    exportUrl = '';

    for (var key in searchData) {
      exportUrl += '&' + key + '=' + searchData[key];
    }
    exportUrl = '/achieveRecord-api/exportExcel?' + exportUrl.substring(1);
    console.log(formValue);
    // 附件下载
    window.open(exportUrl, '_blank');
  });
})
layui.use(['table', 'form', 'layer'], function() {
  var form = layui.form,
  layer = layui.layer,
  table = layui.table,
  variable = getQueryVariable(),
  groupTableId = '',
  fileData = {},
  newTransfromFile = {},
  fileCols = [[
    {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
    {title: '操作', templet: function(d) {
      var templet = '<div class="file-options">';
      templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
      templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
      templet += '</div>';
      return templet;
    }}
  ], [
    {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
    {title: '操作', templet: function(d) {
      var templet = '<div class="file-options">';
      templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
      templet += '</div>';
      return templet;
    }}
  ]
  ];
  console.log(variable);

  // 添加 转化净收益及激励方案
  function addTransfromMaintain(data, auditStatus) {
    var wrapID = 'init_transfrom_maintain';
    if (typeof(data) === 'object' && data.length && auditStatus != '0' && auditStatus != '3') {
      wrapID = 'edit_transfrom_maintain';
      $('#init_transfrom_maintain').empty();
      $('#all_page_submit').remove();
      $.each(data, function(i, val) {
        $('#init_transfrom_maintain').append('<div class="maintain_list" filter="oldTransfrom_'+i+'"></div>');
      })
    }
    if (variable.type !== 'view') {
      $('#' + wrapID).empty().append('<div class="maintain_list" filter="newTransfrom"></div>');
    }

    $('.maintain_list').each(function(index, elem) {
      var $layoutItem = $(this),
      htmlIndex = index,
      formFilter = $layoutItem.attr('filter');

      $layoutItem.load('record_maintain.html', function() {
        $layoutItem.find('.layui-form:eq(0)').attr('lay-filter', formFilter);
        if (wrapID === 'edit_transfrom_maintain') {
          if (formFilter !== 'newTransfrom') {
            // 删除当前区域提交按钮
            $layoutItem.find('.view-page-submit-btn-box, .view-row-title').remove();
            setFomeDisabled(formFilter, '.disabled');
          }
        } else {
          $layoutItem.find('.view-page-submit-btn-box').hide();
        }

        // 添加人员
        var $groupTable = $layoutItem.find('.dy-add-table:eq(0)');
        if (formFilter === 'newTransfrom') {
           groupTableId = randomID(); // 动态生产随机ID
           $groupTable.attr('id', groupTableId);

           /*添加tr*/
           $layoutItem.find('.dy-add-btn:eq(0)').click(function () {
            addTr(groupTableId);
            deleTr(groupTableId);
          })

          if (typeof(data) === 'object' && data.length === 1 && (auditStatus === '0' || auditStatus === '3')) {
            // 草稿
            form.val('newTransfrom', data[0]);
            if ( data[0].teamPerson ) {
              backfill(data[0].teamPerson, groupTableId);
            }
          } else {
            httpModule({
              async: false, // 同步请求
              url: '/achieveReward-api/newInit',
              success: function(res) {
                if (res.code === '0' || res.success === true) {
                  var newTransfromData =  res.data;
                  newTransfromData.achieveRecordId = variable.id;
                  form.val('newTransfrom', newTransfromData);
                }
              }
            });
          }
        } else {
          var tempTableId = randomID(); // 动态生产随机ID
          $groupTable.attr('id', tempTableId);

          var dataIndex = htmlIndex;
          if (variable.type === 'transfrom') {
            dataIndex = (dataIndex - 1);
          }

          // 给当前激励方案赋值回显
          form.val(formFilter, data[dataIndex]);

          // 回显团队成员
          if ( data[dataIndex].teamPerson ) {
            backfill(data[dataIndex].teamPerson, tempTableId, 'view');
          }
        }

        // 绑定附件上传功能
        $layoutItem.find('.file-filter-options').each(function() {
          var $this = $(this),
          fileParId = $(this).find('.fileValue:eq(0)').val() || '';

          if (fileParId) {
            newTransfromFile[fileParId] = '';
          }
          setFileUpload({
            id: $this, // 附件上传作用域ID值 必传
            dataID: fileParId, // 用来查找当前单据下绑定的附件，没有则不查找
            secretLevel : function() {
              return $("#secretLevel").val();
            },
            cols: (function() {
              console.log('formFilter =>', formFilter);

              if (formFilter === 'newTransfrom') {
                return fileCols[0];
              } else {
                return fileCols[1];
              }
            })(),
            callback: function (tableData, type) {
              if (!fileParId) return;
              if (tableData && tableData.length) {
                $.each(tableData, function(fi, valf) {
                  newTransfromFile[fileParId] += ',' + valf.id;
                })
                newTransfromFile[fileParId] = newTransfromFile[fileParId].substring(1);
              } else {
                newTransfromFile[fileParId] = '';
              }
            }
          });
        })

        // 更新表单渲染
        form.render();
      })
    })
  }

  // 获取附件详情
  function getFileValue(data) {
    var fileValue = {}, fileTemp = '';
    if (data.hasOwnProperty('appraisalDoc')) {
      // 知识产权状况或科技成果评价报告：
      fileTemp = fileData[data.appraisalDoc] || '';
      fileValue.appraisalDoc = ['知识产权状况或科技成果评价报告', fileTemp];
    }
    if (data.hasOwnProperty('grantDoc')) {
      // 尽职调查报告：
      fileTemp = fileData[data.grantDoc] || '';
      fileValue.grantDoc = ['尽职调查报告', fileTemp];
    }
    if (data.hasOwnProperty('transContractDoc')) {
      // 合同（协议）文本：
      fileTemp = fileData[data.transContractDoc] || '';
      fileValue.transContractDoc = ['合同（协议）文本', fileTemp];
    }
    if (data.hasOwnProperty('transAssessDoc')) {
      // 资产评估报告及评估备案表：
      fileTemp = fileData[data.transAssessDoc] || '';
      fileValue.transAssessDoc =  ['资产评估报告及评估备案表', fileTemp];
    }
    if (data.hasOwnProperty('decisionMeetingDoc')) {
      // 内部决策会议纪要：
      fileTemp = fileData[data.decisionMeetingDoc] || '';
      fileValue.decisionMeetingDoc =  ['内部决策会议纪要', fileTemp];
    }
    if (data.hasOwnProperty('decisionRuleDoc')) {
      // 单位内部科技成果转化规章制度：
      fileTemp = fileData[data.decisionRuleDoc] || '';
      fileValue.decisionRuleDoc =  ['单位内部科技成果转化规章制度', fileTemp];
    }
    if (data.hasOwnProperty('incomeReportDoc')) {
      // 净收入计算报告（单位财务部门盖章）：
      fileTemp = newTransfromFile[data.incomeReportDoc] || '';
      fileValue.incomeReportDoc =  ['净收入计算报告（单位财务部门盖章）', fileTemp];
    }
    if (data.hasOwnProperty('assignPlanDoc')) {
      // 激励方案报告：
      fileTemp = newTransfromFile[data.assignPlanDoc] || '';
      fileValue.assignPlanDoc =  ['激励方案报告', fileTemp];
    }
    if (data.hasOwnProperty('rewardAccountingDoc')) {
      // 成果核算（单位财务部门盖章）：
      fileTemp = newTransfromFile[data.rewardAccountingDoc] || '';
      fileValue.rewardAccountingDoc = ['成果核算（单位财务部门盖章）', fileTemp];
    }

    return fileValue;
  }

  // 添加科技成果完成团队情况
  $('#addTeamPersonList').click(function () {
    addTr('teamPersonList');
    deleTr('teamPersonList');
  })

  // 获取备案信息
  httpModule({
    url: '/achieveRecord-api/load/'+ variable.id,
    success: function(res) {
      console.log(res);
      // teamPerson
      if (res.code === '0' || res.success === true) {
        var detailsData = res.data;
        if (!detailsData.auditStatus) {
          detailsData.auditStatus = '0';
        } else {
          detailsData.achieveTransStatus = detailsData.auditStatus;
        }

        form.val('RecordInputForm', detailsData);
        setTargetNameValue({auditStatus: detailsData.auditStatus});

        // 草稿、被驳回状态
        if (detailsData.achieveRewards.length) {
          addTransfromMaintain(detailsData.achieveRewards, detailsData.auditStatus);
        } else {
          addTransfromMaintain();
        }

        if ( detailsData.teamPerson ) {
          // 激励人员名单
          var viewValue = null;
          if (variable.type === 'view' || variable.type === 'transfrom') {
            viewValue = 'view';
          }
          backfill(detailsData.teamPerson, 'teamPersonList', viewValue);
        }

        // 绑定附件添加插件
        $('#RecordInputForm .file-filter-options').each(function(i, elem) {
          var fileParId = $(this).find('.fileValue:eq(0)').val() || '';
          if (fileParId) {
            fileData[fileParId] = '';
          }
          setFileUpload({
            id: $(this), // 附件上传作用域ID值 必传
            dataID: fileParId, // 用来查找当前单据下绑定的附件，没有则不查找
            secretLevel : function() {
              return $("#secretLevel").val();
            },
            cols: (function() {
              if (variable.type === 'view' || variable.type === 'transfrom') {
                return fileCols[1];
              } else {
                return fileCols[0];
              }
            })(),
            callback: function (tableData, type) {
              if (!fileParId) return;
              if (tableData && tableData.length) {
                $.each(tableData, function(fi, valf) {
                  fileData[fileParId] += ',' + valf.id;
                })
                fileData[fileParId] = fileData[fileParId].substring(1);
              } else {
                fileData[fileParId] = '';
              }
            }
          });
        })

        if (variable.type === 'transfrom' || variable.type === 'view') {
          // 维护
          $('form[lay-filter="RecordInputForm"] .view-row-title').remove();
          setFomeDisabled('RecordInputForm', '.disabled');
        }
      }
    }
  });

  // 新建整体提交
  var subFormData = null;
  form.on('submit(formSave)', function(data) {
    subFormData = data.field;
    
    var achieveTeamPerson = getTableData('teamPersonList'); // 科技成果完成团队情况
    if (!achieveTeamPerson) {
      layer.msg('激励人员名单不能为空！', {icon: 2});
      subFormData = null;
      return false;
    } else {
      subFormData.teamPerson = achieveTeamPerson;
    }

    // 判断备案信息相关附件是否为空
    var fileValue = getFileValue(subFormData), newFileValue = {};
    for (var fileKey in fileValue) {
      if (!fileValue[fileKey][1]) {
        layer.msg(fileValue[fileKey][0] + '附件不能为空！', {icon: 2});
        subFormData = null;
        break;
      } else {
        newFileValue[subFormData[fileKey]] = fileValue[fileKey][1];
      }
    }
    if (!subFormData) {
      return false;
    } else {
      subFormData.files = JSON.stringify(newFileValue);
    }
    $('[lay-filter="editTranfromMaintain"]').click();
    return false;
  })

  // 维护，新增 => 转化净收益及激励方案
  form.on('submit(editTranfromMaintain)', function(data) {
    var teamPerson = getTableData(groupTableId),
    transfromData = data.field,
    tipsTitle = '备案信息提交审批';
    if (!teamPerson) {
      layer.msg('科技成果完成团队情况不能为空！', {icon: 2});
      return false;
    } else {
      transfromData.teamPerson = teamPerson;
    }

    // 判断备案信息相关附件是否为空
    var fileValue = getFileValue(transfromData), newFileValue = {};
    for (var fileKey in fileValue) {
      if (!fileValue[fileKey][1]) {
        layer.msg(fileValue[fileKey][0] + '附件不能为空！', {icon: 2});
        transfromData = null;
        break;
      } else {
        newFileValue[transfromData[fileKey]] = fileValue[fileKey][1];
      }
    }
    if (!transfromData) {
      return false;
    } else {
      transfromData.files = JSON.stringify(newFileValue);
    }

    var baseUrl = '/achieveReward-api/save', allData = null;
    if (variable.type === 'input') {
      // 备案信息录入
      baseUrl = '/achieveRecord-api/submit';
      allData = {
        creator: null,
        createDate: new Date().getTime(),
        updator: null,
        updateDate: new Date().getTime(),
        deleted: '0',
        createUnitId: '',
        createUnitName: '',
        achieveRecord: subFormData,
        achieveReward: transfromData
      };
    } else {
      // 奖励方案维护
      allData = transfromData;
      tipsTitle = '转化收益维护提交';
    }
    
    // 发起http请求
    var submitIndex = top.layer.load(2);
    $('[lay-filter="formSave"], [lay-filter="editTranfromMaintain"]').prop('disabled', true);
    httpModule({
      url: baseUrl,
      type: 'POST',
      data: allData,
      success: function(res) {
        top.layer.close(submitIndex);
        $('[lay-filter="formSave"], [lay-filter="editTranfromMaintain"]').prop('disabled', true);
        if (res.code === '0' || res.success === true) {
          top.layer.msg(tipsTitle + '成功。', {icon: 1});

          // 提交成功刷新页面为读取状态；
          window.location.href = window.location.pathname+ '?id='+variable.id+'&type=view';
        } else {
          top.layer.msg(tipsTitle + '失败！', {icon: 2});
        }
      },
      error: function(err) {
        top.layer.close(submitIndex);
        $('[lay-filter="formSave"], [lay-filter="editTranfromMaintain"]').prop('disabled', true);
      }
    });

    return false;
  })

  // 暂存
  $('[lay-filter="formTempSave"]').on('click', function() {
    var achieveTeamPerson = getTableData('teamPersonList'), // 科技成果完成团队情况
    achieveRecordData = form.val('RecordInputForm'); // 备案信息;
    arFile = getFileValue(achieveRecordData),  // 备案先挂附件
    newArFile = {};

    delete achieveRecordData.file;
    for (var key in arFile) {
      newArFile[achieveRecordData[key]] = arFile[key][1];
    }
    achieveRecordData.files = JSON.stringify(newArFile);
    achieveRecordData.teamPerson = achieveTeamPerson;

    var achieveRewardData = form.val('newTransfrom'), // 激励信息
    ntFile = getFileValue(achieveRewardData), // 激励方案附件
    newNtFile = {},
    teamPerson = getTableData(groupTableId); // 激励人员名单
    delete achieveRewardData.file;
    for (var key in ntFile) {
      newNtFile[achieveRewardData[key]] = ntFile[key][1];
    }
    achieveRewardData.files = JSON.stringify(newNtFile);
    achieveRewardData.teamPerson = teamPerson;

    var saveData = {
      achieveRecord: achieveRecordData,
      achieveReward: achieveRewardData,
      creator: null,
      createDate: new Date().getTime(),
      updator: null,
      updateDate: new Date().getTime(),
      deleted: '0',
      createUnitId: '',
      createUnitName: ''
    }

    var $this = $(this).prop('disabled', true), loadingIndex = top.layer.load(2);
    httpModule({
      url: '/achieveRecord-api/save',
      type: 'POST',
      data: saveData,
      success: function(res) {
        top.layer.close(loadingIndex);
        $this.prop('disabled', false);
        if (res.code === '0' || res.success) {
          top.layer.msg('备案信息暂存成功！', {icon: 1});
          closeTabsPage(variable.index);
          //window.location.reload();
        }
      },
      error: function() {
        top.layer.close(loadingIndex);
        $this.prop('disabled', false);
      }
    })

    // console.log(form.val('RecordInputForm'), form.val('newTransfrom'));
  })
  $("#reset").click(function () {
      closeTabsPage(variable.index);
  })
  // 查询审批记录
  if (variable.functionId) {
    $('#approvalRecord_layout').show();
    //渲染
    table.render({
      url: '/task/process/list/' + variable.functionId
      ,elem: '#approvalRecord'
      ,method : "POST"
      ,cols : [[
        { title : '序号', type : 'numbers', width : 45 }, {
          field : 'activityState',
          title : '状态',
          style : 'cursor: pointer;',
          align : 'center'
        }, {
          field : 'activityName',
          title : '任务节点名称',
          width : '15%',
          style : 'cursor: pointer;'
        }, {
          field : 'taskName',
          title : '任务名称',
          width : '20%',
          style : 'cursor: pointer;'
        }, {
          field : 'assigneeName',
          title : '处理人',
          width : '15%',
          style : 'cursor: pointer;'
        }, {
          field : 'endTime',
          title : '处理时间',
          width : '20%',
          style : 'cursor: pointer;',
          templet : '<div>{{ layui.laytpl.toDateString(d.endTime) }}</div>',
          align : 'center'
        }, {
          field : 'suggestion',
          title : '处理意见'
        }
      ]]
    })
  } else {
    $('#approvalRecord_layout').hide();
  }
})
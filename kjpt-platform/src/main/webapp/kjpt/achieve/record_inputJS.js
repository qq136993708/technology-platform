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
  ]];

  if(variable.flag==1){
    $("#all_page_submit").hide();
  }

  // 获取激励方案初始数据
  function getNewInitAchieveReward() {
    var newInit = null;
    httpModule({
      async: false, // 同步请求
      url: '/achieveReward-api/newInit',
      success: function(res) {
        if (res.code === '0' || res.success === true) {
          newInit = res.data;
          newInit.achieveRecordId = variable.id;
        }
      }
    });
    return newInit;
  }

  // 添加 转化净收益及激励方案
  function addTransfromMaintain(data, auditStatus) {
    var wrapID = 'init_transfrom_maintain',
      yearData = null, // 当前年的激励方案
      excitationData = [];

    if (variable.type === 'transfrom') {
      var year = new Date().format('yyyy');
      // 判断是否有当前年激励方案
      for (var i = 0; i < data.length; i++) {
        if (year === data[i].rewardYear) {
          yearData = switchHttpData(data[i]);
        } else {
          excitationData.push(data[i]);
        }
      }

      // 添加显示以往激励方案的 HTML
      $('#init_transfrom_maintain').empty();
      $('#all_page_submit').remove();
      $.each(excitationData, function(i, val) {
        $('#init_transfrom_maintain').append('<div class="maintain_list" filter="oldTransfrom_'+i+'"></div>');
      });

      // 维护新增激励方案
      wrapID = 'edit_transfrom_maintain';
      if (yearData.status == 0 || yearData.status == 3) {
        excitationData.unshift(yearData);
      } else {
        excitationData.unshift(getNewInitAchieveReward());
      }

    } else if (variable.type === 'input') {
      if (!data || !data.length) {
        // 录入新增激励方案
        excitationData.unshift(getNewInitAchieveReward());
      } else {
        excitationData = switchHttpData(data);
        $('#' + wrapID).empty().append('<div class="maintain_list" filter="newTransfrom"></div>');
      }
    } else {
      excitationData = switchHttpData(data);
    }

    if (variable.type !== 'view') {
      if (!yearData || (yearData.status == 0 || yearData.status == 3)) {
        $('#' + wrapID).empty().append('<div class="maintain_list" filter="newTransfrom"></div>');
      }
    } else {
      // 添加显示以往激励方案的 HTML
      $('#init_transfrom_maintain').empty();
      $('#all_page_submit').remove();
      $.each(excitationData, function(i, val) {
        $('#init_transfrom_maintain').append('<div class="maintain_list" filter="oldTransfrom_'+i+'"></div>');
      });
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

          // 草稿
          form.val('newTransfrom', excitationData[htmlIndex]);
          if ( excitationData[htmlIndex].teamPerson ) {
            backfill(excitationData[htmlIndex].teamPerson, groupTableId);
          }
        } else {
          var tempTableId = randomID(); // 动态生产随机ID
          $groupTable.attr('id', tempTableId);
          // 给当前激励方案赋值回显
          form.val(formFilter, data[htmlIndex]);

          // 回显团队成员
          if ( excitationData[htmlIndex].teamPerson ) {
            backfill(excitationData[htmlIndex].teamPerson, tempTableId, 'view');
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
    if (data.hasOwnProperty('transPublicDoc')) {
      // 合同（协议）文本：
      fileTemp = fileData[data.transPublicDoc] || '';
      fileValue.transPublicDoc = ['公示及结果材料', fileTemp];
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

        var scope_disabled = true;
        if (variable.type === 'transfrom' || variable.type === 'view') {
          // 维护
          $('form[lay-filter="RecordInputForm"] .view-row-title').remove();
          setFomeDisabled('RecordInputForm', '.disabled');
          scope_disabled = true;
        }

        // 更新表单状态
        form.render();

        // 添加知悉范围
        setJurisdictionScope({
          elem: 'scope_list_layout',
          knowledgeScope: detailsData.knowledgeScope,
          knowledgePerson: detailsData.knowledgePerson,
          secretLevel: detailsData.secretLevel,
          disabled: scope_disabled
        });
      }
    }
  });

  // 成果转化备案上报
  var subFormData = null;
  form.on('submit(formFlow)', function(data) {
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

    var baseUrl = '/achieveReward-api/save',
      allData = null;

    if (variable.type === 'input') {
      // 录入备案信息上报
      // 激励方案密级与备案密级保持一致;
      transfromData.secretLevel = subFormData.secretLevel;

      // 备案信息录入 上报前需先暂存且所有必填项不能为空
      baseUrl = '/achieveRecord-api/save';
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
    } else if (variable.type === 'transfrom') {
      // 奖励方案维护
      allData = transfromData;
      tipsTitle = '转化收益维护提交';
      // 激励方案密级与备案密级保持一致;
      allData.secretLevel = form.val('RecordInputForm').secretLevel;
    } else {
      return false;
    }
    
    // 发起http请求
    var submitIndex = top.layer.load(2);
    $('[lay-filter="formFlow"], [lay-filter="editTranfromMaintain"]').prop('disabled', true);
    httpModule({
      url: baseUrl,
      type: 'POST',
      data: allData,
      success: function(res) {
        top.layer.close(submitIndex);
        if (res.code === '0' || res.success === true) {
          // top.layer.msg(tipsTitle + '成功。', {icon: 1});
          // 上报暂存成功刷新页面为读取状态；
          var viewUrl =  window.location.pathname+ '?id='+variable.id+'&type=view';
          if (variable.type === 'input') {
            // 备案信息ID
            viewUrl += '&flow=1&billId=' + variable.id;
          } else if ( variable.type === 'transfrom') {
            // 激励方案信息ID
            viewUrl += '&flow=2&billId=' + transfromData.id;
          }
          if (variable.functionId) {
            // 流程ID
            viewUrl += '&functionId='+ variable.functionId;
          }
          if (variable.index) {
            // 上层iframe的index
            viewUrl += '&index=' + variable.index;
          }
          // 刷新页面
          window.location.href = viewUrl;
        } else {
          top.layer.msg(tipsTitle + '失败！', {icon: 2});
          $('[lay-filter="formFlow"], [lay-filter="editTranfromMaintain"]').prop('disabled', false);
        }
      },
      error: function(err) {
        top.layer.close(submitIndex);
        $('[lay-filter="formFlow"], [lay-filter="editTranfromMaintain"]').prop('disabled', false);
      }
    });
    return false;
  });

  // 页面上报暂存完成后走流程
  if (variable.flow) {
    var submitIndex = top.layer.load(2);
    if (variable.flow == '1') {
      // 备案上报流程 billId
      $('#functionId').val(variable.functionId); // 备案上报ID
      $('#flow_id').val(variable.billId); // 备案ID
      dealFlow('/workflow/start/audit-type', variable.functionId, submitIndex);
    } else if (variable.flow == '2') {
      // 激励上报流程
      var excitationID = top.$('a[lay-href="/achieveReward_list_flow"]').data('id');
      if (excitationID) {
        $('#functionId').val(excitationID); // 激励上报ID
        $('#flow_id').val(variable.billId); // 激励ID
        dealFlow('/achieveReward-api/start_workflow', excitationID, submitIndex);
      } else {
        dialogError({
          code: '-1',
          msg: '激励方案上报失败！',
          data: '没有查找到流程，请确认是否已配置流程权限。'
        });
      }
    }
  }

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
    // 激励方案密级与备案密级保持一致;
    achieveRewardData.secretLevel = achieveRecordData.secretLevel;

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
  });

  // 查询审批记录
  $('#approvalRecord_layout').hide();

})
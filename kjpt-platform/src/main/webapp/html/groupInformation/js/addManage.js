layui.use(['form','laydate'], function(){
	var form = layui.form;
	
  var variable = getQueryVariable();
  var reportTypeVal = variable.reportType;
  // switch(+reportTypeVal){
  //   case 1:
  //       $('#configName').html("科技规划名称:");
  //   break;
  //   case 2:
  //       $('#configName').html("工作指南名称:");
  //   break;
  //   case 3:
  //       $('#configName').html("工作要点名称:");
  //   break;
  //   case 4:
  //       $('#configName').html("质量信息名称:");
  //   break;
  // }
  var itemDataUrl = '/manageMethod-api/newInit';
  var billID = variable.id || '';
  var msgTitle = '新增';
  var readonlyFile = false; // 附件是否只读
  // layui.laydate.render({elem: '#releaseTimes',trigger:'click'});
  

  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    itemDataUrl = '/manageMethod-api/load/' + variable.id;
    msgTitle = '查看';
    readonlyFile = true;
  } else if (variable.type === 'add') {
    // 年份月度
    layui.laydate.render({elem: '#annualDate',trigger:'click'});
  } else if (variable.type === 'edit') {
    itemDataUrl = '/manageMethod-api/load/' + variable.id;
    msgTitle = '编辑';
    // 年份月度
    layui.laydate.render({elem: '#annualDate',trigger:'click'});
  }

  

  httpModule({
    url: itemDataUrl,
    success: function(res) {
      if (res.code === '0') {
        var formData = res.data;
        if (formData.annual) {
          formData.annual = new Date(formData.annual).format('yyyy-MM');
        }
        if(formData.pubdate){
          formData.pubdate = new Date(formData.pubdate).format('yyyy-MM-dd');
        }
        form.val('formAddPlan', formData);
        form.render();
        $('#reportType').val(reportTypeVal);
        
        var scopeDisabled = false;
        if (variable.type === 'see') {
          setFomeDisabled('formAddPlan', '.disabled');
          $('.disabled-box').remove();
          layui.form.render('select');
          $('#reportType').val(reportTypeVal);
          scopeDisabled = true;
        }

        // 添加知悉范围
        setJurisdictionScope({
          elem: 'scope_list_layout',
          knowledgeScope: formData.knowledgeScope,
          knowledgePerson: formData.knowledgePerson,
          secretLevel: formData.secretLevel,
          disabled: scopeDisabled
        });
      }
    }
  })

  // 附件
  setFileUpload({
    id: 'addPlanFile',
    dataID: billID,
    readonly: readonlyFile,
    secretLevel : function() {
      return $("#secretLevel").val();
    },
    callback: function (tableData, type) {
      if (tableData) {
        var fileIds = '';
        $.each(tableData, function(i, item) {
          fileIds += ',' + item.id;
        })
        fileIds = fileIds.substring(1);
        form.val('formAddPlan', {files: fileIds});
      } else {
        form.val('formAddPlan', {files: ''});
      }
    }
  });


  form.on('submit(formAddPlanBtn)', function(data) {
    var saveData = data.field;
    if (saveData.annual) {
      saveData.annual = new Date(saveData.annual).getTime();
    }
    if(saveData.pubdate){
      saveData.pubdate = new Date(saveData.pubdate).getTime();
    }
    httpModule({
      url: '/manageMethod-api/save',
      data: saveData,
      type: 'POST',
      success: function(res) {
        if (res.code === '0') {
          setDialogData(res);
					top.layer.closeAll();
        } else {
					layer.msg(msgTitle + '失败!', {icon: 2});
        }
      }
    });
    return false;
  })


});
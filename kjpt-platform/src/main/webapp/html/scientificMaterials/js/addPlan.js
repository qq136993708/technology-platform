layui.use(['form', 'formSelects', 'laydate'], function(){
	var form = layui.form;
	var tipTitle = "";
  var variable = getQueryVariable();
  var reportTypeVal = +variable.reportType;
  switch(reportTypeVal){
    case 1:
        $('#configName').html("科技规划名称:");
        tipTitle = "科技规划";
    break;
    case 2:
        $('#configName').html("工作要点名称:");
        tipTitle = "工作要点";
    break;
    case 3:
        $('#configName').html("科技进度名称:");
        tipTitle = "科技进度";
    break;
    case 4:
        $('#configName').html("年度总结名称:");
        tipTitle = "年度总结";
    break;
  }

  if(reportTypeVal !== 1){ //专业领域和专业类别是否隐藏
    $('#professionalField').css("display","none");
    $('#professionalType').css("display","none");
  }


  var itemDataUrl = '/SciencePlan/newInit';
  var billID = variable.id || '';
  var msgTitle = '添加';
  var readonlyFile = false; // 附件是否只读
  layui.laydate.render({elem: '#releaseTimes',trigger:'click'});
  

  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    itemDataUrl = '/SciencePlan/load/' + variable.id;
    readonlyFile = true;
  } else if (variable.type === 'add') {
    // 年份月度
    layui.laydate.render({elem: '#annualDate', type: 'month'});
  } else if (variable.type === 'edit') {
    itemDataUrl = '/SciencePlan/load/' + variable.id;
    msgTitle = '编辑';
    // 年份月度
    layui.laydate.render({elem: '#annualDate', type: 'month'});
  }

  

  httpModule({
    url: itemDataUrl,
    success: function(res) {
      if (res.code === '0') {
        var formData = res.data;
        if (formData.annual) {
          formData.annual = new Date(formData.annual).format('yyyy-MM');
          formData.releaseTime = new Date(formData.annual).format('yyyy-MM');
        }
        if(formData.releaseTime){
          formData.releaseTime = new Date(formData.releaseTime).format('yyyy-MM-dd');
        }
        form.val('formAddPlan', formData);
        form.render();
        $('#reportType').val(reportTypeVal);
        if (formData.authenticateUtil) {
          layui.formSelects.value('authenticateUtil', [formData.authenticateUtil]);
        }
        if (variable.type === 'see') {
          setFomeDisabled('formAddPlan', '.disabled');
          $('.disabled-box').remove();
          layui.form.render('select');
          $('#reportType').val(reportTypeVal);
          layui.formSelects.disabled();
        }
      }
    }
  })

  // 附件
  setFileUpload({
    id: 'addPlanFile',
    dataID: billID,
    readonly: readonlyFile,
    callback: function (tableData, type) {
      if (tableData) {
        var fileIds = '';
        $.each(tableData, function(i, item) {
          fileIds += ',' + item.id;
        })
        fileIds = fileIds.substring(1);
        form.val('formAddPlan', {accessory: fileIds});
      } else {
        form.val('formAddPlan', {accessory: ''});
      }
    }
  });


  form.on('submit(formAddPlanBtn)', function(data) {
    var saveData = data.field;
    
    if (saveData.annual) {
      saveData.annual = new Date(saveData.annual).getTime();
    }
    console.log('saveData',saveData);
    httpModule({
      url: '/SciencePlan/save',
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
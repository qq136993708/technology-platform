layui.use(['laydate', 'form', 'formSelects'], function(){
	var form = layui.form;
	
  var variable = getQueryVariable();
  console.log(variable);

  var itemDataUrl = '/ScienceEvolveDynamic/newInit';
  var billID = variable.id || '';
  var msgTitle = '添加';
  var readonlyFile = false;

  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    itemDataUrl = '/ScienceEvolveDynamic/load/' + variable.id;
    readonlyFile = true;
  } else if (variable.type === 'add') {
    // 年份月度
    layui.laydate.render({elem: '#annualDate', type: 'month'});
  } else if (variable.type === 'edit') {
    itemDataUrl = '/ScienceEvolveDynamic/load/' + variable.id;
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
        }
        form.val('formAddProgress', formData);
        form.render();
        if (formData.authenticateUtil) {
          layui.formSelects.value('authenticateUtil', [formData.authenticateUtil]);
        }
        if (variable.type === 'see') {
          setFomeDisabled('formAddProgress', '.disabled');
          $('.disabled-box').remove();
          layui.form.render('select');
          layui.formSelects.disabled();
        }
      }
    }
  })

  // 附件
  setFileUpload({
    id: 'addProgressFile',
    dataID: billID,
    readonly: readonlyFile,
    callback: function (tableData, type) {
      if (tableData) {
        var fileIds = '';
        $.each(tableData, function(i, item) {
          fileIds += ',' + item.id;
        })
        fileIds = fileIds.substring(1);
        form.val('formAddProgress', {accessory: fileIds});
      } else {
        form.val('formAddProgress', {accessory: ''});
      }
    }
  });


  form.on('submit(formAddProgressBtn)', function(data) {
    var saveData = data.field;
    if (saveData.annual) {
      saveData.annual = new Date(saveData.annual).getTime();
    }
    httpModule({
      url: '/ScienceEvolveDynamic/save',
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
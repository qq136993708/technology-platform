layui.use(['form', 'formSelects', 'laydate'], function(){
  var form = layui.form;
  var formSelects = layui.formSelects;
	
  var variable = getQueryVariable();
  console.log(variable);

  var itemDataUrl = '/WorkPoint/newInit';
  var billID = variable.id || '';
  var msgTitle = '添加';
  var readonlyFile = false; // 附件是否只读

  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    itemDataUrl = '/WorkPoint/load/' + variable.id;
    readonlyFile = true;
  } else if (variable.type === 'add') {
    // 年份月度
    layui.laydate.render({elem: '#annualDate', type: 'month'});
  } else if (variable.type === 'edit') {
    itemDataUrl = '/WorkPoint/load/' + variable.id;
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
        form.val('formAddPoints', formData);
        form.render();
        if (formData.authenticateUtil) {
          formSelects.value('authenticateUtil', [formData.authenticateUtil]);
        }
        if (variable.type === 'see') {
          setFomeDisabled('formAddPoints', '.disabled');
          $('.disabled-box').remove();
          layui.form.render('select');
          formSelects.disabled();
        }
      }
    }
  })

  // 附件
  setFileUpload({
    id: 'addPointsFile',
    dataID: billID,
    readonly: readonlyFile,
    callback: function (tableData, type) {
      if (tableData) {
        var fileIds = '';
        $.each(tableData, function(i, item) {
          fileIds += ',' + item.id;
        })
        fileIds = fileIds.substring(1);
        form.val('formAddPoints', {accessory: fileIds});
      } else {
        form.val('formAddPoints', {accessory: ''});
      }
    }
  });


  form.on('submit(formAddPointsBtn)', function(data) {
    var saveData = data.field,
    utilData = formSelects.value('authenticateUtil');
    if (saveData.annual) {
      saveData.annual = new Date(saveData.annual).getTime();
    }
    if (utilData.length) {
      saveData.authenticateUitlText = utilData[0].name;
    }
    httpModule({
      url: '/WorkPoint/save',
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
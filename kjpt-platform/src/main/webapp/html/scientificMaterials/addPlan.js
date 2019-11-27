layui.use(['element', 'form', 'table', 'formSelects'], function(){
	var element = layui.element;
	var table = layui.table;
	var form = layui.form;
	
  var variable = getQueryVariable();
  console.log(variable);

  var itemDataUrl = '/SciencePlan/newInit';
  var billID = variable.id || '';
  var msgTitle = '添加';

  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    setFomeDisabled('formAddPlan', '.disabled');
    $('.disabled-box').remove();
    layui.form.render('select');
    layui.formSelects.disabled();
  } else if (variable.type === 'add') {
    
  } else if (variable.type === 'edit') {
    itemDataUrl = '/SciencePlan/load/' + variable.id;
    msgTitle = '编辑';
  }
  
  httpModule({
    url: itemDataUrl,
    success: function(res) {
      if (res.code === '0') {
        var formData = res.data;
        form.val('formAddPlan', formData);
        form.render();
        if (formData.authenticateUtil) {
          layui.formSelects.value('authenticateUtil', [formData.authenticateUtil]);
        }
      }
    }
  })


  // 附件
  setFileUpload({
    id: 'addPlanFile',
    dataID: billID,
    callback: function (tableData, type) {
      console.log(tableData);
    }
  });


  form.on('submit(formAddPlanBtn)', function(data) {


    httpModule({
      url: '/SciencePlan/save',
      data: data.field,
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
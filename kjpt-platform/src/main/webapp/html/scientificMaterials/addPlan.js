layui.use(['element', 'form', 'table', 'formSelects'], function(){
	var element = layui.element;
	var table = layui.table;
	var form = layui.form;
	
  var variable = getQueryVariable();
  if (variable.type === 'see') {
    // 查看-设置表单元素为disabled
    setFomeDisabled('formAddPlan', '.disabled');
    $('.disabled-box').remove();
    layui.form.render('select');
    layui.formSelects.disabled();
  } else if (variable.type === 'add') {

  } else if (variable.type === 'edit') {

  }

  var billID = '';
  setFileUpload({
    id: 'addPlanFile',
    dataID: billID,
    callback: function (tableData, type) {
      console.log(tableData);
    }
  });



});
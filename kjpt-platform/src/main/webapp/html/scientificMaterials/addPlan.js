layui.use(['element', 'form', 'jquery', 'formSelects'], function(){
	var element = layui.element;
	var $ = layui.jquery;
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
});
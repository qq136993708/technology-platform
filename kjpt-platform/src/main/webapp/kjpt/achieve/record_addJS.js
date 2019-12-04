layui.use(['form', 'formSelects', 'laydate'], function() {
  var form = layui.form,
  laydate = layui.laydate,
  formSelects = layui.formSelects,
  itemInitApi = '',
  variable = getQueryVariable();
  
  console.log(variable);
  if (variable.type === 'view') {
    $('[lay-submit]').remove();
  } else {

  }


  httpModule({
    url: itemInitApi,
    success: function(res) {
      if (res.code === '0' || res.success === true) {
        if (variable.type === 'view') {
          setFomeDisabled('newRecordFome', '.disabled');
          form.render('select');
        } else {
          laydate.render({elem: '#estimate'})
        }
      }
    }
  });


})
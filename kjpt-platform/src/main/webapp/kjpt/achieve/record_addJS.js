layui.use(['form', 'formSelects', 'laydate'], function() {
  var form = layui.form,
  laydate = layui.laydate,
  formSelects = layui.formSelects,
  itemInitApi = '/achieveRecord-api/newInit',
  variable = getQueryVariable();
  
  console.log(variable);
  if (variable.type === 'view') {
    $('[lay-submit]').remove();
    itemInitApi = '/achieveRecord-api/load/' + variable.id
  } else if (variable.type === 'edit') {
    itemInitApi = '/achieveRecord-api/load/' + variable.id
  }


  httpModule({
    url: itemInitApi,
    success: function(res) {
      if (res.code === '0' || res.success === true) {
        var newData = res.data.achieveRecord || res.data;
        if (variable.type === 'add' && !newData.auditStatus) {
          newData.auditStatus = '0';
        }
        if (newData.aboutCompleteTime) {
          newData.aboutCompleteTime = new Date(newData.aboutCompleteTime).format('yyyy-MM-dd')
        }
        form.val('newRecordFome', newData);
        if (variable.type === 'view') {
          setFomeDisabled('newRecordFome', '.disabled');
        } else {
          laydate.render({elem: '#estimate'})
        }
        form.render();
      }
    }
  });

  // 获取表单数据并校验
  form.on('submit(newSubmit)', function(data) {
    var saveData = {
      achieveRecord: data.field,
      achieveReward: null,
      creator: null,
      createDate: new Date().getTime(),
      updator: null,
      updateDate: new Date().getTime(),
      deleted: '0'
    }
    saveData.achieveRecord.aboutCompleteTime = new Date(saveData.achieveRecord.aboutCompleteTime).getTime()

    httpModule({
      url: '/achieveRecord-api/save',
      data: saveData,
      type: 'POST',
      success: function(res) {
        if (res.code === '0' || res.success === true) {
          setDialogData(res);
					top.layer.closeAll();
        } else {
          var msgTitle = '编辑';
					if (variable.type === 'add') {
						msgTitle = '添加';
					}
					layer.msg(msgTitle + '失败!', {icon: 2});
        }
      }
    });

    return false;
  })

  


})
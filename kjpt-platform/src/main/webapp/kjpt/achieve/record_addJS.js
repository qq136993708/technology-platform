layui.use(['form', 'formSelects', 'laydate'], function() {
  var form = layui.form,
  laydate = layui.laydate,
  formSelects = layui.formSelects,
  itemInitApi = '/achieveRecord-api/newInit',
  variable = getQueryVariable();
  
  function openCorAchieveDialog() {
    // 打开弹窗
    top.layer.open({
      type: 2,
      title: '选择核心成果',
      area: ['720px', '480px'],
      content: '/kjpt/achieve/coreAchieve.html',
      btn: null,
      end: function() {
        var value = getDialogData('dialog-data');
        if (value) {
          // console.log('achieveValue => ', value);
          form.val('newRecordFome', {
            achieveName: value.achieveName,
            achieveId: value.id,
            achieveTransType: value.achieveTransType,
            finishUnitName: value.finishUnitName
          })
        }
      }
    });
  }

  if (variable.type === 'view') {
    $('[lay-submit]').remove();
    itemInitApi = '/achieveRecord-api/load/' + variable.id
    gray()
  } else if (variable.type === 'edit') {
    itemInitApi = '/achieveRecord-api/load/' + variable.id
  }
  $('#selectAchieve').on('click', '.selectIcon', function() {
    openCorAchieveDialog();
  })

  httpModule({
    url: itemInitApi,
    success: function(res) {
      if (res.code === '0' || res.success === true) {
        var newData = res.data.achieveRecord || res.data;
        if (variable.type === 'add' && !newData.auditStatus) {
          newData.auditStatus = '0';
        }
        if (!newData.achieveType && newData.achieveType !== 0) {
          newData.achieveType = '0';
        }
        if (newData.publicityStartDate) {
          newData.publicityStartDate = new Date(newData.publicityStartDate).format('yyyy-MM-dd')
        }
        form.val('newRecordFome', newData);
        if (variable.type === 'view') {
          setFomeDisabled('newRecordFome', '.disabled');
        } else {
          laydate.render({elem: '#estimate',trigger:'click'})
        }
        form.render();
        if (newData.finishUnitName) {
          formSelects.value('finishUnitName', [newData.finishUnitName]);
         }
        var scope_disabled = false;

        // 监听是否为核心成果
        if (variable.type != 'view') {
          form.on('select(achieveType)', function(data) {
            if (data.value == '1') {
              $('#selectAchieve').addClass('let-input-search')
              .find('.search-icon').addClass('selectIcon').show();
              $('[name="achieveTransType"]').prop('disabled', true);
              $('[name="finishUnitName"], [name="achieveName"]').attr({ readonly: 'readonly', placeholder: '请选择核心成果' });
            } else {
              $('#selectAchieve').removeClass('let-input-search')
              .find('.search-icon').removeClass('selectIcon').hide();
              $('[name="achieveTransType"]').prop('disabled', false);
              $('[name="finishUnitName"], [name="achieveName"]').removeAttr('readonly').attr({placeholder: '请填写...' });
            }
            // 选项变化时清空数据
            form.val('newRecordFome', {achieveName: '', achieveId: ''})
            form.render('select');
          })
        } else {
          scope_disabled = true;
        }
        // 添加知悉范围
        setJurisdictionScope({
          elem: 'scope_list_layout',
          knowledgeScope: newData.knowledgeScope,
          knowledgePerson: newData.knowledgePerson,
          secretLevel: newData.secretLevel,
          disabled: scope_disabled
        });

      }
    }
  });

  // 获取表单数据并校验
  form.on('submit(newSubmit)', function(data) {
    var saveData = {
      achieveRecord: data.field,
      achieveReward: null,
      createUnitId: '',
      createUnitName: '',
      creator: null,
      createDate: new Date().getTime(),
      updator: null,
      updateDate: new Date().getTime(),
      deleted: '0'
    }
    saveData.achieveRecord.publicityStartDate = new Date(saveData.achieveRecord.publicityStartDate).getTime();
    saveData.achieveRecord.achieveRewards = [];

    httpModule({
      url: '/achieveRecord-api/simpleSave',
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
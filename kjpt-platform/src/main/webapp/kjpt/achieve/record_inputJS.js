layui.use(['table', 'form'], function() {
  var form = layui.form,
  variable = getQueryVariable(),
  groupTableId = '',
  fileCols = [
    {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
    {title: '操作', templet: function(d) {
      var templet = '<div class="file-options">';
        templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
        templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
      templet += '</div>';
      return templet;
    }}
  ]

  // 添加 转化净收益及激励方案
  function addTransfromMaintain(data) {
    var wrapID = 'init_transfrom_maintain';
    if (typeof(data) === 'object' && data.length) {
      wrapID = 'edit_transfrom_maintain';
      $('#init_transfrom_maintain').empty();
      $('#all_page_submit').remove();
      $.each(data, function(i, val) {
        $('#init_transfrom_maintain').append('<div class="maintain_list" filter="oldTransfrom_'+i+'"></div>');
      })
    }
    if (variable.type !== 'view') {
      $('#' + wrapID).empty().append('<div class="maintain_list" filter="newTransfrom"></div>');
    }

    $('.maintain_list').each(function() {
      var $layoutItem = $(this),
      formFilter = $layoutItem.attr('filter');

      $layoutItem.load('record_maintain.html', function() {
        $layoutItem.find('.layui-form:eq(0)').attr('lay-filter', formFilter);

        $layoutItem.find('.file-filter-options').each(function() {
          var $this = $(this);
          setFileUpload({
            id: $this, // 附件上传作用域ID值 必传
            dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
            cols: fileCols,
            callback: function (tableData, type) {
              console.log(tableData, type);
            }
          });
        })
    
        // 添加人员
        $layoutItem.find('.dy-add-table').each(function(index, elem) {
          $(this).attr('id', 'achieveTable_' + index);
        })

        // 更新表单渲染
        form.render();

        if (wrapID === 'edit_transfrom_maintain') {
          if (formFilter !== 'newTransfrom') {
            // 删除当前区域提交按钮
            $layoutItem.find('.view-page-submit-btn-box, .view-row-title').remove();
            setFomeDisabled(formFilter, '.disabled');
          }
        } else {
          $layoutItem.find('.view-page-submit-btn-box').hide();
        }

        var $groupTable = $layoutItem.find('.dy-add-table:eq(0)');
        if (formFilter === 'newTransfrom') {
           groupTableId = randomID(); // 动态生产随机ID
           $groupTable.attr('id', groupTableId);

           /*添加tr*/
           $layoutItem.find('.dy-add-btn:eq(0)').click(function () {
            addTr(groupTableId);
            deleTr(groupTableId);
          })

          httpModule({
            url: '/achieveReward-api/newInit'
          });
        } else {
          var tempTableId = randomID(); // 动态生产随机ID
          $groupTable.attr('id', tempTableId);
          // 回显团队成员
          // backfill(relData.data.teamPerson, tempTableId);
        }
      })
    })
  }

  $('#RecordInputForm .file-filter-options').each(function(i, elem) {
    setFileUpload({
      id: $(this), // 附件上传作用域ID值 必传
      dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
      cols: fileCols,
      callback: function (tableData, type) {
        console.log(tableData, type);
      }
    });
  })

  if (variable.type === 'transfrom' || variable.type === 'view') {
    // 维护
    addTransfromMaintain([{a: 1}, {b: 3}]);

    $('form[lay-filter="RecordInputForm"] .view-row-title').remove();
    setFomeDisabled('RecordInputForm', '.disabled');
  } else if (variable.type === 'input') {
    // 新增备案
    addTransfromMaintain();
  }


  // 新建整体提交
  form.on('submit(formSave)', function() {
    $('[lay-filter="editTranfromMaintain"]').click();


    return false;
  })

  // 维护，新增 => 转化净收益及激励方案
  form.on('submit(editTranfromMaintain)', function() {
    console.log(' => ');
    var teamPerson = getTableData(groupTableId);
  })

  // 暂存
  $('[lay-filter="formTempSave"]').on('click', function() {
    var teamPerson = getTableData(groupTableId);
    console.log(form.val('RecordInputForm'), form.val('newTransfrom'));
  })
})
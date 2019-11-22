function selectFileUpload(config) {
  // 绑定选择附件上传事件
  var layerLoadIndex = null;
  config.upload.render({
    elem: config.elem //绑定元素
    ,accept: config.accept
    ,url: '/file/upload' //上传接口
    ,before: function(obj) {
      layerLoadIndex = top.layer.load();
    }
    ,done: function(res){
      top.layer.close(layerLoadIndex);
      if (res.code !== '0') {
        top.layer.msg('附件上传失败 => ' + res.message,  {icon: 2});
      }

      // 表格数据变化时执行回调函数
      if (config.callback) {
        config.callback(res);
      }
    }
    ,error: function(error){
      //请求异常回调
      top.layer.close(layerLoadIndex);
      top.layer.msg('附件上传失败，请重新尝试',  {icon: 2});
    }
  });
}

function setFileUpload(config) {
  /*
  config = {
    id: 作用域ID;
    dataID, 单据ID;
    callback 表格数据表格时的回调函数;
    cols: 文件列表表头配置
    更多配置请自行添加
  }
  */
  if (!config.id) { return false; }
  layui.use(['table', 'upload', 'layer'], function(){
    var table = layui.table,
    fileListData = [], // 表格数据
    configDataID = config.dataID, // 单据ID
    readonly = config.readonly,
    tableID = config.id + 'file-table-list',
    $field = $((config.id.indexOf('#') === -1 ? ('#' + config.id) : config.id)),
    addFile = $field.find('[filter="addFile"]').get(0),
    tableDemo = $field.find('table').get(0),
    tableCols = config.cols || [
      {field: 'fileName', title: '文件名称', sort: true},
      {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
      {title: '操作', templet: function(d) {
        var templet = '<div class="file-options">';
        if(! (readonly === true)) {
          templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
        }
        
        templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
        templet += '</div>';
        return templet;
      }}
    ];

    if (configDataID) {
      // 获取附件列表
      httpModule({
        url: '/file/query/' + configDataID,
        success: function(data) {
          if (data.code === '0') {
            if (!data.data.length) {
              return;
            }
            if (fileListData.length) {
              fileListData = fileListData.concat(data.data);
            } else {
              fileListData = data.data;
            }
            // 表格数据变化时执行回调函数
            if (config.callback) {
              config.callback(fileListData, 'query');
            }
          }
        }
      });
    }

    // 附件列表数据
    table.render({ elem: tableDemo, data: fileListData, cols: [tableCols], id: tableID });
  
    // 绑定下载事件
    $field.on('click', '.file-options-download', function(e) {
      var fileID = $(this).data('fileid');
      if (fileID) {
        window.open('/file/downLoadFile/' + fileID);
      }
    }).on('click', '.file-options-delete', function(e) {
      // 删除附件事件
      var fileID = $(this).data('fileid');
      if (fileID) {
        fileListData = fileListData.filter(function(item, i) {
          if (item.id !== fileID) { return item; }
        })
        table.reload(tableID, {data: fileListData});
        // 表格数据变化时执行回调函数
        if (config.callback) {
          config.callback(fileListData, 'delete');
        }
      }
    })

    // 绑定上传事件
    selectFileUpload({
      elem: addFile,
      upload: layui.upload,
      accept: config.accept || 'file',
      callback: function(res) {
        //上传完毕回调
        if (res.code === '0') {
          fileListData.push(res.data);
          table.reload(tableID, {data: fileListData});

          // 表格数据变化时执行回调函数
          if (config.callback) {
            config.callback(fileListData, 'upload');
          }
        }
      }
    });

  })
}


function setImagesUpload(config) {
  /* config = {
    id: '图片上传的作用域ID',
    callback: function(imgJson, type) {}
  }
  */
  if (!config.id) { return false; }

  layui.use(['upload', 'layer'], function(){
    var $imgFile = $((config.id.indexOf('#') === -1 ? ('#' + config.id) : config.id)),
    fileBtn = $imgFile.find('[label="imgUpload"]').get(0),
    $deleteBtn = $imgFile.find('[label="imgDelete"]').eq(0);

    // 绑定上传事件
    selectFileUpload({
      elem: fileBtn,
      upload: layui.upload,
      accept: 'images',
      callback: function(res) {
        //上传完毕回调
        if (res.code === '0') {
          $imgFile.addClass('success').find('img').attr('src', '/file/imgFile/' + res.data.id);
          if (config.callback) {
            config.callback(res.data, 'upload');
          }
        }
      }
    });

    $imgFile.on('click', '.delete-state-normal', function(e) {
      $imgFile.removeClass('success').find('img').attr('src', '');
      if (config.callback) {
        config.callback(null, 'delete');
      }
    })

    if ($deleteBtn.length) {
      $deleteBtn.addClass('delete-state-normal');
    }
  });
}

// 控制图片上传状态 这里不作为绑定上传事件，切与绑定上传事件不冲突
function setImagesUploadState(config) {
  if (config.id) {
    var $imgFile = $((config.id.indexOf('#') === -1 ? ('#' + config.id) : config.id)),
      fileBtn = $imgFile.find('[label="imgUpload"]').get(0),
      $deleteBtn = $imgFile.find('[label="imgDelete"]').eq(0);

    if (config.disabled) {
      // 禁用图片上传功能
      $imgFile.addClass('file-disabled');
      $(fileBtn).attr('disabled', 'true');
      $deleteBtn.removeClass('delete-state-normal');
    } else {
      // 解除禁用图片上传功能
      $(fileBtn).removeAttr('disabled');
      $deleteBtn.addClass('delete-state-normal');
      $imgFile.removeClass('file-disabled');
    }

    if (config.imgID) {
      // 设置图片显示
      $imgFile.addClass('success').find('img').attr('src', '/file/imgFile/' + config.imgID);
    }
  }
}


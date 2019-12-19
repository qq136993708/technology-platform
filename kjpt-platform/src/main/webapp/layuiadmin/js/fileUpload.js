function selectFileUpload(config) {
  // 绑定选择附件上传事件
  var layerLoadIndex = null;
  config.upload.render({
    elem: config.elem //绑定元素
    ,accept: config.accept || 'file'
    ,url:config.url ||  '/file/upload' //上传接口 
    ,data: {
      secretLevel: function() {
        //设定密级，从config.secretLevel中获得，允许使用函数来传递动态值
        if(typeof(config.secretLevel) === 'function'){
          return config.secretLevel();
        } else if(typeof(config.secretLevel) === 'string') {
          return config.secretLevel
        } else {
          return null;
        }
      }
    }
    ,before: function(obj) {
      layerLoadIndex = top.layer.load();
      return true;
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
  var configOption = {
    id: '', // 作用域ID;
    dataID: '', // 单据ID;
    accept: 'file', // 上传附件的类型 file | images
    callback: null, // 表格数据表格时的回调函数;
    cols: null, // 文件列表表头配置
    readonly: false, // 默认可以删除
    download: true // 默认可以下载
  };

  if ( typeof(config) === 'object') {
    for (var key in config) {
    configOption[key] = config[key];
    }
  }

  if (!configOption.id) { return false; }
  layui.use(['table', 'upload', 'layer'], function(){
    var table = layui.table,
    fileListData = [], // 表格数据
    configDataID = configOption.dataID, // 单据ID
    readonly = configOption.readonly, // 
    tableID = randomID(), // 给表格生成不重复的随机ID
    $field = (function() {
      if (typeof(configOption.id) === 'string') {
        return $((configOption.id.indexOf('#') === -1 ? ('#' + configOption.id) : configOption.id));
      } else if (typeof(configOption.id) === 'object') {
        return configOption.id;
      }
    })(),
    addFile = $field.find('[filter="addFile"]').get(0),
    tableDemo = $field.find('table').get(0),
    tableCols = configOption.cols || [
      {field: 'fileName', title: '文件名称', sort: true},
      {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
      {field: 'secretLevelText', title: '密级'},
      {title: '操作', templet: function(d) {
        var templet = '<div class="file-options">';
        if(! (readonly === true)) {
          templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
        }
        if (configOption.download) {
          templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
        }
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

            table.reload(tableID, {data: fileListData});
            // 表格数据变化时执行回调函数
            if (configOption.callback) {
              configOption.callback(fileListData, 'query');
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
        window.open('/file/downLoadFile/' + fileID, '_blank');
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
        if (configOption.callback) {
          configOption.callback(fileListData, 'delete');
        }
      }
    })

    // 绑定上传事件
    selectFileUpload({
      elem: addFile,
      upload: layui.upload,
      accept: configOption.accept || 'file',
      secretLevel : config.secretLevel,
      callback: function(res) {
        //上传完毕回调
        if (res.code === '0') {
          fileListData.push(res.data);
          table.reload(tableID, {data: fileListData});

          // 表格数据变化时执行回调函数
          if (configOption.callback) {
            configOption.callback(fileListData, 'upload');
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
      secretLevel: 'X',
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
/*导入文件*/
function importFiles(config){
    layui.use(['upload'], function(){
        var $field = $((config.id.indexOf('#') === -1 ? ('#' + config.id) : config.id)),
            addFile = $field.find('[filter="addFile"]').get(0)
        selectFileUpload({
            elem: addFile,
            upload: layui.upload,
            url: config.url,
            accept: config.accept || 'file',
            callback: function(res) {
              //上传完毕回调
              if (res.code === '1') {
                res.success = false;
                var errorTips = '';
                $.each(res.data, function(i, item) {
                  errorTips += '<p class="font14">' + item.msg + '</p>';
                })
                if (errorTips) {
                  top.layer.alert(errorTips, {
                    icon: 2,
                    title: '附件导入失败',
                    area: ['420px', '240px']
                  }, function(index) {
                    top.layer.close(index);
                  });
                }
              }
              if (config.callback) {
                config.callback(res, 'import');
              }
            }
        });
    })

}

layui.use(['laypage'], function() {
  var laypage = layui.laypage,
  variable = getQueryVariable(); // 获取页面传参

  function setFilePage(fileId, type) {
    if (!fileId) {
      return false;
    }
    if (type === 'doc' || type === 'docx' || type === 'pdf') {
      httpModule({
        url: '/file/getPdfPageCount/' + fileId,
        // async: false, // 同步请求
        success: function(res) {
          // 附件分页
          if (res.code === '0' || res.success === true) {
            laypage.render({
              elem: 'fileViewPage',
              count: res.data || 0,
              limit: 1,
              curr: 1,
              limits: [1],
              layout: ['prev', 'page', 'next', 'skip'],
              jump: function(page, first) {
                console.log(page, first);
                $('#getPdfPageContent').attr('src', '/file/getPdfPageContent/'+ fileId +'/' + (page.curr - 1));
              }
            });
          }
        }
      })
    } else {/file/imgFile/f635ef6c8f004953800d3dc43e1f2713
      $('#getPdfPageContent').attr('src', '/file/imgFile/'+ fileId);
    }
  }

  function setFileName(name) {
    var fileType = name.split('.'), fileName = '';
    for (var i = 0; i < fileType.length - 1; i++) {
      fileName += '.' + fileType[i];
    }
    fileName = fileName.substring(1);
    fileName = fileName.split(']')[1] || fileName.split(']')[0];
    fileType = fileType[fileType.length - 1];

    console.log(fileName, fileType);
    $('#fileName').text(fileName);
    return fileType;
  }

  function showFileList(data) {
    var fileHtml = '';
    $.each(data, function(i, item) {
      fileHtml += '<div class="file-item-list">';
      fileHtml += '<div class="file-icon"><i class="layui-icon layui-icon-file"></i></div>';
      fileHtml += '<div class="file-title">'+ item.fileName +'</div>';
      fileHtml += '<div class="file-option"><span class="link-text downloadFile" data-fileid="'+item.id+'">下载</span>';
      if (item.fileName.indexOf('.docx') > 0 ||
        item.fileName.indexOf('.doc') ||
        item.fileName.indexOf('.png') ||
        item.fileName.indexOf('.jpg') ||
        item.fileName.indexOf('.jpeg') ||
        item.fileName.indexOf('.gif') ||
        item.fileName.indexOf('.pdf')
      ) {
        fileHtml += '<span class="link-text seeFile" title="'+item.fileName+'" data-fileid="'+item.id+'">预览</span>';
      }
      fileHtml += '</div></div>';
    })
    if (!fileHtml) {
      fileHtml = '<div class="ib-block font14">没有任何附件。</div>';
      $('#filesItem').addClass('middle-block').css('height', 60).empty().html(fileHtml);
    } else {
      $('#filesItem').empty().html(fileHtml);

      var files = data.filter(function(item, i) {
        if (item.fileName.indexOf('.docx') > 0 ||
          item.fileName.indexOf('.doc') ||
          item.fileName.indexOf('.png') ||
          item.fileName.indexOf('.jpg') ||
          item.fileName.indexOf('.jpeg') ||
          item.fileName.indexOf('.gif') ||
          item.fileName.indexOf('.pdf')
        ) {
          return item;
        }
      }),
      file = files[0];

      setTimeout(function() {
        // 默认显示第一页
        var fileType = setFileName(file.fileName);
        setFilePage(file.id, fileType);
      }, 60);
    }
  }

  if (variable.id) {
    httpModule({
      url: '/file/query/' + variable.id,
      success: function(res) {
        if (res.code === '0') {
          showFileList(res.data);
        }
      }
    });


    // 下载、预览
    $('#filesItem').on('click', '.downloadFile', function() {
      var downFileId = $(this).data('fileid');
      window.open('/file/downLoadFile/' + downFileId);
    }).on('click', '.seeFile', function() {
      var fileId = $(this).data('fileid'),
      fileName = $(this).attr('title');
      var fileType = setFileName(fileName);
      setFilePage(fileId, fileType);
    })
  }
})
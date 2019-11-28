$(function() {
  // 获取页面传参
  var variable = getQueryVariable();

  function showFileList(data) {
    var fileHtml = '';
    $.each(data, function(i, item) {
      fileHtml += '<div class="file-item-list">';
      fileHtml += '<div class="file-icon"><i class="layui-icon layui-icon-file"></i></div>';
      fileHtml += '<div class="file-title">'+ item.fileName +'</div>';
      fileHtml += '<div class="file-option"><span class="link-text downloadFile" data-fileid="'+item.id+'">下载</span>';
      fileHtml += '<span class="link-text seeFile" data-fileid="'+item.id+'">预览</span></div></div>';
    })
    if (!fileHtml) {
      fileHtml = '<div class="ib-block font14">没有任何附件。</div>';
      $('#filesItem').addClass('middle-block').css('height', 60).empty().html(fileHtml);
    } else {
      $('#filesItem').empty().html(fileHtml);
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
      var fileId = $(this).data('fileid');
      window.open('/file/downLoadFile/' + fileId);
    }).on('click', '.seeFile', function() {
      var fileId = $(this).data('fileid');
      console.log('预览ID', fileId);
    })
  }
})
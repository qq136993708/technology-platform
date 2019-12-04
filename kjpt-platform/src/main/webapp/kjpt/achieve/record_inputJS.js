layui.use(['table', 'form'], function() {

  var fileCols = [
    {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
    {title: '操作', templet: function(d) {
      var templet = '<div class="file-options">';
        templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
        templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
      templet += '</div>';
      return templet;
    }}
  ]


  setFileUpload({
    id: 'file-filter-options1', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options2', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options3', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options4', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options5', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options6', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options7', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });

  setFileUpload({
    id: 'file-filter-options8', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });
  setFileUpload({
    id: 'file-filter-options9', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });
  setFileUpload({
    id: 'file-filter-options10', // 附件上传作用域ID值 必传
    dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
    cols: fileCols,
    callback: function (tableData, type) {
      console.log(tableData, type);
    }
  });


})
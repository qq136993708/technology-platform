layui.use(['table', 'upload'], function(){
  var table = layui.table;
  var upload = layui.upload;

  var errorText = '解析失败可能是因为文件内容中出现重复信息、文件格式不正确、地址不存在等。';


  function showTableData(res) {
    table.render({
      cols: [[ //表头
        ,{field: 'applicationNumber', title: '申请(专利)号'}
        ,{field: 'unitNameText', title: '单位名称', sort: true }
        ,{field: 'applicationTypeText', title: '申请类型', sort: true}
        ,{field: 'patentTypeText', title: '专利类型' } 
        ,{field: 'applicant', title: '申请人'}
        ,{field: 'inventor', title: '发明人', sort: true}
        ,{field: 'applicationDate', title: '申请日期', sort: true, templet: function(d) {
          return dateFieldText(d.recordDate);
        }}
        ,{field: 'countryText', title: '国别组织'}
        ,{field: 'agency', title: '代理机构', sort: true}
        ,{field: 'legalStatusText', title: '法律状态', sort: true}
      ]],
      elem: '#importTable',
      data: res.data || [],
      page: true,
      limit: 10,
      limits: [5, 10, 15, 20, 30]
    });
  }

  function uploadError(res) {
    $('.layui-form-item:eq(0)').hide();

    if (res.hasOwnProperty('code')) {
      if (res.code === '0') {
        $('.import-table-box:eq(0)').show();
        showTableData(res);
      } else {
        $('#errorMessage').text(res.message || errorText);
        $('.import-error-block:eq(0)').show();
      }
    } else if (res.hasOwnProperty('success')) {
      if (res.success) {
        $('.import-table-box:eq(0)').show();
        showTableData(res);
      } else {
        $('#errorMessage').text(res.message || errorText);
        $('.import-error-block:eq(0)').show();
      }
    } else {
      $('#errorMessage').text(res.message || errorText);
      $('.import-error-block:eq(0)').show();
    }
  }

  upload.render({
    elem: '#importData' //绑定元素
    ,accept: 'file'
    ,url: '/excelImport/kgjimp' //上传接口
    ,before: function(obj) {
      
    }
    ,done: function(res){
      uploadError(res);
    }
    ,error: function(error){
      //请求异常回调
      uploadError(error);
    }
  });


  $('#goBack').click(function() {
    $('.import-error-block:eq(0)').hide();
    $('.layui-form-item:eq(0)').show();
  })

  $('#successBtn').click(function() {
    $('.import-table-box:eq(0)').hide();
    $('.layui-form-item:eq(0)').show();
  })

})
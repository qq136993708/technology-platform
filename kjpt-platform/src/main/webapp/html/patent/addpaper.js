var file_readonly = false;
layui.use(['form', 'table', 'layer', 'upload', 'formSelects','laydate'], function () {
  var form = layui.form;
  var $ = layui.$;
  var variable = getQueryVariable(); // 获取地址栏传递过来的参数
  var laydate = layui.laydate;
  var formSelects = layui.formSelects;
  function getItemInitData(item) {
    var httpUrl = '/treatise-api/newInit';
    if (item && item.id) {
      httpUrl = '/treatise-api/load/' + item.id;
    }
    httpModule({
      url: httpUrl,
      type: 'GET',
      success: function (relData) {
        if (relData.code === '0') {
          // 给form表单赋初始值
          var data = relData.data;
          var billDataID = data.id;
          if(data.unit){
            formSelects.value('unit',[data.unit])
          }
          if(data.publishDate){
            data.publishDate = new Date(data.publishDate).format('yyyy-MM-dd');
          }
          form.val('formMain', data);
          form.render();
          
          if(data.unit) {
        	  data.unit = data.unit.split(',');
        	  formSelects.value('unit', data.unit);
          }
          setFileUpload({
            id: 'file-filter-options', // 附件上传作用域ID值 必传
            dataID: billDataID, // 用来查找当前单据下绑定的附件，没有则不查找
            readonly: file_readonly,
            secretLevel: function () {  
              return $("#secretLevel").val();
            },
            callback: function (tableData, type) {
              /* callback 表格数据每次变更时的回调，返回表格数据与操作类型
               * type 触发变更的类型 目前只有 delete | upload
               */
              var files = $.map(tableData, function (item) {
                return item.id
              });
              $("#files").val(files.join(','));
              if(item.type == 'view'){
                $('input').attr('disabled',true);
                $('select').attr('disabled',true);
                $('#input-box').removeClass('hide-box');
                $('#select-box').addClass('hide-box');
                $('.box-hide').addClass('hide-box')
              }else{
                $('#input-box').addClass('hide-box');
                $('#select-box').removeClass('hide-box');
              }
            }
          });
        }
      }
    });
  };
  

  laydate.render({
    elem: '#estimate', //指定元素
    trigger: 'click'

  });
  
  getItemInitData(variable);

  form.on('submit(newSubmit)', function (data) {
    delete(data.field['file']);
    httpModule({
      url: '/treatise-api/save',
      data: data.field,
      type: "POST",
      success: function (e) {
        setDialogData(e); // 通知上层页面状态 - 弹窗中使用
        top.layer.closeAll(); // 关闭弹窗
      }
    });
    return false;
  });
});
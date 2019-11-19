 


layui.use(['form', 'table', 'layer', 'laydate'], function(){
    var form = layui.form;
    var $ = layui.$;
    var table = layui.table;
    var laydate = layui.laydate;
  
    var $ = layui.jquery;
    var form = layui.form;
  

  function getItemInitData(item) {
    var httpUrl = '/patentController/newInit';
    if (item && item.id) {
      httpUrl = '/patentController/load/' + item.id;
    }
    httpModule({
      url: httpUrl,
      type: 'GET',
      success: function(relData) {
        if (relData.code === '0') {
          // 给form表单赋初始值
          form.val('formMain', relData.data);
          // 更新表单数据
          form.render();

          
            transInputDic($("#applicationType"), 'ROOT_KJPT_ZLFW');
            transInputDic($("#patentType"), 'ROOT_KJPT_ZLZL');

          setRadioShow();
        }
      }
    });
  }
  
	// 获取地址栏传递过来的参数
  var variable = getQueryVariable();
  getItemInitData(variable);

	form.on('submit(newSubmit)', function(data) {
		httpModule({
			url: '/patentController/save',
			data: data.field,
			type: "POST",
			success: function(e) {
				setDialogData(e); // 通知上层页面状态 - 弹窗中使用
				top.layer.closeAll(); // 关闭弹窗
			}
		});
		return false;
    })
    
    //表格渲染
    table.render({
        elem: '#tableFile',
        cols: [[ //表头 
          {field: 'fileName', title: '文件名'},
          {field: 'size', title: '大小' },
          {field: 'id', title: '操作', templet: '#fileOprTpl'}
        ]],
        data: [{id:1, fileName:'test', size: '111'}]
      });

      

    function relistFile(fileList) { 
        table.reload( 'tableFile', { 
             data:[ {id:1, fileName:'test', size: '222'},  {id:1, fileName:'test', size: '222'}]
          });
    }


       
    function deleteFile(id) {
        alert('delete' + id);
    }

    function download(id) {
        alert('download' + id);
    }

    $("#radio1").on("click", function(e) { 
        setRadioShow();
    });

    function setRadioShow() {
        
        $("div[showWhere]").css('display','none');  

        var val = '';
        var rs = $("#radio1").find("input[type='radio']"); 
        $.each(rs, function(i, item){ 
            var el = $(item);
            if (el.prop('checked')) {
                val = el.val();
            }
        });
 
        $("div[showWhere='" + val + "']").css('display',''); 
    }

    // 查看
    $('#selectFile').on('click', function(e) { 
    });

    // 查看
    $('#uploadFile').on('click', function(e) {
        //alert("uploadFile");
    });
        
    laydate.render({
      elem: '#date' //指定元素
      ,trigger: 'click'
    });
  
    laydate.render({
      elem: '#applicationDate' //指定元素
      ,trigger: 'click'
    });

    laydate.render({
        elem: '#entryDate' //指定元素
        ,trigger: 'click'
      });
  
    

  });
  
  

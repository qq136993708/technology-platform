//Demo
layui.use(['form', 'table', 'layer'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;

  //监听提交
  form.on('submit(formDemo)', function(data){
    console.log(data);
    // layer.msg(JSON.stringify(data.field));
    return false;
  });

  //表格渲染
  var itemRowData = null; // 选中行的数据
  table.render({
    elem: '#tableDemo'
    ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '平台名称', templet: '#detailsTpl'}
      ,{field: 'id', title: '依托单位', sort: true }
      ,{field: 'sex', title: '主要负责人', sort: true}
      ,{field: 'city', title: '平台类型'} 
      ,{field: 'sign', title: '研究领域'}
      ,{field: 'experience', title: '主要项目', sort: true}
      ,{field: 'score', title: '科研整体情况', sort: true}
      ,{field: 'classify', title: '科研经费'}
      ,{field: 'wealth', title: '平台评分', sort: true}
    ]],
    parseData: function(res) {
      return {
        "code": '0', //解析接口状态
        "msg": 'res.message', //解析提示文本
        "count": res.tableList.length, //解析数据长度
        "data": res.tableList //解析数据列表
      };
    },
    done: function() {
    	itemRowData = null;
    }
  });
  
  
  function openDataDilog(type) {
	  var dialogTitle = '添加平台';
	  if (type === 'edit') {
		  dialogTitle = '编辑平台'; 
	  }
	  
	  // 打开弹窗
	  top.layer.open({
	      type: 2,
	      title: dialogTitle,
	      area: ['880px', '70%'],
		  content: '/html/scientificPlatform/addPlatformDialog.html?id='+type,
		  btn: null,
		  end: function() {
			  var relData = top.dialogData('dialog-data');
			  if (relData.code !== 'colse') {
				  if (relData.code === '0') {
					  layer.msg(relData.message);
				  } else {
					  layer.msg(relData.message);
				  }
			  }
		  }
	});
  }
  
  // 新增平台
  $('#addItem').on('click', function(e) {
	  openDataDilog('add');
  })
  
  // 表格行被选中
  table.on('radio(tableDemo)', function(obj){
	itemRowData = obj.data;
    console.log(obj)
  });
  // 编辑平台
  $('#editItem').on('click', function(e) {
	if (itemRowData) {
		openDataDilog('edit');
    } else {
    	layer.msg('请选择需要编辑的平台！');
    }
  })
  // 删除平台
  $('#delItem').on('click', function(e) {
    if (itemRowData) {
		layer.confirm('您确定要删除”'+itemRowData.username+'“吗？', {icon: 3, title:'删除提示'}, function(index){
		  layer.close(index);
		  // 确认删除
		});
    } else {
    	layer.msg('请选择需要删除的平台！');
    }
  })

  // https://www.layui.com/demo/table/user/?page=2&limit=10
});
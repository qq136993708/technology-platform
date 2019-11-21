//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;

  laydate.render({elem: '#startReleaseDate'});
  laydate.render({elem: '#endReleaseDate'});

  //表格渲染
  var tableRender = false;
  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/platform-api/query' //数据接口
        ,cols: [[ //表头
          {type: 'radio', field: 'id'}
          ,{field: 'platformName', title: '科研规划名称', templet: '#detailsTpl'}
          ,{field: 'supportingInstitutions', title: '申报单位', sort: true }
          ,{field: 'researchField', title: '研究领域'}
          ,{field: 'personLiable', title: '专业领域', sort: true}
          ,{field: 'type', title: '专业类别'} 
          ,{field: 'createDate', title: '发布日期', sort: true}
          ,{field: 'overallSituation', title: '发布者', sort: true}
        ]],
        parseData: function(res) {return layuiParseData(res);},
        request: {
          page: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limit: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        where: searchData
      });
    } else {
      table.reload('tableDemo', {where: searchData});
    }
  }

  form.on('submit(formDemo)', function(data) {
    queryTable(data.field);
    return false;
  });

  $('[lay-filter="formDemo"]').click();


  function openDataDilog(type, id) {
	  var dialogTitle = '添加';
	  if (type === 'edit') {
		  dialogTitle = '编辑'; 
	  }
	  
	  // 打开弹窗
	  top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
		  content: '/html/scientificMaterials/addPlan.html?type='+type+'&id='+(id || ''),
		  btn: null,
		  end: function() {
        var relData = getDialogData('dialog-data');
			  if (relData) {
				  if (relData.code === '0') {
            layer.msg(dialogTitle+'成功!', {icon: 1});
            $('[lay-filter="formDemo"]').click();
				  } else {
					  layer.msg(relData.message, {icon: 2});
				  }
			  }
		  }
	  });
  }
  
  // 新增规划
  $('#addItem').on('click', function(e) {
	  openDataDilog('add');
  })
  // 查看规划
  $('#seeItem').on('click', function(e) {
	   // 获取表格中选中的数据
     var itemRowData = table.checkStatus('tableDemo').data;
     if (itemRowData.length) {
     openDataDilog('see', itemRowData.id);
     } else {
       layer.msg('请选择科研规划！');
     }
  })
  // 编辑规划
  $('#editItem').on('click', function(e) {
    // 获取表格中选中的数据
    var itemRowData = table.checkStatus('tableDemo').data;
	  if (itemRowData.length) {
		openDataDilog('edit', itemRowData.id);
    } else {
    	layer.msg('请选择科研规划！');
    }
  })
  // 删除规划
  $('#delItem').on('click', function(e) {
    // 获取表格中选中的数据
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length) {
		  layer.confirm('您确定要删除”'+itemRowData.platformName+'“吗？', {icon: 3, title:'删除提示'}, function(index){
		    layer.close(index);
        // 确认删除
        httpModule({
          url: '/platform-api/delete/' + itemRowData.id,
          type: 'DELETE',
          success: function(relData) {
            if (relData.code === '0') {
              layer.msg('删除成功!', {icon: 1});
              $('[lay-filter="formDemo"]').click();
            } else {
              layer.msg('删除失败', {icon: 2});
            }
          }
        });
      });
    } else {
    	layer.msg('请选择需要删除的科研规划！');
    }
  })

  // https://www.layui.com/demo/table/user/?page=2&limit=10
});
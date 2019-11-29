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
        ,url: '/ScienceEvolveDynamic/query' //数据接口
        ,cols: [[ //表头
          {type: 'radio', field: 'id'}
          ,{field: 'name', title: '总结名称', templet: function(d) {
            return '<a href="progressDetails.html?id='+d.id+'" class="layui-table-link">'+d.name+'</a>';
          }}
          ,{field: 'authenticateUtil', title: '申报单位', sort: true }
          ,{field: 'researchField', title: '研究领域'}
          ,{field: 'annual', title: '年度/月度', sort: true, templet: function(d) {
            if (d.annual && (''+ d.annual).indexOf('-') === -1) {
              return new Date().format('yyyy/MM');
            }
          }}
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
		  content: '/html/scientificMaterials/addSummary.html?type='+type+'&id='+(id || ''),
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
     openDataDilog('see', itemRowData[0].id);
     } else {
       layer.msg('请选择年度总结！');
     }
  })
  // 编辑规划
  $('#editItem').on('click', function(e) {
    // 获取表格中选中的数据
    var itemRowData = table.checkStatus('tableDemo').data;
	  if (itemRowData.length) {
		openDataDilog('edit', itemRowData[0].id);
    } else {
    	layer.msg('请选择年度总结！');
    }
  })
  // 删除规划
  $('#delItem').on('click', function(e) {
    // 获取表格中选中的数据
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length) {
		  top.layer.confirm('您确定要删除”'+itemRowData[0].name+'“吗？', {icon: 3, title:'删除提示'}, function(index){
		    top.layer.close(index);
        // 确认删除
        httpModule({
          url: '/ScienceEvolveDynamic/delete/' + itemRowData[0].id,
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
    	layer.msg('请选择需要删除的年度总结！');
    }
  })

  // https://www.layui.com/demo/table/user/?page=2&limit=10
});
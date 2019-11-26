//Demo
layui.use(['form', 'table', 'layer'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;

  var variable = getQueryVariable();
  if (variable && variable.level) {
    form.val('patentFormDemo', {level: variable.level});
    $('[form-label-item="level"]').remove();
  } else {
    $('#opations-btn, [form-label-item="unlevel"]').remove();
  }


  //表格渲染
  var itemRowData = null; // 选中行的数据
  var tableRender = false;
  function queryTable(searchData) {

    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/platform-api/query' //数据接口
        ,cols: [[ //表头
          {type: 'radio', field: 'id'}
          ,{field: 'platformName', title: '平台名称', templet: '#detailsTpl'}
          ,{field: 'supportingInstitutionsText', title: '依托单位', sort: true }
          ,{field: 'personLiable', title: '主要负责人', sort: true}
          ,{field: 'typeText', title: '平台类型'} 
          ,{field: 'researchFieldText', title: '研究领域'}
          ,{field: 'experience', title: '主要项目', sort: true}
          ,{field: 'overallSituation', title: '科研整体情况', sort: true}
          ,{field: 'researchFunds', title: '科研经费'}
          ,{field: 'platformScoring', title: '平台评分', width: 94 , sort: true}
        ]],
        parseData: function(res) {return layuiParseData(res);},
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        done: function() {
          itemRowData = null;
        },
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


  function openDataDilog(value, ID) {
	  var dialogTitle = '添加平台';
	  if (ID === 'edit') {
		  dialogTitle = '编辑平台'; 
	  }
	  
	  // 打开弹窗
	  top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
		  content: '/html/scientificPlatform/addPlatformDialog.html?level='+value+'&id='+ID,
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
  
  // 新增平台
  $('#addItem').on('click', function(e) {
	  openDataDilog(variable.level);
  })
  
  // 表格行被选中
  table.on('radio(tableDemo)', function(obj){
	  itemRowData = obj.data;
  });
  // 编辑平台
  $('#editItem').on('click', function(e) {
	if (itemRowData) {
		openDataDilog(variable.level, itemRowData.id);
    } else {
    	layer.msg('请选择需要编辑的平台！');
    }
  })
  // 删除平台
  $('#delItem').on('click', function(e) {
    if (itemRowData) {
		top.layer.confirm('您确定要删除”'+itemRowData.platformName+'“吗？', {icon: 3, title:'删除提示'}, function(index){
		  top.layer.close(index);
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
    	layer.msg('请选择需要删除的平台！');
    }
  })

  // https://www.layui.com/demo/table/user/?page=2&limit=10
});
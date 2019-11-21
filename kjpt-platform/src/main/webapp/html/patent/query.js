//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;

  //表格渲染
  var itemRowData = null; // 选中行的数据
  var tableRender = false;
  function queryTable(searchData) {

    console.log('query', searchData);

    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/patentController/query' //数据接口
        ,cols: [[ //表头
          {type: 'radio', field: 'id'}
          ,{field: 'applicationNumber', title: '申请(专利)号'}
          ,{field: 'unitName', title: '单位名称', sort: true }
          ,{field: 'applicationType', title: '申请类型', sort: true, templet: '#applicationTypeText'}
          ,{field: 'patentType', title: '专利类型', templet: '#patentTypeText' } 
          ,{field: 'applicant', title: '申请人'}
          ,{field: 'inventor', title: '发明人', sort: true, templet: '#showUserTpl'}
          ,{field: 'applicationDate', title: '申请日期', sort: true, templet: '#applicationDate'}
          ,{field: 'researchFunds', title: '国别组织'}
          ,{field: 'agency', title: '代理机构', sort: true}
          ,{field: 'legalStatus', title: '法律状态', sort: true}
        ]],
        parseData: function(res) {return layuiParseData(res);},
        request: {
          page: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limit: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
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

    //TODO date error
    var query = data.field;
    delete query.applicationDateStart;
    delete query.applicationDateEnd;

    queryTable(query);
    return false;
  });

  $('[lay-filter="formDemo"]').click();


  function openDataDilog(type, id) {

    var url = '/html/patent/edit.html?type=' + type;
    var dialogTitle = '新增专利信息'; 
	  if (type === 'edit') {
      dialogTitle = '编辑专利信息';  
      url += '&id=' + id;
	  } else if (type === 'view') {
      dialogTitle = '专利信息查看'; 
      url = '/html/patent/view.html?id=' + id;
    } 

	  // 打开弹窗
	  top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
		  content: url,
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
  
  // 新增
  $('#addItem').on('click', function(e) {
	  openDataDilog('add');
  })
  
  // 表格行被选中
  table.on('radio(tableDemo)', function(obj){
	  itemRowData = obj.data;
    console.log(obj)
  });
  // 编辑
  $('#editItem').on('click', function(e) {
	if (itemRowData) {
		openDataDilog('edit', itemRowData.id);
    } else {
    	layer.msg('请选择需要编辑的专利项目！');
    }
  });

  // 查看
  $('#viewItem').on('click', function(e) {
    if (itemRowData) {
      openDataDilog('view', itemRowData.id);
      } else {
        layer.msg('请选择需要查看的专利项目！');
      }
  });

  // 删除
  $('#delItem').on('click', function(e) {
    if (itemRowData) {
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
    	layer.msg('请选择需要删除的专利项目！');
    }
  });

  laydate.render({
    elem: '#applicationDateStart' //指定元素
  });

  laydate.render({
    elem: '#applicationDateEnd' //指定元素
  });



  // bindSelectorDic($("#applicationType"), 'ROOT_KJPT_ZLFW', form);
  // bindSelectorDic($("#patentType"), 'ROOT_KJPT_ZLZL', form);
});

function shouUser(userId) {
  alert(userId);
}

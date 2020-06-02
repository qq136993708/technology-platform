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
 

    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/ComputerSoftware/query' //数据接口
        ,cols: [[ //表头
          {type: 'radio', field: 'id'}
          ,{field: 'unitNameText', title: '单位名称', sort: true }
          ,{field: 'softwareName', title: '软件名称', sort: true }
          ,{field: 'registerNumber', title: '登记号', sort: true}
          ,{field: 'recordDate', title: '登记日期', sort: true, templet: function(d) {
                return dateFieldText(d.recordDate);
             }}
          ,{field: 'copyrightOwner', title: '著作权人', sort: true}
          ,{field: 'copyrightGetwayText', title: '权利取得方式', sort: true}
          ,{field: 'registerDepartment', title: '登记部门', sort: true}
          ,{field: 'softwareIntro', title: '项目背景', sort: true}

         /* ,{field: 'technicalFieldValue', title: '技术领域', sort: true }

          ,{field: 'versionNumber', title: '版本号', sort: true}

          ,{field: 'secretLevelText', title: '密级', sort: true, hide: _hideSecrecylevel()} */
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

    //TODO date error
    var query = data.field; 

    queryTable(query);
    return false;
  });

  $('[lay-filter="formDemo"]').click();


  function openDataDilog(type, id) {

    var url = '/html/computersoftware/edit.html?type=' + type;
    var dialogTitle = '新增著作权信息'; 
	  if (type === 'edit') {
      dialogTitle = '编辑著作权信息';  
      url += '&id=' + id;
	  } else if (type === 'view') {
      dialogTitle = '著作权信息查看'; 
      url = '/html/computersoftware/view.html?id='+ id +'&type=' + type;
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
  });
  // 编辑
  $('#editItem').on('click', function(e) {
	if (itemRowData) {
		openDataDilog('edit', itemRowData.id);
    } else {
    	layer.msg('请选择需要编辑的著作权项目！');
    }
  });

  // 查看
  $('#viewItem').on('click', function(e) {
    if (itemRowData) {
      openDataDilog('view', itemRowData.id);
      } else {
        layer.msg('请选择需要查看的著作权项目！');
      }
  });

  // 删除
  $('#delItem').on('click', function(e) {
    if (itemRowData) {
		layer.confirm('您确定要删除”'+itemRowData.softwareName+'“吗？', {icon: 3, title:'删除提示'}, function(index){
		  layer.close(index);
      // 确认删除
      httpModule({
        url: '/ComputerSoftware/delete/' + itemRowData.id,
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
    	layer.msg('请选择需要删除的著作权项目！');
    }
  });

    // 导出
    $('#exportData').click(function() {
        debugger;
        var formValue = form.val('patentFormDemo'),
            searchData = {
                unitName: formValue.unitName || '', // 单位名称：
                patentName: formValue.registerNumber || '', // 登记号：
                patentType: formValue.softwareName || '', // 软件名称：
                lawStatus: formValue.copyrightOwner || '', // 著作权人
                applicationNumber: formValue.versionNumber || '', // 版本号：
            },
            exportUrl = '';

        for (var key in searchData) {
            exportUrl += '&' + key + '=' + searchData[key];
        }
        exportUrl = '/ComputerSoftware/exportExcel?' + exportUrl.substring(1);
        window.open(exportUrl, '_blank');
    })

  loadPatent();
  function loadPatent(){
    httpModule({
      url: '/ComputerSoftware/countByCopyrightGetway',
      type: 'GET',
      success: function (relData) {
        if (relData.success) {
          $.each(relData.data,function(index,item){
            if(item.name == '全部'){
              $('#patentsTotal').text(item.num)
            }else if(item.name == '原始获得'){
              $('#patentNumber').text(item.num)
            }else if(item.name == '维受取得'){
              $('#patentAuthorizations').text(item.num)
            }
          })
        }
      }
    });
  };

  laydate.render({
    elem: '#recordDateStart' //指定元素
  });

  laydate.render({
    elem: '#recordDateEnd' //指定元素
  });

  laydate.render({ //渲染时间表单
    elem: '#recordDate',
    trigger: 'click',
  });

 
});

function shouUser(userId) {
  alert(userId);
}

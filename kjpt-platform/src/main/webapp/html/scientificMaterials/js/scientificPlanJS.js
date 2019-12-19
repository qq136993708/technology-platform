//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;

  // var newTime = new Date(); //发布时间初始值
  // var timeString = newTime.getFullYear() + '-'+ (newTime.getMonth()+1) + '-' + newTime.getDate();
  laydate.render({elem: '#releaseTime',trigger:'click'});
  laydate.render({elem: '#yearOrMonth',trigger:'click',type:'month'});
  var tipTitle = '';
  var params = getQueryVariable();
  var reportType = +params.reportType;

  function setSelectInput(){ //js动态设置条件过滤布局
    var len;
    if(reportType == 1){
      len = ($("#selectRows").children(".layui-col-md4").length - 1) % 3;
    }else{
      len = ($("#selectRows").children(".layui-col-md4").length - 3) % 3;
    }
    switch(len){
      case 0:
        $('#btnGroup').removeClass('layui-col-md4');
        $('#btnGroup').addClass('layui-col-md12');
      break;
      case 1:
        $('#btnGroup').removeClass('layui-col-md4');
        $('#btnGroup').addClass('layui-col-md8');
      break;
    }
}
setSelectInput();

  switch(reportType){
    case 1:
        $('#configName').html("科技规划名称:");
        tipTitle = "科技规划";
    break;
    case 2:
        $('#configName').html("工作要点名称:");
        tipTitle = "工作要点";
    break;
    case 3:
        $('#configName').html("科技进展名称:");
        tipTitle = "科技进展";
    break;
    case 4:
        $('#configName').html("年度总结名称:");
        tipTitle = "年度总结";
    break;
    case 5:
        $('#configName').html("研究报告名称:");
        tipTitle = "研究报告";
    break;
  }
  var cols  = [ //表头
    {type: 'radio', field: 'id'},
    {field: 'name', title: tipTitle + '名称', templet: function(d) {
      return '<a href="planDetails.html?id='+d.id+'" class="layui-table-link">'+d.name+'</a>';
    }}, // authenticateUitlText
    {field: 'nameText', title: '申报单位', sort: true },
    {field: 'technicalFieldName', title: '研究领域'},
    {field: 'releaseTime', title: '发布时间',templet: function(d){
      var times = new Date(d.releaseTime);
       return times.getFullYear() + '-' + (times.getMonth()+1) + '-' +times.getDate();
    }},
    {field: 'annual', title: '年度/月度',templet: function(d){
       var times = new Date(d.annual);
       return times.getFullYear() + '-' + (times.getMonth()+1);
    }}
    
  ]

  var additional = [
    {field: 'professionalField', title: '专业领域', sort: true},
    {field: 'specialtyCategory', title: '专业类别'}
  ]

  if(reportType !== 1){ //专业领域和专业类别是否隐藏
    $('#professionalField').css("display","none");
    $('#professionalType').css("display","none");
  }else{
    cols = cols.concat(additional);
  }

  cols = cols.concat(
    [{field: 'secretLevelText', title: '密级', sort: true} ]
  );


  //表格渲染
  var tableRender = false;
  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo'
        ,url: '/SciencePlan/query?reportType='+ reportType //数据接口
        ,cols: [
          cols
        ],
        parseData: function(res) {return layuiParseData(res);},
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
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
	  var dialogTitle = '新增';
	  if (type === 'edit') {
		  dialogTitle = '编辑'; 
    }
    if(type === 'see'){
      dialogTitle = '查看'; 
    }
	  
	  // 打开弹窗
	  top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
		  content: '/html/scientificMaterials/addPlan.html?type=' + type +'&reportType=' + reportType + '&id='+(id || ''),
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
       layer.msg('请选择需要查看的'+tipTitle+'！');
     }
  })
  // 编辑规划
  $('#editItem').on('click', function(e) {
    // 获取表格中选中的数据
    var itemRowData = table.checkStatus('tableDemo').data;
	  if (itemRowData.length) {
		openDataDilog('edit', itemRowData[0].id);
    } else {
    	layer.msg('请选择需要编辑的'+tipTitle+'！');
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
          url: '/SciencePlan/delete/' + itemRowData[0].id,
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
    	layer.msg('请选择需要删除的'+tipTitle+'！');
    }
  })

  // https://www.layui.com/demo/table/user/?page=2&limit=10
});
layui.use(['form', 'jquery', 'table', 'layer'], function(){
	var $ = layui.jquery;
	var form = layui.form;
	var table = layui.table;
	var layer = layui.layer;
	
	// 获取地址栏传递过来的参数
  var variable = getQueryVariable();
	var submitType = '';
	function switchItem(type) {
		submitType = type;
		if (type === 'unInput') {
			$('.unInput-layout-box').show();
			$('.input-layout-box').hide();
		} else if (type === 'input') {
			$('.unInput-layout-box').hide();
			$('.input-layout-box').show();
		}	
	}
	// 默认显示关联录入
	switchItem('unInput');
	// 监听录入方式变化
	form.on('radio(optionType)', function(data) {
		switchItem(data.value);
	})
	
	// 重置搜索框的值
	$('#restProjectNameValue').click(function() {
		$('#projectName').val('');
	})
	
	function getTableData() {
		var searchData = $('#projectName').val();
		searchData = searchData ? searchData.trim() : '';

		table.render({
		  elem: '#unInputTable' // 表格元素ID
		  ,url: '/data/datalist.json' //数据接口
		  ,page: true //开启分页
		  ,where: { name: searchData }
		  ,cols: [[ // 表头
		    {type: 'checkbox' } // 表格多选
		    ,{field: 'username', title: '项目名称' } // 模版配置列
		    ,{field: 'sex', title: '专业类别', sort: true}
		    ,{field: 'city', title: '负责单位'} 
		    ,{field: 'sign', title: '立项年度'}
		  ]]
		  ,parseData: function(res) { return layuiParseData(res, null, 5); }
		});
	}

	getTableData();
	
	$('#getProjectData').click(function() {
		getTableData();
	})
	
	form.on('submit(InputSubmit)', function(data) {
		// 手工录入提交
    console.log(data.field);
    setDialogData([data.field]);
    top.layer.closeAll();
		return false;
	})
	
	// 提交项目
	$('#projectSubmit').on('click', function(e) {
		if (submitType === 'input') {
			$('#InputSubmit').trigger('click');
		} else if (submitType === 'unInput') {
      var tableCheckedData = table.checkStatus('unInputTable').data;
			if (!tableCheckedData.length) {
				layer.msg('您没有选择任何项目', {icon: 2});
				return false;
			}
			setDialogData(tableCheckedData);
      top.layer.closeAll();
		}
	})
});
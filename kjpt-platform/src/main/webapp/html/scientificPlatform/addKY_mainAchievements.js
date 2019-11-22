layui.use(['form', 'jquery', 'table', 'layer', 'laydate'], function(){
	var $ = layui.jquery;
	var form = layui.form;
	var table = layui.table;
	var layer = layui.layer;
	var laydate = layui.laydate;
	
	// 获取地址栏传递过来的参数
	function getItemData(data) {
		var httpUrl = '/researchPlatformMember-api/newInit/' + data.platformId;
		if (data.id) {
			httpUrl = '/researchPlatformMember-api/load/' + data.id
		}

		httpModule({
			url: httpUrl,
			success: function(res) {
				if (res.code === '0') {
					var formData = res.data;
					if (!formData.platformId) {
						formData.platformId = data.platformId;
					}
					formData.createDate = new Date(formData.createDate).format('yyyy-MM-dd');
					form.val('formProject', formData);
				}
			}
		});
	}

	var submitType = 'input';
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

	laydate.render({ elem: '#applicantYear', type: 'year', btns: ['clear', 'confirm']});
	
	var variable = getQueryVariable();
	if (variable.type === 'edit') {
		submitType = 'input';
	}

	console.log(variable)

	getItemData(variable);

	// 监听录入方式变化
	form.on('radio(optionType)', function(data) {
		switchItem(data.value);
	})
	switchItem(submitType);
	form.val('formRadio', {optionType: submitType});
	
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
		    ,{field: 'username', title: '成果名称' } // 模版配置列
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
		httpModule({
			type: 'POST',
			url: '/researchPlatformMember-api/save',
			data: data.field,
			success: function(res) {
				if (res.code === '0') {
					setDialogData(res);
					top.layer.closeAll();
				} else {
					var msgTitle = '编辑';
					if (variable.type === 'add') {
						msgTitle = '添加';
					}
					layer.msg(msgTitle + '失败!', {icon: 2});
				}
			}
		});
		return false;
	})
	
	// 提交成果
	$('#projectSubmit').on('click', function(e) {
		if (submitType === 'input') {
			$('#InputSubmit').trigger('click');
		} else if (submitType === 'unInput') {
      var tableCheckedData = table.checkStatus('unInputTable').data;
			if (!tableCheckedData.length) {
				layer.msg('您没有选择任何成果', {icon: 2});
				return false;
			}
			// 批量导入
			httpModule({
				type: 'POST',
				url: '/researchPlatformMember-api/batchSave',
				data: tableCheckedData,
				success: function(res) {
					if (res.code === '0') {
						setDialogData(res);
						top.layer.closeAll();
					} else {
						var msgTitle = '编辑';
						if (variable.type === 'add') {
							msgTitle = '添加';
						}
						layer.msg(msgTitle + '失败!', {icon: 2});
					}
				}
			});
		}
	})
});
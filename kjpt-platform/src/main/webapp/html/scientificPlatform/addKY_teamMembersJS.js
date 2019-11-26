layui.use(['form', 'jquery', 'table', 'layer', 'laydate'], function(){
	var $ = layui.jquery;
	var form = layui.form;
	var table = layui.table;
	var layer = layui.layer;
	var laydate = layui.laydate;
	var variable = getQueryVariable();
	console.log(variable)

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
					if (!formData) { return false; }
					if (!formData.platformId) {
						formData.platformId = data.platformId;
					}
					formData.createDate = new Date(formData.createDate).format('yyyy-MM-dd');
					if (variable) {
						if (variable.item === 'member') {
							// 添加成员
							formData.role = '0';
						} else if ( variable.item === 'character' ) {
							// 添加领军人物
							formData.role = '1';
						}
					}
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

	// 切换领军人物 与成员字段
	function switchHideItem(type) {
		$('[item-label]').each(function() {
			if ($(this).attr('item-label').indexOf(type) === -1) {
				$(this).remove();
			}
		})
	}

	if (variable.type === 'edit') {
		submitType = 'input';
	}
	switchHideItem(variable.item);
	getItemData(variable);

	if ($('#birth').length) {
		laydate.render({ elem: '#birth', type: 'month', btns: ['clear', 'confirm']});
	}

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
		  ,url: '/expert-api/list' //数据接口
			,page: true //开启分页
			,method: 'POST'
			,limit: 5
		  ,where: { name: searchData }
		  ,cols: [[ // 表头
		    {type: 'checkbox' } // 表格多选
		    ,{field: 'name', title: '姓名' } // 模版配置列
		    ,{field: 'birth', title: '出生年月', hide: (variable.item === 'member' ? false : true) }
		    ,{field: 'educationText', title: '学历', hide: (variable.item === 'member' ? false : true)} 
				,{field: 'assumeOffice', title: '担任职务'}
				,{field: 'workUnitText', title: '工作单位', hide: (variable.item === 'member' ? true : false)}
				,{field: 'graduateSchool', title: '学校名称', hide: (variable.item === 'member' ? false : true)}
				,{field: 'majorStudied', title: '所学专业'}
				,{field: 'technicalTitle', title: '技术职称', hide: (variable.item === 'member' ? true : false)}
				,{field: 'postName', title: '岗位名称', hide: (variable.item === 'member' ? false : true)}
		  ]]
		  ,parseData: function(res) {
				var relData = {
					code: res.code,
					count: res.count,
					msg: res.msg,
					data: []
				};
				relData.data = $.map(res.data, function(item, i) {
					return {
						"assumeOffice": '-',
						"baseId": item.id,
						"birth": item.age,
						"createDate": (item.createDate ? new Date(item.createDate).format('yyyy-MM-dd'): ''),
						"creator": item.creator,
						"deleted": item.deleted,
						"education": item.education,
						"educationText": item.educationStr,
						"graduateSchool": '-',
						"id": item.id,
						"majorStudied": '-',
						"name": item.name,
						"platformId": variable.platformId,
						"postName": item.titleStr,
						"role": (variable.item === 'member' ? '0' : '1'),
						"roleText": '',
						"technicalTitle": item.post,
						"updateDate": (item.updateTime ? new Date(item.updateTime).format('yyyy-MM-dd'): ''),
						"updator": item.updator,
						"workUnit": item.belongUnit,
						"workUnitText": item.belongUnitStr
					}
				})
				return relData;
			}
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
			// 批量导入
			httpModule({
				type: 'POST',
				url: '/platformTreatise-api/batchSave',
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
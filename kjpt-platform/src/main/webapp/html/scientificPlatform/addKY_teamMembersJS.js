layui.use(['form', 'formSelects', 'table', 'layer', 'laydate'], function(){
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
							if (formData.workUnit) {
								layui.formSelects.value('workUnit', [formData.workUnit]);
							}
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
		  ,url: (function() {
				if (variable.item === 'member') {
					// 添加成员查询关联列表
					return '/expert-api/list';
				} else {
					// 添加领军人物查询关联列表
					return '/researchPlatformMember-api/query';
				}
			})()  //数据接口
			,page: true //开启分页
			,method: (function() {
				if (variable.item === 'member') {
					// 添加成员查询关联列表
					return 'POST';
				} else {
					// 添加领军人物查询关联列表
					return 'GET';
				}
			})()
			,limit: 5
		  ,where: (function() {
				if (variable.item === 'member') {
					// 添加成员查询关联列表
					return { name: searchData };
				} else {
					// 添加领军人物查询关联列表
					return {
						name: searchData,
						platformId: variable.platformId,
						role: '0'
					};
				}
			})()  
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
				// ,{field: 'postName', title: '岗位名称', hide: (variable.item === 'member' ? false : true)}
			]]
			,request: (function() {
				if (variable.item != 'member') {
					return {
						pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
						limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
					}
				} else {
					return null;
				}
			})()
		  ,parseData: function(res) {
				if (variable.item != 'member') {
					return layuiParseData(res)
				} else {
					var relData = {
						code: res.code,
						count: res.count,
						msg: res.msg,
						data: []
					};
					relData.data = $.map(res.data, function(item, i) {
						return {
							"assumeOffice": item.post,
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
							"technicalTitle": '-',
							"updateDate": (item.updateTime ? new Date(item.updateTime).format('yyyy-MM-dd'): ''),
							"updator": item.updator,
							"workUnit": item.belongUnit,
							"workUnitText": item.belongUnitStr
						}
					})
					return relData;
				}
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
			var tableCheckedData = table.checkStatus('unInputTable').data,
			saveData = false;
			if (!tableCheckedData.length) {
				layer.msg('您没有选择任何项目', {icon: 2});
			} else if (variable.item === 'member') {
				// 校验添加的成员是否已经添加过
				httpModule({
					url: '/researchPlatformMember-api/query',
					async: false, // 同步请求
					data: {
						pageNum: 1, pageSize: 10, platformId: variable.platformId,
						baseIds: (function() {
							var baseIdValue = '';
							$.each(tableCheckedData, function(i, item) {
								baseIdValue += ',' + item.baseId;
							})
							baseIdValue = baseIdValue.substring(1);
							return baseIdValue;
						})()
					},
					success: function(res) {
						if (res.code == '0') {
							if (!res.data.list.length) {
								saveData = true;
							} else {
								var memberName = '';
								$.each(res.data.list, function(i, item) {
									memberName += '、“'+ item.name +'”'
								})
								$('#tips-dialog-content').html('<span class="text">新加成员'+ (memberName.substring(1)) +'已在团队中，请重新选择！</span>');
								layer.open({
									type: 1,
									title: '添加重复',
									area: ['380px', '200px'],
									content: $('#tips-dialog-content'),
									btn: ['确认'],
									yes: function(index) {
										layer.close(index);
									}
								});
							}
						}
					}
				});
			} else {
				saveData = true;
			}

			if (!saveData) {
				return false;
			}

			// 批量导入
			httpModule({
				type: 'POST',
				url: (function() {
					if (variable.item === 'member') {
						return '/researchPlatformMember-api/batchSave';
					} else {
						var roleMember = '/researchPlatformMember-api/updateMemberRole?ids=';
						var ids = '';
						$.each(tableCheckedData, function(i, item) {
							ids += (','+item.id);
						})
						roleMember += (ids.substring(1) + '&role=1');
						return roleMember;
					}
				})(),
				data: (function() {
					if (variable.item === 'member') {
						return tableCheckedData;
					}
				})(),
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
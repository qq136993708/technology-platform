layui.use(['form', 'formSelects', 'table', 'layer', 'laydate'], function(){
	var form = layui.form;
	var table = layui.table;
	var layer = layui.layer;
	var laydate = layui.laydate;
	var variable = getQueryVariable();
	console.log(variable)

	// 获取地址栏传递过来的参数
	function getItemData(data) {
		var httpUrl = '';
		if (variable.item === 'character') {
			// 领军人物
			httpUrl = '/researchPlatformLeader-api/newInit/' + data.platformId;
		} else {
			// 团队成员
			httpUrl = '/researchPlatformMember-api/newInit/' + data.platformId;
		}
		if (data.id) {
			if (variable.item === 'character') {
				// 领军人物
				httpUrl = '/researchPlatformLeader-api/load/' + data.id
			} else {
				// 团队成员
				httpUrl = '/researchPlatformMember-api/load/' + data.id
			}
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
					if (variable && variable.item === 'character') {
						// 添加领军人物 工作单位
						if (formData.workUnit) {
							layui.formSelects.value('workUnit', [formData.workUnit]);
						}
					}
					if(formData.birth){
            // 出生日期
            formData.publishDate = new Date(formData.birth).format('yyyy-MM-dd');
          }
					form.val('formProject', formData);

					// 添加知悉范围
          setJurisdictionScope({
            elem: 'scope_list_layout',
            knowledgeScope: formData.knowledgeScope,
            knowledgePerson: formData.knowledgePerson,
            secretLevel: formData.secretLevel,
            disabled: false
          });
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
		laydate.render({ elem: '#birth', btns: ['clear', 'confirm']});
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
		  ,url: '/expert-api/list'  //数据接口
			,page: true //开启分页
			,method: 'POST'
			,limit: 5
			,limits: [5, 10] // 配置分页数据条数
		  ,where: { name: searchData }
		  ,cols: [(function() {
				if (variable.item === 'member') {
					return [ // 表头
						{type: 'checkbox' } // 表格多选
						,{field: 'name', title: '姓名' } // 模版配置列
						,{field: 'birth', title: '出生年月' }
						,{field: 'educationText', title: '学历' } 
						,{field: 'assumeOffice', title: '担任职务'} 
						,{field: 'graduateSchool', title: '学校名称' }
						,{field: 'majorStudied', title: '所学专业'}
					]
				} else {
					return [ // 表头
						{type: 'checkbox' } // 表格多选
						,{field: 'name', title: '姓名' } // 模版配置列
						,{field: 'post', title: '担任职务'}
						,{field: 'workUnitText', title: '工作单位' }
						,{field: 'major', title: '专业'}
					]
				}
			})()]
		  ,parseData: function(res) {
				var relData = {
					code: res.code,
					count: res.count,
					msg: res.msg,
					data: []
				};
				relData.data = $.map(res.data, function(item, i) {
					if (variable.item === 'member') {
						return {
							"assumeOffice": item.post,
							"baseId": item.id,
							"birth": (item.age ? item.age : ''),
							"createDate": (item.createDate ? new Date(item.createDate).format('yyyy-MM-dd'): ''),
							"creator": (item.creator ? item.creator : ''),
							"deleted": (item.deleted ? item.deleted : '0'),
							"education": (item.education ? item.education : ''),
							"educationText": item.educationStr,
							"graduateSchool": '-',
							"id": item.id,
							"majorStudied": '-',
							"name": item.name,
							"platformId": variable.platformId,
							"postName": item.titleStr,
							"technicalTitle": '-',
							"updateDate": (item.updateTime ? new Date(item.updateTime).format('yyyy-MM-dd'): ''),
							"updator": (item.updator ? item.updator : ''),
							"workUnit": item.belongUnit,
							"workUnitText": item.belongUnitStr,
							"knowledgeScope": item.knowledgeScope,
            	"knowledgePerson": item.knowledgePerson,
							"secretLevel": item.secretLevel
						}
					} else {
						return {
							"post": item.post,
							"baseId": item.id,
							"createDate": (item.createDate ? new Date(item.createDate).format('yyyy-MM-dd'): ''),
							"creator": (item.creator ? item.creator : ''),
							"deleted": (item.deleted ? item.deleted : '0'),
							"id": item.id,
							"major": '-',
							"name": item.name,
							"platformId": variable.platformId,
							"updateDate": (item.updateTime ? new Date(item.updateTime).format('yyyy-MM-dd'): ''),
							"updator": (item.updator ? item.updator : ''),
							"workUnit": item.belongUnit,
							"workUnitText": item.belongUnitStr,
							"knowledgeScope": item.knowledgeScope,
            	"knowledgePerson": item.knowledgePerson,
							"secretLevel": item.secretLevel
						}
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
			url: (function() {
				if (variable.item === 'member') {
					// 团队成员
					return '/researchPlatformMember-api/save';
				} else {
					// 领军人物
					return '/researchPlatformLeader-api/save';
				}
			})(),
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
		var $submitBtn = $(this),
		submitIndex = layer.load(2);
		$submitBtn.prop('disabled', true);

		if (submitType === 'input') {
			$('#InputSubmit').trigger('click');
		} else if (submitType === 'unInput') {
			var tableCheckedData = table.checkStatus('unInputTable').data,
			saveData = false;
			if (!tableCheckedData.length) {
				layer.msg('您没有选择任何人物!');
			} else {
				// 校验添加的成员/领军人物是否已经添加过
				httpModule({
					url: (function() {
						if (variable.item === 'member') {
							// 校验团队成员地址
							return '/researchPlatformMember-api/query';
						} else {
							// 校验领军人物地址
							return '/researchPlatformLeader-api/query';
						}
					})(),
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
								});
								
								if (variable.item === 'member') {
									// 校验团队成员地址
									memberName = '团队成员' + memberName.substring(1);
								} else {
									// 校验领军人物地址
									memberName = '领军人物' + memberName.substring(1);
								}

								$('#tips-dialog-content').html('<span class="text">新加'+ memberName +'已存在，请重新选择！</span>');
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
			}

			if (!saveData) {
				$submitBtn.prop('disabled', false);
				layer.close(submitIndex);
				return false;
			}

			// 批量导入
			httpModule({
				type: 'POST',
				url: (function() {
					if (variable.item === 'member') {
						// 导入团队成员
						return '/researchPlatformMember-api/batchSave';
					} else {
						// 导入领军人物
						return  '/researchPlatformLeader-api/batchSave';
					}
				})(),
				data: tableCheckedData,
				success: function(res) {
					$submitBtn.prop('disabled', false);
					layer.close(submitIndex);
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
				},
				error: function() {
					$submitBtn.prop('disabled', false);
					layer.close(submitIndex);
				}
			});
		}
	})
});
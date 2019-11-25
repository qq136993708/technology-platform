//拓展Array map方法
if(!Array.prototype.map){Array.prototype.map=function(i,h){var b,a,c,e=Object(this),f=e.length>>>0;if(h){b=h}a=new Array(f);c=0;while(c<f){var d,g;if(c in e){d=e[c];g=i.call(b,d,c,e);a[c]=g}c++}return a}};
//拓展Array foreach方法
if(!Array.prototype.forEach){Array.prototype.forEach=function forEach(g,b){var d,c;if(this==null){throw new TypeError("this is null or not defined")}var f=Object(this);var a=f.length>>>0;if(typeof g!=="function"){throw new TypeError(g+" is not a function")}if(arguments.length>1){d=b}c=0;while(c<a){var e;if(c in f){e=f[c];g.call(d,e,c,f)}c++}}};
//拓展Array filter方法
if(!Array.prototype.filter){Array.prototype.filter=function(b){if(this===void 0||this===null){throw new TypeError()}var f=Object(this);var a=f.length>>>0;if(typeof b!=="function"){throw new TypeError()}var e=[];var d=arguments[1];for(var c=0;c<a;c++){if(c in f){var g=f[c];if(b.call(d,g,c,f)){e.push(g)}}}return e}};

// 对Date的扩展，将 Date 转化为指定格式的String   
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// new Date().format('yyyy-MM-dd hh:mm:ss') ==> 2006-07-02 08:09:04
if (!Date.prototype.format) {
	Date.prototype.format = function(fmt) { //author: meizz   
		var o = {   
			"M+" : this.getMonth()+1,                 //月份   
			"d+" : this.getDate(),                    //日   
			"h+" : this.getHours(),                   //小时   
			"m+" : this.getMinutes(),                 //分   
			"s+" : this.getSeconds(),                 //秒   
			"q+" : Math.floor((this.getMonth()+3)/3), //季度   
			"S"  : this.getMilliseconds()             //毫秒   
		};   
		if(/(y+)/.test(fmt))   
			fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		for(var k in o)   
			if(new RegExp("("+ k +")").test(fmt))   
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		return fmt;   
	}
}

// 获取地址参数
function getQueryVariable(key) {
  var variable = null;
  if (window.location.search) {
    var query = window.location.search.substring(1);
		var vars = query.split("&");
    variable = {};

    for (var i=0; i<vars.length; i++) {
			if (vars[i]) {
				var pair = vars[i].split("=");
				variable[pair[0]] = (function() {
					if (pair[1] && pair[1] !== 'undefined' && pair[1] !== 'null') {
						return pair[1];
					} else { return ''; }
				})();
			}
    }

    if (key) {
      variable = variable[key];
    }
  }
  return variable;
}

// layui 表格http请求返回结果转换可识别
function layuiParseData(RelData, callback, number) {
  var codeData = {
    "code": '0', //解析接口状态
		"msg": RelData.message, //解析提示文本
		"count": RelData.data.total, //解析数据长度
		"data": (function(){
			return switchHttpData(RelData.data.list, '-');
		})() //解析数据列表
  };

  if (callback) {
    callback(codeData);
  } else {
		if (number) {
			codeData.data = codeData.data.filter(function(val, i) { if (i < number) {return val; } });
		}
    return codeData;
  }
}

// 会话窗口临时数据传递
function setDialogData(data, key) {
	// data 为一个JSON 或者 Array 对象时 设置sessionStorage的值；不能传递 HTML元素
	// key 则为存储的key, 可以为空值， 空值时 使用默认的key 'dialog-data';
	if (typeof(data) === 'object') {
		if (key && typeof(key) === 'string') {
			sessionStorage.setItem(key, JSON.stringify(data))
		} else {
			sessionStorage.setItem('dialog-data', JSON.stringify(data))
		}
	}
}

// 获取弹窗传递的参数
function getDialogData(id) {
	var tempData = null;
	if (id && typeof(id) !== 'object') {
		var tempData = sessionStorage.getItem(id);
		try {
			tempData = JSON.parse(tempData);
			// 数据获取完成后删除临时数据，避免重复
			sessionStorage.removeItem(id);
			return tempData;
		} catch (error) {
			sessionStorage.removeItem(id);
			return tempData;
		}
	}
	return tempData;
}

// 转换HTTP请求数据
function switchHttpData(dataJson, value) {
	if (dataJson != null && typeof(dataJson) === 'object') {
		var tempData = null;
		if (dataJson.length) {
			tempData = [];
			for (var i = 0; i < dataJson.length; i++) {
				if (typeof(dataJson[i]) === 'object') {
					tempData[i] = switchHttpData(dataJson[i], value);
				} else if (!dataJson[i] && (dataJson[i] !== 0 && dataJson[i] !== '0')) {
					tempData[i] = value || '';
				} else {
					tempData[i] = dataJson[i];
				}
			}
		} else {
			tempData = {};
			for (var key in dataJson) {
				if (typeof(dataJson[key]) === 'object') {
					tempData[key] = switchHttpData(dataJson[key], value);
				} else if (!dataJson[key] && (dataJson[key] !== 0 && dataJson[key] !== '0')) {
					tempData[key] = value || '';
				} else {
					tempData[key] = dataJson[key];
				}
			}
		}
		
		return tempData;
	} else {
		return dataJson;
	}
}
// 统一HTTP请求方法调用， 配置项与 $.ajax 参数一样；
function httpModule(config) {
	if (config && typeof(config) === 'object') {
		var httpType = config.type || 'GET';
		if (httpType === 'get') {
			httpType = 'GET';
		} else if (httpType === 'post') {
			httpType = 'POST';
		}

		var options = {
			url: config.url,
			type: httpType,
			data: (function() {
				if (config.hasOwnProperty('data')) {
					return JSON.stringify(config.data);
				}
			})(),
			dataType: config.dataType || "json",
			contentType: config.contentType || 'application/json',
			async: (function() {
				if (config.hasOwnProperty('async')) {
					return config.async;
				} else {
					return true;
				}
			})(),
			beforeSend: function(xmlhr) {
				if (config.hasOwnProperty('beforeSend')) {
					return config.beforeSend(xmlhr);
				} else {
					return true;
				}
			},
			success: function(reldata) {
				if (config.hasOwnProperty('success')) {
					return config.success(reldata);
				}
			},
			error: function(err) {
				if (config.hasOwnProperty('error')) {
					config.error(err);
				}
			},
			complete: function(XHR, TS) {
				if (config.hasOwnProperty('complete')) {
					config.complete(XHR, TS);
				}
			},
			dataFilter: function(data, dataType) {
				if (dataType === 'json') {
					try {
						return JSON.stringify(switchHttpData(JSON.parse(data)));
					} catch (err) {
						if (!data) {
							return JSON.stringify({
								code: '-1',
								data: 'error',
								message: '请求接口异常，后台报错，但不返回值'
							})
						}
					}
				} else {
					return data;
				}
			}
		}

		for (var key in config) {
			if (!options.hasOwnProperty(key)) {
				options[key] = options[key];
			}
		}

		// 调用 $.ajax;
		$.ajax(options);
		
	} else {
		top.layer.msg('HTTP请求配置有误！', {icon: 2});
	}
}
/*关闭标签页*/
function closeTabsPage(index){
	var iframe=parent.$("#LAY_app_body div").eq(index+1).find("iframe")
	var iframeSrc=$(iframe).attr("src")
    $(iframe).attr('src',iframeSrc);
    var index=parent.$("#LAY_app_body div.layui-show").index()-1;
    parent.$("#LAY_app_tabsheader li").eq(index).find('.layui-tab-close').trigger('click');
}


// 获取字典总数据
function _getDicStore(key, type, callback) {
	var store = null;
	if (key && typeof(key) !== 'object') {
		if (!top.__base_dic_store[key]) {
			top.__base_dic_store[key] = {
				data: []
			};
			_commonLoadDic(key, function(relData) {
				if (type === 'form') {
					$(document).trigger('dicLoad_' + key, {data: relData});
				} else {
					$(document).trigger('dicTarget_' + key, {data: relData});
				}
			});
		}
		store = top.__base_dic_store[key].data.map(function(item, i) { return item });
	}
	if (callback) {
		callback(store);
	} else {
		return store;
	}
}

// 设置总字典数据
function _commonLoadDic(dicKindCode, callback) {
	if (dicKindCode && typeof(dicKindCode) !== 'object') {
		var httpUrl = '/sysDictionary-api/getChildsListByCode/' + dicKindCode;
		httpModule({
			url: httpUrl,
			type: 'GET',
			success: function(relData) {
				var success = false;
				if (relData.hasOwnProperty('code')) {
					if (relData.code === '0') {
						success = true;
					}
				} else if (relData.success) {
					success = true;
				}

				if (success) {
					var __dicData = null;
					if (!relData.data) {
						__dicData = [];
					} else {
						__dicData = relData.data.map(function(item, i) {
							if (!item.value) {
								item.value = item.code;
							}
							return item
						});
					}
					top.__base_dic_store[dicKindCode].data = __dicData;
					if (callback) {
						callback(__dicData);
					}
				}
			}
		});
  }
}
  
function bindSelectorDic(selector, dicKindCode, form, filter, type) {
 
	var __dicData = _getDicStore(dicKindCode, 'form');
	if (type === 'xm-select') {
		if (__dicData.length) {
			form.data(filter, 'local', {arr: __dicData});
		} else {
			$(document).on('dicLoad_' + dicKindCode, function(event, param) {
				form.data(filter, 'local', {arr: param.data});
			});
		}
	} else if (type === 'select') {
		if (selector.attr('placeholder')) {
			selector.append('<option value=""></option>');
		}
		if (__dicData.length) {
			$.each(__dicData, function(i, item){
				selector.append(new Option(item.name, (item.numValue || item.value)));
			});
			form.render('select');
		} else {
			$(document).on('dicLoad_' + dicKindCode, function(event, param) {
				var data = param.data;
				$.each(data, function(i, item){
					selector.append(new Option(item.name, (item.numValue || item.value)));
				});
				form.render('select');
			});
		
			// if (__dicData !== 0) {
			// 	_commonLoadDic(dicKindCode);
			// }
		}
		
	}
}
  

function transInputDic(input, dicKindCode) {
	
	var code = input.val();
 
	var __dicData = _getDicStore(dicKindCode, 'form');

	if (__dicData != null && __dicData.length) {
		for(var i = 0; i<__dicData.length; i++) {
			if(__dicData[i].numValue === code) {
				input.val(__dicData[i].name) ; 
			}
		}
 		
	} else {
		$(document).on('dicLoad_' + dicKindCode, function(event, param) {

			var data = param.data;
			var text = code;
			for(var i=0;i<data.length;i++) {
				if(data[i].numValue === code) {
					text = data[i].name;
					break;
				}
			}

			input.val(text) ; 
		});
  
		// if (__dicData !== 0) {
		// 	_commonLoadDic(dicKindCode);
		// }
	}
  
}

  
function transFieldDic(dicKindCode, code) {

	if (code == null) {
		return '';
	}
	var __dicData = _getDicStore(dicKindCode, 'form');

	if (__dicData != null && __dicData.length) {
		for(var i=0;i<__dicData.length;i++) {
			if(__dicData[i].numValue === code) {
				return __dicData[i].name; 
			}
		}
 
		return code;
	} else {
		var attr = "trans-dic-" + dicKindCode + "='" + code + "'";

		$(document).on('dicLoad_' + dicKindCode, function(event, param) {

			var data = param.data;
			var text = code;
			for(var i=0;i<data.length;i++) {
				if(data[i].numValue === code) {
					text = data[i].name;
					break;
				}
			}

			$("span[" + attr + "]").text(text);
		});
  
		// if (__dicData !== 0) {
		// 	_commonLoadDic(dicKindCode);
		// }
  
		return "<span " + attr + ">" + code + "</span>";
	}
}


function dateFieldText(d) {
	if(d==null) return '';
	var d = new Date(d);
	return d.format('yyyy-MM-dd');
}

function getObjectData(dataJson, value) {
	var tempData = null;
	if (dataJson != null) {
		if (typeof(dataJson) === 'object' && dataJson.length) {
			// 当前数据时个数组
			for (var i = 0; i < dataJson.length; i++) {
				if (dataJson[i].value === value || dataJson[i].numValue === value || dataJson[i].code === value) {
					tempData = dataJson[i].name;
					break;
				}
				// 判断是否有子集， 有子集则从子集中去匹配
				if (dataJson[i].hasOwnProperty('childNodes') || dataJson[i].hasOwnProperty('children')) {
					var tempDataArr = [];
					if (typeof(dataJson[i].childNodes) === 'object' && dataJson[i].childNodes.length) {
						tempDataArr = tempDataArr.concat(dataJson[i].childNodes);
					}
					if (typeof(dataJson[i].children) === 'object' && dataJson[i].children.length) {
						tempDataArr = tempDataArr.concat(dataJson[i].children);
					}
					if (tempDataArr.length) {
						tempData = getObjectData(dataJson, value);
						// 如果从子集中拿到相应的值后、则退出循环
						if (tempData) {
							break;
						}
					}
				}
			}
		}
	}
	return tempData;
}

// 给非form表单域标签统一赋值
function setTargetNameValue(data) {
	if (data && typeof(data) === 'object' && !data.length) {
		$('[diy-form-value]').each(function(index, item) {
			var labelKey = $(this).attr('diy-form-value');
			var dicKindCode = $(this).attr('diy-dic-data');
			var targetValue = '';
			if (dicKindCode) {
				// 从字典中读取数据
				var __dicData = _getDicStore(dicKindCode, 'target');
				// 是否获取到相应字典数据
				if (__dicData.length) {
					if (data[labelKey].indexOf(',') !== -1) {
						var keyArr = data[labelKey].split(',');
						for (var i = 0; i < keyArr.length; i++) {
							targetValue += ',' + getObjectData(__dicData, keyArr[i]);
						}
						targetValue = targetValue.substring(1);
					} else {
						targetValue = getObjectData(__dicData, data[labelKey]);
					}
				} else {
					// 当前字典数据暂未获取到，绑定获取数据成功事件
					$(document).on('dicTarget_' + dicKindCode, function(event, param) {
						$(this).text(getObjectData(param.data, data[labelKey]));
					})
				}

			} else {
				targetValue = data[labelKey];
			}
			$(this).text(targetValue);
		})
	} else {
		top.layer.msg('赋值数据有误！', {icon: 2});
	}
}

function setNotClassName(notClass) {
	var className = '';
	if (notClass.indexOf(',') !== -1) {
		var classArr = notClass.split(',');
		$.each(notClass.split(','), function(i, name) {
			className = ',' + setNotClassName(name);
		})
		className = className.substring(1);
	} else if (notClass.indexOf('.') !== -1) {
		className = notClass;
	} else {
		className = '.' + notClass;
	}
	return notClass;
}

// 设置表单元素不可读取 disabled
function setFomeDisabled(filter, notClass) {
	var formItems = $('form[lay-filter="'+ filter +'"]')[0];
	$.each(formItems, function(i, item) {
		$(item).not(setNotClassName(notClass) + ',.close-all-dialog').prop('disabled', true);
	})
}
// 取消表单元素不可读取 disabled
function setFomeUnDisabled(filter, notClass) {
	var formItems = $('form[lay-filter="'+ filter +'"]')[0];
	$.each(formItems, function(i, item) {
		$(item).not(setNotClassName(notClass) + ',.close-all-dialog').prop('disabled', false);
	})
}


// 添加文件大小单位
function setFileSize(number) {
	var size = '0 k';
	if (typeof(number) == 'number') {
		if (number/1024 > 1024) {
			if ( number/(1024 * 1024) > 1024 ) {
				size = parseFloat(number/(1024 * 1024 * 1024)).toFixed(2) + 'G';
			} else {
				size = parseFloat(number/(1024 * 1024)).toFixed(2) + 'Mb';
			}
		} else {
			size = parseFloat(number/1024).toFixed(2) + ' kb';
		}
	}
	return size;
}


// 渲染字典
layui.use(['jquery', 'form', 'formSelects'], function() {
	var $ = layui.jquery;
	
	// 关闭 top层 所有弹窗
	$('.close-all-dialog').click(function() {
		top.layer.closeAll();
	})

	// 自动渲染下拉框
	$('select[dic-base-data]').each(function() {
		if ($(this).attr('dic-base-data')) {
			$(this).empty();
			if ($(this).attr('xm-select')) {
				bindSelectorDic($(this), $(this).attr('dic-base-data'), layui.formSelects, $(this).attr('xm-select'), 'xm-select');
			} else {
				bindSelectorDic($(this), $(this).attr('dic-base-data'), layui.form, $(this).attr('lay-filter'), 'select');
			}
		}
	});
})
  
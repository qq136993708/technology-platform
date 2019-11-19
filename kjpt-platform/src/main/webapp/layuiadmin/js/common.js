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
function layuiParseData(RelData, callback) {
  var codeData = {
    "code": '0', //解析接口状态
		"msg": RelData.message, //解析提示文本
		"count": RelData.data.total, //解析数据长度
		"data": RelData.data.list //解析数据列表
  };

  if (callback) {
    callback(codeData);
  } else {
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
function switchHttpData(dataJson) {
	if (dataJson != null && typeof(dataJson) === 'object') {
		var tempData = null;
		if (dataJson.length) {
			tempData = [];
			for (var i = 0; i < dataJson.length; i++) {
				if (typeof(dataJson[i]) === 'object') {
					tempData[i] = switchHttpData(dataJson[i]);
				} else if (dataJson[i] === null) {
					tempData[i] = '';
				} else {
					tempData[i] = dataJson[i];
				}
			}
		} else {
			tempData = {};
			for (var key in dataJson) {
				if (typeof(dataJson[key]) === 'object') {
					tempData[key] = switchHttpData(dataJson[key]);
				} else if (dataJson[key] === null) {
					tempData[key] = '';
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
					return JSON.stringify(switchHttpData(JSON.parse(data)));
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


// 
layui.use(['jquery'], function() {
	var $ = layui.jquery;
	
	// 关闭 top层 所有弹窗
	$('.close-all-dialog').click(function() {
		top.layer.closeAll();
	})
})



  
var __page_dic_store = {};

function _getDicStore() {
	var store = top._getBaseDicStore();
	return store;  //|| __page_dic_store;
}

 
function _commonLoadDic(dicKindCode) {

	var __dicData = _getDicStore();
	__dicData[dicKindCode] = 0;
	var httpUrl = '/sysDictionary-api/getChildsListByCode/' + dicKindCode;
	httpModule({
	  url: httpUrl,
	  type: 'GET',
	  success: function(relData) {
  
		if (relData.success) { 
			__dicData[dicKindCode] = relData.data;
			$(document).trigger('dicLoad_' + dicKindCode, {data: relData.data});
		}
	  }
	});
  }
  

  
  function bindSelectorDic(selector, dicKindCode, form, filter) {
   
	var __dicData = _getDicStore();
	var dic = __dicData[dicKindCode];
  
	if (dic != null && dic.length) {
		$.each(dic, function(i, item){
			selector.append(new Option(item.name, item.numValue));
		});
		form.render('select', filter);
	} else {
	  $(document).on('dicLoad_' + dicKindCode, function(event, param) {
  
		   var data = param.data;
			 $.each(data, function(i, item){
				selector.append(new Option(item.name, item.numValue));
			});
			form.render('select', filter);
		});
  
		if (dic !== 0) {
			_commonLoadDic(dicKindCode);
		}
	   
	}
  }
  
  
  function transInputDic(input, dicKindCode) {
	
	var code = input.val();
 
	var __dicData = _getDicStore();
	var dic = __dicData[dicKindCode];
	if (dic != null && dic.length) {
		for(var i=0;i<dic.length;i++) {
			if(dic[i].numValue === code) {
				input.val(dic[i].name) ; 
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
  
		if (dic !== 0) {
			_commonLoadDic(dicKindCode);
		}
   
	}
  
  }

  
  
  function transFieldDic(dicKindCode, code) {
	
	if (code == null) {
		return '';
	}

	var __dicData = _getDicStore();
	var dic = __dicData[dicKindCode];
	if (dic != null && dic.length) {
		for(var i=0;i<dic.length;i++) {
			if(dic[i].numValue === code) {
				return dic[i].name; 
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
  
		if (dic !== 0) {
			_commonLoadDic(dicKindCode);
		}
  
		return "<span " + attr + ">" + code + "</span>";
	   
	}
  
  }


  function dateFormatText(d) {
	 var d = new Date(d);
	 return d.toLocaleDateString();
  }
  
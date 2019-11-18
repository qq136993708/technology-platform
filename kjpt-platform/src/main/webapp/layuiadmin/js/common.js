// 公共API
var webKJQTApi = "/webKJQTApi"

// 获取地址参数
function getQueryVariable(key) {
  var variable = null;
  if (window.location.search) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    variable = {};

    for (var i=0; i<vars.length; i++) {
      var pair = vars[i].split("=");
      variable[pair[0]] = pair[1];
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
    "msg": 'res.message', //解析提示文本
    "count": RelData.tableList.length, //解析数据长度
    "data": RelData.tableList //解析数据列表
  };

  if (callback) {
    callback(codeData);
  } else {
    if (number) {
      codeData.data = codeData.data.filter(function(item, i) {
        if (i < number) {
          return item;
        }
      })
    }
    return codeData;
  }
}

// 会话窗口临时数据传递
function dialogData(data, key) {
	// data 为字符串时获取sessionStorage的值；
	// data 为一个JSON 或者 Array 对象时 设置sessionStorage的值；不能传递 HTML元素
	// key 则为存储的key, 可以为空值， 空值时 使用默认的key 'dialog-data';
	if (typeof(data) === 'string') {
		var tempData = null;
		var str = sessionStorage.getItem(data);
		if (str) {
			try {
				tempData = JSON.parse(str);
				// 数据获取完成后删除临时数据，避免重复
				sessionStorage.removeItem(data);
				return tempData;
			} catch (error) {
				sessionStorage.removeItem(data);
				return tempData;
			}
		} else {
			return tempData;
		}
	} else if (typeof(data) === 'object') {
		if (key && typeof(key) === 'string') {
			sessionStorage.setItem(key, JSON.stringify(data))
		} else {
			sessionStorage.setItem('dialog-data', JSON.stringify(data))
		}
	}
}
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
		// 调用 $.ajax;
		$.ajax({
			url: webKJQTApi + config.url,
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
		});
		
	} else {
		top.layer.msg('HTTP请求配置有误！', {icon: 2});
	}
}


// 
layui.use(['jquery'], function() {
	var $ = layui.jquery;
	
	// 关闭 top层 所有弹窗
	$('.close-all-dialog').click(function() {
		dialogData({code: 'close'});
		top.layer.closeAll();
	})
})

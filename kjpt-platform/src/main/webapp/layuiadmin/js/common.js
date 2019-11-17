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
var timeout = 'dialog-data';
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
			timeout = key;
			sessionStorage.setItem(key, JSON.stringify(data))
		} else {
			sessionStorage.setItem('dialog-data', JSON.stringify(data))
		}
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

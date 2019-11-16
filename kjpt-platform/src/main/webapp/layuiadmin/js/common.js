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

// layui 返回结果转换可识别
function layuiParseData(RelData, callback, number) {
  var codeData = {
    "code": '0', //解析接口状态
    "msg": 'res.message', //解析提示文本
    "count": RelData.tableList.length, //解析数据长度
    "data": RelData.tableList //解析数据列表
  };

  /*
  .filter(function(item, i) {
    if (i < 2) {
      return item;
    }
  })
  */

  if (callback) {
    callback(codeData);
  } else {
    if (number) {
      codeData.data = codeData.data.filter(function(item, i) {
        if (i < 2) {
          return item;
        }
      })
    }
    return codeData;
  }
}

/**
 * Created by HANZO on 2016/6/17.
 */

/**
 *
 * @param url
 * @param params
 * @param callback
 * @returns {*}
 */
//(function ($) {

function loadPage(url, container) {
    if (!container)
        container = "#mainDiv";
    if (!url.startWith(basePath))
        url = basePath + url;
    jQuery(container).load(url, function (response, status, xhr) {
        if (status == "success") {
            if (response) {
                try {
                    var result = jQuery.parseJSON(response);
                    if (result.code == 100) {
                        jQuery(container).html("");
                        alert(result.data);
                    }
                } catch (e) {
                    return response;
                }
            }
        }
    });
}

/**
 * Load a url into a page
 * 增加beforeSend以便拦截器在将该请求识别为非ajax请求
 */
var _old_load = jQuery.fn.load;
jQuery.fn.load = function (url, params, callback) {
    //update for HANZO, 2016/12/22
    if (typeof url !== "string" && _old_load) {
        return _old_load.apply(this, arguments);
    }

    var selector, type, response,
        self = this,
        off = url.indexOf(" ");
    if (off > -1) {
        selector = jQuery.trim(url.slice(off));
        url = url.slice(0, off);
    }
    if (jQuery.isFunction(params)) {
        callback = params;
        params = undefined;
    } else if (params && typeof params === "object") {
        type = "POST";
    }
    if (self.length > 0) {
        jQuery.ajaxSetup({cache:true});
        jQuery.ajax({
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader('X-Requested-With', {
                    toString: function () {
                        return '';
                    }
                });
            },
            type: type || "GET",
            dataType: "html",
            data: params
        }).done(function (responseText) {
            //console.log(responseText);
            response = arguments;
            //页面超时跳转到首页
            if (responseText.startWith("<!--login_page_identity-->")) {
                window.location.href = basePath + "/";
            } else {
                self.html(selector ?
                    jQuery("<div>").append(jQuery.parseHTML(responseText)).find(selector) :
                    responseText);
            }
        }).always(callback && function (jqXHR, status) {
                self.each(function () {
                    callback.apply(this, response || [jqXHR.responseText, status, jqXHR]);
                });
            });
    }

    return this;
};

//递归删除空属性防止把null变成空值
function deleteEmptyProp(obj) {
    for (var a in obj) {
        if (typeof (obj[a]) == "object" && obj[a] != null) {
            deleteEmptyProp(obj[a]);
        }
        else {
            if (!obj[a]) {
                delete obj[a];
            }
        }
    }
    return obj;
}

function ajaxPost(url, params, callback) {
    var result = null;
    var headers = {
        //'Content-Type':'application/json',
        //'access-token':getCookie("token")
    };
    if (params && typeof params == "object") {
        params = deleteEmptyProp(params);
    }
    jQuery.ajax({
        type: 'post',
        async: false,
        url: url,
        data: params,
        dataType: 'json',
        headers: headers,
        success: function (data, status) {
            result = data;
            if (data && data.code && data.code == '101') {
            	console.log("操作失败，请刷新重试，具体错误：" + data.message);
                return false;
            }
            if (callback) {
                callback.call(this, data, status);
            }
        },
        error: function (err, err1, err2) {
            console.log("ajaxPost发生异常，请仔细检查请求url是否正确");
        }
    });
    return result;
}

function ajaxPostAsyncTrue(url, params, callback) {
    var result = null;
    var headers = {
        //'Content-Type':'application/json',
        //'access-token':getCookie("token")
    };
    if (params && typeof params == "object") {
        params = deleteEmptyProp(params);
    }
    jQuery.ajax({
        type: 'post',
        async: true,
        url: url,
        data: params,
        dataType: 'json',
        headers: headers,
        success: function (data, status) {
            result = data;
            if (data && data.code && data.code == '101') {
                console.log("操作失败，请刷新重试，具体错误：" + data.message);
                return false;
            }
            if (callback) {
                callback.call(this, data, status);
            }
        },
        error: function (err, err1, err2) {
            console.log("ajaxPost发生异常，请仔细检查请求url是否正确");
        }
    });
    return result;
}

function ajaxGet(url, params, callback) {
    var result = null;
    var headers = {
        //'Content-Type':'application/json',
        //'access-token':getCookie("token")
    };
    if (params && typeof params == "object") {
        params = deleteEmptyProp(params);
    }
    jQuery.ajax({
        type: 'get',
        async: false,
        url: url,
        data: params,
        dataType: 'json',
        headers: headers,
        success: function (data, status) {
            result = data;
            if (data && data.code && data.code == '101') {
                console.log("操作失败，请刷新重试，具体错误：" + data.message);
                return false;
            }
            if (callback) {
                callback.call(this, data, status);
            }
        },
        error: function (err, err1, err2) {
            console.log("ajaxPost发生异常，请仔细检查请求url是否正确");
        }
    });
    return result;
}

function getServerTime(base_path, format) {
    var result = null;

    var sdate = new Date(ajaxPost(base_path + '/base/getServerTime'));
    if (sdate != 'Invalid Date') {
        result = formatDate(sdate, format || 'yyyy/mm/dd');
    }

    return result;
}

/**
 * 格式化日期
 */
function formatDate(date, format) {
    if (!date)return date;
    //数据库为时间戳,用此转换
    // date = (typeof date == "number") ? new Date(date) : date;
    // if(typeof (date)=="string"){
    //     if (date.length>19) {
    //         date = date.substring(0,19);
    //     }
    //     date = date.replace(/-/g,'/');
    //     date = new Date(date);
    // }
    if (date.length>19) {
        date = date.substring(0,19);
    }
    date = new Date(date);
    return date.Format(format);
}

Date.prototype.Format = function (fmt) {
    var o = {
        "m+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "i+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 比较两个时间的大小 d1>d2 返回大于0
 * @param d1
 * @param d2
 * @returns {number}
 * @constructor
 */
function DateDiff(d1, d2) {
    var result = Date.parse(d1.replace(/-/g, "/")) - Date.parse(d2.replace(/-/g, "/"));
    return result;
}

/**
 * 字符串转日期
 * @returns {number}
 */
String.prototype.strToDate = function () {
    if (this && this != "") {
        return Date.parse(this.replace(/-/g, "/"));
    }
    else
        return "";
}
/**
 * 将map类型[name,value]的数据转化为对象类型
 */
function getObjectFromMap(aData) {
    var map = {};
    for (var i = 0; i < aData.length; i++) {
        var item = aData[i];
        if (!map[item.name]) {
            map[item.name] = item.value;
        }
    }
    return map;
}


/**
 * 获取下一个编码 000001，000001000006，6
 * 得到结果 000001000007
 */
function getNextCode(prefix, maxCode, length) {
    if (maxCode == null) {
        var str = "";
        for (var i = 0; i < length - 1; i++) {
            str += "0";
        }
        return prefix + str + 1;
    } else {
        var str = "";
        var sno = parseInt(maxCode.substring(prefix.length)) + 1;
        for (var i = 0; i < length - sno.toString().length; i++) {
            str += "0";
        }
        return prefix + str + sno;
    }

}

/**
 * 收缩左边栏时，触发markdown编辑的resize
 */
/*$("[data-toggle='offcanvas']").click(function () {
 if (editor) {
 setTimeout(function () {
 editor.resize()
 }, 500);
 }
 });*/


//获取布尔值
/*String.prototype.BoolValue=function(){
 if(this==undefined)
 return false;
 if(this=="false"||this=="0")
 return false;
 return true;
 }*/

var HtmlUtil = {
    /*1.用浏览器内部转换器实现html转码*/
    htmlEncode: function (html) {
        //1.首先动态创建一个容器标签元素，如DIV
        var temp = document.createElement("div");
        //2.然后将要转换的字符串设置为这个元素的innerText(ie支持)或者textContent(火狐，google支持)
        (temp.textContent != undefined ) ? (temp.textContent = html) : (temp.innerText = html);
        //3.最后返回这个元素的innerHTML，即得到经过HTML编码转换的字符串了
        var output = temp.innerHTML;
        temp = null;
        return output;
    },
    /*2.用浏览器内部转换器实现html解码*/
    htmlDecode: function (text) {
        //1.首先动态创建一个容器标签元素，如DIV
        var temp = document.createElement("div");
        //2.然后将要转换的字符串设置为这个元素的innerHTML(ie，火狐，google都支持)
        temp.innerHTML = text;
        //3.最后返回这个元素的innerText(ie支持)或者textContent(火狐，google支持)，即得到经过HTML解码的字符串了。
        var output = temp.innerText || temp.textContent;
        temp = null;
        return output;
    }
};

String.prototype.startWith = function (s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length)
        return false;
    if (this.substr(0, s.length) == s)
        return true;
    else
        return false;
    return true;
}

String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}

String.prototype.format = function () {
    if (arguments.length == 0) return this;
    for (var s = this, i = 0; i < arguments.length; i++)
        s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
    return s;
};

//时间处理
function formatDateTime(fDate) {
	if(typeof(fDate)=="undefined"){
        return "";
    }
    var oDate = new Date(fDate),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime; 
}

//补0操作,当时间数据小于10的时候，给该数据前面加一个0  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}


//})(jQuery)
//写cookies
function setCookie(name,value)
{
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)
{
    /*var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;*/
	return index.token;
}
function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function ajaxPostHeader(url, params, callback,headertype) {
    var result = null;
    if(headertype==""){
        headertype="application/json";
    }
    var headers = {
        'Content-Type':headertype,
        'access-token':getCookie("token")
    };

    if (params && typeof params == "object") {
        params = deleteEmptyProp(params);
    }

    jQuery.ajax({
        type: 'post',
        async: false,
        url: url,
        data: params,
        dataType: 'json',
        headers: headers,
        success: function (data, status) {
            result = data;
            if (data && data.code && data.code == '101') {
                modals.error("操作失败，请刷新重试，具体错误：" + data.message);
                return false;
            }
            if (callback) {
                callback.call(this, data, status);
            }
        },
        error: function (err, err1, err2) {
            console.log("ajaxPost发生异常，请仔细检查请求url是否正确");
            //console.log(err.responseText);
            if (err && err.readyState && err.readyState == '4') {
                var sessionstatus = err.getResponseHeader("session-status");
                //console.log(err);
                //console.log(err1);
                //console.log(err2);
                if (sessionstatus == "timeout") {
                    //如果超时就处理 ，指定要跳转的页面
                    window.location.href = basePath + "/";
                }
                else if (err1 == "parsererror") {//csrf异常
                    var responseBody = err.responseText;
                    if (responseBody) {
                        responseBody = "{'retData':" + responseBody;
                        var resJson = eval('(' + responseBody + ')');
                        jQuery("#csrftoken").val(resJson.csrf.CSRFToken);
                        this.success(resJson.retData, 200);
                    }
                    return;
                } else {
                    modals.error({
                        text: JSON.stringify(err) + '<br/>err1:' + JSON.stringify(err1) + '<br/>err2:' + JSON.stringify(err2),
                        large: true
                    });
                    return;
                }
            }

            modals.error({
                text: JSON.stringify(err) + '<br/>err1:' + JSON.stringify(err1) + '<br/>err2:' + JSON.stringify(err2),
                large: true
            });
        }
    });

    return result;
}

// Date.prototype.Format = function(fmt) {
//     var o = {
//         "M+": this.getMonth() + 1,
//         //月份
//         "d+": this.getDate(),
//         //日
//         "h+": this.getHours(),
//         //小时
//         "m+": this.getMinutes(),
//         //分
//         "s+": this.getSeconds(),
//         //秒
//         "q+": Math.floor((this.getMonth() + 3) / 3),
//         //季度
//         "S": this.getMilliseconds() //毫秒
//     };
//     if (/(y+)/.test(fmt)) {
//         fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
//     }
//     for (var k in o) {
//         if (new RegExp("(" + k + ")").test(fmt)) {
//             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
//         }
//     }
//     return fmt;
// }

function getDataTable(data) {
	var obj = {};
	if(!data) return obj;
	$.each(data, function(idx, item) {
		if (item.name == 'sEcho') {
			obj.sEcho = item.value;
		} else if(item.name == 'iColumns'){
			obj.iColumns = item.value;
		} else if(item.name == 'iDisplayStart'){
			obj.iDisplayStart = item.value;
		} else if(item.name == 'iDisplayLength'){
			obj.iDisplayLength = item.value;
		} else if(item.name == 'mDataProp'){
			obj.mDataProp = item.value;
		} else if(item.name == 'sSearch'){
			obj.sSearch = item.value;
		} else if(item.name == 'iSortCol_0'){
			obj.iSortCol_0 = item.value;
			$.each(data, function(idx1, item1) {
				if(item1.name == 'mDataProp_'+item.value){
					obj.iSortCol = item1.value;
					return false;
				}
			})
		} else if(item.name == 'sSortDir_0'){
			obj.sSortDir_0 = item.value;
		}
		//alert("name:" + item.name + ",value:" + item.value);
	});
	return obj;
}
//get url
function getUrlParam(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return "";
}
/**
 * 打开宽600，高400框
 * @param title
 * @param temUrl
 * @returns
 */
function openBaseWin(title,temUrl)
{
	layer.open({
        title:title,
        skin: 'layui-layer-lan',
        shadeClose: false,
        type: 2,
        fixed: false,
        //若使用小窗口形式，则修改 maxmin 值为 true，则注释掉area:[100%,100%]属性,同时设置area: ['900px', '450px']
        maxmin: false,
        //若直接弹出页面 ，则修改 area;[100%,100%]，同时设置 maxmin 为false
        area: ['90%', '80%'],
        content:  temUrl
    });
}
/**
 * 打开满屏框
 * @param title
 * @param temUrl
 * @returns
 */
function openFullWin(title,temUrl)
{
	layer.open({
	    title:title
	    ,skin: 'layui-layer-lan'
	    ,shadeClose: false
	    ,type: 2
	    ,fixed: false
	    //若使用小窗口形式，则修改 maxmin 值为 true，则注释掉area:[100%,100%]属性,同时设置area: ['900px', '450px']
	    ,maxmin: false
	    //若直接弹出页面 ，则修改 area;[100%,100%]，同时设置 maxmin 为false
	    ,area: ['100%', '100%']
	    ,content:  temUrl
	});
}


/**
* 生成一个表单
* @param {String} name 表单的名称
* @param {String} id 表单的ID
* @param {String} action 表单的action
* @param {String} method 表单的method
*/
function createForm(name, id, action, method, target) {
	var form = document.createElement('form');
	form.name = name;
	form.id = id;
	form.action = action;
	form.method = method;
	form.target = target;
	return form;
}

/**
 * 生成一个隐藏域
 * @param {String} name 隐藏域的名称
 * @param {String} value 隐藏域的值
 */
function createHiddenInput(name, value) {
	var field = document.createElement('input');
	field.type = 'hidden';
	field.name = name;
	field.id = name;
	field.value = value;
	return field;
}

function insertValueToForm(formObj,formFieldName,fieldValue){
    formObj.appendChild(createHiddenInput(formFieldName,fieldValue));
}

//获取当前日期
function getCurrentDate(){
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = date.getMonth()+1; 
	var day = date.getDate(); 
	var hour = date.getHours(); 
	var minute = date.getMinutes(); 
	var second = date.getSeconds(); 
	return year+''+month+''+day+''+hour+''+minute+''+second;
}
function json_to_get(sstr){
    sstr = sstr.replace(/\t/g,"");
    sstr = sstr.replace(/\"/g,"").replace("{","").replace("}","");
    sstr = sstr.replace(",","&").replace(":","=");
    sstr = sstr.replace(/\"/g,"").replace(/{/g,"").replace(/}/g,"");
    sstr= sstr.replace(/,/g,"&").replace(/:/g,"=");
    return sstr;
}
function idCode() {
    var param = {
        "id": parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-code"),
        "code": parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("id"),
        "functionbuttons": parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-functionbuttons")
    };
    return param;
}

function upload_File_table(inputValueOrInputId) {
    var param = {};
    param.file_ids_value = inputValueOrInputId;
    param.file_opt_flag = getFunctionParam().id;//文件配置ID
    param.file_edit_detail = "detail";//新增、修改用edit, 显示用detail
    var temUrl = "/sysFilePage/uploadFileTable?param=" + encodeURIComponent(JSON.stringify(param));
    openBaseWin("文件上传列表查看", temUrl);
}

function upload_FileA() {
    var param = {};
    param.file_id_name = "filetextA";//字段ID名称
    param.callback = "call_fun";//回调函数名称
    param.file_opt_flag = "ff8129325ed94773bfd9f33145ccd080";//文件配置ID
    param.file_edit_detail = "edit";//新增、修改用edit, 显示用detail
    param.file_ids_value = $("#" + param.file_id_name).val();
    var temUrl = "/sysFilePage/uploadFile?param=" + encodeURIComponent(JSON.stringify(param));
    openBaseWin("文件上传", temUrl);
}

//inputValueOrInputId:表单字段的ID或者值,不能为空，唯一值UUID，如表单<input type="text" name="id" id="id" value="16537c4bc6f_ff4a0a81">,此处可传id或者16537c4bc6f_ff4a0a81
//fileConfigId：系统管理-附件管理-附件配置：页面标识,不确定则为空
//formType:detail：详情，edti：修改
//callfun:回调函数
function upload_File(inputValueOrInputId, fileConfigId, formType, callfun) {
    var param = {};
    if (document.getElementById(inputValueOrInputId)) {
        param.file_id_name = inputValueOrInputId;
        param.file_ids_value = $("#" + param.file_id_name).val();
    } else {
        param.file_ids_value = inputValueOrInputId;
    }
    if (param.file_ids_value == "") {
        alert("值不能为空");
        return;
    }
    param.callback = callfun;//回调函数名称
    param.file_opt_flag = ((fileConfigId==""||fileConfigId==null)?getFunctionParam().id:fileConfigId);//文件配置ID
    param.file_edit_detail = formType;//新增、修改用edit, 显示用detail
    var temUrl = "/sysFilePage/uploadFile?param=" + encodeURIComponent(JSON.stringify(param));
    openBaseWin("文件上传", temUrl);
}
var getFunctionParam = function () {
    return JSON.parse(window.localStorage.getItem("param"));
    // var functionId = param.id;
    // var iframeId = param.code;
}
var pcitc = pcitc || {};
pcitc.report = pcitc.report || {};
var pcitcReport = pcitc.report = {
    strNameType: "",//模型类型
    strTableId: "",//默认表格ID
    strTableHeadId: "",//默认表格头ID
    map_select: new Map(),//选中map存取
    arrayColumns_tab: [],//树形表格显示列备份
    arrayColumns_pic: [],//图形显示列备份
    strcolumns: "",
    strcolumnsko: "",
    strgroup: "",
    gsdm: "1750",
    strall: "",
    strwhere: "",
    xfield: "",//X轴
    date: "",
    picdata: "",
    k1: {},
    k2: {},
    flag: false,
    isCollect: false,
    treeGridCom: {},
    delHtmlTag: function (str) {//去掉所有的html标记
        return str.replace(/<[^>]+>/g, "");
    }
    , trimStr: function (str)//去空格
    {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
    , showtable: function (index, selectVal) {
        //console.log(index + "----" + id + "-----" + selectVal + "------------showtable-------------" + pcitcReport.map_select.get(index));
        //console.log(selectVal)
        //key,value添加到map
        if (selectVal == "undefined") {
            pcitcReport.map_select.set(index, "");
        } else {
            pcitcReport.map_select.set(index, selectVal);
        }
        //全部显示
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            console.log("全部显示:" + pcitcReport.strTableId);
            $(this).show();
        });
        //遍历map,显示隐藏
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            var obj = $(this);
            pcitcReport.map_select.forEach(function (value, key, map) {
                var flag = true;
                var selectedCon_array = value.split(",");
                // console.log("index:"+key+"---value:"+value);
                for (var i = 0; i < selectedCon_array.length; i++) {
                    selectedCon_array[i] = pcitcReport.trimStr(selectedCon_array[i]);
                    if (selectedCon_array[i] == "" || selectedCon_array[i] == "NaN" || selectedCon_array[i] == "undefined") {
                        continue;
                    }
                    var isPd = pcitcReport.trimStr(selectedCon_array[i]).indexOf(pcitcReport.trimStr($(obj).find('td').eq(key).text())) != -1;
                    if (isPd) {
                        flag = false;
                    }
                }
                console.log(flag + "---" + selectedCon_array.length + "---" + selectedCon_array);
                if (flag && selectedCon_array != "" && selectedCon_array.length > 0) {
                    console.log("-----------隐藏--------------" + value + "---key:" + key);
                    obj.hide();
                }
            });
        });
    },
    vaguetable: function (index, selectVal) {
        //console.log(index + "----" + id + "-----" + selectVal + "------------showtable-------------" + pcitcReport.map_select.get(index));
        //console.log(selectVal)
        //key,value添加到map
        if (selectVal == "undefined") {
            pcitcReport.map_select.set(index, "");
        } else {
            pcitcReport.map_select.set(index, selectVal);
        }
        //全部显示
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            //console.log("全部显示:" + pcitcReport.strTableId);
            $(this).show();
        });
        //console.log("全部展示");

        //遍历map,显示隐藏
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {

            var obj = $(this);
            pcitcReport.map_select.forEach(function (value, key, map) {
                var flag = true;
                var selectedCon_array = value.split(",");
                // console.log("index:"+key+"---value:"+value);
                for (var i = 0; i < selectedCon_array.length; i++) {
                    selectedCon_array[i] = pcitcReport.trimStr(selectedCon_array[i]);
                    if (selectedCon_array[i] == "" || selectedCon_array[i] == "NaN" || selectedCon_array[i] == "undefined") {
                        continue;
                    }
                    var isPd = pcitcReport.trimStr($(obj).find('td').eq(key).text()).indexOf(pcitcReport.trimStr(selectedCon_array[i])) > -1;
                    if (isPd) {
                        flag = false;
                    }
                }
                //console.log(flag + "---" + selectedCon_array.length + "---" + selectedCon_array);
                if (flag && selectedCon_array != "" && selectedCon_array.length > 0) {
                    //console.log("-----------隐藏--------------" + value + "---key:" + key);
                    obj.hide();
                }
            });
        });
    },
    noEqual: function (index, selectVal) {
        //console.log(index + "----" + id + "-----" + selectVal + "------------showtable-------------" + pcitcReport.map_select.get(index));
        //console.log(selectVal)
        //key,value添加到map
        if (selectVal == "undefined") {
            pcitcReport.map_select.set(index, "");
        } else {
            pcitcReport.map_select.set(index, selectVal);
        }
        //全部显示
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            console.log("全部显示:" + pcitcReport.strTableId);
            $(this).show();
        });
        console.log("全部展示");
        //遍历map,显示隐藏
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            var obj = $(this);
            pcitcReport.map_select.forEach(function (value, key, map) {
                var flag = true;
                var selectedCon_array = value.split(",");
                for (var i = 0; i < selectedCon_array.length; i++) {
                    selectedCon_array[i] = pcitcReport.trimStr(selectedCon_array[i]);
                    if (selectedCon_array[i] == "" || selectedCon_array[i] == "NaN" || selectedCon_array[i] == "undefined") {
                        continue;
                    }
                    var isPd = pcitcReport.trimStr(selectedCon_array[i]).indexOf(pcitcReport.trimStr($(obj).find('td').eq(key).text())) != -1;
                    if (isPd) {
                        flag = false;
                    }
                }
                if (flag && selectedCon_array != "" && selectedCon_array.length > 0) {
                } else {
                    obj.hide();
                }
            });
        });
    },
    bigRange: function (index, selectVal) {
        //key,value添加到map
        if (selectVal == "undefined") {
            pcitcReport.map_select.set(index, "");
        } else {
            pcitcReport.map_select.set(index, selectVal);
        }
        //全部显示
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            $(this).show();
        });
        //遍历map,显示隐藏
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            var obj = $(this);
            pcitcReport.map_select.forEach(function (value, key, map) {
                var flag = true;
                var selectedCon_array = value.split(",");
                for (var i = 0; i < selectedCon_array.length; i++) {
                    selectedCon_array[i] = pcitcReport.trimStr(selectedCon_array[i]);
                    if (selectedCon_array[i] == "" || selectedCon_array[i] == "NaN" || selectedCon_array[i] == "undefined") {
                        continue;
                    }
                    var isPd = parseInt(pcitcReport.trimStr($(obj).find('td').eq(key).text())) <= parseInt(pcitcReport.trimStr(selectedCon_array[i]));
                    if (isPd) {
                        flag = false;
                    }
                }
                if (flag && selectedCon_array != "" && selectedCon_array.length > 0) {
                } else {
                    obj.hide();
                }
            });
        });
    }
    ,
    smallRange: function (index, selectVal) {
        //key,value添加到map
        if (selectVal == "undefined") {
            pcitcReport.map_select.set(index, "");
        } else {
            pcitcReport.map_select.set(index, selectVal);
        }
        //全部显示
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            $(this).show();
        });
        //遍历map,显示隐藏
        $('#' + pcitcReport.strTableId).find('tbody tr').each(function () {
            var obj = $(this);
            pcitcReport.map_select.forEach(function (value, key, map) {
                var flag = true;
                var selectedCon_array = value.split(",");
                for (var i = 0; i < selectedCon_array.length; i++) {
                    selectedCon_array[i] = pcitcReport.trimStr(selectedCon_array[i]);
                    if (selectedCon_array[i] == "" || selectedCon_array[i] == "NaN" || selectedCon_array[i] == "undefined") {
                        continue;
                    }
                    var isPd = parseInt(pcitcReport.trimStr($(obj).find('td').eq(key).text())) >= parseInt(pcitcReport.trimStr(selectedCon_array[i]));
                    if (isPd) {
                        flag = false;
                    }
                }
                if (flag && selectedCon_array != "" && selectedCon_array.length > 0) {
                } else {
                    obj.hide();
                }
            });
        });
    }
    , clickThCheck: function (data) {//添加点击事件
        pcitcReport.map_select = new Map();
        var strTh = $('#' + pcitcReport.strTableHeadId).find('thead tr th');
        var randId = new Date().getTime();
        $('#' + pcitcReport.strTableHeadId).find('thead tr th').click(function () {
            var index = $(this).index();
            if (pcitcReport.arrayColumns_tab[index].field.indexOf("K0") > -1) {
                return;
            }
            var thId = randId + "_" + index;
            if ($("#" + thId).length > 0) {
                return;
            }
            $(strTh).eq(index).append("<select name='city'  xm-select='" + thId + "' xm-select-search  xm-select-type='2' class='gobk-select' lay-filter='one' id='" + thId + "'><option value=''>请选择</option></select>");
            var array_temp = new Array();
            for (var i = 0; i < data.length; i++) {
                //获取值
                var obj = data[i];
                //赋值
                if (obj.children.length == 0) {
                    array_temp[array_temp.length] = eval("obj." + pcitcReport.arrayColumns_tab[index].field);
                }
            }
            //去重
            array_temp = pcitcReport.unique(array_temp);
            //添加到checkbox,展示
            for (var i = 0; i < array_temp.length; i++) {
                if (array_temp[i] == "undefined" || typeof (array_temp[i]) == "undefined") {
                    continue;
                }
                $("#" + thId).append("<option  value=" + array_temp[i] + ">" + array_temp[i] + "</option>")
            }
            layui.config({
                base: '/layuiadmin/lib/extend/'
            }).extend({
                formSelects: 'formSelects-v3'
            }).use(['element', 'layer', 'form', 'treeGrid', 'element', 'formSelects'], function () {
                var treeGrid = layui.treeGrid; //很重要
                var element = layui.element;
                var formSelects = layui.formSelects;
                formSelects.render();
                $(".layui-select-title").next().find("dd").on("click", function () {
                    var spanLength = $(this).parent().prev().find("span").length;
                    var thId, selectVal = '', index;
                    for (var i = 0; i < spanLength; i++) {
                        selectVal += $(this).parent().prev().find("span").eq(i).attr("value") + ",";
                        thId = $(this).find("span").attr("lay-filter");
                        thId = thId.substring(3);
                        index = thId.substr(thId.length - 1, 1);
                    }
                    selectVal = selectVal.substring(0, selectVal.length - 1);
                    pcitcReport.showtable(index, thId, selectVal);
                })
            });
            array_temp = new Array();
        });
    }
    , changeTableId: function (data) {
        pcitcReport.strTableHeadId = new Date().getTime() + 2;
        $(".layui-table")[2].id = pcitcReport.strTableHeadId;

        var strTreeTableId = new Date().getTime() + 1;
        pcitcReport.strTableId = strTreeTableId;
        $(".layui-table")[3].id = strTreeTableId;
        // $("#" + strTreeTableId).rowspan(0);
        //添加点击事件
        //pcitcReport.clickThCheck(data);
    }
    , clearChecked: function () {//清空选择指标
        $("#barU li").not(":eq(0)").remove();
        $("#barD li").not(":eq(0)").remove();
        setSelectTips();
    }
    , getCheck: function () {//图表1赋值

        //获取日期
        pcitcReport.date = $("#dateRadio").val();
        //遍历a
        var links = document.getElementById("myTags").getElementsByTagName("a");
        pcitcReport.xfield = $("#xData").val();
        if (links.length > 0) {
            pcitcReport.strcolumns = "";
            pcitcReport.strcolumnsko = "";
            pcitcReport.strall = "";
            pcitcReport.strgroup = "";
        }
        for (var i = 0, j = links.length; i < j; i++) {
            var strtemp = links[i].getAttribute("value");
            var stype = links[i].getAttribute("type");
            if (strtemp == "G0GSDM" && typeof(stype) != "undefined") {
                pcitcReport.gsdm = stype;
            }
            pcitcReport.strall = (pcitcReport.strall == "") ? (strtemp) : (pcitcReport.strall + "," + strtemp);
            if (strtemp.indexOf("K0") > -1) {
                if (pcitcReport.strcolumnsko == "") {
                    pcitcReport.strcolumnsko = strtemp + ",";
                } else {
                    pcitcReport.strcolumnsko = pcitcReport.strcolumnsko + strtemp + ",";
                }
            } else {
                if (i == 0) {
                    pcitcReport.xfield = strtemp;
                }
                pcitcReport.strcolumns = (pcitcReport.strcolumns == "" ? (strtemp + ",") : (pcitcReport.strcolumns + strtemp + ","));
                pcitcReport.strgroup = (pcitcReport.strgroup == "" ? strtemp : (pcitcReport.strgroup + "," + strtemp));
            }
        }
        //判断空值
        if (links.length == 0) {
            alert("请选择内容或指标");
            return false;
        } else if (pcitcReport.strcolumns == "") {
            alert("请选择内容");
            return false;
        }
        // else if (pcitcReport.strcolumnsko == "") {
        //     alert("请选择指标");
        //     return false;
        // }
        else {
            pcitcReport.arrayColumns_tab = pcitcReport.arrayColumns_tab.slice(0, 0);
            var stemparrayColumns = [];
            var strColsArray = pcitcReport.strall.split(",");
            for (var i = 0; i < strColsArray.length; i++) {
                stemparrayColumns.push(eval(strColsArray[i].toUpperCase()));
            }
            pcitcReport.arrayColumns_tab = stemparrayColumns;

            //设置默认公司代码-开始
            var vals = layui.formSelects.value('select2', 'valStr');
            if (vals.length > 0) {
                pcitcReport.gsdm = vals;
            }
            return true;
        }
        //设置默认公司代码-结束
        //
        // var vals = [];
        // $('select[multiple] option:selected').each(function () {
        //     vals.push($(this).val());
        //     texts.push($(this).text());
        // });
        // console.dir(vals);
        // if (vals.length > 0) {
        //     pcitcReport.gsdm = vals.join(",");
        // }
        //设置默认公司代码-结束
    }
    , getCheck2: function () {//图表2赋值
        //获取日期
        pcitcReport.date = $("#dateRadio").val();
        //遍历a
        var links = document.getElementById("myTags").getElementsByTagName("a");
        if (links.length > 0) {
            pcitcReport.strcolumns = "";
            pcitcReport.strgroup = "";
            pcitcReport.strcolumnsko = "";
            pcitcReport.strall = "";
        }
        pcitcReport.xfield = $("#xData").val();
        pcitcReport.strall = pcitcReport.xfield;
        for (var i = 0, j = links.length; i < j; i++) {
            var strtemp = links[i].getAttribute("value");
            var stype = links[i].getAttribute("type");
            if (strtemp == "G0GSDM" && typeof(stype) != "undefined") {
                pcitcReport.gsdm = stype;
            }
            if (strtemp.indexOf("K0") > -1) {
                pcitcReport.strall = pcitcReport.strall + "," + strtemp;
                if (pcitcReport.strcolumnsko == "") {
                    pcitcReport.strcolumnsko = strtemp + ",";
                } else {
                    pcitcReport.strcolumnsko = pcitcReport.strcolumnsko + strtemp + ",";
                }
            } else {
                if (pcitcReport.strcolumns == "") {
                    pcitcReport.strcolumns = strtemp + ",";
                    pcitcReport.strgroup = strtemp;
                } else {
                    pcitcReport.strcolumns = pcitcReport.strcolumns + strtemp + ",";
                    pcitcReport.strgroup = pcitcReport.strgroup + "," + strtemp;
                }
            }
        }
        pcitcReport.strgroup = pcitcReport.xfield;
        pcitcReport.strcolumns = pcitcReport.xfield + ",";
        pcitcReport.arrayColumns_pic = pcitcReport.arrayColumns_pic.slice(0, 0);
        var stemparrayColumns = [];
        var strColsArray = pcitcReport.strall.split(",");
        for (var i = 0; i < strColsArray.length; i++) {
            stemparrayColumns.push(eval(strColsArray[i].toUpperCase()));
        }
        pcitcReport.arrayColumns_pic = stemparrayColumns;
        //设置默认公司代码
        if (pcitcReport.gsdm == "") {
            pcitcReport.gsdm = "1750";
        }
    }
    , getYData: function (obj) {//根据obj获取y轴data数组
        var array = new Array();
        var array_strcolumns = pcitcReport.strcolumnsko.split(",");
        for (var i = 0; i < array_strcolumns.length; i++) {
            if (array_strcolumns[i] != "") {
                array[i] = eval("obj." + array_strcolumns[i]);
            }
        }
        return array;
    }
    , upperJSONKey: function (jsonObj) {//转大写
        for (var key in jsonObj) {
            jsonObj["" + key.toUpperCase() + ""] = jsonObj[key];
            delete(jsonObj[key]);
        }
        return jsonObj;
    }
    , getNameByField: function (field) {//根据field获取名称
        var name = "";
        for (var i = 0; i < pcitcReport.arrayColumns_tab.length; i++) {
            if (pcitcReport.arrayColumns_tab[i].field.toUpperCase() == field) {
                name = pcitcReport.arrayColumns_tab[i].title;
                break;
            }
        }
        return name;
    }, initGsdm: function (gsdmcode, gsdmname) {
        //初始化公司代码
        var gsdm_html = "<option value=\"\"></option>";
        var gsdm_init = "";
        for (var i = 0; i < gsdmcode.length; i++) {
            gsdm_init = (gsdm_init == "" ? "" : (gsdm_init + ",")) + gsdmcode[i];
            gsdm_html = gsdm_html + "<option value='" + gsdmcode[i] + "'>" + gsdmname[i] + "</option>";
        }
        $("#gsdm_select").html(gsdm_html);
        pcitcReport.gsdm = gsdm_init;
    }, queryCon: function (obj) {
        var input = "<input type=\"text\"  id=\"xxxxx\" value=\"\">"
        for (var i = 0,l = obj.length; i < l; i++) {
            var type = obj[i].type;
            var desc = obj[i].desc;
            var field = obj[i].field;
            var htmlInput = input.replace("xxxxx",field);
            $("#inputHtml").append(htmlInput);
            console.log(htmlInput);
        }
    },getQueryval:function (obj) {
        console.log("getQueryval");
        console.log(obj);
        if(obj.length==0){
            return;
        }
        for (var i = 0,l = obj.length; i < l; i++) {
            var type = obj[i].type;
            var desc = obj[i].desc;
            var field = obj[i].field;
            if("input"==type&&$("#"+field).val()!==""){
                pcitcReport.strwhere += ' and '+field+'='+$("#"+field).val();
            }
            console.log(pcitcReport.strwhere);
        }
    }
    , drag: function () {//拖拽
        /*拖拽*/
        var fooU = document.getElementById("barU");
        Sortable.create(fooU, {bar: "omega"});
        var fooD = document.getElementById("barD");
        Sortable.create(fooD, {bar: "omega"});
    }
    , getExplorer: function () {//判断浏览器
        var explorer = window.navigator.userAgent;
        //ie
        if (explorer.indexOf("MSIE") >= 0) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if (explorer.indexOf("Chrome") >= 0) {
            return 'Chrome';
        }
        //Opera
        else if (explorer.indexOf("Opera") >= 0) {
            return 'Opera';
        }
        //Safari
        else if (explorer.indexOf("Safari") >= 0) {
            return 'Safari';
        }
    }
    , initTable2: function (tableData) {//初始化图表2
        for (var i = 0; i < tableData.length; i++) {
            tableData[i] = pcitcReport.upperJSONKey(tableData[i]);
        }
        var arrayx = new Array();
        var arrayy = [];
        var arrayydata = new Array();
        var arraylegenddata = new Array();
        var arraylegenddatacode = new Array();
        // var G0BK ={field:'G0BK', title:'板块', event: 'setActive',style:'cursor: pointer;'};
        //设置图例OK
        var array_strcolumns = pcitcReport.strcolumnsko.split(",");
        for (var i = 0; i < array_strcolumns.length; i++) {
            if (array_strcolumns[i].toUpperCase() != pcitcReport.xfield) {
                arraylegenddatacode[i] = array_strcolumns[i].toUpperCase();
                arraylegenddata[i] = pcitcReport.getNameByField(array_strcolumns[i]);
            }
        }
        //设置x轴
        var map_x = new Map();
        for (var i = 0; i < tableData.length; i++) {
            var obj = tableData[i];
            var x = eval("obj." + pcitcReport.xfield);
            arrayx[i] = x;
        }

        //遍历tableData
        var map_y = new Map();// (x,data)
        for (var i = 0; i < tableData.length; i++) {
            var obj = tableData[i];
            map_y.set(eval("obj." + pcitcReport.xfield), pcitcReport.getYData(obj));
        }

        //设置y轴-设置name,type,itemStyle
        for (var i = 0; i < arraylegenddata.length; i++) {
            var obj_y = {};
            obj_y.name = arraylegenddata[i];
            obj_y.type = "bar";
            obj_y.itemStyle = "itemStyle";
            var array_data = new Array();
            for (var j = 0; j < arrayx.length; j++) {
                array_data[j] = map_y.get(arrayx[j])[i];
            }
            obj_y.data = array_data;
            arrayy.push(obj_y);
        }
    }
    , exportTableToExcel: function () {//整个表格拷贝到EXCEL中
        var tableid = pcitcReport.strTableId;
        if (pcitcReport.getExplorer() == 'ie') {
            var curTbl = document.getElementById(tableid);
            var oXL = new ActiveXObject("Excel.Application");

            //创建AX对象excel
            var oWB = oXL.Workbooks.Add();
            //获取workbook对象
            var xlsheet = oWB.Worksheets(1);
            //激活当前sheet
            var sel = document.body.createTextRange();
            sel.moveToElementText(curTbl);
            //把表格中的内容移到TextRange中
            sel.select;
            //全选TextRange中内容
            sel.execCommand("Copy");
            //复制TextRange中内容
            xlsheet.Paste();
            //粘贴到活动的EXCEL中
            oXL.Visible = true;
            //设置excel可见属性
            try {
                var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
            } catch (e) {
                print("Nested catch caught " + e);
            } finally {
                oWB.SaveAs(fname);

                oWB.Close(savechanges = false);
                //xls.visible = false;
                oXL.Quit();
                oXL = null;
                //结束excel进程，退出完成
                //window.setInterval("Cleanup();",1);
                idTmr = window.setInterval("pcitcReport.Cleanup();", 1);
            }
        } else {
            tableToExcel(tableid)
        }
    }
    , Cleanup: function () {
        window.clearInterval(idTmr);
        CollectGarbage();
    }, unique: function (array) {//数组去重
        var res = [];
        var json = {};
        for (var i = 0; i < array.length; i++) {
            if (!json[array[i]]) {
                res.push(array[i]);
                json[array[i]] = 1;
            }
        }
        return res;
    }, getNowDateMonth: function () {
        var d = new Date;
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        pcitcReport.date = d.getFullYear() + "-" + month;
        // pcitcReport.date = d.getFullYear() + "-" + month + " 至 " + d.getFullYear() + "-" + month;
        return pcitcReport.date;
    }, setDefaultX: function () {
        if ($("#xData").val() == null) {
            $("#xData").append("<option value='" + pcitcReport.xfield + "'>" + eval(pcitcReport.xfield).title + "</option>");
        }
    }, createVar: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                window[key] = str[i][key];
            }
        }
    }, show_wd: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                $("#wd_show_obj_array").after("<li class=\"layui-nav-item\"><a value=\"" + key + "\" title=\"" + window[key].title + "\" href=\"javascript:void(0);\"><span>" + window[key].title + "</span></a></li>");
            }
        }
    }, hide_wd: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                $("#wd_hide_obj_array").append("<li class=\"layui-nav-item\"><a value=\"" + key + "\" title=\"" + window[key].title + "\" href=\"javascript:void(0);\"><span>" + window[key].title + "</span></a></li>");

            }
        }
    }, show_zb: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                $("#zb_show_obj_array").after("<li class=\"layui-nav-item\"><a value=\"" + key + "\" title=\"" + window[key].title + "\" href=\"javascript:void(0);\"><span>" + window[key].title + "</span></a></li>");
            }
        }
    }, hide_zb: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                $("#zb_hide_obj_array").append("<li class=\"layui-nav-item\"><a value=\"" + key + "\" title=\"" + window[key].title + "\" href=\"javascript:void(0);\"><span>" + window[key].title + "</span></a></li>");

            }
        }
    }, x_default: function (str) {
        for (var i = 0; i < str.length; i++) {
            for (var key in str[i]) {
                pcitcReport.xfield = key;
                pcitcReport.arrayColumns_pic.push(eval(key));
            }
        }
    }, list_default: function (default_wd_zb_obj_array) {
        for (var i = 0; i < default_wd_zb_obj_array.length; i++) {
            for (var key in default_wd_zb_obj_array[i]) {
                if (default_wd_zb_obj_array[i][key] == "0") {
                    pcitcReport.arrayColumns_tab.push(eval(key));
                    //维度
                    pcitcReport.strcolumns = (pcitcReport.strcolumns == "" ? key : (pcitcReport.strcolumns + "," + key));
                    pcitcReport.strgroup = (pcitcReport.strgroup == "" ? key : (pcitcReport.strgroup + "," + key));
                } else {
                    //指标
                    pcitcReport.strcolumnsko = (pcitcReport.strcolumnsko == "" ? key : (pcitcReport.strcolumnsko + "," + key));
                    pcitcReport.arrayColumns_tab.push(eval(key));
                    pcitcReport.arrayColumns_pic.push(eval(key));
                }
            }
            if (i == (default_wd_zb_obj_array.length - 1)) {
                pcitcReport.strcolumns = pcitcReport.strcolumns + ",";
            }
        }
    }, field_default: function (default_column_obj_array) {
        pcitcReport.gsdm = "1750";
        for (var i = 0; i < default_column_obj_array.length; i++) {
            for (var key in default_column_obj_array[i]) {
                //将字段存入数组
                // window[key]=JSON.stringify(default_column_obj_array[i][key]);
            }
        }
    }, getMxList: function () {//获取模型信息
        $.ajax({
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify({reportConfig: {}}),
            dataType: 'json',
            async: false,
            url: '/reportConfig/list',
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    if (data[i].status == "2") {
                        html = html + "<dd><a href=\"javascript:pcitcReport.tzModel('" + data[i].id + "');\">" + data[i].name + "</a></dd>";
                    }
                }
                $("#mxlit").append(html);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }, tzModel: function (id) {
        // if (id == "164f98a6b8c_c4effcc1" || id == "16522f9483f_9cad751f" || id == "16541611496_d5d8fc79") {
        //     window.location.href = "/report/reportPage?name=" + id;
        // } else {
        window.location.href = "/reportNew/reportPageStp?name=" + id;
        // }
    }, initTable: function (xx) {
        pcitcReport.xfield = $("#xData").val();
        for (var i = 0; i < xx.length; i++) {
            xx[i] = pcitcReport.upperJSONKey(xx[i]);
        }
        var arrayx = new Array();
        var arrayy = [];
        var arrayydata = new Array();
        var arraylegenddata = new Array();
        var arraylegenddatacode = new Array();
        //设置图例OK
        var array_strcolumns = pcitcReport.strcolumnsko.split(",");
        for (var i = 0; i < array_strcolumns.length; i++) {
            if (array_strcolumns[i].toUpperCase() != pcitcReport.xfield.toUpperCase()) {
                arraylegenddatacode[i] = array_strcolumns[i].toUpperCase();
                arraylegenddata[i] = pcitcReport.getNameByField(array_strcolumns[i]);
            }
        }
        //设置x轴
        var map_x = new Map();
        for (var i = 0; i < xx.length; i++) {
            var obj = xx[i];
            var x = eval("obj." + pcitcReport.xfield);
            // console.log("------------------x-------"+x);
            if (typeof (x) == "undefined") {
                arrayx[i] = "空";
            } else {
                arrayx[i] = x;
            }
        }

        //遍历tableData
        var map_y = new Map();// (x,data)
        for (var i = 0; i < xx.length; i++) {
            var obj = xx[i];
            var x = eval("obj." + pcitcReport.xfield);
            if (typeof (x) == "undefined") {
                map_y.set("空", pcitcReport.getYData(obj));
            } else {
                map_y.set(x, pcitcReport.getYData(obj));
            }

        }

        //设置y轴-设置name,type,itemStyle
        for (var i = 0; i < arraylegenddata.length; i++) {
            var obj_y = {};
            obj_y.name = arraylegenddata[i];
            obj_y.type = "bar";
            obj_y.itemStyle = "itemStyle";
            obj_y.barWidth = "20";
            var array_data = new Array();
            for (var j = 0; j < arrayx.length; j++) {
                array_data[j] = map_y.get(arrayx[j])[i];
            }
            obj_y.data = array_data;
            arrayy.push(obj_y);
        }
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            title: {
                text: '',
                subtext: ''
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: arraylegenddata
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: arrayx
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: arrayy
        };
        myChart.setOption(option);
    },
    calTableWidth: function () {//计算table宽度
        var len = pcitcReport.arrayColumns_tab.length;
        var width = (100) / (len + 1);
        var cha = 0;
        for (var i = 0; i < len; i++) {
            if (i == 0) {
                pcitcReport.arrayColumns_tab[0].width = width * 2 + "%";
            } else {
                pcitcReport.arrayColumns_tab[i].width = width + "%";
            }
        }
    },
    initTableView: function () {

    },
    setStoreExt: function () {//设置收藏之后其他页面dom操作
        $("#xData").val(pcitcReport.xfield);
    },
    isGetStoreData: function () {//是否获取收藏数据
        pcitcReport.isCollect = isIndexFlag;
        return pcitcReport.isCollect;
    },
    getStoreModel: function (flag) {//ajax获取收藏内容,赋值
        //ajax查询
        if (!pcitcReport.isGetStoreData()) {
            return;
        }
        var data = new Array();
        $.ajax({
            type: 'post',
            // contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: {configId: pcitcReport.strNameType, id: stroreId},
            async: false,
            url: '/reportStore/listParamByUserIdStp',
            success: function (json) {
                if (json.length == 0) {
                    return;
                }
                data = json[json.length - 1].json;
            },
            error: function (e) {
                console.log(e);
            }
        });
        //赋值
        //赋值到storeToValue
        if (data.length == 0) {
            return;
        }
        // return;
        var k12 = JSON.parse(data);
        // if (flag == "2") {
        //     this.storeToValue("2");
        // } else {
        //     this.storeToValue("1");
        // }

        if (flag == "2") {
            pcitcReport.k2 = k12.k2;
            pcitcReport.xfield = pcitcReport.k2.column;
            pcitcReport.strcolumnsko = pcitcReport.k2.columnko;
            pcitcReport.strall = pcitcReport.k2.strall;
            pcitcReport.xfield = pcitcReport.k2.group;
            pcitcReport.strwhere = pcitcReport.k2.where;
            // pcitcReport.k2.date =pcitcReport.date.replace("至", "`");
            pcitcReport.gsdm = pcitcReport.k2.gsdm;
            pcitcReport.strNameType = pcitcReport.k2.strNameType;
            pcitcReport.arrayColumns_pic = pcitcReport.k2.arrayColumns_pic;
            //修改下拉
            // $("#xData").empty();
            // $("#xData").append("<option value='" + pcitcReport.xfield + "'>" + eval(pcitcReport.xfield).title + "</option>");
        } else {
            pcitcReport.k1 = k12.k1;
            pcitcReport.strcolumns = pcitcReport.k1.column;
            pcitcReport.strcolumnsko = pcitcReport.k1.columnko;
            pcitcReport.strall = pcitcReport.k1.strall;
            pcitcReport.strgroup = pcitcReport.k1.group;
            pcitcReport.strwhere = pcitcReport.k1.where;
            // pcitcReport.k2.date =pcitcReport.date.replace("至", "`");
            pcitcReport.gsdm = pcitcReport.k1.gsdm;
            pcitcReport.strNameType = pcitcReport.k1.strNameType;
            pcitcReport.arrayColumns_tab = pcitcReport.k1.arrayColumns_tab;
        }
    },
    storeToValue: function (flag) {//赋值
        //table初始化之前------>赋值
        // reload之前------>赋值
        if (flag == "2") {
            pcitcReport.k2.column = pcitcReport.xfield;
            pcitcReport.k2.columnko = pcitcReport.strcolumnsko;
            pcitcReport.k2.strall = pcitcReport.strall;
            pcitcReport.k2.group = pcitcReport.xfield;
            pcitcReport.k2.where = pcitcReport.strwhere;
            // pcitcReport.k2.date =pcitcReport.date.replace("至", "`");
            pcitcReport.k2.gsdm = pcitcReport.gsdm;
            pcitcReport.k2.strNameType = pcitcReport.strNameType;
            pcitcReport.k2.arrayColumns_pic = pcitcReport.arrayColumns_pic;
        } else {
            pcitcReport.k1.column = pcitcReport.strcolumns;
            pcitcReport.k1.columnko = pcitcReport.strcolumnsko;
            pcitcReport.k1.strall = pcitcReport.strall;
            pcitcReport.k1.group = pcitcReport.strgroup;
            pcitcReport.k1.where = pcitcReport.strwhere;
            // pcitcReport.k1.date =pcitcReport.date.replace("至", "`");
            pcitcReport.k1.gsdm = pcitcReport.gsdm;
            pcitcReport.k1.strNameType = pcitcReport.strNameType;
            pcitcReport.k1.arrayColumns_tab = pcitcReport.arrayColumns_tab;
        }
    }
    ,
    storeModel: function () {//收藏保存
        //ajax保存
        var param = {};
        param.k1 = pcitcReport.k1;
        param.k2 = pcitcReport.k2;
        console.log("--------------param-------------");
        var storeName = $(".layui-layer #storeName").val();//名称
        if ($.isEmptyObject(param.k1)) {
            alert("请选择指标和维度,点击'查询'获取搜索结果之后收藏");
            return false;
        } else if (storeName == "") {
            layui.use(['element', 'layer', 'form', 'treeGrid', 'element', 'formSelects'], function () {
                // alert(storeName)
                layer.msg('请输入收藏名称');
            })

            return false;
        } else {
            $.ajax({
                type: 'post',
                // contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({modelId: pcitcReport.strNameType, json: param}),
                dataType: 'json',
                async: false,
                url: '/reportStore/saveReportStoreByUserStp?json=' + encodeURIComponent(JSON.stringify(param)) + "&modelConfigId=" + pcitcReport.strNameType + "&bak4=" + storeName,
                success: function (xx) {
                    alert("操作成功");
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    },
    setExt: function () {
        console.log("setExt");
        $("#stp_table_title").html(pcitcReport.date.replace("-", "年") + "月" + pcitcReport.tableTitle.config.name);
    },
    getStoreModelList: function () {//ajax获取收藏内容
        $.ajax({
            type: 'post',
            // contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: {configId: pcitcReport.strNameType},
            async: false,
            url: '/reportStore/listParamByUserIdStp',
            success: function (data) {
                console.log("收藏下拉");
                console.log(data);
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html = html + "<dd><a href=\"javascript:pcitcReport.tzStore('" + data[i].modelConfigId + "','" + data[i].id + "');\">" + data[i].bak4 + "</a></dd>";
                }
                if (html == "") {
                    html = "<dd><a>无数据</a></dd>";
                }
                $("#mxstorelist").append(html);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }, tzStore: function (configId, storeId) {
        window.location.href = "/reportNew/reportPageStp?name=" + configId + "&storeId=" + storeId;
    }
}

function changePic() {
    console.log("changePic");
    pcitcReport.arrayColumns_pic = pcitcReport.arrayColumns_pic.slice(0, 0);
    pcitcReport.getCheck2();
    pcitcReport.storeToValue('2');//收藏赋值
    paramFun();
}

function paramFun() {
    console.log("paramFun");
    pcitcReport.getStoreModel('2');
    var param = {};
    param.column = pcitcReport.xfield + ",";
    param.columnko = pcitcReport.strcolumnsko;
    param.strall = pcitcReport.strall;
    param.group = pcitcReport.xfield;
    param.where = pcitcReport.strwhere;
    param.date = pcitcReport.date.replace("至", "`");
    param.gsdm = pcitcReport.gsdm;
    param.name = pcitcReport.strNameType;
    // $.ajax({
    //     type: 'post',
    //     contentType: 'application/json;charset=utf-8',
    //     dataType: 'json',
    //     async: false,
    //     url: '/reportNew/getTableReportPic?param=' + encodeURIComponent(JSON.stringify(param)),
    //     success: function (xx) {
    //         initTable(JSON.stringify(xx.data));
    //     },
    //     error: function (e) {
    //         console.log(e);
    //     }
    // });
}

function initTable(sdata) {
    pcitcReport.xfield = $("#xData").val();
    for (var i = 0; i < JSON.parse(sdata).length; i++) {
        JSON.parse(sdata)[i] = pcitcReport.upperJSONKey(JSON.parse(sdata)[i]);
    }
    var arrayx = new Array();
    var arrayy = [];
    var arrayydata = new Array();
    var arraylegenddata = new Array();
    var arraylegenddatacode = new Array();
    //设置图例OK
    var array_strcolumns = pcitcReport.strcolumnsko.split(",");
    for (var i = 0; i < array_strcolumns.length; i++) {
        if (array_strcolumns[i].toUpperCase() != pcitcReport.xfield.toUpperCase()) {
            arraylegenddatacode[i] = array_strcolumns[i].toUpperCase();
            arraylegenddata[i] = pcitcReport.getNameByField(array_strcolumns[i]);
        }
    }
    //设置x轴
    var map_x = new Map();
    for (var i = 0; i < JSON.parse(sdata).length; i++) {
        var obj = JSON.parse(sdata)[i];
        var x = eval("obj." + pcitcReport.xfield);
        if (typeof (x) == "undefined") {
            arrayx[i] = "空";
        } else {
            arrayx[i] = x;
        }
    }

    //遍历tableData
    var map_y = new Map();// (x,data)
    for (var i = 0; i < JSON.parse(sdata).length; i++) {
        var obj = JSON.parse(sdata)[i];
        var x = eval("obj." + pcitcReport.xfield);
        if (typeof (x) == "undefined") {
            map_y.set("空", pcitcReport.getYData(obj));
        } else {
            map_y.set(x, pcitcReport.getYData(obj));
        }

    }

    //设置y轴-设置name,type,itemStyle
    for (var i = 0; i < arraylegenddata.length; i++) {
        var obj_y = {};
        obj_y.name = arraylegenddata[i];
        obj_y.type = "bar";
        obj_y.itemStyle = "itemStyle";
        obj_y.barWidth = "20";
        var array_data = new Array();
        for (var j = 0; j < arrayx.length; j++) {
            array_data[j] = map_y.get(arrayx[j])[i];
        }
        obj_y.data = array_data;
        arrayy.push(obj_y);
    }
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: '',
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            // data: ['科目余额']
            data: arraylegenddata

        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                // data: ['1750']
                data: arrayx
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        // series: [{name: '科目余额', type: "bar", itemStyle: "itemStyle", barWidth: "20", data: [3333]}]
        series: arrayy
    };
    myChart.setOption(option);
    document.getElementById('main').style.height = "300%";
    //重置容器高宽
    myChart.resize();
}

//列合并
$.fn.rowspan = function (combined) {
    return this.each(function () {
        var that;
        $('tr', this).each(function (row) {
            $('td:eq(' + combined + ')', this).filter(':hidden').each(function (col) {
                // $('td:eq('+combined+')', this).filter(':visible').each(function(col) {
                if (that != null && $(this).html() == $(that).html()) {
                    rowspan = $(that).attr("rowSpan");
                    if (rowspan == undefined) {
                        $(that).attr("rowSpan", 1);
                        rowspan = $(that).attr("rowSpan");
                    }
                    rowspan = Number(rowspan) + 1;
                    $(that).attr("rowSpan", rowspan);
                    $(this).hide();
                } else {
                    that = this;
                }
            });
            $('td:eq(' + combined + ')', this).filter(':visible').each(function (col) {
                // $('td:eq('+combined+')', this).filter(':visible').each(function(col) {
                if (that != null && $(this).html() == $(that).html()) {
                    rowspan = $(that).attr("rowSpan");
                    if (rowspan == undefined) {
                        $(that).attr("rowSpan", 1);
                        rowspan = $(that).attr("rowSpan");
                    }
                    rowspan = Number(rowspan) + 1;
                    $(that).attr("rowSpan", rowspan);
                    $(this).hide();
                } else {
                    that = this;
                }
            });
        });
    });
};
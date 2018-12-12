//id div 的id，isMultiple 是否多选，chkboxType 多选框类型{"Y": "ps", "N": "s"} 详细请看ztree官网
var selectTree;
function initSelectTree(id, isMultiple, isShowLine, isShowIcon, chkboxType) {
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: false,
            chkboxType: {"Y": "ps", "N": "s"}
        },
        callback: {
            onClick: onClick,
            onCheck: onCheck
        },
        view: {
            showLine: isShowLine,
            showIcon: isShowIcon
        }

    };
    if (isMultiple) {
        setting.check.enable = isMultiple;
    }
    if (chkboxType !== undefined && chkboxType != null) {
        setting.check.chkboxType = chkboxType;
    }
    var html = '<div class = "layui-select-title" >' +
        '<input id="' + id + 'Show" type = "text" placeholder = "请选择"  value = ""  lay-verify="'+id+'" class = "layui-input" readonly>' +
        '<i class= "layui-edge" ></i>' +
        '</div>';
    $("#" + id).append(html);
    $("#" + id).parent().append('<div class="tree-content scrollbar">' +
    	'<input hidden id="' + id + '"' + 'name="' + id + '">' +
    	'<input hidden id="' + id + 'Value" ' + 'name="' + id + 'Value">' +
        '<input hidden id="' + id + 'Code" ' + 'name="' + id + 'Code">' +
        '<input hidden id="' + id + 'Type" ' + 'name="' + id + 'Type">' +
        '<input hidden id="' + id + 'Url" ' + 'name="' + id + 'Url">' +
        '<input hidden id="' + id + 'Name" ' + 'name="' + id + 'Name">' +
        '<input hidden id="' + id + 'Save" ' + 'name="' + id + 'Save">' +
        '<input hidden id="' + id + 'Show" ' + 'name="' + id + 'Show">' +
        '<ul id="' + id + 'Tree" class="ztree"></ul>' +
        '</div>');
    $("#" + id).bind("click", function () {
        $(".layui-unselect").removeClass("layui-form-selected");
        if ($(this).parent().find(".tree-content").css("display") !== "none") {
            // hideMenu()
        } else {
            $(this).addClass("layui-form-selected");
            var Offset = $(this).offset();
            var width = $(this).width() - 2;
            if(Offset.top > 300){
                $(this).parent().find(".tree-content").css({
                    left: 0 + "px",
                    bottom: $(this).height() + "px"
                }).slideDown("fast");
            }else{
                $(this).parent().find(".tree-content").css({
                    left: 0 + "px",
                    top: $(this).height() + "px"
                }).slideDown("fast");
            }

            $(this).parent().find(".tree-content").css({
                width: width
            });
            $("body").bind("mousedown", onBodyDown);
        }
    });
    selectTree = $.fn.zTree.init($("#" + id + "Tree"), setting, zNodes);
    selectTree.expandAll(true);
    return selectTree;
}

function onClick(event, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    if (zTree.setting.check.enable == true) {
        zTree.checkNode(treeNode, !treeNode.checked, false)
        assignment(treeId, zTree.getCheckedNodes());
    } else {
        assignment(treeId, zTree.getSelectedNodes());
        hideMenu();
    }
    //如果是级联岗位
    if(treeId=="userUnitTree"){
    	initPostData(zTree.getCheckedNodes(true));
    }
    //机具报验退场 联动单项工程联动
    if(treeId=="wbsTree"){
    	$("input[name=wbsCode]").val(treeNode.code);
    	$("input[name=wbsName]").val(treeNode.name);
    	$("input[name=wbsId]").val(treeNode.id);
    	refreshTable(treeNode.id);
    }
}

function onCheck(event, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    assignment(treeId, zTree.getCheckedNodes());
    //如果是级联岗位
    if(treeId=="userUnitTree"){
    	initPostData(zTree.getCheckedNodes(true));
    }
}

function hideMenu() {
    $(".select-tree").removeClass("layui-form-selected");
    $(".tree-content").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}

function initHideMenu() {
    $(".select-tree").removeClass("layui-form-selected");
    $(".tree-content").hide();
}

function assignment(treeId, nodes) {
    var names = "";
    var ids = "";
    var codes = "";
    var types = "";
    var urls = "";    // 系统菜单树中的菜单节点url
    for (var i = 0, l = nodes.length; i < l; i++) {
        console.log("-------"+nodes[i].treeUrl+"-------"+nodes[i].name+"-------"+nodes[i].id);
        //if(nodes[i].isParent!=true){
            names += nodes[i].name + ",";
            ids += nodes[i].id + ",";
            codes += nodes[i].code + ",";
            types += nodes[i].nodeType + ",";
            urls += nodes[i].treeUrl + ",";
        //}
    }
    console.log("1-------"+names);
    if (names.length > 0) {
        names = names.substring(0, names.length - 1);
        ids = ids.substring(0, ids.length - 1);
        types = types.substring(0, types.length - 1);
        codes = codes.substring(0, codes.length - 1);
        urls = urls.substring(0, urls.length - 1);
    }
    treeId = treeId.substring(0, treeId.length - 4);
    console.log("2-------"+names);
    if(names){
        $("#" + treeId + "Show").attr("value", names);
        $("#" + treeId + "Show").attr("title", names);
        $("#" + treeId + "Name").attr("value", names);
    }
    if(types){
        $("#" + treeId + "Type").attr("value", types);
    }
    if(codes){
        $("#" + treeId + "Code").attr("value", codes);
    }
    if(urls){
        $("#" + treeId + "Url").attr("value", urls);
    }
    $("#" + treeId + "Value").attr("value", ids);
    $("#" + treeId ).attr("value", ids);
    $("input[name='"+treeId+"']").attr("value", ids);
}
function onBodyDown(event) {
    if ($(event.target).parents(".tree-content").html() == null) {
        hideMenu();
    }
}
/**
 * 动态创建节点
 * @param id
 * @param pId
 * @param name
 * @returns
 */
function zTreeNode(id,pId,name)
{
	this.id = id;
	this.pId = pId;
	this.name = name;
}
function autoCheck(id,arry)
{
    var zTree = $.fn.zTree.getZTreeObj(id);
    var nodes = zTree.getNodes();
    // console.log(nodes)
    // console.log(zNodes)
    // console.log(arry)
    $.each(zNodes,function(i,n)
    {
        if ($.inArray(n.id, arry) > -1) {
            // alert(n.id)
            var node = zTree.getNodeByParam("id",n.id);
            // zTree.selectNode(node);
            zTree.checkNode(node, true, true);
        }
    });
    assignment(id, zTree.getCheckedNodes());
}
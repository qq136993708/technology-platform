var zNodes,treeId,treeName,temTypeId,temTypeCode,temTypeName,temFunUrl='',selectRowData='',active;
/*技术族树*/
$(function() {
    $.ajax({
        url: "/techFamily-api/getTreeNodeList?parentId=10&isCloudParentId=1",//这个就是请求地址对应sAjaxSource
        type : 'get',
        headers: {'Content-Type' : 'application/json'},
        dataType : 'json',
        async : false,
        success : function(data){
            zNodes = data;
        },
        error : function(msg) {
            layer.msg(msg);
        }
    });
});
/*设置setting*/
var temUrl = '/techFamily-api/getTreeNodeListByParntId';
var setting = {
    // 异步动态加载
    async: {
        enable : true,
        url : temUrl,
        dataType :'json',
        type : 'get',
        //异步查询时，把节点code传递后台，查询此节点下的节点。
        autoParam:["id"]
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    view:{
        showIcon: false
    },
    callback : {//请求成功后回调
        onClick : onClickMenu,//点击相关节点触发的事件
        onAsyncSuccess : ztreeOnAsyncSuccess,//异步加载成功后执行的方法
    }
};

//获取树成功后进行的回调操作。数据如果需要二次加工的话，调用此方法
function ztreeOnAsyncSuccess(event, treeId, treeNode) {

};
function ztreeAsyncChildNodes() {
    var zTree = $.fn.zTree.getZTreeObj("showTree");
    var type = "refresh";
    var silent = false;
    nodes = zTree.getSelectedNodes();
    if (nodes.length == 0) {
        alert("请先选择一个父节点");
    }
    for (var i=0, l=nodes.length; i<l; i++) {
        zTree.reAsyncChildNodes(nodes[i], type, silent);
        if (!silent) zTree.selectNode(nodes[i]);
    }
};

// 点击树节点时，处理变量和右侧表格
function onClickMenu(event,treeId,treeNode,clickFlag) {
    console.log(treeNode)
    treeId = treeNode.id;
    treeName = treeNode.name;
    temTypeCode = treeNode.code;
    temTypeId = treeNode.id;
    temTypeName = treeNode.name;
    temFunUrl = treeNode.treeUrl;
    $('#nodePath').val(treeNode.nodePath);
    active.searchEventNew();
}

$(document).ready(function () {
    $.fn.zTree.init($("#showTree"), setting, zNodes);
});
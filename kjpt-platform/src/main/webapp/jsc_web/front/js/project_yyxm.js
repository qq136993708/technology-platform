var setting = {
	view: {
		showLine: false,
		showIcon: false,
		expandAll:false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: zTreeOnClick
	}
};
function zTreeOnClick(event, treeId, treeNode) {
	loadTableDat(treeNode.name);
};
function loadTableDat(name){
	//科技成果列表
	$("#xmqd_tbody").html('');
	var html='';
	for(var v in jzjcg_data1){
		html+='<tr><td>'+jzjcg_data1[v].val1+'</td>';
		html+='<td>'+jzjcg_data1[v].val2+'</td>';
		html+='<td>'+jzjcg_data1[v].val4+'</td>';
		html+='<td>'+name+'</td>';
		html+='<td>'+jzjcg_data1[v].val5+'</td>';
		html+='<td>'+jzjcg_data1[v].val6+'</td>';
		html+='<td>'+jzjcg_data1[v].val6+'</td>';
		html+='<td>'+jzjcg_data1[v].val6+'</td>';
		html+='<td>'+jzjcg_data1[v].val6+'</td>';
		html+='<td>'+jzjcg_data1[v].val7+'</td></tr>';
	}
	$("#xmqd_tbody").append(html);
}
var zNodes =[
	{ id:1, pId:0, name:"父节点1 - 展开", open:true},
	{ id:11, pId:1, name:"父节点11 - 折叠"},
	{ id:111, pId:11, name:"叶子节点111"},
	{ id:112, pId:11, name:"叶子节点112"},
	{ id:113, pId:11, name:"叶子节点113"},
	{ id:114, pId:11, name:"叶子节点114"},
	{ id:121, pId:11, name:"叶子节点121"},
	{ id:122, pId:11, name:"叶子节点122"},
	{ id:123, pId:11, name:"叶子节点123"},
	{ id:124, pId:11, name:"叶子节点124"}
];

$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, fx_tree_data);
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	treeObj.expandAll(true);
	// loadTableDat('单位');
	$(".check_query .query").on("click", function(){
		$(this).siblings().removeClass("qActive");
		$(this).addClass("qActive");
		$("#check_date").val()
	});
});
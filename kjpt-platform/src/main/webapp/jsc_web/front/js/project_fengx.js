var setting = {
	view: {
		showLine: false,
		showIcon: false
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
	// // alert(treeNode.tId + ", " + treeNode.name);
	loadTableDat(treeNode.name);
};
function loadTableDat(name){
	//清空数据
	$("#fx_tbody").html('');
	var html='';
	console.log(fx_table_data);
	for(var v in fx_table_data){
		html+='<tr><td>'+name + '-' +fx_table_data[v].val1+'</td>';
		html+='<td>'+fx_table_data[v].val2+'</td>';
		html+='<td>'+fx_table_data[v].val3+'</td>';
		html+='<td>'+fx_table_data[v].val4+'</td>';
		html+='<td>'+fx_table_data[v].val6+'</td></tr>';
	}
	$("#fx_tbody").append(html);
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
	loadTableDat('');
	$(".check_query .query").on("click", function(){
		$(this).siblings().removeClass("qActive");
		$(this).addClass("qActive");
		$("#check_date").val()
	});
});
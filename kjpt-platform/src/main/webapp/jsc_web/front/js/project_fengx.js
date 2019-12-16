var setting = {
	view: {
		showLine: false
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

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
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
function setTreeData(data, id) {
	var temp_tree = [], nodeId = (id || '10');
	for (var i=0; i< data.length; i++) {
		if (data[i].pId == nodeId) {
			var nodeJson = {
					orgin: {},
					name: data[i].name,
					id:  data[i].id,
					children: [],
					open: false
				}
			if (nodeId == 10) {
				nodeJson.open = true;
			}
			for (var key in data[i]) {
				if (key !== 'childNodes') {
					nodeJson.orgin[key] = data[i][key];					
				}
			}
			nodeJson.children = setTreeData(data, data[i].id);
			if (nodeJson.children.length == 0) {
				delete nodeJson.children;
			}
			temp_tree.push(nodeJson);
		}
	}
	
	return temp_tree;
}

layui.use(['table', 'laypage'], function() {
	var table = layui.table,
	laypage = layui.laypage,
	selectedUnitId = '',
	tablePage = { page: 1, limit: 10 },
	treeSetting = {
		view: { selectedMulti: true },
		check: { enable: false, chkStyle: 'radios'},
	    callback: {
	    	onClick: function(e, id, data) {
	    		selectedUnitId = data.id;
	    		getTableData({page: tablePage.page, limit: tablePage.limit, userUnit: data.id })
	    	}
	    }
	};
	
	table.render({
	  elem: '#tableDemo',
	  id: 'tableDemo',
	  height: 432,
	  cols: [[ {
	          title: '名称',
	          field: 'userDisp',
	          width: 120
	      }, {
	          field: 'userName',
	          title: '账号'
	      }, {
	          field: 'userUnitName',
	          title: '所属机构'
	      },  {
	    	  field: 'userMail',
	          title: '邮箱'
	      }
	  ]],
	  data: [],
	  page: false
	});
	
	function getTableData(searchData) {
		var strurl = '/user-tmp-api/page?', temp_str = '';
		for (var key in searchData) {
			temp_str += '&'+key+'=' + searchData[key];
		}
		temp_str  = temp_str.substring(1);
		httpModule({
			url: strurl + temp_str, //数据接口
			type: 'post',
			data: {},
			success: function(res) {
				console.log(res.data);
				table.reload('tableDemo', { data: res.data || [] });
				setTablePage(searchData.page, res.count);
			}
		})
	}
	function setTablePage(page, total) {
		laypage.render({
		    elem: 'table-page-layout' //注意，这里的 test1 是 ID，不用加 # 号
		    ,count: (total || 0) //数据总数，从服务端得到
		    ,limit: 10
		    ,limits: [5, 10, 15, 20]
		    ,curr: (page || 1)
		    ,groups: 3
		    ,layout: ['count', 'prev', 'page', 'next', 'limit']
		    ,jump: function(obj, first) {
		    	if (!first) {
		    		getTableData({page: obj.curr, limit: obj.limit, userUnit: selectedUnitId })
		    	}
		    }
		 });
	}
	
	
	httpModule({
		url: '/user-tmp-api/getOrgTreeNodeList',
		success: function(data) {
			if (data && typeof(data) == 'object' && data.length) {
				zTreeObj = $.fn.zTree.init($("#unitTree"), treeSetting, setTreeData(data));	
			}
		}
	});
	
	getTableData({page: 1, limit: 10, userUnit: ''})
})



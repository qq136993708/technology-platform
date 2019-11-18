//Demo
layui.use(['form', 'table', 'layer', 'element'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var element = layui.element;
  form.render(); //更新全部

  table.render({
    elem: '#tableProject'
    // ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '序号' }
      ,{field: 'id', title: '项目名称', sort: true }
      ,{field: 'sex', title: '负责单位', sort: true}
      ,{field: 'city', title: '专业类型'} 
      ,{field: 'sign', title: '立项年度'}
    ]],
    parseData: function(res) { return layuiParseData(res, null, 3); }
  });

  table.render({
    elem: '#leadingFigure'
    // ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '名称' }
      ,{field: 'id', title: '担任职务', sort: true }
      ,{field: 'sex', title: '技术职称', sort: true}
      ,{field: 'city', title: '工作单位'} 
      ,{field: 'sign', title: '专业'}
    ]],
    parseData: function(res) { return layuiParseData(res, null, 3); }
  });
  
  table.render({
    elem: '#tablePaper'
    // ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '论文题目' }
      ,{field: 'id', title: '级别', sort: true }
      ,{field: 'sex', title: '期刊名称', sort: true}
      ,{field: 'city', title: '作者'} 
      ,{field: 'sign', title: '年度'}
    ]],
    parseData: function(res) { return layuiParseData(res, null, 3); }
  });

  table.render({
    elem: '#teamMembers'
    // ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '姓名' }
      ,{field: 'id', title: '年龄', sort: true }
      ,{field: 'sex', title: '学历', sort: true}
      ,{field: 'city', title: '技术职称'} 
      ,{field: 'sign', title: '毕业学校'}
      ,{field: 'classify', title: '所学专业'}
      ,{field: 'wealth', title: '岗位名称'} 
    ]],
    parseData: function(res) { return layuiParseData(res, null, 3); }
  });

  table.render({
    elem: '#mainAchievements'
    // ,height: 382
    ,url: '/data/datalist.json' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {type: 'radio', field: 'id'}
      ,{field: 'username', title: '序号' }
      ,{field: 'id', title: '成果名称', sort: true }
      ,{field: 'sex', title: '申请单位', sort: true}
      ,{field: 'city', title: '成果类型'} 
      ,{field: 'sign', title: '申请年度'}
    ]],
    parseData: function(res) { return layuiParseData(res, null, 3); }
  });

  // 监听tab切换事件
//  element.on('tab(gjj_kyxq)', function(e) {
//	  table.render();
//  })
  
  var layer = layui.layer;

  // 新增
  $('.addItem').on('click', function(e) {
    top.layer.open({
      type: 2,
      title: '添加科研项目',
      area: ['780px', '520px'],
      content: '/html/scientificPlatform/addKY_project.html?id='+e.target.dataset.id,
      btn: null
    });
    
  })
  
  // 新增确定提交
  form.on('submit(projectSubmit)', function(data){
    console.log(data);
    return false;
  })
  

  // 编辑
  $('#editItem').on('click', function(e) {
    if (itemRowID) {
      
    } else {

    }
  })

  // 关闭全部弹窗
  $('.close-dialog').click(function() {
    layer.closeAll();
  })
  
});
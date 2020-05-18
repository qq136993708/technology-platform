layui.use(['element', 'form', 'jquery','table','upload'], function(){
  var element = layui.element,$ = layui.jquery, form = layui.form, table = layui.table,upload=layui.upload;
  var itemRowData=''
  /*公共方法*/
  var obj={
      layerOpen:function (title,id) {
          var index=parent.$("#LAY_app_body div.layui-show").index()-1;
          if(id==undefined){
              var url="/kjpt/expert/expert_add.html?index="+index
              parent.layui.index.openTabsPage(url, title);
          }else {
              var url="/kjpt/expert/expert_add.html?id="+id+"&index="+index
              parent.layui.index.openTabsPage(url, title);
          }
      },
      tableList:function (where) {
          /*列表展示*/
          table.render({
              elem: '#expertTable' // 表格元素ID
              ,url: '/expert-api/list' //数据接口
              ,cols: [[ //表头
                  {type: 'radio' },
                  {field: 'year', title: '获奖年份'},
                  {field: 'awardsTypeText', title: '成果奖项'},
                  {field: 'typeText', title: '奖项数量' },
                  {field: 'awardsType', title: '获奖类型'},
              ]],
              method: 'post', // 数据请求接口类型 默认 get, 如果是get 可以去掉此项
              where: where
              ,request: {
                  page: 'pageIndex', // 重置默认分页请求请求参数 page => pageIndex
                  limit: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
              }
              , page: false //开启分页
              , limit: 15
              , limits: [15, 30, 45, 60], // 配置分页数据条数
          });
      }
  }
  /*初始表格*/
  obj.tableList("");
  /*表格行被选中*/
  table.on('radio(expertTable)', function(obj){
      itemRowData = obj.data;
  });
  importFiles({
      id:'#importData',
      url:'/expert-api/input_excel',
      callback: function (data, type) {
          obj.tableList('');
      }
  })
  form.on('submit(newSubmit)', function(data) {
      console.log(data.field)
      obj.tableList(data.field)
      return false
  })
  var $ = layui.$, active = {
      queryData:function () {
          /*查询*/
          obj.tableList($("#name").val());
          $("#exportData").attr("href","/expert-api/exput_excel?name="+$("#name").val())
      },
      reset:function () {
          /*重置*/
          $("#name").val("");
          obj.tableList('');
      },
      addItem:function () {
          /*新增*/
          obj.layerOpen("新增专家");
      },
      editItem:function () {
          /*编辑*/
          if(itemRowData.id==undefined){
              layer.msg('请选择需要编辑的数据！');
              return
          }
          obj.layerOpen("编辑专家",itemRowData.id);
      },
      delItem:function () {
          /*删除*/
          if (itemRowData) {
              top.layer.confirm('您确定要删除吗？', {icon: 3, title:'删除提示'}, function(index){
                  layer.close(index);
                  // 确认删除
                  httpModule({
                      url: '/expert-api/delete/' + itemRowData.id,
                      type: 'get',
                      success: function(relData) {
                          if (relData.success) {
                              layer.msg('删除成功!', {icon: 1});
                              top.layer.closeAll(); // 关闭弹窗
                              obj.tableList('');
                          } else {
                              layer.msg('删除失败', {icon: 2});
                          }
                      }
                  });
              });
          } else {
              layer.msg('请选择需要删除的数据！');
          }
      }
  }
  $('.layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
  });
});
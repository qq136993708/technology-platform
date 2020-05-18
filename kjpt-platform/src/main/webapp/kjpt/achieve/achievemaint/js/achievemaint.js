layui.use(['element', 'form', 'jquery', 'table', 'laydate'], function () {
  var element = layui.element,
    $ = layui.jquery,
    form = layui.form,
    table = layui.table;
  var laydate = layui.laydate;
  var itemRowData = ''
  /*公共方法*/
  var objLayui = {
    openLayer: function (obj) {
      top.layer.open({
        type: 2,
        title: obj.title,
        content: obj.url, // 全局弹窗页面地址
        btn: null,
        area: ['50%', '60%'],
        end: function (lay, index) {
          // 弹窗销毁时获取弹窗返回数据
          var getData = getDialogData('dialog-data');
          if (getData !== null && getData.success) {
            // tableRender(obj.tableName,obj.arr,obj.tableUrl,variable.id)
            objLayui.tableList('')
          }
        }
      });
    },
    tableList: function (where) {
      /*列表展示*/
      table.render({
        elem: '#expertTable', // 表格元素ID
        url: '/achieveMaintain-api/query' //数据接口
          ,
        cols: [
          [ //表头
            {
              type: 'radio'
            },
            {
              field: 'year',
              title: '获奖年份'
            },
            {
              field: 'awardsTypeText',
              title: '成果奖项'
            },
            {
              field: 'awardsNumber',
              title: '奖项数量'
            },
            {
              field: 'typeText',
              title: '获奖类型'
            },
          ]
        ],
        parseData: function (res) {
          return layuiParseData(res);
        },
        method: "GET", // 数据请求接口类型 默认 get, 如果是get 可以去掉此项
        where: where,
        request: {
          page: 'pageIndex', // 重置默认分页请求请求参数 page => pageIndex
          limit: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        page: false //开启分页
          ,
        limit: 15,
        limits: [15, 30, 45, 60], // 配置分页数据条数
      });
    }
  }
  /*初始表格*/
  objLayui.tableList("");

  laydate.render({
    elem: '#startYear', //指定元素
    type: "year",
    trigger: 'click',
    change: function (value, date, endDate) {
      $("#startYear").val(value)
    }
  });

  laydate.render({
    elem: '#endYear', //指定元素
    type: "year",
    trigger: 'click',
    change: function (value, date, endDate) {
      $("#endYear").val(value)
    }
  });
  /*表格行被选中*/
  table.on('radio(expertTable)', function (obj) {
    itemRowData = obj.data;
  });
  form.on('submit(formDemo)', function (data) {
    console.log(data.field)
    objLayui.tableList(data.field)
    return false
  })
  var $ = layui.$,
    active = {
      reset: function () {
        /*重置*/
        // $("#name").val("");
        objLayui.tableList();
      },
      addItem: function () {
        var obj = {
          title: '新增成果奖项',
          url: '/kjpt/achieve/achievemaint/achievemaint_add.html?type=edit',
        }
        /*新增*/
        objLayui.openLayer(obj);
      },
      editItem: function () {
        /*编辑*/
        if (itemRowData.id == undefined) {
          layer.msg('请选择需要编辑的数据！');
          return
        }
        var obj = {
          title: '编辑成果奖项',
          url: '/kjpt/achieve/achievemaint/achievemaint_add.html?expertId=' + itemRowData.id + '&type=edit',
        }
        objLayui.openLayer(obj);
      },
      seeItem: function () {
        //查看
        if (itemRowData.id == undefined) {
          layer.msg('请选择需要查看的数据！');
          return
        }
        var obj = {
          title: '查看成果奖项',
          url: '/kjpt/achieve/achievemaint/achievemaint_add.html?expertId=' + itemRowData.id + '&type=see',
        }
        objLayui.openLayer(obj);
      },
      delItem: function () {
        /*删除*/
        if (itemRowData) {
          top.layer.confirm('您确定要删除吗？', {
            icon: 3,
            title: '删除提示'
          }, function (index) {
            layer.close(index);
            // 确认删除
            httpModule({
              url: '/achieveMaintain-api/delete/' + itemRowData.id,
              type: 'DELETE',
              success: function (relData) {
                if (relData.success) {
                  layer.msg('删除成功!', {
                    icon: 1
                  });
                  top.layer.closeAll(); // 关闭弹窗
                  objLayui.tableList('');
                } else {
                  layer.msg('删除失败', {
                    icon: 2
                  });
                }
              }
            });
          });
        } else {
          layer.msg('请选择需要删除的数据！');
        }
      },
      exportData: function () {
        var formValue = form.val('patentFormDemo'),
          searchData = {
            type: formValue.type || '', // 获奖类型
            startYear: formValue.startYear || '', //开始时间
            endYear: formValue.endYear || '', // 结束时间
            awardsType: formValue.awardsType || '', // 成果奖项
          },
          exportUrl = '';

        for (var key in searchData) {
          exportUrl += '&' + key + '=' + searchData[key];
        }
        exportUrl = '/achieveMaintain-api/export?' + exportUrl.substring(1);
        window.open(exportUrl, '_blank');
      }
    }
  $('.layui-btn').on('click', function () {
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
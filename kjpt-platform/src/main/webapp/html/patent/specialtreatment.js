//Demo
layui.use(['form', 'table', 'layer', 'laydate'], function () {
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var laydate = layui.laydate;
  var variable = getQueryVariable();
  var queryType = (function() {
    if (variable && typeof(variable) === 'object' && variable.type) {
      return variable.type; } else { return '1'; }
  })();
  
  //表格渲染
  var itemRowData = null; // 选中行的数据
  var tableRender = false;

  function queryTable(searchData) {
    if (!tableRender) {
      tableRender = true;
      table.render({
        elem: '#tableDemo',
        url: '/patentController/query' //数据接口
          ,
        cols: [
          [ //表头
            {
              type: 'checkbox',
              align: 'center'
            },
            {title: '序号',templet: '#xuhao', align: 'center'},
            {
              field: 'unitNameText',
              title: '单位名称',
              align: 'center',
              sort: true,
            },
            {
              field: 'patentName',
              title: '专利名称',
              sort: true,
              align: 'center'
              // hide: (queryType == '1' ? true : false)
            }, {
              field: 'applicationNumber',
              title: '专利号'
            },
            {
              field: 'applicant',
              title: '申请人'
            },
            {
              field: 'inventor',
              title: '发明人',
              sort: true
            },
            {
              field: 'applicationTypeText',
              title: '申请类型',
              align: 'center',
              sort: true,
            },
            {
              field: 'patentTypeText',
              title: '专利类型',
              align: 'center',
            },
            {
              field: 'countryText',
              title: '国别组织',
              align: 'center',
            },
            {
              field: 'applicationDateStr',
              title: '申请日期',
              align: 'center',
              sort: true,
              templet: function(d){
                var times = new Date(d.applicationDateStr);
                 return times.getFullYear() + '-' + (times.getMonth()+1) + '-' +times.getDate();
              }},
            {
              field: 'authorizationDateStr',
              title: '授权日期',
              align: 'center',
              sort: true,
            },
            {
              field: 'secretLevelText',
              title: '密级',
              hide: _hideSecrecylevel(),
              sort: true
            }
          ]
        ],
        parseData: function (res) {
          return layuiParseData(res);
        },
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageIndex
          limitName: 'pageSize', // 重置默认分页请求请求参数 limit => pageSize
          
        },
        page: true, //开启分页
        limit: 10, // 每页数据条数,
        limits: [5, 10, 15, 20], // 配置分页数据条数
        done: function (res) {
          itemRowData = null;
        },
        where: searchData
      });
    } else {
      table.reload('tableDemo', {
        where: searchData
      });
    }
  }

  form.on('submit(formDemo)', function (data) {
    //TODO date error
    var query = data.field;
    query['type']=2;
    // query.type = queryType;  // 后台去掉了type字段
    queryTable(query);
    return false;
  });
  
  $('[lay-filter="formDemo"]').click();

  function openDataDilog(type, id) {
    var pageName = 'edit', pageTitle = '专利';
    if (queryType == '2') {
      // 后专项处理
      pageName = 'handle';
      pageTitle = '后专项处理';
    }

    var url = '/html/patent/'+ pageName +'.html?type=' + type;
    var dialogTitle = '新增'+pageTitle;
    if (type === 'edit') {
      dialogTitle = '编辑'+ pageTitle;
      url += '&id=' + id;
    } else if (type === 'view') {
      dialogTitle = pageTitle + '信息查看';
      url = '/html/patent/view.html?id=' + id+'&type=' + type;
    }

    // 打开弹窗
    top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['880px', '70%'],
      content: url,
      btn: null,
      end: function () {
        var relData = getDialogData('dialog-data');
        if (relData) {
          if (relData.code === '0') {
            layer.msg(dialogTitle + '成功!', {
              icon: 1
            });
            $('[lay-filter="formDemo"]').click();
          } else {
            layer.msg(relData.message, {
              icon: 2
            });
          }
        }
      }
    });
  }

  // 新增
  $('#addItem').on('click', function (e) {
    openDataDilog('add');
  })

  // 表格行被选中
  table.on('radio(tableDemo)', function (obj) {
    itemRowData = obj.data;
  });
  // 编辑
  $('#editItem').on('click', function (e) {
    if (itemRowData) {
      openDataDilog('edit', itemRowData.id);
    } else {
      layer.msg('请选择需要编辑的专利项目！');
    }
  });

  // 查看
  $('#viewItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length == 1) {
      openDataDilog('view', itemRowData[0].id);
    } else {
      layer.msg('请选择需要查看的专利项目！');
    }
  });


  $('#removeItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData.length > 0) {
      layer.confirm('您确定要移除吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        layer.close(index);
        var ids= itemRowData.map(function(item){
          return item.id
        })
        // 确认删除
        httpModule({
          url: '/patentController/batchRemove/'+ids,
          type: 'GET',
          success: function (relData) {
            if (relData.code === '0') {
              layer.msg('移除成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              layer.msg('移除失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要移除的专利项目！');
    }
  });

  laydate.render({
    elem: '#applicationDateStart' //指定元素
  });

  laydate.render({
    elem: '#applicationDateEnd' //指定元素
  });
  loadPatent();
  function loadPatent(){
    httpModule({
      url: '/patentController/countByLegalStatus?type=2',
      type: 'GET',
      success: function (relData) {
        if (relData.success) {
          $.each(relData.data,function(index,item){
            if(item.name == '全部'){
              $('#patentsTotal').text(item.num)
            }else if(item.name == '申请'){
              $('#patentNumber').text(item.num)
            }else if(item.name == '授权'){
              $('#patentAuthorizations').text(item.num)
            }
          })
        }
      }
    });
  };
  loadPatentType();
  function loadPatentType(){
    httpModule({
      url: '/patentController/countByPatentType?type=2',
      type: 'GET',
      success: function (relData) {
        if (relData.success) {
          $.each(relData.data,function(index,item){
            if(item.name == '外观设计'){
              $('#appearanceDesign').text(item.num)
            }else if(item.name == '发明'){
              $('#invention').text(item.num)
            }else if(item.name == '实用新型'){
              $('#utilityModel').text(item.num)
            }
          })
        }
      }
    });
  };
  $('#leftItem').on('click',function(){
    if (itemRowData) {
      httpModule({
        //GET /patentController/load/{id}
        url: '/patentController/load/'+itemRowData.id,
        type: 'GET',
        success: function (relData) {
          if (relData.success) {
            var params = relData.data;
            params['type']=2;
            httpModule({
              url: '/patentController/save',
              type: 'POST',
              data: params,
              success: function (relData) {
                if (relData.success) {
//                  debugger
                  // var data = relData.data;
                }
              }
            });
          }
        }
      });
    } else {
      layer.msg('请选择需要查看的专利项目！');
    }
  })

});

function shouUser(userId) {
  alert(userId);
}
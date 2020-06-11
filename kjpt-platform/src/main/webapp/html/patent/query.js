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
            // {title: '序号', templet: '#xuhao', align: 'center', width: 60 },
            {title: '序号',type:'numbers', width: 60 },
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
              title: '专利类别',
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
                var times = new Date(d.applicationDate);
                 return times.getFullYear() + '-' + (times.getMonth()+1) + '-' +times.getDate();
              }},
            {
              field: 'authorizationDate',
              title: '授权日期',
              align: 'center',
              sort: true,
              templet: function(d){
            	  if (d.authorizationDate) {
            		  var times = new Date(d.authorizationDate);
            		  return times.getFullYear() + '-' + (times.getMonth()+1) + '-' +times.getDate();            		  
            	  } else {
            		  return '';
            	  }
	          },
              // hide: (queryType == '1' ? true : false)
            },
            /*{
              field: 'legalStatusUpdateTime',
              title: '法律状态更新时间',
              align: 'center',
              sort: true,
              hide: (queryType == '1' ? true : false)
            }, {
              field: 'technicalFieldText',
              title: '技术领域名称',
              sort: true,
              hide: (queryType == '1' ? true : false)
            }, {
              field: 'agency',
              title: '代理机构',
              sort: true,
              hide: (queryType == '1' ? false : true)
            }, {
              field: 'legalStatusText',
              title: '法律状态',
              sort: true
            }, */
              {
                  field: 'projectBackgroundText',
                  title: '项目背景',
                  align: 'center',
                  sort: true,
              },
              {
                  field: 'legalStatusText',
                  title: '法律状态',
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
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
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
    var query = data.field;
    // query.type = queryType;  // 后台去掉了type字段
    queryTable(query);
    return false;
  });
  
  // queryTable();
  $('[lay-filter="formDemo"]').click();

  function openDataDilog(type, id) {
    var pageName = 'edit', pageTitle = '专利';
    var url = '/html/patent/'+ pageName +'.html?type=' + type;
    var dialogTitle = '新增'+pageTitle;
    if (type === 'edit') {
      dialogTitle = '编辑'+ pageTitle;
      url += '&id=' + id;
    } else if (type === 'view') {
      dialogTitle = pageTitle + '信息查看';
      url = '/html/patent/view.html?id=' + id+'&type='+ type;
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
  // table.on('radio(tableDemo)', function (obj) {
  //   itemRowData = obj.data;
  // });
  // 编辑
  $('#editItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData && itemRowData.length == 1) {
      openDataDilog('edit', itemRowData[0].id);
    } else {
      layer.msg('请选择需要编辑的专利项目！');
    }
  });

  // 查看
  $('#viewItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData && itemRowData.length == 1) {
      openDataDilog('view', itemRowData[0].id);
    } else {
      layer.msg('请选择需要查看的专利项目！');
    }
  });

  // 删除
  $('#delItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    var ids = itemRowData.map(function(item){
      return item.id
    })
    if (itemRowData) {
      top.layer.confirm('您确定要删除吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        top.layer.close(index);
        // 确认删除
        httpModule({
          url: '/patentController/delete/' + ids,
          type: 'DELETE',
          success: function (relData) {
            if (relData.code === '0') {
              layer.msg('删除成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              layer.msg('删除失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要删除的专利项目！');
    }
  });

  $('#removeItem').on('click', function (e) {
    var itemRowData = table.checkStatus('tableDemo').data;
    if (itemRowData) {
      top.layer.confirm('您确定要移除”' + itemRowData.patentName + '“吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        top.layer.close(index);
        // 确认删除
        httpModule({
          url: '/patentController/batchRemove/' + itemRowData.id,
          type: 'GET',
          success: function (relData) {
            if (relData.code === '0') {
              top.layer.msg('移除成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              top.layer.msg('移除失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要移除的专利项目！');
    }
    // if (itemRowData) {
    //   // layer.msg('移除移除！');

    // } else {
    //   layer.msg('请选择需要移除的专利项目！');
    // }
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
      url: '/patentController/countByLegalStatus',
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
      url: '/patentController/countByPatentType',
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
    var itemRowData = table.checkStatus('tableDemo').data;
    var ids = itemRowData.map(function (item) {
      return item.id;
      })
    if (itemRowData) {
      top.layer.confirm('您确定要后处理吗？', {
        icon: 3,
        title: '删除提示'
      }, function (index) {
        top.layer.close(index);
        httpModule({
          url: '/patentController/postTreatment/' +ids,
          type: 'GET',
          success: function (relData) {
            if (relData.code === '0') {
              top.layer.msg('后处理成功!', {
                icon: 1
              });
              $('[lay-filter="formDemo"]').click();
            } else {
              top.layer.msg('后处理失败', {
                icon: 2
              });
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要后处理的数据！');
    }
//     if (itemRowData) {
//       httpModule({
//         url: '/patentController/load/'+itemRowData.id,
//         type: 'GET',
//         success: function (relData) {
//           if (relData.success) {
//             var params = relData.data;
//             params['type']=2;
//             httpModule({
//               url: '/patentController/save',
//               type: 'POST',
//               data: params,
//               success: function (relData) {
//                 if (relData.success) {
// //                  debugger
//                   // var data = relData.data;
//                 }
//               }
//             });
//           }
//         }
//       });
//     } else {
//       layer.msg('请选择需要查看的专利项目！');
//     }
  })
  //导入
importFiles({
  id:'#importData',
  url:'/patentController/input_excel?type='+queryType,
  callback: function (result) {
    debugger;
      if(result.data!=null && result.data.code=="1"){
          layer.msg('数据导入失败!失败信息：'+result.data.message, {icon: 1});
      }else{
          layer.msg('数据导入成功!', {icon: 1});
          $('[lay-filter="formDemo"]').click();
      }

      /*if(result.data==null||result.data.code=="0") {
          layer.msg('数据导入成功!', {icon: 1});
          $('[lay-filter="formDemo"]').click();
      }else{
          layer.msg('数据导入失败!失败信息：'+result.data.message, {icon: 1});
      }*/
  }
})
// 导出
$('#exportData').click(function() {
  var formValue = form.val('patentFormDemo'),
  searchData = {
    unitName: formValue.unitName || '', // 单位名称：
    projectBackground: formValue.projectBackground || '', // 项目背景：
    patentType: formValue.patentType || '', // 专利类型：
    lawStatus: formValue.lawStatus || '', // 法律状态
    applicationNumber: formValue.applicationNumber || '', // 专利号：
  },
  exportUrl = '';

  for (var key in searchData) {
    exportUrl += '&' + key + '=' + searchData[key];
  }
  exportUrl = '/patentController/exportExcel?' + exportUrl.substring(1);
  window.open(exportUrl, '_blank');
})

});

function shouUser(userId) {
  alert(userId);
}
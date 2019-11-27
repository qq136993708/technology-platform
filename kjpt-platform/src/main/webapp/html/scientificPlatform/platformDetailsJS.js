//Demo
layui.use(['form', 'table', 'layer', 'element'], function(){
  var form = layui.form;
  var $ = layui.$;
  var table = layui.table;
  var element = layui.element;
  var layer = layui.layer;

  form.render(); //更新全部
  // 获取页面参数ID
  var variable = getQueryVariable();
  console.log(variable);

  function addTableData(config) {
    if (!config.update) {
      var searchData = { platformId: variable.id };
      if (config.where) {
        for (var key in config.where) {
          searchData[key] = config.where[key];
        }
      }

      table.render({
        elem: '#'+ config.id
        // ,height: 382
        ,url: config.url //数据接口
        ,page: true //开启分页
        ,cols: config.cols,
        request: {
          pageName: 'pageNum', // 重置默认分页请求请求参数 page => pageNum
          limitName: 'pageSize' // 重置默认分页请求请求参数 limit => pageSize
        },
        limit: 5, // 每页数据条数
        where: searchData,
        parseData: function(res) {
          if (config.url.indexOf('.json') > 0) {
            return layuiParseData(res, null, 3);
          } else {
            return layuiParseData(res);
          }
        }
      });
    } else {
      if (config.options && typeof(config.options) && !config.options.length) {
        table.reload(config.id, config.options);
      } else {
        table.reload(config.id);
      }
    }
  }

  if (variable && variable.id) {
    // 获取平台详情
    httpModule({
      url: '/platform-api/load/' + variable.id,
      success: function(relData) {
        if (relData.code === '0') {
          setTargetNameValue(relData.data);
          if (relData.data.imgId) {
            $('#platformImg').css({
              'background-image':  'url(/file/imgFile/'+ relData.data.imgId +')'
            });
          }
        }
      }
    });
    // 获取项目、评审、成果、专利个数
    httpModule({
      url: '/platform-api/selectPaltinfoCount/' + variable.id,
      success: function(relData) {
        if (relData.code === '0') {
         $('[num-label]').each(function(i, item) {
           var numLabel = $(this).attr('num-label');
           if (numLabel) {
            var itemVlue = relData.data.filter(function(value, i) { if (value.count_type === numLabel) return value; })[0];
            $(this).empty().text(itemVlue.count);
           }
         });
        }
      }
    });

    // 科研项目 /platformProject-api/load/
    addTableData({
      id: 'tableProject',
      url: '/platformProject-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{title: '序号', type: 'numbers', width: 90}
        ,{field: 'projectName', title: '项目名称', sort: true }
        ,{field: 'dutyInstitutionsText', title: '负责单位', sort: true}
        // ,{field: 'majorTypeText', title: '专业类型'} 
        ,{field: 'approvalYear', title: '立项年度'}
      ]]
    });

    // 领军人物
    addTableData({
      id: 'leadingFigure',
      url: '/researchPlatformMember-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{field: 'name', title: '名称' }
        ,{field: 'assumeOffice', title: '担任职务', sort: true }
        ,{field: 'technicalTitle', title: '技术职称', sort: true}
        ,{field: 'workUnitText', title: '工作单位'} 
        ,{field: 'majorStudied', title: '专业'}
      ]],
      where: {role: '1'}
    });
    
    // 论文
    addTableData({
      id: 'tablePaper',
      url: '/platformTreatise-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{field: 'thesisTitle', title: '论文题目' }
        ,{field: 'thesisLevelText', title: '论文级别', sort: true }
        ,{field: 'journalTitle', title: '期刊名称', sort: true}
        ,{field: 'thesisAuthor', title: '作者'} 
        ,{field: 'thesisYear', title: '发表时间'}
      ]]
    });

    // 团队成员
    addTableData({
      id: 'teamMembers',
      url: '/researchPlatformMember-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{field: 'name', title: '姓名' }
        ,{field: 'birth', title: '年龄', sort: true }
        ,{field: 'educationText', title: '学历', sort: true}
        ,{field: 'technicalTitle', title: '技术职称'} 
        ,{field: 'graduateSchool', title: '毕业学校'}
        ,{field: 'majorStudied', title: '所学专业'}
        ,{field: 'postName', title: '岗位名称'} 
      ]],
      where: {role: '0'}
    });

    // 主要成果
    addTableData({
      id: 'mainAchievements',
      url: '/researchPlatformAchievement-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{type: 'numbers', title: '序号', width: 80}
        ,{field: 'achievementName', title: '成果名称', sort: true }
        ,{field: 'applicantUnitText', title: '申请单位', sort: true}
        ,{field: 'achievementTypeText', title: '成果类型'} 
        ,{field: 'applicantYear', title: '申请年度'}
      ]]
    });

    // 主要专利
    addTableData({
      id: 'mainPatent',
      url: '/researchPlatformPatent-api/query',
      cols: [[ //表头
        {type: 'radio', field: 'id'}
        ,{type: 'numbers', title: '序号', width: 80}
        ,{field: 'patentName', title: '专利名称', sort: true }
        ,{field: 'patentTypeText', title: '专利类型', sort: true}
        ,{field: 'applicationDate', title: '申请日期', templet: function(d) {
          return dateFieldText(d.applicationDate);
        }} 
        ,{field: 'remark', title: '描述'}
      ]]
    });
  }

  var tableFilterArr = [
    {tableId: '', title: '平台简介' },
    {tableId: 'tableProject', title: '科研项目'},
    {tableId: 'leadingFigure', title: '领军人物'},
    {tableId: 'tablePaper', title: '论文'},
    {tableId: 'teamMembers', title: '成员'},
    {tableId: 'mainAchievements', title: '成果'},
    {tableId: 'mainPatent', title: '专利'}
    
  ];
  var activeTab = 0;
  // 监控tab签切换
  element.on('tab(platformDetails)', function(data) {
    activeTab = data.index;
    if (activeTab) {
      table.reload(tableFilterArr[activeTab].tableId);
    }
  })

  // 新增
  $('.openDialog').on('click', function(e) {
    var optionsType = $(this).data('type'),
        htmlPage = $(this).data('page'),
        dialogTitle = '',
        typeText = '添加',
        projectId = '';
    if (optionsType === 'edit') {
      typeText = '编辑';
      if (!table.checkStatus(tableFilterArr[activeTab].tableId).data.length) {
        layer.msg('请选择一条数据再进行' + typeText, {icon: 6});
        return false;
      } else {
        projectId = table.checkStatus(tableFilterArr[activeTab].tableId).data[0].id;
      }
    }
    dialogTitle = typeText + tableFilterArr[activeTab].title;

    var dialogPage = '/html/scientificPlatform/'+htmlPage+'.html';
    dialogPage += '?id='+ projectId; // 项目ID
    dialogPage += '&platformId=' + variable.id; // 平台ID
    dialogPage += '&type='+optionsType; // 操作类型

    if ($(this).data('item')) {
      dialogPage += '&item=' + $(this).data('item'); // 成员 | 领军人物
    }

    // 打开弹窗
    top.layer.open({
      type: 2,
      title: dialogTitle,
      area: ['780px', '520px'],
      content: dialogPage,
      btn: null,
      end: function() {
        var returnValue = getDialogData('dialog-data');
        if (returnValue) {
          if (returnValue.code === '0') {
            layer.msg(dialogTitle + '成功。', {icon: 1});
            addTableData({update: true, id: tableFilterArr[activeTab].tableId})
          } else {
            layer.msg(dialogTitle + '失败。', {icon: 2});
          }
        }
        console.log(returnValue);
      }
    });
    
  })
  
  // 新增确定提交
  form.on('submit(projectSubmit)', function(data){
    console.log(data);
    return false;
  })
  

  // 编辑
  $('.deleteItem').on('click', function(e) {
    var delItem = table.checkStatus(tableFilterArr[activeTab].tableId).data;
    if (delItem.length) {
      top.layer.confirm('您确定要删除'+tableFilterArr[activeTab].title+'吗？', {icon: 3, title:'删除提示'}, function(index){
        top.layer.close(index);
  
        var deleteUrl = '/platformProject-api/delete/';
        if (activeTab == 2 || activeTab == 4) {
          deleteUrl = '/researchPlatformMember-api/delete/';
        } else if (activeTab == 3) {
          deleteUrl = '/platformTreatise-api/delete/';
        } else if (activeTab == 5) {
          deleteUrl = '/researchPlatformAchievement-api/delete/';
        } else if (activeTab == 6) {
          deleteUrl = '/researchPlatformPatent-api/delete/';
        }

        httpModule({
          url: (deleteUrl + delItem[0].id),
          type: 'DELETE',
          success: function(res) {
            if (res.code === '0') {
              table.reload(tableFilterArr[activeTab].tableId);
              layer.msg('删除'+ tableFilterArr[activeTab].title + '成功。', {icon: 1});
            }  else {
              layer.msg('删除'+ tableFilterArr[activeTab].title + '失败!', {icon: 2});
            }
          }
        });
      });
    } else {
      layer.msg('请选择需要删除的数据！');
    }
  })

  // 模版下载、导入、导出
  $('.exportDown, .exportData, .importData').on('click', function() {
    layer.msg('功能开发中...暂未实现！');
    return;
  })
  
});
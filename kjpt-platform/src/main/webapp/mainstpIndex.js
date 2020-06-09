layui.config({
    base : '../layuiadmin/' //静态资源所在路径
}).extend({
    index : 'lib/index' //主入口模块
}).use(['index','element', 'jquery'], function() {
  var $ = layui.jquery;

  /*commonItemInto({
    elem: '#homeHeaderItem',
    itemMinWidth: 164,
    cols: [
      { title: '科技人才', iconName: 'icon011', id: 'expertNumber', label: 'zik', unit: '个',url:'/kjpt/expert/expert_query.html' }
      , {  title: '科研平台', iconName: 'icon002', id: 'scientificPlatform', label: '', unit: '家',url:'/html/scientificPlatform/scientificPlatform.html' }
      , { title: '科技成果', iconName: 'icon003', id: '', label: 'kycg', unit: '个' ,url:'#'}
      , { title: '成果转化', iconName: 'icon007', id: 'achieveTranform', label: '', unit: '个',url:'/achieve/achieve_query' }
      , { title: '专利数量', iconName: 'icon010', id: 'patentNumber', label: '', unit: '个' ,url:'/html/patent/query.html'}
      , { title: '核行业标准', iconName: 'icon008', id: '', label: '', unit: '个',url:'#' }
      , { title: '质量报表', iconName: 'icon009', id: '', label: '', unit: '个' ,url:'#'}
      , { title: '经验反馈', iconName: 'icon006', id: '', label: '', unit: '条',url:'#' }
    ]
  });*/

  // 饼图渲染
  function getPieChartOption(data) {
    /*
    public data: {completed: 8, unCompleted: 2, title: '上周工作完成情况'};
    # completed: 已完成;
    # unCompleted: 未完成;
    */
    var option = {
      title: {
        // text: data.text,
        top:  '42%',
        left: 'center',
        textStyle: {
          color: '#fff',
          fontWeight: 'normal',
          fontSize: 12,
          lineHeight: 14,
        },
        subtext: data.subText,
        subtextStyle: {
          color: '#fff',
          fontWeight: 'normal',
          fontSize: 16,
          lineHeight: 18,
        },
        padding: 0,
        itemGap: 3
      },
      tooltip: {
        show: true,
        formatter: function(d) {
          return data.completed.name + ': ' + conversionNumber(data.completed.value) + '<br/>' + data.unCompleted.name + ': ' + conversionNumber(data.unCompleted.value);
        }
      },
      legend: { show: false},
      series: [
        {
          name: data.title || '上周工作完成情况',
          type:'pie',
          radius: ['50%', '70%'],
          label: {show: false},
          avoidLabelOverlap: false,
          labelLine: { show: false },
          data:[
            {
              value: data.completed.value || 0,
              name: data.completed.name,
              emphasis: { itemStyle: { color: 'rgba(255, 255, 255, 1)' }},
            },
            {
              value: data.unCompleted.value  || 0,
              name: data.unCompleted.name,
              tooltip: { show: false },
              emphasis: { itemStyle: { color: 'rgba(255, 255, 255, .35)' }}
            }
          ]
        }
      ],
      animation: false,
      color: ['rgba(255, 255, 255, 0.9)', 'rgba(255, 255, 255, .25)']
    };
    return option;
  }
  // 列表渲染
  function getItemHtml(config) {
    var $parent = $(config.id).empty();
    $.each(config.data, function(i, item) {
      var $li = $('<li class="item-details"></li>'), itemHtml = '';
      if(item.noticeCreatetime){
        itemHtml += '<span class="date-text">['+ (function() {
        	if (item.noticeCreatetime) {
        		if (typeof(item.noticeCreatetime) === 'string' && item.noticeCreatetime.indexOf('-') > 0) {
        			return new Date(item.noticeCreatetime.split('-').join('/')).format('yyyy-MM-dd');
        		} else {
        			return new Date(item.noticeCreatetime).format('yyyy-MM-dd');
        		}
        	} else {
        		return '';
        	}
        })() +']</span>';
      }else{
        itemHtml += '<span class="date-text">['+ (function() {
        	if (item.createDate) {
        		if (typeof(item.createDate) === 'string' && item.createDate.indexOf('-') > 0) {
        			return new Date(item.createDate.split('-').join('/')).format('yyyy-MM-dd');
        		} else {
        			return new Date(item.createDate).format('yyyy-MM-dd');
        		}
        	} else {
        		return '';
        	}
        })() +']</span>';
      }
      itemHtml += '<span class="details-text">'+item[config.name]+'</span>';
      $li.append(itemHtml);
      
      if (config.href) {
        var itemHref = config.href;
        if (config.hrefData) {
        	var dataList = '';
            for (var i = 0; i < config.hrefData.length; i++) {
          	  if (typeof(config.hrefData[i]) === 'object') {
          		  dataList +=  '&' + config.hrefData[i].name + '=' + (config.hrefData[i].value || item[config.hrefData[i].key]);
          	  } else {
          		  dataList +=  '&' + config.hrefData[i] + '=' + item[config.hrefData[i]];            		  
          	  }
            }
            if (itemHref.indexOf('?') === -1) {
                itemHref += ('?' + dataList.substring(1));
            } else {
                itemHref += dataList;
            }
        }

        $li.click(function(e) {
          if (config.openType && config.openType === 'layer') {
            top.layer.open({
              type: 2,
              title: config.title || '查看详情',
              content: itemHref,
              area: ['880px', '70%'],
              btn: null,
            });
          } else {
            parent.layui.index.openTabsPage(itemHref, config.title + '('+ item[config.name] +')');
          }
        })  
      }
      $parent.append($li);
    })
  }
  // 获取tab页签对应的内容
  function getTabContentList(config) {
    httpModule({
      url: config.url,
      data: config.data,
      type: config.type?config.type:'GET',
      contentType: config.contentType,
      success: function(res) {
        if (res.code == '0' || res.success === true) {
          getItemHtml({
            id: config.id,
            name: config.name,
            data: res.data.list?res.data.list:res.data,
            href: config.href,
            hrefData: config.hrefData,
            title: config.title,
            openType: config.openType
          })
        }
        if (config.callback) {
          config.callback(res);
        }
      }
    })
  }

  /*var lastWeekChart = echarts.init(document.getElementById('lastWeek'));
  lastWeekChart.setOption(getPieChartOption({
    completed: { name: '已完成', value: 100 },
    unCompleted: { name: '在研', value: 99 },
    // text: '总量',
    subText: conversionNumber(199),
    title: '项目数量'
  }));*/

  /*var thisWeekChart = echarts.init(document.getElementById('thisWeek'));
  thisWeekChart.setOption(getPieChartOption({
    completed: {
      // name: '实际完成',
      value: 3000000
    },
    unCompleted: {
      name: '年度计划',
      value: 15000000
    },
    text: '实际完成',
    subText: conversionNumber(3000000),
    title: '项目投资'
  }));*/

  $(window).resize(function() {
    // lastWeekChart.resize();
    // thisWeekChart.resize();
  });

  // 获取相关个数
  // httpModule({
  //   url: '/indexHome-model/homeNummary',
  //   success: function(res) {
  //     if ( res.list.length) {
  //       $('[num-label]').each(function(i, item) {
  //         var numLabel = $(this).attr('num-label');
  //         if (numLabel) {
  //          var itemVlue = res.list.filter(function(value, i) { if (value.sumName === numLabel) return value; })[0];
  //          if (itemVlue) {
  //            $(this).empty().text(itemVlue.num);
  //          }
  //         } else {
  //           $(this).empty().text(0)
  //         }
  //       });
  //     }
  //   }
  // });

  // 科技人才数量
  httpModule({
    url: '/outPerson-api/page',
    data: {page: 1, limit: 1},
    success: function(res) {
      if (res.code === '0' || res.code === 0) {
        $('#expertNumber').text(res.count)
      } else {
        $('#expertNumber').text(0);
      }
    }
  })
  
  // 获取科研平台数量
  httpModule({
    url: '/platform-api/query',
    data: {pageNum: 1, pageSize: 1, level: '' },
    success: function(res) {
      if (res.code === '0') {
        $('#scientificPlatform').text(res.data.total)
      } else {
        $('#scientificPlatform').text(0)
      }
    }
  })

  // 获取专利数量
  httpModule({
    url: '/patentController/query',
    data: {pageNum: 1, pageSize: 1 },
    success: function(res) {
      if (res.code === '0') {
        $('#patentNumber').text(res.data.total)
      } else {
        $('#patentNumber').text(0)
      }
    }
  })

  // 获取成果转化数量
  httpModule({
    url: '/achieveRecord-api/query',
    data: {pageNum: 1, pageSize: 1},
    success: function(res) {
      if (res.code === '0') {
        $('#achieveTranform').text(res.data.total)
      } else {
        $('#achieveTranform').text(0)
      }
    }
  })

  //公告列表
  getTabContentList({
    id: '#platform-notice-list',
    url: '/sysNotice/getSysNoticeList?page=1&limit=10',
    // data: { page: 1, limit: 10 },
    name: 'noticeTitle',
    href: '/sysNotice/readNotice',
    hrefData: [{name:'id', key: 'noticeId'}],
    title: '公告',
    type: 'POST',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#platform-notice-list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  });

  //新闻发布
  getTabContentList({
    id: '#news-press-list',
    url: '/sysNews/getTableData',
    data: { page: 1, limit: 10 },
    name: 'title',
    href: '/stp/system/sysNews_view_dis.html',
    openType: 'layer',
    hrefData: [{name: 'id', key: 'dataId'}],
    title: '新闻详情',
    type: 'POST',
    openType: 'layer',  
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#news-press-list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  });
  
  // 成果转化
  getTabContentList({
    id: '#transform_tab_list',
    url: '/achieveRecord-api/query',
    data: { page: 1, limit: 10, publicityStatus: 2 },
    name: 'achieveName',
    href: '/kjpt/achieve/formula.html',
    hrefData: ['id', {name: 'type', value: 'view'}],
    title: '成果转化',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#transform_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 成果获奖
  getTabContentList({
    id: '#patent_tab_list',
    url: '/achieveMaintain-api/query',
    data: { page: 1, limit: 10 },
    name: 'awardsTypeText',
    href: '/kjpt/achieve/achievemaint/achievemaint_add.html',
    hrefData: [{name: 'expertId', key: 'id' }, {name: 'type', value: 'see'}],
    title: '成果获奖',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#patent_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 科技规划
  getTabContentList({
    id: '#plan_tab_list',
    name: 'name',
    url: '/SciencePlan/query',
    data: { page: 1, limit: 10, reportType: 1},
    href: '/html/scientificMaterials/addPlan.html',
    hrefData: ['id', {name: 'type', value: 'see'}, {name: 'reportType', value: '1'}],
    title: '科技规划',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#plan_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 工作要点
  getTabContentList({
    id: '#work_imp_tab_list',
    name: 'name',
    url: '/blocScientificPlan/query',
    data: { page: 1, limit: 10, reportType: 3},
    href: '/html/groupInformation/addPlan.html',
    hrefData: ['id', {name: 'type', value: 'see'}, {name: 'reportType', value: '3'}],
    title: '工作要点',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#work_imp_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 工作指南
  getTabContentList({
    id: '#work_tab_list',
    name: 'name',
    url: '/blocScientificPlan/query',
    data: { page: 1, limit: 10, reportType: 2},
    href: '/html/groupInformation/addPlan.html',
    hrefData: ['id', {name: 'type', value: 'see'}, {name: 'reportType', value: '2'}],
    title: '工作指南',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#work_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  });

  //质量信息
  getTabContentList({
    id: '#zlxx_tab_list',
    name: 'name',
    url: '/blocScientificPlan/query',
    data: { page: 1, limit: 10, reportType: 4},
    href: '/html/groupInformation/addPlan.html',
    hrefData: ['id', {name: 'type', value: 'see'}, {name: 'reportType', value: '4'}],
    title: '质量信息',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#zlxx_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  //管理办法
  getTabContentList({
    id: '#glbf_tab_list',
    name: 'methodName',
    url: '/manageMethod-api/query',
    data: { page: 1, limit: 10, reportType: 2},
    href: '/html/groupInformation/addManage.html',
    hrefData: ['id', {name: 'type', value: 'see'}],
    title: '管理办法',
    openType: 'layer',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#glbf_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 科技进展动态
  getTabContentList({
    id: '#progress_tab_list',
    name: 'name',
    url: '/SciencePlan/query',
    data: { page: 1, limit: 10, reportType: 3},
    href: '/html/scientificMaterials/planDetails.html',
    hrefData: ['id'],
    title: '科技进展动态',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#progress_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 年度总结
  getTabContentList({
    id: '#summary_tab_list',
    name: 'name',
    url: '/SciencePlan/query',
    data: { page: 1, limit: 10, reportType: 4},
    href: '/html/scientificMaterials/planDetails.html',
    hrefData: ['id'],
    title: '年度总结',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#summary_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 科研报告
  getTabContentList({
    id: '#scientific_tab_list',
    name: 'name',
    url: '/SciencePlan/query',
    data: { page: 1, limit: 10, reportType: 5},
    href: '/html/scientificMaterials/planDetails.html',
    hrefData: ['id'],
    title: '科研报告',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#summary_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })
  /*httpModule({
    url: '/collect-api/getSysCollectByUserId?userId='+$("#userId").val(),
    type: 'get',
    success: function(res) {
      if(res.success){
        res.data.map(function (item,index) {
          var html='<div class="work-list"><a lay-href="'+item.collectUrl+'" lay-text="'+item.collectName+'"><span class="link-work">'+item.collectName+'</span></a></div>'
            $("#threeItem .work-item-box").append(html)
        })
      }
    }
  });*/
    
  $('a.tab-more-link').click(function() {
    var itemHref = $(this).attr('lay-href'),
    title = $(this).attr('lay-text');
    parent.layui.index.openTabsPage(itemHref, title);
  })
  
});
//驾驶舱跳转页面
var loadUrl=JSON.parse(localStorage.getItem('url'))
 if(typeof(loadUrl) !== 'undefined' && loadUrl != null){
  parent.layui.index.openTabsPage(loadUrl.url, loadUrl.name);
  localStorage.removeItem("url");
  $(".index-fixed li").removeClass("layui-this");
 }
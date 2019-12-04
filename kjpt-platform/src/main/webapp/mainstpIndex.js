layui.use(['element', 'jquery'], function() {
  var $ = layui.jquery;

  // 饼图渲染
  function getPieChartOption(data) {
    /*
    public data: {completed: 8, unCompleted: 2, title: '上周工作完成情况'};
    # completed: 已完成;
    # unCompleted: 未完成;
    */

    var titleValue = data.unCompleted + ' / '+ data.completed,
    option = {
      title: {
        text: titleValue,
        top: 'center',
        left: 'center',
        textStyle: {
          color: '#fff',
          fontWeight: 'normal',
          fontSize: 14,
          lineHeight: 20,
        },
        padding: 0,
        itemGap: 0
      },
      tooltip: { show: false},
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
              value: data.completed || 0,
              name:'已完成',
              emphasis: { itemStyle: { color: 'rgba(255, 255, 255, 1)' }},
            },
            {
              value: data.unCompleted  || 0,
              name:'未完成',
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
      var $li = $('<li class="item-details"></li>');
      var itemHtml = '<span class="date-text">['+ (item.createDate ? new Date(item.createDate).format('yyyy-MM-dd hh:mm:ss') : '') +']</span>';
      itemHtml += '<span class="details-text">'+item[config.name]+'</span>';
      $li.append(itemHtml);
      
      if (config.href) {
        var itemHref = config.href;
        if (config.hrefData) {
          var dataList = '';
          for (var i = 0; i < config.hrefData.length; i++) {
            dataList +=  '&' + config.hrefData[i] + '=' + item[config.hrefData[i]];
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
            window.location.href = itemHref;
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
      success: function(res) {
        if (res.code === '0' || res.success === true) {
          getItemHtml({
            id: config.id,
            name: config.name,
            data: res.data.list,
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

  var lastWeekChart = echarts.init(document.getElementById('lastWeek'));
  lastWeekChart.setOption(getPieChartOption({completed: 8, unCompleted: 2, title: '上周工作完成情况'}));

  var thisWeekChart = echarts.init(document.getElementById('thisWeek'));
  thisWeekChart.setOption(getPieChartOption({completed: 3, unCompleted: 17, title: '本周工作安排'}));

  $(window).resize(function() {
    lastWeekChart.resize();
    thisWeekChart.resize();
  });

  // 获取相关个数
  httpModule({
    url: '/indexHome-model/homeNummary',
    success: function(res) {
      if ( res.list.length) {
        $('[num-label]').each(function(i, item) {
          var numLabel = $(this).attr('num-label');
          if (numLabel) {
           var itemVlue = res.list.filter(function(value, i) { if (value.sumName === numLabel) return value; })[0];
           if (itemVlue) {
             $(this).empty().text(itemVlue.num);
           }
          } else {
            $(this).empty().text(0)
          }
        });
      }
    }
  });

  // 专利列表
  getTabContentList({
    id: '#patent_tab_list',
    url: '/patentController/query',
    data: { page: 1, limit: 10 },
    name: 'patentName',
    href: '/html/patent/view.html',
    hrefData: ['id'],
    title: '专利详情',
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
    href: '/html/scientificMaterials/planDetails.html',
    hrefData: ['id'],
    title: '科技规划',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#plan_tab_list').text(res.message || '请求出错，无法获取数据。')
      }
    }
  })

  // 工作要点
  getTabContentList({
    id: '#work_tab_list',
    name: 'name',
    url: '/SciencePlan/query',
    data: { page: 1, limit: 10, reportType: 2},
    href: '/html/scientificMaterials/planDetails.html',
    hrefData: ['id'],
    title: '工作要点',
    callback: function(res) {
      if (res.code === '-1' || res.success === false) {
        $('#work_tab_list').text(res.message || '请求出错，无法获取数据。')
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

});
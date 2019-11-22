layui.use(['element', 'jquery'], function() {
  var $ = layui.jquery;

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

  
  var lastWeekChart = echarts.init(document.getElementById('lastWeek'));
  lastWeekChart.setOption(getPieChartOption({completed: 8, unCompleted: 2, title: '上周工作完成情况'}));

  var thisWeekChart = echarts.init(document.getElementById('thisWeek'));
  thisWeekChart.setOption(getPieChartOption({completed: 3, unCompleted: 17, title: '本周工作安排'}));

  $(window).resize(function() {
    lastWeekChart.resize();
    thisWeekChart.resize();
  });


  function getItemValue(url, id) {
    // 
    httpModule({
      url: url,
      success: function(res) {
        if (res.success) { $(id).text(res.data) }
      }
    });
  }

  getItemValue('/expert-api/getZjkBaseCount', '#expertNumber');

});
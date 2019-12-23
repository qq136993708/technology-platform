layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果鉴定结论数量按研究院占比
      var chartData = [], itemName = [
        '管理', '人因', '物料', '环境', '设备', '方法'
      ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_one',
          type: 'pie',
          label: false,
          labelColor: '#fff',
          borderColor: '#001e38',
          title: '反馈经验数量',
          legendPosition: 'bottom',
          legend: { top: 0, right: '25%', left: '25%', orient: 'horizontal', formatter: 'name|value'},
          radius: ['50%', '72%'],
          series: chartData,
          color: ['#81FF5B', '#FFF04E', '#DF5DFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_one', {series: chartData});
      }
    },
    appraisalTwo: function (date) {
      // 成果鉴定结论数量按成果种类占比
      var chartData = [], itemName = [
        '铀矿地质', '铀浓缩', '燃料元件制造', '反应堆运行', '仪器仪表制造', '（工程和设备）设计',
        '核设施退役（含废物处理处置）', '铀矿冶', '铀纯化转化', '乏燃料后处理',
        '工程建设（建设、安装）', '其他'
      ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'pie',
          label: false,
          labelColor: '#fff',
          borderColor: '#001e38',
          title: ' 反馈经验数量',
          legendPosition: 'bottom',
          legend: { top: 0, right: '22%', left: '22%', orient: 'horizontal', formatter: 'name|value'},
          radius: ['54%', '76%'],
          series: chartData,
          color: ['#00D0CE', '#00A3FF', '#3668AC', '#4E408D', '#975BA8',
            '#E44191', '#FFF04E', '#FF2624', '#FCB133', '#FF7693', '#8CCB48', '#00D169']
        });
      } else {
        kyptCharts.reload('appraisal_two', {series: chartData});
      }
    }
  }


  // 成果鉴定结论数量按技术领域
  chartInit.appraisalOne();

  // 成果鉴定结论数量按成果种类占比
  chartInit.appraisalTwo();
  
});
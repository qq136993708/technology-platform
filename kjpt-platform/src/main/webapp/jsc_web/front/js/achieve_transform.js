layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果转化数量趋势分析
      var time = date || '2019',
      chartData = [],
      initYear = 2017;

      for (var i = 1; i < 4; i++) {
        chartData.push({
          name: (initYear + i)+'年',
          value1: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value2: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value3: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_one',
          type: 'line',
          itemName: 'name',
          legend: { show: false },
          grid: { top: 70 },
          legend: { show: true, left: 'right', top: 40},
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '待转化', valueKey: 'value1'},
            { name: '拟转化', valueKey: 'value2'},
            { name: '已转化', valueKey: 'value3'},
          ],
          data: chartData,
          color: ['#FFF04E', '#81FF5B', '#2BF3FF']
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    },
    appraisalTwo: function (date) {
      // 各单位成果转化激励人数
      var chartData = [], itemName = ['研究院1', '研究院2', '研究院3', '研究院4', '研究院5', '研究院6', '研究院7', '研究院8', '研究院9'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value1: (parseInt(Math.random() * 100) + 100) // 100 ~ 200
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'bar',
          itemName: 'name',
          legend: { show: false },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '激励人数', valueKey: 'value1'},
          ],
          data: chartData,
          color: ['#2BF3FF']
        });
      } else {
        kyptCharts.reload('appraisal_two', {series: chartData});
      }
    },
    appraisalThree: function(date) {
      // 成果转化数量按成果类型分析
      var chartData = [], itemName = [ '核心成果', '非核心成果' ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_three',
          type: 'pie',
          legend: { top: 'center', left: '70%'},
          label: false,
          labelColor: '#fff',
          radius: ['44%', '58%'],
          center: ['32%', '50%'],
          borderColor: '#001e38',
          title: '成果类型分析',
          series: chartData,
          color: ['#45F0FF', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_three', {series: chartData});
      }
    },
    appraisalFour: function(date) {
      // 各单位成果转化金额/激励金额
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 13; i++) {
        chartData.push({
          name: i+'月',
          value1: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value2: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_four',
          type: 'bar',
          itemName: 'name',
          legend: { show: true, left: 'right', top: 40},
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '转化金额', valueKey: 'value1'},
            { name: '激励金额', valueKey: 'value2'}
          ],
          data: chartData,
          color: ['#FF7F5D', '#FCFF00']
        })
      } else {
        kyptCharts.reload('appraisal_four', {data: chartData});
      }
    }
  }


  // 成果转化数量趋势分析
  chartInit.appraisalOne();

  // 各单位成果转化激励人数
  chartInit.appraisalTwo();

  // 成果转化数量按成果类型分析
  chartInit.appraisalThree();

  // 各单位成果转化金额/激励金额
  chartInit.appraisalFour();
});
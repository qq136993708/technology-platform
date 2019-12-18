function getProjectData(data, key, value) {
  var itemData = null;
  for (var i = 0; i < data.length; i++) {
    if (data[i][key] === value) {
      itemData = data[i];
      break;
    }
  }
  return itemData;
}

layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  keyData = [
    { name: '核能开发', valueKey: 'nuclearEnergyDev'},
    { name: '集中开发', valueKey: 'focusDev'},
    { name: '国防基础', valueKey: 'nationalDefense'},
    { name: '国防技术基础', valueKey: 'defenseTechnology'}
  ];

  var initChart = {
    cahrtOne: function() {
      // 项目投资计划年度趋势分析

      // 模拟数据 年度趋势分析
      var projectData = [
        {
          year: '2019',
          nuclearEnergyDev: 1800,
          focusDev: 2000,
          nationalDefense: 3900,
          defenseTechnology: 1200
        },
        {
          year: '2018',
          nuclearEnergyDev: 3900,
          focusDev: 5800,
          nationalDefense: 4100,
          defenseTechnology: 1210
        },
        {
          year: '2017',
          nuclearEnergyDev: 6000,
          focusDev: 2000,
          nationalDefense: 3200,
          defenseTechnology: 1400
        }
      ];

      // 渲染报表
      kyptCharts.render({
        id: 'cahrtOne',
        type: 'bar',
        barGap: '50%',
        barWidth: 28,
        itemName: 'labelName',
        grid: { top: 50 },
        series: [
          { name: '2019', valueKey: 'value2019'},
          { name: '2018', valueKey: 'value2018'},
          { name: '2017', valueKey: 'value2017'}
        ],
        data: (function() {
          var chartData = [];
          $.each(keyData, function(i, item) {
            var itemData = {
              labelName: item.name,
              value2017: getProjectData(projectData, 'year', '2017')[item.valueKey],
              value2018: getProjectData(projectData, 'year', '2018')[item.valueKey],
              value2019: getProjectData(projectData, 'year', '2019')[item.valueKey]
            };
            chartData.push(itemData);
          })
          return chartData;
        })(),
        color: ['#0AA1FF', '#5DAC4A', '#FCBD3B']
      })
    },
    chartTwo: function(date) {
      // 项目计划投资按项目类型占比分析
      var chartData = [], itemName = ['国防技术基础', '国防基础', '集中开发', '核能开发'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'chartTwo',
          type: 'pie',
          title: ' 项目计划投资',
          series: chartData,
          color: ['#FFDF29', '#2370A3', '#009186', '#9EBE4A']
        });
      } else {
        kyptCharts.reload('chartTwo', {series: chartData});
      }
    },
    chartThree: function(date) {
      // 项目投资计划按机构占比分析
      var chartData = [], itemName = [
        '中核院',
        '核工院',
        '核能院',
        '核设计院',
        '核工业院',
        '核出版社',
        '核物流院',
        '核三一院'
      ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }
  
      if (!date) {
        kyptCharts.render({
          id: 'chartThree',
          type: 'pie',
          title: ' 项目投资计划',
          series: chartData,
          color: ['#FFDF29', '#9EBE4A', '#5DAC4A', '#009186', '#2370A3', '#845596', '#F07045', '#FCBD3B']
        });
      } else {
        kyptCharts.reload('chartThree', {series: chartData})
      }
    },
    chartFour: function(date) {
      // 实际完成投资按项目类型占比分析
      var chartData = [], itemName = ['国防技术基础', '国防基础', '集中开发', '核能开发'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }
  
      if (!date) {
        kyptCharts.render({
          id: 'chartFour',
          type: 'pie',
          title: ' 实际完成投资',
          series: chartData,
          color: ['#FFDF29', '#9EBE4A', '#5DAC4A', '#009186', '#2370A3', '#845596', '#F07045', '#FCBD3B']
        });
      } else {
        kyptCharts.reload('chartFour', {series: chartData})
      }
    },
    chartFive: function(date) {
      // 实际完成投资按机构占比分析
      var chartData = [], itemName = [
        '中核院',
        '核工院',
        '核能院',
        '核设计院',
        '核工业院',
        '核出版社',
        '核物流院',
        '核三一院'
      ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }
  
      if (!date) {
        kyptCharts.render({
          id: 'chartFive',
          type: 'pie',
          title: ' 实际完成投资',
          series: chartData,
          color: ['#FFDF29', '#9EBE4A', '#5DAC4A', '#009186', '#2370A3', '#845596', '#F07045', '#FCBD3B']
        });
      } else {
        kyptCharts.reload('chartFive', {series: chartData})
      }
    },
    chartSix: function(date) {
      // 投资计划达成率分析
      var time = date || '2019',
      chartData = [],
      xlabelData = [
        '中核院',
        '核工院',
        '核能院',
        '核设计院',
        '核出版社',
        '核二院',
        '核三院',
        '核总院'
      ];

      for (var i = 0; i < xlabelData.length; i++) {
        var _plannedvalue = (parseInt(Math.random() * 400) + 100), // 计划值
        _actualValue = (parseInt(Math.random() * 400) + 100), // 实际值
        _completionRate = parseFloat(_actualValue / _plannedvalue * 100).toFixed(2);
        chartData.push({
          name: xlabelData[i],
          plannedvalue: (parseInt(Math.random() * 400) + 100), // 计划值
          actualValue: (parseInt(Math.random() * 400) + 100), // 实际值
          completionRate: _completionRate // 达成率
        })
      }
  
      if (!date) {
        kyptCharts.render({
          id: 'addProjectMonth',
          type: 'bar',
          barWidth: 28,
          itemName: 'name',
          barGap: '50%',
          grid: { top: 50 },
          series: [
            { name: '计划', valueKey: 'plannedvalue'},
            { name: '实际', valueKey: 'actualValue'},
            { name: '计划达成率', valueKey: 'completionRate', type: 'line', yIndex: 1},
          ],
          yAxis: [{ max: 500, splitNumber: 4}, { splitNumber: 4, max: 500, axisLabel: { show: true, formatter: '{value}%'}}],
          data: chartData,
          color: ['#FCBD3B', '#0AA1FF', '#727272']
        })
      } else {
        kyptCharts.reload('addProjectMonth', {data: chartData});
      }
    }
  }

  // 项目投资计划年度趋势分析
  initChart.cahrtOne();

  // 项目计划投资按项目类型占比分析
  initChart.chartTwo();
  laydate.render({
    elem: '#chartTwoDate',
    type: 'month',
    value: '2019-12',
    done: function(value, date, endDate) {
      initChart.chartTwo(value);
    }
  });

  // 项目投资计划按机构占比分析
  initChart.chartFour();
  laydate.render({
    elem: '#chartThreeDate',
    type: 'month',
    value: '2019-12',
    done: function(value, date, endDate) {
      initChart.chartFour(value);
    }
  });

  // 实际完成投资按项目类型占比分析
  initChart.chartThree();
  laydate.render({
    elem: '#chartFourDate',
    type: 'month',
    value: '2019-12',
    done: function(value, date, endDate) {
      initChart.chartThree(value);
    }
  });

  // 实际完成投资按机构占比分析
  initChart.chartFive();
  laydate.render({
    elem: '#chartFiveDate',
    type: 'month',
    value: '2019-12',
    done: function(value, date, endDate) {
      initChart.chartFive(value);
    }
  });

  // 投资计划达成率分析
  initChart.chartSix();
  laydate.render({
    elem: '#projectMonth',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      initChart.chartSix(value);
    }
  });

})

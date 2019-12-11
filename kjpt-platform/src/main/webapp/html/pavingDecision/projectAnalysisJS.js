function getChartOption(config) {


  var seriesData = [], legendData = [], categoryData = [];

  $.each(config.series, function(index, item) {
    categoryData.push(item.name);
  })

  $.each(config.data, function(i, item) {
    itemData = [];
    legendData.push(item[config.itemName]);
    $.each(config.series, function(index, subItem) {
      itemData.push(item[subItem.valueKey])
    })
    seriesData.push({
      name: item[config.itemName],
      data: itemData,
      type: 'bar',
      barWidth: 28,
      label: {
        show: true,
        position: 'top',
        color: '#46484B',
        fontSize: 12
      }
    });
  })
  
  var option = {
    grid: {
      left: 60,
      right: 100,
      bottom: 20,
      top: 80,
      containLabel: true
    },
    legend: {
      show: true,
      left: 60,
      top: 10,
      itemWidth: 12,
      itemHeight: 12,
      padding: 0,
      itemGap: 12,
      textStyle: {
        fontSize: 12,
        lineHeight: 12
      },
      data: legendData,
    },
    xAxis: {
      type: 'category',
      data: categoryData,
      axisTick: {show: false},
      splitLine: {show: false},
      axisLine: { show: true, lineStyle: {color: '#ABB0BB'} },
      axisLabel: {
        show: true,
        fontSize: 14,
        color: '#46484B'
      }
    },
    yAxis: {
      type: 'value',
      axisLine: {show: false},
      axisTick: {show: false},
      axisLabel: {
        show: true,
        color: '#ABB0BB',
        fontSize: 12
      },
      splitLine: {
        show: true,
        lineStyle: {
          color: '#DBE0E2'
        }
      }
    },
    series: seriesData,
    color: ['#0AA1FF', '#5DAC4A', '#FCBD3B']
  };
  return option;
}
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
var addProjectChart = echarts.init(document.getElementById('addProject'));
addProjectChart.setOption(getChartOption({
  itemName: 'year',
  series: [
    { name: '核能开发', valueKey: 'nuclearEnergyDev'},
    { name: '集中开发', valueKey: 'focusDev'},
    { name: '国防基础', valueKey: 'nationalDefense'},
    { name: '国防技术基础', valueKey: 'defenseTechnology'}
  ],
  data: projectData
}));

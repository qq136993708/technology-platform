// 报表初始化
var kyptCharts = {
  render: function (config) {
    var _this = this;

    if (!config.id || !config.type) {
      top.layer.alert('[kyptCharts]图表类型与ID不能为空！')
      return null;
    } else {
      _this.chart[config.id] = {
        config: {}
      };
      for (var key in config) {
        _this.chart[config.id].config[key] = config[key];
      }
    };

    var elem = document.getElementById(config.id),
    chartDemo = echarts.init(elem),
    chartOption = _this.getChartOption(config);

    // 渲染图表
    chartDemo.setOption(chartOption);
    
    // 窗口大小变化时，更新图表渲染
    var chartTime = null;
    $(window).resize(function() {
      if (chartTime) {
        clearTimeout(chartTime);
      }
      chartTime = setTimeout(function() {
        chartDemo.resize();
      }, 200);
    })
  
    // 回调函数，返回图表对象
    if (config.callback) {
      config.callback(chartDemo);
    }

    _this.chart[config.id].chart = chartDemo;
  },
  reload: function(id, config) {
    if (!id) {
      return null;
    } else {
      var _this = this;

      if (!config) {
        _this.chart[id].chart.resize();
      } else if (typeof(config) === 'object') {
        for (var key in config) {
          _this.chart[id].config[key] = config[key];
          _this.chart[id].chart.setOption(_this.getChartOption(_this.chart[id].config));
        }
      }
    }
  },
  getLBOption: function(config) {
    // 获取直角坐标系配置
    var seriesData = [],
    legendData = [],
    categoryData = [],
    _this = this,
    label = (function() {
      if (typeof(config.label) === 'boolean') {
        return config.label;
      } else {
        return true;
      }
    })(),
    lineColor = config.lineColor || '#ABB0BB',
    valueColor = config.valueColor || '',
    labelColor = config.labelColor || '#46484B',
    barMaxWidth = 28;
    if (config.type === 'bar' && config.series.length > 1) {
      barMaxWidth = 18;
    }

    $.each(config.series, function(index, item) {
      legendData.push(item.name);
  
      var itemData = [];
      $.each(config.data, function(index, subItem) {
        itemData.push(subItem[item.valueKey])
      })

      var seriesItem = {
        name: item.name,
        data: itemData,
        type: item.type || config.type,
        // type: 'pictorialBar',
        barMaxWidth: barMaxWidth,
        barWidth: config.barWidth || 28,
        barGap: 0,
        label: {
          show: label,
          position: 'top',
          color: '#46484B',
          fontSize: 12
        }
      };

      if (item.yIndex || item.yIndex === 0) {
        seriesItem.yAxisIndex = item.yIndex;
      }
      seriesData.push(seriesItem);
    })
  
    $.each(config.data, function(i, item) {
      categoryData.push(item[config.itemName]);
    })
    
    var option = {
      grid: (function() {
        var gridItem = {
          left: 10,
          right: 10,
          bottom: 24,
          top: 24,
          containLabel: true
        };
        if (config.grid) {
          for (var key in config.grid) {
            gridItem[key] = config.grid[key];
          }
        }
        return gridItem;
      })(),
      legend: (function() {
        var lenendItem = {
          show: true,
          left: 10,
          top: 10,
          itemWidth: 18,
          itemHeight: 12,
          padding: 0,
          itemGap: 12,
          textStyle: {
            fontSize: 12,
            lineHeight: 12,
            color: labelColor
          },
          data: legendData,
        }
        if (config.legend) {
          for (var key in config.legend) {
            lenendItem[key] = config.legend[key];
          }
        }
        return lenendItem;
      })(),
      tooltip: {
        show: true,
        trigger: 'axis',
        axisPointer: {
          type: (function(){
            if (config.type === 'line') {
              return 'line';
            } else {
              return 'shadow';
            }
          })()
        }
      },
      xAxis: {
        type: 'category',
        data: categoryData,
        axisTick: {show: false},
        splitLine: {show: false},
        axisLine: { show: true, lineStyle: {color: lineColor} },
        axisLabel: {
          show: true,
          fontSize: 14,
          color: labelColor
        }
      },
      yAxis: (function() {
        var yAxis = [], valueAxis = {
          type: 'value',
          axisLine: {show: false},
          axisTick: {show: false},
          axisLabel: {
            show: true,
            color: valueColor,
            fontSize: 12
          },
          splitLine: {
            show: true,
            lineStyle: { color: lineColor }
          }
        };
  
        if (config.yAxis && typeof(config.yAxis) === 'object' && config.yAxis.length) {
          $.each(config.yAxis, function(i, valItem) {
            var newValueAxis = _this.transformData(valueAxis);
            if (valItem && typeof(valItem) === 'object') {
              newValueAxis = _this.transformData(valItem);
            }
            yAxis.push(newValueAxis);
          })
        } else {
          yAxis.push(valueAxis);
        }
        return yAxis;
      })(),
      series: seriesData,
      color: config.color || '#0AA1FF'
    };

    if (option.legend && option.legend.show && !option.legend.top) {
      option.grid.top = 72;
    }

    return option;
  },
  getPieChartOption: function(config) {
    var _this = this,
    label = (function() {
      if (typeof(config.label) === 'boolean') {
        return config.label;
      } else {
        return true;
      }
    })(),
    labelColor = config.labelColor || '#46484B',
    borderColor = config.borderColor || '';

    // 饼图环图配置
    var option = {
      title: (function() {
        if (config.title) {
          var titleItem = {
            text: '-',
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
          }
          if (config.title === 'value') {
  
          } else {
            titleItem.text = config.title;
          }
        }
      })(),
      tooltip:  {
        show: true,
        trigger: 'item',
        axisPointer: {
          type: 'shadow'
        }
      },
      legend: (function() {
        var legendItem = {
          show: true,
          orient: 'vertical',
          left: 10,
          top: 20,
          itemWidth: 12,
          itemHeight: 12,
          padding: 0,
          itemGap: 16,
          textStyle: {
            color: labelColor
          }
        }
        if (config.legend) {
          for (var key in config.legend) {
            legendItem[key] = config.legend[key];
          }
        }
        return legendItem;
      })(),
      series: [
        {
          // name: config.title || 'pieTile',
          type:'pie',
          radius: config.radius || ['50%', '70%'],
          center: config.center || ['60%', '50%'],
          avoidLabelOverlap: false,
          labelLine: {
            show: label,
            length: 10,
            length2: 20,
            lineStyle: {
              color: '#979797'
            }
          },
          data: config.series,
          label: {
            show: label,
            // position: 'inside',
            color: '#313232',
            formatter: '{c}\n{d}%'
          },
          itemStyle: {
            borderWidth: (borderColor ? 2 : 0),
            borderColor: borderColor || '#fff'
          }
          
        }
      ],
      color: config.color || '#0AA1FF'
    };
    return option;
  },
  getChartOption: function (config) {
    var _this = this;
    if (config.type === 'bar' || config.type === 'line') {
      return _this.getLBOption(config);
    } else if (config.type === 'pie') {
      return _this.getPieChartOption(config);
    }
  },
  transformData(data) {
    var valueData = null, _this = this;
    if (data && typeof(data) === 'object') {
      if (data.length || data.length === 0) {
        valueData = [];
        for (var i = 0; i < data.length; i++) {
          if (typeof(data[i]) !== 'object') {
            valueData[i] = data[i];
          } else {
            valueData[i] = _this.transformData(data[i]);
          }
        }
      } else {
        valueData = {};
        for (var key in data) {
          if (typeof(data[key]) !== 'object') {
            valueData[key] = data[key];
          } else {
            valueData[key] = _this.transformData(data[key]);
          }
        }
      }
    } else if (data) {
      valueData = data;
    }

    return valueData;
  },
  chart: {}
}

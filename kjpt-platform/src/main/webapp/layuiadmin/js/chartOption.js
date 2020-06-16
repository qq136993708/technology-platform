// 报表初始化
var kyptCharts = {
  /*
  config = {
    id: ElementId,
    type: 'bar' | 'line' | 'pie', // 图表类型
    itemName: string, // 类名轴显示文字对应的字段 key
    legend: object, // 图例的一些配置， 与官网 option.legend一致 {show: false } => 表示不显示图例
    grid: object, // 绘图区域配置 与官网保持一致
    lineColor: '#bababa', // 坐标轴在 grid 区域中分隔线的颜色
    axisLineColor: '', // X,Y 轴线颜色 axisLineColor
    valueColor: '#333', // X、Y轴axisLabel 文字颜色
    labelColor: '#46484B' // 图形上的文本标签（label） 的文字颜色
    label: true | object, // 是否显示文本标签; 默认为 true; object与官网保持一致
    labelRotate: 0, // 类名轴显示文字旋转度数；默认为0
    labelLenth: number, // 类名轴显示文本超出多少长度时行显示
    labelMaxNumber: number, // 类名轴最多显示少个类名，超出滚动条
    color: Array<string|[string, string]> | string, // 图例对应的颜色，顺序与series对应；
    yAxis: Array<{}|null>, // {} 配置与官网数值轴一致； 当有两个数值轴时 yAxis必填； yAxis内对应的数值轴不配置传null;
    series: Array<{
      name: string, // 图例名称
      valueKey: string, // 图例对应值的字段 key; type = (line、bar) 有效
      value: number, // 图例对应的值； type = pie 有效
      type: 'line' | 'bar', // 当前图例的类型config.type = pie 时无效； 优先于config.type;
      yIndex: number, // 当前有两个数值轴时不指定 yIndex；默认取 0（对应第一根数值轴）； 必须配合 config.yAxis使用；
    }>,
    data: Array<any>, // type = 'line'|'bar'时有效；图例数据源
    barWidth: number, // 柱子的宽度
    barMinHeight: 0, // 柱子的最小高度
    barGap: 0, // 同一类名区域有多个柱子时柱子间的间隔； 默认为0；
    valueIndex: 'y' | 'x', // 用哪个轴作为数值轴； 默认为y轴
    legendPosition: 'left|right|top|bottom',
    // 启动HTML标签作为图例并设置图例放置位置；css样式再common.css 中; 不加载会乱；
    // legendPosition = 'left'或'right', 设置legend.top = 'center'，可以垂直居中
    // 设置legend.top = 20，图例距离顶部20px
    // 设置legend.formatter = 'name|value'; 可以在图例上显示对应图例的值
    radius: [string, string], // 饼图pie.series[i].radius 配置；与官网一致
    center: [string, string], // 饼图pie.series[i].center 配置；与官网一致
    borderColor: string, // 饼图边框颜色，与底色想同时可以产生间隔 line/bar 无效
    title: object, // 饼图title配置 与官网保持一致
    totalTitle: false, // 是否环图中间显示总数量; 默认不显示
    callback: Function, // 回调函数；返回一个参数 => 当前图表实例chart

    // 更多功能请自行添加修改
  }
  */
  emptyChart: function(id, config) {
    var emptyData = true;

    if (config.type === 'pie') {
      if (config.series.length > 0) {
        emptyData = false;
      }
    } else {
      if (config.data.length > 0) {
        emptyData = false;
      }
    }
    
    if (emptyData) {
      if ($('#'+ id).find('.chart-data-empty').length <= 0) {
        $('#'+ id).append('<div class="chart-data-empty middle-block"><span class="ib-block font16">无数据</span></div>');
      }
    } else {
      $('#' + id + ' .chart-data-empty').remove();
    }

    return emptyData;
  },
  render: function (config) {
    var _this = this;

    if (!config.id || !config.type) {
      top.layer.alert('[kyptCharts]图表类型与ID不能为空！')
      return null;
    } else {
      _this.chart[config.id] = {
        config: {}, chart: null
      };
      for (var key in config) {
        _this.chart[config.id].config[key] = config[key];
      }
    };

    var $chartParent = $('#' + config.id),
    chartOption = _this.getChartOption(config),
    elem = $('<div style="height: 100%;" class="dy-chart-layout"></div>').get(0);
    $chartParent.css({position: 'relative'}).append($(elem));
    if (config.legendPosition) {
      _this.setChartLegend(config, chartOption.legend);
      chartOption.legend.show = false;
    }

    _this.emptyChart(config.id, _this.chart[config.id].config);


    var chartDemo = echarts.init(elem);
    _this.chart[config.id].chart = chartDemo;

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
        }

        var chartOption = _this.getChartOption(_this.chart[id].config);
        if (_this.chart[id].config.legendPosition) {
          _this.setChartLegend(_this.chart[id].config, chartOption.legend);
          chartOption.legend.show = false;
        }

        //判断图表是否数据为空
        _this.emptyChart(id, _this.chart[id].config);

        // 有无数据都要重新渲染图表
        var chartDome=_this.chart[id].chart.setOption(chartOption);
        _this.chart[id].chart.resize();
      }
    }
  },
  getLBOption: function(config) {
    // 获取直角坐标系配置
    var seriesData = [],
    legendData = [],
    categoryData = [],
    _this = this,
    lineColor = config.lineColor || '#ABB0BB',
    axisLineColor = config.axisLineColor || '',
    valueColor = config.valueColor || '',
    labelColor = config.labelColor || '#46484B',
    barMaxWidth = 28,
    showAxisLine = true;

    if (
      (config.type === 'pie' && config.series.length <= 0) ||
      (config.type === 'line' || config.type === 'bar') && config.data.length <= 0
    ) {
      showAxisLine = false;
    }

    if (config.type === 'bar' && config.series.length > 1) {
      barMaxWidth = 18;
    }

    $.each(config.series, function(index, item) {
      legendData.push(item.name);
  
      var itemData = [];
      $.each(config.data, function(index, subItem) {
        itemData.push(subItem[item.valueKey])
      })

      var colorValue = null, itemStyle = null;
      if (typeof(config.color) === 'object' && config.color[index]) {
        colorValue = config.color[index];

        if (typeof(colorValue) === 'object') {
          itemStyle = {
            color: { type: 'linear', x: 0, y: 0, x2: 0, y2: 1,
            // x: 1, y: 0, x2: 0, y2: 1,
              colorStops: [{
                  offset: 0, color: colorValue[0] // 0% 处的颜色
              }, {
                  offset: 1, color: colorValue[1] // 100% 处的颜色
              }],
              global: false // 缺省为 false
            }
          }
          // 横向柱子渐变色渲染
          if (config.valueIndex && config.valueIndex === 'x') {
            var targetValue = {x: 1, y: 0, x2: 0, y2: 1};
            for (var key in targetValue) {
              itemStyle.color[key] = targetValue[key];
            }
          }
        }
      }

      var seriesItem = {
        name: item.name,
        data: itemData,
        type: item.type || config.type,
        // type: 'pictorialBar',
        stack: (item.stack || ('stack' + index)),
        barMaxWidth: config.barWidth || barMaxWidth,
        barWidth: config.barWidth || barMaxWidth,
        barMinHeight: config.barMinHeight || 0,
        barGap: config.barGap || 0,
        label: {
          show: true,
          position: 'top',
          color: labelColor || '#46484B',
          fontSize: 16,
          fontFamily:'Impact'
        }
      };

      if (typeof(config.label) === 'object') {
        for (var key in config.label) {
          seriesItem.label[key] = config.label[key]; 
        }
      } else if (typeof(config.label) === 'boolean') {
        seriesItem.label.show = config.label;
      }
      seriesItem.itemStyle = item.itemStyle?item.itemStyle:{};
      if (itemStyle) {
        seriesItem.itemStyle = itemStyle;
      }

      if (item.yIndex || item.yIndex === 0) {
        seriesItem.yAxisIndex = item.yIndex;
      }
      seriesData.push(seriesItem);
    })
    
    // 超出长度换行显示
    var textLenth = config.labelLenth || 0;
    $.each(config.data, function(i, item) {
      var itemName = item[config.itemName],
      newText = '';
      if (textLenth && (itemName.length > textLenth)) {
        var maxLenth = Math.ceil(itemName.length / textLenth);
        for (var i = 0; i < maxLenth; i++) {
          newText += (itemName.substr(i*textLenth, textLenth) + '\n');
        }
        newText = newText.substring(0, newText.length - 2);
      } else {
        newText = itemName;
      }
      categoryData.push(newText);
    })
    
    var itemCategory = [{
      type: 'category',
      data: categoryData,
      axisTick: {show: false},
      splitLine: {show: false},
      // axisLineColor
      axisLine: { show: showAxisLine, lineStyle: {color: (axisLineColor || lineColor)} },
      axisLabel: {
        show: true,
        fontSize: 14,
        color: labelColor,
        rotate: config.labelRotate || 0
      }
    }],
    itemValueAxis = (function() {
      var yAxis = [], valueAxis = {
        type: 'value',
        axisLine: {
          show: (axisLineColor ? true : false),
          lineStyle: { color: (axisLineColor || lineColor) }
        },
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
            for (var key in valItem) {
              if (key !== 'formatter') {
                newValueAxis[key] = valItem[key];
              }
            }
            if (valItem.formatter) {
              newValueAxis.axisLabel.formatter = valItem.formatter;
            }
          }
          yAxis.push(newValueAxis);
        })
      } else {
        yAxis.push(valueAxis);
      }
      return yAxis;
    })(),
    option = {
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
      tooltip: (function(){
        var tooltipItem = {
            show: true,
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
        }
          if (config.tooltip) {
              for (var key in config.tooltip) {
                  tooltipItem[key] = config.tooltip[key];
              }
          }
          return tooltipItem;
      }) (),
      // tooltip: {
      //   show: true,
      //   trigger: 'axis',
      //   axisPointer: {
      //     type: (function(){
      //       if (config.type === 'line') {
      //         return 'line';
      //       } else {
      //         return 'shadow';
      //       }
      //     })()
      //   }
      // },
      xAxis: null,
      yAxis: null,
      series: seriesData,
      color: config.color || '#0AA1FF'
    };

    if (typeof(config.tooltip) === 'object') {
      for(var key in config.tooltip) {
        option.tooltip[key] = config.tooltip[key];
      } 
    } else if (typeof(config.tooltip) === 'boolean') {
      option.tooltip.show = config.tooltip;
    }

    if (option.legend && option.legend.show && !option.legend.top) {
      option.grid.top = 72;
    }

    if (config.valueIndex && config.valueIndex === 'x') {
      option.xAxis = itemValueAxis;
      option.yAxis = itemCategory;
    } else {
      option.xAxis = itemCategory;
      option.yAxis = itemValueAxis;

      // 是否添加横向滚动条
      if (config.labelMaxNumber) {
        for(var i = 0; i < option.xAxis.length; i++) {
          // 显示所有类目名
          option.xAxis[i].axisLabel.interval = 0;
        }

        if (categoryData.length > config.labelMaxNumber) {
          option.dataZoom = {
            show: true,
            realtime: true,
            type: 'slider',
            left: option.grid.left,
            right: option.grid.right,
            startValue: 0,
            endValue: (config.labelMaxNumber - 1),
            showDetail: false,
            showDataShadow: false,
            filterMode: 'none',
            height: 18,
            fillerColor: '#ccc',
            handleStyle: { opacity: 0 },
            dataBackground: { lineStyle: {opacity: 0}, areaStyle: {opacity: 0} },
            backgroundColor: '#fff',
            borderColor: '#fff'
          };

          if (config.dataZoom) {
            for (var key in config.dataZoom) {
              option.dataZoom[key] = config.dataZoom[key];
              if (key === 'backgroundColor') {
                option.dataZoom.borderColor = config.dataZoom.backgroundColor;
              }
            }
          }
          if (typeof(option.grid.bottom) === 'number') {
            option.grid.bottom += 30;
          } else {
            option.grid.bottom = 60;
          }
        }
      }
    }
    return option;
  },
  setChartLegend: function(config, pieLegend) {
    // 饼图图例是否显示
    if (config.series && config.series.length) {
      var _this = this,
      itemHtml = '',
      $parent = $('#'+config.id),
      legendColor = config.color || [],
      formatter = (function() {
        if (pieLegend.formatter) {
          return pieLegend.formatter.split('|');
        } else {
          return ['name'];
        }
      })(),
      $legend = (function() {
        if ($parent.find('.pie-legend-list').length) {
          $parent.find('.pie-legend-list').remove();
        }
        var legendClass = config.legendPosition + ' ' + (pieLegend.orient || 'horizontal');

        return $('<div class="pie-legend-list"></div>').addClass(legendClass);
      })(),
      $center = (function() {
        if (pieLegend.top === 'center' || pieLegend.bottom === 'center') {
          $legend.addClass('middle-block');
          return $('<div class="ib-block"></div>');
        } else {
          return null;
        }
      })();

      if (typeof(legendColor) === 'string') {
        legendColor = [legendColor];
      }
      $.each(config.series, function(i, item) {
        var $item = $('<label class="legend-item" title="'+item.name+'"></label>'),
        itemColor = legendColor[i] || legendColor[0];
        if (typeof(itemColor) === 'object') {
          itemColor = itemColor[1];
        } else if (!itemColor) {
          itemColor = '#0AA1FF';
        }
        itemHtml = '<span class="lenend-item-icon '+ (item.type || config.type) +'" style="background-color:'+itemColor+'"></span>';
        itemHtml += '<span class="lenend-item-name" >'+ item.name +'</span>';
        if (formatter.indexOf('value') >= 0) {
          itemHtml += '<span class="lenend-item-value">'+ item.value +'</span>';
        }
        if (item.page) {
          $item.attr('data-page', item.page)
        }
      
        $item.append(itemHtml);
        if ($center) {
          $center.append($item);
        } else {
          $legend.append($item);
        }
        
        // 添加图例事件
        $item.off('click').on({
          'click': function(e) {
            if($(this).attr('data-page')){
              jscPup($(this).attr('data-page'),encodeURI($(this).attr('title')));
            }else{
            var optionChart = _this.chart[config.id].chart.getOption(),
            legendSelected = optionChart.legend.selected || {};
            if ($(this).hasClass('selected')) {
              $(this).removeClass('selected');
              legendSelected[item.name] = true;
            } else {
              $(this).addClass('selected');
              legendSelected[item.name] = false;
            }
            _this.chart[config.id].chart.setOption({ legend: {selected: legendSelected} });
            }
          }
        })
      });

      if ($center) {
        $legend.append($center);
      }
      $parent.append($legend);
      $legend.css({
        'padding-top': pieLegend.top || 'auto',
        'padding-right': pieLegend.right || 'auto',
        'padding-bottom': pieLegend.bottom || 'auto',
        'padding-left': pieLegend.left || 'auto',
        color: pieLegend.textStyle.color || '#333'
      })

      var className = 'padding-' + config.legendPosition, classValue = {};
      if (config.legendPosition === 'left' || config.legendPosition === 'right') {
        classValue[className] = $legend.outerWidth();
      } else {
        classValue[className] = $legend.outerHeight();
      }
      $parent.css(classValue);
      return true;
    } else {
      return false;
    }
  },
  getPieChartOption: function(config) {
    var _this = this,
    label = (function() {
      if (typeof(config.label) === 'boolean') {
        return config.label;
      } else {
        return config.label || false;
      }
    })(),
    labelColor = config.labelColor || '#46484B',
    borderColor = config.borderColor || '',
    dataSeries = config.series;

    if (typeof(label) === 'object' && dataSeries.length) {
      for (var i = 0 ; i < dataSeries.length; i++) {
        var temp_color = (function() {
          if (typeof(config.color[i]) === 'object') {
            return config.color[i][1];
          } else if (typeof(config.color[i]) === 'string') {
            return config.color[i];
          } else {
            return '#979797';
          }
        })();

        dataSeries[i].label = label;
        dataSeries[i].emphasis = {labelLine: { show: true}};
        dataSeries[i].labelLine = {
          show: true, length: 10, length2: 20, lineStyle: { color: temp_color}
        };
        if (dataSeries[i].label.rich && dataSeries[i].label.rich.a) {
          dataSeries[i].label.rich.a.borderColor = temp_color;
          dataSeries[i].label.rich.a.color = '#fff';
        }
      }
    }



    // 饼图环图配置
    var option = {
      title: (function() {
        var titleItem = {
          text: '',
          top: 'center',
          left: '50%',
          textAlign: 'center',
          textStyle: {
            color: '#fff',
            fontWeight: 'normal',
            fontSize: 14,
            lineHeight: 20,
          },
          padding: 0,
          itemGap: 0
        }
        if (typeof(config.title) === 'object') {
          for (var key in config.title) {
            titleItem[key] = config.title[key];
          }
        }
        return titleItem;
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
        if (config.pieFormattr && config.series) {

        }
        return legendItem;
      })(),
      series: [
        {
          // name: config.title || 'pieTile',
          type:'pie',
          radius: config.radius || ['50%', '70%'],
          center: config.center || ['50%', '50%'],
          avoidLabelOverlap: false,
          labelLine: {
            show: typeof(label) === 'boolean' ? label :  false,
            length: 10,
            length2: 20,
            lineStyle: {
              color: '#979797'
            }
          },
          data: dataSeries,
          label: {
            show: typeof(label) === 'boolean' ? label : false,
            // position: 'inside',
            color: '#313232',
            formatter: '{c}\n{d}%'
          },
          itemStyle: {
            borderWidth: (borderColor ? 2 : 0),
            borderColor: borderColor || '#fff'  // 饼图空隙
          } 
          
        }
      ],
      color: config.color || '#0AA1FF'
    };

    if (typeof(config.tooltip) === 'object') {
      for(var key in config.tooltip) {
        option.tooltip[key] = config.tooltip[key];
      } 
    } else if (typeof(config.tooltip) === 'boolean') {
      option.tooltip.show = config.tooltip;
    }

    if (config.totalTitle && config.series.length) {
      var totalTitle = 0;
      for (var i = 0; i < config.series.length; i++) {
        if (config.series[i].value || config.series[i].value !== '-') {
          totalTitle += parseFloat(config.series[i].value);
        }
      }
      option.title.text = totalTitle;

      if (config.center) {
        option.title.left = config.center[0];
      } else {
        option.title.left = '50%';  
      } 
      if(config.company){
        option.title.subtext =  config.company;
      }
    }

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
  transformData: function(data) {
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
};

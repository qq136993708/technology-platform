layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    getChartData: function(config) {
      if (config.strKey) {
        var dateValue = new Date().getTime(),
        httpUrl = '/qims-api/qualityStatistics/query?';
        dateValue = (dateValue - 1000*60*60*24);
        dateValue = new Date(dateValue).format('yyyy-MM-dd') + ' 00:00:00';
        httpUrl = httpUrl + 'key=' + config.strKey + '&date=' + dateValue;
  
        httpModule({
          url: httpUrl, 
          success: function(res) {
            if (res && res.data.data[0]) {
              var relData = res.data.data[0].indicatorDataList,
              chartType = res.data.data[0].indicatorDefine.chartType,
              chartConfig = {series: []},
              subTitle = '';
  
              if (chartType === 'pie') {
                var pieData = relData[0],
                legendData = pieData.legend.split(','),
                valueData = pieData.ydata.split(',');
                $.each(legendData, function(i, item) {
                  chartConfig.series.push({
                    name: item, value: valueData[i]
                  });
                })
                subTitle = pieData.subtext;
              } else {
                chartConfig.data = [];
                subTitle = relData[0].subtext;

                var legendData = relData[0].legend.split(',');
                $.each(legendData, function(i, item) {
                  chartConfig.series.push({name: item, valueKey: ('value_' + i) });
                });
                $.each(relData, function(i ,item) {
                  var rowItem = switchHttpData(item),
                  _value = (function() {
                    if (typeof(rowItem.ydata) === 'string') {
                      return rowItem.ydata.split(',');
                    } else if (typeof(rowItem.ydata) === 'number') {
                      return [rowItem.ydata]
                    } else {
                      return ['-']
                    }
                  })();
                  $.each(_value, function(id, val) {
                    rowItem['value_'+id] = (function() {
                      if (!val && val !== 0) {
                        return '-';
                      } else {
                        return val;
                      }
                    })();
                  });
                  chartConfig.data.push(rowItem);
                })
              }
              if (config.callback) {
                if (config.legend && chartConfig.series) {
                  $.each(chartConfig.series, function(i, item) {
                    for (var key in config.legend[i]) {
                      if (!item[key]) {
                        chartConfig.series[i][key] = config.legend[i][key];
                      }
                    }
                  })
                }
                config.callback(chartConfig, subTitle);
              }
            }
          }
        });
      }
    },
    qualityOne: function(date) {
      // 同位素产品质量趋势图
      var legendData = [
        { name: '月度非计划停推次数', valueKey: 'value1'},
        { name: '人因失误导致的运行事件数', valueKey: 'value2'},
        { name: '累计平均人因失误导致的运行事件数', valueKey: 'value3'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_one',
        type: 'line',
        itemName: 'xdata',
        legend: { left: 0, top: 60 },
        grid: { top: 100 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        series: legendData,
        data: [],
        color: ['#EAFF74', '#00FF32', '#42FDFF', '#D300E0', '#FF7F5D', '#00ABE9']
      })

      // 获取数据
      this.getChartData({
        strKey: 'F-HD-01', // 核电运行质量趋势图
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_one', configData);

          var $title = $('#quality_one').siblings('.chart-title-layout');
          if (text) {
            $title.find('.sub_title_text').text(text);
          }
          var key1 = configData.series[0].valueKey,
          key2 =  configData.series[1].valueKey,
          total1 = 0, total2 = 0;
          $.each(configData.data, function(i, item) {
            total1 += (function() {
              if (item[key1] === '-') {
                return 0;
              } else {
                return parseFloat(item[key1]);
              }
            })();
            total2 += (function() {
              if (item[key2] === '-') {
                return 0;
              } else {
                return parseFloat(item[key2]);
              }
            })();
          });

          $title.find('.item-value').eq(0).text(total1);
          $title.find('.item-value').eq(1).text(total2);
        }
      });
    },
    qualityTwo: function (date) {
      // 2019年3季度工程建设|| 、|||类不合符项关闭率
      var legendData = [
        { name: '工程（%）', valueKey: 'value1'},
        { name: '设备（%）', valueKey: 'value2'},
        { name: '调试（%）', valueKey: 'value3'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_two',
        type: 'bar',
        itemName: 'xdata',
        legend: { show: true, left: 'right' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        barWidth: 18,
        label: false,
        series: legendData,
        data: [],
        color: ['#FFF04E', '#2687FF', '#FF7F5D']
      });

      // 获取数据
      this.getChartData({
        strKey: 'F-GC-00', // 2019年3季度工程建设|| 、|||类不合符项关闭率
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_two', configData);
          if (text) {
            $('#quality_two').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    qualityThree: function(date) {
      // 核材料/核燃料质量趋势图
      var legendData = [
        { name: '产品161一次交检合格率（%）', valueKey: 'value1'},
        { name: '产品162一次交检合格率（%）', valueKey: 'value2'},
        { name: '压水堆核燃料组件一次交检合格率（%）', valueKey: 'value3'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_three',
        type: 'line',
        itemName: 'xdata',
        legend: { show: true, left: '0' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        barWidth: 18,
        series: legendData,
        data: [],
        color: ['#EAFF74', '#00FF32', '#42FDFF']
      })

      // 获取数据
      this.getChartData({
        strKey: 'F-YZ-01', // 核材料/核燃料质量趋势图
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_three', configData);
          if (text) {
            $('#quality_three').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    qualityFour: function(date) {
      // 地浸质量数据统计
      var legendData = [
        { name: '浸采率（%）', valueKey: 'value1'},
        { name: '回收率（%）', valueKey: 'value2'},
        { name: '损失率（%）', valueKey: 'value3'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_four',
        type: 'bar',
        itemName: 'xdata',
        legend: { show: true, left: 'right' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        barWidth: 18,
        label: false,
        series: legendData,
        data: [],
        color: ['#FFF04E', '#2687FF', '#FF7F5D']
      });

      // 获取数据
      this.getChartData({
        strKey: 'F-DJ-01', // 地浸质量数据统计
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_four', configData);
          if (text) {
            $('#quality_four').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    qualityFive: function (date) {
      // 地质勘探质量趋势图
      var legendData = [
        { name: '累计完成钻孔数', valueKey: 'value1'},
        { name: '平均优质孔率（%）', valueKey: 'value2', type: 'line', yIndex: 1},
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_five',
        type: 'bar',
        itemName: 'xdata',
        legend: { show: true, left: 'right' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        barWidth: 18,
        label: false,
        yAxis: [null, {formatter: '{value}%'}],
        series: legendData,
        data: [],
        color: ['#FFF04E', '#2687FF', '#FF7F5D']
      });

      // 获取数据
      this.getChartData({
        strKey: 'F-DZ-01', // F-DZ-01地质勘探质量趋势图
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_five', configData);
          if (text) {
            $('#quality_five').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    qualitySix: function (date) {
      // 装备制造与仪器仪表生产质量趋势图
      var legendData = [
        { name: '产品161一次交检合格率（%）', valueKey: 'value1'},
        { name: '产品162一次交检合格率（%）', valueKey: 'value2'},
        { name: '压水堆核燃料组件一次交检合格率（%）', valueKey: 'value3'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'quality_six',
        type: 'line',
        itemName: 'xdata',
        legend: { show: true, left: '0' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        barWidth: 18,
        series: legendData,
        data: [],
        color: ['#EAFF74', '#00FF32', '#42FDFF']
      });

      // 获取数据
      this.getChartData({
        strKey: 'F-PY-01', // 装备制造与仪器仪表生产质量趋势图
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('quality_six', configData);
          if (text) {
            $('#quality_six').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },

    appraisalOne: function(date) {
      // 同位素产品质量趋势图
      var legendData = [
        { name: '医疗器械一次检验合格率（%）', valueKey: 'value1'},
        { name: '医疗器械出厂检验合格率（%）', valueKey: 'value2'},
        { name: '放射源一次检验合格率（%）', valueKey: 'value3'},
        { name: '放射源出厂检验合格率（%）', valueKey: 'value4'},
        { name: '放射性药品一次检验合格率（%）', valueKey: 'value5'},
        { name: '放射性药品出厂检验合格率（%）', valueKey: 'value6'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'appraisal_one',
        type: 'line',
        itemName: 'xdata',
        legend: { left: 0 },
        grid: { top: 85 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        series: legendData,
        data: [],
        color: ['#EAFF74', '#00FF32', '#42FDFF', '#D300E0', '#FF7F5D', '#00ABE9']
      });

      // 获取数据
      this.getChartData({
        strKey: 'F-TF-01', // 同位素产品质量趋势图
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_one', configData);
          if (text) {
            $('#appraisal_one').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    appraisalTwo: function (date) {
      // GB/T19001认证审核的主要不符合项条款
      var legendData = [
        { name: '数量', valueKey: 'value'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'appraisal_two',
        type: 'bar',
        itemName: 'xdata',
        legend: { show: true, left: 'right' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        barWidth: 18,
        label: false,
        series: legendData,
        data: [],
        color: ['#FFF04E', '#00AEFF', '#93E9FF']
      });

      // 获取数据
      this.getChartData({
        strKey: 'A213-a', // GB/T19001认证审核的主要不符合项条款
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_two', configData);
          if (text) {
            $('#appraisal_two').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    appraisalThree: function(date) {
      // GJB/T19001认证审核的主要不符合项条款
      var legendData = [
        { name: '数量', valueKey: 'value'}
      ];

      // 初始化配置图表参数
      kyptCharts.render({
        id: 'appraisal_three',
        type: 'bar',
        itemName: 'xdata',
        legend: { show: true, left: 'right' },
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        barWidth: 18,
        series: legendData,
        data: [],
        color: ['#81FF5B', '#00AEFF', '#93E9FF']
      });
      
      // 获取数据
      this.getChartData({
        strKey: 'A213-b', // GJB/T19001认证审核的主要不符合项条款
        legend: legendData,
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_three', configData);
          if (text) {
            $('#appraisal_three').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    appraisalFour: function(date) {
      // 最新季度内、外部质量损失占比
      kyptCharts.render({
        id: 'appraisal_four',
        type: 'pie',
        legendPosition: 'right',
        legend: { top: 'center', right:18, formatter: 'name|value'},
        label: false,
        labelColor: '#fff',
        radius: ['44%', '66%'],
        borderColor: '#001e38',
        title: '损失占比',
        series: [],
        color: ['#45F0FF', '#2687FF', '#2687FF']
      });

      // 获取数据
      this.getChartData({
        strKey: 'A214-08', // 最新季度内、外部质量损失占比
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_four', configData);
          if (text) {
            $('#appraisal_four').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    appraisalFive: function (date) {
      // 最新季度内部质量损失各科目占比
      kyptCharts.render({
        id: 'appraisal_five',
        type: 'pie',
        legendPosition: 'right',
        legend: { top: 'center', right:18, formatter: 'name|value'},
        label: false,
        labelColor: '#fff',
        radius: ['44%', '66%'],
        borderColor: '#001e38',
        title: '科目损失占比',
        series: [],
        color: ['#FFF04E', '#81FF5B', '#42FDFF', '#DF5DFF', '#2687FF', '#FF7F5D']
      });

      // 获取数据
      this.getChartData({
        strKey: 'A214-09', // 最新季度内部质量损失各科目占比
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_five', configData);
          if (text) {
            $('#appraisal_five').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    },
    appraisalSix: function (date) {
      // 最新季度外部质量损失各科目占比 A214-10
      kyptCharts.render({
        id: 'appraisal_six',
        type: 'pie',
        legendPosition: 'right',
        legend: { top: 'center', right:18, formatter: 'name|value'},
        label: false,
        labelColor: '#fff',
        radius: ['44%', '66%'],
        borderColor: '#001e38',
        title: '科目损失占比',
        series: [],
        color: ['#FFF04E', '#81FF5B', '#42FDFF', '#FF7F5D', '#2687FF']
      });

      // 获取数据
      this.getChartData({
        strKey: 'A214-10', // 最新季度外部质量损失各科目占比
        callback: function(configData, text) {
          // 更新图表渲染
          kyptCharts.reload('appraisal_six', configData);
          if (text) {
            $('#appraisal_six').siblings('.chart-title-layout').find('.sub_title_text').text(text);
          }
        }
      });
    }
  }

  // 运行报表渲染数据添加
  for (var key in chartInit) {
    if (key !== 'getChartData') {
      chartInit[key]();
    }
  }
  
  $('.scroll-layout:eq(0)').on('click', '.scroll-btn', function(e) {
    if ($(this).hasClass('active')) {
      $(this).removeClass('active').siblings('.scroll-btn').addClass('active');
      var targetValue = $('.scroll-layout:eq(0)').outerWidth();
      if ($(this).hasClass('left')) {
        targetValue = 0;
      }
      $('#scrollObject').css({left: -targetValue});
    }
  })

});
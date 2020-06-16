$(function() {

  // 历年成果转化完成情况
  kyptCharts.render({
    id: 'awardTramsformInfoHistory',
    type: 'bar',
    itemName: 'year',
    legend: { show: true },
    legendPosition: 'top',
    grid: { top: 30, right: 60 },
    lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: '#fff',
    labelColor: '#2BB7FF',
    label: { color: '#fff', position: 'top' },
    yAxis: [
      {
        type: 'value',
        name: '单位：个',
        nameTextStyle: {
          color: '#ffffff',
          fontSize: 14
        }
      },
      {
        type: 'value',
        name: '金额：万元',
        nameTextStyle: {
          color: '#ffffff',
          fontSize: 14
        }
      }
    ],
    color: ['#D89936', '#0CB92D'],
    series: [
      { name: '成果完成数量', valueKey: 'transAmount', yIndex: 0 },
      { name: '成果完成金额', valueKey: 'transMoneySum', yIndex: 1 }
    ],
    data: []
  });

  // 二级单位成果转化情况
  kyptCharts.render({
    id: 'achieveTransferOffice',
    type: 'bar',
    itemName: 'affiliatedUnitText',
    legend: { show: true },
    legendPosition: 'top',
    grid: { top: 30, right: 30, bottom: 12 },
    lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: '#fff',
    labelColor: '#2BB7FF',
    barMaxWidth: '25px',
    label: {
      color: '#fff',
      position: 'top'
    },
    yAxis: [
      {
        type: 'value',
        name: '单位：个',
        nameTextStyle: { color: '#ffffff' }
      },
      {
        type: 'value',
        name: '金额：万元',
        nameTextStyle: { color: '#ffffff' }
      }
    ],
    color: ['#4FA0E4', '#3461D3', '#EFEC56', '#DE7A3A', '#DF5DFF'],
    series: [
      {
        name: '转化完成数量',
        valueKey: 'transAmount',
        yIndex: 0
      },
      {
        name: '转化完成金额',
        valueKey: 'transMoneySum',
        yIndex: 1
      }
    ],
    data: [],
    labelRotate: 40
  });
  

  var pieColor = ['#4FA0E4', '#3461D3', '#EFEC56', '#DE7A3A', '#DF5DFF'];
  var chartInit = {
    transformInfo: function (param) {
      var y1 = [];
      var y2 = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByYear',
        data: param,
        type: 'GET',
        async: false,
        success: function(res) {
          var result = [];
          if (res.code == 0) {
            var data = res.data;
            $.each(data, function (i, item) {
              y1.push(item.transAmount);
              y2.push(item.transMoneySum);
              var obj = {};
              obj.year = item.year;
              obj.transAmount = item.transAmount;
              obj.transMoneySum = item.transMoneySum;
              result.push(obj);
            });
            kyptCharts.reload('awardTramsformInfoHistory', {
                  data: result,
                  yAxis: [
                    {
                      type: 'value',
                      min: 0,
                      max: Math.ceil(Math.max.apply(null,y1)/4)*4,
                      interval: Math.ceil(Math.max.apply(null,y1)/4),
                    },
                    {
                      type: 'value',
                      min: 0,
                      max: Math.ceil(Math.max.apply(null,y2)/4)*4,
                      interval: Math.ceil(Math.max.apply(null,y2)/4),
                    }
                  ]
                });
          }
        }
      });
    },
    awardsYearPie: function (params) {
      $('#awardTramsformType').empty();
      var chartDemo = echarts.init(document.getElementById('awardTramsformType'));
      //获取数据
      var countSeries = {
        name: '数量',
        type: 'pie',
        selectedMode: 'single',
        radius: [0, '30%'],
        // center: ['30%', '50%'],
        label: {
          show: false
        }
      };
      var moneySeries = {
        name: '金额',
        type: 'pie',
        radius: ['40%', '60%'],
        // center: ['30%', '50%'],
        label: {
          show: false
        }
      };
      var series = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByType',
        data: params,
        type: 'GET',
        async: false,
        success: function (res) {
         if (res.code == 0) {
           var data = res.data;
           var countArray = [];
           var moneyArray = [];
           var html = '';
           $.each(data, function (i, item) {
             html += '<div class="legend-item"><span><i style="background: ' + pieColor[i] + '"></i>' +item.achieveTransTypeText+ '</span><span>' +item.transAmount+ '</span><span>' +item.transMoneySum+ '</span></div>';
             var objc = {};
             objc.name = item.achieveTransTypeText;
             objc.value = item.transAmount;
             objc.itemStyle = {};
             objc.itemStyle.color = pieColor[i];
             countArray.push(objc);
             var objm = {};
             objm.name = item.achieveTransTypeText;
             objm.value = item.transMoneySum;
             objm.itemStyle = {};
             objm.itemStyle.color = pieColor[i];
             moneyArray.push(objm);
           });
           countSeries.data = countArray;
           moneySeries.data = moneyArray;
           series.push(countSeries);
           series.push(moneySeries);
           $('.chart-content .chart-legend').append(html);
         }
        }
      });
      var option = {
        series: series,
        title: {
          textStyle: { fontSize: 48, color: '#fff' }
        },
        legend: {
          show: false,
          right: 60,
          top: 'center',
          orient: 'vertical',
          formatter: function (name) {
              for(var j=0;j<countSeries.data.length;j++){
                if (countSeries.data[j].name == name) {
                  var result = countSeries.data[j].value;
                  var result2 = moneySeries.data[j].value;
                  var arr = ["{a|"+name+"}","{b|"+result+"个}", "{c|" + result2 + "万元}"];
                  return arr.join(' ');
                }
            }
          },
          textStyle: {
            color: '#ffffff',
            rich: {
              a: {
                width: 80
              },
              b: {
                width: 60,
                verticalAlign: 'middle'
              }
            }
          }
        },
        tooltip:  {
          show: true,
          trigger: 'item',
          axisPointer: {
            type: 'shadow'
          }
        },
        // color: ['#4FA0E4', '#3461D3', '#EFEC56', '#DE7A3A', '#DF5DFF']
      };
      chartDemo.setOption(option);
    },
    achieveTransferOfficeChart: function (params) {
      var y1 = [];
      var y2 = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByOffice',
        data: params,
        type: 'GET',
        async: false,
        success: function(res) {
          var result = [];
          if (res.code == 0) {
            var data = res.data;
            $.each(data, function (i, item) {
              y1.push(item.transAmount);
              y2.push(item.transMoneySum);
              var obj = {};
              obj.year = item.year;
              obj.transAmount = item.transAmount;
              obj.transMoneySum = item.transMoneySum;
              result.push(obj);
            });
            kyptCharts.reload('achieveTransferOffice',
                {
                  data: data,
                  yAxis: [
                    {
                      type: 'value',
                      name: '单位：个',
                      nameTextStyle: { color: '#ffffff' },
                      min: 0,
                      max: Math.ceil(Math.max.apply(null,y1)/4)*4,
                      interval: Math.ceil(Math.max.apply(null,y1)/4),
                    },
                    {
                      type: 'value',
                      name: '金额：万元',
                      nameTextStyle: { color: '#ffffff' },
                      min: 0,
                      max: Math.ceil(Math.max.apply(null,y2)/4)*4,
                      interval: Math.ceil(Math.max.apply(null,y2)/4),
                    }
                    ]

                });
          }
        }
      });
    }
  };

  chartInit.transformInfo();
  chartInit.awardsYearPie();
  chartInit.achieveTransferOfficeChart();
});
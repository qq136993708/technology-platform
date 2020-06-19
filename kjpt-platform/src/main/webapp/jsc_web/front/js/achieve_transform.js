$(function() {

  // 历年成果转化完成情况
  kyptCharts.render({
    id: 'awardTramsformInfoHistory',
    type: 'bar',
    itemName: 'year',
    legend: { show: true },
    legendPosition: 'top',
    grid: { top: 30, right: 60 },
    // lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: '#fff',
    labelColor: '#2BB7FF',
    label: { color: '#fff', position: 'top',show:false },
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

  // 成果转化方式
  var pieColor = ['#4FA0E4', '#3461D3', '#EFEC56', '#DE7A3A', '#DF5DFF'];
  kyptCharts.render({
    id: 'awardTramsformType',
    type: 'pie',
    tooltip: {
      trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } },
      formatter: function(params) {
        var tipsText = '';
        tipsText += '<dl class="transform-pie-tips">';
        tipsText += '<dt class="toltip-row middle-block">'
        tipsText += '<span class="ib-block pie-icon" style="background:'+ pieColor[params.dataIndex] +'"></span><span class="ib-block name">'+ params.data.name +'</span>';
        tipsText += '</dt><dd class="toltip-row middle-block">';
        tipsText += '<span class="ib-block name">数量：</span><span class="ib-block value">'+ params.data.number +'</span>';
        tipsText += '</dd><dd class="toltip-row middle-block">';
        tipsText += '<span class="ib-block name">金额：</span><span class="ib-block value">'+ params.data.value +'万</span>';
        tipsText += '</dd></dl>';
        return tipsText;
      }
    },
    legend: { show: false },
    label: false,
    labelColor: '#fff',
    radius: '65%',
    center: ['50%', '50%'],
    left: '20',
    // borderColor: '#001e38',
    totalTitle: false,
    series: [],
    title: { textStyle: { fontSize: 48, color: '#fff' } },
    color: pieColor
  });
  

  // 二级单位成果转化情况
  kyptCharts.render({
    id: 'achieveTransferOffice',
    type: 'bar',
    itemName: 'affiliatedUnitText',
    legend: { show: true },
    legendPosition: 'top',
    tooltip: { trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } }},
    grid: { top: 30, right: 30, bottom: 12 },
    // lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: '#fff',
    labelColor: '#2BB7FF',
    barMaxWidth: '25px',
    label: {
      color: '#fff',
      position: 'top',
      show:false
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
  
  // HTTP请求
  var chartInit = {
    transformInfo: function (param) {
      // 历年成果转化完成情况 数据请求
      var y1 = [];
      var y2 = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByYear',
        data: param || null,
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
      // 成果转化方式数据请求
      var seriesData = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByType',
        data: params || null,
        type: 'GET',
        async: false,
        success: function (res) {
         if (res.code == 0) {
          var data = res.data,
          legendHtml = '<label class="legend-item">' +
          '<span class="lenend-item-icon pie" style="opacity: 0;"></span>' +
          '<span class="lenend-item-name"></span>' +
          '<span class="lenend-item-value number th">数量</span>' +
          '<span class="lenend-item-value money th">金额：万元</span></label>';

           $.each(data, function (i, item) {
            seriesData.push({
              name: item.achieveTransTypeText,
              value: item.transMoneySum,
              number: item.transAmount
            });
            legendHtml += '<label class="legend-item" title="'+ item.achieveTransTypeText +'">';
            legendHtml += '<span class="lenend-item-icon pie" style="background-color:'+ pieColor[i] +'"></span>';
            legendHtml += '<span class="lenend-item-name">'+ item.achieveTransTypeText +'</span>';
            legendHtml += '<span class="lenend-item-value number">'+ item.transAmount +'</span>';
            legendHtml += '<span class="lenend-item-value money">'+ item.transMoneySum +'</span></label>';
           });

           kyptCharts.reload('awardTramsformType', { series: seriesData });
           $('#lenend-list-box').empty().html(legendHtml);
         }
        }
      });
    },
    achieveTransferOfficeChart: function (params) {
      // 二级单位成果转化情况
      var y1 = [];
      var y2 = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAchieveTransferByOffice',
        data: params || null,
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
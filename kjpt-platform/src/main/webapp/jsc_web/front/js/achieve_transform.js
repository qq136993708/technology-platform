layui.use(['laydate'], function() {
  var laydate = layui.laydate;
  var achieveTypes = [];
  var achieveTypesSeries = [];
  var awardsYearChart;

  var chartInit = {
    transformInfo: function (param) {
      $('#awardTramsformInfoHistory').empty();
      kyptCharts.render({
        id: 'awardTramsformInfoHistory',
        type: 'bar',
        itemName: 'year',
        legend: { show: false},
        grid: { top: 20 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#2BB7FF',
        barMaxWidth: '25px',
        label: {
          color: '#fff',
          position: 'top'
        },
        color: [],
        series: [
          { name: '成果完成数量', valueKey: 'value1', itemStyle: {normal: {color: '#0CB92D'}}},
          { name: '成果完成金额', valueKey: 'value2', itemStyle: {normal: {color: '#D89936'}}}
        ],
        data: [
          {value1: 12, value2: 56, year: 2016},
          {value1: 14, value2: 46, year: 2017},
          {value1: 22, value2: 96, year: 2018},
          {value1: 32, value2: 6, year: 2019},
          {value1: 42, value2: 16, year: 2020},
        ],
        callback: function (chartObj) {   //柱子点击事件

        }
      });

      httpModule({
        url: '/achieveMaintainBI-api/getAwardSumByQuery',
        data: param,
        type: 'GET',
        async: false,
        success: function(res) {
          var result = [];
          if (res.code == 0) {
            var data = res.data;
            $.each(data, function (i, item) {
              var obj = {};
              var _hasitem = result.find(function (v, index) { return v.year == item.year});
              var _hasitemIndex = result.findIndex(function (v, index) { return v.year == item.year});
              if (_hasitem) {
                result.splice(_hasitemIndex, 1);
                obj = _hasitem;
              }
              obj.year = item.year;
              var typeItem = achieveTypes.find(function(v, index) { return v.name == item.typeText});
              var key = typeItem ? typeItem.code:'key';
              obj[key] = item.awardsNumberSum;
              result.push(obj);
            });
            kyptCharts.reload('awards-year', {data: result});
          }
        }
      });
    },
    awardsYearPie: function (params) {
      $('#awards-year-pie').empty();
      //获取数据
      var series = [];
      var colors = [];
      httpModule({
        url: '/achieveMaintainBI-api/getAwardSumByTypePie',
        data: params,
        type: 'GET',
        async: false,
        success: function (res) {
          if (res.code == 0) {
            var data = res.data;
            $.each(data, function(i, item) {
              var colorObj = awardNameColor.find(function (currValue, i) {
                return currValue.type == item.awardsChildTypeText;
              });
              var color = colorObj ? colorObj.color : '#DF5DFF';
              var obj = {name: item.awardsChildTypeText, value: Number(item.awardsNumberSum)};
              colors.push(color)
              series.push(obj);
            });
          }
        }
      });
      kyptCharts.render({
        id: 'awards-year-pie',
        type: 'pie',
        legendPosition: 'right',
        legend: { top: 'center', formatter: 'name|value', right: 40},
        label: false,
        labelColor: '#fff',
        radius: '65%',
        center: ['50%', '50%'],
        left: '20',
        borderColor: '#001e38',
        totalTitle: false,
        series: series,
        title: {
          textStyle: { fontSize: 48, color: '#fff' }
        },
        color: colors
      });
    },
  };

  chartInit.transformInfo();
  chartInit.awardsYearPie();
});
layui.use(['laydate'], function() {
  var laydate = layui.laydate;
  var achieveTypes = [];
  var achieveTypesSeries = [];
  var awardsYearChart;

  //奖励类型
  var colors = [
    {type: '集团奖', color: '#306BF0'},
    {type: '社会奖项', color: '#0DA8D4'},
    {type: '省部级奖', color: '#EBDD51'},
    {type: '国家级奖', color: '#D86436'},
    {type: 'default', color: '#DF5DFF'},
  ];

  //奖项名称
  var awardNameColor = [
    {type: '国家科学技术奖', color: '#3461D3'},
    {type: '国防科学技术奖', color: '#D86436'},
    {type: '军队科技进步奖', color: '#DC8D3E'},
    {type: '其他省部级科技奖', color: '#EBDD51'},
    {type: '中核集团科技奖', color: '#D1F166'},
    {type: '社会奖项', color: '#65C8E0'}
  ];

  var dictcode = 'ROOT_KJPT_CGWH_HJLX';
  httpModule
  ({
    url: "/sysDictionary-api/getChildsListByCode/" + dictcode,
    type: 'GET',
    async: false,
    success: function(res) {
      if (res.success) {
        var data = res.data;
        achieveTypes = data;
        var html = '';
        $.each(data, function(i, item){
          var color = colors.find(function (currValue, i) { return currValue.type == item.name});
          color = color ? color.color : '#DF5DFF';
          var achieveTypesSeriesObj  = {name: item.name, valueKey: item.code, itemStyle: {normal: {color: color}}};
          achieveTypesSeries.push(achieveTypesSeriesObj);
          html += '<li data-type="' + item.code + '"><span class="award-rectangle" style="background: ' + color + ';"></span>' + item.name + '</li>';
        });
        $('#achievt-types').html(html);
      }
    }
  });

  var chartInit = {
    awardsYear: function (param) {
      $('#awards-year').empty();
      kyptCharts.render({
        id: 'awards-year',
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
        series: achieveTypesSeries,
        data: [],
        callback: function (chartObj) {   //柱子点击事件
          awardsYearChart = chartObj;
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
    getAchieveTableData: function (params) {
      httpModule({
        url: '/achieveMaintainBI-api/getDetailList',
        type: 'GET',
        data: params,
        success: function (res) {
          if (res.code == 0) {
            var data = res.data;
            let html = '';
            $.each(data, function (i, item) {
              html += '<tr><td>' + item.year + '</td><td>' + item.typeText +'</td><td>' + item.awardsTypeText + '</td><td>' + item.awardsChildTypeText + '</td><td>' + item.awardLevel + '</td><td>' + item.awardsNumber+ '</td></tr>'
            })
            $('.achieve-detail-table table tbody').html(html);
          }
        }
      });
    }
  };

  $('.count-year-title ul li').on('click', function () {
    var type = $(this).attr('data-type');
    chartInit.awardsYear({type: type});
    chartInit.getAchieveTableData({type: type});
  });

  $('#all').on('click', function () {
    chartInit.awardsYear();
    chartInit.getAchieveTableData();
  });

  chartInit.awardsYear();
  chartInit.awardsYearPie();
  chartInit.getAchieveTableData();

  //柱子点击事件
  if (awardsYearChart) {
    awardsYearChart.on('click', function(params) {
      var typeName = params.seriesName;
      var year = params.name;
      chartInit.getAchieveTableData({type: typeName, year: year})
    });
  }
});
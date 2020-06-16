function addTableData(data) {
  if (typeof(data) === 'object' && data.length) {
      var $tbodyContent = $('#tbodyContent').empty(), tbodyHtml = '';

      $.each(data, function(index, item) {
          tbodyHtml += '<tr>';
          tbodyHtml += '<td class="year">'+ item.year +'</td>';
          tbodyHtml += '<td class="level">'+ item.typeText +'</td>';
          tbodyHtml += '<td class="name">'+ item.awardsTypeText +'</td>';
          tbodyHtml += '<td class="subName">'+ item.awardsChildTypeText +'</td>';
          tbodyHtml += '<td class="award">'+ item.awardLevel +'</td>';
          tbodyHtml += '<td class="number">'+ item.awardsNumber +'</td>';
          tbodyHtml += '</tr>';
      });
      $tbodyContent.html(tbodyHtml);

      setTimeout(function() {
          var $table = $('#kynl_kypt_table .table-scroll-layout:eq(0)')
          $('#kynl_kypt_table > .table-header').css({
              'padding-right': $table.outerWidth() - $table.children('table').outerWidth()
          });
      }, 120);
  }
}

$(function() {
  var achieveTypes = [];
  var achieveTypesSeries = [];
  var awardsYearChart;


  kyptCharts.render({
    id: 'awards-year',
    type: 'bar',
    itemName: 'year',
    legend: { show: true },
    legendPosition: 'top',
    grid: { top: 30 },
    lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: '#fff',
    labelColor: '#2BB7FF',
    barMaxWidth: '25px',
    label: { color: '#fff', position: 'top' },
    color: ['#306BF0', '#0DA8D4', '#EBDD51', '#D86436'],
    series: [],
    data: [],
    callback: function (chartObj) {   //柱子点击事件
      awardsYearChart = chartObj;
    }
  });

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

  var chartInit = {
    awardsYear: function (param) {
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
              var typeItem = achieveTypes.find(function(v, index) {
                if (item.typeText.indexOf(v.name) !== -1) {
                  return true;
                } else {
                  return;
                }
              });
              var key = typeItem ? typeItem.code:'key';
              obj[key] = item.awardsNumberSum;
              result.push(obj);
            });

            kyptCharts.reload('awards-year', {data: result, series: achieveTypesSeries});
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
        data: params || '',
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
        // borderColor: '#001e38',
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
            addTableData(res.data)
            // let html = '';
            // $.each(data, function (i, item) {
            //   html += '<tr><td>' + item.year + '</td><td>' + item.typeText +'</td><td>' + item.awardsTypeText + '</td><td>' + item.awardsChildTypeText + '</td><td>' + item.awardLevel + '</td><td>' + item.awardsNumber+ '</td></tr>'
            // })
            // $('.achieve-detail-table table tbody').html(html);
          }
        }
      });
    }
  };

  var dictcode = 'ROOT_KJPT_CGWH_HJLX';
  httpModule({
    url: "/sysDictionary-api/getChildsListByCode/" + dictcode,
    type: 'GET',
    async: false,
    success: function(res) {
      if (res.success) {
        var data = res.data;
        achieveTypes = data;
        $.each(data, function(i, item){
          var achieveTypesSeriesObj = { name: item.name, valueKey: item.code };
          achieveTypesSeries.push(achieveTypesSeriesObj);
        });
        chartInit.awardsYear();
      } 
    }
  });

  chartInit.awardsYearPie();
  chartInit.getAchieveTableData();

  //柱子点击事件
  if (awardsYearChart) {
    awardsYearChart.on('click', function(params) {
      var typeName = params.seriesName;
      var year = params.name;
      chartInit.getAchieveTableData({type: typeName, year: year});
      chartInit.awardsYearPie({type: typeName, year: year});
    });
  }



})
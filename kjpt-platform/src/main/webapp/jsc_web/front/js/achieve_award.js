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
        'padding-right': parseInt($table.outerWidth()) - parseInt($table.children('table').outerWidth())
      });
    }, 120);
  }
}

$(function() {
  var achieveTypes = [];
  var achieveTypesSeries = [];

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
          var achieveTypesSeriesObj = { name: item.name, valueKey: item.code, id: item.id };
          achieveTypesSeries.push(achieveTypesSeriesObj);
        });
      } 
    }
  });

  var chartInit = {
    awardsYear: function (param) {
      httpModule({
        url: '/achieveMaintainBI-api/getAwardSumByQuery',
        data: param || null,
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

            kyptCharts.reload('awards-year', {data: result, series: achieveTypesSeries, loading: false});
          }
        }
      });
    },
    awardsYearPie: function (param) {
      //获取数据
      httpModule({
        url: '/achieveMaintainBI-api/getAwardSumByTypePie',
        data: param || null,
        type: 'GET',
        async: false,
        success: function (res) {
          if (res.code == 0) {
            var data = res.data, seriesData = [];
            $.each(data, function(i, item) {
              seriesData.push({name: item.awardsChildTypeText, value: Number(item.awardsNumberSum)});
            });
            kyptCharts.reload('awards-year-pie', {series: seriesData, loading: false});
          }
        }
      });
    },
    getAchieveTableData: function (param) {
      httpModule({
        url: '/achieveMaintainBI-api/getDetailList',
        type: 'GET',
        data: param || null,
        success: function (res) {
          if (res.code == 0) {
            addTableData(res.data)
          }
        }
      });
    }
  };

  // 获奖按年份统计
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
    callback: function (chartObj) {
      //柱子点击事件
      chartObj.on('click', function(params) {
        // 重加载详细表格数据
        chartInit.getAchieveTableData({type: achieveTypes[params.seriesIndex].id, year: params.name});
        // 重加载奖项名称(累计)数据
        kyptCharts.reload('awards-year-pie', {loading: true});
        chartInit.awardsYearPie({type: achieveTypes[params.seriesIndex].id, year: params.name});
      });
    },
    legendCallback: function(item, items) {
      // 图例被点击时的回调
      var ids = '';
      $.each(items, function(i, val) {
        if (val.legendSelected !== false) {
          ids += ',' + val.id;
        }
      });
      ids = ids.substring(1);
      // 重加载详细表格数据
      chartInit.getAchieveTableData({ type: ids });
      // 重加载奖项名称(累计)数据
      kyptCharts.reload('awards-year-pie', {loading: true});
      chartInit.awardsYearPie({ type: ids });
      // return false;
    }
  });

  // 奖项名称(累计)
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
    series: [],
    title: {
      textStyle: { fontSize: 48, color: '#fff' }
    },
    color: ['#3461D3', '#D86436', '#DC8D3E', '#EBDD51', '#D1F166', '#65C8E0']
  });


  // 获取图表数据
  chartInit.awardsYear();
  chartInit.awardsYearPie();
  chartInit.getAchieveTableData();

})
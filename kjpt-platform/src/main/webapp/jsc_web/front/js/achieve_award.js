

function addTableData(data) {
  if (typeof(data) === 'object' && data.length) {
    var $tbodyContent = $('#tbodyContent').empty(), tbodyHtml = '';

    $.each(data, function(index, item) {
      tbodyHtml += '<tr>';
      tbodyHtml += '<td class="year">'+ item.year +'</td>';
      tbodyHtml += '<td class="level">'+ item.typeText +'</td>';
      tbodyHtml += '<td class="name">'+ item.awardsTypeText +'</td>';
      tbodyHtml += '<td class="subName">'+ item.awardsChildTypeText +'</td>';
      tbodyHtml += '<td class="award">'+ item.awardLevelText +'</td>';
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
  } else {
    $('#tbodyContent').empty();
  }
}

// $(function() {
  var variable = getQueryVariable()
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
          var achieveTypesSeriesObj = { name: item.name, valueKey: item.code, id: item.code };
          achieveTypesSeries.push(achieveTypesSeriesObj);
        });
      } 
    }
  });

  var chartInit = {
    awardsYear: function (param) {
      httpModule({
        url: '/achieveMaintain-api/getAchieveMaintainGrupCountListByYear',
        data: param || null,
        type: 'GET',
        async: false,
        success: function(res) {
          if (res.code == 0) {
            var data = res.data, yearArr = [], totalData = [], items = {};

            $.each(data, function (i, item) {
              if (!items[item.type]) { items[item.type] = item.name; }

              var index = yearArr.indexOf(item.year);
              if (index === -1) {
                var newItem = {year: item.year};
                newItem[item.type] = item.num;
                totalData.push(newItem);
                yearArr.push(item.year);
              } else {
                totalData[index][item.type] = item.num;
              }
            });

            $.each(totalData, function(i, item) {
              for (var key in items) { if (!item[key]) { item[key] = '-'; } }
            });
            
            achieveTypes = [];
            for (var key in items) {
              achieveTypes.push({ name: items[key], valueKey: key });
            }
            totalData.sort(function(a, b) { return parseInt(a.year) - parseInt(b.year); });
            var showData = [];
            for (var i = 0; i < totalData.length; i++) {
              if (i < 5) {
                showData.push(totalData[i]);
              } else {
                break;
              }
            }

            kyptCharts.reload('awards-year', {data: showData, series: achieveTypes, loading: false});
          }
        }
      });
    },
    awardsYearPie: function (param) {
      var paramsData = { year: '', type: '' };
      if (param) {
        paramsData.type = param.type;
        paramsData.year = param.year;
      }

      //获取数据
      httpModule({
        url: '/achieveMaintain-api/getAchieveMaintainGrupCountList',
        data: paramsData,
        type: 'GET',
        async: false,
        success: function (res) {
          if (res.code == 0) {
            kyptCharts.reload('awards-year-pie', {series: res.data, loading: false});
          }
        }
      });
    },
    getAchieveTableData: function (param) {
      var paramsData = {
        pageNum: 1,
        pageSize: 1000,
        startYear: '',
        endYear: '',
        type: ''
      };
      if (param) {
        paramsData.type = param.type;
        paramsData.startYear = param.year;
        paramsData.endYear = param.year;
      }

      httpModule({
        url: '/achieveMaintain-api/query',
        type: 'GET',
        data: paramsData,
        success: function (res) {
          if (res.code == 0) {
            addTableData(res.data.list);
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
    tooltip: { trigger: 'axis', axisPointer: { type: 'shadow', shadowStyle: { color: 'rgba(0, 0, 0, 0)' } }},
    grid: { top: 10 },
    // lineColor: 'rgba(30, 83, 137, .6)',
    axisLineColor: 'rgba(30, 83, 137, .6)',
    valueColor: 'rgba(255, 255, 255, .7)',
    labelColor: '#fff',
    barMaxWidth: '25px',
    label: { color: '#fff', position: 'top' ,show:false},
    color: ['#306BF0', '#0DA8D4', '#EBDD51', '#D86436'],
    series: [],
    data: [],
    callback: function (chartObj) {
      //柱子点击事件
      chartObj.on('click', function(params) {
        $('#totalYear').text('奖项名称('+ params.name+')')
        // 重加载详细表格数据
        chartInit.getAchieveTableData({type: achieveTypes[params.seriesIndex].valueKey, year: params.name});
        // 重加载奖项名称(累计)数据
        kyptCharts.reload('awards-year-pie', {loading: true});
        chartInit.awardsYearPie({type: achieveTypes[params.seriesIndex].valueKey, year: params.name});
      });
    },
    legendCallback: function(item, items) {
      // 图例被点击时的回调
      var ids = '';
      $.each(items, function(i, val) {
        if (val.legendSelected !== false) {
          ids += ',' + val.valueKey;
        }
      });
      ids = ids.substring(1);

      if (ids === '') { ids = 'not_data' }

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
  
  if (variable) {
    $('.two_nav_item',parent.document).addClass('disNone')
    $('.cggl',parent.document).removeClass('disNone');
    $('#wrapper',parent.document).css({ 'padding-top': '6rem'});
    if (variable.name) {
      var curName = decodeURI(variable.name);
      var ids;
      httpModule({
        url: "/sysDictionary-api/getChildsListByCode/ROOT_KJPT_CGWH_HJLX",
        type: 'GET',
        async: false,
        success: function(res) {
          if (res.success) {
           $.each(res.data,function(index,item){
             if(item.name == curName){
              return ids = item.code
             }
           })
          } 
          chartInit.getAchieveTableData({ type: ids });
        // 重加载奖项名称(累计)数据
        // kyptCharts.reload('awards-year-pie', {loading: true});
        chartInit.awardsYear({ type: ids });
        chartInit.awardsYearPie({ type: ids });
        }
      });
    }
  }else{
     // 获取图表数据
  chartInit.awardsYear();
  chartInit.awardsYearPie();
  chartInit.getAchieveTableData();
  }

// })
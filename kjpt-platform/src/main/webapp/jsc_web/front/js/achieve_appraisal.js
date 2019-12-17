layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果鉴定结论数量按技术领域
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 13; i++) {
        chartData.push({
          name: i+'月',
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_one',
          type: 'bar',
          itemName: 'name',
          legend: { show: false },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '技术领域', valueKey: 'value'},
          ],
          data: chartData,
          color: '#2BF3FF'
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    },
    appraisalTwo: function (date) {
      // 成果鉴定结论数量按成果种类占比
      var chartData = [], itemName = ['理论成果', '应用技术成果', '软科学成果'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'pie',
          legend: { top: 'center', formatter: '{name}{value}'},
          label: false,
          labelColor: '#fff',
          radius: ['44%', '65%'],
          borderColor: '#001e38',
          title: ' 成果种类占比',
          series: chartData,
          color: ['#FFF04E', '#FF7F5D', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_two', {series: chartData});
      }
    },
    appraisalThree: function(date) {
      // 成果鉴定结论数量按研究院占比
      var chartData = [], itemName = [ '石勘院', '物探院', '工程院', '石科院', '上海院', '北化院', '其他' ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_three',
          type: 'pie',
          legend: { top: 'center' },
          label: false,
          labelColor: '#fff',
          radius: ['44%', '65%'],
          borderColor: '#001e38',
          title: ' 研究院占比',
          series: chartData,
          color: ['#81FF5B', '#FFF04E', '#DF5DFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_three', {series: chartData});
      }
    },
    appraisalFour: function(date) {
      // 成果鉴定结论数量按研究院分布情况
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 13; i++) {
        chartData.push({
          name: i+'月',
          value1: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value2: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value3: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_four',
          type: 'bar',
          itemName: 'name',
          legend: { show: true, left: 'right', top: 40},
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '理论成果', valueKey: 'value1'},
            { name: '应用技术成果', valueKey: 'value2'},
            { name: '软科学成果', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#4526FF', '#00AEFF', '#93E9FF']
        })
      } else {
        kyptCharts.reload('appraisal_four', {data: chartData});
      }
    }
  }


  // 成果鉴定结论数量按技术领域
  chartInit.appraisalOne();
  laydate.render({
    elem: '#oneDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalOne(value);
    }
  });

  // 成果鉴定结论数量按成果种类占比
  chartInit.appraisalTwo();
  laydate.render({
    elem: '#twoDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalTwo(value);
    }
  });

  // 成果鉴定结论数量按研究院占比
  chartInit.appraisalThree();
  laydate.render({
    elem: '#threeDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalThree(value);
    }
  });

  // 成果鉴定结论数量按研究院占比
  chartInit.appraisalFour();
  laydate.render({
    elem: '#fourDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalFour(value);
    }
  });
});
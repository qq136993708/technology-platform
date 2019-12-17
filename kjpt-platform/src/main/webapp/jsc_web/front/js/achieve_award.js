layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果报奖数量趋势分析
      var time = date || '2019',
      chartData = [];

      for (var i = 2017; i < 2020; i++) {
        chartData.push({
          name: i+'年',
          value1: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value2: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value3: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_one',
          type: 'line',
          itemName: 'name',
          legend: { left: 'center' },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '科技进步奖', valueKey: 'value1'},
            { name: '技术发明奖', valueKey: 'value2'},
            { name: '前瞻研究奖', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#FFF04E', '#81FF5B', '#42FDFF']
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    },
    appraisalTwo: function (date) {
      // 成果报奖数量按获奖等级分析
      var chartData = [], itemName = ['科技进步奖', '技术发明奖', '前瞻研究奖'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value1: (parseInt(Math.random() * 400) + 100), // 特等奖
          value2: (parseInt(Math.random() * 400) + 100), // 一等奖
          value3: (parseInt(Math.random() * 400) + 100), // 二等奖
          value4: (parseInt(Math.random() * 400) + 100) // 三等奖
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'bar',
          itemName: 'name',
          grid: { top: 70 },
          legend: { left: 150, top: 14 },
          label: false,
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          valueIndex: 'x',
          barWidth: 10,
          data: chartData,
          series: [
            { name: '特等奖', valueKey: 'value1'},
            { name: '一等奖', valueKey: 'value2'},
            { name: '二等奖', valueKey: 'value3'},
            { name: '三等奖', valueKey: 'value4'}
          ],
          color: ['#FFF04E', '#C85DFF', '#2687FF', '#FF7F5D']
        });
      } else {
        kyptCharts.reload('appraisal_two', {series: chartData});
      }
    },
    appraisalThree: function(date) {
      // 成果报奖数量按技术领域分析
      var chartData = [], itemName = [ '技术领域', '技术领域', '技术领域', '技术领域', '技术领域', '技术领域', '技术领域' ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_three',
          type: 'bar',
          itemName: 'name',
          grid: { top: 70 },
          legend: { show: false },
          label: false,
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          data: chartData,
          series: [
            { name: '技术领域分析', valueKey: 'value'},
          ],
          color: ['#2BF3FF', '#C85DFF', '#2687FF', '#FF7F5D']
        });
      } else {
        kyptCharts.reload('appraisal_three', {series: chartData});
      }
    },
    appraisalFour: function(date) {
      // 成果报奖数量按研究院分布情况
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 13; i++) {
        chartData.push({
          name: i+'研究院',
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
            { name: '科技进步奖', valueKey: 'value1'},
            { name: '技术发明奖', valueKey: 'value2'},
            { name: '前瞻研究奖', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#4526FF', '#00AEFF', '#93E9FF']
        })
      } else {
        kyptCharts.reload('appraisal_four', {data: chartData});
      }
    },
    appraisalFive: function(date) {
      // 成果报奖数量按研究院占比
      var chartData = [], itemName = [ '石勘院', '物探院', '工程院', '石科院', '上海院', '北化院', '其他' ];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_five',
          type: 'pie',
          legend: { top: 'center' },
          label: false,
          labelColor: '#fff',
          radius: ['48%', '66%'],
          borderColor: '#001e38',
          title: ' 研究院占比',
          series: chartData,
          color: ['#81FF5B', '#FFF04E', '#DF5DFF', '#3A26FF', '#FF7F5D', '#42FDFF', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_five', {series: chartData});
      }
    }
  }


  // 成果报奖数量趋势分析
  chartInit.appraisalOne();

  // 成果报奖数量按获奖等级分析
  chartInit.appraisalTwo();
  laydate.render({
    elem: '#twoDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalTwo(value);
    }
  });

  // 成果报奖数量按技术领域分析
  chartInit.appraisalThree();
  laydate.render({
    elem: '#threeDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalThree(value);
    }
  });

  // 成果报奖数量按研究院分布情况
  chartInit.appraisalFour();
  laydate.render({
    elem: '#fourDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalFour(value);
    }
  });

  // 成果报奖数量按研究院占比
  chartInit.appraisalFive();
  laydate.render({
    elem: '#fiveDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalFive(value);
    }
  });
  

});
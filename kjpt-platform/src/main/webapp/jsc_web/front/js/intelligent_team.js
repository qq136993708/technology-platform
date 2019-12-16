layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果报奖数量趋势分析
      var time = date || '2019',
      chartData = [],
      labelArr = ['30岁以下', '30~45岁', '46~55岁', '56岁以上']

      for (var i = 0; i < labelArr.length; i++) {
        chartData.push({
          name: labelArr[i],
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
            { name: '年龄段', valueKey: 'value'}
          ],
          data: chartData,
          color: ['#2BF3FF', '#81FF5B', '#42FDFF']
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    },
    appraisalTwo: function (date) {
      // 科技人才数量按职称
      var chartData = [], itemName = ['正高级', '副高级', '中级', '助理级', '员级', '无'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value: (parseInt(Math.random() * 400) + 100)
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'pie',
          legend: { top: 'center' },
          label: false,
          labelColor: '#fff',
          radius: ['48%', '66%'],
          borderColor: '#001e38',
          series: chartData,
          color: ['#FFF04E', '#81FF5B', '#42FDFF', '#DF5DFF', '#2687FF', '#FF7F5D']
        });
      } else {
        kyptCharts.reload('appraisal_two', {series: chartData});
      }
    },
    appraisalThree: function(date) {
      // 科技人才数量按学历
      var chartData = [], itemName = ['博士', '硕士', '其他'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_three',
          type: 'pie',
          legend: { top: 'center' },
          label: false,
          labelColor: '#fff',
          radius: ['48%', '66%'],
          borderColor: '#001e38',
          series: chartData,
          color: ['#FFF04E', '#FF7F5D', '#2687FF']
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
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_four',
          type: 'bar',
          itemName: 'name',
          legend: { show: false},
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '科技人才数量', valueKey: 'value'}
          ],
          data: chartData,
          color: ['#00C6FF']
        })
      } else {
        kyptCharts.reload('appraisal_four', {data: chartData});
      }
    }
  }


  // 科技人才数量按年龄段
  chartInit.appraisalOne();

  // 科技人才数量按职称
  chartInit.appraisalTwo();

  // 科技人才数量按学历
  chartInit.appraisalThree();

  // 科技人才数量按单位
  chartInit.appraisalFour();
  

});
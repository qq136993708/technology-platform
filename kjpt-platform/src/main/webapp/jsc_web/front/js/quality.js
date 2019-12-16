layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 同位素产品质量趋势图
      var time = date || '2019',
      chartData = [];

      for (var i = 0; i < 12; i++) {
        chartData.push({
          name:  (i+ 1)+'月',
          value1: (parseInt(Math.random() * 100) + 0), // 100 ~ 500
          value2: (parseInt(Math.random() * 100) + 0),
          value3: (parseInt(Math.random() * 100) + 0),
          value4: (parseInt(Math.random() * 100) + 0),
          value5: (parseInt(Math.random() * 100) + 0)
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_one',
          type: 'line',
          itemName: 'name',
          legend: { left: 0 },
          grid: { top: 85 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '医疗器械一次检验合格率（%）', valueKey: 'value1'},
            { name: '医疗器械出厂检验合格率（%）', valueKey: 'value2'},
            { name: '放射源出厂检验合格率（%）', valueKey: 'value3'},
            { name: '放射性药品一次检验合格率（%）', valueKey: 'value4'},
            { name: '放射性药品出厂检验合格率（%）', valueKey: 'value5'}
          ],
          data: chartData,
          color: ['#EAFF74', '#00FF32', '#42FDFF', '#D300E0', '#FF7F5D', '#00ABE9']
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    },
    appraisalTwo: function (date) {
      // gb/t19001认证审核的主要不符合项条款
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 13; i++) {
        chartData.push({
          name: i+'-成文信息',
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_two',
          type: 'bar',
          itemName: 'name',
          legend: { show: true, left: 'right' },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          barWidth: 18,
          label: false,
          series: [
            { name: '数量', valueKey: 'value'}
          ],
          data: chartData,
          color: ['#FFF04E', '#00AEFF', '#93E9FF']
        })
      } else {
        kyptCharts.reload('appraisal_two', {data: chartData});
      }
    },
    appraisalThree: function(date) {
      // gjb/t19001认证审核的主要不符合项条款
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 7; i++) {
        chartData.push({
          name: i+'-质量目标及其实现的策划',
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_three',
          type: 'bar',
          itemName: 'name',
          legend: { show: true, left: 'right' },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          barWidth: 18,
          series: [
            { name: '数量', valueKey: 'value'}
          ],
          data: chartData,
          color: ['#81FF5B', '#00AEFF', '#93E9FF']
        })
      } else {
        kyptCharts.reload('appraisal_three', {data: chartData});
      }
    },
    appraisalFour: function(date) {
      // 最新季度内、外部质量损失占比（%）
      var chartData = [], itemName = ['内部', '外部'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_four',
          type: 'pie',
          legend: { top: 'center', left: '65%'},
          label: false,
          labelColor: '#fff',
          radius: ['44%', '61%'],
          center: ['28%', '50%'],
          borderColor: '#001e38',
          title: ' 损失占比',
          series: chartData,
          color: ['#45F0FF', '#2687FF', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_four', {series: chartData});
      }
    },
    appraisalFive: function (date) {
      // 最新季度内部质量损失各科目占比（%）
      var chartData = [], itemName = ['报废', '返修（工）', '降级', '停工', '成品质量事故处理', '其他'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_five',
          type: 'pie',
          legend: { top: 'center', left: '65%'},
          label: false,
          labelColor: '#fff',
          radius: ['44%', '61%'],
          center: ['28%', '50%'],
          borderColor: '#001e38',
          title: '科目损失占比',
          series: chartData,
          color: ['#FFF04E', '#FF7F5D', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_five', {series: chartData});
      }
    },
    appraisalSix: function (date) {
      // 最新季度外部质量损失各科目占比（%）
      var chartData = [], itemName = ['索赔', '退货', '折价', '保修', '其他'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i], value: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'appraisal_six',
          type: 'pie',
          legend: { top: 'center', left: '65%'},
          label: false,
          labelColor: '#fff',
          radius: ['44%', '61%'],
          center: ['28%', '50%'],
          borderColor: '#001e38',
          title: '科目损失占比',
          series: chartData,
          color: ['#FFF04E', '#FF7F5D', '#2687FF']
        });
      } else {
        kyptCharts.reload('appraisal_six', {series: chartData});
      }
    }
  }


  // 同位素产品质量趋势图
  chartInit.appraisalOne();

  // gb/t19001认证审核的主要不符合项条款
  chartInit.appraisalTwo();

  // gjb/t19001认证审核的主要不符合项条款
  chartInit.appraisalThree();

  // 最新季度内、外部质量损失占比（%）
  chartInit.appraisalFour();

  // 最新季度内部质量损失各科目占比（%）
  chartInit.appraisalFive();

  // 最新季度外部质量损失各科目占比（%）
  chartInit.appraisalSix();
  
});
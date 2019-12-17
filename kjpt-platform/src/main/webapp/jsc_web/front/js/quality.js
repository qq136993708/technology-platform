layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    qualityOne: function(date) {
      // 同位素产品质量趋势图
      var time = date || '2019',
      chartData = [];

      for (var i = 0; i < 12; i++) {
        chartData.push({
          name:  (i+ 1)+'月',
          value1: (parseInt(Math.random() * 100) + 0), // 100 ~ 500
          value2: (parseInt(Math.random() * 100) + 0),
          value3: (parseInt(Math.random() * 100) + 0)
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_one',
          type: 'line',
          itemName: 'name',
          legend: { left: 0, top: 60 },
          grid: { top: 100 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '月度非计划停推次数', valueKey: 'value1'},
            { name: '人因失误导致的运行事件数', valueKey: 'value2'},
            { name: '累计平均人因失误导致的运行事件数', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#EAFF74', '#00FF32', '#42FDFF', '#D300E0', '#FF7F5D', '#00ABE9']
        })
      } else {
        kyptCharts.reload('quality_one', {data: chartData});
      }
    },
    qualityTwo: function (date) {
      // gb/t19001认证审核的主要不符合项条款
      var time = date || '2019',
      chartData = [],
      labelArr = ['漳州核电1、2号机组', '霞浦核电工程']

      for (var i = 0; i < labelArr.length; i++) {
        chartData.push({
          name: labelArr[i],
          value1: (parseInt(Math.random() * 100) + 0), // 工程
          value2: (parseInt(Math.random() * 100) + 0), // 设备
          value3: (parseInt(Math.random() * 100) + 0) // 调试
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_two',
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
            { name: '工程（%）', valueKey: 'value1'},
            { name: '设备（%）', valueKey: 'value2'},
            { name: '调试（%）', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#FFF04E', '#2687FF', '#FF7F5D']
        })
      } else {
        kyptCharts.reload('quality_two', {data: chartData});
      }
    },
    qualityThree: function(date) {
      // gjb/t19001认证审核的主要不符合项条款
      var time = date || '2019',
      chartData = [];

      for (var i = 1; i < 10; i++) {
        chartData.push({
          name: i+'月',
          value1: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value2: (parseInt(Math.random() * 400) + 100), // 100 ~ 500
          value3: (parseInt(Math.random() * 400) + 100) // 100 ~ 500
        })
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_three',
          type: 'line',
          itemName: 'name',
          legend: { show: true, left: '0' },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          barWidth: 18,
          series: [
            { name: '产品161一次交检合格率（%）', valueKey: 'value1'},
            { name: '产品162一次交检合格率（%）', valueKey: 'value2'},
            { name: '压水堆核燃料组件一次交检合格率（%）', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#EAFF74', '#00FF32', '#42FDFF']
        })
      } else {
        kyptCharts.reload('quality_three', {data: chartData});
      }
    },
    qualityFour: function(date) {
      // 最新季度内、外部质量损失占比（%）
      var chartData = [], itemName = ['511矿床', '巴彦乌拉铀矿床', '513矿床', '510矿床'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value1: (parseInt(Math.random() * 400) + 100),
          value2: (parseInt(Math.random() * 400) + 100),
          value3: (parseInt(Math.random() * 400) + 100)
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_four',
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
            { name: '浸采率（%）', valueKey: 'value1'},
            { name: '回收率（%）', valueKey: 'value2'},
            { name: '损失率（%）', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#FFF04E', '#2687FF', '#FF7F5D']
        });
      } else {
        kyptCharts.reload('quality_four', {series: chartData});
      }
    },
    qualityFive: function (date) {
      // 最新季度内部质量损失各科目占比（%）
      var chartData = [], itemName = ['第一季度', '第二季度', '第三季度'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i],
          value1: (parseInt(Math.random() * 400) + 100),
          value2: (parseInt(Math.random() * 400) + 100)
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_five',
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
            { name: '累计完成钻孔数', valueKey: 'value1'},
            { name: '平均优质孔率（%）', valueKey: 'value2'},
          ],
          data: chartData,
          color: ['#FFF04E', '#2687FF', '#FF7F5D']
        });
      } else {
        kyptCharts.reload('quality_five', {series: chartData});
      }
    },
    qualitySix: function (date) {
      // 最新季度外部质量损失各科目占比（%）
      var chartData = [], itemName = ['1', '2', '3', '4', '5', '6', '7'];
      for (var i = 0; i < itemName.length; i++) {
        chartData.push({
          name: itemName[i] + '月',
          value1: (parseInt(Math.random() * 400) + 100),
          value2: (parseInt(Math.random() * 400) + 100),
          value3: (parseInt(Math.random() * 400) + 100)
        });
      }

      if (!date) {
        kyptCharts.render({
          id: 'quality_six',
          type: 'line',
          itemName: 'name',
          legend: { show: true, left: '0' },
          grid: { top: 70 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          barWidth: 18,
          series: [
            { name: '产品161一次交检合格率（%）', valueKey: 'value1'},
            { name: '产品162一次交检合格率（%）', valueKey: 'value2'},
            { name: '压水堆核燃料组件一次交检合格率（%）', valueKey: 'value3'}
          ],
          data: chartData,
          color: ['#EAFF74', '#00FF32', '#42FDFF']
        });
      } else {
        kyptCharts.reload('quality_six', {series: chartData});
      }
    },

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
          radius: ['43%', '65%'],
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
          radius: ['43%', '65%'],
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
          radius: ['43%', '65%'],
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

  for (var key in chartInit) {
    chartInit[key]();
  }

  // // 同位素产品质量趋势图
  // chartInit.appraisalOne();

  // // gb/t19001认证审核的主要不符合项条款
  // chartInit.appraisalTwo();

  // // gjb/t19001认证审核的主要不符合项条款
  // chartInit.appraisalThree();

  // // 最新季度内、外部质量损失占比（%）
  // chartInit.appraisalFour();

  // // 最新季度内部质量损失各科目占比（%）
  // chartInit.appraisalFive();

  // // 最新季度外部质量损失各科目占比（%）
  // chartInit.appraisalSix();
  
  $('.scroll-layout:eq(0)').on('click', '.scroll-btn', function(e) {
    if ($(this).hasClass('active')) {
      $(this).removeClass('active').siblings('.scroll-btn').addClass('active');
      var targetValue = $('.scroll-layout:eq(0)').outerWidth();
      if ($(this).hasClass('left')) {
        targetValue = 0;
      }
      $('#scrollObject').css({left: -targetValue});
    }
  })

});
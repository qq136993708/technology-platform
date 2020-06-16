layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
      // 成果报奖数量趋势分析
      kyptCharts.render({
        id: 'appraisal_one',
        type: 'bar',
        itemName: 'age',
        legend: { show: false },
        grid: { top: 20 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        valueIndex: 'x',
        // barWidth: 10,
        label: {
          show: true,
          position: 'insideLeft',
          color: '#041E36',
          fontSize: 16
        },
        series: [
          { name: '年龄段', valueKey: 'num'}
        ],
        data: [],
        color: [['#49FF8E','#2BF3FF'], '#81FF5B', '#42FDFF']
      });

      // 获取图表数据
      httpModule({
        url: '/cockpit/person/personCountAge',
        type: 'POST',
        success: function(res) {
          if ( res.code === '0' || res.success === true) {
            kyptCharts.reload('appraisal_one', {data: res.data});
          }
        }
      });
    },
    appraisalTwo: function (date) {
      // 科技人才数量按职称
      kyptCharts.render({
        id: 'appraisal_two',
        type: 'pie',
        legendPosition: 'left',
        legend: { top: 'center', formatter: 'name|value'},
        label: false,
        labelColor: '#fff',
        radius: ['44%', '66%'],
        // borderColor: '#001e38',
        series: [],
        totalTitle: true,
        title: {
          textStyle: { fontSize: 48, color: '#fff' }
        },
        color: ['#FFF04E', '#81FF5B', '#42FDFF', '#DF5DFF', '#2687FF', '#FF7F5D']
      });
      
      httpModule({
        url: '/cockpit/person/personCountTitle',
        type: 'POST',
        success: function(res) {
          if (res.code === '0' || res.success === true) {
            var chartData = [];
            $.each(res.data, function(i, item) {
              chartData.push({
                name: item.title,
                value: item.num
              });
            });
            kyptCharts.reload('appraisal_two', {series: chartData});
          }
        }
      });
    },
    appraisalThree: function(date) {
      // 科技人才数量按学历
      kyptCharts.render({
        id: 'appraisal_three',
        type: 'pie',
        legendPosition: 'left',
        legend: { top: 'center', formatter: 'name|value'},
        label: false,
        labelColor: '#fff',
        radius: ['44%', '66%'],
        // borderColor: '#001e38',
        series: [],
        totalTitle: true,
        title: {
          textStyle: {
            color: '#fff',
            fontSize: 30,
            width: '100%'
          }
        },
        pieFormattr: true,
        title: {
          textStyle: { fontSize: 48, color: '#fff' }
        },
        color: ['#FFF04E', '#FF7F5D', '#2687FF']
      });

      httpModule({
        url: '/cockpit/person/personCountEducation',
        type: 'POST',
        success: function(res) {
          if (res.code === '0' || res.success === true) {
            var chartData = [];
            $.each(res.data, function(i, item) {
              chartData.push({
                name: item.education,
                value: item.num
              });
            });
            kyptCharts.reload('appraisal_three', {series: chartData});
          }
        }
      });

    },
    appraisalFour: function(date) {
      // 成果报奖数量按研究院分布情况
      kyptCharts.render({
        id: 'appraisal_four',
        type: 'bar',
        itemName: 'company',
        legend: { show: false},
        grid: { top: 70 },
        lineColor: '#1E5389',
        valueColor: '#fff',
        labelColor: '#fff',
        label: false,
        series: [
          { name: '科技人才数量', valueKey: 'num'}
        ],
        data: [],
        color: [['#42FDFF', '#00C6FF']]
      })

      httpModule({
        url: '/cockpit/person/personCountCompany',
        type: 'POST',
        success: function(res) {
          if (res.code === '0' || res.success === true) {
            kyptCharts.reload('appraisal_four', {data: res.data});
          }
        }
      });
    }
  }

  // 初始化图表
  for(var key in chartInit) {
    chartInit[key]();
  }

  

  // 科技人才数量按职称
  // chartInit.appraisalTwo();

  // 科技人才数量按学历
  // chartInit.appraisalThree();

  // 科技人才数量按单位
  // chartInit.appraisalFour();
  

});
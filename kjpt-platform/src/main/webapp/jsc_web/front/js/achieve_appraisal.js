layui.use(['laydate'], function() {
  var laydate = layui.laydate,
  chartInit = {
    appraisalOne: function(date) {
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
          grid: { top: 80 },
          lineColor: '#1E5389',
          valueColor: '#fff',
          labelColor: '#fff',
          label: false,
          series: [
            { name: '成果鉴定结论数量', valueKey: 'value'},
          ],
          data: chartData,
          color: '#2BF3FF'
        })
      } else {
        kyptCharts.reload('appraisal_one', {data: chartData});
      }
    }
  }


  // 渲染新增项目数量月度趋势分析表
  chartInit.appraisalOne();
  laydate.render({
    elem: '#oneDate',
    type: 'year',
    value: '2019',
    done: function(value, date, endDate) {
      chartInit.appraisalOne(value);
    }
  });




});
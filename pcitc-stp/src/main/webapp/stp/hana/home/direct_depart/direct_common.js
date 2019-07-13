/**
 * ==============单柱图 =============
 */

var option_bar_single_down = {

	title : {
		text : '',
		x : 'center',
		y : '10px',
		textStyle : {
			fontSize : 15,
			fontWeight : 'normal',
			color : '#000000'
		},
		subtextStyle : {
			color : '#7B7B7B'
		},
		subtext : ''
	},
	grid : {
		top : '15%',
		left : '0%',
		right : '0.5%',
		bottom : '10%',
		containLabel : true
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : {
			type : 'shadow',
			crossStyle : {
				color : '#999'
			}
		}
	},
	color : [ '#43c5ff', '#ffa70f', '#70b1aa', '#e8a791', '#b5c26a', '#d59981' ],
	xAxis : {
		type : 'category',
		data : [],
		axisLabel : {
			interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
		// rotate:-30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}
	},
	yAxis : {
		type : 'value',
	},
	series : []
};

function barAjax_single_down(url, echartsobj, options, id) {

	var xAxisData = [];
	var series = [];
	$.ajax({
		type : "get",
		url : url,
		timeout : 9000,
		dataType : "json",
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (data.success == true || data.success == 'true') {
				echartsobj.hideLoading();

				dataresutl = data.data;
				set_single_graph_statistics(dataresutl, id);

				var chartList = data.data.xAxisDataList;
				for (var i = 0; i < chartList.length; i++) {
					xAxisData.push(chartList[i]);
				}

				var seriesDataList = data.data.seriesDataList;
				for (var i = 0; i < seriesDataList.length; i++) {
					series.push(seriesDataList[i]);
				}
				// 加载数据图表
				echartsobj.setOption({
					xAxis : {
						data : xAxisData
					},
					series : [ {
						data : series,
						type : 'bar',
						barWidth : 50,
					} ]
				});

			}
		},
		error : function() {
			layer.msg('图表加载失败');
		},
		complete : function(XMLHttpRequest, status) {
			if (status == 'timeout') {
				layer.msg('超时');
			}
		}
	});

}

// 单图
function load_single_bar_down(url, id, title, subtext, yAxis, color) {
	var echartsobj = echarts.init(document.getElementById(id));
	option_bar_single_down.title.text = title;
	option_bar_single_down.title.subtext = subtext;

	if (yAxis != null && yAxis != '') {
		option_bar_single_down.yAxis = yAxis;
	}
	if (color != undefined && color != "") {
		option_bar_single_down.color = color;
	}

	echartsobj.setOption(option_bar_single_down);
	echartsobj.showLoading();
	barAjax_single_down(url, echartsobj, option_bar_single_down, id);
	return echartsobj;
}

/**
 * ===============================================单 柱图 end
 * =================================
 */

var mutl_bar_down = {
	title : {
		text : '',
		x : 'center',
		y : '10px',
		textStyle : {
			fontSize : 15,
			fontWeight : 'normal',
			color : '#000000'
		},
		subtextStyle : {
			color : '#7B7B7B'
		},
		subtext : ''
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : {
			type : 'shadow',
			crossStyle : {
				color : '#999'
			}
		}
	},
	grid : {
		x : 40,
		y : 60,
		x2 : 30,
		y2 : 60
	},
	color : [ '#6592b2', '#54b6e9', '#70b1aa', '#e8a791', '#b5c26a', '#d59981' ],
	legend : {
		type : 'scroll',
		bottom : 0,
		data : [],
		selected : {}
	},
	xAxis : [ {
		type : 'category',
		data : [],
		axisLabel : {
			interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
		// rotate:30,//倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}

	} ],
	yAxis : [ {
		type : 'value',
		name : '金额（万元）',
		/*
		 * min: 'dataMin', max:'dataMax',
		 */
		axisLabel : {
			formatter : '{value}'
		}
	} ],
	series : [

	]
};

// barLineAjax返回DATA,指标在下方
function load_mutl_bar_down(url, id, title, subtext, yAxis, width, color, callback) {
	var echartsobj = echarts.init(document.getElementById(id));
	if (title != null && title != '') {
		mutl_bar_down.title.text = title;
	}
	if (subtext != null && subtext != '') {
		mutl_bar_down.title.subtext = subtext;
	}
	mutl_bar_down.grid = {
		top : "10.5%",
		left : '2.5%',
		right : '3%',
		bottom : '10%',
		containLabel : true
	}
	if (yAxis != null && yAxis != '') {
		mutl_bar_down.yAxis = yAxis;
	}
	if (color != undefined && color != "") {
		mutl_bar_down.color = color;
	}
	mutl_bar_down.xAxis = [ {
		type : 'category',
		axisLabel : {
			interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
			rotate : 0,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}
	} ]
	echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();

	echartsobj = barLineAjax_down(url, echartsobj, mutl_bar_down, id, width, callback);
	return echartsobj;
}
function load_mutl_bar_down_f(url, id, title, subtext, yAxis, width, color, callback) {
	var echartsobj = echarts.init(document.getElementById(id));
	if (title != null && title != '') {
		mutl_bar_down.title.text = title;
	}
	if (subtext != null && subtext != '') {
		mutl_bar_down.title.subtext = subtext;
	}
	mutl_bar_down.grid = {
		top : "10.5%",
		left : '2.5%',
		right : '3%',
		bottom : '10%',
		containLabel : true
	}
	if (yAxis != null && yAxis != '') {
		mutl_bar_down.yAxis = yAxis;
	}
	if (color != undefined && color != "") {
		mutl_bar_down.color = color;
	}
	mutl_bar_down.xAxis = [ {
		type : 'category',
		axisLabel : {
			interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
			rotate : 0,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}
	} ]
	echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();

	echartsobj = barLineAjax_down_f(url, echartsobj, mutl_bar_down, id, width, callback);
	return echartsobj;
}
function load_mutl_bar_down_rotate(url, id, title, subtext, yAxis, width, color, rotate, callback) {
	var echartsobj = echarts.init(document.getElementById(id));
	if (title != null && title != '') {
		mutl_bar_down.title.text = title;
	}
	if (subtext != null && subtext != '') {
		mutl_bar_down.title.subtext = subtext;
	}
	mutl_bar_down.grid = {
		top : "10.5%",
		left : '0.5%',
		right : '3%',
		bottom : '10%',
		containLabel : true
	}
	if (yAxis != null && yAxis != '') {
		mutl_bar_down.yAxis = yAxis;
	}
	if (color != undefined && color != "") {
		mutl_bar_down.color = color;
	}
	mutl_bar_down.xAxis = [ {
		type : 'category',
		axisLabel : {
			interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
			rotate : 0,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
		}
	} ];
	if (rotate == undefined && rotate != '') {
		mutl_bar_down.xAxis = [ {
			type : 'category',
			axisLabel : {
				interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
				rotate : 0,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
			}
		} ]
	} else {
		mutl_bar_down.xAxis = [ {
			type : 'category',
			axisLabel : {
				interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
				rotate : 30,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
			}
		} ]
	}
	echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();

	echartsobj = barLineAjax_down_itemStyle(url, echartsobj, mutl_bar_down, id, width, callback);
	return echartsobj;
}
function load_mutl_bar_down_r(url, id, title, subtext, yAxis, rotate, width, color) {
	var echartsobj = echarts.init(document.getElementById(id));
	if (title != null && title != '') {
		mutl_bar_down.title.text = title;
	}
	if (subtext != null && subtext != '') {
		mutl_bar_down.title.subtext = subtext;
	}
	mutl_bar_down.grid = {
		top : "10.5%",
		left : '0%',
		right : '3%',
		bottom : '10%',
		containLabel : true
	}
	if (yAxis != null && yAxis != '') {
		mutl_bar_down.yAxis = yAxis;
	}
	if (color != undefined && color != "") {
		mutl_bar_down.color = color;
	}
	if (rotate == undefined && rotate != '') {
		mutl_bar_down.xAxis = [ {
			type : 'category',
			axisLabel : {
				interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
				rotate : 0,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
			}
		} ]
	} else {
		mutl_bar_down.xAxis = [ {
			type : 'category',
			axisLabel : {
				interval : 0,// 0：全部显示，1：间隔为1显示对应类目，2：依次类推，（简单试一下就明白了，这样说是不是有点抽象）
				rotate : 30,// 倾斜显示，-：顺时针旋转，+或不写：逆时针旋转
			}
		} ]
	}
	echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();

	echartsobj = barLineAjax_down(url, echartsobj, mutl_bar_down, id, width);
	return echartsobj;
}
function load_mutl_bar_down_color(url, id, title, subtext, yAxis, color) {
	var echartsobj = echarts.init(document.getElementById(id));
	if (title != null && title != '') {
		mutl_bar_down.title.text = title;
	}
	if (subtext != null && subtext != '') {
		mutl_bar_down.title.subtext = subtext;
	}
	mutl_bar_down.grid = {
		top : "10.5%",
		left : '1.5%',
		right : '3%',
		bottom : '10%',
		containLabel : true
	}
	if (color != undefined) {
		mutl_bar_down.color = color;
	} else {
		mutl_bar_down.color = [ "#66e0e3", "#fedb5b" ]
	}
	if (yAxis != null && yAxis != '') {
		mutl_bar_down.yAxis = yAxis;
	}
	echartsobj.clear();
	echartsobj.setOption(mutl_bar_down);
	echartsobj.showLoading();

	echartsobj = barLineAjax_down(url, echartsobj, mutl_bar_down, id);
	return echartsobj;
}

function barLineAjax_down(url, echartsobj, options, id, width, callback) {

	var legends = [];
	var xAxisData = [];
	var seriesData = [];
	var dataresutl;
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		timeout : 11000,
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (data.success == true || data.success == 'true') {
				echartsobj.hideLoading();
				dataresutl = data.data;
				set_multi_graph_statistics(dataresutl, id);
				var legendDataList = data.data.legendDataList;
				// 挨个取出类别并填入类别数组
				for (var i = 0; i < legendDataList.length; i++) {
					legends.push(legendDataList[i]);
				}
				var xAxisDataList = data.data.xAxisDataList;
				for (var i = 0; i < xAxisDataList.length; i++) {

					xAxisData.push(xAxisDataList[i]);
				}
				var seriesList = data.data.seriesList;

				var barWidth = 20;
				if (width != undefined && width != "") {
					barWidth = width
				}

				for (var i = 0; i < seriesList.length; i++) {

					seriesData.push({
						type : seriesList[i].type,
						name : seriesList[i].name,
						data : seriesList[i].data,
						stack : seriesList[i].stack,
						barWidth : barWidth,
						barGap : "4%",
						yAxisIndex : seriesList[i].yAxisIndex,
						itemStyle : {
							normal : {
								label : {
									show : true,
									color : "#000",
									position : 'inside'
								}
							}
						},

					});
				}
				// 加载数据图表
				echartsobj.setOption({
					legend : {
						data : legends
					},
					xAxis : [ {
						type : 'category',
						data : xAxisData
					} ],
					series : seriesData
				});

			} else {

			}
			if (callback) {
				callback(data);
			}
		},
		error : function() {
		},
		complete : function(XMLHttpRequest, status) {
			if (status == 'timeout') {
			}
		}

	});
	return echartsobj;

}
function barLineAjax_down_f(url, echartsobj, options, id, width, callback) {

	var legends = [];
	var xAxisData = [];
	var seriesData = [];
	var selecteds = {};
	var dataresutl;
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		timeout : 11000,
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (data.success == true || data.success == 'true') {
				echartsobj.hideLoading();
				dataresutl = data.data;
				set_multi_graph_statistics(dataresutl, id);
				var legendDataList = data.data.legendDataList;
				// 挨个取出类别并填入类别数组
				for (var i = 0; i < legendDataList.length; i++) {
					legends.push(legendDataList[i]);
					console.log(legendDataList[i])
					if (legendDataList[i] == "100万以下") {
						selecteds[legendDataList[i]] = false;
					}
				}
				var xAxisDataList = data.data.xAxisDataList;
				for (var i = 0; i < xAxisDataList.length; i++) {

					xAxisData.push(xAxisDataList[i]);
				}
				var seriesList = data.data.seriesList;

				var barWidth = 20;
				if (width != undefined && width != "") {
					barWidth = width
				}

				for (var i = 0; i < seriesList.length; i++) {

					seriesData.push({
						type : seriesList[i].type,
						name : seriesList[i].name,
						data : seriesList[i].data,
						stack : seriesList[i].stack,
						barWidth : barWidth,
						barGap : "4%",
						yAxisIndex : seriesList[i].yAxisIndex,
						itemStyle : {
							normal : {
								label : {
									show : true,
									color : "#000",
									position : 'inside'
								}
							}
						},

					});
				}
				// 加载数据图表
				echartsobj.setOption({
					legend : {
						data : legends,
						selected : selecteds
					},
					xAxis : [ {
						type : 'category',
						data : xAxisData
					} ],
					series : seriesData
				});

			} else {

			}
			if (callback) {
				callback(data);
			}
		},
		error : function() {
		},
		complete : function(XMLHttpRequest, status) {
			if (status == 'timeout') {
			}
		}

	});
	return echartsobj;

}
function barLineAjax_down_itemStyle(url, echartsobj, options, id, width, callback) {

	var legends = [];
	var xAxisData = [];
	var seriesData = [];
	var dataresutl;
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		timeout : 11000,
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (data.success == true || data.success == 'true') {
				echartsobj.hideLoading();
				dataresutl = data.data;
				set_multi_graph_statistics(dataresutl, id);
				var legendDataList = data.data.legendDataList;
				// 挨个取出类别并填入类别数组
				for (var i = 0; i < legendDataList.length; i++) {
					legends.push(legendDataList[i]);
				}
				var xAxisDataList = data.data.xAxisDataList;
				for (var i = 0; i < xAxisDataList.length; i++) {

					xAxisData.push(xAxisDataList[i]);
				}
				var seriesList = data.data.seriesList;

				var barWidth = 20;
				if (width != undefined && width != "") {
					barWidth = width
				}

				for (var i = 0; i < seriesList.length; i++) {

					seriesData.push({
						type : seriesList[i].type,
						name : seriesList[i].name,
						data : seriesList[i].data,
						stack : seriesList[i].stack,
						barWidth : barWidth,
						yAxisIndex : seriesList[i].yAxisIndex

					});
				}
				// 加载数据图表
				echartsobj.setOption({
					legend : {
						data : legends
					},
					xAxis : [ {
						type : 'category',
						data : xAxisData
					} ],
					series : seriesData
				});

			} else {

			}
			if (callback) {
				callback(data);
			}
		},
		error : function() {
		},
		complete : function(XMLHttpRequest, status) {
			if (status == 'timeout') {
			}
		}

	});
	return echartsobj;

}
// 单
function getSingleDataCountForName(data, strName) {
	var xAxisDataList = data.xAxisDataList;
	var seriesList = data.seriesDataList;
	var ii = 0;
	for (var i = 0; i < xAxisDataList.length; i++) {
		if (xAxisDataList[i] == strName) {
			ii = i;
		}
	}
	var xkCount = 0;
	for (var i = 0; i < seriesList.length; i++) {
		var value_data = seriesList[i];
		if (ii == i) {
			xkCount = value_data;
		}
	}
	return parseInt(xkCount);

}

// 多
function getDataCountForName(data, strName) {
	var seriesList = data.seriesList;
	// alert(seriesList.length);

	var xkCount = 0;
	for (var i = 0; i < seriesList.length; i++) {
		var arr = seriesList[i].data;
		var name = seriesList[i].name;
		if (name == strName) {
			var name_count = 0;
			for (var j = 0; j < arr.length; j++) {
				name_count = name_count + parseInt(arr[j]);
			}
			xkCount = name_count;
		}
	}
	return parseInt(xkCount);
}

// 单柱图
function set_single_graph_statistics(data, id) {

	if (id == 'contract_chart1') {
		var xkCount_1 = getSingleDataCountForName(data, '已签');
		var jzCount_2 = getSingleDataCountForName(data, '未签');
		var allCount_3 = xkCount_1 + jzCount_2;

		if (isNaN(allCount_3)) {
			allCount_3 = 0;
		}
		if (isNaN(xkCount_1)) {
			xkCount_1 = 0;
		}
		if (isNaN(jzCount_2)) {
			jzCount_2 = 0;
		}
		$("#contract_chart1_01").html(allCount_3 + "个");
		$("#contract_chart1_02").html(xkCount_1 + "个");
		$("#contract_chart1_03").html(jzCount_2 + "个");
	}

	if (id == 'contract_chart4') {

		var count_1 = getSingleDataCountForName(data, '发明授权');
		var count_2 = getSingleDataCountForName(data, '外观设计');
		var count_3 = getSingleDataCountForName(data, '实用新型');
		var count_all = count_1 + count_2 + count_3;

		if (isNaN(count_2)) {
			count_2 = 0;
		}

		$("#contract_chart4_01").html(count_all);
		$("#contract_chart4_02").html(count_1);
		$("#contract_chart4_03").html(count_2);
		$("#contract_chart4_04").html(count_3);

	}
}

// 多柱图 -统计
function set_multi_graph_statistics(data, id) {

	/** =============================直属研究院=========================== */

	// 专利
	if (id == 'knowldege_chart1') {
		var xkCount_1 = getDataCountForName(data, '专利申请');
		var jzCount_2 = getDataCountForName(data, '专利授权');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#knowldege_chart1_01").html(allCount_3 + "个");
		$("#knowldege_chart1_02").html(xkCount_1 + "个");
		$("#knowldege_chart1_03").html(jzCount_2 + "个");
	}
	if (id == 'knowldege_chart4') {

		var count_1 = getDataCountForName(data, '发明专利');
		var count_2 = getDataCountForName(data, '外观设计');
		var count_3 = getDataCountForName(data, '实用新型');
		var count_all = count_1 + count_2 + count_3;

		$("#knowldege_chart4_01").html(count_all + "个");
		$("#knowldege_chart4_02").html(count_1 + "个");
		$("#knowldege_chart4_03").html(count_2 + "个");
		$("#knowldege_chart4_04").html(count_3 + "个");

	}

	// 直属研究院课题分布
	if (id == 'topic_chart1') {
		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		if (isNaN(allCount_3)) {
			allCount_3 = 0;
		}
		if (isNaN(xkCount_1)) {
			xkCount_1 = 0;
		}
		if (isNaN(jzCount_2)) {
			jzCount_2 = 0;
		}
		$("#topic_chart1_01").html(allCount_3 + "个");
		$("#topic_chart1_02").html(xkCount_1 + "个");
		$("#topic_chart1_03").html(jzCount_2 + "个");
	}

	/*
	 * if(id=='investment_smal_chart1') { var
	 * xkCount_1=getDataCountForName(data,'预算金额'); var
	 * jzCount_2=getDataCountForName(data,'合同金额'); var
	 * jzCount_3=getDataCountForName(data,'拨款金额');
	 * 
	 * $("#investment_smal_chart1_01").html(xkCount_1+"个");
	 * $("#investment_smal_chart1_02").html(jzCount_2+"个");
	 * $("#investment_smal_chart1_03").html(jzCount_3+"个");
	 *  }
	 */
	/*
	 * if(id=='investment_smal_chart2') { var
	 * xkCount_1=getDataCountForName(data,'预算金额'); var
	 * jzCount_2=getDataCountForName(data,'合同金额'); var
	 * jzCount_3=getDataCountForName(data,'拨款金额');
	 * 
	 * $("#investment_smal_chart2_01").html(xkCount_1+"个");
	 * $("#investment_smal_chart2_02").html(jzCount_2+"个");
	 * $("#investment_smal_chart2_03").html(jzCount_3+"个");
	 *  }
	 */

	if (id == 'direct_topic_chart3') {

		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#direct_topic_chart3_01").html(allCount_3 + "个");
		$("#direct_topic_chart3_02").html(xkCount_1 + "个");
		$("#direct_topic_chart3_03").html(jzCount_2 + "个");

	}

	if (id == 'topic_chart4') {

		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#topic_chart4_01").html(allCount_3 + "个");
		$("#topic_chart4_02").html(xkCount_1 + "个");
		$("#topic_chart4_03").html(jzCount_2 + "个");

	}
	if (id == 'topic_chart7') {

		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#topic_chart7_01").html(allCount_3 + "个");
		$("#topic_chart7_02").html(xkCount_1 + "个");
		$("#topic_chart7_03").html(jzCount_2 + "个");

	}

	// 专业处所属科研课题分布
	if (id == 'topic_chart8') {

		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#topic_chart8_01").html(allCount_3 + "个");
		$("#topic_chart8_02").html(xkCount_1 + "个");
		$("#topic_chart8_03").html(jzCount_2 + "个");

	}
	// 合同
	if (id == 'contract_chart4') {

		var count_1 = getDataCountForName(data, '计划签订');
		var count_2 = getDataCountForName(data, '实际签订');

		$("#contract_chart4_01").html(count_1 + "个");
		$("#contract_chart4_02").html(count_2 + "个");
		if (count_1 == 0) {
			$("#contract_chart4_03").html("0%");
		} else {
			var tt = percentNum(count_2, count_1);
			$("#contract_chart4_03").html(tt);
		}

	}

	// 装备
	if (id == 'equipment_chart1') {
		var xkCount_1 = getDataCountForName(data, '新开课题');
		var jzCount_2 = getDataCountForName(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#equipment_chart1_01").html(allCount_3 + "个");
		$("#equipment_chart1_02").html(xkCount_1 + "个");
		$("#equipment_chart1_03").html(jzCount_2 + "个");
	}

	if (id == 'direct_knowledge_chart1') {
		var xkCount_1 = getDataCountForName(data, '申请总数');
		var jzCount_2 = getDataCountForName(data, '授权总数');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#direct_knowledge_chart1_01").html(allCount_3 + "个");
		$("#direct_knowledge_chart1_02").html(xkCount_1 + "个");
		$("#direct_knowledge_chart1_03").html(jzCount_2 + "个");
	}

	if (id == 'direct_contract_chart') {
		var count_1 = getDataCountForName(data, '已签');
		var count_2 = getDataCountForName(data, '未签');

		$("#direct_contract_chart_01").html(count_1 + "个");
		$("#direct_contract_chart_02").html(count_2 + "个");
		$("#direct_contract_chart_03").html(percentNum(count_1, count_1 + count_2));
	}

	if (id == 'pay_chart1') {
		var xkCount_1 = getDataCountForNameFloat(data, '新开课题');
		var jzCount_2 = getDataCountForNameFloat(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#pay_chart1_01").html(allCount_3.toFixed(2) + "亿元");
		$("#pay_chart1_02").html(xkCount_1.toFixed(2) + "亿元");
		$("#pay_chart1_03").html(jzCount_2.toFixed(2) + "亿元");
	}

	if (id == 'investment_chart6') {
		var jzCount_1 = getDataCountForNameFloat(data, '新开课题预算金额');
		var jzCount_2 = getDataCountForNameFloat(data, '新开课题实际金额');
		$("#investment_chart6_01").html(jzCount_1.toFixed(2) + "亿元");
		$("#investment_chart6_02").html(jzCount_2.toFixed(2) + "亿元");
	}

	if (id == 'pay_chart3') {

	}

	if (id == 'dragon3') {

		var xkCount_1 = getDataCountForName(data, '十条龙项目');
		var jzCount_2 = getDataCountForName(data, '重大项目');
		var allCount_3 = xkCount_1 + jzCount_2;

		// $("#dragon3_01").html(allCount_3+"个");
		// $("#dragon3_02").html(xkCount_1+"个");
		$("#dragon3_03").html(jzCount_2 + "个");
	}

	if (id == 'leader_knowledge_chart1') {
		var xkCount_1 = getDataCountForName(data, '专利申请');
		var jzCount_2 = getDataCountForName(data, '专利授权');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#leader_knowledge_chart1_02").html(xkCount_1 + "个");
		$("#leader_knowledge_chart1_03").html(jzCount_2 + "个");
	}

	if (id == 'leader_knowledge_chart4') {
		var count1 = getDataCountForName(data, '发明专利');
		var count2 = getDataCountForName(data, '外观设计');
		var count3 = getDataCountForName(data, '使用信息');
		var allCount_3 = count1 + count2 + count3;

		$("#leader_knowledge_chart4_01").html(allCount_3 + "个");
		$("#leader_knowledge_chart4_02").html(count1 + "个");
		$("#leader_knowledge_chart4_03").html(count2 + "个");
		$("#leader_knowledge_chart4_04").html(count3 + "个");
	}

	if (id == 'leader_knowledge_chart7') {
		var count_1 = getDataCountForName(data, '发明专利');
		var count_2 = getDataCountForName(data, '外观设计');
		var count_3 = getDataCountForName(data, '实用新型');
		var count_all = count_1 + count_2 + count_3;

		$("#leader_knowledge_chart7_01").html(count_all + "个");
		$("#leader_knowledge_chart7_02").html(count_1 + "个");
		$("#leader_knowledge_chart7_03").html(count_2 + "个");
		$("#leader_knowledge_chart7_04").html(count_3 + "个");

	}

	if (id == 'direct_kt_chart1') {
		var xkCount_1 = getDataCountForNameFloat(data, '新开课题');
		var jzCount_2 = getDataCountForNameFloat(data, '结转课题');
		var allCount_3 = xkCount_1 + jzCount_2;

		$("#direct_kt_chart1_01").html(allCount_3 + "个");
		$("#direct_kt_chart1_02").html(xkCount_1 + "个");
		$("#direct_kt_chart1_03").html(jzCount_2 + "个");
	}

	if (id == 'equipment_01_chart') {

		var xkCount_1 = getDataCountForName(data, '500万以上');
		var jzCount_2 = getDataCountForName(data, '300-500万');
		var jzCount_3 = getDataCountForName(data, '100-300万');
		var jzCount_4 = getDataCountForName(data, '100万以下');
		var allCount = xkCount_1 + jzCount_2 + jzCount_3 + jzCount_4;
		$("#chart_title_01").html(allCount + "个");
	}
	
	// 领导页-科研投入chart1
	if (id == 'investment_chart1') {
		var fxyMoney = getDataCountForName(data, '费用性科研投入');
		var zbxMoney = getDataCountForName(data, '资本性科研投入');
		var totalMoney = getDataCountForName(data, '总预算科研投入');
		
		$("#investment_chart1_01").html(totalMoney.toFixed(2) + "亿元");
		$("#investment_chart1_02").html(fxyMoney.toFixed(2) + "亿元");
		$("#investment_chart1_03").html(zbxMoney.toFixed(2) + "亿元");
		if (totalMoney == '0') {
			$("#investment_chart1_04").html("0%");
		} else {
			$("#investment_chart1_04").html(percentNum(fxyMoney + zbxMoney, totalMoney));
		}

	}

}
function getDataCountForNameFloat(data, strName) {
	var seriesList = data.seriesList;
	var xkCount = 0;
	if (typeof (seriesList) == "undefined") {

	} else {
		for (var i = 0; i < seriesList.length; i++) {
			var arr = seriesList[i].data;
			var name = seriesList[i].name;
			if (name == strName) {
				var name_count = 0;
				for (var j = 0; j < arr.length; j++) {
					name_count = name_count + parseFloat(arr[j]);
				}
				xkCount = name_count;
			}
		}

	}
	return parseFloat(xkCount);

}
// 小数点后两位百分比
function percentNum(num, num2) {

	// return Math.floor(num / num2 * 100) / 100+"%";
	return (Math.round(num / num2 * 10000) / 100.00 + "%");
}

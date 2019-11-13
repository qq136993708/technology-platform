/**===================================================立项==============================================*/



var option1_common = {
      		  title: {
                    text: '年度项目数量分析',
                    x:'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
      		    legend: {
      		    	type: 'scroll',
        	        bottom: 10,
      		        data:['2018','2017','同比']
      		    },
      		    xAxis: [
      		        {
      		            type: 'category',
      		            data: ['计划立项','预算批复','合同执行','成果鉴定','科技奖励'],
      		            axisPointer: {
      		                type: 'shadow'
      		            }
      		        }
      		    ],
      		    yAxis: [
      		        {
      		            type: 'value',
      		            name: '金额（万元）',
      		            min: 0,
      		            max: 250,
      		            axisLabel: {
      		                formatter: '{value}'
      		            }
      		        },
      		        {
      		            type: 'value',
      		            name: '同比',
      		            min: 0,
      		            max: 100,
      		            axisLabel: {
      		                formatter: '{value} %'
      		            }
      		        }
      		    ],
      		    series: [
    		        {
    		            name:'2018',
    		            type:'bar',
    		            color: ['#37A2DA'],
    		            data:[22, 44, 74, 24,22]
    		        },
    		        {
    		            name:'2017',
    		            type:'bar',
    		            color: ['#67E0E3'],
    		            data:[22, 44, 74, 24]
    		        },
    		        
    		        {
    		            name:'同比',
    		            type:'line',
    		            itemStyle : {  /*设置折线颜色*/
                            normal : {
                                color:'#c4cddc'
                            }
                        },
    		            data:[1.2, 9.3, 32.2, 1.2,1.2]
    		        }
    		        
    		        
    		    ]
      		};  



var option2_setup = {
	    title : {
	        text: '项目级别占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['国家项目','总部项目','企业项目']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'国家项目'},
	                {value:210, name:'总部项目'},
	                {value:210, name:'企业项目'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};




var option3_setup = {
	    title : {
	        text: '管理类型占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['A','B1','B2','C']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'A'},
	                {value:210, name:'B1'},
	                {value:210, name:'B2'},
	                {value:134, name:'C'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

var option4_setup = {
	    title : {
	        text: '单位占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        /* x : 10,  
            y : 100, */
            data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'石勘院'},
	                {value:210, name:'物探院'},
	                {value:134, name:'工程院'},
	                {value:134, name:'石科院'},
	                {value:134, name:'抚研院'},
	                {value:134, name:'北化院'},
	                {value:134, name:'上海院'},
	                {value:134, name:'安工院'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};







var option5_setup = {
		  title: {
            text: '单位项目数量同比分析',
            x:'center'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
		        data:['本年','上年','比率']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        },
		        {
		            type: 'value',
		            name: '比率',
		            min: 0,
		            max: 100,
		            axisLabel: {
		                formatter: '{value} %'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'本年',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[22, 44, 74, 24,22, 44, 74, 24]
	        },
	        {
	            name:'上年',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[22, 44, 74, 24,22, 44, 74, 24]
	        },
	        
	        {
	            name:'比率',
	            type:'line',
	            itemStyle : {  /*设置折线颜色*/
                    normal : {
                        color:'#c4cddc'
                    }
                },
	            data:[1.2, 9.3, 32.2, 1.2,1.2, 2.3, 32.2, 8.2]
	        }
	        
	        
	    ]
		};  









/**===================================================批复==============================================*/



var option2_reply = {
	    title : {
	        text: '项目级别占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['国家项目','总部项目','企业项目']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'国家项目'},
	                {value:210, name:'总部项目'},
	                {value:210, name:'企业项目'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
var option3_reply = {
	    title : {
	        text: '管理类型占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['A','B1','B2','C']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'A'},
	                {value:210, name:'B1'},
	                {value:210, name:'B2'},
	                {value:134, name:'C'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

  


var option4_reply = {
	    title : {
	        text: '单位占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        /* x : 10,  
            y : 100, */
            data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'石勘院'},
	                {value:210, name:'物探院'},
	                {value:134, name:'工程院'},
	                {value:134, name:'石科院'},
	                {value:134, name:'抚研院'},
	                {value:134, name:'北化院'},
	                {value:134, name:'上海院'},
	                {value:134, name:'安工院'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};









var option5_reply = {
		  title: {
              text: '单位项目数量同比分析',
              x:'center'
          },
          tooltip: {
              trigger: 'axis',
              axisPointer: {
                  type: 'cross',
                  crossStyle: {
                      color: '#999'
                  }
              }
          },
          toolbox: {
              feature: {
                  dataView: {show: true, readOnly: false},
                  magicType: {show: true, type: ['line', 'bar']},
                  restore: {show: true},
                  saveAsImage: {show: true}
              }
          },
		    legend: {
		    	type: 'scroll',
  	        bottom: 10,
		        data:['本年','上年','比率']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        },
		        {
		            type: 'value',
		            name: '比率',
		            min: 0,
		            max: 100,
		            axisLabel: {
		                formatter: '{value} %'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'本年',
		            type:'bar',
		            color: ['#37A2DA'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        {
		            name:'上年',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        
		        {
		            name:'比率',
		            type:'line',
		            itemStyle : {  /*设置折线颜色*/
                      normal : {
                          color:'#c4cddc'
                      }
                  },
		            data:[1.2, 9.3, 32.2, 1.2,1.2, 2.3, 32.2, 8.2]
		        }
		        
		        
		    ]
		};  


/**===================================================合同金额==============================================*/








var option2_contract = {
		
		 title: {
            text: '项目合同执行率',
            x:'center'
        },
	    tooltip : {
	        formatter: "{a} <br/>{b} : {c}%"
	    },
	    toolbox: {
	        feature: {
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    series: [
	        {
	            name: '业务指标',
	            type: 'gauge',
	            detail: {formatter:'{value}%'},
	            data: [{value: 50, name: '完成率'}]
	        }
	    ]
	};


var option4_contract = {
		  title: {
          text: '管理类型执行率分析（万元）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
		        data:['预算批复','合同执行','执行%']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['A','B1','B2','C'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'预算批复',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74, 72]
	        },
	        {
	            name:'合同执行',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74, 12]
	        },
	        {
	            name:'执行%',
	            type:'bar',
	            data:[212, 224, 214, 78]
	        }
	    ]
		}; 

var option3_contract = {
		  title: {
          text: '项目级别执行率分析（万元）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
		        data:['预算批复','合同执行','执行%']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['国家项目','总部项目','企业项目'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'预算批复',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74]
	        },
	        {
	            name:'合同执行',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74]
	        },
	        {
	            name:'执行%',
	            type:'bar',
	            data:[212, 224, 214]
	        }
	    ]
		};  
var option5_contract = {
	    title : {
	        text: '合同执行经费占比分析（万元）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        /* x : 10,  
            y : 100, */
            data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'石勘院'},
	                {value:210, name:'物探院'},
	                {value:134, name:'工程院'},
	                {value:134, name:'石科院'},
	                {value:134, name:'抚研院'},
	                {value:134, name:'北化院'},
	                {value:134, name:'上海院'},
	                {value:134, name:'安工院'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};



var option6_contract = {
		  title: {
              text: '各单位项目合同执行率分析',
              x:'center'
          },
          tooltip: {
              trigger: 'axis',
              axisPointer: {
                  type: 'cross',
                  crossStyle: {
                      color: '#999'
                  }
              }
          },
          toolbox: {
              feature: {
                  dataView: {show: true, readOnly: false},
                  magicType: {show: true, type: ['line', 'bar']},
                  restore: {show: true},
                  saveAsImage: {show: true}
              }
          },
		    legend: {
		    	type: 'scroll',
  	        bottom: 10,
		        data:['预算批复','合同执行','实际执行%']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        },
		        {
		            type: 'value',
		            name: '比率',
		            min: 0,
		            max: 100,
		            axisLabel: {
		                formatter: '{value} %'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'预算批复',
		            type:'bar',
		            color: ['#37A2DA'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        {
		            name:'合同执行',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        
		        {
		            name:'实际执行%',
		            type:'line',
		            itemStyle : {  /*设置折线颜色*/
                      normal : {
                          color:'#c4cddc'
                      }
                  },
		            data:[1.2, 9.3, 32.2, 1.2,1.2, 2.3, 32.2, 8.2]
		        }
		        
		        
		    ]
		}; 





















/**===================================================成果=============================================*/





var option2_achievement = {
	    title : {
	        text: '鉴定成果占比分析（项）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
            data: ['国际领先','国际先进','国内领先','国内先进']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'国际领先'},
	                {value:210, name:'国际先进'},
	                {value:134, name:'国内领先'},
	                {value:134, name:'国内先进'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

var option3_achievement = {
		  title: {
          text: '项目级别成果鉴定分析（项）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
	        data: ['国际领先','国际先进','国内领先','国内先进']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['国家项目','总部项目','企业项目'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'国际领先',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74]
	        },
	        {
	            name:'国际先进',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74]
	        },
	        {
	            name:'国内领先',
	            type:'bar',
	            data:[212, 224, 214]
	        },
	        {
	            name:'国内先进',
	            type:'bar',
	            data:[212, 224, 214]
	        }
	    ]
		};  





var option4_achievement = {
		  title: {
          text: '管理类型执行率分析（项）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
	        data: ['国际领先','国际先进','国内领先','国内先进']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['A','B1','B2','C'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'国际领先',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74, 72]
	        },
	        {
	            name:'国际先进',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74, 12]
	        },
	        {
	            name:'国内领先',
	            type:'bar',
	            data:[212, 224, 214, 78]
	        },
	        {
	            name:'国内先进',
	            type:'bar',
	            data:[212, 224, 214, 78]
	        }
	    ]
		};  


var option5_achievement = {
		  title: {
              text: '单位项目数量同比分析',
              x:'center'
          },
          tooltip: {
              trigger: 'axis',
              axisPointer: {
                  type: 'cross',
                  crossStyle: {
                      color: '#999'
                  }
              }
          },
          toolbox: {
              feature: {
                  dataView: {show: true, readOnly: false},
                  magicType: {show: true, type: ['line', 'bar']},
                  restore: {show: true},
                  saveAsImage: {show: true}
              }
          },
		    legend: {
		    	type: 'scroll',
  	        bottom: 10,
  	        data: ['国际领先','国际先进','国内领先','国内先进']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'国际领先',
		            type:'bar',
		            color: ['#37A2DA'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        {
		            name:'国际先进',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },{
		            name:'国内领先',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        
		        {
		            name:'国内先进',
		            type:'bar',
		            itemStyle : {  /*设置折线颜色*/
                      normal : {
                          color:'#c4cddc'
                      }
                  },
                  data:[22, 44, 44, 24,22, 44, 74, 224]
		        }
		        
		        
		    ]
		}; 









/**===================================================奖励==============================================*/





var option2_award = {
	    title : {
	        text: '鉴定成果占比分析（项）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['科技进步奖','技术发明奖','前瞻研究奖']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'科技进步奖'},
	                {value:210, name:'技术发明奖'},
	                {value:134, name:'前瞻研究奖'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

var option3_award = {
		  title: {
          text: '项目级别成果鉴定分析（项）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
	        data: ['科技进步奖','技术发明奖','前瞻研究奖']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['国家项目','总部项目','企业项目'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'科技进步奖',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74]
	        },
	        {
	            name:'技术发明奖',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74]
	        },
	        {
	            name:'前瞻研究奖',
	            type:'bar',
	            data:[212, 224, 214]
	        }
	    ]
		};  

var option4_award = {
		  title: {
          text: '管理类型执行率分析（项）',
          x:'center'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      toolbox: {
          feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
          }
      },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
	        data: ['科技进步奖','技术发明奖','前瞻研究奖']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['A','B1','B2','C'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 450,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'科技进步奖',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[252, 44, 74, 72]
	        },
	        {
	            name:'技术发明奖',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[222, 24, 74, 12]
	        },
	        {
	            name:'前瞻研究奖',
	            type:'bar',
	            data:[212, 224, 214, 78]
	        }
	    ]
		}; 

var option5_award = {
		  title: {
              text: '单位项目数量同比分析',
              x:'center'
          },
          tooltip: {
              trigger: 'axis',
              axisPointer: {
                  type: 'cross',
                  crossStyle: {
                      color: '#999'
                  }
              }
          },
          toolbox: {
              feature: {
                  dataView: {show: true, readOnly: false},
                  magicType: {show: true, type: ['line', 'bar']},
                  restore: {show: true},
                  saveAsImage: {show: true}
              }
          },
		    legend: {
		    	type: 'scroll',
  	        bottom: 10,
  	        data: ['科技进步奖','技术发明奖','前瞻研究奖']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'科技进步奖',
		            type:'bar',
		            color: ['#37A2DA'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },
		        {
		            name:'技术发明奖',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        },{
		            name:'前瞻研究奖',
		            type:'bar',
		            color: ['#67E0E3'],
		            data:[22, 44, 74, 24,22, 44, 74, 24]
		        }
		        
		        
		    ]
		};  



/**===================================================合同关闭=============================================*/




var option2_close = {
	    title : {
	        text: '项目来源关闭占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['国家项目','总部项目','企业项目']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'国家项目'},
	                {value:210, name:'总部项目'},
	                {value:210, name:'企业项目'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};




var option3_close = {
	    title : {
	        text: '管理级别关闭占比分析（个）',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        data: ['A','B1','B2','C']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'A'},
	                {value:210, name:'B1'},
	                {value:210, name:'B2'},
	                {value:134, name:'C'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

var option4_close = {
	    title : {
	        text: '研究院合同关闭占比分析（个',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    	type: 'scroll',
	        bottom: 10,
	        /* x : 10,  
            y : 100, */
            data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: ['20%', '50%'],
	            avoidLabelOverlap: false,
	            data:[
	                {value:135, name:'石勘院'},
	                {value:210, name:'物探院'},
	                {value:134, name:'工程院'},
	                {value:134, name:'石科院'},
	                {value:134, name:'抚研院'},
	                {value:134, name:'北化院'},
	                {value:134, name:'上海院'},
	                {value:134, name:'安工院'}
	            ],
	            itemStyle: {
	            	normal:{ 
                        label:{ 
                            show: true, 
                            formatter: '{b} \n {c} ({d}%)' 
                        }, 
                        labelLine :{show:true} 
                 },
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};



var option5_close = {
		  title: {
            text: '单位项目关闭数量同比分析',
            x:'center'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
		    legend: {
		    	type: 'scroll',
	        bottom: 10,
		        data:['执行数量','关闭数量','关闭比率']
		    },
		    xAxis: [
		        {
		            type: 'category',
		          data: ['石勘院','物探院','工程院','石科院','抚研院','北化院','上海院','安工院'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		            min: 0,
		            max: 250,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        },
		        {
		            type: 'value',
		            name: '比率',
		            min: 0,
		            max: 100,
		            axisLabel: {
		                formatter: '{value} %'
		            }
		        }
		    ],
		    series: [
	        {
	            name:'执行数量',
	            type:'bar',
	            color: ['#37A2DA'],
	            data:[22, 44, 74, 24,22, 44, 74, 24]
	        },
	        {
	            name:'关闭数量',
	            type:'bar',
	            color: ['#67E0E3'],
	            data:[22, 44, 74, 24,22, 44, 74, 24]
	        },
	        
	        {
	            name:'关闭比率',
	            type:'line',
	            itemStyle : {  /*设置折线颜色*/
                    normal : {
                        color:'#c4cddc'
                    }
                },
	            data:[1.2, 9.3, 32.2, 1.2,1.2, 2.3, 32.2, 8.2]
	        }
	        
	        
	    ]
		};  



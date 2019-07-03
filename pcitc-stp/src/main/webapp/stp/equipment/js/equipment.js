 
    function  getTaskSpecialAuditor0ByProfessionalDepartName(professionalDepartName)
	{
		var specialAuditor0="";
		if(professionalDepartName.indexOf("勘探")!= -1)
		{
			specialAuditor0="";//关晓东
		}
		if(professionalDepartName.indexOf("石油")!= -1)
		{
			specialAuditor0="";//陈本池
		}
		if(professionalDepartName.indexOf("炼油")!= -1)
		{
			specialAuditor0="30130056_LYC_ZYCCZ";//潘煜
		}
		if(professionalDepartName.indexOf("化工")!= -1)
		{
			specialAuditor0="30130057_HGC_ZYCCZ";//方志平
		}
		if(professionalDepartName.indexOf("材料")!= -1)
		{
			specialAuditor0="30130058_CLC_ZYCCZ";//庄毅
		}
		if(professionalDepartName.indexOf("装备与储运")!= -1)
		{
			specialAuditor0="30130059_CYC_ZYCCZ";//卢衍波
		}
		if(professionalDepartName.indexOf("知识产权")!= -1)
		{
			specialAuditor0="30130061_ZSCQC_ZYCCZ";//陈蓓艳
		}
		if(professionalDepartName.indexOf("三剂")!= -1)
		{
			specialAuditor0="30130062_SJC_ZYCCZ";//林雯
		}
		if(professionalDepartName.indexOf("技术监督")!= -1)
		{
			specialAuditor0="30130063_JSJDC_ZYCCZ";//秦士珍
		}
		return specialAuditor0;
	}
    
    
    
    
    function getDepartNameByParentCode(parentCode)
    {
    	
    	 $("#professionalDepartCode").empty();
    	 var v_date=(new Date()).getTime();
    	 if(parentCode!=null && parentCode!='')
         {
    		 
    		 $.ajax({
    				url : "/sre-project-basic/getDicListByParentCode?v_date="+v_date+"&parentCode="+parentCode,
    				type : "post",
    				async: false,
    				dataType : "json",
    				success : function(data) 
    				{
    					$("#professionalDepartCode").append("<option value=''>--请选择--</option>");
    					$.each(data, function(i, el) 
    					{
    						$("#professionalDepartCode").append('<option value="'+ el.code +'">' + el.name+ '</option>');
    					});
    				},
    				error : function() 
    				{
    					alert("发生未知错误 ,请重新操作.");
    				}
    			});
    		 
         }
    	 var code_temp=$("#professionalDepartCode").val();
    	 getProfessionalNameListByParentCode(code_temp);
    }


    function getProfessionalNameListByParentCode(parentCode)
    {
    	
    	if(parentCode==null || parentCode=='')
    	{
    		parentCode='-1';
    	}
    	 $("#professionalFieldCode").empty();
    	 var v_date=(new Date()).getTime();
    	 $.ajax({
    			url : "/sre-project-basic/getDicListByParentCode?v_date="+v_date+"&parentCode="+parentCode,
    			type : "post",
    			async: false,
    			dataType : "json",
    			success : function(data) 
    			{
    				$("#professionalFieldCode").append("<option value=''>--请选择--</option>");
    				$.each(data, function(i, el) 
    				{
    					$("#professionalFieldCode").append('<option value="'+ el.code +'">' + el.name+ '</option>');
    	  			  	
    				});
    			},
    			error : function() 
    			{
    				alert("发生未知错误 ,请重新操作.");
    			}
    		});
    }
    
    
    
    
    
    
    // 时间格式化
    function formatTime(d) {
        if (d) {
            var date = new Date();
            date.setTime(d);
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            m = m < 10 ? ('0' + m) : m;
            var day = date.getDate();
            day = day < 10 ? ("0" + day) : day;
            var h = date.getHours();
            h = h < 10 ? ("0" + h) : h;
            var M = date.getMinutes();
            M = M < 10 ? ("0" + M) : M;
            var str = y + "-" + m + "-" + day + " " + h + ":" + M;
            return str;
        } else {
            return '';
        }
    }
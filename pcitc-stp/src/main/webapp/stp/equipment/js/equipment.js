 
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
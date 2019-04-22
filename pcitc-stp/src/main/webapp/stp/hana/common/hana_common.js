function init_companyCode(functionId)
{
	 var v_date=(new Date()).getTime();
	 $.ajax({
			url : "/getDirDeparetMentList?functionId="+ functionId+"&v_date="+v_date,
			type : "get",
			async: false,
			dataType : "json",
			success : function(data) 
			{
				//$("#companyCode").append("<option value=''>请选择</option>");
				$.each(data.data, function(i, el) 
				{
					$("#companyCode").append('<option value="'+ el.numValue +'">' + el.name+ '</option>');
					/* if(cityId==el.id)
					{
						$("#companyCode ").val(cityId);  
					} */
				});
			},
			error : function() 
			{
				alert("发生未知错误 ,请重新操作.");
			}
		});
}
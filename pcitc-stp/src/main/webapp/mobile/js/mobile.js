function setNumStr(num)
{
    	
    	var result="";
    	
    	if(num=='0.00')
		{
    		num=0;
		}
		if(Math.abs(parseFloat(num))>10000 )//亿
		{
			var  temp=parseFloat(num/10000).toFixed(2);
			var  endstr=temp.substring(temp.length-3);
			//alert(temp);
			if(endstr=='.00')
			{
				temp= temp.substring(0,temp.length-3);
			}
			result=temp+"<lable style='font-size:14px;font-weight:normal'>亿<lable>";
		}else//万
		{
			
			var  temp=parseFloat(num).toFixed(2);
			var  endstr=temp.substring(temp.length-3);
			if(endstr=='.00')
			{
				//temp= temp.replace(".00","")
				temp= temp.substring(0,temp.length-3);
			}
			result=temp+"<lable style='font-size:14px;font-weight:normal'>万<lable>";
		}
		return result;
}
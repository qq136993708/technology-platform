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




function page(id,url,type,functionN)
{
    var v_date = (new Date()).getTime();
    $.ajax({
        type: type,
        url: url ,
        timeout: 9000,
        dataType: 'json',
        cache: false,
        success: function (data, status) {
            console.log(data)
            var page = Math.ceil(data.count / 15);
            $("#" + id+"1").remove();
            if(page>1) { 
                var html = '<div class="mobile-page" id="' + id + '1">' +
                    '                    <a  href="javascript:;" class="aH">上一页</a>' +
                    '                    <ul class="show">' +
                    '                        <li><a href="javascript:;">1</a></li>' +
                    '                    </ul>' +
                    '                    <ul class="cont-number layui-hide"></ul>' +
                    '                    <a href="javascript:;" class="prev">下一页</a>' +
                    '                </div>';
                $("#" + id).after(html);
                var htmlUl = "";
                for (var i = 1; i <= page; i++) {
                    htmlUl += "<li><a href='javascript:;'> " + i + "</a></li>";
                }
                $("#" + id + "1 .cont-number").append(htmlUl);
                $("#" + id + "1 .show").click(function () {
                    if ($("#" + id + "1 .cont-number").attr("class").indexOf("layui-hide") != -1) {
                        $("#" + id + "1 .cont-number").removeClass("layui-hide");
                    } else {
                        $("#" + id + "1 .cont-number").addClass("layui-hide");
                    }
                });
                $("#" + id + "1 ul.cont-number li").click(function () {
                    $("#" + id + "1 .cont-number").addClass("layui-hide");
                    var number =$(this).text();
                    $("#" + id + "1 .show li a").html(number);
                    if(number==1){
                        $("#" + id + "1>a:eq(0)").removeClass("next");
                        $("#" + id + "1>a:eq(0)").addClass("aH");
                    }else {
                        $("#" + id + "1>a:eq(0)").addClass("next");
                        $("#" + id + "1>a:eq(0)").removeClass("aH");
                    }
                    if(number==page){
                        $("#" + id + "1>a:eq(1)").removeClass("prev");
                        $("#" + id + "1>a:eq(1)").addClass("aH");
                    }else {
                        $("#" + id + "1>a:eq(1)").addClass("prev");
                        $("#" + id + "1>a:eq(1)").removeClass("aH");
                    }
                   // functionN(url+"&page=" + parseInt(number), id, type);
                    eval(functionN+"('"+url+"&page=" + parseInt(number)+"','"+id+"','"+type+"');");
                });
                $(".prev").click(function () {
                    $("#" + id + "1 .cont-number").addClass("layui-hide");
                    var number=parseInt($("#" + id + "1 .show li a").html())+1;
                    $("#" + id + "1 .show li a").html(number);
                    if(number<=1){
                        $("#" + id + "1>a:eq(0)").removeClass("next");
                        $("#" + id + "1>a:eq(0)").addClass("aH");
                    }else {
                        $("#" + id + "1>a:eq(0)").addClass("next");
                        $("#" + id + "1>a:eq(0)").removeClass("aH");
                        $(".next").off("click").on("click",function () {
                            $("#" + id + "1 .cont-number").addClass("layui-hide");
                            var number1=parseInt($("#" + id + "1 .show li a").html())-1;
                            $("#" + id + "1 .show li a").html(number1);
                            if(number1<=1){
                                $("#" + id + "1>a:eq(0)").removeClass("next");
                                $("#" + id + "1>a:eq(0)").addClass("aH");
                                $("#" + id + "1 .show li a").html(1);
                            }else {
                                $("#" + id + "1>a:eq(0)").addClass("next");
                                $("#" + id + "1>a:eq(0)").removeClass("aH");
                            }
                            if(number1>page){
                                $("#" + id + "1>a:eq(1)").removeClass("prev");
                                $("#" + id + "1>a:eq(1)").addClass("aH");
                            }else {
                                $("#" + id + "1>a:eq(1)").addClass("prev");
                                $("#" + id + "1>a:eq(1)").removeClass("aH");
                            }
                           // functionN(url+"&page=" + (number1), id, type);
                            eval(functionN+"('"+url+"&page=" + (number1)+"','"+id+"','"+type+"');");
                        });

                    }
                    if(number>=page){
                        $("#" + id + "1>a:eq(1)").removeClass("prev");
                        $("#" + id + "1>a:eq(1)").addClass("aH");
                        $("#" + id + "1 .show li a").html(page);
                    }else {
                        $("#" + id + "1>a:eq(1)").addClass("prev");
                        $("#" + id + "1>a:eq(1)").removeClass("aH");
                    }
                   // eval( functionN(url+"&page=" + (number), id, type);
                    eval(functionN+"('"+url+"&page=" + (number)+"','"+id+"','"+type+"');");
                });
                $(".aH").unbind("click");
            }
        }
    });
}
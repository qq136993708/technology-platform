var FancyForm=function(){
	return{
		inputs:".FancyForm input, .FancyForm textarea",
		setup:function(){
			var a=this;
			this.inputs=$(this.inputs);
			a.inputs.each(function(){
				var c=$(this);
				a.checkVal(c)
			});
			a.inputs.live("keyup blur",function(){
				var c=$(this);
				a.checkVal(c);
			});
		},checkVal:function(a){
			a.val().length>0?a.parent("li").addClass("val"):a.parent("li").removeClass("val")
		}
	}
}();




$(document).ready(function() {
	FancyForm.setup();
});


var searchAjax=function(){};
var G_tocard_maxTips=30;

$(function(){(
	function(){

		var a=$(".plus-tag");
		var tj=$(".tj .list-one");
		var zb=$(".zb .list-two");

		$("a em",a).live("click",function(){
			var c=$(this).parents("a"),b=c.attr("title"),d=c.attr("value");
			delTips(b,d)
		});

        hasTips=function(b,v){
            var d=$("a",a),c=false;
            d.each(function(){
                if($(this).attr("title")==b && $(this).attr("type")==v){
                    $(this).remove();
                    $('.default-tag a').each(function(){
                        var $this = $(this);
                        console.log($this.attr('title'))
                        if($this.attr('title') == b){
                            $this.removeClass('selected');
                            return false;
                        }
                    })
                    c=true;
                    return false
                }
            });

            return c
        };
        isRepeat=function(d){
            var aAll=$("a",a),c=false;
            aAll.each(function(){
                if($(this).attr("value")==d){
                    c=true;
                    return false
                }
            });
            return c
        }
		isMaxTips=function(){
			return
			$("a",a).length>=G_tocard_maxTips
		};
        $(".layui-nav input").on("click",function () {
            if($(this).attr("checked")){
				var v=$(this).next().attr("type");
				var c=$(this).next().attr("title");
				var b=$(this).next().attr("value");
                if($("#tj a").text().indexOf(c)==-1){
					if($(this).attr("class")=="ckAll"){
                        $(this).parent().parent().find("input").attr("checked",true)
					}
                    tj.append($("<li class='layui-nav-item'><a value="+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><span class='allSpan'>"+v+"</span><em></em></a></li>"));
				}else {
                	console.log(v)
                    if($(this).attr("class")=="ckAll"){
                        $(this).parent().parent().find("input").attr("checked",true)
                    }
                	var vAll='';
                    $(".layui-nav input").each(function () {
                        if($(this).attr	("checked")=="checked"){
                            if($(".layui-nav input[type='checkbox']:checked").length==1 || $(this).attr("class")=="ckAll"){
                                vAll=$(this).next().attr("type")
								console.log(vAll)
                            }else {
                                vAll+=$(this).next().attr("type")+','

                            }

                        } /*else  if($(this).attr("class")=="ckAll"){
                        vAll=""
                        console.log(vAll)
                    }*/
                    })
                    for(var i=0;i<$("#tj a").length;i++){
                        if($("#tj a").eq(i).attr("value")==b){
                            $("#tj a").eq(i).find(".allSpan").html(vAll.substring(0,vAll.length-1))
                            $("#tj a").eq(i).attr("type",vAll.substring(0,vAll.length-1))
                        }
                    }
				}
            }else {
                var b=$(this).next().attr("value");
                var vAll='';
                $(".layui-nav input").each(function () {
                	console.log($(".layui-nav input[type='checkbox']:checked").length==1)
                    if($(this).attr	("checked")=="checked"){
                        if($(".layui-nav input[type='checkbox']:checked").length==1 && $(this).attr("class")=="ckAll"){
                            vAll=$(this).next().attr("type")
                        }else {
                        	if($(this).attr("class")=="ckAll"){
                                vAll=''
							}else {
                                vAll+=$(this).next().attr("type")+','
							}
                        }

                    } /*else  if($(this).attr("class")=="ckAll"){
                        vAll=""
                        console.log(vAll)
                    }*/
                })
                for(var i=0;i<$("#tj a").length;i++){
                    if($("#tj a").eq(i).attr("value")==b){
                    	if(vAll.length<=0){
                            $(this).parent().parent().prev().removeClass("selected")
                            $("#tj a").eq(i).remove()
						}else {
                            $("#tj a").eq(i).find(".allSpan").html(vAll.substring(0,vAll.length-1))
                            $("#tj a").eq(i).attr("type",vAll.substring(0,vAll.length-1))
						}
                    }
                }
			}
        })
		setTips=function(c,d,v){
			if(hasTips(c,v)){
                console.log(c)
				console.log(v)

				return false
			}if(isMaxTips()){
				alert("最多添加"+G_tocard_maxTips+"个标签！");
				return false
			}if (isRepeat(d)){
                for(var i=0;i<$("#tj a").length;i++){
                    if($("#tj a").eq(i).attr("value")==d){
                        if (v.indexOf(",")>-1){
                            $("#tj a").eq(i).find(".allSpan").html("所有");

                        }else {
                            $("#tj a").eq(i).find(".allSpan").html(v)
                        }
                        $("#tj a").eq(i).attr("type",v)
                    }
                }
                return false
            }

			var b=d?'value="'+d+'"':"";
			// a.append($("<a "+b+' title="'+c+'" href="javascript:void(0);" ><span>'+c+"</span><em></em></a>"));
			if(d.indexOf("G0")>-1||d.indexOf("CALM")>-1){
                if(v.length>0){
                	if (v.indexOf(",")>-1){
                        tj.append($("<li class='layui-nav-item'><a "+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><span class='allSpan'>所有</span><em></em></a></li>"));
                    }else {
                        tj.append($("<li class='layui-nav-item'><a "+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><span class='allSpan'>"+v+"</span><em></em></a></li>"));
                    }
                     }else {
                    tj.append($("<li class='layui-nav-item'><a "+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><em></em></a></li>"));
                }
                $("#xData option[value="+d+"]").remove();
                $("#xData").append("<option value='"+d+"'>"+c+"</option>");
            }else {
                if(v.length>0){
                    zb.append($("<li class='layui-nav-item'><a "+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><span>"+v+"</span><em></em></a></li>"));
                }else {
                    zb.append($("<li class='layui-nav-item'><a "+b+' title="'+c+'" type="'+v+'" href="javascript:void(0);" ><span>'+c+"</span><em></em></a></li>"));
                }
            }
			searchAjax(c,d,true);
			return true
		};

		delTips=function(b,c){
			if(hasTips(b)){
				return false
			}
			$("a",a).each(function(){
				var d=$(this);
			    var index=d.index()
				if(d.attr("title")==b){
					d.remove();
                    $("#xData option[value="+d.attr("value")+"]").remove();
                    // $("#xData option").eq(index-1).remove();
					return false
				}
				if($("#xData").val()){

                }
			});
			searchAjax(b,c,false);
			return true
		};

		getTips=function(){
			var b=[];
			$("a",a).each(function(){
				b.push($(this).attr("title"))
			});
			return b
		};

		getTipsId=function(){
			var b=[];
			$("a",a).each(function(){
				b.push($(this).attr("value"))
			});
			return b
		};

		getTipsIdAndTag=function(){
			var b=[];
			$("a",a).each(function(){
				b.push($(this).attr("value")+"##"+$(this).attr("title"))
			});
			return b
		}
	}

)()});







// 更新选中标签标签
$(function(){
	setSelectTips();
	$('.plus-tag').append($('.plus-tag a'));
});
var searchAjax = function(name, id, isAdd){
	setSelectTips();
};
// 搜索
(function(){
	var $b = $('.plus-tag-add button'),$i = $('.plus-tag-add input');
	$i.keyup(function(e){
		if(e.keyCode == 13){
			$b.click();
		}
	});
	$b.click(function(){
		var name = $i.val().toLowerCase();
		if(name != '') setTips(name,-1,'');
		$i.val('');
		$i.select();
	});
})();
// 推荐标签
(function(){
	var str = ['展开推荐标签', '收起推荐标签']
	$('.plus-tag-add a').click(function(){
		var $this = $(this),
				$con = $('#mycard-plus');

		if($this.hasClass('plus')){
			$this.removeClass('plus').text(str[0]);
			$con.hide();
		}else{
			$this.addClass('plus').text(str[1]);
			$con.show();
		}
	});
	$('.default-tag a').live('click', function(){
		var $this = $(this),
				name = $this.attr('title'),
				id = $this.attr('value');
		var strtype = $(this).attr('type');
		if(typeof (strtype)!="undefined"&&strtype!=""){
            setTips(name, id,strtype);
        }else {
            setTips(name, id,'');
        }
        if($this.prev().is("input")){

			if($this.prev().hasClass("ckAll")){
                $this.parent().parent().find("input").attr("checked",true)
			}else {
                $this.parent().parent().find("input").attr("checked",false)
                $this.prev().attr("checked",true)
			}
		}
	});
	// 更新高亮显示
	setSelectTips = function(){
		var arrName = getTips();
		if(arrName.length){
			$('#myTags').show();
		}else{
			$('#myTags').hide();
		}
		$('.default-tag a').removeClass('selected');
		$.each(arrName, function(index,name){
			$('.default-tag a').each(function(){
				var $this = $(this);
				if($this.attr('title') == name){
					$this.addClass('selected');
					return false;
				}
			})
		});
	}

})();
// 更换链接
(function(){
	var $b = $('#change-tips'),
		$d = $('.default-tag div'),
		len = $d.length,
		t = 'nowtips';
	$b.click(function(){
		var i = $d.index($('.default-tag .nowtips'));
		i = (i+1 < len) ? (i+1) : 0;
		$d.hide().removeClass(t);
		$d.eq(i).show().addClass(t);
	});
	$d.eq(0).addClass(t);
})();
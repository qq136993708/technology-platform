//兼容ie6的fixed代码 
//jQuery(function($j){
//	$j('#pop').positionFixed()
//})
//(function($j){
//    $j.positionFixed = function(el){
//        $j(el).each(function(){
//            new fixed(this)
//        })
//        return el;                  
//    }
//    $j.fn.positionFixed = function(){
//        return $j.positionFixed(this)
//    }
//    var fixed = $j.positionFixed.impl = function(el){
//        var o=this;
//        o.sts={
//            target : $j(el).css('position','fixed'),
//            container : $j(window)
//        }
//        o.sts.currentCss = {
//            top : o.sts.target.css('top'),              
//            right : o.sts.target.css('right'),              
//            bottom : o.sts.target.css('bottom'),                
//            left : o.sts.target.css('left')             
//        }
//        if(!o.ie6)return;
//        o.bindEvent();
//    }
//    $j.extend(fixed.prototype,{
//        ie6 : $.browser.msie && $.browser.version < 7.0,
//        bindEvent : function(){
//            var o=this;
//            o.sts.target.css('position','absolute')
//            o.overRelative().initBasePos();
//            o.sts.target.css(o.sts.basePos)
//            o.sts.container.scroll(o.scrollEvent()).resize(o.resizeEvent());
//            o.setPos();
//        },
//        overRelative : function(){
//            var o=this;
//            var relative = o.sts.target.parents().filter(function(){
//                if($j(this).css('position')=='relative')return this;
//            })
//            if(relative.size()>0)relative.after(o.sts.target)
//            return o;
//        },
//        initBasePos : function(){
//            var o=this;
//            o.sts.basePos = {
//                top: o.sts.target.offset().top - (o.sts.currentCss.top=='auto'?o.sts.container.scrollTop():0),
//                left: o.sts.target.offset().left - (o.sts.currentCss.left=='auto'?o.sts.container.scrollLeft():0)
//            }
//            return o;
//        },
//        setPos : function(){
//            var o=this;
//            o.sts.target.css({
//                top: o.sts.container.scrollTop() + o.sts.basePos.top,
//                left: o.sts.container.scrollLeft() + o.sts.basePos.left
//            })
//        },
//        scrollEvent : function(){
//            var o=this;
//            return function(){
//                o.setPos();
//            }
//        },
//        resizeEvent : function(){
//            var o=this;
//            return function(){
//                setTimeout(function(){
//                    o.sts.target.css(o.sts.currentCss)      
//                    o.initBasePos();
//                    o.setPos()
//                },1)    
//            }           
//        }
//    })
//})(jQuery)

function Pop(title,url,intro,tab){
	this.title=title;
	this.url=url;
	this.intro=intro;
	this.tab=tab;
	this.apearTime=1000;
	this.delay=8000;
	//添加信息
	this.showNotice();
	//显示
	this.showDiv();
	//关闭
	this.closeDiv();
}

function openNotice(url){
	layer.open({
        title:'查看公告'
        ,skin: 'layui-layer-lan'
        ,shadeClose: true
        ,type: 2
        ,fixed: false
        //若使用小窗口形式，则修改 maxmin 值为 true，则注释掉area:[100%,100%]属性,同时设置area: ['900px', '450px']
        ,maxmin: false
        //若直接弹出页面 ，则修改 area;[100%,100%]，同时设置 maxmin 为false
        ,area: ['100%', '100%']
        ,content: url
    });
	$('#pop').hide();
    setTimeout("getUserNoticeCount()",1500);
}

Pop.prototype = {
	showNotice:function(){
	    $("#popTitle a").attr("href","javascript:openNotice('"+this.url+"');").html(this.title);
	    $("#popIntro").html(this.intro);
	    $("#popMore a").attr("href","javascript:openNotice('"+this.url+"');");
	},
	showDiv:function(time){
//		if (!($.browser.msie && ($.browser.version == "6.0") && !$.support.style)) {
		if ($.support.style) {
			$('#pop').slideDown(this.apearTime).delay(this.delay).fadeOut(400);
		} else {//调用jquery.fixed.js,解决ie6不能用fixed
			$('#pop').show();
			jQuery(function($j){
			    $j('#pop').positionFixed();
			})
	    }
	},
	closeDiv:function(){
		$("#popClose").click(function(){
  		  	$('#pop').hide();
  		});
	}
}

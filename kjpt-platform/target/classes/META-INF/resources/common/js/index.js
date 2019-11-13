/**
 * Created by Administrator on 2018/5/9.
 */
function main(url,content,index){
    var htmlDivTab=$('<iframe  class="content-tab active" id=content-tab-'+index+' src='+url+'></iframe>');
    content.append(htmlDivTab);
    return false;
}
var index={
    sidebarUrl:"",
    sidebarTxt:"",
    ptcA:"",
    thisA:"",
    thisPrev:"",
    sidebarA:"",
    tabS:"",
    pageOnlyId:parent.$("#content iframe.active").attr("id"),
    modalId:"",
    pMainHeader:"",
    pContentHeader:"",
    token:parent.$("#content-tab-0").attr("token"),
    init:function(){
        //二级导航
        pMainHeader=parent.$(".main-header").height();
        pContentHeader=parent.$(".content-header").height();
        var content=$("#content");
        /*var firstUrl=$(".page-tabs-content a").attr("data-id");
        var htmlDivTab=$('<iframe  class="content-tab active" id=content-tab-0 src='+firstUrl+'></iframe>');
        content.append(htmlDivTab);*/

        /*$(".menu-li ul").hide(); 注释默认三级菜单显示，放开三级菜单默认隐藏*/
        /*$(".menu-li ul").hide();*/
        /*隐藏没有三给的二级目录*/
        var menuNull=$(".menu-ul");
        for (var i=0;i<menuNull.length;i++){
            if(menuNull.eq(i).children("li").length==0){
                menuNull.eq(i).hide();
            }
        }
        $('.menu li a').on('click',function(){
            var parents = $(this).parent().parent();//获取当前页签的父级的父级
            var parent=$(this).parent("li");
            var labeul =$(this).parent("li").find(">ul");
            $(".menu li").removeClass("active")
            parent.addClass("active")
            if ($(this).parent().hasClass('open') == false) {
                //展开未展开
                if(labeul.css("display")=="block"){
                    labeul.slideUp(300);
                }else if(labeul.css("display")=="none"){
                    labeul.slideDown(300);
                }
                /*else {
                 parents.find('ul').slideUp(300);
                 parents.find("li").removeClass("open")
                 parents.find('li a').removeClass("active").find(".arrow").removeClass("open");
                 parent.addClass("open")
                 parent.find(labeul).slideDown(300);
                 $(this).addClass("active").find(".arrow").addClass("open");
                 }*/
                if($(this).attr("data-id")!= undefined){
                    if($(".page-tabs-content a").length<=1){
                        $(".page-tabs-content a").removeClass("active");
                        sidebarUrl=$(this).attr("data-id");
                        sidebarTxt=$(this).text();
                        tabs='<li><a href="javascript:;" class="J_menuTab active" data-id='+sidebarUrl+'>'+sidebarTxt+'</a>'+'<i class="ptc-i"></i></li>';
                        $(".page-tabs-content a").removeClass("active");
                        $(".page-tabs-content ul li").last().after(tabs);
                        main(sidebarUrl,content,$(".page-tabs-content a").length-1);
                        $(".content-tab:not(:last)").removeClass("active").hide();
                        $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                    }else if($(".page-tabs-content a").length>=2){
                        sidebarTxt=$(this).text();
                        sidebarUrl=this.href;
                        var str=$(".page-tabs-content a").text();
                        if(str.indexOf(sidebarTxt)!=-1){
                            $(".page-tabs-content a").removeClass("active");
                            for(var i=0;i<$(".page-tabs-content a").length;i++){
                                if($(".page-tabs-content a").eq(i).text()==sidebarTxt){
                                    $(".page-tabs-content a").eq(i).addClass("active");
                                    /* sidebarUrl=$(".page-tabs-content a").eq(i).attr("data-id");
                                     main(sidebarUrl,content);
                                     $(".content-tab:not(:last)").hide();*/
                                    $(".content-tab").removeClass("active").hide();
                                    $(".content-tab").eq(i).remove()
                                    main(sidebarUrl,content,i);
                                    $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                                }
                            }
                        }else {
                            $(".page-tabs-content a").removeClass("active");
                            sidebarUrl=$(this).attr("data-id");
                            tabs='<li><a href="javascript:;" class="J_menuTab active" data-id='+sidebarUrl+'>'+sidebarTxt+'</a>'+'<i class="ptc-i"></i></li>';
                            $(".page-tabs-content ul li").last().after(tabs);
                            main(sidebarUrl,content,$(".page-tabs-content a").length-1);
                            $(".content-tab:not(:last)").removeClass("active").hide();
                            $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                        }
                    }

                    $(".menu ul li").removeClass("active");
                    $(".page-tabs-content ul li").on("click",function(){
                        $(".page-tabs-content a").removeClass("active");
                        var indexNum=$(this).index();
                        $(".page-tabs-content a").eq(indexNum).addClass("active");
                        $(".content-tab").removeClass("active").hide();
                        $(".content-tab").eq(indexNum).addClass("active").show();
                        $(".menu-ul li").removeClass("active");
                        $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                    });
                    $(".ptc-i").unbind('click').click(function(){
                        $(".menu ul li").removeClass("active");
                        $(".page-tabs-content a").removeClass("active");
                        thisA=$(this).prev();
                        thisPrev=thisA.parent().prev();
                        var thisNumber=$(this).parent().index();
                        if(thisA.length==1){
                            var url=thisA.attr("data-id");
                            thisA.parent().remove();
                            thisA.remove();
                            this.remove();
                            $(".menu li").removeClass("open");
                            thisPrev.children("a").addClass("active");
                            var indexNumber=thisPrev.parent().index();
                            if(indexNumber==-1){
                                indexNumber=0;
                            }
                            $(".content-tab").eq(thisNumber).removeClass("active").remove();
                            $(".content-tab").eq(indexNumber).addClass("active").show();
                        }
                    });
                }
            }else{
                if($(this).parent().find("ul").length>0){
                    $(this).parent("li").removeClass("open").find(labeul).slideUp(300);
                    $(this).removeClass("active").find(".arrow").removeClass("open")
                }else{
                    $(this).addClass("active")
                }
            }
        });
        //页签
        $(".menu-ul li").on("click","a",function(){
            if($(".page-tabs-content a").length<=1){
                $(".page-tabs-content a").removeClass("active");
                sidebarUrl=this.href;
                sidebarTxt=this.text;
                tabs='<li><a href="javascript:;" class="J_menuTab active" data-id='+sidebarUrl+'>'+sidebarTxt+'</a>'+'<i class="ptc-i"></i></li>';
                $(".page-tabs-content a").removeClass("active");
                $(".page-tabs-content ul li").last().after(tabs);
                main(sidebarUrl,content,$(".page-tabs-content a").length-1);
                $(".content-tab:not(:last)").hide();
                $(".content-tab:not(:last)").removeClass("active");
                $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
            }else if($(".page-tabs-content a").length>=2){
                sidebarTxt=this.text;
                sidebarUrl=this.href;
                var str=$(".page-tabs-content a").text();
                if(str.indexOf(sidebarTxt)!=-1){
                    $(".page-tabs-content a").removeClass("active");
                    for(var i=0;i<$(".page-tabs-content a").length;i++){
                        if($(".page-tabs-content a").eq(i).text()==sidebarTxt){
                            $(".page-tabs-content a").eq(i).addClass("active");
                            $(".content-tab").removeClass("active").hide();
                            $(".content-tab").eq(i).remove()
                            main(sidebarUrl,content,i);
                            $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                        }
                    }
                }else {
                    $(".page-tabs-content a").removeClass("active");
                    sidebarUrl=this.href;
                    tabs='<li><a href="javascript:;" class="J_menuTab active" data-id='+sidebarUrl+'>'+sidebarTxt+'</a>'+'<i class="ptc-i"></i></li>';
                    $(".page-tabs-content ul li").last().after(tabs);
                    main(sidebarUrl,content,$(".page-tabs-content a").length-1);
                    $(".content-tab:not(:last)").hide();
                    $(".content-tab:not(:last)").removeClass("active")
                    $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
                }
            }
            $(".menu ul li").removeClass("active");
            $(this).parent().addClass("active");
            $(".page-tabs-content ul li").on("click",function(){
                $(".page-tabs-content a").removeClass("active");
                var indexNum=$(this).index();
                $(".page-tabs-content a").eq(indexNum).addClass("active");
                $(".content-tab").removeClass("active").hide();
                $(".content-tab").eq(indexNum).addClass("active").show();
                $(".menu-ul li").removeClass("active");
                $("iframe").css("height",$(document).height()-(pMainHeader+pContentHeader));
            });
            $(".ptc-i").unbind('click').click(function(){
                $(".menu ul li").removeClass("active");
                $(".page-tabs-content a").removeClass("active");
                thisA=$(this).prev();
                thisPrev=thisA.parent().prev().children("a");
                var thisNumber=$(this).parent().index();
                if(thisA.length==1){
                    var url=thisPrev.attr("data-id");
                    thisA.parent().remove();
                    thisA.remove();
                    this.remove();
                    thisPrev.addClass("active");
                    var indexNumber=thisPrev.parent().index();
                    if(indexNumber==-1){
                        indexNumber=0;
                    }
                    $(".content-tab").eq(thisNumber).removeClass("active").remove();
                    $(".content-tab").eq(indexNumber).addClass("active").show();

                }
            });
            $(".J_tabCloseAll").click(function () {
                var J_tabCloseAll=$(".page-tabs-content ul li").find("i").length
                if(J_tabCloseAll>0){
                    $(".menu ul li").removeClass("active");
                    $(".page-tabs-content ul li:first a").addClass("active")
                    $(".page-tabs-content ul li:not(:first)").remove();
                    $("#content iframe:first").show();
                    $("#content iframe:not(:first)").remove()
                }
            });
            $(".J_tabCloseOther").click(function () {
                var J_tabCloseAll=$(".page-tabs-content ul li").find("i").length;
                if(J_tabCloseAll>1){
                    var indexJTab=$(".page-tabs-content ul li a.active").parent().index();
                    $(".page-tabs-content ul li:not(:eq("+indexJTab+"),:eq(0))").remove();
                    $("#content iframe:not(:eq("+indexJTab+"),:eq(0))").remove()
                }
            });
            var ptcSum=0;
            var ptcLastWidth=0;
            $(".page-tabs-content ul li").each(function(index){
                ptcSum+=+parseInt($(this).width());
                console.log($(this).width())
            });
            var navWidth=$(".page-tabs").height();
            if(navWidth==60){
                console.log("111")
                $('.page-tabs').css({"margin-left":"-120px;"});
            }
            return false;
        });
    },
    addFrom:function (sidebarTxt,sidebarUrl){
        var content=parent.$("#content");
        //var sidebarUrl=basePath+"demo/edit.html?t=" + new Date().getTime();
        var tabs='<li><a href="javascript:;" class="J_menuTab active" data-id='+sidebarUrl+'>'+sidebarTxt+'</a>'+'<i class="ptc-i"></i></li>';
        parent.$(".J_menuTab ").removeClass("active")
        parent.$(".page-tabs-content ul li").last().after(tabs);
        main(sidebarUrl,content,parent.$(".page-tabs-content a").length-1);
        parent.$(".content-tab:not(:last)").hide();
        parent.$(".content-tab:not(:last)").removeClass("active");
        parent.$("iframe").css("height",parent.parent.$("body").height()-(pMainHeader+pContentHeader));
        parent.$(".page-tabs-content ul li").on("click",function(){
            parent.$(".page-tabs-content a").removeClass("active");
            var indexNum=$(this).index();
            parent.$(".page-tabs-content a").eq(indexNum).addClass("active");
            parent.$(".content-tab").removeClass("active").hide();
            parent.$(".content-tab").eq(indexNum).addClass("active").show();
            parent.$(".menu-ul li").removeClass("active");
            $("iframe").css("height",parent.parent.$("body").height()-(pMainHeader+pContentHeader));
        });
        parent.$(".ptc-i").unbind('click').click(function(){
            parent.$(".menu ul li").removeClass("active");
            parent.$(".page-tabs-content a").removeClass("active");
            thisA=$(this).prev();
            thisPrev=thisA.parent().prev().children("a");
            var thisNumber=$(this).parent().index();
            if(thisA.length==1){
                var url=thisPrev.attr("data-id");
                thisA.parent().remove();
                thisA.remove();
                this.remove();
                thisPrev.addClass("active");
                var indexNumber=thisPrev.parent().index();
                if(indexNumber==-1){
                    indexNumber=0;
                }
                parent.$(".content-tab").eq(thisNumber).removeClass("active").remove();
                parent.$(".content-tab").eq(indexNumber).addClass("active").show();

            }
        });

    }
}
$(function(){
    index.init();
    $(".J_tabClose").click(function () {
        if ($(".dropdown-menu-right").css("display")=="none"){
            $(".dropdown-menu-right").show()
        } else {
            $(".dropdown-menu-right").hide()
        }
    });
});
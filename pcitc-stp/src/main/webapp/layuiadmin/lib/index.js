/**

 @Name：layuiAdmin iframe版主入口
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */
 
layui.extend({
  setter: 'config' //配置模块
  ,admin: 'lib/admin' //核心模块
  ,view: 'lib/view' //视图渲染模块
}).define(['setter', 'admin'], function(exports){

  var selfRownum=parent.$(".selfRownum").val();
  var setter = layui.setter
  ,element = layui.element
  ,admin = layui.admin
  ,tabsPage = admin.tabsPage
  ,view = layui.view

  //打开标签页
  ,openTabsPage = function(url, text,id,code,functionbuttons){
    //遍历页签选项卡

    var matchTo
    ,tabs = $('#LAY_app_tabsheader>li')
    ,path = url.replace(/(^http(s*):)|(\?[\s\S]*$)/g, '');

    tabs.each(function(index){
      var li = $(this)
      ,layid = li.attr('lay-id');
      
      if(layid === url){
        matchTo = true;
        tabsPage.index = index;
      }
    });
    
    text = text || '新标签页';
    var protocolStr = document.location.protocol;
    var domain = protocolStr+"//"+location.host;
    if(parent.$("#LAY_app .layui-layout-admin").hasClass("layui-leader")){
       $("#LAY_app_body .layadmin-tabsbody-item").remove();
        $(APP_BODY).append([
            '<div class="layadmin-tabsbody-item layui-show">'
            ,'<iframe src="'+ domain+url +'" id="'+code+'"  data-code="'+id+'" data-functionbuttons="'+functionbuttons+'" frameborder="0" class="layadmin-iframe"></iframe>'
            ,'</div>'
        ].join(''));
        var param={
            "id":id,
            "code":code,
            "functionbuttons":  functionbuttons,
            "name":text,
            "selfRownum":selfRownum
        }
        param = JSON.stringify(param)
        window.localStorage.setItem("param",param);
    }else {
        if(setter.pageTabs){
            //如果未在选项卡中匹配到，则追加选项卡

            if(!matchTo){
                var lodingMsg = layer.msg('页面加载中....');
                $(APP_BODY).append([
                    '<div class="layadmin-tabsbody-item layui-show">'
                    ,'<iframe src="'+ domain+url +'" id="'+code+'"  data-code="'+id+'" data-functionbuttons="'+functionbuttons+'" frameborder="0" class="layadmin-iframe"></iframe>'
                    ,'</div>'
                ].join(''));
                tabsPage.index = tabs.length;
                element.tabAdd(FILTER_TAB_TBAS, {
                    title: '<span>'+ text +'</span>'
                    ,id: url
                    ,attr: path
                });

                var id=parent.$(".layui-body .layui-show .layadmin-iframe").eq(1).attr("id");
                var param={
                    "id":parent.$(".layui-body .layui-show .layadmin-iframe").eq(1).attr("data-code"),
                    "code":id,
                    "functionbuttons":  functionbuttons,
                    "name":text,
                    "selfRownum":selfRownum
                }
                param = JSON.stringify(param)
                console.log(parent.$(".layui-body .layui-show .layadmin-iframe"))
                window.localStorage.setItem("param",param);
                parent.$(".layui-body .layui-show .layadmin-iframe").on("load",function(){
                    layer.close(lodingMsg);
                    //加载完成，需要执行的代码
                });
            }else {
                $(APP_BODY+" div").eq(tabsPage.index+1).addClass("layui-show").html([
                    '<iframe src="'+domain+ url +'" id="'+code+'"  data-code="'+id+'" data-functionbuttons="'+functionbuttons+'" frameborder="0" class="layadmin-iframe"></iframe>'
                ].join(''));
                var id=parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("id");
                var param={
                    "id":parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-code"),
                    "code":id,
                    "functionbuttons":  parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-functionbuttons"),
                    "name":text,
                    "selfRownum":selfRownum
                }
                param = JSON.stringify(param)
                console.log(param)
                window.localStorage.setItem("param",param);

            }

        } else {
            var iframe = admin.tabsBody(admin.tabsPage.index).find('.layadmin-iframe');
            iframe[0].contentWindow.location.href = url;
        }
    }
    /*parent.$(".index-fixed li").removeClass(".layui-this")*/
    /* console.log($(".index-fixed li"))*/
    //定位当前tabs
    element.tabChange(FILTER_TAB_TBAS, url);
    admin.tabsBodyChange(tabsPage.index, {
      url: url
      ,text: text
    });
  }

  ,APP_BODY = '#LAY_app_body', FILTER_TAB_TBAS = 'layadmin-layout-tabs'
  ,$ = layui.$, $win = $(window);

  //初始
  if(admin.screen() < 2) admin.sideFlexible();

  //将模块根路径设置为 controller 目录
  layui.config({
    base: setter.base + 'modules/'
  });
  $(".layui-side .layadmin-flexible").click(function () {
    if($("#LAY_app").hasClass("layadmin-side-shrink")){
        $("#LAY_app").removeClass("layadmin-side-shrink")
        $(".layadmin-flexible div").removeClass('flexd')
    }else {
        $("#LAY_app").addClass("layadmin-side-shrink")
        $(".layadmin-flexible div").addClass('flexd')
    }
  });
  $(document).on('click', '#LAY_app_tabsheader li', function() {
      var param={
          "id":parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-code"),
          "code":parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("id"),
          "functionbuttons":  parent.$(".layui-body .layui-show .layadmin-iframe").eq(0).attr("data-functionbuttons"),
          "name":$("#LAY_app_tabsheader li.layui-this span").text(),
          "selfRownum":selfRownum
      }
      param = JSON.stringify(param)
      window.localStorage.setItem("param",param);
  });
  $(".index-fixed li").click(function () {
      $("#mainIframe").attr('src', $("#mainIframe").attr('src'));
      $(".layui-nav-item").removeClass("layui-this");
      $(".layui-nav-tree").addClass("layui-hide");
      $(".layui-nav-tree").eq(0).removeClass("layui-hide");
      $(".layadmin-tabsbody-item").removeClass("layui-show");
      $(".layadmin-tabsbody-item").eq(0).addClass("layui-show");
      $(".layui-tab-title li").removeClass("layui-this");
  });
  $(document).on('click', '.layui-tab-close', function() {
      if($("#LAY_app_body .layui-show").index()==1 && $("#LAY_app_tabsheader .layui-this").index()==-1){
          $("#LAY_app_body .layadmin-tabsbody-item").eq(1).removeClass("layui-show");
          $("#LAY_app_body .layadmin-tabsbody-item").eq(0).addClass("layui-show");
      }else if($("#LAY_app_tabsheader li").length==0){
          $(".layadmin-tabsbody-item").addClass("layui-show");
          $(".index-fixed li").addClass("layui-this");
      }
  });
  
  //扩展 lib 目录下的其它模块
  layui.each(setter.extend, function(index, item){
    var mods = {};
    mods[item] = '{/}' + setter.base + 'lib/extend/' + item;
    layui.extend(mods);
  });
    /*弹出*/
    $(".QRCode").on("click", function(e) {
        e.stopPropagation();
        $(".QRCode-content").toggleClass("layui-hide");
        if ($(".chat-content").hasClass('layui-hide') == false) {
            $(".chat-content").addClass('layui-hide');
        }
        if ($(".deal-content").hasClass('layui-hide') == false) {
            $(".deal-content").addClass('layui-hide');
        }
        if ($(".information").hasClass('layui-hide') == false) {
            $(".information").addClass('layui-hide');
        }
    });
    $(".layui-nav-item-a").on("click", function(e) {
        e.stopPropagation();
        $(".information").toggleClass("layui-hide");
        if ($(".QRCode-content").hasClass('layui-hide') == false) {
            $(".QRCode-content").addClass('layui-hide');
        }
        if ($(".chat-content").hasClass('layui-hide') == false) {
            $(".chat-content").addClass('layui-hide');
        }
        if ($(".deal-content").hasClass('layui-hide') == false) {
            $(".deal-content").addClass('layui-hide');
        }
    });
    /*$(".chat").on("click", function(e) {
        e.stopPropagation();
        $(".chat-content").toggleClass("layui-hide");
        if ($(".QRCode-content").hasClass('layui-hide') == false) {
            $(".QRCode-content").addClass('layui-hide');
        }
        if ($(".deal-content").hasClass('layui-hide') == false) {
            $(".deal-content").addClass('layui-hide');
        }
        if ($(".information").hasClass('layui-hide') == false) {
            $(".information").addClass('layui-hide');
        }
    });*/
    /*$(".deal").on("click", function(e) {
        e.stopPropagation();
        $(".deal-content").toggleClass("layui-hide");
        if ($(".QRCode-content").hasClass('layui-hide') == false) {
            $(".QRCode-content").addClass('layui-hide');
        }
        if ($(".chat-content").hasClass('layui-hide') == false) {
            $(".chat-content").addClass('layui-hide');
        }
        if ($(".information").hasClass('layui-hide') == false) {
            $(".information").addClass('layui-hide');
        }
    });*/
    $(".selectBox-span").on("click", function(e) {
        e.stopPropagation();
        $(".layui-nav-child-span").toggleClass("layui-hide");
        $(".layui-nav-child-span dd").click(function() {
            if ($(this).find("a").html() == "知识管理") {
                $(".stpSearchBox .selectBox").css("width", "100px")
            } else {
                $(".stpSearchBox .selectBox").css("width", "100px")
            }
            $(".selectBox-span small").text($(this).find("a").html());
        });
    });
    $(document).on('click', function(e) {
        if($("#LAY_app>div").hasClass("layui-leader-admin")){
            if ($(".QRCode-content").hasClass('layui-hide') == false) {
                $(".QRCode-content").addClass('layui-hide');
            }
            if ($(".chat-content").hasClass('layui-hide') == false) {
                $(".chat-content").addClass('layui-hide');
            }
            if ($(".deal-content").hasClass('layui-hide') == false) {
                $(".deal-content").addClass('layui-hide');
            }
            if ($(".information").hasClass('layui-hide') == false) {
                $(".information").addClass('layui-hide');
            }
        }else {
            if ($(".QRCode-content").hasClass('layui-hide') == false) {
                $(window.parent.document).find(".QRCode-content").addClass('layui-hide');
            }
            if ($(".chat-content").hasClass('layui-hide') == false) {
                $(window.parent.document).find(".chat-content").addClass('layui-hide');
            }
            if ($(".deal-content").hasClass('layui-hide') == false) {
                $(window.parent.document).find(".deal-content").addClass('layui-hide');
            }
            if ($(".information").hasClass('layui-hide') == false) {
                $(window.parent.document).find(".information").addClass('layui-hide');
            }
        }

    });

  view().autoRender();
  //加载公共模块
  layui.use('common');

  //对外输出
  exports('index', {
    openTabsPage: openTabsPage
  });
});

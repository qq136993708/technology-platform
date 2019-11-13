/**
 * Created by Administrator on 2018/5/11.
 */
$(function(){
    //滚动条
    var mainHeaderHeight=parent.$(".main-header").outerHeight();
    var menuHeaderHeight=parent.$(".menu-header").outerHeight();
    var contentHeader=parent.$(".content-header").outerHeight();
    var contentSearcXh=$(".content-searcXh").outerHeight();
    var contentBodyBtn=$(".content-body>.btn-group").outerHeight(true);
    var slimSHeight=$(document).height()-(menuHeaderHeight+mainHeaderHeight);
    var slimSTHeight=$(document).height()-(contentBodyBtn+contentSearcXh);
    var slimTreeHeight=$(document).height()-(contentBodyBtn+contentHeader+mainHeaderHeight);
    var slimSHeightHalf=parseInt(slimSHeight/$(".main-sidebar .menu:not(.hide)").length);
    var boxBodyHeight=parent.parent.$("body").height()-(menuHeaderHeight+mainHeaderHeight)
    /*左侧导航*/
    $(".sidebar .menu:not(.hide)").slimScroll({
        width:"230px",
        height: slimSHeightHalf,
        size: '7px',
        position: 'right',
        color: '#666',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    /*表格*/
    $(".content-table").slimScroll({
        width:"100%",
        height: slimSTHeight,
        size: '7px',
        position: 'right',
        color: '#222',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    /*没有查询的表格*/
    $(".box-tree .content-table").slimScroll({
        width:"100%",
        height: slimTreeHeight,
        size: '7px',
        position: 'right',
        color: '#222',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    /*弹出层*/
    $(".modal-content").slimScroll({
        width:"100%",
        height: "380px",
        size: '7px',
        position: 'right',
        color: '#222',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    /*charts*/
    $(".content-canvas").slimScroll({
        height: "480px",
        size: '7px',
        position: 'right',
        color: '#222',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    /*树形结构*/
    $("#tree").slimScroll({
        height: slimSHeight,
        size: '7px',
        position: 'right',
        color: '#333',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    parent.$("#"+index.pageOnlyId).contents().find("form").slimScroll({
        height: boxBodyHeight,
        size: '7px',
        position: 'right',
        color: '#333',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    $(".content-wrapper-main").slimScroll({
        height: boxBodyHeight,
        size: '7px',
        position: 'right',
        color: '#333',
        alwaysVisible: true,
        distance: '0',
        start: "top",
        railVisible: true,
        railColor: '#f1f1f1',
        railOpacity: 0,
        wheelStep: 7,
        allowPageScroll: false,
        disableFadeOut: true
    });
    $("iframe").css("height",parent.$(document).height()-(parent.$(".main-header").outerHeight()+parent.$(".content-header").outerHeight()));
    $(".sidebar-toggle").click(function(){
        $(".main-sidebar").hide();
        $(".content-wrapper").css({"marginLeft":"0","width":"100%"})
    });
});
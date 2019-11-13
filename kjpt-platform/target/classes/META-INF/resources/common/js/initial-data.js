/**
 * Created by Administrator on 2018/6/4.
 */
/*  获取初始化元素的值：
    1、打开页面通过id获取默认页面的元素值
    2、点击左侧导航通过id获取刚生成初始化页面中的元素值
    3、点击一级导航时
*/
/*  获取修改页面的元素值：
    点击左侧导航第一次生成页面时通过id获取最后一次的页面中元素的值
*/
$(function(){
    var pageOnlyId=$("#content>.active").attr("id");
    console.log($("#"+pageOnlyId+" section").children().length)
    console.log($("#"+pageOnlyId+" section").children().eq(0))

    console.log($("#"+pageOnlyId+" section").children().eq(1))
})
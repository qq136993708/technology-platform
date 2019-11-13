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
var initialData= {
    initialObj: [],
    changeObj: {},
    initialData: function (id) {
        //id 传值
        //1、通过id获取布局情况
        //2、通过判断length
        //push到json中
        initialData.initialObj.push({
            id: id
        });
        //获取当前tabContent的布局
        var elementLength = $("#" + id + " section").children();
        //根据布局获取页面
        if (elementLength.length == 2) {
            //第一种情况是有搜索条件，获取值
            if (elementLength.eq(0).attr("class") == "content-searcXh") {
                var elementInput = elementLength.eq(0).find("input");
                var elementSelect = elementLength.eq(0).find("select");
                if (elementInput.length > 0) {
                    for (var i = 0; i < elementInput.length; i++) {
                        var elementInputId = elementInput.eq(i).attr("id");
                        var elementInputVal = elementInput.eq(i).val();
                        var nodes = {};
                        var elementInputType = elementInput.eq(i).attr("type");
                        if (elementInputType == "radio") {
                            var elementRadio = $(elementInput).eq(i).attr("checked");
                            nodes = {
                                elementId: elementInputId,
                                elementVal: elementRadio,
                                elementInputType:elementInputType
                            }

                            initialData.initialObj.push(nodes);
                        } else if (elementInputType == "checkbox") {
                            var elementCheckbox = $(elementInput).eq(i).attr("checked");
                            nodes = {
                                elementId: elementInputId,
                                elementVal: elementCheckbox,
                                elementInputType:elementInputType
                            }

                            initialData.initialObj.push(nodes);
                        } else {
                            nodes = {
                                elementId: elementInputId,
                                elementVal: elementInputVal,
                                elementInputType:elementInputType
                            }

                            initialData.initialObj.push(nodes);
                        }

                    }
                }
                if (elementSelect.length > 0) {
                    for (var j = 0; j < elementSelect.length; j++) {
                        var elementSelectId = elementSelect.eq(j).attr("id");
                        var elementSelectVal = elementSelect.eq(j).find(':selected').text();
                        var elementIndex=elementSelect.eq(j).find(':selected').val();
                        elementInput.eq(i).change(function () {
                            elementSelectVal = $(this).find(':selected').text();
                            elementIndex=elementSelect.eq(j).find(':selected').val();
                        });
                        nodes = {
                            elementIndex: elementIndex,
                            elementVal: elementSelectVal,
                            elementInputType:"select",
                            elementId:elementSelectId
                        }
                        initialData.initialObj.push(nodes);
                    }
                }
                //保存到页面中方便调用
                var tabDataP = $("<p class='" + id + "'>" + JSON.stringify(initialData.initialObj) + "</p>")
                $("#tabData").append(tabDataP);
            }
            if (elementLength.eq(1).attr("class") == "content-body") {

            }
        }
    },
    tabLoad: function (id) {
        //id
        console.log(id)
        var tabDataP = $("#tabData").find("p");
        tabDataP.each(function () {
            if($(this).attr("class")==id){
                var tabDataStr=$(this).html();
                var tabDataJson = eval('(' + tabDataStr + ')');
                console.log(tabDataJson.length)
                for(var i=0;i<tabDataJson.length-1;i++){
                    var elementLength = $("#" + id + " section").children();
                    //根据布局获取页面
                    if (elementLength.length == 2) {
                        //第一种情况是有搜索条件，获取值
                        if (elementLength.eq(0).attr("class") == "content-searcXh") {
                            var elementInput = elementLength.eq(0).find("input");
                            var elementSelect = elementLength.eq(0).find("select");
                            if (elementInput.length > 0) {
                                var elementInputId = elementInput.eq(i).attr("id");
                                var elementInputVal = elementInput.eq(i).val();
                                var elementInputType = elementInput.eq(i).attr("type");
                                elementInputVal = elementInput.eq(i).val(tabDataJson[i+1].elementVal);
                                console.log(elementInput.eq(i).attr("id")+"   "+tabDataJson[i+1].elementId)

                            }
                        }
                    }
                }
            }
        })
    }
}
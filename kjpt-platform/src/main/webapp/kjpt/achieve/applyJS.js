layui.use(['jquery','table', 'form'], function() {
    var $ = layui.jquery,form = layui.form;
    var fileCols = [
        {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
        {title: '操作', templet: function(d) {
                var templet = '<div class="file-options">';
                templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
                templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
                templet += '</div>';
                return templet;
            }}
    ]
    setFileUpload({
        id: 'file-filter-options1', // 附件上传作用域ID值 必传
        dataID: '', // 用来查找当前单据下绑定的附件，没有则不查找
        cols: fileCols,
        callback: function (tableData, type) {
            console.log(tableData, type);
        }
    });
    /*动态生成元素*/
    function createElement(param) {
        httpModule({
            url: "/sysDictionary-api/getChildsListByCode/"+param.code,
            type: 'GET',
            success: function(relData) {
                if (relData.success === true) {
                    relData.data.map(function(item){
                        if(param.element=="option"){
                            if(param.value==item.numValue){
                                $("#"+param.id+" tbody tr:eq("+param.index+")").find("."+param.className).append("<option value='"+item.numValue+"' selected='selected'>"+item.name+"</option>")
                            }else {
                                $("#"+param.id+" tbody tr:eq("+param.index+")").find("."+param.className).append("<option value='"+item.numValue+"'>"+item.name+"</option>")
                            }
                        }
                    });
                    form.render()
                }
            }
        });
    }
    var noTr='<tr class="layui-none">' +
        '                  <td colspan="6"><div style="text-align: center">暂无数据,请添加！</div></td>' +
        '                </tr>';
    $("#addTr").click(function () {
        var off=$("#achieveTable").find(".layui-none");
        $(off).hide();
        var index=$("#achieveTable tbody tr").length
        var trHtml='<tr>' +
                '<td>'+index+'</td>' +
                '<td><input type="text"  placeholder="请填写姓名" autocomplete="off" class="layui-input"></td>' +
                '<td><select name="sex" class="sex">' +
                    '<option value=""></option>' +
                    '</select></td>' +
                '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                '<td><a style="color: #F44C4C;cursor: pointer;" class="deleTr">删除</a></td>' +
            '</tr>';
        createElement({code:'ROOT_KJPT_XB',id:'achieveTable',className:'sex',element:'option',index:index})
        $("#achieveTable tbody").append(trHtml)
        deleTr()
    })
    function backfill() {
        var obj=[{name:'1',sex:"1"},{name:'2',sex:"1"}]
        if(obj.length>0){
            var off=$("#achieveTable").find(".layui-none");
            $(off).hide();
            obj.map(function (item, index) {
                var trHtml='<tr>' +
                    '<td>'+(index+1)+'</td>' +
                    '<td><input type="text" value="'+item.name+'" placeholder="请填写姓名" autocomplete="off" class="layui-input"></td>' +
                    '<td><select name="sex" class="sex">' +
                    '<option value=""></option>' +
                    '</select></td>' +
                    '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                    '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                    '<td><a style="color: #F44C4C;cursor: pointer;" class="deleTr">删除</a></td>' +
                    '</tr>';
                createElement({code:'ROOT_KJPT_XB',id:'achieveTable',className:'sex',element:'option',index:index+1,value:item.sex})
                $("#achieveTable tbody").append(trHtml)
            })
        }
        deleTr()
    }
    backfill()
    function deleTr(){
        $(".deleTr").click(function () {
            $(this).parents("tr").remove()
            var tr=$("#achieveTable tbody tr")
            $(tr).map(function (index, item) {
                if($(this).attr("class")!="layui-none"){
                    $(this).find("td:nth-child(1)").html(index)
                }

            });
        })
    }
    function getTableData(){
        var tr=$("#achieveTable tbody tr")
        $(tr).map(function (index, item) {
            if(index!==0){
                /*获取数据*/
            }
        })
    }
    form.on('submit(formSave)', function(data) {
        getTableData()
    })
    form.on('submit(formDemo)', function(data) {
        getTableData()
    })
})
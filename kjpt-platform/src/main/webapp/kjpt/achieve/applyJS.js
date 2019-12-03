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
                '<td>3</td>' +
                '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                '<td><input type="text"  placeholder="请填写..." autocomplete="off" class="layui-input"></td>' +
                '<td><a style="color: #F44C4C;cursor: pointer;" class="deleTr">删除</a></td>' +
            '</tr>';
        $("#achieveTable tbody").append(trHtml)
        addTr()
    })
    function addTr() {

    }
    function deleTr() {

    }
    function getTableData(){

    }
    form.on('submit(formSave)', function(data) {
        getTableData()
    })
    form.on('submit(formDemo)', function(data) {
        getTableData()
    })
})
layui.use(['jquery','table', 'form','formSelects','laydate'], function() {
    var $ = layui.jquery,form = layui.form,formSelects=layui.formSelects,laydate=layui.laydate;
    // 获取地址栏传递过来的参数
    var variable = getQueryVariable(),id='';
    /*判断id，回显*/
    if(variable.id!=undefined){

        /*回显tr*/
        backfill('姓名#1#单位#职务$姓名#1#单位#职务','achieveTable')
    }else {
        httpModule({
            url: "/achieve-api/newInit",
            type: 'GET',
            async:false,
            success: function(relData) {
                if(relData.code==0){
                    id=relData.data.id
                }
                console.log(relData)
            }
        });

    }
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
    laydate.render({
        elem: '#finishDate'
        ,trigger: 'click'
    });
    /*领域*/
    httpModule({
        url: "/techFamily-api/getTreeList",
        type: 'GET',
        async:false,
        success: function(relData) {
            console.log(relData)
            relData.children.map(function (item,index) {
                item.children.map(function (items,i) {
                    delete items.children
                })
            })
            formSelects.data('techType', 'local', { arr: relData.children });
            formSelects.btns('techType', ['remove']);
        }
    });
    /*添加tr*/
    $("#addTr").click(function () {
        addTr('achieveTable')
        deleTr('achieveTable')
    })
    $("#formSave").click(function () {
        var data=form.val("formPlatform"),techTypeText='',achieveTransTypeText=''
        delete data.file;
        if(formSelects.value('techType')){
            formSelects.value('techType').map(function (item, index) {
                techTypeText+=item.name+','
            })
        }
        data.id=id
        data.teamPerson=getTableData('achieveTable')
        data.techTypeText=techTypeText.substring(0,techTypeText.length-1)
        data.achieveTransTypeText=$(".achieveTransType option:selected").text()
        console.log(data)
        httpModule({
            url: '/achieve-api/save',
            data: data,
            type: "POST",
            success: function(e) {
                console.log(e)
                /*if(e.success){
                    layer.msg('保存成功!', {icon: 1});
                }*/
            }
        });
    })
    /*form.on('submit(formSave)', function(data) {
        console.log(data)
        var data=getTableData('achieveTable')
    })*/
    form.on('submit(formDemo)', function(data) {
        var techTypeText='',achieveTransTypeText=''
        delete data.file;
        if(formSelects.value('techType')){
            formSelects.value('techType').map(function (item, index) {
                techTypeText+=item.name+','
            })
        }
        data.id=id
        data.teamPerson=getTableData('achieveTable')
        data.techTypeText=techTypeText.substring(0,techTypeText.length-1)
        data.achieveTransTypeText=$(".achieveTransType option:selected").text()
        console.log(data)
        httpModule({
            url: '/achieve-api/submit',
            data: data,
            type: "POST",
            success: function(e) {
                console.log(e)
                /*if(e.success){
                    layer.msg('保存成功!', {icon: 1});
                }*/
            }
        });
    })
})
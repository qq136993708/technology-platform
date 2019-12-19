layui.use(['jquery','table', 'form','formSelects','laydate'], function() {
    var $ = layui.jquery,form = layui.form,formSelects=layui.formSelects,laydate=layui.laydate;
    var fileDoc=''
    var readonlyFile = false; // 附件是否只读
    // 获取地址栏传递过来的参数
    var variable = getQueryVariable(),id='',approvalDoc='',publicDoc='';
    /*判断id，回显*/

   /* var fileCols = [
        {field: 'fileSize', title: '大小', templet: function(d) {return setFileSize(d.fileSize)}},
        {title: '操作', templet: function(d) {
                var templet = '<div class="file-options">';
                templet += '<span class="link-text file-options-delete" data-fileid="'+ d.id +'">删除</span>';
                templet += '<span class="link-text file-options-download" data-fileid="'+ d.id +'">下载</a>';
                templet += '</div>';
                return templet;
            }}
    ]*/
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
    if(variable.type=='view'){
        gray()
        $(".file-options-delete").remove()
        readonlyFile=true
        if(variable.flag==1){
            $("#close").hide()
        }
    }
    console.log(variable.id)
    if(variable.id!=undefined){
        id=variable.id
        httpModule({
            url: "/achieve-api/load/"+variable.id,
            type: 'GET',
            async:false,
            success: function(relData) {
                if(relData.code==0){
                    /*回显tr*/
                    relData.data.finishDate=dateFieldText(relData.data.finishDate)
                    form.val('formPlatform', relData.data);
                    formSelects.value('techType', relData.data.techType.split(','));
                    fileDoc=variable.id
                    backfill(relData.data.teamPerson,'achieveTable',variable.type)
                    approvalDoc=relData.data.approvalDoc
                    publicDoc=relData.data.publicDoc
                    if(variable.type=='view'){
                        formSelects.disabled(); // 禁用所有多选下拉框
                    }
                    console.log(relData)
                }
            }
        });

    }else {
        httpModule({
            url: "/achieve-api/newInit",
            type: 'GET',
            async:false,
            success: function(relData) {
                if(relData.code==0){
                    id=relData.data.id
                    approvalDoc=relData.data.approvalDoc
                    publicDoc=relData.data.publicDoc
                }
                console.log(relData)
            }
        });

    }
    setFileUpload({
        id: 'file-filter-options1', // 附件上传作用域ID值 必传
        dataID: approvalDoc, // 用来查找当前单据下绑定的附件，没有则不查找
        /*cols: fileCols,*/
        readonly: readonlyFile,
        secretLevel : function() {
            return $("#secretLevel").val();
          },
        callback: function (tableData, type) {
            console.log(tableData)
            if(tableData.length>0){
                fileDoc=''
                tableData.map(function (item, index) {
                    console.log(item)
                    fileDoc+=item.id+","
                })
                fileDoc=fileDoc.substring(0, fileDoc.length - 1);
            }else {
                fileDoc=''
            }
        }
    });
    /*添加tr*/
    $("#addTr").click(function () {
        addTr('achieveTable')
        deleTr('achieveTable')
    })
    form.on('submit(formSave)', function(data) {
        var techTypeText='',achieveTransTypeText=''
        delete data.field.file;
        if(formSelects.value('techType')){
            formSelects.value('techType').map(function (item, index) {
                techTypeText+=item.name+','
            })
        }
        data.field.id=id
        data.field.approvalDoc=approvalDoc
        data.field.publicDoc=publicDoc
        data.field.teamPerson=getTableData('achieveTable')
        data.field.techTypeText=techTypeText.substring(0,techTypeText.length-1)
        data.field.achieveTransTypeText=$(".achieveTransType option:selected").text()
        console.log(fileDoc)
        var fileDocS={}
        fileDocS[approvalDoc]=fileDoc
        data.field.fileDoc=JSON.stringify(fileDocS)
        if(getTableData('achieveTable')==''){
            layer.msg('科技成果完成团队情况（按贡献度排序）为必填项不能为空！');
            return false
        }
        httpModule({
            url: '/achieve-api/save',
            data:  data.field,
            type: "POST",
            success: function(e) {
                if(e.code==0){
                    layer.msg('保存成功!', {icon: 1});
                    closeTabsPage(variable.index);
                }
            }
        });
    })
    $("#close").click(function () {
        closeTabsPage(variable.index);
    })
})
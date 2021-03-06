/**
 * 通用文件管理组件
 * @author
 */
(function ($, window, document, undefined) {
    'use strict';

    var pluginName = 'file';

    $.fn[pluginName] = function (options) {
        console.log(options);
        var self = $(this);
        if (this == null)
            return null;
        var data = this.data(pluginName);
        if (!data) {
            data = new BaseFile(this, $.extend(true, {}, options));
            self.data(pluginName, data);
        }
    };


    var BaseFile = function (element, options) {
        this.element = element;
        //extend优先级 后面的会覆盖前面的
        //alert(this.element.selector);
        //将容器ID传过去便于弹窗获取到BaseFile对象，如果页面布局不在使用jquery.load方法，则该方法会失效，因为不是一个页面了
        options.container = options.container || this.element.selector.replace("#", "");
        //初始化文件图标信息
        this.getFileIconSettings();
        //获取配置信息
        this.getFileConfig(this.default);
        this.options = $.extend(true, {}, this.default, options);
        //初始化图标信息
        this.initFileIds();

        if(this.options.window) {
            this.element.click(function () {
                $(this).data('file').openWin();
            });
        }else{
            //非弹窗形式
            if(this.options.multiple)
                this.element.attr("multiple","multiple");
        }

        //如果配置了附件编辑容器showContainer（附件列表，可单个删除），则进行初始化
        if(this.hasDisplayZone()){
            this.showFiles();
        }

    }



    BaseFile.prototype.default = {
        winId: "fileWin",
        width: 900,
        title: "文件上传",
        //通用文件上传界面
        url:  "/sysfile/uploader",
        //默认支持多文件上传
        multiple: true,
        //默认弹出附件上传窗口
        window:true,
        showType:"edit",
        fileinput: {
            language: 'zh',
            uploadUrl:  "/sysfile/uploadMultipleFile",
            deleteUrl:"/sysfile/delete",
            uploadAsync:false,
            validateInitialCount:true,
            overwriteInitial: false,
            uploadExtraData: function (previewId, index) {
                var obj = {};
                obj.id=filedflag;
                obj.token=getCookie("token");
                return obj;
            },
            layoutTemplates :{
                // actionDelete:'', //去除上传预览的缩略图中的删除图标
                actionUpload:'',//去除上传预览缩略图中的上传图片；
                actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
            },

            allowedPreviewTypes: ['image'],
            previewFileIcon:'<i class="fa fa-file-o"></i>',
            otherActionButtons:'<button type="button" class="kv-file-down btn btn-xs btn-default" {dataKey} title="下载附件"><i class="fa fa-cloud-download"></i></button>',
            slugCallback: function (text) {
                var newtext=(!text||text=='') ? '' : String(text).replace(/[\-\[\]\/\{}:;#%=\(\)\*\+\?\\\^\$\|<>&"']/g, '_');
                //去除空格
                return newtext.replace(/(^\s+)|(\s+$)/g,"").replace(/\s/g,"");
            }
        }
    }

    BaseFile.prototype.getFileConfig=function(options){
        ajaxPost("/sysfileconfig/getFileConfig",{filedflag:filedflag,token:getCookie("token")},function(result){
            var self = options;
            self.fileinput.maxFileSize=result.fileSize;
            self.fileinput.maxFileCount = result.fileCount;
            self.fileinput.allowedFileExtensions = result.fileType.split(",");
        });
    };

    BaseFile.prototype.getFileInputConfig=function () {
        return this.options.fileinput;
    }

        BaseFile.prototype.getFileIconSettings = function () {
        var self = this;
        ajaxPost( "/sysfile/icons", null, function (icons) {
            self.previewFileIconSettings = icons;
        })
    }


    BaseFile.prototype.openWin = function () {
        var that = this;
        var self = $.extend(true, {}, this.options);
        //深拷贝后删除属性，这样不会通过后台传送过去，防止被XSS过滤掉特殊字符
        //不需要通过参数config=传递到弹窗的参数可使用delete删除
        delete self.callback;
        delete self.fileIds;
        delete self.showContainer;
        delete self.fileIdContainer;
        delete self.fileinput;

        /*console.log(this.options);
         console.log("=============");
         console.log(self);*/
        modals.openWin({
            winId: that.options.winId,
            url: that.options.url + "?config=" + JSON.stringify(self),
            width: that.options.width + "px",
            title: that.options.title,
            backdrop: "static"
        });
    }

    BaseFile.prototype.callbackHandler = function (fileIds) {
        //更新fileIds并执行回调函数
        var oldfileIds = this.options.fileIds;
        this.options.fileIds = fileIds;
        this.updateFileIds();
        if (this.options.callback) {
            this.options.callback.call(this, fileIds, oldfileIds);
        }
    }

    //调用成功后执行显示附件
    BaseFile.prototype.showFiles=function(options){
        options=options||{};
        if(!this.hasDisplayZone()){
            modals.error("请配置showContainer属性，并在容器下配置type=file的input组件");
            return;
        }
        var fileIds=options.fileIds||this.options.fileIds;
        if(!fileIds&&this.options.window){
            $(this.options.showContainer).hide();
            return;
        }
        //显示
        $(this.options.showContainer).show();
        var fileComponet=$(this.options.showContainer);
        var fileResult=this.getFileResult(fileIds),preview=fileResult.initialPreview,previewConfig=fileResult.initialPreviewConfig,self=this;
        //配置三类参数 edit=附件列表（可删除） detail=附件列表（显示） 可上传
        var defaultConfig={
            initialPreview:preview,
            initialPreviewConfig:previewConfig,
            previewFileIconSettings:this.previewFileIconSettings
        };
        var config;
        if(this.options.showType=="detail"){
            config=$.extend({},self.options.fileinput,defaultConfig,{
                showRemove:false,
                showUpload:false,
                showClose:false,
                showBrowse:false,
                showCaption:false,
                showDrag:true,
                initialPreviewShowDelete:true,
                fileActionSettings:{
                    showZoom:true,//不允许预览
                    showRemove:false
                }


            },options);
            //detail状态下隐藏上传按钮
            //$("#fileIds").hide();
        }else {
            if (this.options.window) {
                if (this.options.showType == "edit") {
                    //全局配置->本方法默认配置->edit属性下配置->外部参数
                    config = $.extend({}, self.options.fileinput, defaultConfig, {
                        showRemove: false,
                        showUpload: false,
                        showClose: false,
                        showBrowse: false,
                        showCaption: false
                    }, options);
                }
            } else {
                config = $.extend({}, self.options.fileinput, defaultConfig, {
                    showClose: false
                }, options);
            }
        }
        if(!config){
            modals.error("缺少配置，请检查");
            return;
        }
        //console.log("config=========="+JSON.stringify(config));
        fileComponet.fileinput('destroy');
        fileComponet.fileinput(config).on("filedeleted",function (event,key) {
            var newfids=self.deleteFileIds(key,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
        }).on("fileuploaded",function(event,data,previewId,index){
            var newfids=self.addFileIds(data.response.fileIds,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
            //otherActionButtons绑定事件 下载按钮绑定
            self.downloadHandler(this);
        }).on("filebatchuploadsuccess",function (event,data,previewId,index) {
            var newfids=self.addFileIds(data.response.fileIds,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
            //otherActionButtons绑定事件
            self.downloadHandler(this);
        }).on("filezoomhidden", function(event, params) {
            $(document.body).removeClass('modal-open');
            $(document.body).css("padding-right","0px");
        })
        this.downloadHandler(fileComponet);
    }


    /**
     * 其他按钮（如下载）绑定时间
     */
    BaseFile.prototype.downloadHandler=function(fileobj){
        if(!fileobj)
            fileobj=$(this.options.showContainer);
        var objs=$(fileobj).data('fileinput').$preview.find(".kv-preview-thumb .kv-file-down");
        objs.unbind("click");
        objs.on("click",function(){
            //点击下载
            window.location.href="/sysfile/download/"+$(this).data("key");
        });
    }
    /**
     * 向targetIds里删除数据fileIds
     * @param fileIds
     * @param targetIds
     */
    BaseFile.prototype.deleteFileIds=function(fileIds,targetIds){
        if(!fileIds) return targetIds;
        //没有文件删除，其中必有蹊跷
        if(!targetIds){
            modals.error("没有要删除的文件，请检查是否数据没有初始化");
            return;
        }
        var fileIdArr=fileIds.split(",");
        var fresult=targetIds.split(",");
        $.each(fileIdArr,function (index,fileId){
            //存在则删除
            if($.inArray(fileId,fresult)>-1){
                fresult.splice($.inArray(fileId,fresult),1);
            }
        })
        return fresult.join();
    }

    /**
     * 向targetIds里加数据fileIds
     * @param fileIds
     * @param targetIds
     */
    BaseFile.prototype.addFileIds=function (fileIds,targetIds) {
        if(!fileIds)return targetIds;
        var fileIdArr=fileIds.split(",");
        var fresult=[];
        if(targetIds){
            fresult=targetIds.split(",");
        }
        $.each(fileIdArr,function (index,fileId){
            //不存在，新增
            if($.inArray(fileId,fresult)==-1){
                fresult.push(fileId);
            }
        })
        return fresult.join();
    }

    BaseFile.prototype.updateFileIds=function(){
        if(this.options.fileIdContainer)
            $(this.options.fileIdContainer).val(this.options.fileIds);
    }

    BaseFile.prototype.initFileIds=function(){
        //不弹出窗口的话一定要绑定fileIdContainer
        if(!this.options.window){
            if(!this.options.fileIdContainer||!$(this.options.fileIdContainer)){
                modals.info("请设置fileIdContainer属性");
                return;
            }
        }
        if(!this.options.fileIds){
            if(this.options.fileIdContainer){
                this.options.fileIds=$(this.options.fileIdContainer).val();
            }
        }
    }

    BaseFile.prototype.getFileResult=function(fileIds){
        var ret=null;
        ajaxPost("/sysfile/getFiles",{fileIds:fileIds},function(result){
            ret=result;
        });
        return ret;
    };

    /**
     * 是否有显示区域
     * @returns {boolean}
     */
    BaseFile.prototype.hasDisplayZone=function(){
        if(!this.options.showContainer){
            this.options.showContainer=this.element.selector;
        }
        if(!this.options.showContainer||!$(this.options.showContainer)){
            return false;
        }
        return true;
    }



})(jQuery, window, document);
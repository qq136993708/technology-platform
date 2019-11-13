/**
 * Created on 2018年8月14日11点05分
 * 方法
 */
layui.define(['jquery','jqZtreeCore','table','laydate'],
    function(exports) {
        var $ = layui.jquery,table=layui.table,laydate=layui.laydate;
        var selectTreeObj = {
            //id div 的id，isMultiple 是否多选，chkboxType 多选框类型{"Y": "ps", "N": "s"} 详细请看ztree官网
            selectTree:'',
            initSelectTree:function(id, isMultiple, isShowLine, isShowIcon, chkboxType,zNodes) {
                var setting = {
                    view: {
                        dblClickExpand: false,
                        showLine: true
                    },
                    data: {
                        simpleData: {
                            enable: true
                        }
                    },
                    check: {
                        enable: false,
                        chkboxType: {"Y": "ps", "N": "s"}
                    },
                    callback: {
                        onClick: selectTreeObj.onClick,
                        onCheck: selectTreeObj.onCheck
                    },
                    view: {
                        showLine: isShowLine,
                        showIcon: isShowIcon
                    }

                };
                if (isMultiple) {
                    setting.check.enable = isMultiple;
                }
                if (chkboxType !== undefined && chkboxType != null) {
                    setting.check.chkboxType = chkboxType;
                }
                var html = '<div class = "layui-select-title" >' +
                    '<input id="' + id + 'Show" type = "text" placeholder = "请选择"  value = ""  lay-verify="'+id+'" class = "layui-input" readonly>' +
                    '<i class= "layui-edge" ></i>' +
                    '</div>';
                $("#" + id).append(html);
                $("#" + id).parent().append('<div class="tree-content scrollbar">' +
                	'<input hidden id="' + id + '"' + 'name="' + id + '">' +
                    '<input hidden id="' + id + 'Value" ' + 'name="' + id + 'Value">' +
                    '<input hidden id="' + id + 'Code" ' + 'name="' + id + 'Code">' +
                    '<input hidden id="' + id + 'Type" ' + 'name="' + id + 'Type">' +
                    '<input hidden id="' + id + 'Save" ' + 'name="' + id + 'Save">' +
                    '<input hidden id="' + id + 'Show" ' + 'name="' + id + 'Show">' +
                    '<ul id="' + id + 'Tree" class="ztree"></ul>' +
                    '</div>');
                $("#" + id).bind("click", function () {
                    $(".layui-unselect").removeClass("layui-form-selected");
                    if ($(this).parent().find(".tree-content").css("display") !== "none") {
                        // hideMenu()
                    } else {
                        $(this).addClass("layui-form-selected");
                        var Offset = $(this).offset();
                        var width = $(this).width() - 2;
                        if(Offset.top > 300){
                            $(this).parent().find(".tree-content").css({
                                left: 0 + "px",
                                bottom: $(this).height() + "px"
                            }).slideDown("fast");
                        }else{
                            $(this).parent().find(".tree-content").css({
                                left: 0 + "px",
                                top: $(this).height() + "px"
                            }).slideDown("fast");
                        }

                        $(this).parent().find(".tree-content").css({
                            width: width
                        });
                        $("body").bind("mousedown", selectTreeObj.onBodyDown);
                    }
                });
                selectTree = $.fn.zTree.init($("#" + id + "Tree"), setting, zNodes);
                selectTree.expandAll(true);
                return selectTree;
            },

            onClick:function(event, treeId, treeNode) {
                console.log(treeNode)
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                if (zTree.setting.check.enable == true) {
                    zTree.checkNode(treeNode, !treeNode.checked, false)
                    selectTreeObj.assignment(treeId, zTree.getCheckedNodes());
                } else {
                    selectTreeObj.assignment(treeId, zTree.getSelectedNodes());
                    selectTreeObj.hideMenu();
                }
                //如果是级联岗位
                if(treeId=="userUnitTree"){
                    initPostData(zTree.getCheckedNodes(true));
                }
                //机具报验退场 联动单项工程联动
                if(treeId=="wbsTree"){
                    $("input[name=wbsCode]").val(treeNode.code);
                    $("input[name=wbsName]").val(treeNode.name);
                    $("input[name=wbsId]").val(treeNode.id);
                    table.render({
                        elem: '#userTalbe',
                        url: '/tools/list',
                        limit: 15,
                        id: 'back',
                        method:"POST",
                        where: {param: {"wbsId":treeNode.id}},
                        cols: [[
                            {type:'checkbox'},
                            {title:'序号', type:'numbers'},
                            {field:'attachId', title:'附件', event: 'setActive',style:'cursor: pointer;',
                                templet:  function (d) {
                                    return "<a class='file-name add-file' onclick=editUpload('"+d.dataId+"')> 添加附件<input type='hidden' value='"+d.dataId+"'/></a>";
                                }
                            },
                            {field:'formCode', title:'机具编号', event: 'setActive',style:'cursor: pointer;'},
                            {field:'toolType', title:'机具类型', event: 'setActive',style:'cursor: pointer;'},
                            {field:'toolName', title:'机具名称', event: 'setActive',style:'cursor: pointer;'},
                            {field:'toolVersion', title:'规格型号', event: 'setActive',style:'cursor: pointer;'},
                            {field:'toolPhoto', title:'照片', event: 'setActive',style:'cursor: pointer;',
                                templet:  function (d) {
                                    return "<a class='file-name add-file' onclick=editUpload('"+d.dataIdPhoto+"')> 添加照片<input type='hidden' value='"+d.dataIdPhoto+"'/></a>";
                                }
                            },
                            {field:'status', title:'机具状态', event: 'setActive',style:'cursor: pointer;'},
                            {field:'exitDate', title:'退场日期', event: 'setActive',style:'cursor: pointer;',width:'13%',
                                templet:function (d) {
                                    var t="<input type='text' value='"+d.exitDate+"' class='layui-input datetime inputVal' id='test-laydate-type-certtime' placeholder='请选择日期' >";
                                    return t;
                                }
                            },
                            {field:'validTill', title:'有效期至', event: 'setActive',style:'cursor: pointer;'},
                            {field:'reportId', title:'报验id', event: 'setActive',style:'cursor: pointer;'},
                            {field:'toolPerson', title:'负责人', event: 'setActive',style:'cursor: pointer;'},
                            {field:'contactWay', title:'联系方式', event: 'setActive',style:'cursor: pointer;'},
                            {field:'workArea', title:'施工区域', event: 'setActive',style:'cursor: pointer;'},
                            {field:'dataIdRemark', title:'问题附件id', event: 'setActive',style:'cursor: pointer;'}
                        ]],
                        done: function (res, curr, count) {
                            // 点击行联动选择框--单选
                            $("#userTalbeHeader table").css("width","100%");
                            $("#userTalbeHeader .layui-table-body table tr").each(function () {
                                $(this).find("td").eq(11).hide();
                                $(this).find("td").eq(12).hide();
                                $(this).find("td").eq(13).hide();
                                $(this).find("td").eq(14).hide();
                                $(this).find("td").eq(15).hide();
                            });
                            $("th:eq(11)").hide();
                            $("th:eq(12)").hide();
                            $("th:eq(13)").hide();
                            $("th:eq(14)").hide();
                            $("th:eq(15)").hide();
                            $('.datetime').each(function() {
                                laydate.render({
                                    elem : this,
                                    trigger : 'click'
                                });
                            });
                        }

                    });
                }
            },

            onCheck:function(event, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                selectTreeObj.assignment(treeId, zTree.getCheckedNodes());
                //如果是级联岗位
                if(treeId=="userUnitTree"){
                    initPostData(zTree.getCheckedNodes(true));
                }
            },

            hideMenu:function() {
                $(".select-tree").removeClass("layui-form-selected");
                $(".tree-content").fadeOut("fast");
                $("body").unbind("mousedown", selectTreeObj.onBodyDown);
            },

            initHideMenu:function() {
                $(".select-tree").removeClass("layui-form-selected");
                $(".tree-content").hide();
            },

            assignment:function(treeId, nodes) {
                var names = "";
                var ids = "";
                var codes = "";
                var types = "";
                for (var i = 0, l = nodes.length; i < l; i++) {
                    //if(nodes[i].isParent!=true){
                    names += nodes[i].name + ",";
                    ids += nodes[i].id + ",";
                    codes += nodes[i].code + ",";
                    types += nodes[i].nodeType + ",";
                    //}
                }
                if (names.length > 0) {
                    names = names.substring(0, names.length - 1);
                    ids = ids.substring(0, ids.length - 1);
                    types = types.substring(0, types.length - 1);
                    codes = codes.substring(0, codes.length - 1);
                }
                treeId = treeId.substring(0, treeId.length - 4);
                // Show.Code.Type这三个有问题
                $("#" + treeId + "Show").attr("value", names);
                $("#" + treeId + "Show").attr("title", names);
                $("#" + treeId + "Value").attr("value", ids);
                $("#" + treeId ).attr("value", ids);
                $("#" + treeId + "Code").attr("value", codes);
                $("#" + treeId + "Type").attr("value", types);
                $("input[name='"+treeId+"']").attr("value", ids);
            },
            onBodyDown:function(event) {
                if ($(event.target).parents(".tree-content").html() == null) {
                    selectTreeObj.hideMenu();
                }
            },
            /**
             * 动态创建节点
             * @param id
             * @param pId
             * @param name
             * @returns
             */
            zTreeNode:function(id,pId,name)
            {
                this.id = id;
                this.pId = pId;
                this.name = name;
            },
            autoCheck:function(id,arry)
            {
                var zTree = $.fn.zTree.getZTreeObj(id);
                // var nodes = zTree.getNodes();
                // console.log(nodes)
                // console.log(zNodes)
                // console.log(arry)
                $.each(zNodes,function(i,n)
                {
                    if ($.inArray(n.id, arry) > -1) {
                        // alert(n.id)
                        var node = zTree.getNodeByParam("id",n.id);
                        // zTree.selectNode(node);
                        zTree.checkNode(node, true, true);
                    }
                });
                selectTreeObj.assignment(id, zTree.getCheckedNodes());
            }
        }
        /**
         * 接口输出
         */
        exports('selectTree',selectTreeObj);
    });
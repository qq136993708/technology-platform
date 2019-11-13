/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function (config) {
    config.language = 'zh-cn';
    config.uiColor = '#d1e9f3';
    config.toolbarCanCollapse = true;
    config.toolbarGroups = [
        {name: 'document', groups: ['mode', 'document', 'doctools']},
        {name: 'clipboard', groups: ['clipboard', 'undo']},
        {name: 'editing', groups: ['find', 'selection', 'spellchecker', 'editing']},
        {name: 'forms', groups: ['forms']},
        {name: 'basicstyles', groups: ['basicstyles', 'cleanup']},
        {name: 'paragraph', groups: ['list', 'indent', 'blocks', 'align', 'bidi', 'paragraph']},
        {name: 'links', groups: ['links']},
        {name: 'insert', groups: ['insert']},
        {name: 'styles', groups: ['styles']},
        {name: 'colors', groups: ['colors']},
        {name: 'tools', groups: ['tools']},
        {name: 'others', groups: ['others']},
        {name: 'about', groups: ['about']}
    ];
// 图片上传配置
    config.image_previewText = ' ';/*去掉图片预览框的文字*/
    /*开启工具栏“图像”中文件上传功能，后面的url为图片上传要指向的的action或servlet*/
    // config.filebrowserUploadUrl = '/sysfile/ckupload?type=File';
    config.filebrowserImageUploadUrl = '/sysfile/ckupload?type=Image';
    // config.filebrowserFlashUploadUrl = '/sysfile/ckupload?type=Flash';
    // 图片浏览配置
    //config.filebrowserImageBrowseUrl = 'browerServer.do?type=image';

    config.removeButtons = 'Source,Save,NewPage,Print,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,CreateDiv,Iframe,PageBreak,Flash,About,Language';
};
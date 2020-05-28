CKEDITOR.plugins.add( 'abbr', {
    icons: 'image',
    init: function( editor ) {
        // Plugin logic goes here...
        // 给自定义插件注册一个调用命令
        editor.addCommand( 'abbr', new CKEDITOR.dialogCommand( 'abbrDialog' ) );
 
        editor.ui.addButton( 'Abbr', {
            // label为鼠标悬停时展示的字
            label: 'Insert Abbreviation',
            // the command to be executed once the button is activated. This is the command we created in the previous step.
            command: 'abbr',
            // 将插件放在哪一组tollbar， 像我这样写的话，将放在'insert'组的第一个，懂了吗？后面的数字是这个数据的下标
            toolbar: 'insert,0'
        });
        // 加载自定义窗口，'abbrDialog'跟上面调用命令的'abbrDialog'一致;
        CKEDITOR.dialog.add( 'abbrDialog', this.path + 'dialog/mydialog.js' );
    }
});
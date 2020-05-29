CKEDITOR.dialog.add( 'abbrDialog', function( editor ) {
    return {
        title: 'Abbreviation Properties',
        minWidth: 400,
        minHeight: 200,
        contents: [
            {
                id: 'Upload',
                label: 'Upload test',
                elements: [
                    // 我这里需要一个tab页面，所以elements数组只有一个对象
                    {
                        // type为html表示html代码
                        type: 'html',
                        // 接下来html属性就可以直接写html代码了
                        html: '<div>'
                              +  '<label for="fileuploadtest">选择图片</label>'
                              +  '<input type="file" name="fileuploadtest" id="fileuploadtest">'
                            + '</div>',
                            // 那要怎么拿到自定义窗口的元素呢？在ckeditor自带的自定义窗口里并不容易拿到，这时候我们得用到onLoad函数了
                        onLoad: function () {
                            // 在自定义窗口展示的时候会触发这条函数;而我们就能在这条函数里写我们的代码了;
                            var ele = document.getElementById('fileuploadtest');
                            // 给id为'fileuploadtest'的input绑定change事件
                            ele.addEventListener('change', function() {
                                // 当用户没选或者点取消的时候直接return
                                if (this.files.length == 0) return;
                                var imageData = this.files[0];
                                // 检测后缀名
                                var lastIndex = imageData.name.lastIndexOf('.');
                                var imageSuffix = imageData.name.substring(lastIndex + 1);
                                // 判断后缀名
                                if (!(imageSuffix == 'png' || imageSuffix == 'jpg' || imageSuffix == 'jpeg')) {
                                    alert('图片格式只支持"png, jpg, jpeg格式"');
                                    return
                                }
                                // 大小不能超过1m 
                                if (imageData.size > 1*1024*1024) {
                                    alert('图片大小不能超过1M');
                                    return
                                }
                                // 使用FileReader接口读取图片
                                var reader = new FileReader();
                                reader.addEventListener('load', function () { 
                                    var imageBase64 = reader.resul;
                                    // 我没有想到好的办法将数据传递到onOk函数那里去，只好将图片数据保存在sessionstorage里面
                                    // 有好的办法希望各位大神能提供下
                                    sessionStorage.setItem('image', imageBase64)
                                })
                                console.log(imageData);
                                
                                // 将图片转成base64格式
                                reader.readAsDataURL(imageData)
                            })
                        }
                    }
                ]
            }
        ],
        onOk: function() {
            // this这里就是自定窗口了，ckeditor内部封装好了。
            var dialog = this;
            // 创建img标签
            var image = editor.document.createElement( 'img' );
            // 给img标签设置class类
            image.setAttribute( 'class', 'insert-image');
            var imageData = sessionStorage.getItem('image');
            // 将图片数据赋予img标签
            image.setAttribute('src',imageData);
            // 利用ckeditor提供的接口将标签插入到富文本框中
            editor.insertElement( image );
        },
    };
});
// ClassicEditor.create(document.querySelector('#detailContent'), {})
//     .then(editor => {
//         editor.plugins.get('FileRepository').createUploadAdapter  = (loader) => {
//             return new UploadAdapter(loader);
//         };
//         console.log('Editor was initialized');
//     })
//     .catch(error => {
//         console.log(error)
//     });
//自定义适配器
class UploadAdapter {
    constructor(loader) {
        this.loader = loader;
    }
    upload() {
        return new Promise((resolve, reject) => {
            const data = new FormData();
            data.append('file', this.loader.file);
            data.append('allowSize', 10);//允许图片上传的大小/兆
            $.ajax({
                // url:  "" + rootPath + "/qiNiu/uploadFile.json",//上传图片的url
                url:  "/sysfile/ckupload5?type=Image",//上传图片的url
                type: 'POST',
                data: data,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function (data) {
                    var tempObj = data.data;
                    var status = data.success;
                    if (status==true) {
                        resolve({
                            default: tempObj.imageUrl
                        });
                    } else {
                        reject(data.msg);
                    }
                }
            });
        });
    }
    abort() {
    }
}
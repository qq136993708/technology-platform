package com.pcitc.web.controller.system;

import org.springframework.stereotype.Controller;

import com.pcitc.web.common.BaseController;
//
//import org.apache.http.*;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;

/**
 * <p>控制类</p>
 * <p>Table: sys_file - </p>
 *
 * @since 2018-05-08 02:04:50
 */
@Controller
public class HttpClientFileUploadController extends BaseController {//extends BaseController

    private static final String uploadFileSave = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadFileSave";

    private static final String uploadFileSavetest = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadFileSavetest";
//
//    /**
//     * 多文件上传，用于uploadAsync=false(同步多文件上传使用)
//     *
//     * @param
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/sysfile/uploadMultipleFile", method = RequestMethod.POST)
//    @ResponseBody
//    public FileResult uploadMultipleFile(@RequestParam(value = "file", required = false) MultipartFile[] files,
//                                         HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        try{
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // 设置要进行远程上传微服务调用的代理地址
//    public static final String UPLOAD_URL = "http://localhost:9501/zuul/mldn-proxy/upload-proxy/upload";
//    @RequestMapping(value = "/consumer/uploadPre", method = RequestMethod.GET)
//    public String uploadPre() {
//        return "upload";
//    }
//    @RequestMapping(value = "/consumer/upload", method = RequestMethod.POST)
//    public @ResponseBody String upload(String name, MultipartFile photo) throws Exception {
//        try {
//            if (photo != null) {
//                CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个HttpClient对象
//                HttpClientContext httpContext = HttpClientContext.create(); // 创建Http处理操作的上下文对象
//                HttpPost httpPost = new HttpPost(UPLOAD_URL); // 设置要进行访问的请求地址
//                org.apache.http.HttpEntity entity = MultipartEntityBuilder.create()
//                        .addBinaryBody("photo", photo.getBytes(),
//                                ContentType.create("image/jpeg"), "temp.jpg")
//                        .build();
//                httpPost.setEntity(entity);    // 将请求的实体信息进行发送
//                HttpResponse response = httpClient.execute(httpPost, httpContext) ;    // 执行请求的发送
//                return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8")) ;
////       return "【*** 消费端 ***】name = " + name + "、photoName = "
////             + photo.getOriginalFilename() + "、ContentType = "
////             + photo.getContentType();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "nophoto.jpg";
//    }

}
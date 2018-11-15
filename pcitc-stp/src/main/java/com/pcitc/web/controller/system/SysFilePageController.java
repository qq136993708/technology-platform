package com.pcitc.web.controller.system;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("sysFilePage")
public class SysFilePageController extends BaseController {

    private static final String LIST = "http://pcitc-zuul/system-proxy/projecttype-provider/projecttype/projecttype_list";

    @RequestMapping(value = "/fileconfig", method = {RequestMethod.GET})
    public String fileConfig() {
        return "base/system/function_trees";
    }

    @RequestMapping(value = "/fileuplaod", method = {RequestMethod.GET})
    public String fileUpload() {
        return "base/system/upload";
    }

    @RequestMapping(value = "/filelist", method = {RequestMethod.GET})
    public String fileList() {
        return "base/system/file_show";
    }

    @RequestMapping(value = "/highchart", method = {RequestMethod.GET})
    public String highchart() {
        /*httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ProjectType>(new ProjectType(), this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ProjectType> list = (List<ProjectType>) retJson.get("list");
        request.setAttribute("list", list);*/
        return "pplus/sample/highchart";
    }

    /**
     * layui文件上传跳转
     *
     * @return
     */
    @RequestMapping(value = "/fileuplaodlayui", method = {RequestMethod.GET})
    public String layuiFileUpload() {
        return "layui/uploadlayui";
    }

    /**
     * layui文件上传跳转
     *
     * @return
     */
    @RequestMapping(value = "/fileuplaodlayuitwo", method = {RequestMethod.GET})
    public String layuiFileUploadtwo() {
        return "layui/uploadlayuitwo";
    }

    /**
     * layui文件上传弹出
     *
     * @return
     */
    @RequestMapping(value = "/example_upload_pop", method = {RequestMethod.GET})
    public String example_upload_pop() {
        return "base/system/example_upload_pop";
    }

    /**
     * 文件上传弹出窗口
     * @return
     */
    @RequestMapping(value = "/uploadFile")
    public String uploadFile(String param) {
        Map<String, Object> map = JSON.parseObject(param);
        System.out.println("map = " + map);
        request.setAttribute("param",JSON.toJSON(map).toString());
        request.setAttribute("file_edit_detail", map.get("file_edit_detail"));
        request.setAttribute("file_id_name", map.get("file_id_name"));
        request.setAttribute("file_opt_flag", map.get("file_opt_flag"));
        request.setAttribute("file_ids_value", map.get("file_ids_value"));
        request.setAttribute("call_fun", map.get("callback"));
//        response.addHeader("x-frame-options","DENY");
//        response.addHeader("x-frame-options","SAMEORIGIN");

        httpHeaders.add("x-frame-options","ALLOW-FROM");
//        httpHeaders.add("x-frame-options","DENY");

        return "/common/public/uploadpop";
    }

    /**
     * 文件列表查看table
     * @return
     */
    @RequestMapping(value = "/uploadFileTable")
    public String uploadFileTable(String param) {
        Map<String, Object> map = JSON.parseObject(param);
        System.out.println("map = " + map);
        request.setAttribute("param",JSON.toJSON(map).toString());
        request.setAttribute("file_edit_detail", map.get("file_edit_detail"));
        request.setAttribute("file_id_name", map.get("file_id_name"));
        request.setAttribute("file_opt_flag", map.get("file_opt_flag"));
        request.setAttribute("file_ids_value", map.get("file_ids_value"));
        request.setAttribute("call_fun", map.get("callback"));
        return "/common/public/uploadpop_table";
    }
}
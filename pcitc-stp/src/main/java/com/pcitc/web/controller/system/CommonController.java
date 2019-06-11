package com.pcitc.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:Administrator
 * @date:2018/5/10
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/uploadfiledialog")
    public String uploadFileDialog(String config, HttpServletRequest request){
        System.out.println("i'm coming");
        String configs = request.getAttribute("config")+"";
        request.setAttribute("config",request.getAttribute("config"));
        System.out.println(config);
        return "file_uploader";
    }
}

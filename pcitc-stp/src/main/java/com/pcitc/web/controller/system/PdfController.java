package com.pcitc.web.controller.system;

import com.pcitc.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:Administrator
 * @date:2018/5/10
 */
@Controller
@RequestMapping("/pdf")
public class PdfController extends BaseController {

    @RequestMapping("/view")
    public String uploadFileDialog(){
        String strFileName = request.getParameter("file");
        return "plugins/pdf/pdfjs-2.0.943-dist/web/viewer";
    }
}

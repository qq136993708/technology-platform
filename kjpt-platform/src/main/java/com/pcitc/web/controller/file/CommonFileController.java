package com.pcitc.web.controller.file;

import com.pcitc.base.common.FileModel;
import com.pcitc.web.common.RestBaseController;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 文件上传
 * @author ty
 */
@Controller
public class CommonFileController extends RestBaseController {

    @RequestMapping(value="",method = RequestMethod.GET)
     public List<FileModel> query(){

         return null;
     }


}

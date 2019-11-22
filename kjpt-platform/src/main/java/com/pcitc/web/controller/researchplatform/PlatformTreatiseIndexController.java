package com.pcitc.web.controller.researchplatform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>服务接口</p>
 * <p>Table:  - 科研平台-基本信息</p>
 * @author ty
 */

@Controller
public class PlatformTreatiseIndexController{

    @RequestMapping(value = "/platformProject-api/view")
    public String view() {
        return "/kjpt/researchplatform/treatise/view";
    }

    @RequestMapping(value = "/platformProject-api/add")
    public String add() {
        return "/kjpt/researchplatform/treatise/add";
    }

}

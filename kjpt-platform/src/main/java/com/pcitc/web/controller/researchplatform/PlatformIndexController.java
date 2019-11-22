package com.pcitc.web.controller.researchplatform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlatformIndexController {

    @RequestMapping(value = "/platform-api/view")
    public String view() {
        return "/kjpt/researchplatform/researchplatform_view";
    }

    @RequestMapping(value = "/platform-api/add")
    public String add() {
        return "/kjpt/researchplatform/researchplatform_add";
    }
}

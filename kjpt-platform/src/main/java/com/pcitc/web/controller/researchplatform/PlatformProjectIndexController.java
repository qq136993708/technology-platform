package com.pcitc.web.controller.researchplatform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlatformProjectIndexController {

    @RequestMapping(value = "/platformProject-api/view")
    public String view() {
        return "/kjpt/researchplatform/project/view";
    }

    @RequestMapping(value = "/platformProject-api/add")
    public String add() {
        return "/kjpt/researchplatform/project/add";
    }

}

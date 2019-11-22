package com.pcitc.web.controller.researchplatform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PlatformMemberIndexController {
    @RequestMapping(value = "/platformProject-api/view")
    public String view() {
        return "/kjpt/researchplatform/member/view";
    }

    @RequestMapping(value = "/platformProject-api/add")
    public String add() {
        return "/kjpt/researchplatform/member/add";
    }

}

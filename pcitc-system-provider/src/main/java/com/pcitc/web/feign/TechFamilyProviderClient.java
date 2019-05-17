package com.pcitc.web.feign;

import com.pcitc.base.stp.techFamily.TechFamily;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "pcitc-stp-provider")
public interface TechFamilyProviderClient {

    @RequestMapping(value = "/tech-family-provider/selectTechFamilyTypeList", method = RequestMethod.POST)
    public List<TechFamily> selectTechFamilyTypeList(@RequestBody TechFamily techFamily);

}

package com.pcitc.web.researchPlatform;

import com.pcitc.base.researchPlatform.PlatformInfoModel;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>服务接口</p>
 * <p>Table: zjk_achievement - 科研平台-基本信息</p>
 * @author ty
 */

@Api(value = "researchPlatform-api", description = "国家科研平台接口")
@RestController
@RequestMapping("researchPlatform-api")
public class PlatformClient {

    public PlatformInfoModel load(){
        return null;
    }

    public void save(){
    }

    public List<PlatformInfoModel> query(){
        return null;
    }

    public void delete(){
    }
}

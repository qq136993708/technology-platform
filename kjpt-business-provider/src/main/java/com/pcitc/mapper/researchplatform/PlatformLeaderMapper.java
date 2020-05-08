package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.researchplatform.PlatformLeaderModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlatformLeaderMapper {

    /**
     * 根据主键获取一个平台领军人物的信息
     */
    PlatformLeaderModel load(String id);
    /**
     * 保存平台领军人物
     */
    int add(PlatformLeaderModel platformLeaderModel);
    /**
     * 查询科研平台领军人物列表
     */
    List<PlatformLeaderModel> query(Map paramMap);


    /**
     * 修改科研平台领军人物
     */
    int update(PlatformLeaderModel platformLeaderModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 批量添加
     */
    int batchSave(List<PlatformLeaderModel> list);

}

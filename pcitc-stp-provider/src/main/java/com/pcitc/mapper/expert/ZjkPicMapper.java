package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkPic;
import com.pcitc.base.expert.ZjkPicExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ZjkPicMapper {
long countByExample(ZjkPicExample example);

int deleteByExample(ZjkPicExample example);

int deleteByPrimaryKey(String menuId);

int insert(ZjkPic record);

int insertSelective(ZjkPic record);

List<ZjkPic> selectByExample(ZjkPicExample example);

    ZjkPic selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkPic record, @Param("example") ZjkPicExample example);

    int updateByExample(@Param("record") ZjkPic record, @Param("example") ZjkPicExample example);

    int updateByPrimaryKeySelective(ZjkPic record);

    int updateByPrimaryKey(ZjkPic record);

    int updateByPrimaryKeyWithBLOBs(ZjkPic record);

    List<ZjkPic> findZjkPicByPage(Map<String,Object> map);

    List<ZjkPic> findZjkPicList( ZjkPic record);

    }
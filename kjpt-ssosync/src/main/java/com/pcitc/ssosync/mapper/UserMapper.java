package com.pcitc.ssosync.mapper;

import com.pcitc.ssosync.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Mapper
public interface UserMapper {

   List<User> query();

   User load(String adAccount);

   User loadByUserNamePassword(@Param("userName")String userName, @Param("password")String password);

   List<User> queryApprover(Map param);


}

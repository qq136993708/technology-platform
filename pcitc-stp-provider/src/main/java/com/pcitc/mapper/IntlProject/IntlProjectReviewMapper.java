package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectReview;
import com.pcitc.base.stp.IntlProject.IntlProjectReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectReviewMapper {
    long countByExample(IntlProjectReviewExample example);

    int deleteByExample(IntlProjectReviewExample example);

    int deleteByPrimaryKey(String reviewId);

    int insert(IntlProjectReview record);

    int insertSelective(IntlProjectReview record);

    List<IntlProjectReview> selectByExample(IntlProjectReviewExample example);

    IntlProjectReview selectByPrimaryKey(String reviewId);

    int updateByExampleSelective(@Param("record") IntlProjectReview record, @Param("example") IntlProjectReviewExample example);

    int updateByExample(@Param("record") IntlProjectReview record, @Param("example") IntlProjectReviewExample example);

    int updateByPrimaryKeySelective(IntlProjectReview record);

    int updateByPrimaryKey(IntlProjectReview record);
}
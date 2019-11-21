package com.pcitc.mapper.patent;

import com.pcitc.base.patent.KgjImportModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ty
 */
@Mapper
public interface KgjImportMapper {

    void kgjData2Db(List<KgjImportModel> dataList);

    List handlerKgjImport(String batchId);
}

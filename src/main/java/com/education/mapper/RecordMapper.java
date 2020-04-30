package com.education.mapper;

import com.education.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
/**
 * @author lss
 * @since 2020-03-22
 */
@Mapper
@Repository
public interface RecordMapper {
    public List<Record> queryRecordList();
    public List<Record> queryForType(HashMap map);
    public List<Record> queryForRecommend(HashMap map);

}
package com.education.mapper;

import com.education.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
/**
 * @author lss
 * @since 2020-03-22
 */
@Mapper
@Component
public interface RecordMapper {
    public List<Record> queryRecordList();
    public List<Record> queryRecordForType(HashMap map);
}
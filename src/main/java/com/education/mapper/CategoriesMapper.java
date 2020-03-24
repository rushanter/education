package com.education.mapper;

import com.education.entity.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lss
 * @since 2020-03-22
 */
@Mapper
@Component
public interface CategoriesMapper {
    public List<Categories> queryCategoriesList();
}

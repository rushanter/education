package com.education.mapper;

import com.education.entity.Categorie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lss
 * @since 2020-03-22
 */
@Mapper
@Repository
public interface CategorieMapper {
    public List<Categorie> queryCategorieList();
}

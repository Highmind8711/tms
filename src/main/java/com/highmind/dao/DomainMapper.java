package com.highmind.dao;

import com.highmind.entity.Domain;
import java.util.List;
import java.util.Map;

public interface DomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Domain record);

    int insertSelective(Domain record);

    List<Domain> selectByExample(Map<String,Object> map);

    Domain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Domain record);

    int updateByPrimaryKey(Domain record);
}
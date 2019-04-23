package com.highmind.dao;

import com.highmind.entity.Domain;
import java.util.List;
import java.util.Map;

public interface DomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Domain record);

    int insertSelective(Domain record);

    List<Domain> selectDomain(Map<String,Object> map);

    Domain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Domain record);

    int updateByPrimaryKey(Domain record);
}
package com.highmind.dao;

import com.highmind.entity.Loginlog;
import java.util.List;
import java.util.Map;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    List<Loginlog> selectByExample(Map<String,Object> map);

    Loginlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Loginlog record);

    int updateByPrimaryKey(Loginlog record);
}
package com.highmind.dao;

import com.highmind.entity.Area;
import java.util.List;
import java.util.Map;

public interface AreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectArea(Map<String, Object> hashMap);

    Area selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}
package com.highmind.dao;

import com.highmind.entity.Spot;
import java.util.List;
import java.util.Map;

public interface SpotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Spot record);

    int insertSelective(Spot record);

    List<Spot> selectSpot(Map<String, Object> hashMap);

    Spot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Spot record);

    int updateByPrimaryKey(Spot record);
}
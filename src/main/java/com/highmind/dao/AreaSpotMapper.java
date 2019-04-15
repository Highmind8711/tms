package com.highmind.dao;

import com.highmind.entity.AreaSpot;
import java.util.List;
import java.util.Map;

public interface AreaSpotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AreaSpot record);

    int insertSelective(AreaSpot record);

    List<AreaSpot> selectAreaSpot(Map<String, Object> hashMap);

    AreaSpot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AreaSpot record);

    int updateByPrimaryKey(AreaSpot record);
}
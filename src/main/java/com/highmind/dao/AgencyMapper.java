package com.highmind.dao;

import com.highmind.entity.Agency;
import java.util.List;
import java.util.Map;

public interface AgencyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Agency record);

    int insertSelective(Agency record);

    List<Agency> selectAgency(Map<String, Object> hashMap);

    Agency selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Agency record);

    int updateByPrimaryKey(Agency record);
}
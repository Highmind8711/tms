package com.highmind.dao;

import com.highmind.entity.AgencyEmployee;
import java.util.List;
import java.util.Map;

public interface AgencyEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AgencyEmployee record);

    int insertSelective(AgencyEmployee record);

    List<AgencyEmployee> selectAgencyEmployee(Map<String, Object> hashMap);

    AgencyEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgencyEmployee record);

    int updateByPrimaryKey(AgencyEmployee record);
}
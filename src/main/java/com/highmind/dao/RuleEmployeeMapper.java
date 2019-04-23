package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.RuleEmployee;

public interface RuleEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RuleEmployee record);

    int insertSelective(RuleEmployee record);

    RuleEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RuleEmployee record);

    int updateByPrimaryKey(RuleEmployee record);
    
    List<RuleEmployee> selectRuleEmployee(Map<String,Object> map);
}
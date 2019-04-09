package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Rule;

public interface RuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);
    
    List<Rule> selectRule(Map<String,Object> map);
}
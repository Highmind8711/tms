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
    /**
     * 查询角色下的雇员
     * @Description
     * @param map
     * @return
     */
    List<Rule> selectRuleEmployee(Map<String,Object> map);
    /**
     * 查询角色下的权限
     * @Description
     * @param map 传递的参数为角色id id
     * @return
     */
    List<Rule> selectRulePermission(Map<String,Object> map);
    /**
             * 查询所有的角色名字
     * @Description
     * @return
     */
    List<Rule> selectRuleName();
    /**
     * 根据雇员id查询角色
     * @Description
     * @param map
     * @return
     */
    List<Rule> selectRuleByEid(Map<String, Object> map);
}
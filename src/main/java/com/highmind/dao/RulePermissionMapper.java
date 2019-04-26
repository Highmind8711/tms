package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.RulePermission;

public interface RulePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RulePermission record);

    int insertSelective(RulePermission record);

    RulePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RulePermission record);

    int updateByPrimaryKey(RulePermission record);
    
    List<RulePermission> selectRulePermission(Map<String,Object> map);
    
    /**
     * 根据角色id删除全部权限
     * @Description
     * @param Eid
     * @return
     */
    int deleteByRid(Long Rid);
}
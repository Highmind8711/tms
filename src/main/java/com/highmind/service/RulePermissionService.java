package com.highmind.service;

import java.util.List;

import com.highmind.entity.RulePermission;

/**
 * @ClassName RulePermissionService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:37:30
 * @version 1.0.0
 */
public interface RulePermissionService extends BaseService<RulePermission>{
    /**
     * 批量添加角色权限
     * @Description
     * @param rulePermissions
     * @return
     */
    int addRulePermissions(List<RulePermission> rulePermissions);
}

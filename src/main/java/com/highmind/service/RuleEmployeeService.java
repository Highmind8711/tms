package com.highmind.service;

import java.util.List;

import com.highmind.entity.RuleEmployee;


/**
 * @ClassName RuleEmployeeService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:37:12
 * @version 1.0.0
 */
public interface RuleEmployeeService extends BaseService<RuleEmployee>{
    /**
     * 批量添加角色雇员
     * @Description
     * @param rulePermissions
     * @return
     */
    int addRuleEmployees(List<RuleEmployee> ruleEmployees);
}

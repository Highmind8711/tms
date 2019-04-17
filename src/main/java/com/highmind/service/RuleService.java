package com.highmind.service;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Rule;

/**
 * @ClassName RuleService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:36:40
 * @version 1.0.0
 */
public interface RuleService extends BaseService<Rule>{
    /**
         * 查询所有的角色名字
    * @Description
    * @return
    */
    List<Rule> selectRuleName();
    /**
     * 查询角色下的权限
     * @Description
     * @return
     */
    List<Rule> selectRulePermission(Map<String,Object> map);
}

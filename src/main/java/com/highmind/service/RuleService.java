/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service
 *
 *    Filename:    RuleService.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月3日 上午11:36:40
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:36:40
 *        - first revision
 *
 *****************************************************************/
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

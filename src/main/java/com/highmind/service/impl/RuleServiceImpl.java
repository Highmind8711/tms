/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    RuleServiceImpl.java
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
 *    Create at:   2019年4月3日 下午1:07:42
 *
 *    Revision:
 *
 *    2019年4月3日 下午1:07:42
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.RuleMapper;
import com.highmind.entity.Rule;
import com.highmind.service.RuleService;

/**
 * @ClassName RuleServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:07:42
 * @version 1.0.0
 */
@Service
public  class RuleServiceImpl implements RuleService{
    @Autowired
    RuleMapper ruleMapper;

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Rule selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return ruleMapper.selectRule(map).get(0);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Rule> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> hashMap = new HashMap<String,Object>();
        return ruleMapper.selectRule(hashMap);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(Rule record) {
        // TODO Auto-generated method stub
        return ruleMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Rule record) {
        // TODO Auto-generated method stub
        return ruleMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return ruleMapper.deleteByPrimaryKey(id);
    }

    

}

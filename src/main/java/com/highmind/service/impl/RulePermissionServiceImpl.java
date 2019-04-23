package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.RulePermissionMapper;
import com.highmind.entity.RulePermission;
import com.highmind.service.RulePermissionService;

/**
 * @ClassName RulePermissionServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:07:01
 * @version 1.0.0
 */
@Service
public class RulePermissionServiceImpl implements RulePermissionService{
    @Autowired
    RulePermissionMapper rulePermissionMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public RulePermission selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return rulePermissionMapper.selectRulePermission(map).get(0);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<RulePermission> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String,Object>();
        return rulePermissionMapper.selectRulePermission(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(RulePermission record) {
        // TODO Auto-generated method stub
        return rulePermissionMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(RulePermission record) {
        // TODO Auto-generated method stub
        return rulePermissionMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return rulePermissionMapper.deleteByPrimaryKey(id);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.RulePermissionService#addRulePermissions(java.util.List)
     */
    @Override
    public int addRulePermissions(List<RulePermission> rulePermissions) {
        // TODO Auto-generated method stub
        for(RulePermission rulePermission:rulePermissions) {
            int result=rulePermissionMapper.insertSelective(rulePermission);
            if(result==0) {
                return 0;
            }
        }
        return 1;
    }

}

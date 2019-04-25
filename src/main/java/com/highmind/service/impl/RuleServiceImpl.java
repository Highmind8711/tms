package com.highmind.service.impl;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.PermissionMenuMapper;
import com.highmind.dao.PermissionOperationMapper;
import com.highmind.dao.RuleMapper;
import com.highmind.entity.Permission;
import com.highmind.entity.PermissionMenu;
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
    @Autowired
    PermissionMenuMapper permissionMenuMapper;
    @Autowired
    PermissionOperationMapper permissionOperationMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Rule selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Rule> selectRule = ruleMapper.selectRuleEmployee(map);
        return selectRule.size()!=0?selectRule.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Rule> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> hashMap = new HashMap<String,Object>();
        return ruleMapper.selectRuleEmployee(hashMap);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public Long add(Rule record) {
        // TODO Auto-generated method stub
        return (long) ruleMapper.insertSelective(record);
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

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.RuleService#selectRuleName()
     */
    @Override
    public List<Rule> selectRuleName() {
        // TODO Auto-generated method stub
        return ruleMapper.selectRuleName();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.RuleService#selectRulePermission()
     */
    @Override
    public List<Rule> selectRulePermission(Map<String,Object> map) {
        // TODO Auto-generated method stub
        List<Rule> rules=ruleMapper.selectRulePermission(map);
        for(Rule rule:rules) {
            List<Permission> permissions = rule.getPermissions();
            if(!permissions.isEmpty()) {
                for(Permission permission:permissions) {
                    /*
                     * if(permission.getType().equals("1")) { Map<String,Object> tempMap=new HashMap<String,Object>();
                     * tempMap.put("id", permission.getId()); List<PermissionOperation> permissionOperations =
                     * permissionOperationMapper.selectPermissionOperation(tempMap); PermissionOperation
                     * permissionOperation=permissionOperations.size()!=0?permissionOperations.get(0):null;
                     * permission.setOperation(permissionOperation.getOperation()); }else
                     */if(permission.getType().equals("2")) {
                        Map<String,Object> tempMap=new HashMap<String,Object>();
                        tempMap.put("id", permission.getId());
                        List<PermissionMenu> selectPermissionMenu = permissionMenuMapper.selectPermissionMenu(tempMap);
                        PermissionMenu permissionMenu=selectPermissionMenu.size()!=0?selectPermissionMenu.get(0):null;
                        if(permissionMenu!=null) {
                            permission.setMenu(permissionMenu.getMenu());
                        }
                        

                       

                    }
                }
            }
            
        }
        return rules;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.RuleService#selectRuleByEid(java.util.Map)
     */
    @Override
    public Set<String> selectRuleByEid(Map<String, Object> map) {
        // TODO Auto-generated method stub
        Set<String> ruleseSet= new HashSet<String>();
        List<Rule> rules=ruleMapper.selectRuleByEid(map);
        for(Rule rule:rules) {
            ruleseSet.add(rule.getRulename());
        }
        return ruleseSet;
    }

    

}

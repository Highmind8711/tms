package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.RuleEmployeeMapper;
import com.highmind.entity.RuleEmployee;
import com.highmind.service.RuleEmployeeService;

/**
 * @ClassName RuleEmployeeServiceimpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:06:25
 * @version 1.0.0
 */
@Service
public class RuleEmployeeServiceImpl implements RuleEmployeeService{
    @Autowired
    RuleEmployeeMapper ruleEmployeeMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public RuleEmployee selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return ruleEmployeeMapper.selectRuleEmployee(map).get(0);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<RuleEmployee> selectAll() {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        return ruleEmployeeMapper.selectRuleEmployee(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(RuleEmployee record) {
        // TODO Auto-generated method stub
        return ruleEmployeeMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(RuleEmployee record) {
        // TODO Auto-generated method stub
        return ruleEmployeeMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return ruleEmployeeMapper.deleteByPrimaryKey(id);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.RuleEmployeeService#addRuleEmployees(java.util.List)
     */
    @Override
    public int addRuleEmployees(List<RuleEmployee> ruleEmployees) {
        // TODO Auto-generated method stub
       for(RuleEmployee ruleEmployee:ruleEmployees) {
           int result=ruleEmployeeMapper.insertSelective(ruleEmployee);
           if(result==0) {
               return 0;
           }
       }
        return 1;
    }



}

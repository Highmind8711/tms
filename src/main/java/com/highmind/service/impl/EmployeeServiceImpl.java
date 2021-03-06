package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.EmployeeMapper;
import com.highmind.dao.RuleEmployeeMapper;
import com.highmind.entity.Employee;
import com.highmind.entity.RuleEmployee;
import com.highmind.service.EmployeeService;

/**
 * @ClassName EmployeeServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:02:37
 * @version 1.0.0
 */
@Service
public  class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RuleEmployeeMapper ruleEmployeeMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Employee selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Employee> selectEmployee = employeeMapper.selectEmployee(map);
        return selectEmployee.size()!=0?selectEmployee.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Employee> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> hashMap = new HashMap<String,Object>();
        return employeeMapper.selectEmployee(hashMap);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(Employee record) {
        // TODO Auto-generated method stub
        return employeeMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Employee record) {
        // TODO Auto-generated method stub
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return employeeMapper.deleteByPrimaryKey(id);
    }


    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.EmployeeService#addRoleForEmployee(java.util.Map)
     */
    @Override
    public int addRoleForEmployee(Map<String, Object> map) {
        // TODO Auto-generated method stub
        String rid=map.get("rid").toString();
        String eid=map.get("eid").toString();
        RuleEmployee ruleEmployee = new RuleEmployee();
        ruleEmployee.setEmployee_id(Long.valueOf(eid));
        ruleEmployee.setRule_id(Long.valueOf(rid));
        return ruleEmployeeMapper.insertSelective(ruleEmployee);
    }

    @Override
    public Employee checkUser(Map<String, Object> map) {
        List<Employee> employees = employeeMapper.selectEmployee(map);
        if(employees.isEmpty()){
            return null;
        }else{
            return employees.get(0);
        }
    }
}

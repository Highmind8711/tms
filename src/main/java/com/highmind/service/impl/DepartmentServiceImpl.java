package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.DepartmentMapper;
import com.highmind.entity.Department;
import com.highmind.service.DepartmentService;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:01:06
 * @version 1.0.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentMapper departmentMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Department selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Department> selectDepartment = departmentMapper.selectDepartment(map);
        return selectDepartment.size()!=0?selectDepartment.get(0):null;
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Department> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> hashMap = new HashMap<String,Object>();
        return departmentMapper.selectDepartment(hashMap);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(Department record) {
        // TODO Auto-generated method stub
        return departmentMapper.insertSelective(record);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Department record) {
        // TODO Auto-generated method stub
        return departmentMapper.updateByPrimaryKeySelective(record);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return departmentMapper.deleteByPrimaryKey(id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.DepartmentService#selectDepartmentName()
     */
    @Override
    public List<Department> selectDepartmentName() {
        // TODO Auto-generated method stub
        return departmentMapper.selectDepartmentName();
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.DepartmentService#findAllRecursion()
     */
    @Override
    public List<Department> findAllRecursion() {
        // TODO Auto-generated method stub
        return departmentMapper.findAllRecursion();
    }

    @Override
    public List<Department> findRoot(){
        return departmentMapper.findRoot();
    }

    @Override
    public List<Department> findChild(Long id){
        return departmentMapper.findChild(id);
    }

}

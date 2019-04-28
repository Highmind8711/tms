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
    public List<Department> selectAll(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return departmentMapper.selectDepartment(map);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public Long add(Department record) {
        // TODO Auto-generated method stub
        return (long) departmentMapper.insertSelective(record);
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
     * Description:删除部门下如果有子部门不允许删除
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        if(findChild(id).isEmpty()) {
            return departmentMapper.deleteByPrimaryKey(id);
        }else {
            return 0;
        }
        
        
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.DepartmentService#selectDepartmentName()
     */
    @Override
    public List<Department> selectDepartmentName(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return departmentMapper.selectDepartmentName(map);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.DepartmentService#findAllRecursion()
     */
    @Override
    public List<Department> findAllRecursion(Map<String, Object> map) {
        // TODO Auto-generated method stub
        //System.out.println(map.get("domainid")+"测试");
        return departmentMapper.findAllRecursion(map);
    }

    @Override
    public List<Department> findRoot(Map<String, Object> map){
        return departmentMapper.findRoot(map);
    }

    @Override
    public List<Department> findChild(Long id){
        return departmentMapper.findChild(id);
    }

}

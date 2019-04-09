package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    

    /**
     * @Description
     * @param hashMap
     * @return
     */
    List<Department> selectDepartment(Map<String, Object> hashMap);
    /**
     * 查询所有的部门名字
     * @Description
     * @return
     */
    List<Department> selectDepartmentName();
}
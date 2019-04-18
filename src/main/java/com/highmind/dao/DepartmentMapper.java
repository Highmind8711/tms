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
    List<Department> selectDepartmentName(Map<String, Object> hashMap);
    /**
     *遍历所有的部门
     * @Description
     * @return
     */
    List<Department> findAllRecursion(Map<String, Object> hashMap);
    /**
     * 查询根节点
     * @Description
     * @return
     */
    List<Department> findRoot(Map<String, Object> hashMap);
    /**
     * 查询根节点下的子节点
     * @Description
     * @return
     */
    List<Department> findChild(Long id);
}
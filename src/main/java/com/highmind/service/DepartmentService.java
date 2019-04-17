package com.highmind.service;


import java.util.List;

import com.highmind.entity.Department;

/**
 * @ClassName DepartmentService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:28:35
 * @version 1.0.0
 */
public interface DepartmentService extends BaseService<Department>{
    /**
     * 查询所有部门的名字
     * @Description
     * @return
     */
    List<Department> selectDepartmentName();
    /**
     * 递归查询全部部门
     * @Description
     * @return
     */
   List<Department> findAllRecursion();
    
    /**
         * 查询根节点
     * @Description
     * @return
     */
    List<Department> findRoot();
    /**
         * 查询根节点下的子节点
     * @Description
     * @return
     */
    List<Department> findChild(Long id);

}

/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service
 *
 *    Filename:    DepartmentService.java
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
 *    Create at:   2019年4月3日 上午11:28:35
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:28:35
 *        - first revision
 *
 *****************************************************************/
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
    public List<Department> selectDepartmentName();
    /**
     * 递归查询全部部门
     * @Description
     * @return
     */
    public List<Department> findAllRecursion();
    
    /**
         * 查询根节点
     * @Description
     * @return
     */
    public List<Department> findRoot();
    /**
         * 查询根节点下的子节点
     * @Description
     * @return
     */
    public List<Department> findChild(Long id);

}

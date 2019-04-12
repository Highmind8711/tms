package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /**
     *
     * @param map 参数为id ，loginid，或者loginId
     * @return
     */
    List<Employee> selectEmployee(Map<String,Object> map);
}
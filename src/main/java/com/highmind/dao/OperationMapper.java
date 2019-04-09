package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Operation;

public interface OperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
    
    List<Operation> selectOperation(Map<String,Object> map);
}
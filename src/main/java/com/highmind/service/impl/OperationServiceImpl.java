package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.OperationMapper;
import com.highmind.entity.Operation;
import com.highmind.service.OperationService;

/**
 * @ClassName OperationServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:03:51
 * @version 1.0.0
 */
@Service
public class OperationServiceImpl implements OperationService{
    @Autowired
    OperationMapper operationMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Operation selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Operation> selectOperation = operationMapper.selectOperation(map);
        return selectOperation.size()!=0?selectOperation.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Operation> selectAll() {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        return operationMapper.selectOperation(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public Long add(Operation record) {
        // TODO Auto-generated method stub
        return (long) operationMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Operation record) {
        // TODO Auto-generated method stub
        return operationMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return operationMapper.deleteByPrimaryKey(id);
    }

}

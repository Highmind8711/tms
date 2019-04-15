package com.highmind.dao;

import com.highmind.entity.TicketEmployee;
import java.util.List;
import java.util.Map;

public interface TicketEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketEmployee record);

    int insertSelective(TicketEmployee record);

    List<TicketEmployee> selectTicketEmployee(Map<String, Object> hashMap);

    TicketEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketEmployee record);

    int updateByPrimaryKey(TicketEmployee record);
}
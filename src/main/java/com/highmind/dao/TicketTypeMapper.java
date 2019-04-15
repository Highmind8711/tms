package com.highmind.dao;

import com.highmind.entity.TicketType;
import java.util.List;
import java.util.Map;

public interface TicketTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketType record);

    int insertSelective(TicketType record);

    List<TicketType> selectTicketType(Map<String, Object> hashMap);

    TicketType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketType record);

    int updateByPrimaryKey(TicketType record);
}
package com.highmind.dao;

import com.highmind.entity.Ticket;
import java.util.List;
import java.util.Map;

public interface TicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectTicket(Map<String, Object> hashMap);

    Ticket selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}
package com.highmind.dao;

import com.highmind.entity.AgencyTicket;
import java.util.List;
import java.util.Map;

public interface AgencyTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AgencyTicket record);

    int insertSelective(AgencyTicket record);

    List<AgencyTicket> selectAgencyTicket(Map<String, Object> hashMap);

    AgencyTicket selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgencyTicket record);

    int updateByPrimaryKey(AgencyTicket record);
}
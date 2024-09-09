package com.room.room.rooms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.room.room.rooms.service.RoomsService;

@Mapper
public class RoomsMapper {
 
    @Autowired
    private RoomsService roomsService;
}

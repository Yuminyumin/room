package com.room.room.rooms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.room.rooms.dao.RoomsMapper;
import com.room.room.rooms.domain.RoomsRequestDTO;
import com.room.room.rooms.domain.RoomsResponseDTO;

@Service
public class RoomsService {
    
    @Autowired
    private RoomsMapper roomsMapper;

    public void create(RoomsRequestDTO params){
        System.out.println("debug >>> service create " + roomsMapper);
        roomsMapper.insertRow(params);
    }

    public RoomsResponseDTO find(Map<String, Integer> map){
        System.out.println("debug >>> service find "+ roomsMapper);
        RoomsResponseDTO result = roomsMapper.findRow(map);
        return result;
    }

    public void delete(Map<String, Integer> map){
        System.out.println("debug >>> service delete "+ roomsMapper);
        roomsMapper.deleteRow(map);
    }
}

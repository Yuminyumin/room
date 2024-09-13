package com.room.room.rooms.service;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.room.rooms.dao.RoomsMapper;
import com.room.room.rooms.domain.RoomsRequestDTO;
import com.room.room.rooms.domain.RoomsResponseDTO;

@Service
public class RoomsService {
    
    @Autowired
    private RoomsMapper roomsMapper;

    public List<RoomsResponseDTO> findAll(){
        System.out.println("debug >>> service findAll " + roomsMapper);
        return roomsMapper.findAllRow();
    }

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

    public void update(RoomsRequestDTO params){
        System.out.println("debug >>> service update "+ roomsMapper);
        roomsMapper.updateRow(params);
    }
}

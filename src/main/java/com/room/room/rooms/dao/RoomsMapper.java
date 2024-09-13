package com.room.room.rooms.dao;

import java.util.Map;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.room.room.rooms.domain.RoomsRequestDTO;
import com.room.room.rooms.domain.RoomsResponseDTO;

@Mapper
public interface RoomsMapper {
   public List<RoomsResponseDTO> findAllRow();
   public void                   insertRow(RoomsRequestDTO params);
   public RoomsResponseDTO       findRow(Map<String, Integer> map);
   public void                   deleteRow(Map<String, Integer> map);
   public void                   updateRow(RoomsRequestDTO params);
}

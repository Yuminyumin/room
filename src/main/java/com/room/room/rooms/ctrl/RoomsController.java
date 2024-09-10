package com.room.room.rooms.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.room.rooms.domain.RoomsRequestDTO;
import com.room.room.rooms.domain.RoomsResponseDTO;
import com.room.room.rooms.service.RoomsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody RoomsRequestDTO params) {
        System.out.println("client endpoint : /rooms/save");
        System.out.println("params : "+ params);
        roomsService.create(params);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<RoomsResponseDTO> view(@PathVariable(name="id") Integer id) {
        System.out.println("client endpoint : /rooms/view");
        System.out.println("params : "+ id);

        Map<String ,Integer> map = new HashMap<>();
        map.put("id",id);

        RoomsResponseDTO result = roomsService.find(map);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id){
        System.out.println("client endpoint : /rooms/delete");
        System.out.println("params : "+ id);

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        roomsService.delete(map);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

package com.room.room.rooms.ctrl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping("/index")
    public ResponseEntity<Object> landing() {
        System.out.println("client endpoint : /rooms/index " + roomsService);
        
        List<RoomsResponseDTO> list = roomsService.findAll();
        System.out.println("result size = "+ list.size());
        if(list.size() == 0){
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다.");
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody RoomsRequestDTO params) {
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

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody RoomsRequestDTO params) {
        System.out.println("client endpoint : /rooms/update");
        System.out.println("params : "+ params);
        
        roomsService.update(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

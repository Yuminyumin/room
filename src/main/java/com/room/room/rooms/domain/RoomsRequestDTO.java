package com.room.room.rooms.domain;

import lombok.Data;

@Data
public class RoomsRequestDTO {
    private Integer id;
    private String  title;
    private String  content;
    private String  memo;
    private String  tel;
}

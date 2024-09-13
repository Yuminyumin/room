package com.room.room.rooms.domain;

import lombok.Data;

@Data
public class RoomsResponseDTO {
    private Long id;
    private String  title;
    private String  content;
    private String  memo;
    private String  tel;
}

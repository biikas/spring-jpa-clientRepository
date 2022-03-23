package com.bikash.springjpa.dto;

import lombok.*;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDTO {

    private int id;
    private char active;
    private String name;
    private String username;
    private String password;
    private Date date_recorded;
}
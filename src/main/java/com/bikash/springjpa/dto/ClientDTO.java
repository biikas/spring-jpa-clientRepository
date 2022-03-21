package com.bikash.springjpa.dto;

import lombok.*;
import org.springframework.stereotype.Component;

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
}

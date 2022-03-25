package com.bikash.springjpa.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiDataDTO {

    private Integer id;
    private String api_name;
    private String api_data;
    private Integer Client_id;
}
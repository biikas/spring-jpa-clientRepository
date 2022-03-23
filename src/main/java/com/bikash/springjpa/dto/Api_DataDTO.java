package com.bikash.springjpa.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Api_DataDTO {

    private Integer id;
    private String api_name;
    private String api_data;
    private Integer Client_id;
}
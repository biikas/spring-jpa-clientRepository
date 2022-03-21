package com.bikash.springjpa.controller;

import com.bikash.springjpa.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private boolean success;
    private String message;
    private int code;
    private String clientName;
    public Response(boolean success,String message){
        this.success=success;
        this.message=message;
    }


}

package com.bikash.springjpa.controller.ResponseMessage;

import com.bikash.springjpa.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse{
    private boolean success;
    private String message;
    private int code;
    private List<ClientResponse> list;}

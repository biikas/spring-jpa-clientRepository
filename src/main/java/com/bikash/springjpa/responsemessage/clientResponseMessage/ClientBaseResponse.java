package com.bikash.springjpa.responsemessage.clientResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientBaseResponse {
    private boolean success;
    private String message;
    private int code;
    private List<ClientResponse> list;}

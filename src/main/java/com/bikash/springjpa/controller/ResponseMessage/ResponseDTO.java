package com.bikash.springjpa.controller.ResponseMessage;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private boolean success;
    private String message;
    private int code;
    private ClientResponse clientResponse;
    //private Map<String,String> clientDetails;





}

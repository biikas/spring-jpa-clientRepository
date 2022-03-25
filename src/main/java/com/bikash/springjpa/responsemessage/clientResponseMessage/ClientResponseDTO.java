package com.bikash.springjpa.responsemessage.clientResponseMessage;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private boolean success;
    private String message;
    private int code;
    private ClientResponse clientResponse;
    //private Map<String,String> clientDetails;





}

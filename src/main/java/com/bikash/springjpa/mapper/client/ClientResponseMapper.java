package com.bikash.springjpa.mapper.client;

import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponseDTO;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.utility.DateUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientResponseMapper {

    public static ClientResponseDTO convertToClientSuccessResponse(Client client) {
        ClientResponse clientResponse =new ClientResponse();
        clientResponse.setName(client.getName());
        DateUtility dateUtility =new DateUtility();
        String d = String.valueOf(client.getDate_recorded());
        clientResponse.setDateCreated(dateUtility.formatDate(d));
        return new ClientResponseDTO(true, "client created successfully", 1,clientResponse);
    }

    public static ClientResponseDTO convertToClientFailureResponse(Client client) {
        ClientResponse clientResponse  =new ClientResponse();
        return new ClientResponseDTO(false,"client already exists",0,null);
    }

}

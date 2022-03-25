package com.bikash.springjpa.mapper.client;

import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientBaseResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponseDTO;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.utility.DateUtility;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRequestMapper {
    public static ClientResponseDTO responseToClientById(Client client){
        ClientResponse clientResponse =new ClientResponse();
        clientResponse.setName(client.getName());
        DateUtility dateUtility = new DateUtility();
        String d = String.valueOf(client.getDate_recorded());
        clientResponse.setDateCreated(dateUtility.formatDate(d));
        return new ClientResponseDTO(true,"client created successfully",1,clientResponse);

    }
    public static ClientBaseResponse responseToGetAllClient(List<Client> client){
        ClientBaseResponse baseResponse =new ClientBaseResponse();
        List<ClientResponse> list =new ArrayList<>();
        DateUtility dateUtility = new DateUtility();

//        for(Client c1:client){
//            DateUtility dateUtility = new DateUtility();
//            String d = String.valueOf(c1.getDate_recorded());
//            list.add(new ClientResponse(c1.getName(),dateUtility.formatDate(d)));
//        }
        client.forEach(c-> list.add(new ClientResponse(c.getName(), dateUtility.formatDate(String.valueOf(c.getDate_recorded())))));

        baseResponse.setList(list);
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Client successfully added");
        baseResponse.setCode(1);

        return  baseResponse;

    }
}

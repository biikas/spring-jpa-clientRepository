package com.bikash.springjpa.mapper.client;

import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ClientMapper {


    @Autowired
    private ClientRepository clientRepository;

    public Client convertToSaveClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setActive('Y');
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());
        client.setDate_recorded(new Date());

        return client;
    }

    public List<ClientDTO>convertToClient(List<Client> clients) {
        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Client client : clients) {

            ClientDTO clientDTO = new ClientDTO();

            client.setId(client.getId());
            client.setName(client.getName());
            client.setActive(client.getActive());
            client.setUsername(client.getUsername());
            client.setPassword(client.getPassword());
            client.setDate_recorded(client.getDate_recorded());

            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }

    public Client ConvertToGetByClientID(int id) {
        Client client = clientRepository.getById(id);
        //Client client = new Client();
        client.setId(client.getId());
        client.setName(client.getName());
        client.setActive(client.getActive());
        client.setUsername(client.getUsername());
        client.setPassword(client.getPassword());
        client.setDate_recorded(client.getDate_recorded());

        return client;
    }

    public Client ConvertToUpdateClient(ClientDTO clientDTO, int id) {
        Client client = clientRepository.getById(id);
        log.info(""+client);
        client.setName(clientDTO.getName());
        //client.setActive(clientDTO.getActive());
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());

        return client;
    }
    public Client convertToChangeStatus(ClientDTO clientDTO,int id){
            Client client = clientRepository.getById(id);
            //client.setActive(clientDTO.getActive());
            return client;
    }

    public Client convertToClientUpdate(ClientDTO clientDTO,int id){
        Client client =clientRepository.getById(id);
        client.setName(clientDTO.getName());
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());
//        clientRepository.save(client);
        return client;
    }
    public List<Client> convertToGetAllClient() {
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }
}

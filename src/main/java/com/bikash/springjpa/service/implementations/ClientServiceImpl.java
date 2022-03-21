package com.bikash.springjpa.service.implementations;

import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ClientRepository;
import com.bikash.springjpa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public boolean saveClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setActive(clientDTO.getActive());
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());
        client.setRecorded_date(new Date());

        clientRepository.save(client);

        return true;
    }

    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> clients = clientRepository.findAll();

        return getClientDTOS(clients);
    }

    @Override
    public ClientDTO getClient(int id) {
        Client client = clientRepository.getById(id);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setActive(client.getActive());
        clientDTO.setUsername(client.getUsername());
        clientDTO.setPassword(client.getPassword());

        return clientDTO;
    }


    @Override
    public List<ClientDTO> getClientByActive(char active) {
        List<Client> clients = clientRepository.findClientByActive(active);
        return getClientDTOS(clients);
    }

    private List<ClientDTO> getClientDTOS(List<Client> clients) {
        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Client client : clients) {

            ClientDTO clientDTO = new ClientDTO();
//            char c = client.getActive();
            clientDTO.setId(client.getId());
            clientDTO.setName(client.getName());
            clientDTO.setActive(client.getActive());
            clientDTO.setUsername(client.getUsername());
            clientDTO.setPassword(client.getPassword());
            clientDTOList.add(clientDTO);
            }

        return clientDTOList;
    }

    @Override
    public boolean updateClient(ClientDTO clientDTO, int id) {
        Client client = clientRepository.getById(id);
        client.setName(clientDTO.getName());
        //client.setActive(clientDTO.getActive());
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());

        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean changeStatus(ClientDTO clientDTO, int id) {
        Client client = clientRepository.getById(id);
        client.setActive(clientDTO.getActive());
        clientRepository.save(client);
        return true;
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }


}

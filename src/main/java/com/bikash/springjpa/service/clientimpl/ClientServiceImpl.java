package com.bikash.springjpa.service.clientimpl;

import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientBaseResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponseDTO;
import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.mapper.client.ClientMapper;
import com.bikash.springjpa.mapper.client.ClientRequestMapper;
import com.bikash.springjpa.mapper.client.ClientResponseMapper;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ClientRepository;
import com.bikash.springjpa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;


    //done
    @Override
    public ClientResponseDTO saveClient(ClientDTO clientDTO) throws Exception {


        Client existingClient = clientRepository.findByUsername(clientDTO.getUsername());
        if (existingClient != null) {
            Client client = getClientByUsername(clientDTO.getUsername());
//            return ClientResponseMapper.convertToClientFailureResponse(client);
            throw new Exception("Username already exists");

        } else {
            log.info("data ready for saving");
            clientRepository.save(clientMapper.convertToSaveClient(clientDTO));
            log.info("data saved successfully");
            Client client = getClientByUsername(clientDTO.getUsername());
            return ClientResponseMapper.convertToClientSuccessResponse(client);
        }
    }
    //done
    @Override
    public ClientBaseResponse getAllClient() {
        return  ClientRequestMapper.responseToGetAllClient(clientMapper.convertToGetAllClient());
    }
    //done
    @Override
    public ClientResponseDTO getClient(int id) {
        return ClientRequestMapper.responseToClientById((clientMapper.ConvertToGetByClientID(id)));
    }


    public ClientBaseResponse getClientByActive(char active) {
        List<Client> clients = clientRepository.findClientByActive(active);
        return ClientRequestMapper.responseToGetAllClient(clients);
    }
    //done
    @Override
    public ClientResponseDTO updateClient(ClientDTO clientDTO, int id) {
        clientRepository.save(clientMapper.ConvertToUpdateClient(clientDTO,id));
        Client client = getClientByUsername(clientDTO.getUsername());
        return ClientResponseMapper.convertToClientSuccessResponse(client);
    }

    @Override
    public boolean changeStatus(ClientDTO clientDTO, int id) {
        clientRepository.save(clientMapper.convertToChangeStatus(clientDTO, id));
        return true;
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }
}

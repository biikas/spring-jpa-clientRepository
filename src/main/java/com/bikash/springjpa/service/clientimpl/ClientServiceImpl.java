package com.bikash.springjpa.service.clientimpl;

import com.bikash.springjpa.controller.ResponseMessage.BaseResponse;
import com.bikash.springjpa.controller.ResponseMessage.ResponseDTO;
import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.mapper.client.ClientMapper;
import com.bikash.springjpa.mapper.client.RequestMapper;
import com.bikash.springjpa.mapper.client.ResponseMapper;
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
    public ResponseDTO saveClient(ClientDTO clientDTO) {

        Client existingClient = clientRepository.findByUsername(clientDTO.getUsername());
        if (existingClient != null) {
            log.info("data already exists");
            Client client = getClientByUsername(clientDTO.getUsername());
            return ResponseMapper.convertToClientFailureResponse(client);
        } else {
            log.info("data ready for saving");
            clientRepository.save(clientMapper.convertToSaveClient(clientDTO));
            log.info("data saved successfully");
            Client client = getClientByUsername(clientDTO.getUsername());
            return ResponseMapper.convertToClientSuccessResponse(client);
        }
    }
    //done
    @Override
    public BaseResponse getAllClient() {
        return  RequestMapper.responseToGetAllClient(clientMapper.convertToGetAllClient());
    }
    //done
    @Override
    public ResponseDTO getClient(int id) {
        return RequestMapper.responseToClientById((clientMapper.ConvertToGetByClientID(id)));
    }


    public BaseResponse getClientByActive(char active) {
        List<Client> clients = clientRepository.findClientByActive(active);
        return RequestMapper.responseToGetAllClient(clients);
    }
    //done
    @Override
    public ResponseDTO updateClient(ClientDTO clientDTO, int id) {
        clientRepository.save(clientMapper.ConvertToUpdateClient(clientDTO,id));
        Client client = getClientByUsername(clientDTO.getUsername());
        return ResponseMapper.convertToClientSuccessResponse(client);
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

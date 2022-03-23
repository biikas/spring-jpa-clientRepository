package com.bikash.springjpa.service;

import com.bikash.springjpa.controller.ResponseMessage.BaseResponse;
import com.bikash.springjpa.controller.ResponseMessage.ResponseDTO;
import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;

public interface ClientService {
    ResponseDTO saveClient(ClientDTO clientDTO);

    BaseResponse getAllClient();

    ResponseDTO getClient(int id);

    BaseResponse getClientByActive(char active);

    public Client getClientByUsername(String username);

    public ResponseDTO updateClient(ClientDTO clientDTO, int id);

    public boolean changeStatus(ClientDTO clientDTO, int id);

}

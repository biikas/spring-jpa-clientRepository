package com.bikash.springjpa.service;

import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientBaseResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponseDTO;
import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;

public interface ClientService {
    ClientResponseDTO saveClient(ClientDTO clientDTO);

    ClientBaseResponse getAllClient();

    ClientResponseDTO getClient(int id);

    ClientBaseResponse getClientByActive(char active);

    public Client getClientByUsername(String username);

    public ClientResponseDTO updateClient(ClientDTO clientDTO, int id);

    public boolean changeStatus(ClientDTO clientDTO, int id);

}

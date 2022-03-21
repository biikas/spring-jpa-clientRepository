package com.bikash.springjpa.service;

import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;


import java.util.List;

public interface ClientService {
    boolean saveClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClient();

    ClientDTO getClient(int id);

    List<ClientDTO> getClientByActive(char active);

    boolean updateClient(ClientDTO clientDTO, int id);

    boolean changeStatus(ClientDTO clientDTO, int id);
    Client getClientByUsername(String username);

}

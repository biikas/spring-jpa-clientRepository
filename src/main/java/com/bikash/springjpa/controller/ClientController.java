package com.bikash.springjpa.controller;

import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "add")
    public ResponseEntity<Response> addStudent(@RequestBody ClientDTO clientDTO) {
        Client existingClient = clientService.getClientByUsername(clientDTO.getUsername());
        if (existingClient != null) {
            return new ResponseEntity<>(new Response(false, clientDTO.getUsername() + " username already exists", 0, clientDTO.getUsername()), HttpStatus.BAD_REQUEST);
        } else {
            clientService.saveClient(clientDTO);
            return new ResponseEntity<>(new Response(true, "client added successfully " + clientDTO.getUsername(), 1, clientDTO.getUsername()), HttpStatus.OK);
        }
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Response> updateStudent(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(clientDTO, id);
        log.info("updated successfully");
        return new ResponseEntity<>(new Response(true,"client updated successfully",1,clientDTO.getUsername()),HttpStatus.OK);
    }

    @PutMapping(value = "changestatus/{id}")
    public void changeStatus(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        clientService.changeStatus(clientDTO, id);
        log.info("Status changed successfully");
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        List<ClientDTO> clients = clientService.getAllClient();
        return ResponseEntity.ok(clients);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable int id) {
        ClientDTO client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping(value = "home")
    public ResponseEntity<String> welcome() {
        String s = "WELCOME";
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping(value = "activeclient")
    public ResponseEntity<List<ClientDTO>> getActive() {
        List<ClientDTO> clients = clientService.getClientByActive('Y');
        return ResponseEntity.ok(clients);
    }

}

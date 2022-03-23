package com.bikash.springjpa.controller;


import com.bikash.springjpa.controller.ResponseMessage.BaseResponse;
import com.bikash.springjpa.controller.ResponseMessage.ResponseDTO;
import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.mapper.client.ResponseMapper;

import com.bikash.springjpa.service.ClientService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ResponseMapper responseMapper;


    @PostMapping(value = "add")
    public ResponseDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }


    @PutMapping(value = "update/{id}")
    public ResponseDTO updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO,id);
    }

    @PutMapping(value = "change/status/{id}")
    public boolean changeStatus(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        log.info("Status changed successfully");
        return clientService.changeStatus(clientDTO,id);

    }

    @GetMapping(value = "list")
    public BaseResponse getAllClient() {
        return (BaseResponse) clientService.getAllClient();}

    @GetMapping(value = "/{id}")
    public ResponseDTO getById(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @GetMapping(value = "active/client")
    public BaseResponse getActive() {
        return  clientService.getClientByActive('Y');
    }
}

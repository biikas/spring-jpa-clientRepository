package com.bikash.springjpa.controller;


import com.bikash.springjpa.dto.Api_DataDTO;
import com.bikash.springjpa.model.Api_Data;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.service.ApiDataService;
import com.bikash.springjpa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "data")
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @Autowired
    private ClientService clientService;

    @PostMapping(value="add/{username}")
    public void addApiData(@PathVariable String username, @RequestBody Api_DataDTO api_dataDTO){
        Client client =clientService.getClientByUsername(username);
        apiDataService.saveApiData(api_dataDTO,client);
    }

}

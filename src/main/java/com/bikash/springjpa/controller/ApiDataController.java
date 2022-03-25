package com.bikash.springjpa.controller;


import com.bikash.springjpa.responsemessage.ApiDataResponseMessage.ApiBaseRespons;
import com.bikash.springjpa.dto.ApiDataDTO;
import com.bikash.springjpa.model.ApiData;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.service.ApiDataService;
import com.bikash.springjpa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "data")
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @Autowired
    private ClientService clientService;

    @PostMapping(value="add")
    public boolean addApiData(@PathVariable String username, @RequestBody ApiDataDTO api_dataDTO){
        Client client =clientService.getClientByUsername(username);
        apiDataService.saveApiData(api_dataDTO,client);
        return true;
    }
    @PutMapping(value ="update/{username}")
    public void updateApiData(@PathVariable String username,@RequestBody ApiDataDTO api_dataDTO){
        log.info("checking");
        Client client =clientService.getClientByUsername(username);
        log.info("some message");
       apiDataService.updateApiData(api_dataDTO,client);
    }
    @GetMapping(value = "list")
    public List<ApiData> listApiData(){
        log.info("ready to display the list");
        return apiDataService.getAllApiData();
    }
    @GetMapping(value = "list/{username}")
    public ApiBaseRespons usernameApiData(@PathVariable String username){
        log.info("username api data ready to be fetched");
        Client client =clientService.getClientByUsername(username);
//        return (Api_Data) apiDataService.getApiDataUser(client);
       // return apiDataService.getApiDataUser(client);
        return (ApiBaseRespons) apiDataService.getApiDataUser(client);

    }
}

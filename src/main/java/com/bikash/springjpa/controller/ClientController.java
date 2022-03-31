package com.bikash.springjpa.controller;


import com.bikash.springjpa.dto.ClientDTO;
import com.bikash.springjpa.mapper.client.ClientResponseMapper;
import com.bikash.springjpa.repository.TokenRepository;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientBaseResponse;
import com.bikash.springjpa.responsemessage.clientResponseMessage.ClientResponseDTO;
import com.bikash.springjpa.service.ClientService;
import jdk.nashorn.internal.parser.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientResponseMapper responseMapper;

    @Autowired
    private TokenRepository tokenRepository;

    protected String token;


//    @PostMapping(value = "add")
//    public ClientResponseDTO addClient(@RequestBody ClientDTO clientDTO) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("token","token value");
//        return clientService.saveClient(clientDTO);
//    }
    @PostMapping(value="add")
    public ResponseEntity<ClientResponseDTO> addClient(@RequestBody ClientDTO clientDTO) throws Exception {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.AUTHORIZATION, "mhbjh");
        return new ResponseEntity<>((clientService.saveClient(clientDTO)),headers, HttpStatus.OK);
    }


    @PutMapping(value = "update/{id}")
    public ClientResponseDTO updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO,id);
    }

    @PutMapping(value = "change/status/{id}")
    public boolean changeStatus(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        log.info("Status changed successfully");
        return clientService.changeStatus(clientDTO,id);

    }

    @GetMapping(value = "list")
    public ClientBaseResponse getAllClient() {
        return (ClientBaseResponse) clientService.getAllClient();}

    @GetMapping(value = "/{id}")
    public ClientResponseDTO getById(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @GetMapping(value = "active/client")
    public ClientBaseResponse getActive() {
        return  clientService.getClientByActive('Y');
    }
}

package com.bikash.springjpa.service.loginserviceimpl;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.model.clienttokenlist.ClientToken;
import com.bikash.springjpa.repository.ClientRepository;
import com.bikash.springjpa.repository.TokenRepository;
import com.bikash.springjpa.service.LoginService;
import com.bikash.springjpa.utility.TokenRandomCharacters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public boolean authentication(Client client) throws Exception {
        Client c = new Client();
        c=clientRepository.findByUsername(client.getUsername());
        if(c==null) {
            log.info("username does not exists");
            throw new Exception("username doesnot exists");

        }else if(c.getUsername().equals(client.getUsername()) && (c.getPassword().equals(client.getPassword()))){

            List<ClientToken> lists= tokenRepository.getClientTokenByActive('Y');
            lists.forEach(list-> list.setActive('N'));
            ClientToken ct=new ClientToken();
            ct.setToken(TokenRandomCharacters.generateToken());
            ct.setActive('Y');
            ct.setClient(c);
            tokenRepository.save(ct);
        }
        else {
            log.info("username password does not matches");
            throw new Exception("username password does not matches");
        }
        return false;
    }


}

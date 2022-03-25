package com.bikash.springjpa.service.loginserviceimpl;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.model.clienttokenlist.ClientToken;
import com.bikash.springjpa.repository.LoginRepository;
import com.bikash.springjpa.repository.TokenRepository;
import com.bikash.springjpa.responsemessage.loginresponse.LoginResponse;
import com.bikash.springjpa.service.LoginService;
import com.bikash.springjpa.utility.TokenRandomCharacters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public boolean authentication(Client client) {
        Client c = new Client();
        c=loginRepository.findByUsername(client.getUsername());
        if(c==null) {
            log.info("username does not exists");

        }else if(c.getUsername().equals(client.getUsername()) && (c.getPassword().equals(client.getPassword()))){
            ClientToken ct=new ClientToken();
            ct.setToken(TokenRandomCharacters.generateToken());
            ct.setClient(c);
            tokenRepository.save(ct);
        }
        else {
            log.info("username password does not matches");
        }
        return false;
    }
}

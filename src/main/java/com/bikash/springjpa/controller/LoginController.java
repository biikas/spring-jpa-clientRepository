package com.bikash.springjpa.controller;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "login")

@CrossOrigin(origins="http://localhost:4200/")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public void login(@RequestBody Client client) throws Exception {
        log.info("login controller");

        loginService.authentication(client);

    }
}

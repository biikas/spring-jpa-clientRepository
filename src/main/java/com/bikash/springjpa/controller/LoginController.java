package com.bikash.springjpa.controller;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public void login(@RequestBody Client client){
        log.info("login controller");

        loginService.authentication(client);

    }
}

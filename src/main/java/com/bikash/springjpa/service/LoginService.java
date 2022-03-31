package com.bikash.springjpa.service;

import com.bikash.springjpa.model.Client;

public interface LoginService {
    public boolean authentication(Client client) throws Exception;
}

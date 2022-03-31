package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.clienttokenlist.ClientToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<ClientToken, Integer> {
    //String findByUsername(String username);
    List<ClientToken> getClientTokenByActive(char active);




}

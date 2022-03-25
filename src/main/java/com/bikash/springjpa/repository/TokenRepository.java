package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.model.clienttokenlist.ClientToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<ClientToken, Integer> {

}

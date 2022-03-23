package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findClientByActive(char active);

    Client findByUsername(String username);

    //String ByName(String name);

    String findByName(String name);

}

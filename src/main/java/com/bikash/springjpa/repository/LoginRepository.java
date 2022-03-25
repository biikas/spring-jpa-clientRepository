package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Client,Integer> {

    Client findByUsername(String username);
}

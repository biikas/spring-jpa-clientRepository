package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.ApiData;
import com.bikash.springjpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiDataRepository extends JpaRepository<ApiData,Integer> {

    ApiData getByClient(Client client);

    List<ApiData> findByClient(Client client);

}

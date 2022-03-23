package com.bikash.springjpa.service;

import com.bikash.springjpa.dto.Api_DataDTO;
import com.bikash.springjpa.model.Api_Data;
import com.bikash.springjpa.model.Client;

import java.util.List;

public interface ApiDataService {

    boolean saveApiData(Api_DataDTO api_dataDTO, Client client);
    List<Api_Data> getAllApiData();
    boolean updateApiData(Api_DataDTO api_dataDTO,int id);

}

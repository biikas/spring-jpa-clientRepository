package com.bikash.springjpa.service;

import com.bikash.springjpa.responsemessage.ApiDataResponseMessage.ApiBaseRespons;
import com.bikash.springjpa.dto.ApiDataDTO;
import com.bikash.springjpa.model.ApiData;
import com.bikash.springjpa.model.Client;

import java.util.List;

public interface ApiDataService {

    boolean saveApiData(ApiDataDTO api_dataDTO, Client client);

    List<ApiData> getAllApiData();

    boolean updateApiData(ApiDataDTO api_dataDTO, Client client);

    ApiBaseRespons getApiDataUser(Client client);
}

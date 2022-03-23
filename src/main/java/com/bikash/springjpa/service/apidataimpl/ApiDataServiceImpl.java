package com.bikash.springjpa.service.apidataimpl;

import com.bikash.springjpa.dto.Api_DataDTO;
import com.bikash.springjpa.model.Api_Data;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ApiDataRepository;
import com.bikash.springjpa.service.ApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiDataServiceImpl implements ApiDataService {

    @Autowired
    private ApiDataRepository apiDataRepository;

    @Override
    public boolean saveApiData(Api_DataDTO api_dataDTO, Client client) {
        Api_Data api_data = new Api_Data();
        api_data.setApi_name(api_dataDTO.getApi_name());
        api_data.setApi_data(api_dataDTO.getApi_data());
        api_data.setClient(client);
        //api_data.setClient();
        //api_data.setId(id);
        //api_data.setClient_id(api_dataDTO.getClient_id());
        apiDataRepository.save(api_data);
        return true;

    }

    @Override
    public List<Api_Data> getAllApiData() {
        return null;
    }

    @Override
    public boolean updateApiData(Api_DataDTO api_dataDTO, int id) {
        return false;
    }
}

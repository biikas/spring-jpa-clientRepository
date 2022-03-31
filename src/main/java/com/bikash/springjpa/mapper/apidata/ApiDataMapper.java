package com.bikash.springjpa.mapper.apidata;

import com.bikash.springjpa.dto.ApiDataDTO;
import com.bikash.springjpa.model.ApiData;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ApiDataRepository;
import com.bikash.springjpa.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ApiDataMapper {
    @Autowired
    private ApiDataRepository apiDataRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ApiData convertToSaveApiData(ApiDataDTO apiDataDTO, Client client) {
        ApiData api_data = new ApiData();

        log.info(apiDataDTO.getApi_name());
        api_data.setApi_name(apiDataDTO.getApi_name());
        api_data.setApi_data(apiDataDTO.getApi_data());
        api_data.setClient(client);
        return api_data;
    }
    public ApiData convertToUpdateApiData(ApiDataDTO apiDataDTO, Client client){

        ApiData api_data =apiDataRepository.getByClient(client);
        log.info("reached here");
        api_data.setApi_name(apiDataDTO.getApi_name());
        api_data.setApi_data(apiDataDTO.getApi_data());
        log.info("finally reached here");

        return api_data;
    }
    public List<ApiData> convertToGetList(){
        return apiDataRepository.findAll();

    }
    public List<ApiData> convertToGetApiUser(Client client){
        log.info("reached here");
        List<ApiData> apiData = apiDataRepository.findByClient(client);
        return apiData;


    }

}

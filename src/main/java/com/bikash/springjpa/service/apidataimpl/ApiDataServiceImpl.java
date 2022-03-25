package com.bikash.springjpa.service.apidataimpl;

import com.bikash.springjpa.responsemessage.ApiDataResponseMessage.ApiBaseRespons;
import com.bikash.springjpa.dto.ApiDataDTO;
import com.bikash.springjpa.mapper.apidata.ApiDataMapper;
import com.bikash.springjpa.mapper.apidata.ApiDataRequestMapper;
import com.bikash.springjpa.model.ApiData;
import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.repository.ApiDataRepository;
import com.bikash.springjpa.service.ApiDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ApiDataServiceImpl implements ApiDataService {

    @Autowired
    private ApiDataRepository apiDataRepository;

    @Autowired
    private ApiDataMapper apiDataMapper;

    @Override
    public boolean saveApiData(ApiDataDTO api_dataDTO, Client client) {
        apiDataRepository.save(apiDataMapper.ConvertToSaveApiData(api_dataDTO,client));
        log.info("api saved successfully");
        return true;

    }

    @Override
    public boolean updateApiData(ApiDataDTO api_dataDTO, Client client) {
        apiDataRepository.save(apiDataMapper.convertToUpdateApiData(api_dataDTO,client));
        return true;
    }

    @Override
    public List<ApiData> getAllApiData() {
        return apiDataMapper.convertToGetList();
    }

    public ApiBaseRespons getApiDataUser(Client client){
        log.info("before service impl");
        return ApiDataRequestMapper.responseToGetApiByUser(apiDataMapper.convertToGetApiUser(client));
    }

}

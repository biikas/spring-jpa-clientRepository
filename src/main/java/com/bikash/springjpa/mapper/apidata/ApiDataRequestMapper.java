package com.bikash.springjpa.mapper.apidata;

import com.bikash.springjpa.responsemessage.ApiDataResponseMessage.ApiBaseRespons;
import com.bikash.springjpa.responsemessage.ApiDataResponseMessage.ApiResponse;
import com.bikash.springjpa.model.ApiData;

import java.util.ArrayList;
import java.util.List;

public class ApiDataRequestMapper {

    public static ApiBaseRespons responseToGetApiByUser(List<ApiData> api_data){
        ApiBaseRespons apiBaseResponse =new ApiBaseRespons();
        List<ApiResponse> list =new ArrayList<>();
        api_data.forEach(c->list.add(new ApiResponse(c.getApi_data(),c.getApi_data(),c.getId())));
        apiBaseResponse.setSuccess(true);
        apiBaseResponse.setMessage("Data obtained successfully");
        apiBaseResponse.setCode(1);
        apiBaseResponse.setApiDetails(list);
        return apiBaseResponse;
    }
}

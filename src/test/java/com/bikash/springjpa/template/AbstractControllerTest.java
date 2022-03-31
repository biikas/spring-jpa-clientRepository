package com.bikash.springjpa.template;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class AbstractControllerTest {

    public static final String BASE_URL="http://localhost:8084/";
    protected RestTemplate restTemplate;
    protected static final String X_REQUEST_CHANNEL="x-request-channel";
    protected HttpHeaders headers;


    public AbstractControllerTest(){
        this.restTemplate=new RestTemplate();

        this.headers=new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.add(X_REQUEST_CHANNEL,"web");
    }


}

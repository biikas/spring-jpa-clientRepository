package com.bikash.springjpa.template;

import com.bikash.springjpa.dto.ClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@Slf4j
public class CrudControllerTest extends TokenBasedAbstractControllerTest{

    public static void main(String[] args) {
        CrudControllerTest crudControllerTest =new CrudControllerTest();
        //crudControllerTest.addClient();
        crudControllerTest.getAllClient();

    }

    public void addClient(){
        String webServiceURL=BASE_URL+"/clients/add";
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Nitesh");
        clientDTO.setUsername("nitesh123");
        clientDTO.setPassword("nitesh123");
        //clientDTO.setActive('Y');

        HttpEntity<ClientDTO> request = new HttpEntity<>(clientDTO,headers);

        String result = restTemplate.postForObject(webServiceURL,request,String.class);

        log.info("result: "+result);
    }
    public void getAllClient(){
        String webServiceURL=BASE_URL+"/clients/list";
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> result =restTemplate.exchange(webServiceURL, HttpMethod.GET,request,String.class);
        log.info("result"+result);
    }

}

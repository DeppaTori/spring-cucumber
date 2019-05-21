package com.mitrais.simpleservice;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract  class BaseIntegrationTest {
    private final String SERVER_URL = "http://localhost";
    private String endPoint = "";


    private RestTemplate restTemplate;

    @LocalServerPort
    protected int port;

    public BaseIntegrationTest(){
        restTemplate = new RestTemplate();
    }

    public void setEndPoint(String endPoint){
        this.endPoint = endPoint;
    }

    public String getEndPointUrl(){
        return SERVER_URL + ":" + port + endPoint;
    }

    public void clean() {
        restTemplate.delete(getEndPointUrl());
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return restTemplate;
    }
}

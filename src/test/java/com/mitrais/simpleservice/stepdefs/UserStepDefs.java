package com.mitrais.simpleservice.stepdefs;


import com.mitrais.simpleservice.BaseIntegrationTest;
import com.mitrais.simpleservice.model.User;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

public class UserStepDefs implements En {



    public UserStepDefs(){
        super();
       // setEndPoint("/users/find-one");

        When("the client calls \\/find-one", () -> {
            // Write code here that turns the phrase above into concrete actions
           throw new cucumber.api.PendingException();

        });

//        Then("the client receives status code of {int}", (Integer int1) -> {
//            // Write code here that turns the phrase above into concrete actions
//            throw new cucumber.api.PendingException();
//        });
//
//        Then("the client receives User Tiara", () -> {
//            // Write code here that turns the phrase above into concrete actions
//            throw new cucumber.api.PendingException();
//        });

    }
}

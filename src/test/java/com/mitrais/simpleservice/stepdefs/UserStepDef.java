package com.mitrais.simpleservice.stepdefs;

import cucumber.api.java8.En;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserStepDef implements En {

    private List<String> users;

    public UserStepDef(){
        Given("User table is empty", () -> {
            users = new ArrayList<>();
        });

        When("User {string} register", (String userName) -> {
            users.add(userName);
        });

        Then("User table have {string} row", (String string) -> {
            assertEquals(users.get(0),string);
        });


    }
}

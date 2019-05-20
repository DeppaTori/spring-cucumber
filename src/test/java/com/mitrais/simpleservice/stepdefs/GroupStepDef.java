package com.mitrais.simpleservice.stepdefs;

import cucumber.api.java8.En;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupStepDef  implements En {

    private List<String> groups;

    public GroupStepDef(){
        Given("Group table is empty", () -> {
            groups = new ArrayList<>();
        });

        When("User add new {string} group", (String groupName) -> {
            groups.add(groupName);
        });

        Then("Group table have {int} row", (Integer totalRow) -> {
            assertEquals(groups.size(),totalRow.intValue());
        });

    }
}

package com.mitrais.simpleservice.stepdefs;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class GoogleBookStepDefs implements En {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";


    public GoogleBookStepDefs(){
        Given("a book exists with an isbn of {string}", (String isbn) -> {
            request = given().param("q", "isbn:" + isbn);
        });

        When("a user retrieves the book by isbn", () -> {
            response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
            System.out.println("response: " + response.prettyPrint());

        });

        Then("the status code is {int}", (Integer statusCode) -> {
            // Write code here that turns the phrase above into concrete actions
            json = response.then().statusCode(statusCode);
        });

        Then("response totalItems is {int}", (Integer int1) -> {
            json.assertThat().body("totalItems",equalTo(int1));
        });

        Then("response includes the following in any order", (DataTable dataTable) -> {
            List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
            json.assertThat().body("items.findAll { it.id == '8U2oAAAAQBAJ' }.volumeInfo.title", hasItems( list.get(0).get("Value")));

        });





    }
}

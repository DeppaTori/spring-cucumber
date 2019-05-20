package com.mitrais.simpleservice.stepdefs;

import com.mitrais.simpleservice.SpringBootBaseIntegrationTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

//@Ignore
public class BagCucumberStepDefinitions extends SpringBootBaseIntegrationTest implements En {

    private final Logger log = LoggerFactory.getLogger(BagCucumberStepDefinitions.class);

        public BagCucumberStepDefinitions(){
            Given("the bag is empty", () -> {
                clean();
                assertThat(getContents().isEmpty()).isTrue();
            });

            When("I put {int} potato in the bag", (Integer quantity) -> {
                IntStream.range(0, quantity)
                        .peek(n -> log.info("Putting a {} in the bag, number {}", "potato", quantity))
                        .map(ignore -> put("potato"))
                        .forEach(statusCode -> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
            });

            Then("the bag should contain only {int} potato", (Integer quantity) -> {
                assertNumberOfTimes(quantity, "potato", true);
            });

            When("I put {int} cucumber in the bag", (Integer quantity) -> {
                IntStream.range(0, quantity)
                        .peek(n -> log.info("Putting a {} in the bag, number {}", "potato", quantity))
                        .map(ignore -> put("cucumber"))
                        .forEach(statusCode -> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
            });

            Then("the bag should contain {int} potato", (Integer quantity) -> {
                assertNumberOfTimes(quantity, "potato", true);
            });

            Then("the bag should contain {int} cucumber", (Integer quantity) -> {
                assertNumberOfTimes(quantity, "cucumber", true);
            });


        }

    private void assertNumberOfTimes(final int quantity, final String something, final boolean onlyThat) {
        final List<String> things = getContents().getThings();
        log.info("Expecting {} times {}. The bag contains {}", quantity, something, things);
        final int timesInList = Collections.frequency(things, something);
        assertThat(timesInList).isEqualTo(quantity);
        if (onlyThat) {
            assertThat(timesInList).isEqualTo(things.size());
        }
    }
}

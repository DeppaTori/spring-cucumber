package com.mitrais.simpleservice;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = {"com.mitrais.simpleservice.stepdefs"},
        plugin = {"pretty", "html:target/cucumber"})
public class BagCucumberIntegrationTest {


}

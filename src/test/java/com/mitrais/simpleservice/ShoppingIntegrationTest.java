package com.mitrais.simpleservice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/shopping.feature"})
public class ShoppingIntegrationTest {
}

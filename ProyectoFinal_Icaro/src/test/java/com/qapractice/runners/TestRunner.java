package com.qapractice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "com.qapractice.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@OK"
)

public class TestRunner {

}

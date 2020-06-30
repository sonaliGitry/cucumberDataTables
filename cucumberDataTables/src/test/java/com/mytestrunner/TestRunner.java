package com.mytestrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/feature/dataTables.feature",glue= {"com.stepdefinition"},
dryRun=false)

public class TestRunner {

}

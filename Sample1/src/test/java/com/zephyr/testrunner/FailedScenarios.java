package com.zephyr.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features/"},
        		//tags={"@Create_Cycle555"},
        				 
        		glue = {"com.zephyr.stepdefinition"},
        plugin = { "pretty","html:target/report/rerun/html-basic",         
                                "json:target/report/rerun/cucumber.json" },monochrome = true
                
        )
public class FailedScenarios 
{

}

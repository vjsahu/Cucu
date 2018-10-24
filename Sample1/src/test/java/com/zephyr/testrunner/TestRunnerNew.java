package com.zephyr.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features={"Features/DT.feature:4"},

//tags={@Import1,@Export11,@Map1,@search1,@Edit1,@DND1},

glue={"com.zephyr.stepdefinition"},
plugin = {"html:target/cucumber-html-report",
"pretty:target/cucumber-pretty.txt,rerun:target/rerun.txt",
"json:target/cucumber6.json"},
monochrome = false)

public class TestRunnerNew extends AbstractTestNGCucumberTests
{
}

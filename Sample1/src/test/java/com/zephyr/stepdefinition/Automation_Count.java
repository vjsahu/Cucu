package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Automation_Count extends LaunchBrowser {

	 String previousCount;
	
	
	@When("^user open the file and change the execution count$")
	public void user_open_the_file_and_change_the_execution_count() throws Throwable {
	  previousCount= Property_Lib.getPropertyValue(CONFIG_PATH1, "Count");
	  System.out.println(previousCount);
	  Property_Lib.setPropertyValue(CONFIG_PATH1, "Count");
	  
	  
	  
	 
		
	}

	@Then("^execution count should be changed$")
	public void execution_count_should_be_changed() throws Throwable {
		 String currentCount= Property_Lib.getPropertyValue(CONFIG_PATH1, "Count");
		 System.out.println("Current Count- "+currentCount);
		 if(currentCount.equals(previousCount))
		 {
			 System.out.println("Execution Count successfully Changed");
		 }
	}
}

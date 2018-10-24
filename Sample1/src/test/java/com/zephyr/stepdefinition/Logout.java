package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	String filename="Logout";
	@Given("^User is in the Zephyr ProjectPage$")
	public void user_is_in_the_Zephyr_ProjectPage() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		//String projectName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,0);
	    //pp.selectProject(projectName);
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User Clicks on logout Icon$")
	public void user_Clicks_on_logout_Icon() throws Throwable 
	{
		try
		{
	    bp=new BasePage();
	    
	    bp.waitForElement();
		pp.user_option.click();
		bp.waitForElement();
		log.info("Pass - clicked on Logout user Option");
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User clicks on Logout Option$")
	public void user_clicks_on_Logout_Option() throws Throwable 
	{
		try
		{
	    bp=new BasePage();
	    pp.logout.click();
	    bp.waitForElement();
	    log.info("Pass - clicked on Logout Successfully");
	    pp.closeBrowser();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}

	}

	@Then("^User should be logged out from Zephyr Application Successfully$")
	public void user_should_be_logged_out_from_Zephyr_Application_Successfully() throws Throwable 
	{
	    log.info("Pass - User should be logged out from Zephyr Application Successfully");

	}


}

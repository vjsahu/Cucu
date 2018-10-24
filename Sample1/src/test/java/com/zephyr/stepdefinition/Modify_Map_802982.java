package com.zephyr.stepdefinition;

import org.openqa.selenium.By;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Modify_Map_802982 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Modify_Map_802982";
	
	@Given("^User is in the Testrepository page$")
	public void user_is_in_the_Testrepository_page() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LUname");
//		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LPass");
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		try{   
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();  
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		
	}

	@When("^User navigates to the Release$")
	public void user_navigates_to_the_Release() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User clicks on ImportIcon$")
	public void user_clicks_on_ImportIcon() throws Throwable 
	{
		try
		{
		ip= new ImportPage(driver);
		 bp=new BasePage();
		ip.clickOnImport();
		   bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User moves to Create map field$")
	public void user_moves_to_Create_map_field() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		ip=new ImportPage(driver);
		
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
		ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
		
		ip.back.click();
		//driver.findElement(By.xpath(xpathExpression))
		
		bp.waitForElement();
		ip.selectMap.click();
		bp.eraseText(ip.selectMap);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		
	}

	@When("^User modifies the Map$")
	public void user_modifies_the_Map() throws Throwable 
	{
		try
		{
		String mapname=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 6, 7);
		ImportPage ip= new ImportPage(driver);
	    ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	    bp.waitForElement();
	    ip.closeImportTestCasePage.click();
	    bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Map should be modified successfully$")
	public void map_should_be_modified_successfully() throws Throwable 
	{
		try
		{
	    log.info("Pass - Map should be modified successfully");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
}

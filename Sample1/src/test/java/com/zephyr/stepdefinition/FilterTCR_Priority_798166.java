package com.zephyr.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FilterTCR_Priority_798166 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCR_Priority_798166";
	@Given("^user in the repository page$")
	public void user_in_the_repository_page() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   actual[3]=tr.doubleClickOnRelease(releaseName);
	}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
	}

	@When("^when user select the export tests$")
	public void when_user_select_the_export_tests() throws Throwable
	{
		try
		{
		ep=new ExportPage(driver);
		actual[4]=ep.clickOnNodeExport();
		}catch (Exception e)
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^select the specific priority and creator$")
	public void select_the_specific_priority_and_creator() throws Throwable 
	{
		try
		{
		String coverage=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String[] priority=new String[1];
		priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1,0);
		
		String[] creator=new String[1];
		creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 2,0);
	   
	   
		
		String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		
		actual[5]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	   
	}

	@When("^select the summary$")
	public void select_the_summary() throws Throwable 
	{
	  try
	  {
		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
		actual[6]=ep.reportType(report_Type);
	    
	   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
	    
	   // ep.outputType(outputType);
	    
//	    Actions ac=new Actions(driver);
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
	    
	    actual[7]=ep.title(report_Type);
	    bp=new BasePage();
	    bp.waitForElement();
	    actual[8]=ep.saveAndDownload();
	  }catch (Exception e) 
	  {lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		  e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
	}
	}

	@Then("^should generate filtered specific priority and creator Report$")
	public void should_generate_filtered_specific_priority_and_creator_Report() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("filter Test Case Exported Successfully");
		
//		pp=new ProjectPage(driver);
//		pp.clickOnLogout();
//		lb=new LaunchBrowser();
//		lb.close();
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	
//	@After
//	public void tearDown(Scenario scenario) {
//		 pp=new ProjectPage(driver);
//		 
//	 if (scenario.isFailed()) {
//	          final byte[] screenshot = ((TakesScreenshot) driver)
//	                      .getScreenshotAs(OutputType.BYTES);
//	         scenario.embed(screenshot, "image/png"); //stick it in the report
//	          
//	  }
//}
}
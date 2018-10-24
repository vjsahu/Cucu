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

public class FilterTCR_Automated_798185 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[8];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCR_Automated_798185";
	@Given("^user in the Repository page$")
	public void user_in_the_Repository_page() throws Throwable 
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
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
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

	@When("^user select export test option$")
	public void user_select_export_test_option() throws Throwable 
	{
		try
		{
		ep=new ExportPage(driver);
		actual[2]=ep.clickOnNodeExport();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		}
	}

	@When("^Select the auto or manual checkbox$")
	public void select_the_auto_or_manual_checkbox() throws Throwable 
	{
		try
		{
		String[] selectFields=new String[1];
		selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 1,0);
		actual[3]=ep.selectSelectFields(selectFields);
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

	@When("^In filter by select automated radio button$")
	public void in_filter_by_select_automated_radio_button() throws Throwable
	{
		try
		{
		String coverage=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String[] priority=new String[1];
		priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 100,100);
		
		String[] creator=new String[1];
		creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 100,100);
	   
	   
		//String M_A=" ";
		String M_A1=Excel_Lib.getData(INPUT_PATH_4, "M_A", 1,0);
		
		
		actual[4]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A1);
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		}
	}

	@When("^select summuray report$")
	public void select_summuray_report() throws Throwable 
	{
		try
		{
		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
		actual[5]=ep.reportType(report_Type);
	    
	   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
	    
	   // ep.outputType(outputType);
	    
//	    Actions ac=new Actions(driver);
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
	    bp=new BasePage();
	    actual[6]=ep.title(report_Type);
	    bp.waitForElement();
	    actual[7]=ep.saveAndDownload();
	    bp.waitForElement();
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		}
	}

	@Then("^should generate Automated Test case Report$")
	public void should_generate_Automated_Test_case_Report() throws Throwable 
	{
		try
		{
		log.info("filter automated Test Cases Report Exported Successfully");
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
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

}

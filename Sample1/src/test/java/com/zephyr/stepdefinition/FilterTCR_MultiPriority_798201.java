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

public class FilterTCR_MultiPriority_798201 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCR_MultiPriority_798201";
	@Given("^user in the test Repository Page$")
	public void user_in_the_test_Repository_Page() throws Throwable 
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
		   bp=new BasePage();
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   actual[3]=tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
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

	@When("^user selects the export tests in Repositorypage$")
	public void user_selects_the_export_tests_in_Repositorypage() throws Throwable 
	{
	    try
	    {
		ep=new ExportPage(driver);
		bp.waitForElement();
		actual[4]=ep.clickOnNodeExport();
		bp.waitForElement();
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

	@When("^select the multiple priorities$")
	public void select_the_multiple_priorities() throws Throwable 
	{
		try
		{
//		String[] selectFields=new String[2];
//		selectFields[0]=Excel_Lib.getData(INPUT_PATH, "selectcheckbox", 2,0);
//		selectFields[1]=Excel_Lib.getData(INPUT_PATH, "selectcheckbox", 3,0);
//	    ep.selectSelectFields(selectFields);
		
		//ep.selectallSelectFields();
			ep=new ExportPage(driver);
		ep.unselectAllSelectFields();
		
		String[] selectFields=new String[2];
		selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 2,0);
		selectFields[1]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 3,0);
		actual[5]=ep.selectSelectFields(selectFields);
		bp.waitForElement();
		String coverage=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		String[] priority=new String[3];
		priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1,0);
		priority[1]=Excel_Lib.getData(INPUT_PATH_4, "priority", 2,0);
		priority[2]=Excel_Lib.getData(INPUT_PATH_4, "priority", 3,0);
		
		String[] creator=new String[1];
		creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 100,100);
	   
	   
		
		String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		
		
		actual[6]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);
		bp.waitForElement();
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

	@When("^Select the detailed Report$")
	public void select_the_detailed_Report() throws Throwable 
	{
		try
		{
		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 2, 0);
		actual[7]=ep.reportType(report_Type);
		bp.waitForElement();
	   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
	    
	   // ep.outputType(outputType);
	    
//	    Actions ac=new Actions(driver);
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
	    bp.waitForElement();
	    actual[8]=ep.title(report_Type);
	    bp.waitForElement();
	    actual[9]=ep.saveAndDownload();
	    bp.waitForElement();
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

	@Then("^shoud Generateb multipriority Test case report$")
	public void shoud_Generateb_multipriority_Test_case_report() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("filter multi priority Test Cases Report Exported Successfully");
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

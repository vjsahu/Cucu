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

public class FilterTCRByAllVCreators_798222 extends LaunchBrowser
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
	 String filename="FilterTCRByAllVCreators_798222";
	@Given("^user in the tests repository page$")
	public void user_in_the_tests_repository_page() throws Throwable 
	{
		try
		{
//		   lb=new LaunchBrowser();
//		   lb.preCond();
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
	@When("^select the option export tests$")
	public void select_the_option_export_tests() throws Throwable 
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
	@When("^Select the Required Check Box in Select fields$")
	public void select_the_Required_Check_Box_in_Select_fields() throws Throwable
	{
		try
		{
		ep.unselectAllSelectFields();
		String[] selectFields=new String[5];
		selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 1,0);
		selectFields[1]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 2,0);
		selectFields[2]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 3,0);
		selectFields[3]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 4,0);
		selectFields[4]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 5,0);
		actual[5]=ep.selectSelectFields(selectFields);
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
	@When("^Select the priority All creators and all M/A$")
	public void select_the_priority_All_creators_and_all_M_A() throws Throwable 
	{
		try
		{
		String coverage=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		String[] priority=new String[2];
		priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1,0);
		priority[1]=Excel_Lib.getData(INPUT_PATH_4, "priority", 2,0);
		String[] creator=new String[10];
		creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 1,0);
		creator[1]=Excel_Lib.getData(INPUT_PATH_4, "creator", 2,0);
		creator[2]=Excel_Lib.getData(INPUT_PATH_4, "creator", 3,0);
		creator[3]=Excel_Lib.getData(INPUT_PATH_4, "creator", 4,0);
		creator[4]=Excel_Lib.getData(INPUT_PATH_4, "creator", 5,0);
		creator[5]=Excel_Lib.getData(INPUT_PATH_4, "creator", 6,0);
		creator[6]=Excel_Lib.getData(INPUT_PATH_4, "creator", 7,0);
		creator[7]=Excel_Lib.getData(INPUT_PATH_4, "creator", 8,0);
		creator[8]=Excel_Lib.getData(INPUT_PATH_4, "creator", 9,0);
		creator[9]=Excel_Lib.getData(INPUT_PATH_4, "creator", 10,0);
		//creator[10]=Excel_Lib.getData(INPUT_PATH_4, "creator", 11,0);
		String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		actual[6]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);
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
	@When("^Select the option Detailed$")
	public void select_the_option_Detailed() throws Throwable 
	{
		try
		{
		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 2, 0);
		actual[7]=ep.reportType(report_Type);
	   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
	   // ep.outputType(outputType);
//	    Actions ac=new Actions(driver);
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
	    //ep.title(report_Type);
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
	@Then("^Should generate the filter test case detailed Report$")
	public void should_generate_the_filter_test_case_detailed_Report() throws Throwable
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();	
		log.info("Filter by coverage (both covered and non-covered) with multi-select Priority (P1 and P2), multi-select M/A, all creators Test Cases Report Exported Successfully");
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

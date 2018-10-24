package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportReleaseLevel_798102 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	String filename="ExportReleaseLevel_798102";
	@Given("^User is in the Test RepositoryPage$")
	public void user_is_in_the_Test_RepositoryPage() throws Throwable {
//		  lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
//		   
		   try
		   {
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   }
		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	     	Relogin rl=new Relogin();
	     	rl.reLogin();
	     	throw e;
			}
		  // tr=new TestRepositoryPage(driver);
	}

	@When("^User Select the Release and choose Export Test Option$")
	public void user_Select_the_Release_and_choose_Export_Test_Option() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		  tr=new TestRepositoryPage(driver);
		  actual[3]=tr.doubleClickOnRelease(releaseName);
		   
		   ep=new ExportPage(driver);
		   actual[4]=ep.clickOnNodeExport();
		}
		catch(Exception e)
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

	@When("^select Data Report to an Excel File$")
	public void select_Data_Report_to_an_Excel_File() throws Throwable
	{
		try
		{
		String report_Type=Excel_Lib.getData(INPUT_PATH_2,"Test_798102", 1, 0);
		System.out.println(report_Type);
		actual[5]=ep.reportType(report_Type);
		actual[6]=ep.saveAndDownload();
		}
		catch(Exception e)
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

	@Then("^all the Selected test case should be exported$")
	public void all_the_Selected_test_case_should_be_exported() throws Throwable 
	{
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
			
	       tr.doubleClickOnRelease(releaseName);
	       
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
		log.info("Test Case Exported");
		}
		 catch(Exception e)
		{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
//		pp=new ProjectPage(driver);
//		pp.clickOnLogout();
//		lb=new LaunchBrowser();
//		lb.close();
		
}
}
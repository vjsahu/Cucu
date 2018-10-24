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

public class FilterTestCaseReport_798162 extends LaunchBrowser
{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[7];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTestCaseReport_798162";
@Given("^user logged in the repository page$")
public void user_logged_in_the_repository_page() throws Throwable 
{
	try
	{
//	lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
		ep=new ExportPage(driver);
	   pp=new ProjectPage(driver);
	   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
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
@When("^user select and click on exporttest$")
public void user_select_and_click_on_exporttest() throws Throwable 
{
	   try
	   {
	   ep=new ExportPage(driver);
	   actual[4]=ep.clickOnNodeExport();
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
@When("^select the speccific creator$")
public void select_the_speccific_creator() throws Throwable
{
	try
	{
	String coverage=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
	String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
	String[] priority=new String[1];
	priority[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 100,100);
	String[] creator=new String[1];
	//creator[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_3");
	creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator",2,0);
	String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
	actual[5]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);
	System.out.println(actual[5]);
	bp.waitForElement();
	bp.waitForElement();
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
@When("^select the summary report$")
public void select_the_summary_report() throws Throwable
{
	try
	{
//			bp=new BasePage();
//		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
//		actual[6]=ep.reportType(report_Type);
//		System.out.println(actual[6]);
//		bp.waitForElement();
//		bp.waitForElement();
//		String outputType=Excel_Lib.getData(INPUT_PATH_4, "outputtype", 1, 0);
//		actual[7]=ep.outputType(outputType);
//		bp.waitForElement();
//		bp.waitForElement();
//		System.out.println(actual[7]);
//	//    Actions ac=new Actions(driver);
//	//    ac.sendKeys(Keys.DOWN).perform();
//	//    ac.sendKeys(Keys.DOWN).perform();
//	//    ac.sendKeys(Keys.DOWN).perform();
//	    bp.waitForElement();
//		bp.waitForElement();
//	//	String report_Type1=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
//	//    //actual[8]=ep.title(report_Type1);
//	    bp.waitForElement();
		ep=new ExportPage(driver);
	    actual[6]=ep.saveAndDownload();
	    bp.waitForElement();
	    bp.waitForElement();
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
@Then("^shoud be generate filter Testcase Report$")
public void shoud_be_generate_filter_Testcase_Report() throws Throwable 
{
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();	
	log.info("filter Test Case Exported Successfully");
//	pp=new ProjectPage(driver);
//	pp.clickOnLogout();
//	lb=new LaunchBrowser();
//	lb.close();
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

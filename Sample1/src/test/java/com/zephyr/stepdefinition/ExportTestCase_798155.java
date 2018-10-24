package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798155 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	BasePage bp;
	String filename="ExportTestCase_798155";
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	

@When("^User creates a phase$")
public void user_creates_a_phase() throws Throwable 
{
  try
  {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 24, 0);
	String Desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 24, 1);
	
	 bp=new BasePage(); 
	 tr=new TestRepositoryPage(driver);
	 actual[0]=tr.doubleClickOnRelease(releaseName);   
	// bp.waitForElement();
	 actual[1]=tr.addNode(Name, Desc);
	 bp.waitForElement();
	 bp.waitForElement();
	 
	 tr.doubleClickOnRelease(releaseName);
	 
	 bp.waitForElement();
	 String[] phase=new String[1];
	 phase[0]=Name;
	 tr.navigateToNode(releaseName, phase);
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

@When("^add a test case to the phase$")
public void add_a_test_case_to_the_phase() throws Throwable 
{
	try
	{
	actual[2]=tr.addTestCase();
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

@When("^enter test case detail with custom field$")
public void enter_test_case_detail_with_custom_field() throws Throwable 
{
	try
	{
	actual[3]=tr.clickDetailButton();
   ctc=new CreateTestCasePage(driver);
   String name=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,10);
   String desc=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,11);
   actual[4]=ctc.enterTestCaseNameAndDesc(name, desc);
   tr.clickOnCustomField();
   //ctc.clickOnCustomField.click();
   String text=Excel_Lib.getData(INPUT_PATH_2,"CustomField",2,0);
   String longtext=Excel_Lib.getData(INPUT_PATH_2,"CustomField",2,1);
   String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CustomField",2,2));
   String checkbox=Excel_Lib.getData(INPUT_PATH_2,"CustomField",2,4);
   String pick=Excel_Lib.getData(INPUT_PATH_2,"CustomField",2,5);
   String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CustomField",2,3));
   
   actual[5]=ctc.enterCustomFields(text, longtext, number, checkbox, pick, date);
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

@When("^click on export option$")
public void click_on_export_option() throws Throwable 
{
	try
	{
	actual[6]=tr.clickOnList();
	bp.waitForElement();
	ep=new ExportPage(driver);
	String[] testcase=new String[1];
	testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CustomField",1,7));
	actual[7]=ep.selectMultipleTestCaseFromGrid(testcase);
	bp.waitForElement();
	actual[8]=tr.exportTestCase();
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

@When("^click on save and download button$")
public void click_on_save_and_download_button() throws Throwable 
{
	try
	{
   ep=new ExportPage(driver);
	String report=Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 6);
   actual[9]=ep.reportType(report);
   bp.waitForElement();
   actual[10]=ep.saveAndDownload();
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

@Then("^test case should be exported successfully$")
public void test_case_should_be_exported_successfully() throws Throwable 
{
   try
   {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	tr.doubleClickOnRelease(releaseName);
	for(int k=0;k<=actual.length-1;k++)
    {
    	soft.assertEquals(actual[k], true);
    }
	soft.assertAll();
	log.info("Test case Exported");
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


}

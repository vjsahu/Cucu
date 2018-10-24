package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809227 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
    
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809227";
	
	boolean[] actual=new boolean[9];
	   SoftAssert soft=new SoftAssert();
	   
@Given("^User is in the Phase Page$")
public void user_is_in_the_Phase_Page() throws Throwable 
{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		  try
		  {
			  bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   
		   tr.doubleClickOnRelease(releaseName);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",7,0);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Nodes",7,0);
		   tr.doubleClickOnRelease(releaseName);
		   
		   tr.addNode(name, desc);
		   bp.waitForElement();
		   bp.waitForElement();
		   tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 7, 0);
		   actual[3]=tr.navigateToNode(releaseName, phase);
		   
		   for(int i=1;i<=4;i++)
		   {
		   tr.addTestCase();
		   }
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

@When("^User selects multiple test cases$")
public void user_selects_multiple_test_cases() throws Throwable {
   
	try
	{
		String[] testCases=new String[3];
   testCases[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", 1, 2));
   testCases[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", 2, 2));
   testCases[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", 3, 2));
   
	
	ep=new ExportPage(driver);
	 actual[4]=ep.selectMultipleTestCaseFromGrid(testCases);
	}
	catch(Exception e)
	{  lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^edit Alt Id,Auto$")
public void edit_Alt_Id_Auto() throws Throwable {
	
	try
	{
	String[] testData=new String[3];
	testData[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase", 3, 1));
	testData[1]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 2, 2);
	testData[2]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 3, 4);
	
	String[] auto=new String[4];
	auto[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 5);
	auto[1]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 6);
	auto[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase", 1, 7));
	auto[3]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 8);
	ctc=new CreateTestCasePage(driver);
   
	actual[5]=tr.editTestCase();
	 actual[6]= ctc.editMultipleTestCase(testData,auto);
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^edit the Custom Fields and saved it$")
public void edit_the_Custom_Fields_and_saved_it() throws Throwable {
	try
	{
	String text=Excel_Lib.getData(INPUT_PATH_2, "CustomField", 1, 0);
	String longText=Excel_Lib.getData(INPUT_PATH_2, "CustomField", 1, 1);
	String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CustomField", 1, 2));
	String checkBox=Excel_Lib.getData(INPUT_PATH_2, "CustomField", 1, 4);
	String pickupList=Excel_Lib.getData(INPUT_PATH_2, "CustomField", 1, 5);
	String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CustomField", 1, 3));
	 actual[7]=ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
	 actual[8]=ctc.saveMultipleTestCaseEdit();
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
   
}

@Then("^multi selected test case should be edited$")
public void multi_selected_test_case_should_be_edited() throws Throwable {
    try
    {
    	for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
    	
	log.info("Multi Selected test case edited ");
	}
    catch(Exception e)
	{   lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
   
    
    
}


}

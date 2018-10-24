package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809352 extends LaunchBrowser 
{

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809352";
	
	boolean[] actual=new boolean[8];
	   SoftAssert soft=new SoftAssert();
	 
	   
	   @Given("^User is in the test Repository Page of Normal Project$")
	   public void user_is_in_the_test_Repository_Page_of_Normal_Project() throws Throwable {
		   try
			{
				bp=new BasePage();
			   pp=new ProjectPage(driver);
			   
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"EditPrerequisite",1,1);
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   tr=new TestRepositoryPage(driver);
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
	   
	   
	@When("^User create a node$")
	public void user_create_a_node() throws Throwable
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		
	  tr=new TestRepositoryPage(driver);
	  String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
	  String nodeDesc=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 1);
	  actual[0]=tr.doubleClickOnRelease(releaseName);
	  actual[1]=tr.addNode(nodeName, nodeDesc);
	  actual[2]=tr.doubleClickOnRelease(releaseName);
	  String[] phase=new String[1];
	   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
	   actual[3]=tr.navigateToNode(releaseName, phase);
	  
	  
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

	@When("^Add test case in the node$")
	public void add_test_case_in_the_node() throws Throwable {
		try
		{
			actual[4]=tr.addTestCase();
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

	@When("^navigate to test case detail page$")
	public void navigate_to_test_case_detail_page() throws Throwable 
	{
		try
		{
			actual[5]=tr.clickDetailButton();
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

	@When("^check automation script and enter Automat fields$")
	public void check_automation_script_and_enter_Automat_fields() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			String chk=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
		String scriptName=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
		String scriptId=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
		String scriptPath=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 5, 0);
	    ctc=new CreateTestCasePage(driver);
	    
	    actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(chk, scriptName, scriptId, scriptPath);
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

	@When("^make it manual by unchecked automation field$")
	public void make_it_manual_by_unchecked_automation_field() throws Throwable 
	{
		try
		{
			actual[7]=ctc.unselectAutomationField();
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

	@Then("^test case should be converted into manaual$")
	public void test_case_should_be_converted_into_manaual() throws Throwable {
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	   log.info("Test Case Converted into Manual");
	   
	   tr.clickOnList();
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

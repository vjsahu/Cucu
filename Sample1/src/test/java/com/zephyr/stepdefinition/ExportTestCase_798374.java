package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class ExportTestCase_798374 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	BasePage bp;
	 
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798374";
	@When("^User creates a phase ,system and subsystem$")
	public void user_creates_a_phase_system_and_subsystem() throws Throwable {
	  
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Export",1,11);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 6, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH_2, "Export", 6, 1);
		tr=new TestRepositoryPage(driver);
		
		 actual[0]=tr.doubleClickOnRelease(releaseName);   
		 bp.waitForElement();
		 actual[1]=tr.addNode(Name, Desc);
		 bp.waitForElement();
		 actual[2]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 
		 
		  
		  String [] phase1=new String[1];
		  phase1[0]=Name;
		  actual[3]=tr.navigateToNode(releaseName, phase1);
		  bp.waitForElement();
		  String Name2=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 0);
		  String Desc2=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 1);
		  actual[4]=tr.addNode(Name2, Desc2);
		  bp.waitForElement();
		  actual[5]=tr.doubleClickOnRelease(releaseName);
		  bp.waitForElement();
		   
		  
		  
		   String [] system=new String[2];
		   system[0]=Name;
		   system[1]=Name2;
		   actual[6]=tr.navigateToNode(releaseName, system);
		   bp.waitForElement();
		   String Name3=Excel_Lib.getData(INPUT_PATH_2, "Export", 8, 0);
		   String Desc3=Excel_Lib.getData(INPUT_PATH_2, "Export", 8, 1);
		   actual[7]=tr.addNode(Name3, Desc3);
		   bp.waitForElement();
		   bp.waitForElement();
//		   actual[8]=tr.doubleClickOnRelease(releaseName);
//		   bp.waitForElement();
		   tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
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

	@When("^navigate to the phase and add test cases$")
	public void navigate_to_the_phase_and_add_test_cases() throws Throwable {
		try
		{
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 6, 0);
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Export",1,11);
		
		String[] node=new String[2];
		node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 6, 0);
		node[1]=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 0);
		
		tr.navigateToNode(releaseName, node);
		  actual[8]=tr.selectPhase(Name);
		  actual[9]=tr.addTestCase();
		  actual[10]=tr.addTestCase();
		  actual[11]=tr.addTestCase();
		  actual[12]=tr.addTestCase();
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

	@When("^navigate to the system and subsystem$")
	public void navigate_to_the_system_and_subsystem() throws Throwable {
	  
		log.info("Navigated to system");
		
	}

	@When("^select the multiple test case from phase$")
	public void select_the_multiple_test_case_from_phase() throws Throwable {
	   try
	   {
		ep=new ExportPage(driver);
	   String[] testCase=new String[2];
		testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"Export",1,10));
		testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"Export",2,10));
		
		
		  actual[13]=ep.selectMultipleTestCaseFromGrid(testCase);
		  bp.waitForElement();
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

	@When("^move to the system/subsystem$")
	public void move_to_the_system_subsystem() throws Throwable {
		try
		{
		WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
		String sys=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 0);
		  actual[14]=tr.dragAndDropTestCase(ele, sys);
		  bp.waitForElement();
		  bp.waitForElement();
		  bp.waitForElement();
		}catch(Exception e)
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

	@When("^select multiple test case from test case grid$")
	public void select_multiple_test_case_from_test_case_grid() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Export",1,11);
			String[] node=new String[2];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 6, 0);
			node[1]=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 0);
		//String node=Excel_Lib.getData(INPUT_PATH_2, "Export", 7, 0);
		  actual[15]=tr.navigateToNode(releaseName, node);
		  bp.waitForElement();
		
		 ep=new ExportPage(driver);
		   String[] testCase=new String[2];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"Export",1,10));
			testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"Export",2,10));
			
			
			  actual[16]=ep.selectMultipleTestCaseFromGrid(testCase);
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

	@When("^export the test case$")
	public void export_the_test_case() throws Throwable {
		try
		{
			bp.waitForElement();
		  actual[17]=tr.exportTestCase();
		  bp.waitForElement();
		  bp.waitForElement();
		  actual[18]=ep.saveAndDownload();
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

	@Then("^selected test case should be exported$")
	public void selected_test_case_should_be_exported() throws Throwable {
		
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Export",1,11);
			tr.doubleClickOnRelease(releaseName);
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	System.out.println(actual[k]);
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
	}


}

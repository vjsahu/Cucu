package com.zephyr.stepdefinition;



import java.util.List;

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

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809300 extends LaunchBrowser 
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809300";
	
	boolean[] actual=new boolean[15];
	   SoftAssert soft=new SoftAssert();
	   
	@Given("^Uesr is in the test repository page$")
	public void uesr_is_in_the_test_repository_page() throws Throwable
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
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

	@When("^User select the phase and select test case$")
	public void user_select_the_phase_and_select_test_case() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		
		tr=new TestRepositoryPage(driver);
		tr.doubleClickOnRelease(releaseName);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		
		tr.addNode(name, desc);
		
		bp.waitForElement();
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		//tr.addTestCase();
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
//		tr=new TestRepositoryPage(driver);
		
		actual[3]=tr.navigateToNode(releaseName, phase);
		actual[4]=tr.addTestCase();
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

	@When("^edit the execution time$")
	public void edit_the_execution_time() throws Throwable {
	   try
	   {
		ctc=new CreateTestCasePage(driver);
	    String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase",2,14));
	    String hr=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase",2,15));
	    String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase",2,16));
	    actual[6]=ctc.enterEstimatedTime(day, hr,mn);
	    bp.waitForElement();
	    
	    actual[7]=tr.clickOnList();
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

	@Then("^execution time should be changed$")
	public void execution_time_should_be_changed() throws Throwable {
	    log.info("Execution time changed");
	}

	@When("^User select the system and select test case$")
	public void user_select_the_system_and_select_test_case() throws Throwable {
		
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1); 
		//actual[7]=tr.moveToNodesInDetail();
		actual[8]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
        //tr.moveToNodesInDetail();
		//Navigating to phase
		
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		tr=new TestRepositoryPage(driver);
		actual[9]=tr.navigateToNode(releaseName, phase);
		//bp.waitForElement();
		String name2=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,1);
		String desc2=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,1);
		tr.addNode(name2, desc2);
		
		bp.waitForElement();
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	
		
		String[] sys=new String[2];
		sys[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		sys[1]=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,1);
		tr.navigateToNode(releaseName, sys);
		
		tr.clickDetailButton();
		actual[10]=tr.addNewTestCaseInDetilview();
		//tr.clickDetailButton();
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

	@Then("^execution time should be modified$")
	public void execution_time_should_be_modified() throws Throwable {
		 log.info("Execution time Edited");
	}

	@When("^User select the subsystem and test case$")
	public void user_select_the_subsystem_and_test_case() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		//String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1); 
		//actual[11]=tr.moveToNodesInDetail();
		
		//Navigating to system
		actual[11]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] system=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		system[1]=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,1);
		//subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"Nodes",3,2);
		tr=new TestRepositoryPage(driver);
		actual[12]=tr.navigateToNode(releaseName, system);
		
		String name3=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,2);
		String desc3=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,2);
		actual[13]=tr.addNode(name3, desc3);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] subsystem=new String[3];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,0);
		subsystem[1]=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,1);
		subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"Nodes",13,2);
		
		tr.navigateToNode(releaseName, subsystem);
		
		
		tr.clickDetailButton();
		actual[14]=tr.addNewTestCaseInDetilview();
		
		//tr.selectTestCase(subsystem); 
		}catch(Exception e)
		{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

	@Then("^execution time should be edited$")
	public void execution_time_should_be_edited(DataTable arg1) throws Throwable 
	{
		try
		{
		List<List<String>> data = arg1.raw();
	      System.out.println(data.get(1).get(1)); 
	      
	      for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
		 log.info("Estimated time Edited successfully");
		 
		// tr.clickOnList();
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

package com.zephyr.stepdefinition;

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
import cucumber.api.java.en.When;

public class CreatePrerequisite extends LaunchBrowser
{

	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;

	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CreatePrerequisite";

@Given("^User select the project and select release$")
public void user_select_the_project_and_select_release() throws Throwable {
	try
	{
	bp=new BasePage();
	pp=new ProjectPage(driver);
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);
	pp.selectProject(projectName);
	pp.selectRelease(releaseName);
	
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
}

@When("^user naviagate to test repository page$")
public void user_naviagate_to_test_repository_page() throws Throwable {
	try
	{
	rp=new ReleasePage(driver);
	   rp.clickOnTestRep();
	   
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
		
}

@When("^double click on release$")
public void double_click_on_release() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);
	tr=new TestRepositoryPage(driver);
    tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
}

@When("^create a phase and navigate to phase and add test cases$")
public void create_a_phase_and_navigate_to_phase_and_add_test_cases() throws Throwable {
	try
	{
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	tr.addNode(phasename, desc);
	
	String[] node1=new String[1];
	node1[0]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);
	
	tr.navigateToNode(releaseName, node1);
	bp.waitForElement();
	for(int i=1;i<=5;i++)
	{
	tr.addTestCase();
	}
	bp.waitForElement();
	
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
}

@When("^read the test case Count$")
public void read_the_test_case_Count() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);
	tr.verifyPresentTestCase();
    tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
    
}

@When("^create a system  and navigate to system and add test cases$")
public void create_a_system_and_navigate_to_system_and_add_test_cases() throws Throwable {
	try
	{
	String[] node2=new String[2];
	 node2[0]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	//node2[1]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);;
	tr.navigateToNode(releaseName, node2);
	
	String phasename2=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	String desc2=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	tr.addNode(phasename2, desc2);
	
	
	
	bp.waitForElement();
	bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node3=new String[2];
	 node3[0]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	node3[1]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	
	tr.navigateToNode(releaseName, node2);
	
	
	for(int i=1;i<=5;i++)
	{
	tr.addTestCase();
	}
	bp.waitForElement();
	
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			
}
	
	


@When("^create subsystem and navigate to subsystem and add test cases$")
public void create_subsystem_and_navigate_to_subsystem_and_add_test_cases() throws Throwable
{
	try
	{
	String[] node4=new String[2];
	 node4[0]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	node4[1]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 1);;
	tr.navigateToNode(releaseName, node4);
	
	String phasename3=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 4);
	String desc3=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 4);
	tr.addNode(phasename3, desc3);
	
	
	
	bp.waitForElement();
	bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node5=new String[3];
	 node5[0]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 2);
	node5[1]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 3);
	node5[2]=Excel_Lib.getData(INPUT_PATH_2, "CreatePrerequisite", 1, 4);
	tr.navigateToNode(releaseName, node5);
	
	
	for(int i=1;i<=5;i++)
	{
	tr.addTestCase();
	}
	bp.waitForElement();
}
	


catch(Exception e)
{
	lb.getScreenShot(fileName);
	driver.close();
  	Relogin rl=new Relogin();
  	rl.reLogin();
  	throw e;
	 
			
}
}
}








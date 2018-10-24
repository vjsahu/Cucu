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



public class DNDPrecondition_2 extends LaunchBrowser {


	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DNDPrerequisite_2";
	
boolean[] actual=new boolean[23];
	
	SoftAssert soft=new SoftAssert();
	//LaunchBrowser lb=new LaunchBrowser();

@Given("^User is in test repository Page of Isolated Project$")
public void user_is_in_test_repository_Page_of_Isolated_Project() throws Throwable {
	try
	{
	bp=new BasePage();
	pp=new ProjectPage(driver);
	
	pp.clickOnLogout();
	lp=new LoginPage(driver);
	String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_5");
	String userPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_5");
	
	actual[0]=lp.enterUname(userName);
	actual[1]=lp.enterPass(userPass);
	actual[2]=lp.clickOnLogin();
	bp.waitForElement();
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Isolated_Project_2");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[3]=pp.selectProject(projectName);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	actual[4]=pp.selectRelease(releaseName);
	
	rp=new ReleasePage(driver);
	actual[5]=rp.clickOnTestRep();
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




@When("^User add a first node and add multiple testcases$")
public void user_add_a_first_node_and_add_multiple_testcases() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
		actual[6]=tr.clickOnRelease(releaseName);
		actual[7]=tr.addNode(phasename, desc);
		
		bp.waitForElement();
		
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
		
		
		
		actual[8]=tr.navigateToNode(releaseName, node1);
		
         bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[9]=tr.addTestCase();
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

@Then("^multiple test cases added successfully$")
public void multiple_test_cases_added_successfully() throws Throwable {
	try
	{
		actual[10]=tr.verifyPresentTestCase();
	
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



@When("^user creates a system under phase and add testcases$")
public void user_creates_a_system_under_phase_and_add_testcases() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);

	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[11]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
	actual[12]=tr.addNode(phasename, desc);
	bp.waitForElement();
	bp.waitForElement();
	
	actual[13]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[2];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
	actual[14]=tr.navigateToNode(releaseName, node11);
	
	bp.waitForElement();
	
	for(int i=1;i<=5;i++)
	{
		actual[15]=tr.addTestCase();
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

@Then("^test cases successfully added in system$")
public void test_cases_successfully_added_in_system() throws Throwable {
	try
	{
		actual[16]=tr.verifyPresentTestCase();
	
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

@When("^user creates a subsystem under system and add testcases$")
public void user_creates_a_subsystem_under_system_and_add_testcases() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
//	tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[17]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
	actual[18]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
	
   bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[19]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[3];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
	node11[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
	actual[20]=tr.navigateToNode(releaseName, node11);
	
   
	for(int i=1;i<=5;i++)
	{
		actual[21]=tr.addTestCase();
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

@Then("^test cases successfully added in subsystem$")
public void test_cases_successfully_added_in_subsystem() throws Throwable {
	try
	{
		actual[22]=tr.verifyPresentTestCase();
	
	for (int k = 0; k <= actual.length - 1; k++) {
		soft.assertEquals(actual[k], true);
		System.out.println(actual[k]);
	}
	soft.assertAll();

	
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

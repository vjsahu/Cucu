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

public class ExportTestCase_798063 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;

	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798063";
@Given("^User is in the test Repository Page$")
public void user_is_in_the_test_Repository_Page() throws Throwable 
{
//	   lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//	   
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
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

@When("^User Add a phase and add test cases in the phase$")
public void user_Add_a_phase_and_add_test_cases_in_the_phase() throws Throwable 
{
	try
	{
		bp=new BasePage();
	
		tr=new TestRepositoryPage(driver);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 1, 0);
    String phaseDesc=Excel_Lib.getData(INPUT_PATH_2,"NodeAdd", 1, 1);
    String[] node=new String[1];
    node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"NodeAdd" , 1, 0);
    actual[3]=tr.doubleClickOnRelease(releaseName);
	
    actual[4]=tr.addNode(phaseName, phaseDesc);
    bp.waitForElement();
    bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=node[0];
	tr.navigateToNode(releaseName, node1);
	
    actual[5]=tr.addTestCase();
    actual[6]=tr.addTestCase();
    actual[7]=tr.addTestCase();
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

@When("^navigate to search and search test cases$")
public void navigate_to_search_and_search_test_cases() throws Throwable 
{
	try
	{
	String searchText=Excel_Lib.getData(INPUT_PATH_2,"TestCaseNo", 1, 1);
	
    ep=new ExportPage(driver);
    actual[8]=ep.searchTestCases(searchText);
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

@When("^select few test cases and export$")
public void select_few_test_cases_and_export() throws Throwable {
	try
	{
	String[] str=new String[3];
	str[0]=Integer.toString((Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 0)));
	str[1]=Integer.toString((Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 0)));
	str[2]=Integer.toString((Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 3, 0)));
	
	actual[9]=ep.selectMultipleTestcasesfromSearch(str);
	actual[10]=ep.clickOnExportTab(); 
	actual[11]=ep.saveAndDownload();
	bp.waitForElement();
	tr.clickedOnFolder();
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

@Then("^selected test cases in search results should be exported$")
public void selected_test_cases_in_search_results_should_be_exported() throws Throwable 
{
    
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
	tr.doubleClickOnRelease(releaseName);
	
	
	for(int k=0;k<=actual.length-1;k++)
    {
    	soft.assertEquals(actual[k], true);
    }
	soft.assertAll();
	
	log.info("Test case exported from searched result");
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

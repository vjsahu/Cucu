package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DragAndDrop_808706 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	ImportPage ip;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DragAndDrop_808706";
   boolean[] actual=new boolean[9];
	
	SoftAssert soft=new SoftAssert();
	

@Given("^User is in the test Repository page of second release$")
public void user_is_in_the_test_Repository_page_of_second_release() throws Throwable {
	try
	{

//    
//		lb=new LaunchBrowser();
//   lb.preCond();
//   lp=new LoginPage(driver);
//   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",3,0);
//   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",3,1);
//   lp.enterUname(Uname);
//   lp.enterPass(Pass);
//   lp.clickOnLogin();
//
   pp=new ProjectPage(driver);
   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,1);
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



@When("^User select the imported node$")
public void user_select_the_imported_node() throws Throwable {
	try
	{
		bp=new BasePage();
	ip=new ImportPage(driver);
   // ImportPage_POM ipp=new ImportPage_POM(driver);
	Actions a1=new Actions(driver);
	
	a1.doubleClick(ip.Imported).perform();
	String fileName=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 9);
	actual[0]=ip.selectImportedFile(fileName);
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
	
  @Then("^test case count should be displayed$")
	public void test_case_count_should_be_displayed() throws Throwable 
	{
	  tr=new TestRepositoryPage(driver);
	  actual[1]=tr.verifyPresentTestCase();
	}


	


@When("^user navigate navigate to local phase$")
public void user_navigate_navigate_to_local_phase() throws Throwable {
   try
   {
	tr=new TestRepositoryPage(driver);
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 1);
	String[] phase=new String[1];
    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
    bp.waitForElement();
    actual[2]=tr.navigateToNode(releaseName, phase);
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

@When("^read the test case count$")
public void read_the_test_case_count() throws Throwable {
	try
	{
	actual[3]=tr.verifyPresentTestCase();
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

@When("^user navigate to local system$")
public void user_navigate_to_local_system() throws Throwable {
	try
	{
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 1);
		String[] system=new String[1];
		//system[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
		system[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 4);
		actual[4]=tr.navigateNode(system);
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

@When("^user navigate to local subsystem$")
public void user_navigate_to_local_subsystem() throws Throwable {
	try
	{
		//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 1);
	
	
		String[] subsystem=new String[1];
		//subsystem[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
		//subsystem[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 4);
		subsystem[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 5);
		actual[5]=tr.navigateNode(subsystem);
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

@When("^select the multiple test case from imported node$")
public void select_the_multiple_test_case_from_imported_node() throws Throwable {
    
 try
 {
	  bp=new BasePage();
//	    Actions a1=new Actions(driver);
//		
//		a1.doubleClick(ip.Imported).perform();
		bp.waitForElement();
		String fileName=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 9);
		actual[6]=ip.selectImportedFile(fileName);
		
	ep=new ExportPage(driver);
	String[] testcase=new String[2];
	testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 1, 6));
	testcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 2, 6));
	//testcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 3, 6));
	
	actual[7]=ep.selectMultipleTestCaseFromGrid(testcase);
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

@When("^copy the selected test case from imported node to local phase ,system and subsystem$")
public void copy_the_selected_test_case_from_imported_node_to_local_phase_system_and_subsystem() throws Throwable {
 try
 {
	 bp=new BasePage();
	WebElement ele=driver.findElement(By.xpath("//*[@id='grid-table-tcr']/div[2]/div[1]/div[4]/div/div"));
	
   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
   bp.waitForElement();
//   String system=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 4);
//   String subsystem=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 5);
   
  
   actual[8]= tr.copyTestCase(ele, phase);
  
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

@Then("^test case should be copied to the local phase,system and subsystem$")
public void test_case_should_be_copied_to_the_local_phase_system_and_subsystem() throws Throwable {
	try
	{
		
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
      log.info("Pass - test case copied sucessfully");
      driver.close();
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
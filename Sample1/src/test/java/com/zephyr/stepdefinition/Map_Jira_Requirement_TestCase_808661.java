package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_Jira_Requirement_TestCase_808661 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Map_Jira_Requirement_808661";

	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
@When("^User enters External DTS Login details$")
public void user_enters_External_DTS_Login_details() throws Throwable {
    try
    {
    	   String Username=Excel_Lib.getData(INPUT_PATH_3,"Login",1,3);
		    String Password=Excel_Lib.getData(INPUT_PATH_3,"Login",0,2);
			String ReenterPassword=Excel_Lib.getData(INPUT_PATH_3,"Login",1,2);
			req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			actual[0]=req.DTSLoginDetail(Username, Password, ReenterPassword);
			bp.waitForElement();
    }
    catch(Exception e)
	 {
    	lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
    	e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
}

@When("^User performs JQL query operation$")
public void user_performs_JQL_query_operation() throws Throwable {
    
	try
	{
		String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
		String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
		actual[1]=req.selectQuerry(selectQuerry, enterQuerry);
     
     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
	String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,9 );
	actual[2]=req.selectAccessTypeAndFolderName(accessType, folderName);
     req.clickjiraSearchButton.click();
	}
	catch(Exception e)
	{
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^User Imports the Jira requirements$")
public void user_Imports_the_Jira_requirements() throws Throwable {
    
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	String[] testCaseNo=new String[6];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    testCaseNo[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",4 ,4 ));
    testCaseNo[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",5 ,4 ));
    testCaseNo[5]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",6 ,4 ));
    actual[3]=req.selectMultipleTestCaseFromGrid(testCaseNo);
    bp.waitForElement();
	req.clickOnImportSelected.click();
	}
	catch(Exception e)
	{
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	
}

@Then("^User copys the Imported Jira requirements to Release node$")
public void user_copys_the_Imported_Jira_requirements_to_Release_node() throws Throwable {
    
	 try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",1,9);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
		    bp.waitForElement();
	    	//tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	 bp.waitForElement();
		 	actual[4]=tr.navigateToNode(ImportedName, fields);
	    	
		 	bp.waitForElement();
       		actual[5]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[6]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	actual[7]=tr.pasteNode();
		 	bp.waitForElement();
		 	
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    	driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
}

@Then("^User is in the testRepository$")
public void user_is_in_the_testRepository() throws Throwable {
    try
	{

			rp= new ReleasePage(driver);
			bp.waitForElement();
			bp.waitForElement();
		   actual[8]=rp.clickOnTestRep();
		   bp.waitForElement();
	}
	catch(Exception e)
    {
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		e.printStackTrace();
    driver.close();
     Relogin rl=new Relogin();
     rl.reLogin();
     throw e;
    }
}

@Given("^User creates a node under the release$")
public void user_creates_a_node_under_the_release() throws Throwable {
    
	try
    {
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 14, 0);
	String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 14, 3);
	
	tr=new TestRepositoryPage(driver);
	
	 actual[9]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	 bp.waitForElement();
	 actual[10]=tr.addNode(p_Name1,p_Desc1);
	 String[] phase= new String[1];
		//[0]=p_Name1;
		phase[0]=p_Name1;
		 bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName,phase );
		
    }
    catch(Exception e)
	 {
    	lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
    	e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
}

@When("^User create a test case$")
public void user_create_a_test_case() throws Throwable {
    
	try
	{
		bp.waitForElement();
		//tr=new TestRepositoryPage(driver);
	actual[11]=tr.addTestCase();
	}
	catch(Exception e)
	 {
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
}

@Then("^User Goto testcase details$")
public void user_Goto_testcase_details() throws Throwable {
 try
	{
	bp=new BasePage();
	bp.waitForElement();
	//tr=new TestRepositoryPage(driver);
	tr.clickDetailButton();
	}
 catch(Exception e)
 {
	 lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
	 e.printStackTrace();
  driver.close();
  Relogin rl=new Relogin();
  rl.reLogin();
  throw e;
 }
}

@Then("^User Maps Requirements to testcase$")
public void user_Maps_Requirements_to_testcase() throws Throwable {
 
	try
    {
	req=new RequirementsPage(driver);
	bp.waitForElement();
	actual[12]=req.MapRequirements();

    }
    catch(Exception e)
	 {
    	lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
    	e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
}

@Then("^User expands release node$")
public void user_expands_release_node() throws Throwable {
 try
	{
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	actual[13]=req.ExpandRelease(releaseName);
	}
 catch(Exception e)
 {
	 lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
	 e.printStackTrace();
  driver.close();
  Relogin rl=new Relogin();
  rl.reLogin();
  throw e;
 }
}

@Then("^User selects a node and save requirements$")
public void user_selects_a_node_and_save_requirements() throws Throwable {
    try
    {
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[14]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
   // driver.navigate().refresh();
    //bp.waitForElement();
    //bp.waitForElement();
    actual[15]=req.selectMultipleTestCaseFromGrids(testCaseNo);
    bp.waitForElement();
    bp.waitForElement();
    req.clickOnSavejirareq.click();
    bp.waitForElement();
	tr.clickOnList();
	bp.waitForElement();
    }
    catch(Exception e)
	 {
    	lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
    	e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
}

@Then("^User successfully maps requirements to testcase$")
public void user_successfully_maps_requirements_to_testcase() throws Throwable {
    try
    {
    	for(int k=0;k<=actual.length-1;k++)
        {
    		System.out.println(actual[k]);
         soft.assertEquals(actual[k], true);
        }
        soft.assertAll();
	log.info("User successfully maps requirements to testcase");
    }
    catch(Exception e)
	 {
    	lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
    	e.printStackTrace();
	  driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
    
}
	
}

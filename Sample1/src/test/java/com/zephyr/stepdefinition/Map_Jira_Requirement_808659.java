package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
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

public class Map_Jira_Requirement_808659 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Map_Jira_Requirement_808659";
	
	boolean[] actual=new boolean[21];
	 SoftAssert soft=new SoftAssert();
	 
	 @Given("^User is in the page of the Requirements page$")
	 public void user_is_in_the_page_of_the_Requirements_page() throws Throwable {
		 try
			{
				/*lb=new LaunchBrowser();
				   lb.preCond();
				   
				  // WebDriver driver = null;
				 lp=new LoginPage(driver);
				   
				 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
				 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();*/
				bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   bp.waitForElement();
			   
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
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

	 @Given("^User clicks on Import and chooses Import type to JIRA$")
	 public void user_clicks_on_Import_and_chooses_Import_type_to_JIRA() throws Throwable {
			try
		    {
		    	req=new RequirementsPage(driver);
		    	req.import_Requirement.click();
			String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
			actual[3]=req.chooseImportType(importTypeNum);
			
			String Username=Excel_Lib.getData(INPUT_PATH_3,"Login",1,3);
			 String Password=Excel_Lib.getData(INPUT_PATH_3,"Login",0,2);
				String ReenterPassword=Excel_Lib.getData(INPUT_PATH_3,"Login",1,2);
				
				req.username.sendKeys(Username);
		    	req.password.click();
		    	bp.waitForElement();
		    	req.password.sendKeys(Password);
		    	bp.waitForElement();
		    	//reEnterPassword.click();
		    	bp.waitForElement();
		    	req.reEnterPassword.sendKeys(ReenterPassword);
		    	bp.waitForElement();
		    	
		    	driver.findElement(By.xpath("(//*[@id='zee-import-modal-requirement-jira']//*[text()='Save'])[2]")).click();
		    	
//		    	req.update.click();
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

	 @When("^User enters External DTS Login detail$")
	 public void user_enters_External_DTS_Login_detail() throws Throwable {
	  try
	  {
		  String Username=Excel_Lib.getData(INPUT_PATH_3,"Login",1,3);
			 String Password=Excel_Lib.getData(INPUT_PATH_3,"Login",0,2);
				String ReenterPassword=Excel_Lib.getData(INPUT_PATH_3,"Login",1,2);
				req=new RequirementsPage(driver);
				bp=new BasePage();
				bp.waitForElement();
				actual[4]=req.DTSLoginDetail(Username, Password, ReenterPassword);
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

	 @When("^User performs JQL query operations$")
	 public void user_performs_JQL_query_operations() throws Throwable {
	     
		 try
			{
				String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
				String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
				actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
		     
		     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6,7 );
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",3 ,9 );
			actual[6]=req.selectAccessTypeAndFolderName(accessType, folderName);
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

	 @When("^User Imports the Jira Requirement$")
	 public void user_Imports_the_Jira_Requirement() throws Throwable {

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
		    actual[7]=req.selectMultipleTestCaseFromGrid(testCaseNo);
		    bp.waitForElement();
			req.clickOnImportSelected.click();
			bp.waitForElement();
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

	 @Then("^User copys the Imported Jira Requirements to Release node$")
	 public void user_copys_the_Imported_Jira_Requirements_to_Release_node() throws Throwable {
		 try
		    {
			  bp=new BasePage();
			String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",3,9);
			String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
			
			    tr=new TestRepositoryPage(driver);
		    	//tr.doubleClickOnRelease(ImportedName);
		    	String[] fields=new String[1];
			 	 fields[0]=fileName;
			 	 bp.waitForElement();
			 	 bp.waitForElement();
			 	actual[8]=tr.navigateToNode(ImportedName, fields);
		    	
			 	bp.waitForElement();
	       		actual[9]=tr.copyNode();
	       		bp.waitForElement();
				//ip.drag_action_1();
			  
			    bp.waitForElement();
				String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			 	actual[10]= tr.doubleClickOnRelease(releaseName1);
			 	bp.waitForElement();
			 	actual[11]=tr.pasteNode();
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

	 @Then("^User is in the page testRepository$")
	 public void user_is_in_the_page_testRepository() throws Throwable {
		 try
			{
			 rp= new ReleasePage(driver);
			 bp.waitForElement();
			 bp.waitForElement();
			actual[12]=rp.clickOnTestRep();
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
	 
	 @Given("^User creates a node the under release$")
	 public void user_creates_a_node_the_under_release() throws Throwable {
		 try
		 {
			 String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 18, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 18, 3);
			
			tr=new TestRepositoryPage(driver);
			String[] phase= new String[1];
			//[0]=p_Name1;
			phase[0]=p_Name1;
			 actual[13]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			 actual[14]=tr.addNode(p_Name1,p_Desc1);
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

	 @When("^User creates a test case under a node$")
	 public void user_creates_a_test_case_under_a_node() throws Throwable {
	     
		 try
			{
			 bp.waitForElement();
			 actual[15]=tr.addTestCase();
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

	 @Then("^User Go to testcase details$")
	 public void user_Go_to_testcase_details() throws Throwable {
	   try
	   {
		 bp.waitForElement();
		actual[16]= tr.clickOnDetails();
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

	 @Then("^User Maps the Requirements to testcase$")
	 public void user_Maps_the_Requirements_to_testcase() throws Throwable {
		 try
		    {
			req=new RequirementsPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[17]=req.MapRequirements();

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

	 @Then("^User expands the release node$")
	 public void user_expands_the_release_node() throws Throwable {
	     try
	     {
		 req=new RequirementsPage(driver);
		 tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			
			actual[18]=req.ExpandRelease(releaseName);
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

	 @Then("^User selects the node and save requirements to a testcase$")
	 public void user_selects_the_node_and_save_requirements_to_a_testcase() throws Throwable {
	  
		 try
		    {
				tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 3, 9);
			//actual[18]=tr.doubleClickOnRelease(phaseName);
			String[] fields=new String[1];
		 	 
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
		 	 bp.waitForElement();
		 	 actual[19]=tr.navigateToNode(phaseName, fields);
		 	 bp.waitForElement();
			String[] testCaseNo=new String[2];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    bp.waitForElement();
		    bp.waitForElement();
		    //bp.waitForElement();
		    //bp.waitForElement();
		    actual[20]=req.selectMultipleTestCaseFromGrids(testCaseNo);
		    bp.waitForElement();
		    bp.waitForElement();
		    //WebElement ele=req.clickOnSavejirareq;
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
	 
	 @Then("^User successfully Maps requirements to testcase$")
	 public void user_successfully_Maps_requirements_to_testcase() throws Throwable {
	     
		 try
		  {
			  for(int k=0;k<=actual.length-1;k++)
			     {
				  System.out.println(actual[k]);
			      soft.assertEquals(actual[k], true);
			     }
			     soft.assertAll();
			 log.info("User successfully map requirements to testcase");
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

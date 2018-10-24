package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UnMap_Jira_Requirement_808670 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	ExportPage ep;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ImportPage ip;
	String fileName="UnMap_Jira_Requirement_808670";
	
	boolean[] actual=new boolean[30];
	 SoftAssert soft=new SoftAssert();
	
	 @Given("^user is in the Requirements page$")
	 public void user_is_in_the_Requirements_page() throws Throwable {
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
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
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

	 @Given("^user clicks on Import and choose Import type to JIRA$")
	 public void user_clicks_on_Import_and_choose_Import_type_to_JIRA() throws Throwable {
		 try
		    {
		    	req=new RequirementsPage(driver);
		    	bp.waitForElement();
		    	req.import_Requirement.click();
		    	bp.waitForElement();
			String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
			actual[3]=req.chooseImportType(importTypeNum);
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

	 @When("^User enetrs external Login Details$")
	 public void user_enetrs_external_Login_Details() throws Throwable {
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

	 @When("^User performs import operation$")
	 public void user_performs_import_operation() throws Throwable {
		 try
			{
//				String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
//				actual[4]=req.chooseAccessType(accessType);
				String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
				String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
				actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
		     
		     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",8 ,9 );
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

	 @When("^User Imports Jira Requirements$")
	 public void user_Imports_Jira_Requirements() throws Throwable {
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

	 @When("^User Copying the imported jira requirement to release node$")
	 public void user_Copying_the_imported_jira_requirement_to_release_node() throws Throwable {
		 try
		    {
			//ip.ClickOKonStatusReport();
			String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",8,9);
			String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
			//ip=new ImportPage(driver);
			//ip.validateImport(fileName, releaseName);
			    tr=new TestRepositoryPage(driver);
			    bp.waitForElement();
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
			    bp=new BasePage();
			    bp.waitForElement();
				String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
				//String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 8, 0);
				//String[] fields1=new String[1];
			 	 //fields[0]=p_Name1;
			 	actual[10]= tr.doubleClickOnRelease(releaseName1);
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

	 @When("^User is in the page of the TestRePository page$")
	 public void user_is_in_the_page_of_the_TestRePository_page() throws Throwable {
	     try
	     {
	    	 bp.waitForElement();
	    	 rp=new ReleasePage(driver);
	    	 actual[12]=rp.clickOnTestRep();
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

	 @When("^User Creating a node$")
	 public void user_Creating_a_node() throws Throwable {
		 try
		   {
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 22, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 22, 3);
			actual[13]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[14]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			actual[15]=tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[16]=tr.navigateToNode(releaseName, phase);
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

	 @When("^User Adds a TestCase$")
	 public void user_Adds_a_TestCase() throws Throwable {
		 try
			{
			bp.waitForElement();	
			actual[17]=tr.addTestCase();
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
	 
	@Then("^User maps Jira requirements to a testcase$")
	public void user_maps_Jira_requirements_to_a_testcase() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	bp.waitForElement();
	    	req=new RequirementsPage(driver);
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	tr.clickDetailButton();
		actual[18]=req.MapRequirements();
    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
    	
    	bp.waitForElement();
    	actual[19]=req.ExpandRelease(releaseName);
    	bp.waitForElement();
    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
    	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 8, 9);
    	//actual[2]=tr.doubleClickOnRelease(phaseName);
    	String[] fields=new String[1];
	 	 
	 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
	 	 bp.waitForElement();
	 	 tr=new TestRepositoryPage(driver);
	 	 bp.waitForElement();
	 	 actual[20]=tr.navigateToNode(phaseName, fields);
	 	 
	 	String[] testCaseNo=new String[2];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    //ep= new ExportPage(driver);
	    actual[21]=tr.verifyPastTestCase();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[22]=req.selectMultipleTestCaseFromGrids(testCaseNo);
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[23]=tr.verifyPresentTestCase();
	    
	   // bp.waitForElement();
    	//req=new RequirementsPage(driver);
    	//bp.waitForElement();
    	//req.clickOnSavejirareq.click();	 
    	
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
	    
	    @When("^User click on the save$")
	    public void user_click_on_the_save() throws Throwable {
	    	try
		    {
		    	//RequirementsPage re1=new RequirementsPage(driver);
		    	bp.waitForElement();
		    	bp.waitForElement();
		    	req.clickOnSavejirareq.click();
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

	    @When("^User navigate again to map requirements$")
	    public void user_navigate_again_to_map_requirements() throws Throwable {

			try
		    {
				//RequirementsPage re1=new RequirementsPage(driver);
				bp.waitForElement();
				bp.waitForElement();
		    	actual[24]=req.MapRequirements();
		    	
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

	    @Then("^User Uncheck the selected requirements$")
	    public void user_Uncheck_the_selected_requirements() throws Throwable {
	    	 try
	    	 {
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	        	bp.waitForElement();
	        	actual[25]=req.ExpandRelease(releaseName);
	        	bp.waitForElement();
	        	bp.waitForElement();
	        	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 8, 9);
	        	String[] fields=new String[1];
	    	 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
	    	 	 
	    	 	 actual[26]=tr.navigateToNode(phaseName, fields);
	    	 	String[] testCaseNo=new String[2];
	    	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    	   // ep=new ExportPage(driver);
	    	    bp.waitForElement();
	    	    req=new RequirementsPage(driver);
	    	    bp.waitForElement();
	    	    actual[27]=tr.verifyPastTestCase();
	    	    bp.waitForElement();
	    	    actual[28]=req.selectMultipleTestCaseFromGrids(testCaseNo);
	    	    bp.waitForElement();
	    	    actual[29]=tr.verifyPresentTestCase();
	    		//tr.clickOnReleaseCheckBox.click();
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

}

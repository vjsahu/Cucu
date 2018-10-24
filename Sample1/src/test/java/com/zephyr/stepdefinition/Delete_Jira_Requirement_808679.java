package com.zephyr.stepdefinition;

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

public class Delete_Jira_Requirement_808679 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Delete_Jira_Requirement_808679";
	
	boolean[] actual=new boolean[19];
	 SoftAssert soft=new SoftAssert();
	@Given("^User is in the page of Requirements page$")
	public void user_is_in_the_page_of_Requirements_page() throws Throwable {
	    
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
		   bp.waitForElement();
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

	@Given("^User clicks on Import option and choose Import type to JIRA$")
	public void user_clicks_on_Import_option_and_choose_Import_type_to_JIRA() throws Throwable {
	    
		try
	    {
	    	req=new RequirementsPage(driver);
	    	bp=new BasePage();
	    	bp.waitForElement();
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		actual[3]=req.chooseImportType(importTypeNum);
		
		String Username=Excel_Lib.getData(INPUT_PATH_3,"Login",1,3);
		 String Password=Excel_Lib.getData(INPUT_PATH_3,"Login",0,2);
			String ReenterPassword=Excel_Lib.getData(INPUT_PATH_3,"Login",1,2);
			req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			actual[4]=req.DTSLoginDetail(Username, Password, ReenterPassword);
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

	@When("^User performs JQL operation on Import$")
	public void user_performs_JQL_operation_on_Import() throws Throwable {
	    
		try
		{
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			req.selectQuerry(selectQuerry, enterQuerry);
	     
			String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",10 ,9 );
			actual[5]=req.selectAccessTypeAndFolderName(accessType, folderName);
			req.clickjiraSearchButton.click();
	     
	     	bp=new BasePage();
			bp.waitForElement();
			String[] testCaseNo=new String[6];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    testCaseNo[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",4 ,4 ));
		    testCaseNo[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",5 ,4 ));
		    testCaseNo[5]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",6 ,4 ));
		    actual[6]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User copys the Imported folder to Release node$")
	public void user_copys_the_Imported_folder_to_Release_node() throws Throwable {
	    
		try
	    {
		//ip.ClickOKonStatusReport();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",10,9);
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
		 	actual[7]=tr.navigateToNode(ImportedName, fields);
	    	
		bp.waitForElement();
		actual[8]=tr.copyNode();
		bp.waitForElement();
			//ip.drag_action_1();
		    bp=new BasePage();
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[9]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	actual[10]=tr.pasteNode();
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

	@When("^User is in the testRepository page$")
	public void user_is_in_the_testRepository_page() throws Throwable {
	    
		try
		{

				rp= new ReleasePage(driver);
				bp.waitForElement();
				bp.waitForElement();
			   actual[11]=rp.clickOnTestRep();
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

	@Then("^User creates a node under release node$")
	public void user_creates_a_node_under_release_node() throws Throwable {
	    try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 19, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 19, 3);
		
		tr=new TestRepositoryPage(driver);
		
		 actual[12]=tr.doubleClickOnRelease(releaseName);
		 actual[13]=tr.addNode(p_Name1,p_Desc1);
		 String[] phase= new String[1];
			phase[0]=p_Name1;
			 actual[14]=tr.doubleClickOnRelease(releaseName);
			 //actual[14]=tr.addNode(p_Name1,p_Desc1);
			 bp.waitForElement();
				//tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				tr.navigateToNode(releaseName,phase);
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

	@Then("^User adds a test case$")
	public void user_adds_a_test_case() throws Throwable {
		try
		{
			bp.waitForElement();
		actual[14]=tr.addTestCase();
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

	@Given("^User maps requirements to testcase$")
	public void user_maps_requirements_to_testcase() throws Throwable {
	    try
	    {
		req=new RequirementsPage(driver);
		tr.clickDetailButton();
		actual[15]=req.MapRequirements();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
    	bp.waitForElement();
    	actual[16]=req.ExpandRelease(releaseName);
    	bp.waitForElement();
    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
    	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 10, 9);
    	//actual[18]=tr.doubleClickOnRelease(phaseName);
    	String[] fields=new String[1];
	 	 
	 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
	 	 
	 	 actual[17]=tr.navigateToNode(phaseName, fields);
		String[] testCaseNo=new String[2];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[18]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@When("^User navigates to a testcase contains jira requirements$")
	public void user_navigates_to_a_testcase_contains_jira_requirements() throws Throwable {
	   try
	   {
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		//tr.clickOnDetailView.click();
		bp.waitForElement();
		tr.verifyPastTestCase();
		bp.waitForElement();
		ep=new ExportPage(driver);
		String[] testCaseNo=new String[1];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		ep.selectMultipleTestCaseFromGrid(testCaseNo);
		bp.waitForElement();
		
		tr.deleteTestcase.click();
		
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

	@Then("^User deleted the testcase successfully$")
	public void user_deleted_the_testcase_successfully() throws Throwable {
	   try
	   {
		bp.waitForElement();
		tr.clicksDelete.click();
		bp.waitForElement();
		tr.verifyPresentTestCase();
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("User deleted the testcase successfully");
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

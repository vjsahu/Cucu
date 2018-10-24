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

public class UnMap_Jira_Requirement_808669 extends LaunchBrowser {


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
	String fileName="UnMap_Jira_Requirement_808669";
	
	boolean[] actual=new boolean[29];
	 SoftAssert soft=new SoftAssert();
	@Given("^User is in the Requirements page$")
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

	@Given("^User clicks on Import and choose Import type to JIRA$")
	public void user_clicks_on_Import_and_choose_Import_type_to_JIRA() throws Throwable {
	    try
	    {
	    	req=new RequirementsPage(driver);
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

	@Then("^User enters External DTS login details$")
	public void user_enters_External_DTS_login_details() throws Throwable {
		try
		  {
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

	@Then("^User performs some other operation$")
	public void user_performs_some_other_operation() throws Throwable {
		try
		{
//			String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
//			actual[4]=req.chooseAccessType(accessType);
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",7 ,9 );
	     actual[6]=req.selectAccessTypeAndFolderName(accessType, folderName);
	     req.clickjiraSearchButton.click();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^yet another action$")
	public void yet_another_action() throws Throwable {
		
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

	@Then("^some other action$")
	public void some_other_action() throws Throwable {
	    try
	    {
		//ip.ClickOKonStatusReport();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",7,9);
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
	    	driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Given("^User is in the page of the TestRepository page$")
	public void user_is_in_the_page_of_the_TestRepository_page() throws Throwable {
	   
		try
	    {
		bp.waitForElement();	
		actual[12]=rp.clickOnTestRep();
		bp.waitForElement();
		//tr=new TestRepositoryPage(driver);
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Map", 1, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 1, 3);
		actual[13]=tr.doubleClickOnRelease(releaseName);
		actual[14]=tr.addNode(p_Name1,p_Desc1);
		
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

	@Given("^User creating a node$")
	public void user_creating_a_node() throws Throwable {
	    
		 try
		   {
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 1, 1);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 1, 4);
			actual[16]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[17]=tr.addNode(s_Name1,s_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			String[] system=new String[1];
			system[0]=s_Name1;
			bp.waitForElement();
			tr.navigateToNode(releaseName, system);
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

	@When("^User adds a TestCase$")
	public void user_adds_a_TestCase() throws Throwable {
	    
		try
		{
		bp.waitForElement();	
		actual[18]=tr.addTestCase();
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

	@Then("^User maps Jira requirement to a testcase$")
	public void user_maps_Jira_requirement_to_a_testcase() throws Throwable {
	    
		try
	    {
			//RequirementsPage re1=new RequirementsPage(driver);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
	    	actual[19]=req.MapRequirements();
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	    	bp.waitForElement();
	    	actual[20]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	    	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 7, 9);
	    	//actual[18]=tr.doubleClickOnRelease(phaseName);
	    	String[] fields=new String[1];
		 	 
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
		 	 
		 	 actual[21]=tr.navigateToNode(phaseName, fields);
		 	 
		 	String[] testCaseNo=new String[2];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		   // ep=new ExportPage(driver);
		    bp.waitForElement();
		    req=new RequirementsPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[22]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User clicks on the save$")
	public void user_clicks_on_the_save() throws Throwable {
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

	@When("^User navigates again to map requirements$")
	public void user_navigates_again_to_map_requirements() throws Throwable {
	    
		try
	    {
			//RequirementsPage re1=new RequirementsPage(driver);
			bp.waitForElement();
			bp.waitForElement();
	    	actual[23]=req.MapRequirements();
	    	
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

	@Then("^uncheck the selected requirements$")
	public void uncheck_the_selected_requirements() throws Throwable {
	 try
	 {
		bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
    	bp.waitForElement();
    	actual[24]=req.ExpandRelease(releaseName);
    	bp.waitForElement();
    	bp.waitForElement();
    	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 7, 9);
    	String[] fields=new String[1];
	 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
	 	 
	 	 actual[25]=tr.navigateToNode(phaseName, fields);
	 	String[] testCaseNo=new String[2];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	   // ep=new ExportPage(driver);
	    bp.waitForElement();
	    req=new RequirementsPage(driver);
	    bp.waitForElement();
	    actual[26]=tr.verifyPastTestCase();
	    bp.waitForElement();
	    actual[27]=req.selectMultipleTestCaseFromGrids(testCaseNo);
	    bp.waitForElement();
	    actual[28]=tr.verifyPresentTestCase();
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

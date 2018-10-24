package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Map_Jira_Requirement_TCNames_808665 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	String fileName="Map_Jira_Requirement_TCNames_808665";
	
	boolean[] actual=new boolean[52];
	 SoftAssert soft=new SoftAssert();

@Given("^User is in page Requirements$")
public void user_is_in_page_Requirements() throws Throwable {
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

@Given("^User clicks on Import and selects Import type as JIRA$")
public void user_clicks_on_Import_and_selects_Import_type_as_JIRA() throws Throwable {
	try
    {
    	req=new RequirementsPage(driver);
    	bp.waitForElement();
    	req.import_Requirement.click();
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

@When("^User User enters external DTS login details$")
public void user_User_enters_external_DTS_login_details() throws Throwable {
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

@When("^User performs JQL operation on the Import$")
public void user_performs_JQL_operation_on_the_Import() throws Throwable {
	try
	{
		String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
		String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
		actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
     
     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
	String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",11 ,9 );
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

@When("^User then Imports the Jira requirements$")
public void user_then_Imports_the_Jira_requirements() throws Throwable {
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

@When("^User copying the Imported Jira requirements to release node$")
public void user_copying_the_Imported_Jira_requirements_to_release_node() throws Throwable {
	try
    {
		tr=new TestRepositoryPage(driver);
	  bp=new BasePage();
	String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",11,9);
	String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
	
	    
	    bp.waitForElement();
    	//actual[8]=tr.doubleClickOnRelease(ImportedName);
    	String[] fields=new String[1];
	 	 fields[0]=fileName;
	 	 actual[8]=bp.waitForElement();
	 	 //tr.doubleClickOnRelease(ImportedName);
	 	 bp.waitForElement();
	 	actual[9]=tr.navigateToNode(ImportedName, fields);
   		actual[10]=tr.copyNode();
   		bp.waitForElement();
		//ip.drag_action_1();
	  
	    bp.waitForElement();
		String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
	 	actual[11]= tr.doubleClickOnRelease(releaseName1);
	 	bp.waitForElement();
	 	actual[12]=tr.pasteNode();
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

@Then("^User is in testRepository$")
public void user_is_in_testRepository() throws Throwable {
	try
	{
		bp.waitForElement();
	 rp= new ReleasePage(driver);
		   actual[13]=rp.clickOnTestRep();
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

@Then("^User create a node under release$")
public void user_create_a_node_under_release() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 15, 0);
	String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 15, 3);
	
	tr=new TestRepositoryPage(driver);
	
	 actual[14]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	 bp.waitForElement();
	 actual[15]=tr.addNode(p_Name1,p_Desc1); 
	 
	 String[] phase=new String[1];
		phase[0]=p_Name1;
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.navigateToNode(releaseName, phase);
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

@Given("^User again creates a testcase under a node$")
public void user_again_creates_a_testcase_under_a_node() throws Throwable {
	try
	{
	 actual[16]=tr.addTestCase();
	 bp.waitForElement();
	 bp.waitForElement();
	 actual[17]= tr.clickOnDetails();
	 ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
	 ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	 
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

@When("^User go to details and performs mapping$")
public void user_go_to_details_and_performs_mapping() throws Throwable {
	 try
	    {
		 
		req=new RequirementsPage(driver);
		bp.waitForElement();
		actual[18]=req.MapRequirements();
		bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		bp.waitForElement();
		
		actual[19]=req.ExpandRelease(releaseName);
		
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
		//actual[18]=tr.doubleClickOnRelease(phaseName);
		String[] fields=new String[1];
	 	 
	 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
	 	 
	 	 actual[20]=tr.navigateToNode(phaseName, fields);
		String[] testCaseNo=new String[2];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    //WebDriverWait wait1 = new WebDriverWait(driver, 30);
	    //wait1.until(ExpectedConditions.elementToBeClickable(requirements));
	    actual[21]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@Then("^User maps requirement to testcase name which contains special characters$")
public void user_maps_requirement_to_testcase_name_which_contains_special_characters() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		//tr.doubleClickOnRelease(releaseName);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 9, 3);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		
		//tr=new TestRepositoryPage(driver);
		
		 //actual[14]=tr.doubleClickOnRelease(releaseName);
		 //actual[15]=tr.addNode(p_Name1,p_Desc1);  
		//tr.clickOnListView.click();
		//bp.waitForElement();
		tr.add_TestCase.click();
//		driver.navigate().refresh();
//		bp.waitForElement();
//		driver.navigate().refresh();
	//actual[23]=tr.clickOnDetails();
	
	ctc=new CreateTestCasePage(driver);
	bp.waitForElement();
	String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 10);
	//System.out.println(tcName);
	bp.waitForElement();
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 10);
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[22]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[23]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[24]=req.ExpandRelease(releaseName);
	
	//tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[25]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[26]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@When("^User maps Jira requirement to testcase name which contains non-English characters$")
public void user_maps_Jira_requirement_to_testcase_name_which_contains_non_English_characters() throws Throwable {
    
	try
	{
		//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		//tr.doubleClickOnRelease(releaseName);
		//bp.waitForElement();
		//tr.clickOnListView.click();
//		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 0);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		
		tr=new TestRepositoryPage(driver);
		
//		 actual[14]=tr.doubleClickOnRelease(releaseName);
		bp=new BasePage();
		bp.waitForElement();
//		 actual[15]=tr.addNode(p_Name1,p_Desc1);  
		tr.add_TestCase.click();
	bp.waitForElement();
	//driver.navigate().refresh();
	//actual[30]=tr.clickOnDetails();
	
		
	ctc=new CreateTestCasePage(driver);
	String tcName=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 11));
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 11);
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[27]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[28]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[29]=req.ExpandRelease(releaseName);
	
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[30]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
   // testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[31]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@When("^User maps Jira requirement to testcase name which contains numbers only$")
public void user_maps_Jira_requirement_to_testcase_name_which_contains_numbers_only() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		bp.waitForElement();
//		//tr.clickOnListView.click();
//		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 0);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
//		
		
//		
//		 actual[14]=tr.doubleClickOnRelease(releaseName);
//		 actual[15]=tr.addNode(p_Name1,p_Desc1);  
		//actual[36]=tr.addTestCase();
		tr.add_TestCase.click();
	bp.waitForElement();
	//driver.navigate().refresh();
	//actual[37]=tr.clickOnDetails();
	bp.waitForElement();
	ctc=new CreateTestCasePage(driver);
	String tcName=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 12));
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 12);
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[32]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[33]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[34]=req.ExpandRelease(releaseName);
	
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[35]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
   // testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[36]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@When("^User maps Jira requirement to testcase name which contains alphanumeric characters$")
public void user_maps_Jira_requirement_to_testcase_name_which_contains_alphanumeric_characters() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		//tr.clickOnListView.click();
//		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 0);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		
		
		
//		
		tr.add_TestCase.click();
	bp.waitForElement();
	//driver.navigate().refresh();
	//actual[44]=tr.clickOnDetails();
	//bp.waitForElement();
	//bp.waitForElement();
	bp.waitForElement();
	ctc=new CreateTestCasePage(driver);
	String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 13);
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 13);
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[37]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[38]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[39]=req.ExpandRelease(releaseName);
	
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[40]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[41]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@When("^User maps Jira requirement to testcase name which contains UPPERCASE$")
public void user_maps_Jira_requirement_to_testcase_name_which_contains_UPPERCASE() throws Throwable {
	try
	{
//		bp.waitForElement();
//		//tr.clickOnListView.click();
//		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 0);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		
//		 
		tr.add_TestCase.click();
	bp.waitForElement();
//	driver.navigate().refresh();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
	//actual[51]=tr.clickOnDetails();
		
	ctc=new CreateTestCasePage(driver);
	String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 14);
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 14);
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[42]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[43]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[44]=req.ExpandRelease(releaseName);
	
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[45]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[46]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@When("^User maps Jira requirement to testcase name which contain both alphanumeric and special chracters$")
public void user_maps_Jira_requirement_to_testcase_name_which_contain_both_alphanumeric_and_special_chracters() throws Throwable {
	try
	{
//		bp.waitForElement();
//		//tr.clickOnListView.click();
//		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 0);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
//		 actual[14]=tr.doubleClickOnRelease(releaseName);
//		 actual[15]=tr.addNode(p_Name1,p_Desc1);  
//		actual[57]=tr.addTestCase();
	bp.waitForElement();
	tr.add_TestCase.click();
	bp.waitForElement();
//	driver.navigate().refresh();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
	//actual[58]=tr.clickOnDetails();
	
	ctc=new CreateTestCasePage(driver);
	String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 15);
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 15);
	bp.waitForElement();
	bp.waitForElement();
	ctc.stepDetail.click();
	bp.waitForElement();
	actual[47]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
	bp.waitForElement();
	bp.waitForElement();
	actual[48]=req.MapRequirements();
	bp.waitForElement();
	bp.waitForElement();
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	bp.waitForElement();
	
	actual[49]=req.ExpandRelease(releaseName);
	
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 11, 9);
	//actual[18]=tr.doubleClickOnRelease(phaseName);
	String[] fields=new String[1];
 	 
 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
 	 
 	 actual[50]=tr.navigateToNode(phaseName, fields);
	String[] testCaseNo=new String[2];
    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[51]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

@Then("^User maps Jira requirement to different types of testcase names successfully$")
public void user_maps_Jira_requirement_to_different_types_of_testcase_names_successfully() throws Throwable {
	try
	  {
		  for(int k=0;k<=actual.length-1;k++)
		     {
			  System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     log.info("User maps Jira requirement to different types of testcase names successfully");
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

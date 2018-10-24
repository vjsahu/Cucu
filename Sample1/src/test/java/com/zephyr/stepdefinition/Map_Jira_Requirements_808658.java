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

public class Map_Jira_Requirements_808658 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Map_Jira_Requirement_808658";
	
	boolean[] actual=new boolean[86];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a Requirements page$")
	public void user_is_in_a_Requirements_page() throws Throwable {
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

	@Given("^User clicks on Import and selects Import type to an JIRA$")
	public void user_clicks_on_Import_and_selects_Import_type_to_an_JIRA() throws Throwable {
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

	@When("^User enters external DTS login details$")
	public void user_enters_external_DTS_login_details() throws Throwable {
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

	@When("^User performs JQL operation on an Import$")
	public void user_performs_JQL_operation_on_an_Import() throws Throwable {
		try
		{
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			bp.waitForElement();
			actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,10 );
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

	@When("^User Imports the Jira requirements of issue type Bug$")
	public void user_Imports_the_Jira_requirements_of_issue_type_Bug() throws Throwable {
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

	@Then("^User Imports the Jira requirements of issue type New Feature$")
	public void user_Imports_the_Jira_requirements_of_issue_type_New_Feature() throws Throwable {
		try
		{

	    	//req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		bp.waitForElement();
		actual[8]=req.chooseImportType(importTypeNum);
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			actual[9]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",2 ,10 );
		bp.waitForElement();
		actual[10]=req.selectAccessTypeAndFolderName(accessType, folderName);
		bp.waitForElement();
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
		    actual[11]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@Then("^User Imports the Jira requirements of issue type Task$")
	public void user_Imports_the_Jira_requirements_of_issue_type_Task() throws Throwable {
		try
		{
			bp.waitForElement();
			//req=new RequirementsPage(driver);
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		bp.waitForElement();
		actual[12]=req.chooseImportType(importTypeNum);
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			actual[13]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",3 ,10 );
		actual[14]=req.selectAccessTypeAndFolderName(accessType, folderName);
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
		    actual[15]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User Imports the Jira requirements of issue type Improvement$")
	public void user_Imports_the_Jira_requirements_of_issue_type_Improvement() throws Throwable {
		try
		{
			//req=new RequirementsPage(driver);
			bp.waitForElement();
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		bp.waitForElement();
		actual[16]=req.chooseImportType(importTypeNum);
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			actual[17]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",4 ,10 );
		actual[18]=req.selectAccessTypeAndFolderName(accessType, folderName);
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
		    actual[19]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User Imports the Jira requirements of issue type Test$")
	public void user_Imports_the_Jira_requirements_of_issue_type_Test() throws Throwable {
		try
		{
			//req=new RequirementsPage(driver);
			bp.waitForElement();
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		bp.waitForElement();
		actual[20]=req.chooseImportType(importTypeNum);
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			actual[21]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",5 ,10 );
		actual[22]=req.selectAccessTypeAndFolderName(accessType, folderName);
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
		    actual[23]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User Imports the Jira requirements of issue type Requirement$")
	public void user_Imports_the_Jira_requirements_of_issue_type_Requirement() throws Throwable {
		try
		{
			//req=new RequirementsPage(driver);
			bp.waitForElement();
	    	req.import_Requirement.click();
		String importTypeNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Import",1 ,5 ));
		bp.waitForElement();
		actual[24]=req.chooseImportType(importTypeNum);
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			bp.waitForElement();
			actual[25]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
		String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,10 );
		actual[26]=req.selectAccessTypeAndFolderName(accessType, folderName);
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
		    actual[27]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User copys the Imported Bug Jira requirements to an release node$")
	public void user_copys_the_Imported_Bug_Jira_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",1,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	//tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	actual[28]=tr.navigateToNode(ImportedName, fields);
	    	
		 	bp.waitForElement();
       		actual[29]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[30]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	bp.waitForElement();
		 	actual[31]=tr.pasteNode();
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

	@When("^User copys the Imported New Feature requirements to an release node$")
	public void user_copys_the_Imported_New_Feature_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",2,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	actual[32]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields1=new String[1];
		 	 fields1[0]=fileName;
		 	 bp.waitForElement();
		 	actual[33]=tr.navigateToNode(ImportedName, fields1);
	    	bp.waitForElement();
		 	bp.waitForElement();
       		actual[34]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[35]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
			bp.waitForElement();
		 	actual[36]=tr.pasteNode();
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

	@When("^User copys the Imported Task Jira requirements to an release node$")
	public void user_copys_the_Imported_Task_Jira_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",3,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	actual[37]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	 bp.waitForElement();
		 	actual[38]=tr.navigateToNode(ImportedName, fields);
			bp.waitForElement();
		 	bp.waitForElement();
       		actual[39]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[40]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
			bp.waitForElement();
		 	actual[41]=tr.pasteNode();
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

	@When("^User copys the Imported Improvement Jira requirements to an release node$")
	public void user_copys_the_Imported_Improvement_Jira_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",4,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	actual[42]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	actual[43]=tr.navigateToNode(ImportedName, fields);
			bp.waitForElement();
		 	bp.waitForElement();
       		actual[44]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[45]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	bp.waitForElement();
		 	actual[46]=tr.pasteNode();
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

	@When("^User copys the Imported Test Jira requirements to an release node$")
	public void user_copys_the_Imported_Test_Jira_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",5,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	actual[47]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	actual[48]=tr.navigateToNode(ImportedName, fields);
		 	bp.waitForElement();
		 	bp.waitForElement();
       		actual[49]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[50]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	bp.waitForElement();
		 	actual[51]=tr.pasteNode();
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

	@When("^User copys the Imported Requirement Jira requirements to an release node$")
	public void user_copys_the_Imported_Requirement_Jira_requirements_to_an_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",6,10);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	actual[52]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	actual[53]=tr.navigateToNode(ImportedName, fields);
		 	bp.waitForElement();
		 	bp.waitForElement();
       		actual[54]=tr.copyNode();
       		bp.waitForElement();
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[55]= tr.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	bp.waitForElement();
		 	actual[56]=tr.pasteNode();
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

	@Then("^User is in a testRepository page$")
	public void user_is_in_a_testRepository_page() throws Throwable {
		try
		{
		       rp= new ReleasePage(driver);
		       bp.waitForElement();
			   actual[57]=rp.clickOnTestRep();
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

	@When("^User creates a phase under an release$")
	public void user_creates_a_phase_under_an_release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 20, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 20, 3);
		
		tr=new TestRepositoryPage(driver);
		
		 actual[58]=tr.doubleClickOnRelease(releaseName);
		 actual[59]=tr.addNode(p_Name1,p_Desc1);
		 tr.doubleClickOnRelease(releaseName);
			String navigation[]=new String[1];
			navigation[0]=p_Name1;
			bp.waitForElement();
			tr.navigateToNode(releaseName, navigation);
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

	@When("^User creates a testcase under an release$")
	public void user_creates_a_testcase_under_an_release() throws Throwable {
		try
		{
		bp.waitForElement();	
		 actual[60]=tr.addTestCase();
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

	@When("^User go to testcase detail$")
	public void user_go_to_testcase_detail() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[61]= tr.clickOnDetails();
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

	@Then("^User maps the Jira requirements of issue type Bug to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_Bug_to_an_testcase() throws Throwable {
		 try
		    {
			req=new RequirementsPage(driver);
			bp.waitForElement();
			actual[62]=req.MapRequirements();
			 req=new RequirementsPage(driver);
				bp=new BasePage();
				bp.waitForElement();
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				bp.waitForElement();
				
				actual[63]=req.ExpandRelease(releaseName);
				
				tr=new TestRepositoryPage(driver);
				bp.waitForElement();
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
				String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
				//actual[18]=tr.doubleClickOnRelease(phaseName);
				String[] fields=new String[1];
			 	 
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
			 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
			 	 bp.waitForElement();
			 	 actual[64]=tr.navigateToNode(phaseName, fields);
				String[] testCaseNo=new String[2];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
			   // testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[65]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User maps the Jira requirements of issue type New Feature to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_New_Feature_to_an_testcase() throws Throwable {
		 try
		    {
			 //tr.clickOnListView.click();
			req=new RequirementsPage(driver);
			bp.waitForElement();
			actual[66]=req.MapRequirements();
			 req=new RequirementsPage(driver);
				bp=new BasePage();
				bp.waitForElement();
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				bp.waitForElement();
				
				actual[67]=req.ExpandRelease(releaseName);
				
				tr=new TestRepositoryPage(driver);
				bp.waitForElement();
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
				String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 10);
				//actual[18]=tr.doubleClickOnRelease(phaseName);
				String[] fields=new String[1];
			 	 
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
			 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
			 	 bp.waitForElement();
			 	 actual[68]=tr.navigateToNode(phaseName, fields);
				String[] testCaseNo=new String[2];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
			    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[69]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User maps the Jira requirements of issue type Task to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_Task_to_an_testcase() throws Throwable {
		 try
		    {
			req=new RequirementsPage(driver);
			bp.waitForElement();
			actual[70]=req.MapRequirements();
			 req=new RequirementsPage(driver);
				bp=new BasePage();
				bp.waitForElement();
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				bp.waitForElement();
				
				actual[71]=req.ExpandRelease(releaseName);
				
				tr=new TestRepositoryPage(driver);
				bp.waitForElement();
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
				String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 3, 10);
				//actual[18]=tr.doubleClickOnRelease(phaseName);
				String[] fields=new String[1];
			 	 
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
			 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
			 	 bp.waitForElement();
			 	bp.waitForElement();
			 	 actual[72]=tr.navigateToNode(phaseName, fields);
				String[] testCaseNo=new String[2];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
			    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[73]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User maps the Jira requirements of issue type Improvement to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_Improvement_to_an_testcase() throws Throwable {
		try
	    {
		req=new RequirementsPage(driver);
		bp.waitForElement();
		actual[74]=req.MapRequirements();
		 req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			
			actual[75]=req.ExpandRelease(releaseName);
			
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 10);
			//actual[18]=tr.doubleClickOnRelease(phaseName);
			String[] fields=new String[1];
		 	 
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
		 	 bp.waitForElement();
		 	bp.waitForElement();
		 	 actual[76]=tr.navigateToNode(phaseName, fields);
			String[] testCaseNo=new String[2];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[77]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User maps the Jira requirements of issue type Test to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_Test_to_an_testcase() throws Throwable {
		try
	    {
		req=new RequirementsPage(driver);
		bp.waitForElement();
		actual[78]=req.MapRequirements();
		 req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			
			actual[79]=req.ExpandRelease(releaseName);
			
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 5, 10);
			//actual[18]=tr.doubleClickOnRelease(phaseName);
			String[] fields=new String[1];
		 	 
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
		 	 bp.waitForElement();
		 	bp.waitForElement();
		 	 actual[80]=tr.navigateToNode(phaseName, fields);
			String[] testCaseNo=new String[2];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[81]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User maps the Jira requirements of issue type Requirement to an testcase$")
	public void user_maps_the_Jira_requirements_of_issue_type_Requirement_to_an_testcase() throws Throwable {
		try
	    {
		req=new RequirementsPage(driver);
		bp.waitForElement();
		actual[82]=req.MapRequirements();
		 req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			
			actual[83]=req.ExpandRelease(releaseName);
			
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import", 6, 10);
			//actual[18]=tr.doubleClickOnRelease(phaseName);
			String[] fields=new String[1];
		 	 
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		 	fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 10);
		 	 bp.waitForElement();
		 	bp.waitForElement();
		 	 actual[84]=tr.navigateToNode(phaseName, fields);
			String[] testCaseNo=new String[2];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    //req.remoteLink.getText();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    actual[85]=req.selectMultipleTestCaseFromGrids(testCaseNo);
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

	@Then("^User successfully maps Jira requirements of issue types to an testcase$")
	public void user_successfully_maps_Jira_requirements_of_issue_types_to_an_testcase() throws Throwable {
		try
		  {
			  for(int k=0;k<=actual.length-1;k++)
			     {
				  System.out.println(actual[k]);
			      soft.assertEquals(actual[k], true);
			     }
			     soft.assertAll();
			 log.info("User successfully maps Jira requirements of issue types to a testcases");
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

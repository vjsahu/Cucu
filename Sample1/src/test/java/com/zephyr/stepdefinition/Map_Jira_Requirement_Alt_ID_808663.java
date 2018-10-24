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

public class Map_Jira_Requirement_Alt_ID_808663 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Map_Jira_Requirement_Alt_ID_808663";
	
	boolean[] actual=new boolean[32];
	 SoftAssert soft=new SoftAssert();
	 @Given("^User is in the page of an Requirements page$")
	 public void user_is_in_the_page_of_an_Requirements_page() throws Throwable {
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
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_2");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			   bp.waitForElement();
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

	 @Given("^User clicks on the Import option and choose Import type to JIRA$")
	 public void user_clicks_on_the_Import_option_and_choose_Import_type_to_JIRA() throws Throwable {
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
	 
	 @When("^User enters external login detail$")
	 public void user_enters_external_login_detail() throws Throwable {
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

	 @When("^User performs JQL operation on an Importing Jira Requirements$")
	 public void user_performs_JQL_operation_on_an_Importing_Jira_Requirements() throws Throwable {
		 try
			{
			 bp.waitForElement();
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,6 );
			actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
		     
		     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",12 ,9 );
			actual[6]=req.selectAccessTypeAndFolderName(accessType, folderName);
		     req.clickjiraSearchButton.click();
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

	 @When("^User Imports the Jira Requirement under the Imported Folder$")
	 public void user_Imports_the_Jira_Requirement_under_the_Imported_Folder() throws Throwable {
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

	@When("^User copys the Imported folder to Global tree$")
	public void user_copys_the_Imported_folder_to_Global_tree() throws Throwable {
	   
		try
	    {
			rp=new ReleasePage(driver);
			bp.waitForElement();
			actual[8]=rp.clickOnTestRep();
			bp.waitForElement();
			
			 tr=new TestRepositoryPage(driver);
			bp=new BasePage();
		//ip.ClickOKonStatusReport();
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 3);
		/*WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(releaseName)));*/
			req=new RequirementsPage(driver);
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
		actual[9]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[10]=tr.addNode(p_Name1, p_Desc1);
		bp.waitForElement();
		String[] str=new String[1];
		str[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
		tr.navigateToNode(releaseName, str);
		actual[11]=tr.addTestCase();
		
		bp.waitForElement();
		rp=new ReleasePage(driver);
		actual[12]=rp.clickOnRequirements();
		bp.waitForElement();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",12,9);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		//ip=new ImportPage(driver);
		//ip.validateImport(fileName, releaseName);
		   bp.waitForElement();
		   req=new RequirementsPage(driver);
		   //tr.doubleClickOnRelease(releaseName);
	    	//tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	actual[13]=tr.navigateToNode(ImportedName, fields);
	    	
		 	bp.waitForElement();
		    actual[14]=tr.copyNode();
		    bp.waitForElement();
			//ip.drag_action_1();
		    bp=new BasePage();
		    bp.waitForElement();
			String globalName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",2,2);
		 	actual[15]= tr.clickOnRelease(globalName1);
		 	bp.waitForElement();
		 	actual[16]=tr.pasteNode();
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
	
	@When("^User allocates Imported folder to Release node$")
	public void user_allocates_Imported_folder_to_Release_node() throws Throwable {
	 
		try
		{
		    String releaseName2=Excel_Lib.getData(INPUT_PATH_3,"Releases",2,2);
		   // tr.doubleClickOnRelease(releaseName2);
			bp.waitForElement();
			String srcNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",12,9);//
			String destNode=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			String[] fields=new String[1];
		 	 fields[0]=srcNode;
		 	actual[17]=tr.navigateToNode(releaseName2, fields);
			req=new RequirementsPage(driver);
			bp.waitForElement();
			actual[18]=req.dragAndDropNode(srcNode, destNode);
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


	@Then("^User clones the Jira requirement$")
	public void user_clones_the_Jira_requirement() throws Throwable {
	    try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		//ip=new ImportPage(driver);
		//ip.validateImport(fileName, releaseName);
		    req=new RequirementsPage(driver);
	    	actual[19]=req.doubleClickOnRelease(releaseName);
	    	bp.waitForElement();
	    	String[] fields=new String[2];
		 	 fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",12,9);//
		 	fields[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,10);
		 	tr=new TestRepositoryPage(driver);
		 	tr.doubleClickOnRelease(releaseName);
		 	bp.waitForElement();
		 	actual[20]=tr.navigateToNode(releaseName, fields);
		 	bp.waitForElement();
		 	
		 	String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			bp.waitForElement();
			//bp.waitForElement();
			//req=new RequirementsPage(driver);
			actual[21]=req.selectRequirementsFromGrids(testCaseNo);
		 	bp.waitForElement();
		 	actual[22]=req.cloneRequirement();
		 	bp.waitForElement();
		 	String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			bp.waitForElement();
			req.selectRequirementsFromGrids(testCaseNo1);
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

	@Then("^User maps original Jira requirement to testcase$")
	public void user_maps_original_Jira_requirement_to_testcase() throws Throwable {
		try
		{
		bp.waitForElement();
		req=new RequirementsPage(driver);
		tr.clickDetailButton();
		actual[23]=req.MapTestCases();
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
    	bp.waitForElement();
    	actual[24]=req.ExpandRelease(releaseName);
    	bp.waitForElement();
		
    	String[] fields=new String[1];
	 	 
	 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
	 	//fields[1]=Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 9);
	 	 bp.waitForElement();
	 	 bp.waitForElement();
	 	 tr=new TestRepositoryPage(driver);
	 	 actual[25]=tr.navigateNode(fields);
	 	 bp.waitForElement();
    	
		String[] testCaseNo=new String[1];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		actual[26]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
		bp.waitForElement();
		req.clickOnSavejirareq.click();
		//String phaseName=Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 9);
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

	@Given("^User again maps the cloned Jira requirement to same testcase$")
	public void user_again_maps_the_cloned_Jira_requirement_to_same_testcase() throws Throwable {
	 try
	 {
		 bp.waitForElement();
		 req=new RequirementsPage(driver);
		bp.waitForElement();
		String[] testCaseNo=new String[2];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		bp.waitForElement();
		actual[27]=req.selectRequirementsFromGrids(testCaseNo);
		bp.waitForElement();
		
		bp.waitForElement();
		actual[28]=req.MapTestCases();
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
    	bp.waitForElement();
    	bp.waitForElement();
    	bp.waitForElement();
    	actual[29]=req.ExpandRelease(releaseName);
    	//String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
//    	bp.waitForElement();
//    	actual[17]=req.ExpandRelease(releaseName);
//    	bp.waitForElement();
    	//String phaseName=Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 9);
    	String[] fields1=new String[1];
	 	 
	 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	 	fields1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
	 	 bp.waitForElement();
	 	 bp.waitForElement();
	 	 bp.waitForElement();
	 	 //actual[30]=tr.navigateToNode(releaseName, fields1);//
	 	actual[30]=tr.navigateNode(fields1);
	 	bp.waitForElement();
	 	String[] testCaseNo1=new String[1];
		testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		req=new RequirementsPage(driver);
		//req.remoteLink.getText();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		actual[31]=req.mapTestCasesToRequirementsFromGrids(testCaseNo1);
		//bp.waitForElement();
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

	@Then("^User maps both original and cloned Jira requirement to the same testcase successfully$")
	public void user_maps_both_original_and_cloned_Jira_requirement_to_the_same_testcase_successfully() throws Throwable {
		try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
	    		System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     log.info("User maps both original and cloned Jira requirement to the same testcase successfully");
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
